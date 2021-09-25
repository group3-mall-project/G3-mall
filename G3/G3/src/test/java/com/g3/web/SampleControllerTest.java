package com.g3.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



//@RunWith
//@WebAppConfiguration
//@ContextConfiguration
//=> spring MVC로 테스트 하겠다 (웹 O)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class SampleControllerTest {
	
	// 테스트 파일을 사용해서 WAS의 동작 수행(스프링3.2~이후 가능)
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMVC;
	
	@Before
	public void setup() {
		logger.info("setup() 메서드 호출! (테스트 전에 준비되는 동작)");
		
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		logger.info("mockMVC 객체 준비 완료! ");
	}
	
	@Test
	public void testMain() throws Exception{
		logger.info("testMain() 메서드 호출 : 컨트롤러 역활");
		
		mockMVC.perform(MockMvcRequestBuilders.get("/main"));
		
	}
	
	
	
	
}
