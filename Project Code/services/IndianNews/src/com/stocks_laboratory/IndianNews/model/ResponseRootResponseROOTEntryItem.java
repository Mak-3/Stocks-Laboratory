/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.stocks_laboratory.IndianNews.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * ResponseRootResponseROOTEntryItem
 */

public class ResponseRootResponseROOTEntryItem {
  @JsonProperty("Title")
  private String Title = null;

  @JsonProperty("URL")
  private String URL = null;

  @JsonProperty("Source")
  private String Source = null;

  public ResponseRootResponseROOTEntryItem Title(String Title) {
    this.Title = Title;
    return this;
  }

   /**
   * Get Title
   * @return Title
  **/
  public String getTitle() {
    return Title;
  }

  public void setTitle(String Title) {
    this.Title = Title;
  }

  public ResponseRootResponseROOTEntryItem URL(String URL) {
    this.URL = URL;
    return this;
  }

   /**
   * Get URL
   * @return URL
  **/
  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public ResponseRootResponseROOTEntryItem Source(String Source) {
    this.Source = Source;
    return this;
  }

   /**
   * Get Source
   * @return Source
  **/
  public String getSource() {
    return Source;
  }

  public void setSource(String Source) {
    this.Source = Source;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseRootResponseROOTEntryItem Response_RootResponseROOTEntryItem = (ResponseRootResponseROOTEntryItem) o;
    return Objects.equals(this.Title, Response_RootResponseROOTEntryItem.Title) &&
        Objects.equals(this.URL, Response_RootResponseROOTEntryItem.URL) &&
        Objects.equals(this.Source, Response_RootResponseROOTEntryItem.Source);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Title, URL, Source);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseRootResponseROOTEntryItem {\n");
    
    sb.append("    Title: ").append(toIndentedString(Title)).append("\n");
    sb.append("    URL: ").append(toIndentedString(URL)).append("\n");
    sb.append("    Source: ").append(toIndentedString(Source)).append("\n");
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
