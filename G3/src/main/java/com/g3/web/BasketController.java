package com.g3.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.g3.domain.BasketVO;
import com.g3.service.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
	
	// 서비스 객체를 주입
	@Inject
	private BasketService service;
	private BasketVO bvo;
	
	
	@RequestMapping(value = "/addProductInBasket", method = RequestMethod.POST)
	public String addProductInBasket(@RequestParam("p_num") int p_num, HttpSession session) throws Exception {
		
		String id = (String) session.getAttribute("u_id");
		
		bvo.setU_id(id);
		
		return "";
	}
	
	
	
	
	
	
	
}
