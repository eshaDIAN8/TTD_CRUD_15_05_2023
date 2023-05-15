package com.citi.converted.testdrivendevelopment.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.citi.converted.testdrivendevelopment.service.TtdCrudService;
import com.citi.converted.testdrivendevelopment.serviceImpl.TtdCrudServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest
@WebMvcTest(TtdCrudController.class)
@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class TtdConvertCrudControllerTest {

	/*@Value(value = "${local.server.port}")
	private int port;*/

	
	//@Mock
	private  MockMvc mockMvc;

	@Mock
	private MockMvcRequestBuilders mockMvcBuilder;

	@InjectMocks
	private  TtdCrudController controller;

	//@Autowired
	@Mock
	private TtdCrudService service  ;

	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	//expected = NullPointerException.class
	@Test()
	public void getFormulaFailureScenario() throws Exception {
		
	//	ObjectMapper mapper = new ObjectMapper();
		String convertedUnit = "km-meter";		
		//String convertedData1 =	"{\"convertedUnit\":\"km-meter\"}";
		String uri = "/getConvertedUnit/{convertedUnit}";
		when(service.findByKey(convertedUnit)).thenReturn("*1000");

	   /* String formula	=  (String) service.findByKey(convertedUnit);
	    System.out.println("formula"+formula);*/

	     MvcResult mvcResult = (MvcResult) mockMvc
		.perform(MockMvcRequestBuilders.get(uri,"km-meter"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("*1000")).andReturn();
		
	     //mapper.writeValueAsString(formula)
		Assert.assertEquals("/1000", mvcResult.getResponse().getContentAsString());

	}

	@Test
	public void getFormulaSuccessScenario() throws Exception {

		String convertedUnit = "km-meter";		
		//String convertedData1 =	"{\"convertedUnit\":\"km-meter\"}";
		String uri = "/getConvertedUnit/{convertedUnit}";
/*
	     String formula	=  (String) service.findByKey(convertedUnit);
	     System.out.println("formula"+formula);*/
		
		when(service.findByKey(convertedUnit)).thenReturn("*1000");

	     MvcResult mvcResult = (MvcResult) mockMvc
		.perform(MockMvcRequestBuilders.get(uri,"km-meter"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("*1000")).andReturn();
		
	     //mapper.writeValueAsString(formula)
		Assert.assertEquals("*1000", mvcResult.getResponse().getContentAsString());

	}

}
