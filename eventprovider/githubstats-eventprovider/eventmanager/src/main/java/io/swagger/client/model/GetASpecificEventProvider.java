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


package io.swagger.client.model;

import java.util.Objects;

/**
 * GetASpecificEventProvider
 */
@javax.annotation.Generated(value = "com.oracle.aura.clientgen.template.java.Generator", date = "2017-12-07T15:11:31.765Z")
public class GetASpecificEventProvider {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetASpecificEventProvider {\n");
    
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

