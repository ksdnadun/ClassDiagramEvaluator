package com.research.classdiagramevaluator.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.research.classdiagramevaluator.dto.ClassModelDTO;
import com.research.classdiagramevaluator.services.ModelEvaluateService;

@Component
public class ModelEvaluatorServiceImpl implements ModelEvaluateService {

	@Override
	public ResponseEntity evaluateModel(ClassModelDTO classModelDTO) {
		return ResponseEntity.ok().body("Overriding parent class methods can generate problems while maintainig changes");
	}

}
