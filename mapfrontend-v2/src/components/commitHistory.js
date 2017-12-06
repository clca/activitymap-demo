// author: irfan-ahmed Fri, 09/29/2017

import React, { Component } from 'react';
import './commitHistory.css';
import axios from 'axios';

const sec = 1000;
const min = 60 * sec;
const hour = 60 * min;
const day = 24 * hour;
const week = 7 * day;

const HISTORY_URL = '/map/history';

const getTicks = (start, end, step) => {
  if (!step) {
    step = day;
  }

  let ticks = [];
  const range = start - end;
  if (range < day) {
    return [start];
  }

  const numTicks = parseInt(range / step, 10);
  for (let i = 0; i < numTicks; i++) {
    const tick = start - i * step;
    if (tick > end) {
      ticks.push(tick);
    } else {
      break;
    }
  }

  return ticks;
};

const getFormattedDate = date => {
  let day = date.getDate();
  let year = date.getFullYear();
  let month = date.getMonth() + 1;
  // format yyyy-mm-dd;
  return `${year}-${month < 10 ? 0 : ''}${month}-${day < 10 ? 0 : ''}${day}`;
};

const END_TIME = week;
const STEP_TIME = day / 2;

class CommitHistory extends Component {
  static defaultProps = {
    layout: 'vertical',
  };

  constructor(props) {
    super(props);
    this.fetching = false;
    this.start = new Date().getTime();
    this.end = this.start - END_TIME;
    this.step = STEP_TIME;
    this.ticks = getTicks(this.start, this.end, this.step);
    this.state = {
      data: [],
      current: this.start,
      currentStatus: 'Slide to a date/time to view historical data.',
    };
    console.log('CommitHistory.Constructor', this.start, this.end, this.ticks);
  }

  componentDidMount() {
    this.fetchData();
  }

  fetchData = () => {
    const fromDate = getFormattedDate(new Date(this.end));
    const toDate = getFormattedDate(new Date(this.start));
    if (this.fetching) {
      console.warn('Previous fetch still pending...');
      return;
    }

    this.fetching = true;
    axios
      .get(`${HISTORY_URL}/${fromDate}/${toDate}`)
      .then(({ data }) => {
        console.log('Got Data', data.length, data[0]);
        data.sort((a, b) => {
          const t1 = new Date(a.timestamp).getTime();
          const t2 = new Date(b.timestamp).getTime();
          return t2 - t1;
        });
        this.setState({ data });
        this.fetching = false;
      })
      .catch(e => {
        console.log('Error in data', e);
        this.fetching = false;
      });
  };

  onChange = e => {
    const current = parseInt(e.target.value, 10);
    let backup = current - this.step;
    const { data } = this.state;
    const stats = data.filter(stat => {
      const time = new Date(stat.timestamp);
      return time >= backup && time <= current;
    });

    let currentStatus = `Showing data at ${new Date(current).toLocaleString()}`;
    if (!stats.length) {
      currentStatus = `No data available at ${new Date(
        current
      ).toLocaleString()}`;
    }

    if (current === this.start) {
      currentStatus = 'Slide to a date/time to view historical data.';
    }

    this.setState({
      current,
      currentStatus,
    });

    // resume polling as user has moved to start pos
    if (current === this.start) {
      return this.props.onResumePolling();
    }

    // lets stop polling;
    this.props.onStopPolling();

    if (stats.length) {
      this.props.onHistory(stats[0].stats);
    }
  };

  componentWillReceiveProps(nextProps) {
    const { data } = this.state;
    if (data.length === 0) {
      this.fetchData();
    }
  }

  render() {
    const start = new Date(this.start);
    const end = new Date(this.end);
    const { current, currentStatus } = this.state;

    return (
      <div className="history">
        <div className="info">
          <div>
            {start.toLocaleString()}
            <span className="dimText">(From)</span>
          </div>
          <div>
            <span>{end.toLocaleString()}</span>
            <span className="dimText">(To)</span>
          </div>
          <div>
            <span>{new Date(current).toLocaleString()}</span>
            <span className="dimText">(Slider)</span>
          </div>
        </div>

        <div className="slider-wrapper">
          <input
            type="range"
            min={end.getTime()}
            max={start.getTime()}
            step={-hour}
            list="tickmarks"
            onChange={this.onChange}
            value={current}
            orient="vertical"
          />
          <datalist id="tickmarks">
            {this.ticks.map((tick, index) => {
              return <option key={tick} value={tick} />;
            })}
          </datalist>
        </div>
        <div className="status">
          <div className="dimText">{currentStatus}</div>
        </div>
      </div>
    );
  }
}

CommitHistory.displayName = 'CommitHistory';
export default CommitHistory;
