
package com.example.application.data.api.request;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "title",
    "certificates",
    "ratings",
    "genres",
    "releaseDate",
    "plotOutline",
    "plotSummary"
})
@Generated("jsonschema2pojo")
public class Movie {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private Title title;
    @JsonProperty("certificates")
    private Certificates certificates;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonProperty("genres")
    private List<String> genres = null;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("plotOutline")
    private PlotOutline plotOutline;
    @JsonProperty("plotSummary")
    private PlotSummary plotSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("certificates")
    public Certificates getCertificates() {
        return certificates;
    }

    @JsonProperty("certificates")
    public void setCertificates(Certificates certificates) {
        this.certificates = certificates;
    }

    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("genres")
    public List<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @JsonProperty("releaseDate")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("releaseDate")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("plotOutline")
    public PlotOutline getPlotOutline() {
        return plotOutline;
    }

    @JsonProperty("plotOutline")
    public void setPlotOutline(PlotOutline plotOutline) {
        this.plotOutline = plotOutline;
    }

    @JsonProperty("plotSummary")
    public PlotSummary getPlotSummary() {
        return plotSummary;
    }

    @JsonProperty("plotSummary")
    public void setPlotSummary(PlotSummary plotSummary) {
        this.plotSummary = plotSummary;
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
        sb.append(Movie.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("certificates");
        sb.append('=');
        sb.append(((this.certificates == null)?"<null>":this.certificates));
        sb.append(',');
        sb.append("ratings");
        sb.append('=');
        sb.append(((this.ratings == null)?"<null>":this.ratings));
        sb.append(',');
        sb.append("genres");
        sb.append('=');
        sb.append(((this.genres == null)?"<null>":this.genres));
        sb.append(',');
        sb.append("releaseDate");
        sb.append('=');
        sb.append(((this.releaseDate == null)?"<null>":this.releaseDate));
        sb.append(',');
        sb.append("plotOutline");
        sb.append('=');
        sb.append(((this.plotOutline == null)?"<null>":this.plotOutline));
        sb.append(',');
        sb.append("plotSummary");
        sb.append('=');
        sb.append(((this.plotSummary == null)?"<null>":this.plotSummary));
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
