package com.research.classdiagramevaluator.service.impl;

import java.util.List;

import com.research.classdiagramevaluator.common.enums.UMLElementType;
import com.research.classdiagramevaluator.elements.Association;
import com.research.classdiagramevaluator.elements.UMLElement;

public class AssociationEvaluator {
	
	public void evaluateAssociation(Association association) {
		evaluateSingleAssociation(association);
	}
	
	public void evaluateAssociations(List<Association> associations) {
		associations.forEach(association -> {
			evaluateAssociation(association);
		});
	}
	
	private void evaluateSingleAssociation(Association association) {
		UMLElement startUmlElement = association.getStartUMLElement();
		UMLElement endUmlElement = association.getEndUMLElement();
		if(startUmlElement.getUmlElementType() == UMLElementType.CLASS && endUmlElement.getUmlElementType() == UMLElementType.CLASS) {
			System.out.println("No ABstraction Layer");
		}
	}

}
