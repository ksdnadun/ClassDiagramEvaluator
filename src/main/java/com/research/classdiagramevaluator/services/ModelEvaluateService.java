package com.research.classdiagramevaluator.services;

import org.jvnet.hk2.annotations.Service;
import org.springframework.http.ResponseEntity;

import com.research.classdiagramevaluator.dto.ClassModelDTO;

@Service
public interface ModelEvaluateService {	

	ResponseEntity evaluateModel(ClassModelDTO classModelDTO);

}
