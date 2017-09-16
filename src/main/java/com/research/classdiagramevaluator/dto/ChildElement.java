
package com.research.classdiagramevaluator.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "childId",
    "relationType"
})
public class ChildElement {

    /**
     * The Childid Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("childId")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private ChildElement.ChildId childId = ChildElement.ChildId.fromValue(2);
    /**
     * The Relationtype Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("relationType")
    @JsonPropertyDescription("An explanation about the purpose of this instance.")
    private ChildElement.RelationType relationType = ChildElement.RelationType.fromValue("Inheritance");
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * The Childid Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("childId")
    public ChildElement.ChildId getChildId() {
        return childId;
    }

    /**
     * The Childid Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("childId")
    public void setChildId(ChildElement.ChildId childId) {
        this.childId = childId;
    }

    /**
     * The Relationtype Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("relationType")
    public ChildElement.RelationType getRelationType() {
        return relationType;
    }

    /**
     * The Relationtype Schema
     * <p>
     * An explanation about the purpose of this instance.
     * (Required)
     * 
     */
    @JsonProperty("relationType")
    public void setRelationType(ChildElement.RelationType relationType) {
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

    public enum ChildId {

        _2(2);
        private final Integer value;
        private final static Map<Integer, ChildElement.ChildId> CONSTANTS = new HashMap<Integer, ChildElement.ChildId>();

        static {
            for (ChildElement.ChildId c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ChildId(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer value() {
            return this.value;
        }

        @JsonCreator
        public static ChildElement.ChildId fromValue(Integer value) {
            ChildElement.ChildId constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException((value +""));
            } else {
                return constant;
            }
        }

    }

    public enum RelationType {

        INHERITANCE("Inheritance");
        private final String value;
        private final static Map<String, ChildElement.RelationType> CONSTANTS = new HashMap<String, ChildElement.RelationType>();

        static {
            for (ChildElement.RelationType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private RelationType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ChildElement.RelationType fromValue(String value) {
            ChildElement.RelationType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
