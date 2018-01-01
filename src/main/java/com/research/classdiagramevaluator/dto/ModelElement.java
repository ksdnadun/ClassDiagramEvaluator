
package com.research.classdiagramevaluator.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "elementName",
    "parentElements",
    "isAbstractClass",
    "childElements",
    "attributes",
    "behaviors"
})
public class ModelElement {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("elementName")
    private String elementName;    
    @JsonProperty("parentElements")
    private List<ParentElement> parentElements = null;
    @JsonProperty("isAbstractClass")
    private String isAbstractClass;
    @JsonProperty("childElements")
    private List<ChildElement> childElements;
    @JsonProperty("attributes")
    private Object attributes;
    @JsonProperty("behaviors")
    private List<Behavior> behaviors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }
    
    @JsonProperty("elementName")
    public void setElementName(String elementName) {
    	this.elementName = elementName;
    }
    
    @JsonProperty("elementName")
    public String getElementName() {
    	return elementName;
    }

    @JsonProperty("parentElements")
    public List<ParentElement> getParentElements() {
        return parentElements;
    }

    @JsonProperty("parentElements")
    public void setParentElements(List<ParentElement> parentElements) {
        this.parentElements = parentElements;
    }

    @JsonProperty("isAbstractClass")
    public String getIsAbstractClass() {
        return isAbstractClass;
    }

    @JsonProperty("isAbstractClass")
    public void setIsAbstractClass(String isAbstractClass) {
        this.isAbstractClass = isAbstractClass;
    }

    @JsonProperty("childElements")
    public List<ChildElement> getChildElements() {
        return childElements;
    }

    @JsonProperty("childElements")
    public void setChildElements(List<ChildElement> childElements) {
        this.childElements = childElements;
    }

    @JsonProperty("attributes")
    public Object getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("behaviors")
    public List<Behavior> getBehaviors() {
        return behaviors;
    }

    @JsonProperty("behaviors")
    public void setBehaviors(List<Behavior> behaviors) {
        this.behaviors = behaviors;
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
