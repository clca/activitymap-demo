// @flow
// author: irfan-ahmed Thu, 09/28/2017

const express = require('express');
const path = require('path');
const app = express();
const mapRoutes = require('./router/mapRoutes');

app.use('/map', express.static(path.join(__dirname, 'build')));
app.use('/map', mapRoutes);

var GithubstatsApi = require('./githubstats-api-v2');
var client = GithubstatsApi.Configuration.createApiClient();
var api = new GithubstatsApi.HealthcheckApi(client);

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
api.githubstatsStatusGet(callback);

console.log("Listening on 3000 ....")
app.listen(3000);
