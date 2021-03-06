/*
 * EventManager
 * EventManager is a simple API allowing user to interact with EventManager.  It allows user to:  * register/unregister an EventProvider with EventManager  * get the information of a registered EventProvider  * list all the registered EventProvider  * send event to the EventBus via EventManager
 *
 * OpenAPI spec version: 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Function;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Configuration for creating {@link ApiClient} connected to a service according to configuration properties.
 *
 * <p>
 * The following configuration properties are recognised:
 * </p>
 * <table summary="Configuration Properties">
 * <tr><th>Name</th>              <th>Default</th>          <th>Description</th></tr>
 * <tr><td>host</td>              <td>localhost</td>        <td>host name to connect</td></tr>
 * <tr><td>port</td>              <td>80</td>               <td>port to connect</td></tr>
 * <tr><td>protocol</td>          <td>http</td>             <td>protocol to use</td></tr>
 * <tr><td>base.path.prefix</td>  <td></td>                 <td>optional path fragment to be added before base path,
 *                                                              by default it is empty</td></tr>
 * <tr><td>root.url</td>          <td>${protocol}://${host}:${port}/${base.path.prefix}</td>
 *                                                          <td>root URL to connect</td></tr>
 * <tr><td>base.path</td>         <td>/</td>  <td>base path defined in API description
 *                                                              ({@code basePath} property in Open API)</td></tr>
 * <tr><td>base.url</td>          <td>${rootUrl}/${base.path}</td>
 *                                                          <td>base URL to connect - this value is passed to {@link ApiClient}</td></tr>
 * </table>
 *
 * <p>
 * The properties are read from files and environment variables in the following order:
 * </p>
 * <ul>
 * <li><b>1. Separate files for each property</b><br>
 *     E.g. files <code>${config-dir}/host</code>, <code>${config-dir}</code> etc. Each file conains plain text value of the property</li>
 * <li><b>2. Properties file</b><br>
 *     <code>${config-dir}/connection.properties</code> file in Java Properties format</li>
 * <li><b>2. JSON file</b><br>
 *     <code>${config-dir}/connection.json</code> file in JSON format</li>
 * <li><b>2. Environemtn varibales</b><br>
 *     {@code <NAME>_<PROPERTY>} environment variables, e.g. {@code CLIENT_V1_HOST}, {@code CLIENT_V1_PORT}</li>
 * </ul>
 *
 * <p>
 * The {@code name} of configuration, which is {@code "eventmanager"} by default and
 * may be overriden using {#link Builder#name(String)} method, determines {@code config-dir},
 * the directory which is scanned for configuration files.
 * </p>
 *
 * <p>
 * {@code config-dir} is by default <code>/etc/aura/apiclient/default/${name}</code>, where {@code name} is the name of configuration.
 * Sticking with default {@code name}, {@code config-dir} will be {@code /etc/aura/apiclient/default/eventmanager}.
 * The leading part of {@code config-dir} can be changed too:
 * it is composed as <code>${API_CLIENT_CONFIG_ROOT_PATH}/${env}/${name}</code>,
 * where {@code API_CLIENT_CONFIG_ROOT_PATH} is environment variable (default {@code /etc/aura/apiclient}) and
 * {@code env} is value of {@code API_CLIENT_ENV} environment variable or {@code <NAME>_ENV} environment variable
 * which takes precedence if exists and is non-empty.
 * </p>
 *
 * <p>
 * {@code <NAME>} (resp. {@code <PROPERTY>}) used to form environment variable names are upper case'd values of
 * {@code name} (resp. name of property) with all non-alphanumeric characters replaced with underscore.
 * Example: {@code create("client.v1")} will try to read <i>host</i> property from {@code CLIENT_V1_HOST} environment variable.
 * </p>
 */
@javax.annotation.Generated(value = "com.oracle.aura.clientgen.template.java.Generator", date = "2017-12-07T15:11:31.765Z")
public class Configuration {

    /**
     * Enumeration of discovery policies, policies which define if and how often to reach discovery service
     * if target service is not configured using configuration.
     */
    public enum DiscoveryPolicy {
        NEVER,
        ALWAYS,
        ONCE
    }

    /**
     * Builder of {@link Configuration}.
     */
    public static class Builder {
        private Properties properties;
        private String name;
        private DiscoveryPolicy discoveryPolicy;

        /**
         * Set discovery policy.
         * @param discoveryPolicy discovery policy
         * @return {@code this}
         */
        public Builder discoveryPolicy(DiscoveryPolicy discoveryPolicy) {
            this.discoveryPolicy = discoveryPolicy;
            return this;
        }

        /**
         * Set configuration name.
         * @param name configuration name
         * @return {@code this}
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set configuration properties.
         * @param properties properties
         * @return {@code this}
         */
        public Builder properties(Properties properties) {
            this.properties = properties;
            return this;
        }

        /**
         * Creates configuration using values aggregated using this builder.
         * @return {@link Configuration} object
         */
        public Configuration build() {
            String configName = name != null ? name : DEFAULT_NAME;
            return new Configuration(
                    configName,
                    properties != null ? properties : Configuration.loadProperties(configName),
                    discoveryPolicy != null ? discoveryPolicy : DiscoveryPolicy.ALWAYS);
        }

        /**
         * Creates new instance of this builder.
         * @return new {@link Builder}
         */
        public static Builder create() {
            return new Builder();
        }
    }

    private static final String DEFAULT_NAME = "eventmanager";
    private static final String DEFAULT_PROTOCOL = "http";
    private static final String DEFAULT_HOST = "polls.apiblueprint.org";
    private static final String DEFAULT_PORT = "";
    private static final String DEFAULT_BASE_PATH_PREFIX = "";
    private static final String DEFAULT_BASE_PATH = "/";
    private static final String PROTOCOL_PROPERTY_NAME = "protocol";
    private static final String HOST_PROPERTY_NAME = "host";
    private static final String PORT_PROPERTY_NAME = "port";
    private static final String USER_PROPERTY_NAME = "user";
    private static final String PASS_PROPERTY_NAME = "pass";
    private static final String TOKEN_PROPERTY_NAME = "token";
    private static final String BASE_PATH_PREFIX_PROPERTY_NAME = "base.path.prefix";
    private static final String BASE_PATH_PROPERTY_NAME = "base.path";
    private static final String BASE_URL_PROPERTY_NAME = "base.url";
    private static final String ROOT_URL_PROPERTY_NAME = "root.url";
    private static final String[] PROPERTY_NAMES = new String[] {
            HOST_PROPERTY_NAME,
            PORT_PROPERTY_NAME,
            USER_PROPERTY_NAME,
            PASS_PROPERTY_NAME,
            TOKEN_PROPERTY_NAME,
            BASE_PATH_PREFIX_PROPERTY_NAME,
            BASE_PATH_PROPERTY_NAME,
            BASE_URL_PROPERTY_NAME,
            ROOT_URL_PROPERTY_NAME
        };
    private static final Pattern NAME_VALIDATION_PATTERN = Pattern.compile("^[a-zA-Z.-][a-zA-Z0-9.-]*$");
    private static final Pattern NON_ALPHANUMERIC_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    private final Properties properties;
    private final String name;
    private final DiscoveryPolicy discoveryPolicy;

    /**
     * Creates new instance of {@link Configuration}.
     *
     * @param name name of the configuration
     * @param properties configuration properties
     * @param discoveryPolicy discovery policy
     */
    private Configuration(String name, Properties properties, DiscoveryPolicy discoveryPolicy) {
      validate(name);
      Objects.requireNonNull(properties);
      Objects.requireNonNull(discoveryPolicy);
      this.name = name;
      this.properties = properties;
      this.discoveryPolicy = discoveryPolicy;
    }

    /**
     * Gets name of this configuration.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets value of property in this configuration.
     *
     * @param key of property
     * @return value of property
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBasePath() {
        return basePathFromProperties(properties);
    }

    public String getBaseUrl() {
        return baseUrlFromProperties(properties);
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    /**
     * Creates configured {@code ApiClient} with this configuration.
     *
     * @return {@code ApiClient}
     */
    public ApiClient createApiClient() {
        if (properties.isEmpty()) {
            return new ApiClient(name, createBaseUrlProvider());
        } else {
            return new ApiClient(name, createBaseUrlProviderPolicyNever());
        }
    }

    private Function<Boolean, ServiceDiscoveryClient.ConnectionInfo> createBaseUrlProvider() {
        switch (discoveryPolicy) {
            case ONCE:
                return createBaseUrlProviderPolicyOnce();
            case NEVER:
                return createBaseUrlProviderPolicyNever();
            default: // ALWAYS
                return createBaseUrlProviderPolicyAlways();
        }
    }

    private Function<Boolean, ServiceDiscoveryClient.ConnectionInfo> createBaseUrlProviderPolicyAlways() {
        return this::callDiscoveryService;
    }

    private Function<Boolean, ServiceDiscoveryClient.ConnectionInfo> createBaseUrlProviderPolicyOnce() {
        return new Function<Boolean, ServiceDiscoveryClient.ConnectionInfo>() {

            private volatile ServiceDiscoveryClient.ConnectionInfo value;

            @Override
            public ServiceDiscoveryClient.ConnectionInfo apply(Boolean force) {
                if (value == null || Boolean.TRUE.equals(force)) {
                    synchronized (this) {
                        if (value == null || Boolean.TRUE.equals(force)) {
                            value = callDiscoveryService(force);
                        }
                    }
                }
                return value;
            }
        };
    }

    private Function<Boolean, ServiceDiscoveryClient.ConnectionInfo> createBaseUrlProviderPolicyNever() {
        ServiceDiscoveryClient.ConnectionInfo info = new ServiceDiscoveryClient.ConnectionInfo(getBaseUrl(), getHeaders());
        return (f) -> info;
    }

    private ServiceDiscoveryClient.ConnectionInfo callDiscoveryService(Boolean force) {
        return ServiceDiscoveryClient.instance().getConnectionInfo(this, force == null ? false : force.booleanValue());
    }

    /**
     * Load configuration properties by instance name.
     *
     * @param name name of instance
     * @return Properties
     */
    public static Properties loadProperties(String name) {
        return loadProperties(name, getConfigPath(name));
    }

    /**
     * Load configuration properties by instance name with given configuration path.
     *
     * @param name name of instance
     * @param configPath path of configuration directory
     * @return Properties
     */
    public static Properties loadProperties(String name, File configPath) {
        validate(name);
        Objects.requireNonNull(configPath);
        Properties properties = new Properties();
        properties = readDirectory(properties, configPath);
        properties = readJavaProperties(properties, new File(configPath, "connection.properties"));
        properties = readJsonFile(properties, new File(configPath, "connection.json"));
        properties = readEnvironment(properties, name);
        return properties;
    }

    static String basePathFromProperties(Properties properties) {
        return getNonNullPropertyValue(properties, BASE_PATH_PROPERTY_NAME, DEFAULT_BASE_PATH).trim();
    }

    static String baseUrlFromProperties(Properties properties) {
        String protocol = getNonNullPropertyValue(properties,PROTOCOL_PROPERTY_NAME, DEFAULT_PROTOCOL).trim();
        String host = getNonNullPropertyValue(properties, HOST_PROPERTY_NAME, DEFAULT_HOST).trim();
        String port = getNonNullPropertyValue(properties, PORT_PROPERTY_NAME, DEFAULT_PORT).trim();
        String basePathPrefix = getNonNullPropertyValue(properties, BASE_PATH_PREFIX_PROPERTY_NAME, DEFAULT_BASE_PATH_PREFIX).trim();
        String basePath = basePathFromProperties(properties);
        String rootUrl = getNonNullPropertyValue(properties, ROOT_URL_PROPERTY_NAME,
                StringUtil.joinUrlPathElements(protocol + "://" + host + (!port.isEmpty() ? (":" + port) : ""),
                        basePathPrefix)).trim();
        String baseUrl = getNonNullPropertyValue(properties, BASE_URL_PROPERTY_NAME,
                StringUtil.joinUrlPathElements(rootUrl, basePath)).trim();
        return baseUrl;
    }

    private static Properties readJavaProperties(Properties properties, File propertiesFile) {
        try {
            if (propertiesFile.exists() && propertiesFile.isFile()) {
                try (InputStream is = new FileInputStream(propertiesFile)) {
                    properties.load(is);
                }
            }
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read configuration file " + propertiesFile.getAbsolutePath(), e);
        }
    }

    private static Properties readDirectory(Properties properties, File propertiesDirectory) {
        try {
            if (propertiesDirectory.exists() && propertiesDirectory.isDirectory()) {
                for (String propertyName : PROPERTY_NAMES) {
                    String value = valueOfFile(new File(propertiesDirectory, propertyName));
                    if (value != null) {
                        properties.put(propertyName, value);
                    }
                }
            }
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read configuration from directory " + propertiesDirectory, e);
        }
    }

    private static Properties readJsonFile(Properties properties, File propertiesFile) {
        try {
            if (propertiesFile.exists() && propertiesFile.isFile()) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode node = mapper.readTree(propertiesFile);
                try {
                    writeToProperties(properties, node);
                } catch (IllegalArgumentException e) {
                    throw new IllegalStateException("Failed to read configuration file "
                            + propertiesFile.getAbsolutePath()
                            + ": " + e.getMessage(), e);
                }
            }
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read configuration file " + propertiesFile.getAbsolutePath(), e);
        }
    }

    /**
     * Writes known properties from {@code json} to {@code properties}.
     * @param properties {@link Properties} (not null)
     * @param json {@link JsonNode} (not null)
     * @throws IllegalArgumentException if a known property is of an unexpected type
     */
    public static void writeToProperties(Properties properties, JsonNode json) {
        for (String propertyName : PROPERTY_NAMES) {
            JsonNode propertyNode = json.get(propertyName);
            if (propertyNode != null) {
                if (PORT_PROPERTY_NAME.equals(propertyName) && propertyNode.canConvertToLong()) {
                    properties.put(propertyName, Long.toString(propertyNode.asLong()));
                } else if (propertyNode.isTextual()) {
                    properties.put(propertyName, propertyNode.asText());
                } else {
                    throw new IllegalArgumentException("Invalid type of " + propertyName);
                }
            }
        }
    }

    private static Properties readEnvironment(Properties properties, String name) {
        String envNamePrefix = envFragmentFrom(name);
        for (String propertyName : PROPERTY_NAMES) {
            String value = System.getenv(envNamePrefix + "_" + envFragmentFrom(propertyName));
            if (value != null) {
                properties.put(propertyName, value);
            }
        }
        return properties;
    }

    private static String envFragmentFrom(String name) {
        if (name != null) {
            return NON_ALPHANUMERIC_PATTERN.matcher(name).replaceAll("_").toUpperCase();
        } else {
            return name;
        }
    }

    private static File getConfigPath(String name) {
        File root = new File(getEnvironmentVaribale("API_CLIENT_CONFIG_ROOT_PATH", "/etc/aura/apiclient"));
        File rootWithEnv = new File(root,
                getEnvironmentVaribale(
                        envFragmentFrom(name) + "_ENV",
                        getEnvironmentVaribale("API_CLIENT_ENV", "default")));
        File configDir = new File(rootWithEnv, name);
        return configDir;
    }

    private static String getEnvironmentVaribale(String name, String defaultValue) {
        String value = System.getenv(name);
        value = value != null ? value.trim() : "";
        return value.isEmpty() ? defaultValue : value;
    }

    private static String valueOfFile(File file) throws IOException {
        Objects.requireNonNull(file);
        if (file.exists() && file.isFile()) {
            byte[] encoded = Files.readAllBytes(file.toPath());
            return new String(encoded);
        } else {
            return null;
        }
    }

    private static String getNonNullPropertyValue(Properties properties, String key, String defaultValue) {
        String value = properties.getProperty(key, defaultValue);
        return value != null ? value : "";
    }

    private static void validate(String name) {
        Objects.requireNonNull(name);
        if (!NAME_VALIDATION_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    "Name must match " + NAME_VALIDATION_PATTERN.pattern());
        }
    }

    //
    // Deprecated stuff follows.
    // Shall be removed once we are sure that no library template uses it.
    //

    /**
     * @deprecated will be removed without replacement
     */
    private static ApiClient defaultApiClient = new ApiClient();

    /**
     * Get the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @return Default API client
     * @deprecated use {@link Builder#create()}, {@link Builder#build()} and {@link #createApiClient()} instead
     */
    public static ApiClient getDefaultApiClient() {
        return defaultApiClient;
    }

    /**
     * Set the default API client, which would be used when creating API
     * instances without providing an API client.
     *
     * @param apiClient API client
     * @deprecated will be removed without replacement
     */
    public static void setDefaultApiClient(ApiClient apiClient) {
        defaultApiClient = apiClient;
    }

}
