package com.citi.converted.testdrivendevelopment.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import com.citi.converted.testdrivendevelopment.Repository.TtdCrudRepository;
import com.citi.converted.testdrivendevelopment.entity.Convert;


public class TtdCrudServiceImplTest {
	
	@InjectMocks
	private TtdCrudServiceImpl serviceImpl;
	
	@Mock
	//@Autowired
	private TtdCrudRepository repo;
	
	//@Autowired
	@Mock
	private Convert convert = new Convert()   ;
	
	@Test
	public void testImpl() {
		
		String convertedUnit = "km-meter";
		
	when(repo.findByName(convertedUnit)).thenReturn(convert);
	
	when(serviceImpl.findByKey(convertedUnit)).thenReturn(String.class);
	assertThat(serviceImpl.findByKey(convertedUnit)).isEqualTo("*1000");
	
	}

}
