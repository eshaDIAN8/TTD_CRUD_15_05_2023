package com.citi.converted.testdrivendevelopment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.converted.testdrivendevelopment.service.TtdCrudService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/getConvertedUnit")
@RestController
public class TtdCrudController {
	
	
	@Autowired
	private TtdCrudService service;
	
	ObjectMapper mapper = new ObjectMapper();
	
	String formula;
	@GetMapping("/{convertedUnit}")
	public ResponseEntity<String> getFormula(@PathVariable String convertedUnit) throws JsonProcessingException {
		
		try {
			if(service != null) {
	 formula =(String) service.findByKey(convertedUnit);
	 System.out.println("in controller::"+mapper.writeValueAsString(formula));
			}
		//mapper.writeValueAsString(formula);
			
			else {
				System.out.println("service object is null");
			}
	
		}catch(Exception e) {
			System.out.println("exception "+e);
			
		}
		
		return ResponseEntity.ok(mapper.writeValueAsString(formula));
		
		
		
	}

}
