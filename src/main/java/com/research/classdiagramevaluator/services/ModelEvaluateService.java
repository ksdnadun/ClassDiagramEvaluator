package com.research.classdiagramevaluator.services;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.http.ResponseEntity;

import com.research.classdiagramevaluator.dto.ClassModelDTO;
import com.research.classdiagramevaluator.dto.ResultRule;

@Service
public interface ModelEvaluateService {	

	List<ResultRule> evaluateModel(ClassModelDTO classModelDTO);

}

