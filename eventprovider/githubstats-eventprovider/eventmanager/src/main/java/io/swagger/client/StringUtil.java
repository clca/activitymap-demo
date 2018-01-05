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

@javax.annotation.Generated(value = "com.oracle.aura.clientgen.template.java.Generator", date = "2017-12-07T15:11:31.765Z")
public class StringUtil {
  /**
   * Check if the given array contains the given value (with case-insensitive comparison).
   *
   * @param array The array
   * @param value The value to search
   * @return true if the array contains the value
   */
  public static boolean containsIgnoreCase(String[] array, String value) {
    for (String str : array) {
      if (value == null && str == null) return true;
      if (value != null && value.equalsIgnoreCase(str)) return true;
    }
    return false;
  }

  /**
   * Join an array of strings with the given separator.
   * <p>
   * Note: This might be replaced by utility method from commons-lang or guava someday
   * if one of those libraries is added as dependency.
   * </p>
   *
   * @param array     The array of strings
   * @param separator The separator
   * @return the resulting string
   */
  public static String join(String[] array, String separator) {
    int len = array.length;
    if (len == 0) return "";

    StringBuilder out = new StringBuilder();
    out.append(array[0]);
    for (int i = 1; i < len; i++) {
      out.append(separator).append(array[i]);
    }
    return out.toString();
  }

    /**
     * Joins two URL path elements together.
     *
     * @param first first part (may be full url)
     * @param second path element to add to first
     * @return joined url
     */
    public static String joinUrlPathElements(String first, String second) {
        if (first == null || first.isEmpty()) return second;
        if (second == null || second.isEmpty()) return first;
        return stripTrailingSlashes(first) + "/" + stripLeadingSlashes(second);
    }


    /**
     * Strips trailing slashes from string.
     *
     * @param value to be stripped
     * @return value without trailing slashes
     */
    public static String stripTrailingSlashes(String value) {
        if (value != null) {
            int index = value.length();
            while (--index >= 0 && value.charAt(index) == '/');
            return value.substring(0, index + 1);
        }
        return value;
    }

    /**
     * Strips leading slashes from string.
     *
     * @param value to be stripped
     * @return value without leading slashes
     */
    public static String stripLeadingSlashes(String value) {
        if (value != null) {
            int index = -1;
            int endIndex = value.length();
            while (++index < endIndex && value.charAt(index) == '/');
            return value.substring(index, endIndex);
        }
        return value;
    }

}
