
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
    "parentId",
    "relationType"
})
public class ParentElement {

    @JsonProperty("parentId")
    private Integer parentId;
    @JsonProperty("relationType")
    private String relationType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("parentId")
    public Integer getParentId() {
        return parentId;
    }

    @JsonProperty("parentId")
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("relationType")
    public String getRelationType() {
        return relationType;
    }

    @JsonProperty("relationType")
    public void setRelationType(String relationType) {
        this.relationType = relationType;
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
