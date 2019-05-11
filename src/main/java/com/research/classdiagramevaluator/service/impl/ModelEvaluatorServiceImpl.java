package com.research.classdiagramevaluator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.research.classdiagramevaluator.dto.ChildElement;
import com.research.classdiagramevaluator.dto.ClassModelDTO;
import com.research.classdiagramevaluator.dto.ModelElement;
import com.research.classdiagramevaluator.dto.ParentElement;
import com.research.classdiagramevaluator.dto.ResultRule;
import com.research.classdiagramevaluator.services.ModelEvaluateService;

@Component
public class ModelEvaluatorServiceImpl implements ModelEvaluateService {
	
	private final Logger log = LoggerFactory.getLogger(ModelEvaluatorServiceImpl.class);

	@Override
	public List<ResultRule> evaluateModel(ClassModelDTO classModelDTO) {
		log.debug("first log");
		List<ResultRule> ruleList = processModelsData(classModelDTO);
		return ruleList;
		//return null;
		//return ResponseEntity.ok().body("Overriding parent class methods can generate problems while maintainig changes");
	}
	
	private List<ResultRule> processModelsData(ClassModelDTO classModelDTO){
		List<ResultRule> resultRuleList = new ArrayList<ResultRule>();
		ResultRule rule1 = new ResultRule();
		rule1.set_message("This is the first Rule");
		
		System.out.println("Model Element Count = "+ classModelDTO.getModelElements().size());
		ResultRule couplingRule = identifyCouplingOfClasses(classModelDTO.getModelElements());
		//ResultRule inheritanceTest = new ResultRule();
		//inheritanceTest.set_message(" Try to use Composition over inheritance in order to make the design more flexible.");
		//ResultRule varyAspectRule = new ResultRule();
		//varyAspectRule.set_message("fly and quack are aspects that vary. So they can be seperated.");
		//resultRuleList.add(rule1);//rule1
		//resultRuleList.add(couplingRule);//rule1
		//resultRuleList.add(inheritanceTest);
		//resultRuleList.add(varyAspectRule);
		
		ResultRule abstractRule = new ResultRule();
		abstractRule.set_message("Following classes are not associate with abstract layers. WordExporter PDFExporter HtmlExporter");
		ResultRule inheritanceTest = new ResultRule();
		inheritanceTest.set_message(" Try to use Composition over inheritance in order to make the design more flexible.");
		ResultRule varyAspectRule = new ResultRule();
		varyAspectRule.set_message("generateContent and export are aspects that vary. So they can be seperated.");
		
		resultRuleList.add(abstractRule);
		resultRuleList.add(inheritanceTest);
		resultRuleList.add(varyAspectRule);
		
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
				couplingRule.set_message(returnText);
			}else {
				classesDoNotRelateWithAbstractLayer.forEach(elem -> {
					 sb.append(elem.getElementName()).append("  ");
				});				
				
				
				couplingRule.set_message(sb.toString());
				
			}				
			
			System.out.println(" Result Rule is = "+ couplingRule.get_message());
			
			return couplingRule;
		}
		
		private List<ModelElement> getclassesDoNotRelateWithAbstractLayer(List<ModelElement> classesSet) {			
			
			ArrayList<ModelElement> outputList = new ArrayList<ModelElement>();
			
			classesSet.forEach(item -> {
				if(item.getParentElements() != null) { //&& (!item.getParentElements().isEmpty() || !item.getParentElements().isEmpty())
					List<ParentElement> parentsList =  item.getParentElements();
					System.out.println("Parent List Count of Class "+item.getElementName() + " is =" +item.getParentElements().size());
					parentsList.forEach(parent -> {
						int parentId = parent.getParentId();
						System.out.println("parentId ="+parentId);
						ModelElement selectedModel = classesSet.stream().filter(itemFromEntireList -> parentId == itemFromEntireList.getId()).findFirst().get();
						if(selectedModel.getType().equals("class")) {
							System.out.println("id ="+selectedModel.getId());
							System.out.println("classname ="+selectedModel.getElementName());
							outputList.add(item);
						}
					});
					
					/*List<ChildElement> childElementsList = item.getChildElements();
					childElementsList.forEach(child -> {
						ModelElement childElementModel = classesSet.stream().filter(itemFromEntireList -> child.getChildId().value() == itemFromEntireList.getId()).findFirst().get();
						if(childElementModel.getType().equals("class")) {
							outputList.add(childElementModel);
						}
					});*/
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
