
package com.research.classdiagramevaluator.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "returnType",
    "parametersInOrder",
    "isOverriden",
    "isAbstract"
})
public class Behavior {

    @JsonProperty("name")
    private String name;
    @JsonProperty("returnType")
    private String returnType;
    @JsonProperty("parametersInOrder")
    private Object parametersInOrder;
    @JsonProperty("isOverriden")
    private Boolean isOverriden;
    @JsonProperty("isAbstract")
    private Boolean isAbstract;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("returnType")
    public String getReturnType() {
        return returnType;
    }

    @JsonProperty("returnType")
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @JsonProperty("parametersInOrder")
    public Object getParametersInOrder() {
        return parametersInOrder;
    }

    @JsonProperty("parametersInOrder")
    public void setParametersInOrder(Object parametersInOrder) {
        this.parametersInOrder = parametersInOrder;
    }

    @JsonProperty("isOverriden")
    public Boolean getIsOverriden() {
        return isOverriden;
    }

    @JsonProperty("isOverriden")
    public void setIsOverriden(Boolean isOverriden) {
        this.isOverriden = isOverriden;
    }

    @JsonProperty("isAbstract")
    public Boolean getIsAbstract() {
        return isAbstract;
    }

    @JsonProperty("isAbstract")
    public void setIsAbstract(Boolean isAbstract) {
        this.isAbstract = isAbstract;
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
