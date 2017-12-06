# GithubstatsApi.HealthcheckApi

All URIs are relative to *http://polls.apiblueprint.org*

Method | HTTP request | Description
------------- | ------------- | -------------
[**githubstatsStatusGet**](HealthcheckApi.md#githubstatsStatusGet) | **GET** /githubstats/status | Retrieve Service&#39;s liveness


<a name="githubstatsStatusGet"></a>
# **githubstatsStatusGet**
> githubstatsStatusGet()

Retrieve Service&#39;s liveness



### Example
```javascript
var GithubstatsApi = require('githubstats_api');

var apiInstance = new GithubstatsApi.HealthcheckApi();

var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
};
apiInstance.githubstatsStatusGet(callback);
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

