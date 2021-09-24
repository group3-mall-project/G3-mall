package com.g3.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.g3.domain.Criteria;
import com.g3.domain.OrderSearchVO;
import com.g3.domain.OrderVO;
import com.g3.domain.PageVO;
import com.g3.service.AdminOrderService;

// servlet-context.xml에서 Controller 객체(bean)로 인식
@Controller
@RequestMapping("/adminOrder/*")
public class AdminOrderController {
	private static final Logger logger 
		= LoggerFactory.getLogger(AdminOrderController.class);
	
	
	
	// AdminOrderService 객체 의존성 주입, 컨트롤러는 서버를 통해서만 실행가능
	@Inject
	private AdminOrderService aoservice;
	
	
	
	// 회원ID 검색
	// http://localhost:8088/adminOrder/userSearch (GET)
	@RequestMapping(value="/userSearch", method=RequestMethod.GET)
	public void searchUserOrderGET() throws Exception {
		System.out.println("Presentation(Controller): searchUserOrderGET() 호출\n");
		System.out.println("Presentation(Controller): searchUserOrderGET() 완료\n");
	}
	
	@RequestMapping(value="/userSearch", method=RequestMethod.POST)
	public String searchUserOrderPOST(String u_id, RedirectAttributes redir) throws Exception {
		System.out.println("Presentation(Controller): searchUserOrderPOST(String u_id, RedirectAttributes redir) 호출\n");
		
		redir.addAttribute("u_id", u_id);
		
		System.out.println("Presentation(Controller): searchUserOrderPOST(String u_id, RedirectAttributes redir) 완료\n");
		return "redirect:/adminOrder/singleUserOrdersOutput";
	}
	// 회원ID 검색

	

	// 회원별 주문조회
	// http://localhost:8088/adminOrder/singleUserOrdersOutput (GET)
	@RequestMapping(value="/singleUserOrdersOutput", method=RequestMethod.GET)
	public void outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) 호출\n");
		
		PageVO pvo = new PageVO(cri, aoservice.getNumOfOrders(u_id));
		model.addAttribute("listOfOrdersOfUser", aoservice.getListOfOrders(u_id, cri));	
		model.addAttribute("pvo", pvo);
		model.addAttribute("u_id", u_id);
		model.addAttribute("backDest", "singleUserOrdersOutput");
		
		System.out.println("Presentation(Controller): outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) 완료\n");
	}
	// 회원별 주문조회
	
	
	
	// 총 주문조회
	// http://localhost:8088/adminOrder/allUsersOrdersOutput (GET)
	@RequestMapping(value="/allUsersOrdersOutput", method=RequestMethod.GET)
	public void outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		// (String)session.getAttribute("u_id")
		PageVO pvo = new PageVO(cri, aoservice.getNumOfOrders("admin"));
		model.addAttribute("listOfOrdersOfAllUsers", aoservice.getListOfOrders("admin", cri));	
		model.addAttribute("pvo", pvo);	 
		model.addAttribute("backDest", "allUsersOrdersOutput");
		
		System.out.println("Presentation(Controller): outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}	 	 
	// 총 주문조회
	
	
	
	// 일일정산
	// http://localhost:8088/adminOrder/dailySumTotalOutput (GET)
	@RequestMapping(value="/dailySumTotalOutput", method=RequestMethod.GET)
	public void outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		cri.setNumOfItemsPerPage(31);
		PageVO pvo = new PageVO(cri, aoservice.getNumOfDailySumTotal());
		model.addAttribute("listOfDailySumTotal", aoservice.getListOfDailySumTotal(cri));
		model.addAttribute("pvo", pvo);	
		
		System.out.println("Presentation(Controller): outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 일일정산
	

	
	// 월별정산
	// http://localhost:8088/adminOrder/monthlySumTotalOutput (GET)	
	@RequestMapping(value="/monthlySumTotalOutput", method=RequestMethod.GET)
	public void outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		cri.setNumOfItemsPerPage(12);
		PageVO pvo = new PageVO(cri, aoservice.getNumOfMonthlySumTotal());
		model.addAttribute("listOfMonthlySumTotal", aoservice.getListOfMonthlySumTotal(cri));
		model.addAttribute("pvo", pvo);	
		
		System.out.println("Presentation(Controller): outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 월별정산
	
	
	
	// 주문검색
	// http://localhost:8088/adminOrder/orderSearch
	@RequestMapping(value="/orderSearch", method=RequestMethod.GET)
	public void searchOrderGET() throws Exception {
		System.out.println("Presentation(Controller): searchOrderGET() 호출\n");
		System.out.println("Presentation(Controller): searchOrderGET() 완료\n");
	}
	
	
	
	@RequestMapping(value="/orderSearch", method=RequestMethod.POST)
	public String searchOrderPOST(OrderSearchVO osvo, HttpSession session) throws Exception {
		System.out.println("Presentation(Controller): searchOrderPOST(OrderSearchVO osvo, HttpSession session) 호출\n");
		
		session.setAttribute("osvo", osvo);
		
		System.out.println("Presentation(Controller): searchOrderPOST(OrderSearchVO osvo, HttpSession session) 완료\n");
		return "redirect:/adminOrder/orderSearchOutput";
	}
	
	
	
	@RequestMapping(value="/orderSearchOutput", method=RequestMethod.GET)
	public void outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		OrderSearchVO osvo = (OrderSearchVO)session.getAttribute("osvo");
		PageVO pvo = new PageVO(cri, aoservice.getNumOfOrderSearch(osvo));
		model.addAttribute("listOfOrderSearch", aoservice.getListOfOrderSearch(osvo, cri));
		model.addAttribute("pvo", pvo);	
		model.addAttribute("backDest", "orderSearchOutput");
		
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 주문검색
	
	
	
	// 주문 상세정보
	@RequestMapping(value="/orderDetailOutput", method=RequestMethod.GET)
	public void outputOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) throws Exception {
		System.out.println("Presentation(Controller): outputOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) 호출\n");
		
		String trackingNumber = aoservice.getTrackingNumber(o_d_num);
		
		// 배송장 번호가 없을 경우, 의사 난수로 생성
		if(trackingNumber == null) {
			String o_way_num = aoservice.generateUniqueTrackingNumber();
			aoservice.addTrackingNumber(o_d_num, o_way_num);
		}

		model.addAttribute("listOfOrderDetail", aoservice.getOrderDetail(o_d_num));
		model.addAttribute("o_d_num", o_d_num);
		model.addAttribute("backDest", backDest);
		model.addAttribute("currentPageNum", currentPageNum);
		model.addAttribute("numOfItemsPerPage", numOfItemsPerPage);
		model.addAttribute("u_id", u_id);
		
		System.out.println("Presentation(Controller): outputOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) 완료\n");	
	}
	// 주문 상세정보
	
	
	
	//주문 상세정보 수정
	@RequestMapping(value="/orderDetailEdit", method=RequestMethod.GET)
	public void editOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) throws Exception {
		System.out.println("Presentation(Controller): editOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) 호출\n");
		
		model.addAttribute("listOfOrderDetail", aoservice.getOrderDetail(o_d_num));
		model.addAttribute("o_d_num", o_d_num);
		model.addAttribute("backDest", backDest);
		model.addAttribute("currentPageNum", currentPageNum);
		model.addAttribute("numOfItemsPerPage", numOfItemsPerPage);
		model.addAttribute("u_id", u_id);
		
		System.out.println("Presentation(Controller): editOrderDetailGET(String o_d_num, String backDest, String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage) 완료\n");		
	}

	
	@RequestMapping(value="/orderDetailEdit", method=RequestMethod.POST)
	public String editOrderDetailPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir, OrderVO ovo) throws Exception {
		System.out.println("Presentation(Controller): editOrderDetailPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir, OrderVO ovo) 호출\n");
		
		redir.addAttribute("o_d_num", o_d_num);
		redir.addAttribute("backDest", backDest);
		redir.addAttribute("currentPageNum", currentPageNum);
		redir.addAttribute("numOfItemsPerPage", numOfItemsPerPage);
		redir.addAttribute("u_id", u_id);
		aoservice.editOrderDetail(ovo);
		
		System.out.println("Presentation(Controller): editOrderDetailPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir, OrderVO ovo) 완료\n");	
		
		return "redirect:/adminOrder/orderDetailOutput";
	}
	// 주문 상세정보 수정
	
	
	
	// 주문취소
	@RequestMapping(value="/orderCancel", method=RequestMethod.POST)
	public String cancelOrderPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir) throws Exception {
		System.out.println("Presentation(Controller): cancelOrderPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir) 호출\n");
		
		redir.addAttribute("o_d_num", o_d_num);
		redir.addAttribute("backDest", backDest);
		redir.addAttribute("currentPageNum", currentPageNum);
		redir.addAttribute("numOfItemsPerPage", numOfItemsPerPage);
		redir.addAttribute("u_id", u_id);		
		aoservice.cancelOrder(o_d_num);
		
		System.out.println("Presentation(Controller): cancelOrderPOST(String o_d_num, String backDest, String u_id, Integer currentPageNum, Integer numOfItemsPerPage, RedirectAttributes redir) 완료\n");		
		
		switch(backDest) {
			case "allUsersOrdersOutput":
				return "redirect:/adminOrder/allUsersOrdersOutput";
			case "singleUserOrdersOutput":
				return "redirect:/adminOrder/singleUserOrdersOutput";
			default:
				return "redirect:/adminOrder/orderSearchOutput";
		}
	}	
	// 주문취소
}
