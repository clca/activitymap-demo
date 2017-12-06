# GithubstatsApi.StatsApi

All URIs are relative to *http://polls.apiblueprint.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**githubstatsStatsGet**](StatsApi.md#githubstatsStatsGet) | **GET** /githubstats/stats | Retrieve all Stats
[**statsUsStateGet**](StatsApi.md#statsUsStateGet) | **GET** /stats/{usState} | Retrieve Stats for a State


<a name="githubstatsStatsGet"></a>
# **githubstatsStatsGet**
> githubstatsStatsGet()

Retrieve all Stats



### Example
```javascript
var GithubstatsApi = require('githubstats_api');

var apiInstance = new GithubstatsApi.StatsApi();

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
apiInstance.githubstatsStatsGet(callback);
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="statsUsStateGet"></a>
# **statsUsStateGet**
> statsUsStateGet(usState)

Retrieve Stats for a State



### Example
```javascript
var GithubstatsApi = require('githubstats_api');

var apiInstance = new GithubstatsApi.StatsApi();

var usState = "usState_example"; // String | Two-letter code for the US State (ex. CA, WA, HI, ...)


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
apiInstance.statsUsStateGet(usState, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **usState** | **String**| Two-letter code for the US State (ex. CA, WA, HI, ...) | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

