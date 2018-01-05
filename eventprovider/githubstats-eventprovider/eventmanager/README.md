# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) 2.2.0 or later to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

```

## Documentation for API Endpoints

All URIs are relative to *http://polls.apiblueprint.org*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------


## Documentation for Tracing
Tracing is done with request headers in each request. In order to propagate tracing information,
related request headers should be extracted from incoming request and passed to outgoing.

This can be done with either, automatically - providing a Supplier into API client, supplying this information
on every request, or manually extracting tracing headers with HeaderUtil and than passing them into invokeAPI call.

Example #1

```java
 client = new (() ->
HeaderUtil.extractTracingHeaders(getIncomingRequestHeaders());
```

Note that `getIncominRequestHeaders` method needs to be implemented in client code.
It is not provided as part of the client library because it depends on server environment.

## Documentation for Configuration

Consider for example, client configured as follows:

```

```

The client will by default use discovery service at `http://aura-api-catalog:8080` to find the target URL to connect to.
Use API_DISCOVERY_SERVICE_URL environment variable to change the discovery service URL.
See _Service Discovery_ section for more details.

To avoid discovery service call, you can configure the client using `/etc/aura/apiclient/default/eventmanager/connection.json` file, example:

```
{
  "host": "example.org",
  "port": 8080
}
```

More file types supported and values can be overridden using environment variables.
For description of all the configuration options please see javdoc of `io.swagger.client.Configuration` class.

### Service Discovery

Unless the client is configured otherwise, it will perform `GET http://aura-api-catalog:8080/v1/apis/5245089f-a56e-4f94-8a80-9e0e787f8dc6/api-binding`
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
The `service` object may define the same set of properties as `connection.json` document
(see see javdoc of `io.swagger.client.Configuration` class for more details)
and one additional property: `headers`.
The `headers` object defines additional request headers that will be added to each service call.

Service discovery results are cached for 5 minutes by default. It can be changed using
`API_DISCOVERY_EXPIRATION` environment variable by setting another cache expiration timeout
in miliseconds. The default value is 300000.

Whenever there is an error in the target service response, discovery cached is cleared and re-discovery is attempted.
If the new discovery response provides different information than the cached one then new target service is called.

## Documentation for Models

 - [EventManagerResource](docs/EventManagerResource.md)
 - [EventProviderResource](docs/EventProviderResource.md)
 - [GetASpecificEventProvider](docs/GetASpecificEventProvider.md)
 - [SendingMessages](docs/SendingMessages.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author


