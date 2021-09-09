package com.g3.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.g3.domain.Ad_ProductVO;
import com.g3.service.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
	
	// 서비스 객체를 주입
	@Inject
	private BasketService service;
	
	@RequestMapping(value = "/addProductInBasket", method = RequestMethod.GET)
	public void addProductInBasket(Ad_ProductVO prod, HttpSession session) throws Exception {
		//ad product -> porduct 변경 고민@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String id = (String) session.getAttribute("u_id");
		service.insertProductInBasket(prod,id);
		
		// 장바구니 중복 경우 id, p_name, p_option 같으면 개수 +a 필요
	}
	
	@RequestMapping(value = "/basketList",method = RequestMethod.GET)
	public String basketList(HttpSession session) throws Exception {
		String id = (String) session.getAttribute("u_id");
		
		List basketList = service.basketList(id);
		
		return "";
	}
	
	
}
