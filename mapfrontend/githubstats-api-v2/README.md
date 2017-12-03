# githubstats_api

GithubstatsApi - JavaScript client for githubstats_api

- API version: 
- Package version: 1.0.0

## Installation

### For [Node.js](https://nodejs.org/)

#### npm

To publish the library as a [npm](https://www.npmjs.com/),
please follow the procedure in ["Publishing npm packages"](https://docs.npmjs.com/getting-started/publishing-npm-packages).

Then install it via:

```shell
npm install githubstats_api --save
```

##### Local development

To use the library locally without publishing to a remote npm registry, first install the dependencies by changing
into the directory containing `package.json` (and this README). Let's call this `JAVASCRIPT_CLIENT_DIR`. Then run:

```shell
npm install
```

Next, [link](https://docs.npmjs.com/cli/link) it globally in npm with the following, also from `JAVASCRIPT_CLIENT_DIR`:

```shell
npm link
```

Finally, switch to the directory you want to use your githubstats_api from, and run:

```shell
npm link /path/to/<JAVASCRIPT_CLIENT_DIR>
```

You should now be able to `require('githubstats_api')` in javascript files from the directory you ran the last
command above from.

#### git
#
If the library is hosted at a git repository, e.g.
https://github.com/YOUR_USERNAME/githubstats_api
then install it via:

```shell
    npm install YOUR_USERNAME/githubstats_api --save
```

### For browser

The library also works in the browser environment via npm and [browserify](http://browserify.org/). After following
the above steps with Node.js and installing browserify with `npm install -g browserify`,
perform the following (assuming *main.js* is your entry file, that's to say your javascript file where you actually
use this library):

```shell
browserify main.js > bundle.js
```

Then include *bundle.js* in the HTML pages.

### Webpack Configuration

Using Webpack you may encounter the following error: "Module not found: Error:
Cannot resolve module", most certainly you should disable AMD loader. Add/merge
the following section to your webpack config:

```javascript
module: {
  rules: [
    {
      parser: {
        amd: false
      }
    }
  ]
}
```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following JS code:

```javascript
var GithubstatsApi = require('githubstats_api');
var client = GithubstatsApi.Configuration.createApiClient();
var api = new GithubstatsApi.HealthcheckApi(client);

// call operation

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
api.githubstatsStatusGet(callback);

```

## Documentation for API Configuration
The API client can be configured using the `Configuration` object.
The configuration object set the URL connection `<protocol>://<host>:<port>/<base.path.prefix>/base.path/` based on the following properties:

Property Name | Meaning | Default value
------------ | ------------
protocol | Supported protocol scheme: http or https | `schemes` from Open API (swagger) definition or `http` if not defined
host | name of the host where the API implementation is hosted | `host` from Open API (swagger) definition or `localhost` if not defined
port | port in an uri scheme where the API implementation listens | port in `host` from Open API (swagger) definition or none (default to 80) if not defined
base.path.prefix | Optional prefix that is prepandable to `base.path` variable | None
base.path | `/basePath` variable defined by Open API Specification | `basePath` from Open API (swagger) definition
root.url | Overrides `<protocol>://<host>:<port>/<base.path.prefix>` from the URL | None
base.url | Overrides complete URL | None
user | user to be provided in the uri scheme, for future use | TBD
password | password to be provided in the uri scheme, for future use | TBD
token | possible token authentication, for future use | TBD

The properties are read from sources located base on a given instance name (default is aura-javascript-client) in the following priority order (the higher the priority the higher in the list):

Property source| Default location | Example
------------ | ------------ | ------------
Environment variables|AURA_JAVASCRIPT_CLIENT_<VARIABLE_UPPER_CASE>|AURA_JAVASCRIPT_CLIENT_HOST
JSON file | /etc/aura/apiclient/default/aura-javascript-client/connection.json | { "host" : "localhost" , "port" : 8080 }
Property file | /etc/aura/apiclient/default/aura-javascript-client/connection.properties | host=localhost
Property file| /etc/aura/apiclient/default/aura-javascript-client/host | localhost

For environment variables, any non alphanumeric symbol in the instance name is replaced by underscore `_`, and the result is upper-cased. Currently, a property defined in lower priority source is merged with a property defined in the higher priority source, making a single property override to the default settings. This allows for redefining only one property such as `host` and use defaults for the rest.

The default instance name can be overridden by an argument passed to the `Configuration.createApiClient` factory method. For instance, for using name `MyInstanceName`:
```
var GithubstatsApi = require('githubstats_api');
var client = GithubstatsApi.Configuration.createApiClient('MyInstanceName');
```
The `connection.json` property file then would be located at `/etc/aura/apiclient/default/MyInstanceName/connection.json`

### Discovery Service

If there is no configuration (i.e. no related environment varibales, JSON or property files),
the client will use discovery service to find the target service to call.

The client will it will perform `GET http://aura-api-catalog:8080/v1/apis/7a916729-b5e7-45f3-ba35-d041d39a0d1b/api-binding`
HTTP request by default to discover which target service it will call.
The URL can be changed using `API_DISCOVERY_SERVICE_URL` and `API_ID_OVERRIDE` environment variables,
the URL is constructed as follows:

```
${API_DISCOVERY_SERVICE_URL}/v1/apis/${API_ID_OVERRIDE}/api-binding
```

The response is expected to be a JSON object in the following form:

```
{
    "service": {
        "host": "example.org",
        "port": 8080,
        "headers": {
          "extra-header-name": "extra-header-value"
        }
    },
    "message": "Optional message"
}
```

The connection information is stored under `service` object.
The `service` object may define the same set of properties as defined above
and one additional property: `headers`.
The `headers` object defines additional request headers that will be added to each service call.

Service discovery results are cached for 5 minutes by default. It can be changed using
`API_DISCOVERY_EXPIRATION` environment variable by setting another cache expiration timeout
in miliseconds. The default value is 300000.

Whenever there is an error in the target service response, discovery cached is cleared and re-discovery is attempted.
If the new discovery response provides different information than the cached one then new target service is called.

## Documentation for API Endpoints

All URIs are relative to *http://polls.apiblueprint.org*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*GithubstatsApi.HealthcheckApi* | [**githubstatsStatusGet**](docs/HealthcheckApi.md#githubstatsStatusGet) | **GET** /githubstats/status | Retrieve Service&#39;s liveness
*GithubstatsApi.StatsApi* | [**githubstatusStatsGet**](docs/StatsApi.md#githubstatusStatsGet) | **GET** /githubstatus/stats | Retrieve all Stats
*GithubstatsApi.StatsApi* | [**statsUsStateGet**](docs/StatsApi.md#statsUsStateGet) | **GET** /stats/{usState} | Retrieve Stats for a State


## Documentation for Models

 - [GithubstatsApi.GetAllStats](docs/GetAllStats.md)
 - [GithubstatsApi.GetStatsByState](docs/GetStatsByState.md)
 - [GithubstatsApi.Status](docs/Status.md)


## Documentation for Authorization

 All endpoints do not require authorization.

