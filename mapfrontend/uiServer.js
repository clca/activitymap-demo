// @flow
// author: irfan-ahmed Thu, 09/28/2017

const express = require('express');
const path = require('path');
const app = express();
const mapRoutes = require('./router/mapRoutes');

app.use('/map', express.static(path.join(__dirname, 'build')));
app.use('/map', mapRoutes);

app.listen(3000);
