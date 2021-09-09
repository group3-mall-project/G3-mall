package com.g3.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.g3.domain.SearchOrderVO;
import com.g3.service.AdminOrderService;


@Controller
@RequestMapping("/adminOrder/*")
public class AdminOrderController {
	private static final Logger logger 
		= LoggerFactory.getLogger(AdminOrderController.class);
	
	// AdminOrderService 객체 의존성 주입, 컨트롤러는 서버를 통해서만 실행가능
	@Inject
	private AdminOrderService aoservice;
	
	// 회원별 주문조회
	// http://localhost:8088/controller/adminOrder/singleUser (GET)
	@RequestMapping(value="/singleUser", method=RequestMethod.GET)
	public void displayAllOrdersOfUserGET(HttpSession session, Model model) throws Exception {
		// 세션값 없을 경우
		//String u_id = (String)session.getAttribute("u_id");
		String u_id = "user3";
		//if(u_id == null) {
			// TO-DO
		//}
		
		model.addAttribute("allOrdersOfUserList", aoservice.getAllOrdersOfUser(u_id));
	}
	// 회원별 주문조회
	
	
	// 총 주문조회
	// http://localhost:8088/controller/adminOrder/allUser (GET)
	@RequestMapping(value="/allUsers", method=RequestMethod.GET)
	public void displayAllOrdersOfAllUsersGET(HttpSession session, Model model) throws Exception {
		// 세션값 없을 경우
		//String u_id = (String)session.getAttribute("u_id");
		String u_id = "admin";
		//if(u_id == null) {
			// TO-DO
		//}
		
		model.addAttribute("allOrdersOfAllUsersList", aoservice.getAllOrdersOfAllUsers(u_id));
	}
	// 총 주문조회
	
	
	// 일일정산
	// http://localhost:8088/controller/adminOrder/dailyTotal (GET)
	@RequestMapping(value="/dailyTotal", method=RequestMethod.GET)
	public void displayDailyTotalGET(HttpSession session, Model model) throws Exception {
		// 세션값 없을 경우
		//String u_id = (String)session.getAttribute("u_id");
		//if(u_id == null) {
			// TO-DO
		//}
		model.addAttribute("dailySumTotalList", aoservice.getDailySumTotal());
	}
	// 일일정산
	
	
	// 월별정산
	// http://localhost:8088/controller/adminOrder/monthlyTotal (GET)	
	@RequestMapping(value="/monthlyTotal", method=RequestMethod.GET)
	public void displayMonthlyTotalGET(HttpSession session, Model model) throws Exception {
		// 세션값 없을 경우
		//String u_id = (String)session.getAttribute("u_id");
		//if(u_id == null) {
			// TO-DO
		//}		
		model.addAttribute("monthlySumTotalList", aoservice.getMonthlySumTotal());
	}
	// 월별정산
	
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// Work in progress
	// 주문검색
	// http://localhost:8088/controller/adminOrder/orderSearch
	@RequestMapping(value="/orderSearch", method=RequestMethod.GET)
	public String inputOrderSearchGET() throws Exception {
		
		return "/adminOrder/ex_searchOrder";
	}
	
	@RequestMapping(value="/orderSearch", method=RequestMethod.POST)
	public String inputOrderSearchPOST(SearchOrderVO svo) throws Exception {
		System.out.println("inquiryPeriod: "+svo.getInquiryPeriod());
		System.out.println("beginningDate: "+svo.getBeginningDate());
		System.out.println("endDate: "+svo.getEndDate());
		System.out.println("advancedSearch: "+svo.getAdvancedSearch());
		System.out.println("userQuery: "+svo.getUserQuery());
		
		return "/adminOrder/ex_displaySearchOrder";
	}
	// 주문검색
	// Work in progress
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
}
