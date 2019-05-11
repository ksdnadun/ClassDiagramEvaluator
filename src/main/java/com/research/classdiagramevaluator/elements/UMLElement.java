package com.research.classdiagramevaluator.elements;

import com.research.classdiagramevaluator.common.enums.UMLElementType;

public class UMLElement {
	
	private UMLElementType umlElementType;
	private String umlElementName;
	
	public UMLElementType getUmlElementType() {
		return umlElementType;
	}
	public void setUmlElementType(UMLElementType umlElementType) {
		this.umlElementType = umlElementType;
	}
	public String getUmlElementName() {
		return umlElementName;
	}
	public void setUmlElementName(String umlElementName) {
		this.umlElementName = umlElementName;
	}
	

}
