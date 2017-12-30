package com.research.classdiagramevaluator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.research.classdiagramevaluator.dto.ClassModelDTO;
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
		
		//ResultRule couplingRule = identifyCouplingOfClasses(classModelDTO.getModelElements());
		resultRuleList.add(rule1);//couplingRule
		return resultRuleList;
	}
}
