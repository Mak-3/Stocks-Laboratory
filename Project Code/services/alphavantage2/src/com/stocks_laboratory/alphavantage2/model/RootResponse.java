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

package com.stocks_laboratory.alphavantage2.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.stocks_laboratory.alphavantage2.model.ResponseFeedEntryItem;
import java.util.ArrayList;
import java.util.List;
/**
 * RootResponse
 */

public class RootResponse {
  @JsonProperty("feed")
  private List<ResponseFeedEntryItem> feed = new ArrayList<>();

  @JsonProperty("sentiment_score_definition")
  private String sentiment_score_definition = null;

  @JsonProperty("relevance_score_definition")
  private String relevance_score_definition = null;

  @JsonProperty("items")
  private String items = null;

  public RootResponse feed(List<ResponseFeedEntryItem> feed) {
    this.feed = feed;
    return this;
  }

  public RootResponse addFeedItem(ResponseFeedEntryItem feedItem) {
    this.feed.add(feedItem);
    return this;
  }

   /**
   * Get feed
   * @return feed
  **/
  public List<ResponseFeedEntryItem> getFeed() {
    return feed;
  }

  public void setFeed(List<ResponseFeedEntryItem> feed) {
    this.feed = feed;
  }

  public RootResponse sentiment_score_definition(String sentiment_score_definition) {
    this.sentiment_score_definition = sentiment_score_definition;
    return this;
  }

   /**
   * Get sentiment_score_definition
   * @return sentiment_score_definition
  **/
  public String getSentimentScoreDefinition() {
    return sentiment_score_definition;
  }

  public void setSentimentScoreDefinition(String sentiment_score_definition) {
    this.sentiment_score_definition = sentiment_score_definition;
  }

  public RootResponse relevance_score_definition(String relevance_score_definition) {
    this.relevance_score_definition = relevance_score_definition;
    return this;
  }

   /**
   * Get relevance_score_definition
   * @return relevance_score_definition
  **/
  public String getRelevanceScoreDefinition() {
    return relevance_score_definition;
  }

  public void setRelevanceScoreDefinition(String relevance_score_definition) {
    this.relevance_score_definition = relevance_score_definition;
  }

  public RootResponse items(String items) {
    this.items = items;
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RootResponse RootResponse = (RootResponse) o;
    return Objects.equals(this.feed, RootResponse.feed) &&
        Objects.equals(this.sentiment_score_definition, RootResponse.sentiment_score_definition) &&
        Objects.equals(this.relevance_score_definition, RootResponse.relevance_score_definition) &&
        Objects.equals(this.items, RootResponse.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feed, sentiment_score_definition, relevance_score_definition, items);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RootResponse {\n");
    
    sb.append("    feed: ").append(toIndentedString(feed)).append("\n");
    sb.append("    sentiment_score_definition: ").append(toIndentedString(sentiment_score_definition)).append("\n");
    sb.append("    relevance_score_definition: ").append(toIndentedString(relevance_score_definition)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
