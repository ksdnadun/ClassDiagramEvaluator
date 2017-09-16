
package com.research.classdiagramevaluator.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ModelType",
    "ModelElements"
})
public class ClassModelDTO {

    @JsonProperty("ModelType")
    private String modelType;
    @JsonProperty("ModelElements")
    private List<ModelElement> modelElements = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ModelType")
    public String getModelType() {
        return modelType;
    }

    @JsonProperty("ModelType")
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    @JsonProperty("ModelElements")
    public List<ModelElement> getModelElements() {
        return modelElements;
    }

    @JsonProperty("ModelElements")
    public void setModelElements(List<ModelElement> modelElements) {
        this.modelElements = modelElements;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
