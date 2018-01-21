package io.swagger.client;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
//import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.swagger.client.Pair;
import io.swagger.client.ServiceDiscoveryClient.ConnectionInfo;
import io.swagger.client.ServiceDiscoveryClient.DiscoveryException;
import io.swagger.client.auth.Authentication;
import io.swagger.client.auth.HttpBasicAuth;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.auth.OAuth;

@javax.annotation.Generated(value = "com.oracle.aura.clientgen.template.java.Generator", date = "2017-12-07T15:11:31.765Z")
public class ApiClient {

  private final String name;

  private Map<String, String> defaultHeaderMap = new HashMap<String, String>();
  private final Function<Boolean, ConnectionInfo> connectionInfoProvider;

  private boolean debugging = false;
  private int connectionTimeout = 0;

  private Client httpClient;
  private JSON json;
  private String tempFolderPath = null;

  private Map<String, Authentication> authentications;

  private int statusCode;
  private Map<String, List<String>> responseHeaders;

  private DateFormat dateFormat;

  private Supplier<Stream<Pair>> requestHeadersSupplier;

  /**
   * Creates default instance.
   */
  public ApiClient() {
    this("eventmanager",
        (f) -> new ServiceDiscoveryClient.ConnectionInfo("http://polls.apiblueprint.org", Collections.emptyMap()));
  }

  /**
   * Creates instance.
   * @param name configuration name
   * @param connectionInfoProvider provider of connection info
   *                               takes one argument (Boolean) which indicates whether to force
   *                               flushing caches (if any)
   */
  public ApiClient(String name, Function<Boolean, ConnectionInfo> connectionInfoProvider) {
    this.name = name;
    this.json = new JSON();
    this.httpClient = buildHttpClient(debugging);
    this.connectionInfoProvider = connectionInfoProvider;

    this.dateFormat = new RFC3339DateFormat();

    // Set default User-Agent.
    setUserAgent("Swagger-Codegen/1.0.0/java");

    // Setup authentications (key: authentication name, value: authentication).
    this.authentications = new HashMap<String, Authentication>();
    // Prevent the authentications from being modified.
    this.authentications = Collections.unmodifiableMap(authentications);
  }

  /**
   * Gets instance name.
   * @return instance name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the JSON instance to do JSON serialization and deserialization.
   * @return JSON
   */
  public JSON getJSON() {
    return json;
  }

  public Client getHttpClient() {
    return httpClient;
  }

  public ApiClient setHttpClient(Client httpClient) {
    this.httpClient = httpClient;
    return this;
  }

  /**
   * Gets the status code of the previous request
   * @return Status code
   */
  public int getStatusCode() {
    return statusCode;
  }

  /**
   * Gets the response headers of the previous request
   * @return Response headers
   */
  public Map<String, List<String>> getResponseHeaders() {
    return responseHeaders;
  }

  /**
   * Get authentications (key: authentication name, value: authentication).
   * @return Map of authentication object
   */
  public Map<String, Authentication> getAuthentications() {
    return authentications;
  }

  /**
   * Get authentication for the given name.
   *
   * @param authName The authentication name
   * @return The authentication, null if not found
   */
  public Authentication getAuthentication(String authName) {
    return authentications.get(authName);
  }

  /**
   * Helper method to set username for the first HTTP basic authentication.
   * @param username Username
   */
  public void setUsername(String username) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setUsername(username);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set password for the first HTTP basic authentication.
   * @param password Password
   */
  public void setPassword(String password) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof HttpBasicAuth) {
        ((HttpBasicAuth) auth).setPassword(password);
        return;
      }
    }
    throw new RuntimeException("No HTTP basic authentication configured!");
  }

  /**
   * Helper method to set API key value for the first API key authentication.
   * @param apiKey API key
   */
  public void setApiKey(String apiKey) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKey(apiKey);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set API key prefix for the first API key authentication.
   * @param apiKeyPrefix API key prefix
   */
  public void setApiKeyPrefix(String apiKeyPrefix) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof ApiKeyAuth) {
        ((ApiKeyAuth) auth).setApiKeyPrefix(apiKeyPrefix);
        return;
      }
    }
    throw new RuntimeException("No API key authentication configured!");
  }

  /**
   * Helper method to set access token for the first OAuth2 authentication.
   * @param accessToken Access token
   */
  public void setAccessToken(String accessToken) {
    for (Authentication auth : authentications.values()) {
      if (auth instanceof OAuth) {
        ((OAuth) auth).setAccessToken(accessToken);
        return;
      }
    }
    throw new RuntimeException("No OAuth2 authentication configured!");
  }

  /**
   * Set the User-Agent header's value (by adding to the default header map).
   * @param userAgent Http user agent
   * @return API client
   */
  public ApiClient setUserAgent(String userAgent) {
    addDefaultHeader("User-Agent", userAgent);
    return this;
  }

  /**
   * Set supplier of request headers.
   *
   * <p>
   * The supplier is called with each request to provide headers for that request.
   * </p>
   *
   * @param requestHeadersSupplier provides headers as stream of pairs
   * @return API client
   */
  public ApiClient setRequestHeadersSupplier(Supplier<Stream<Pair>> requestHeadersSupplier) {
    this.requestHeadersSupplier = requestHeadersSupplier;
    return this;
  }

  /**
   * Get supplier of request headers.
   *
   * @return supplier of request headers (may be {@code null})
   */
  public Supplier<Stream<Pair>> getRequestHeadersSupplier() {
    return this.requestHeadersSupplier;
  }

  /**
   * Add a default header.
   *
   * @param key The header's key
   * @param value The header's value
   * @return API client
   */
  public ApiClient addDefaultHeader(String key, String value) {
    defaultHeaderMap.put(key, value);
    return this;
  }

  /**
   * Check that whether debugging is enabled for this API client.
   * @return True if debugging is switched on
   */
  public boolean isDebugging() {
    return debugging;
  }

  /**
   * Enable/disable debugging for this API client.
   *
   * @param debugging To enable (true) or disable (false) debugging
   * @return API client
   */
  public ApiClient setDebugging(boolean debugging) {
    this.debugging = debugging;
    // Rebuild HTTP Client according to the new "debugging" value.
    this.httpClient = buildHttpClient(debugging);
    return this;
  }

  /**
   * The path of temporary folder used to store downloaded files from endpoints
   * with file response. The default value is <code>null</code>, i.e. using
   * the system's default tempopary folder.
   *
   * @return Temp folder path
   */
  public String getTempFolderPath() {
    return tempFolderPath;
  }

  /**
   * Set temp folder path
   * @param tempFolderPath Temp folder path
   * @return API client
   */
  public ApiClient setTempFolderPath(String tempFolderPath) {
    this.tempFolderPath = tempFolderPath;
    return this;
  }

  /**
   * Connect timeout (in milliseconds).
   * @return Connection timeout
   */
  public int getConnectTimeout() {
    return connectionTimeout;
  }

  /**
   * Set the connect timeout (in milliseconds).
   * A value of 0 means no timeout, otherwise values must be between 1 and
   * {@link Integer#MAX_VALUE}.
   * @param connectionTimeout Connection timeout in milliseconds
   * @return API client
   */
  public ApiClient setConnectTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
    httpClient.property(ClientProperties.CONNECT_TIMEOUT, connectionTimeout);
    return this;
  }

  /**
   * Get the date format used to parse/format date parameters.
   * @return Date format
   */
  public DateFormat getDateFormat() {
    return dateFormat;
  }

  /**
   * Set the date format used to parse/format date parameters.
   * @param dateFormat Date format
   * @return API client
   */
  public ApiClient setDateFormat(DateFormat dateFormat) {
    this.dateFormat = dateFormat;
    // also set the date format for model (de)serialization with Date properties
    this.json.setDateFormat((DateFormat) dateFormat.clone());
    return this;
  }

  /**
   * Parse the given string into Date object.
   * @param str String
   * @return Date
   */
  public Date parseDate(String str) {
    try {
      return dateFormat.parse(str);
    } catch (java.text.ParseException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Format the given Date object into string.
   * @param date Date
   * @return Date in string format
   */
  public String formatDate(Date date) {
    return dateFormat.format(date);
  }

  /**
   * Format the given parameter object into string.
   * @param param Object
   * @return Object in string format
   */
  public String parameterToString(Object param) {
    if (param == null) {
      return "";
    } else if (param instanceof Date) {
      return formatDate((Date) param);
    } else if (param instanceof Collection) {
      StringBuilder b = new StringBuilder();
      for(Object o : (Collection)param) {
        if(b.length() > 0) {
          b.append(',');
        }
        b.append(String.valueOf(o));
      }
      return b.toString();
    } else {
      return String.valueOf(param);
    }
  }

  /*
   * Format to {@code Pair} objects.
   * @param collectionFormat Collection format
   * @param name Name
   * @param value Value
   * @return List of pairs
   */
  public List<Pair> parameterToPairs(String collectionFormat, String name, Object value){
    List<Pair> params = new ArrayList<Pair>();

    // preconditions
    if (name == null || name.isEmpty() || value == null) return params;

    Collection valueCollection;
    if (value instanceof Collection) {
      valueCollection = (Collection) value;
    } else {
      params.add(new Pair(name, parameterToString(value)));
      return params;
    }

    if (valueCollection.isEmpty()){
      return params;
    }

    // get the collection format (default: csv)
    String format = (collectionFormat == null || collectionFormat.isEmpty() ? "csv" : collectionFormat);

    // create the params based on the collection format
    if ("multi".equals(format)) {
      for (Object item : valueCollection) {
        params.add(new Pair(name, parameterToString(item)));
      }

      return params;
    }

    String delimiter = ",";

    if ("csv".equals(format)) {
      delimiter = ",";
    } else if ("ssv".equals(format)) {
      delimiter = " ";
    } else if ("tsv".equals(format)) {
      delimiter = "\t";
    } else if ("pipes".equals(format)) {
      delimiter = "|";
    }

    StringBuilder sb = new StringBuilder() ;
    for (Object item : valueCollection) {
      sb.append(delimiter);
      sb.append(parameterToString(item));
    }

    params.add(new Pair(name, sb.substring(1)));

    return params;
  }

  /**
   * Check if the given MIME is a JSON MIME.
   * JSON MIME examples:
   *   application/json
   *   application/json; charset=UTF8
   *   APPLICATION/JSON
   *   application/vnd.company+json
   * @param mime MIME
   * @return True if the MIME type is JSON
   */
  public boolean isJsonMime(String mime) {
    String jsonMime = "(?i)^(application/json|[^;/ \t]+/[^;/ \t]+[+]json)[ \t]*(;.*)?$";
    return mime != null && (mime.matches(jsonMime) || mime.equalsIgnoreCase("application/json-patch+json"));
  }

  /**
   * Select the Accept header's value from the given accepts array:
   *   if JSON exists in the given array, use it;
   *   otherwise use all of them (joining into a string)
   *
   * @param accepts The accepts array to select from
   * @return The Accept header to use. If the given array is empty,
   *   null will be returned (not to set the Accept header explicitly).
   */
  public String selectHeaderAccept(String[] accepts) {
    if (accepts.length == 0) {
      return null;
    }
    for (String accept : accepts) {
      if (isJsonMime(accept)) {
        return accept;
      }
    }
    return StringUtil.join(accepts, ",");
  }

  /**
   * Select the Content-Type header's value from the given array:
   *   if JSON exists in the given array, use it;
   *   otherwise use the first one of the array.
   *
   * @param contentTypes The Content-Type array to select from
   * @return The Content-Type header to use. If the given array is empty,
   *   JSON will be used.
   */
  public String selectHeaderContentType(String[] contentTypes) {
    if (contentTypes.length == 0) {
      return "application/json";
    }
    for (String contentType : contentTypes) {
      if (isJsonMime(contentType)) {
        return contentType;
      }
    }
    return contentTypes[0];
  }

  /**
   * Escape the given string to be used as URL query value.
   * @param str String
   * @return Escaped string
   */
  public String escapeString(String str) {
    try {
      return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
    } catch (UnsupportedEncodingException e) {
      return str;
    }
  }

  /**
   * Serialize the given Java object into string entity according the given
   * Content-Type (only JSON is supported for now).
   * @param obj Object
   * @param formParams Form parameters
   * @param contentType Context type
   * @return Entity
   * @throws ApiException API exception
   */
  public Entity<?> serialize(Object obj, Map<String, Object> formParams, String contentType) throws ApiException {
    Entity<?> entity;
    if (contentType.startsWith("multipart/form-data")) {
      MultiPart multiPart = new MultiPart();
      for (Entry<String, Object> param: formParams.entrySet()) {
        if (param.getValue() instanceof File) {
          File file = (File) param.getValue();
          FormDataContentDisposition contentDisp = FormDataContentDisposition.name(param.getKey())
              .fileName(file.getName()).size(file.length()).build();
          multiPart.bodyPart(new FormDataBodyPart(contentDisp, file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        } else {
          FormDataContentDisposition contentDisp = FormDataContentDisposition.name(param.getKey()).build();
          multiPart.bodyPart(new FormDataBodyPart(contentDisp, parameterToString(param.getValue())));
        }
      }
      entity = Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE);
    } else if (contentType.startsWith("application/x-www-form-urlencoded")) {
      Form form = new Form();
      for (Entry<String, Object> param: formParams.entrySet()) {
        form.param(param.getKey(), parameterToString(param.getValue()));
      }
      entity = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
    } else {
      // We let jersey handle the serialization
      entity = Entity.entity(obj, contentType);
    }
    return entity;
  }

  /**
   * Deserialize response body to Java object according to the Content-Type.
   * @param <T> Type
   * @param response Response
   * @param returnType Return type
   * @return Deserialize object
   * @throws ApiException API exception
   */
  @SuppressWarnings("unchecked")
  public <T> T deserialize(Response response, GenericType<T> returnType) throws ApiException {
    if (response == null || returnType == null) {
      return null;
    }

    if ("byte[]".equals(returnType.toString())) {
      // Handle binary response (byte array).
      return (T) response.readEntity(byte[].class);
    } else if (returnType.getRawType() == File.class) {
      // Handle file downloading.
      T file = (T) downloadFileFromResponse(response);
      return file;
    }

    String contentType = null;
    List<Object> contentTypes = response.getHeaders().get("Content-Type");
    if (contentTypes != null && !contentTypes.isEmpty())
      contentType = String.valueOf(contentTypes.get(0));
    if (contentType == null)
      throw new ApiException(500, "missing Content-Type in response");

    return response.readEntity(returnType);
  }

  /**
   * Download file from the given response.
   * @param response Response
   * @return File
   * @throws ApiException If fail to read file content from response and write to disk
   */
  public File downloadFileFromResponse(Response response) throws ApiException {
    try {
      File file = prepareDownloadFile(response);
      Files.copy(response.readEntity(InputStream.class), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
      return file;
    } catch (IOException e) {
      throw new ApiException(e);
    }
  }

  public File prepareDownloadFile(Response response) throws IOException {
    String filename = null;
    String contentDisposition = (String) response.getHeaders().getFirst("Content-Disposition");
    if (contentDisposition != null && !"".equals(contentDisposition)) {
      // Get filename from the Content-Disposition header.
      Pattern pattern = Pattern.compile("filename=['\"]?([^'\"\\s]+)['\"]?");
      Matcher matcher = pattern.matcher(contentDisposition);
      if (matcher.find())
        filename = matcher.group(1);
    }

    String prefix;
    String suffix = null;
    if (filename == null) {
      prefix = "download-";
      suffix = "";
    } else {
      int pos = filename.lastIndexOf('.');
      if (pos == -1) {
        prefix = filename + "-";
      } else {
        prefix = filename.substring(0, pos) + "-";
        suffix = filename.substring(pos);
      }
      // File.createTempFile requires the prefix to be at least three characters long
      if (prefix.length() < 3)
        prefix = "download-";
    }

    if (tempFolderPath == null)
      return File.createTempFile(prefix, suffix);
    else
      return File.createTempFile(prefix, suffix, new File(tempFolderPath));
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param <T> Type
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param formParams The form parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param authNames The authentications to apply
   * @param returnType The return type into which to deserialize the response
   * @return The response body in type of string
   * @throws ApiException API exception
   */
  public <T> T invokeAPI(
      String path, String method, List<Pair> queryParams, Object body, Map<String, String> headerParams,
      Map<String, Object> formParams, String accept, String contentType, String[] authNames,
      GenericType<T> returnType) throws ApiException {
    return invokeAPI(path,
        method,
        queryParams,
        body,
        mapAsStream(headerParams),
        formParams,
        accept,
        contentType,
        authNames,
        returnType);
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param <T> Type
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param queryParams The query parameters
   * @param body The request body object
   * @param headerParams The header parameters
   * @param formParams The form parameters
   * @param accept The request's Accept header
   * @param contentType The request's Content-Type header
   * @param authNames The authentications to apply
   * @param returnType The return type into which to deserialize the response
   * @return The response body in type of string
   * @throws ApiException API exception
   */
  public <T> T invokeAPI(
      String path, String method, List<Pair> queryParams, Object body, Stream<Pair> headerParams,
      Map<String, Object> formParams, String accept, String contentType, String[] authNames,
      GenericType<T> returnType) throws ApiException {

    Iterable<Pair> queryParamsIterable = Stream.concat(Optional.ofNullable(queryParams)
                                                               .orElse(Collections.emptyList())
                                                               .stream(),
                                                       getAuthQueryParams(authNames))
        .filter(p -> p != null && p.getName() != null && p.getValue() != null)
        .collect(Collectors.toList());

    Iterable<Pair> headersIterable = Stream.of(getAuthHeaders(authNames),
                                               headerParams,
                                               getSuppliedRequestHeaders(),
                                               getDefaultHeadersAsStream())
        .flatMap(s -> s)
        .filter(p -> p != null && p.getName() != null && p.getValue() != null)
        .collect(Collectors.toList());

    Entity<?> entity = serialize(body, formParams, contentType);

    final ConnectionInfo info;
    try {
      info = this.connectionInfoProvider.apply(Boolean.FALSE);
    } catch (DiscoveryException e) {
      throw new ApiException(e.getMessage());
    }

    try {
      return invokeAPI(info, path, method, entity, queryParamsIterable.iterator(), headersIterable.iterator(), accept, returnType);
    } catch (ApiException originalException) {
      try {
        ConnectionInfo newInfo = this.connectionInfoProvider.apply(Boolean.TRUE);
        if (!info.equals(newInfo)) {
          try {
            return invokeAPI(newInfo, path, method, entity, queryParamsIterable.iterator(), headersIterable.iterator(), accept, returnType);
          } catch (ApiException e) {
            throw originalException;
          }
        } else {
          throw originalException;
        }
      } catch (DiscoveryException de) {
        throw originalException;
      }
    }
  }

  /**
   * Invoke API by sending HTTP request with the given options.
   *
   * @param <T> Type
   * @param connectionInfo connection information
   * @param path The sub-path of the HTTP URL
   * @param method The request method, one of "GET", "POST", "PUT", and "DELETE"
   * @param body The request body entity
   * @param queryParams The query parameters
   * @param headerParams The header parameters
   * @param accept The request's Accept header
   * @param returnType The return type into which to deserialize the response
   * @return The response body in type of string
   * @throws ApiException API exception
   */
  private <T> T invokeAPI(
      ConnectionInfo info, String path, String method, Entity<?> body,
      Iterator<Pair> queryParams, Iterator<Pair> headerParams, String accept,
      GenericType<T> returnType) throws ApiException {

    // Not using `.target(info.getUrl()).path(path)` below,
    // to support (constant) query string in `path`, e.g. "/posts?draft=1"
    String targetUrl = info.getUrl() + path;
    WebTarget target = httpClient.target(targetUrl);

    while(queryParams.hasNext()) {
      Pair queryParam = queryParams.next();
      target = target.queryParam(queryParam.getName(), queryParam.getValue());
    }
    Invocation.Builder invocationBuilder = target.request().accept(accept);

    while(headerParams.hasNext()) {
      Pair headerEntry = headerParams.next();
      invocationBuilder = invocationBuilder.header(headerEntry.getName(), headerEntry.getValue());
    }
    for (Map.Entry<String, String> entry: info.getHeaders().entrySet()) {
        invocationBuilder = invocationBuilder.header(entry.getKey(), entry.getValue());
    }

    Response response = null;

    try {
      if ("GET".equals(method)) {
        response = invocationBuilder.get();
      } else if ("POST".equals(method)) {
        response = invocationBuilder.post(body);
      } else if ("PUT".equals(method)) {
        response = invocationBuilder.put(body);
      } else if ("DELETE".equals(method)) {
        response = invocationBuilder.delete();
      } else if ("PATCH".equals(method)) {
        response = invocationBuilder.header("X-HTTP-Method-Override", "PATCH").post(body);
      } else {
        throw new ApiException(500, "unknown method type " + method);
      }

      statusCode = response.getStatusInfo().getStatusCode();
      responseHeaders = buildResponseHeaders(response);

      if (response.getStatus() == Status.NO_CONTENT.getStatusCode()) {
        return null;
      } else if (response.getStatusInfo().getFamily() == Status.Family.SUCCESSFUL) {
        if (returnType == null)
          return null;
        else
          return deserialize(response, returnType);
      } else {
        String message = "Error connecting to " + targetUrl;
        String respBody = null;
        if (response.hasEntity()) {
          try {
            respBody = String.valueOf(response.readEntity(String.class));
            message = "Error connecting to " + targetUrl + ": " + respBody;
          } catch (RuntimeException e) {
            // e.printStackTrace();
          }
        }
        throw new ApiException(
          response.getStatus(),
          message,
          buildResponseHeaders(response),
          respBody,
          targetUrl);
      }
    } catch (ProcessingException e) {
        throw new ApiException("Error connecting to " + targetUrl, e, targetUrl);
    } finally {
      try {
        response.close();
      } catch (Exception e) {
        // it's not critical, since the response object is local in method invokeAPI; that's fine, just continue
      }
    }
  }

  /**
   * Build the Client used to make HTTP requests.
   * @param debugging Debug setting
   * @return Client
   */
  private Client buildHttpClient(boolean debugging) {
    final ClientConfig clientConfig = new ClientConfig();
    clientConfig.register(MultiPartFeature.class);
    clientConfig.register(json);
    clientConfig.register(JacksonFeature.class);
    //if (debugging) {
    //  clientConfig.register(new LoggingFilter(java.util.logging.Logger.getLogger(LoggingFilter.class.getName()), true));
    //}
    return ClientBuilder.newClient(clientConfig);
  }

  private Map<String, List<String>> buildResponseHeaders(Response response) {
    Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>();
    for (Entry<String, List<Object>> entry: response.getHeaders().entrySet()) {
      List<Object> values = entry.getValue();
      List<String> headers = new ArrayList<String>();
      for (Object o : values) {
        headers.add(String.valueOf(o));
      }
      responseHeaders.put(entry.getKey(), headers);
    }
    return responseHeaders;
  }

  /**
   * Get headers from authentication settings.
   *
   * @param authName authentications to use
   * @return headers as stream of pairs
   */
  private Stream<Pair> getAuthHeaders(String[] authNames) {
    return Arrays.stream(authNames)
                 .map(n -> Optional.ofNullable(authentications.get(n))
                                   .<RuntimeException>orElseThrow(
                                       () -> new RuntimeException(
                                           "Authentication undefined: " + n)))
                 .flatMap(a -> a.asHeaderParams());
  }

  /**
   * Get query parameters from authentication settings.
   *
   * @param authName authentications to use
   * @return query parameters as stream of pairs
   */
  private Stream<Pair> getAuthQueryParams(String[] authNames) {
    return Arrays.stream(authNames)
                 .map(n -> Optional.ofNullable(authentications.get(n))
                                   .<RuntimeException>orElseThrow(
                                       () -> new RuntimeException(
                                           "Authentication undefined: " + n)))
                 .flatMap(a -> a.asQueryParams());
  }

  /**
   * Helper method to safely call supplier to get stream of headers.
   *
   * @return stream of pairs
   */
  private Stream<Pair> getSuppliedRequestHeaders() {
    return Optional.ofNullable(getRequestHeadersSupplier())
        .orElse(() -> Stream.empty())
        .get();
  }

  /**
   * Helper method to get default headers as map.
   *
   * @return stream of pairs
   */
  private Stream<Pair> getDefaultHeadersAsStream() {
    return mapAsStream(defaultHeaderMap);
  }

  /**
   * Helper method to convert map of strings to stream of pairs.
   *
   * @param map input
   * @return stream of pairs
   */
  private static Stream<Pair> mapAsStream(Map<String, String> map) {
    return Optional.ofNullable(map).orElse(Collections.emptyMap()).entrySet().stream()
        .map(e -> new Pair(e.getKey(), e.getValue()));
  }

}