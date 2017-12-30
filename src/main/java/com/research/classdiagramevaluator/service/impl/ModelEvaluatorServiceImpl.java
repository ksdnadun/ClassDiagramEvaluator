package com.research.classdiagramevaluator.service.impl;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.research.classdiagramevaluator.dto.ClassModelDTO;
import com.research.classdiagramevaluator.dto.ModelElement;
import com.research.classdiagramevaluator.dto.ParentElement;
import com.research.classdiagramevaluator.dto.ResultRule;
import com.research.classdiagramevaluator.services.ModelEvaluateService;

@Component
public class ModelEvaluatorServiceImpl implements ModelEvaluateService {

	@Override
	public List<ResultRule> evaluateModel(ClassModelDTO classModelDTO) {
		List<ResultRule> ruleList = processModelsData(classModelDTO);
		return ruleList;
		//return null;
		//return ResponseEntity.ok().body("Overriding parent class methods can generate problems while maintainig changes");
	}
	
	private List<ResultRule> processModelsData(ClassModelDTO classModelDTO){
		List<ResultRule> resultRuleList = new ArrayList<ResultRule>();
		ResultRule rule1 = new ResultRule();
		rule1.set_message("This is the first Rule");
		
		ResultRule couplingRule = identifyCouplingOfClasses(classModelDTO.getModelElements());
		//resultRuleList.add(rule1);//rule1
		resultRuleList.add(couplingRule);//rule1
		return resultRuleList;
	}
	
	//2.	Program to an interface, not to an implementation
		//3.	Favor composition over inheritance
		
		private ResultRule identifyCouplingOfClasses(List<ModelElement> classesSet) {
			//get functional classes that do not have a relationwith abstract layer but only with concrete classes.		
			List<ModelElement> classesDoNotRelateWithAbstractLayer =  getclassesDoNotRelateWithAbstractLayer(classesSet);
			ResultRule couplingRule = new ResultRule();
			String couplingRuleText = "Following classes do not associated with abstract layers. ";
			StringBuilder sb = new StringBuilder(couplingRuleText);
			
			String returnText = null;
			
			if(classesDoNotRelateWithAbstractLayer.isEmpty()) {
				returnText = "All classes are properly associated with Abstract layers";
			}else {
				classesDoNotRelateWithAbstractLayer.forEach(elem -> {
					 sb.append(elem.getElementName());
				});
				
				couplingRule.set_message(sb.toString());
			}
			
			couplingRule.set_message(returnText);
			
			return couplingRule;		
		}
		
		private List<ModelElement> getclassesDoNotRelateWithAbstractLayer(List<ModelElement> classesSet) {			
			
			List<ModelElement> outputList = new ArrayList<ModelElement>();
			classesSet.forEach(item -> {
				if(item.getParentElements() != null) { //&& (!item.getParentElements().isEmpty() || !item.getParentElements().isEmpty())
					List<ParentElement> parentsList =  item.getParentElements();
					parentsList.forEach(parent -> {
						int parentId = parent.getParentId();
						ModelElement selectedModel = classesSet.stream().filter(itemFromEntireList -> parentId == itemFromEntireList.getId()).findFirst().get();
						if(selectedModel.getType().equals("class")) {
							outputList.add(selectedModel);
						}						
					});
				}
			});
			
			return outputList;
			
//			return classesSet.stream().filter(element -> 
//			(element.getParentElements() != null && (!element.getParentElements().isEmpty() || !element.getParentElements().isEmpty())) &&
//			(element.getParentElements().isEmpty() && isAssociatedWithAbstractLayer(element, classesSet)))
//					.collect(Collectors.toList());			
		}
		
		private boolean isAssociatedWithAbstractLayer(ModelElement specificElement, List<ModelElement> entireElementList) {
			List<ParentElement> parentList = specificElement.getParentElements();
			Stream<ModelElement> entireListStream = entireElementList.stream();
			//Stream specificElementsAssociateWithAbstractLayer = specificList.stream().filter(element -> 
			//element.getId() == entireListStream.filter(elementFromEntireList -> elementFromEntireList.getId() == element.getId()).findFirst().get().getId());
			
			boolean isAssociatedWithAbstractLayer = false;
			
			for(ParentElement item : parentList){
				ModelElement associatedParentItem = entireListStream.filter(element -> element.getId() == item.getParentId()).findFirst().get();
				if (associatedParentItem.getType() == "interface" || associatedParentItem.getType() == "abstract_class") {
					isAssociatedWithAbstractLayer = true;
					break;
				}
			}
			
			return isAssociatedWithAbstractLayer;
		}
}
