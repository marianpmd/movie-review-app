
package com.example.application.data.api.request;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "canRate",
    "rating",
    "ratingCount",
    "topRank"
})
@Generated("jsonschema2pojo")
public class Ratings {

    @JsonProperty("canRate")
    private Boolean canRate;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("ratingCount")
    private Integer ratingCount;
    @JsonProperty("topRank")
    private Integer topRank;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("canRate")
    public Boolean getCanRate() {
        return canRate;
    }

    @JsonProperty("canRate")
    public void setCanRate(Boolean canRate) {
        this.canRate = canRate;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @JsonProperty("ratingCount")
    public Integer getRatingCount() {
        return ratingCount;
    }

    @JsonProperty("ratingCount")
    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    @JsonProperty("topRank")
    public Integer getTopRank() {
        return topRank;
    }

    @JsonProperty("topRank")
    public void setTopRank(Integer topRank) {
        this.topRank = topRank;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Ratings.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("canRate");
        sb.append('=');
        sb.append(((this.canRate == null)?"<null>":this.canRate));
        sb.append(',');
        sb.append("rating");
        sb.append('=');
        sb.append(((this.rating == null)?"<null>":this.rating));
        sb.append(',');
        sb.append("ratingCount");
        sb.append('=');
        sb.append(((this.ratingCount == null)?"<null>":this.ratingCount));
        sb.append(',');
        sb.append("topRank");
        sb.append('=');
        sb.append(((this.topRank == null)?"<null>":this.topRank));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
