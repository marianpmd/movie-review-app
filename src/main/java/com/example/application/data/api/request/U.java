
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
    "certificate",
    "certificateNumber",
    "ratingReason",
    "ratingsBody",
    "country"
})
@Generated("jsonschema2pojo")
public class U {

    @JsonProperty("certificate")
    private String certificate;
    @JsonProperty("certificateNumber")
    private Integer certificateNumber;
    @JsonProperty("ratingReason")
    private String ratingReason;
    @JsonProperty("ratingsBody")
    private String ratingsBody;
    @JsonProperty("country")
    private String country;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("certificate")
    public String getCertificate() {
        return certificate;
    }

    @JsonProperty("certificate")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @JsonProperty("certificateNumber")
    public Integer getCertificateNumber() {
        return certificateNumber;
    }

    @JsonProperty("certificateNumber")
    public void setCertificateNumber(Integer certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @JsonProperty("ratingReason")
    public String getRatingReason() {
        return ratingReason;
    }

    @JsonProperty("ratingReason")
    public void setRatingReason(String ratingReason) {
        this.ratingReason = ratingReason;
    }

    @JsonProperty("ratingsBody")
    public String getRatingsBody() {
        return ratingsBody;
    }

    @JsonProperty("ratingsBody")
    public void setRatingsBody(String ratingsBody) {
        this.ratingsBody = ratingsBody;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
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
        sb.append(U.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("certificate");
        sb.append('=');
        sb.append(((this.certificate == null)?"<null>":this.certificate));
        sb.append(',');
        sb.append("certificateNumber");
        sb.append('=');
        sb.append(((this.certificateNumber == null)?"<null>":this.certificateNumber));
        sb.append(',');
        sb.append("ratingReason");
        sb.append('=');
        sb.append(((this.ratingReason == null)?"<null>":this.ratingReason));
        sb.append(',');
        sb.append("ratingsBody");
        sb.append('=');
        sb.append(((this.ratingsBody == null)?"<null>":this.ratingsBody));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
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
