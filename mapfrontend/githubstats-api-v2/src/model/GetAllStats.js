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
    // AMD. Register as an anonymous module.
    define(['ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.GithubstatsApi) {
      root.GithubstatsApi = {};
    }
    root.GithubstatsApi.GetAllStats = factory(root.GithubstatsApi.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The GetAllStats model module.
   * @module model/GetAllStats
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>GetAllStats</code>.
   * @alias module:model/GetAllStats
   * @class
   */
  var exports = function() {
    var _this = this;

  };

  /**
   * Constructs a <code>GetAllStats</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/GetAllStats} obj Optional instance to populate.
   * @return {module:model/GetAllStats} The populated <code>GetAllStats</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

    }
    return obj;
  }




  return exports;
}));

