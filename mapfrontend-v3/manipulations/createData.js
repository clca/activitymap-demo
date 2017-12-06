// @flow
// author: irfan-ahmed Fri, 09/22/2017
const fs = require("fs");
const topojson = require("topojson-client");

const us = require("../public/data/us.json");
const counties = require("../public/data/county.topo.json");
const stateNames = require("./us-state-names.json");

// update counties with data
const countPropsById = {};
const countyFeatures = topojson.feature(counties, counties.objects.county).features;
countyFeatures.forEach(county => {
  countPropsById[ parseInt(county.id) ] = county;
});

const modifiedCounties = us.objects.counties.geometries.map((county, index) => {
  let { id } = county;
  const props = countPropsById[ id ];
  if (props) {
    const modifiedCounty = Object.assign({}, county, {
      properties: Object.assign({}, county.properties, props.properties, {
        county: true
      })
    });
    return modifiedCounty;
  }
  return county;
});

// update states based on id with properties such as name and commit stats
const statePropsById = {};
stateNames.forEach(state => {
  const { code, name } = state;
  statePropsById[ parseInt(state.id) ] = Object.assign({}, state, {
    properties: {
      code,
      name
    }
  })
});

// update the states with there name and code and initialize stats
const modifiedStates = us.objects.states.geometries.map((state, index) => {
  const stateProps = statePropsById[ state.id ] || {};
  const modifiedState = Object.assign({}, state, {
    properties: Object.assign({}, state.properties, stateProps.properties, {
      numCommits: 0,
      numStars: 0,
      numEvents: 0
    })
  });
  return modifiedState;
});

us.objects.counties.geometries = modifiedCounties;
us.objects.states.geometries = modifiedStates;

// write the modified topojson file
var date = new Date().toLocaleString().replace(/ |:/g, "_");
const fileName = `us-with-data-${date}.json`.replace(/-/g, "_");
fs.writeFile(fileName, JSON.stringify(us), (err) => {
  if (err) {
    throw err;
  }
  console.log("File Saved: ", fileName);
});


