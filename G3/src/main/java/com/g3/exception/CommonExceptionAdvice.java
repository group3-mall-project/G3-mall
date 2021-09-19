package com.g3.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// servlet-context.xml에서 해당 객체(bean)를 모든 예외를 처리하는 객체로 인식
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView errorModelAndView(Exception error) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/error_page");
		mav.addObject("error", error);
		mav.addObject("errorMsg", "실패");
		
		return mav;
		
	}
}
