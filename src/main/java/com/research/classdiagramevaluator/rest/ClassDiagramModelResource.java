package com.research.classdiagramevaluator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.research.classdiagramevaluator.dto.ClassModelDTO;
import com.research.classdiagramevaluator.dto.ResultRule;
import com.research.classdiagramevaluator.services.ModelEvaluateService;

//@EnableOAuth2Sso
@RestController
@RequestMapping("/api/v1")
public class ClassDiagramModelResource {	
	
	@Autowired
	ModelEvaluateService modelEvaluateService;	
	
	@ResponseStatus(code = HttpStatus.OK)
	//@ResponseBody()
	@PostMapping("/classmodel")
	public ResponseEntity createClassModel(@RequestBody ClassModelDTO classModelDTO){
		List<ResultRule> result = modelEvaluateService.evaluateModel(classModelDTO);
		return ResponseEntity.ok().body(result);
	}

}
