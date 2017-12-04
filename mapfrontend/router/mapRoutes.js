// author: irfan-ahmed Sat, 09/30/2017

const express = require('express');
const router = express.Router();
const axios = require('axios');
const path = require('path');

const debug = process.env.DEBUG_ENABLED;
const service = 'http://githubstats:9000/githubstats';
const statsService = `${service}/stats`;
const historyService = `${service}/history`;


const handleError = error => {
  let json = {
    code: error.code,
    response: error.response,
  };

  if (error.response) {
    json.error = error.response;
    json.status = error.response.status;
    json.message = error.response.statusText;
  }

  return json;
};

router.use((req, res, next) => {
  if (debug) {
    console.log(new Date().toLocaleString(), req.originalUrl);
  }
  next();
});

var GithubstatsApi = require('../githubstats-api-v2');
var client = GithubstatsApi.Configuration.createApiClient();
var api = new GithubstatsApi.HealthcheckApi(client);

router.get('/githubstatus', function(req, res) {

  var callback = function(error, data, response) {
    if (error) {
      res.send("there was an error");
      console.error(error);
    } else {
      res.send(data);
      console.log('API called successfully.');
    }
  };
  api.githubstatsStatusGet(callback);
  
});

router.get('/stats', function(req, res) {
  axios
    .get(statsService)
    .then(response => {
      res.json(response.data);
    })
    .catch(e => {
      console.log('Error getting: ', req.originalUrl, e.code, e.statusText);
      res.status(500).json({ error: handleError(e) });
    });
});

router.get('/history/:from/:to', (req, res) => {
  const { from, to } = req.params;
  if (!from || !to) {
    return res.json([]);
  }
  axios
    .get(`${historyService}?from=${from}&to=${to}`)
    .then(response => {
      res.json(response.data);
    })
    .catch(e => {
      console.log('Error getting: ', req.originalUrl, e.code, e.statusText);
      res.status(500).json({ error: handleError(e) });
    });
});

router.get('/info', (req, res) => {
  const env = process.env;
  res.json({
    version: env.VERSION ? env.VERSION : 'V2',
    debug,
    production: env.NODE_ENV === 'production',
  });
});

module.exports = router;
