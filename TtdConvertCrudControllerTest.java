package com.citi.converted.testdrivendevelopment.controller;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

//@SpringBootTest
//@WebMvcTest(TtdCrudController.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class TtdConvertCrudControllerTest {

	@Value(value = "${local.server.port}")
	private int port;

	//@Mock
	private  MockMvc mockMvc;

	@Mock
	private MockMvcRequestBuilders mockMvcBuilder;

	@Autowired
	private  TtdCrudController controller;

	@Autowired
	private TtdCrudService service;

	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	//expected = NullPointerException.class
	@Test()
	public void getFormulaFailureScenario() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		String convertedUnit = "km-meter";		
		String convertedData1 =	"{\"convertedUnit\":\"km-meter\"}";
		String uri = "/getConvertedUnit/{convertedUnit}";

	     String formula	= (String) service.findByKey(convertedUnit);
	     System.out.println("formula"+formula);

	     MvcResult mvcResult = (MvcResult) mockMvc
		.perform(MockMvcRequestBuilders.get(uri,"km-meter"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("*1000")).andReturn();
		
		Assert.assertEquals(mapper.writeValueAsString(formula), mvcResult.getResponse());

	}

	@Test
	public void getFormulaSuccessScenario() throws Exception {

		String convertedUnit = "km-meter";
		String uri = "/getConvertedUnit/{convertedUnit}";

		when(service.findByKey(convertedUnit)).thenReturn(String.class);

		MvcResult mvcResult = (MvcResult) mockMvc.perform(
				(RequestBuilder) ((ResultActions) MockMvcRequestBuilders.get(uri).param(convertedUnit, "km-meter"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().string("*1000")));
	}

}
