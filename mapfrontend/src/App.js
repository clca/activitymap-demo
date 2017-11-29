import React, { Component } from 'react';
import './App.css';
import {
  ComposableMap,
  Annotation,
  Geographies,
  Geography,
  ZoomableGroup,
} from 'react-simple-maps';
import { geoAlbers, geoCentroid } from 'd3-geo';
import { scaleLinear } from 'd3-scale';
import fetch from 'isomorphic-fetch';
import axios from 'axios';
import * as topojson from 'topojson-client';
import 'systema-base.css/base.css';
import Tile from './tile';
import CommitHistory from './components/commitHistory';

const STATS_SERVER = '/map/stats';
const INFO_URL = '/map/info';

const WIDTH = 1080;
const HEIGHT = 580;
const FREQUENCY = 3000; //ms

const colorScale = scaleLinear()
  .domain([0, 5000, 100000])
  .range(['#fafafa', '#FFC107', '#E65100']);

class ProjectJavaMap extends Component {
  constructor(props) {
    super(props);
    this.poller = null;
    this.fetching = false;
    this.state = {
      geoPaths: [],
      clickedGeo: {},
      stats: {},
      version: 'V2',
      debug: false,
    };
    this.annotations = [];
  }

  projection(width, height) {
    const proj = geoAlbers()
      .rotate([96, 0])
      .center([-0.6, 38.7])
      .parallels([29.5, 45.5])
      .scale(1200)
      .translate([width / 2, height / 2])
      .precision(0.1);
    return proj;
  }

  createAnnotations = centroids => {
    this.annotations = centroids.map(state => {
      const { code, centroid } = state.properties;
      let dx = 0,
        dy = 0;
      switch (code) {
        case 'CT':
          dx = 20;
          dy = 40;
          break;
        case 'DE':
          dx = 30;
          dy = 30;
          break;
        case 'MD':
          dx = 38;
          dy = 50;
          state.properties.centroid = [centroid[0], centroid[1]];
          break;
        case 'DC':
          dx = 32;
          dy = 70;
          state.properties.numCommits = 100000;
          break;
        case 'RI':
          dx = 40;
          dy = 35;
          break;
        case 'FL':
          state.properties.centroid = [-81.75, 28];
          break;
        case 'MI':
          state.properties.centroid = [centroid[0] + 0.5, centroid[1] - 1];
          break;
        default:
          break;
      }
      return (
        <Annotation
          dx={dx}
          dy={dy}
          subject={state.properties.centroid}
          stroke="#999"
          strokeWidth={1}
          key={state.id}
        >
          <text
            className="stateName"
            onClick={() => {
              this.handleStateClick(state);
            }}
          >
            {state.properties.code}
          </text>
        </Annotation>
      );
    });
  };

  componentDidMount() {
    // get the info from server to show/hide features.
    axios
      .get(INFO_URL)
      .then(({ data }) => {
        console.log('Features: ', data);
        this.setState({
          ...data,
        });
      })
      .catch(e => {
        console.error('Error in getting features', e);
      });

    // get data for the map
    fetch('/map/data/us-with-data.json')
      .then(res => {
        if (!res.ok) {
          throw new Error('Error getting data: ' + res.statusText);
        }
        return res.json();
      })
      .then(data => {
        // get the states
        const states = topojson.feature(data, data.objects.states).features;

        // create the county boundaries
        const countyMesh = topojson.mesh(data, data.objects.counties, function(
          a,
          b
        ) {
          return a !== b;
        });

        // get the center points for each state to set the name tags
        const centroids = states.map(path => ({
          ...path,
          properties: {
            ...path.properties,
            centroid: geoCentroid(path),
          },
        }));

        // create the state names
        this.createAnnotations(centroids);

        this.setState({
          states,
          geoPaths: [...states, countyMesh],
        });

        // start the poller to get the latest stats
        this.startPolling();
      });
  }

  startPolling = () => {
    this.stopPolling();
    this.poller = setInterval(() => {
      this.updateGeo();
    }, FREQUENCY);
    this.updateGeo();
    console.log('Starting Poller', this.poller);
  };

  stopPolling = () => {
    console.log('Stopping Polling', this.poller);
    clearInterval(this.poller);
  };

  updateGeo = () => {
    // get the latest stats
    if (this.fetching) {
      console.warn('Still fetching stats...');
      return;
    }

    this.fetching = true;
    fetch(STATS_SERVER)
      .then(res => {
        this.fetching = false;
        if (!res.ok) {
          throw new Error(res);
        }
        return res.json();
      })
      .then(stateData => {
        this.fetching = false;
        this.setData(stateData);
      })
      .catch(e => {
        this.fetching = false;
        console.error('Error getting response ', e);
      });
  };

  setData = stateData => {
    // convert stats to id based
    const stats = {};
    stateData.stats.forEach(stat => {
      stats[stat.state] = stat;
    });

    // check if a geo has been clicked and update its stats
    let { clickedGeo } = this.state;
    if (clickedGeo) {
      const updatedStats = stats[clickedGeo.code];
      clickedGeo = {
        ...clickedGeo,
        ...updatedStats,
      };
    }

    // set the latest stats in state so that the geography can pick it up and show it
    this.setState({ stats, clickedGeo });
  };

  componentWillUnmount() {
    // stop the poller
    this.stopPolling();
  }

  /**
   * Function to return a state with the latest commit stats
   * @param geography
   * @param projection
   * @returns <Geography>
   */
  getState(geography, projection) {
    const { name, code } = geography.properties;

    // check if stats are available
    const stats = this.state.stats[code] || {};
    const { numCommits = 0, numStars = 0, numEvents = 0 } = stats;

    // create the color based on the number of commits
    const color = colorScale(numCommits);

    return (
      <Geography
        key={`geography-${code}-${numCommits}-${numStars}-${numEvents}`}
        geography={geography}
        projection={projection}
        className="state"
        data-tip={`${name} (${code}) - Commits: ${numCommits}`}
        onClick={this.handleStateClick}
        style={{
          default: {
            fill: color,
          },
          hover: {
            fill: color,
          },
          pressed: {
            strokeWidth: '1.5px',
            stroke: '#697f98',
          },
        }}
      />
    );
  }

  /**
   * function called to create a county boundary
   * @param geography
   * @param projection
   * @returns {XML}
   */
  getCounty(geography, projection) {
    return (
      <Geography
        key={`geography-${geography.id}`}
        geography={geography}
        projection={projection}
        className="county"
        onClick={this.handleStateClick}
      />
    );
  }

  /**
   * A function that updates the UI with data for the state on which user clicked
   * @param geo
   * @param e
   */
  handleStateClick = (geo, e) => {
    if (!geo || !geo.properties || !geo.properties.code) {
      // this happens when the user clicks on boundaries
      return;
    }

    // get the information for the state
    const { code } = geo.properties;

    // get the stats from the state
    const { numCommits = 0, numStars = 0, numEvents = 0 } =
      this.state.stats[code] || {};
    const clickedGeo = {
      ...geo.properties,
      numCommits,
      numStars,
      numEvents,
    };

    // show the stats
    this.setState({
      clickedGeo,
    });
  };

  showHistoricalData = stats => {
    // stop polling
    this.stopPolling();

    // show the data
    this.setData(stats);
  };

  render() {
    // get information for the current clicked state (if any)
    const {
      code,
      name,
      numCommits,
      numStars,
      numEvents,
    } = this.state.clickedGeo;

    const { version } = this.state;

    return (
      <div className="container">
        <div className="mapContainer" style={{ width: `${WIDTH}px` }}>
          <div className="header">
            <h1>Project Java - Commits, Stars and Events</h1>
          </div>
          <div className="map" style={{ width: '100%', height: 'auto' }}>
            <ComposableMap
              style={{ width: '100%', height: 'auto' }}
              width={WIDTH}
              height={HEIGHT}
              projectionConfig={{
                scale: 1300,
                rotate: [96, 0],
                parallels: [29.5, 45.5],
                precision: 0.1,
              }}
            >
              <ZoomableGroup
                disablePanning={true}
                width={WIDTH}
                height={HEIGHT}
                center={[-95, 37]}
              >
                {[
                  <Geographies
                    key="geos"
                    geographyPaths={this.state.geoPaths}
                    disableOptimization={true}
                  >
                    {(geographies, projection) =>
                      geographies.map((geography, i) => {
                        return geography.type === 'Feature'
                          ? this.getState(geography, projection)
                          : this.getCounty(geography, projection);
                      })}
                  </Geographies>,
                  ...this.annotations,
                ]}
              </ZoomableGroup>
            </ComposableMap>
          </div>
          {code ? (
            <div className="dataContainer">
              <Tile label={'State'} value={name} />
              <Tile label={'Commits'} value={numCommits} />
              <Tile label={'Stars'} value={numStars} />
              <Tile label={'Events'} value={numEvents} />
            </div>
          ) : (
            <div className={'inlineHelp'}>
              Click on a state to view more information.
            </div>
          )}
        </div>
        <div className="actionsContainer" style={{ height: `${HEIGHT}px` }}>
          {version === 'V3' && (
            <CommitHistory
              onHistory={this.showHistoricalData}
              onResumePolling={this.startPolling}
              onStopPolling={this.stopPolling}
            />
          )}
        </div>
      </div>
    );
  }
}

export default ProjectJavaMap;
