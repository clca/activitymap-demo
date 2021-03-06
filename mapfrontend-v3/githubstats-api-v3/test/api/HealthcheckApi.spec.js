/**
 * githubstats API
 * ## Version [V2]  Generate Github statistics on:  * number of commits  * number of stars  * Aggregated activity  for GitHub projects aggregated by US States
 *
 * OpenAPI spec version: 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.2.3
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.GithubstatsApi);
  }
}(this, function(expect, GithubstatsApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new GithubstatsApi.HealthcheckApi();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('HealthcheckApi', function() {
    describe('githubstatsStatusGet', function() {
      it('should call githubstatsStatusGet successfully', function(done) {
        //uncomment below and update the code to test githubstatsStatusGet
        //instance.githubstatsStatusGet(function(error) {
        //  if (error) throw error;
        //expect().to.be();
        //});
        done();
      });
    });
  });

}));
