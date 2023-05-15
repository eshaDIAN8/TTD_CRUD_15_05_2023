package com.citi.converted.testdrivendevelopment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.converted.testdrivendevelopment.Repository.TtdCrudRepository;
import com.citi.converted.testdrivendevelopment.entity.Convert;
import com.citi.converted.testdrivendevelopment.service.TtdCrudService;


@Service
public class TtdCrudServiceImpl implements TtdCrudService{
	
	@Autowired
	TtdCrudRepository repo;
	
	//@Autowired
	Convert convert = new Convert();

	@Override
	public Object findByKey(String convertedUnit) {
		
	 convert =	repo.findByName(convertedUnit);
		
		return convert.getFormula();
	}

}
