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
	
	public void processPaging(String u_id, Model model, Integer currentPageNum, Integer numOfItemsPerPage, Integer choice, OrderSearchVO osvo) {
		
		// 회원별 주문조회, 총 주문조회 -> 사용자 ID(u_id) 필요 
		
		// 현재 페이지 번호(currentPageNum) 필요
	
		// 한 페이지에 출력할 항목의 개수(numOfItemsPerPage) <- 사용자 입력값 
		
		// 선택값(choice)
		
		// osvo -> 주문검색 필요
			
		// 현제 페이지 번호
		if(currentPageNum == null)
			currentPageNum = 1;
		
		// DB 시작번호
		Integer beginNumOfItems = (currentPageNum-1)*numOfItemsPerPage+1;
		
		// 한 페이지에서 보여줄 페이지 번호의 개수 <- 관리자 지정
		Integer numOfPagesPerPage = 3;
		
		// 전체 항목의 개수
		Integer numOfItems = 0;
		
		// choice 값에 따라서 회원별 주문조회, 총 주문조회, 일일정산, 월별정산, 주문검색
		switch(choice) {
			// 회원별 주문조회
			case 1:
				// 
				//numOfItems = aoservice.getNumOfAllOrdersOfUser(u_id);
				//model.addAttribute("listOfAllOrdersOfUser", aoservice.getListOfAllOrdersOfUser(u_id, beginNumOfItems, numOfItemsPerPage));
				break;
			// 총 주문조회
			case 2:
				//numOfItems = aoservice.getNumOfAllOrdersOfAllUsers(u_id);
				//model.addAttribute("listOfAllOrdersOfAllUsers", aoservice.getListOfAllOrdersOfAllUsers(u_id, beginNumOfItems, numOfItemsPerPage));
				break;
			// 일일정산
			case 3:
				//numOfItems = aoservice.getNumOfDailySumTotal();
				//model.addAttribute("listOfDailySumTotal", aoservice.getListOfDailySumTotal(beginNumOfItems, numOfItemsPerPage));
				break;
			// 월별정산
			case 4:
				//numOfItems = aoservice.getNumOfMonthlySumTotal();
				//model.addAttribute("listOfMonthlySumTotal", aoservice.getListOfMonthlySumTotal(beginNumOfItems, numOfItemsPerPage));
				break;
			// 주문검색
			case 5:
				numOfItems = aoservice.getNumOfSearchOrder(osvo);
				model.addAttribute("listOfOrderSearch", aoservice.getListOfSearchOrder(osvo, beginNumOfItems, numOfItemsPerPage));
				break;
		}
		
		// 페이지 개수
		Integer numOfPages = numOfItems/numOfItemsPerPage + ((numOfItems%numOfItemsPerPage == 0) ? 0 : 1);
				
		// 페이지 시작번호
		Integer beginNumOfPage = ((currentPageNum-1)/numOfPagesPerPage)*numOfPagesPerPage+1;
		
		// 페이지 끝번호
		Integer endNumOfPage = beginNumOfPage+numOfPagesPerPage-1;
		
		// 만약 끝번호가 총 페이지 개수보다 크면
		if(endNumOfPage > numOfPages)
			endNumOfPage = numOfPages;
		
		model.addAttribute("numOfItems", numOfItems);
		model.addAttribute("numOfPages", numOfPages);
		model.addAttribute("numOfPagesPerPage", numOfPagesPerPage);
		model.addAttribute("beginNumOfPage", beginNumOfPage);
		model.addAttribute("endNumOfPage", endNumOfPage);
	}
	
	

	// 회원별 주문조회
	// http://localhost:8088/controller/adminOrder/singleUserOrdersOutput (GET)
	@RequestMapping(value="/singleUserOrdersOutput", method=RequestMethod.GET)
	public void outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) 호출\n");
		
		PageVO pvo = new PageVO(cri, aoservice.getNumOfOrders(u_id));
		model.addAttribute("listOfOrdersOfUser", aoservice.getListOfOrders(u_id, cri));	
		model.addAttribute("pvo", pvo);
		model.addAttribute("u_id", u_id);
		
		System.out.println("Presentation(Controller): outputListOfOrdersOfSingleUserGET(Model model, Criteria cri, String u_id) 완료\n");
	}
	// 회원별 주문조회
	
	
	
	// 총 주문조회
	// http://localhost:8088/controller/adminOrder/allUsersOrdersOutput (GET)
	@RequestMapping(value="/allUsersOrdersOutput", method=RequestMethod.GET)
	public void outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		// (String)session.getAttribute("u_id")
		PageVO pvo = new PageVO(cri, aoservice.getNumOfOrders("admin"));
		model.addAttribute("listOfOrdersOfAllUsers", aoservice.getListOfOrders("admin", cri));	
		model.addAttribute("pvo", pvo);	 
		
		System.out.println("Presentation(Controller): outputListOfOrdersOfAllUsersGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}	 	 
	// 총 주문조회
	
	
	
	// 일일정산
	// http://localhost:8088/controller/adminOrder/dailySumTotalOutput (GET)
	@RequestMapping(value="/dailySumTotalOutput", method=RequestMethod.GET)
	public void outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		PageVO pvo = new PageVO(cri, aoservice.getNumOfDailySumTotal());
		model.addAttribute("listOfDailySumTotal", aoservice.getListOfDailySumTotal(cri));
		model.addAttribute("pvo", pvo);	
		
		System.out.println("Presentation(Controller): outputListOfDailySumTotalGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 일일정산
	

	
	// 월별정산
	// http://localhost:8088/controller/adminOrder/monthlySumTotalOutput (GET)	
	@RequestMapping(value="/monthlySumTotalOutput", method=RequestMethod.GET)
	public void outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		PageVO pvo = new PageVO(cri, aoservice.getNumOfMonthlySumTotal());
		model.addAttribute("listOfMonthlySumTotal", aoservice.getListOfMonthlySumTotal(cri));
		model.addAttribute("pvo", pvo);	
		
		System.out.println("Presentation(Controller): outputListOfMonthlySumTotalGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 월별정산
	
	
	
	// 주문검색
	// http://localhost:8088/controller/adminOrder/orderSearch
	@RequestMapping(value="/orderSearch", method=RequestMethod.GET)
	public void searchOrderGET() throws Exception {
		System.out.println("Presentation(Controller): searchOrderGET() 호출\n");
		System.out.println("Presentation(Controller): searchOrderGET() 완료\n");
	}
	
	
	
	@RequestMapping(value="/orderSearch", method=RequestMethod.POST)
	public String searchOrderPOST(OrderSearchVO osvo, HttpSession session) throws Exception {
		System.out.println("Presentation(Controller): searchOrderPOST 호출\n");
		
		System.out.println(osvo);
		session.setAttribute("osvo", osvo);
		
		System.out.println("Presentation(Controller): searchOrderPOST 완료\n");
		return "redirect:/adminOrder/orderSearchOutput";
	}
	
	
	
	/*@RequestMapping(value="/orderSearchOutput", method=RequestMethod.GET)
	public void outputListOfOrderSearchGET(HttpSession session, Model model, Integer currentPageNum) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Integer currentPageNum) 호출\n");
		
		OrderSearchVO osvo = (OrderSearchVO)session.getAttribute("osvo");
		processPaging(null, model, currentPageNum, 1, 5, osvo);
		
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Integer currentPageNum) 완료\n");
	}*/
	
	@RequestMapping(value="/orderSearchOutput", method=RequestMethod.GET)
	public void outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) throws Exception {
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) 호출\n");
		
		OrderSearchVO osvo = (OrderSearchVO)session.getAttribute("osvo");
		
		numOfItems = aoservice.getNumOfSearchOrder(osvo);
		model.addAttribute("listOfOrderSearch", aoservice.getListOfSearchOrder(osvo, beginNumOfItems, numOfItemsPerPage));
	//	processPaging(null, model, currentPageNum, 1, 5, osvo);
		
		System.out.println("Presentation(Controller): outputListOfOrderSearchGET(HttpSession session, Model model, Criteria cri) 완료\n");
	}
	// 주문검색
	
	
	
	// 주문 상세정보
	@RequestMapping(value="/orderDetailOutput", method=RequestMethod.GET)
	public void outputOrderDetailGET(Integer o_d_num, Model model) throws Exception {
		System.out.println("Presentation(Controller): outputOrderDetailGET(Integer o_num, Model model) 호출\n");
		
		String trackingNumber = aoservice.getTrackingNumber(o_d_num);
		
		// 배송장 번호가 없을 경우, 의사 난수로 생성
		if(trackingNumber == null) {
			String o_way_num = aoservice.generateUniqueTrackingNumber();
			aoservice.addTrackingNumber(o_d_num, o_way_num);
		}

		model.addAttribute("listOfOrderDetail", aoservice.getOrderDetail(o_d_num));
		
		System.out.println("Presentation(Controller): outputOrderDetailGET(Integer o_num, Model model) 완료\n");	
	}
	// 주문 상세정보
	
	
	
	//주문 상세정보 수정
	@RequestMapping(value="/orderDetailEdit", method=RequestMethod.GET)
	public void editOrderDetailGET(Integer o_d_num, Model model) throws Exception {
		System.out.println("Presentation(Controller): editOrderDetailGET(Integer o_d_num) 호출\n");
		
		model.addAttribute("listOfOrderDetail", aoservice.getOrderDetail(o_d_num));
		
		System.out.println("Presentation(Controller): editOrderDetailGET(Integer o_d_num) 완료\n");		
	}

	
	@RequestMapping(value="/orderDetailEdit", method=RequestMethod.POST)
	public String editOrderDetailPOST(Integer o_d_num, RedirectAttributes redir, OrderVO ovo) throws Exception {
		System.out.println("Presentation(Controller): editOrderDetailPOST(Integer o_d_num) 호출\n");
		
		System.out.println(ovo);
		redir.addAttribute("o_d_num", o_d_num);
		aoservice.editOrderDetail(ovo);
		
		System.out.println("Presentation(Controller): editOrderDetailPOST(Integer o_d_num) 완료\n");	
		
		return "redirect:/adminOrder/orderDetailOutput";
	}
	// 주문 상세정보 수정
	
	
	
	// 주문취소
	@RequestMapping(value="/orderCancel", method=RequestMethod.POST)
	public String cancelOrderPOST(Integer o_d_num) throws Exception {
		System.out.println("Presentation(Controller): cancelOrderPOST(Integer o_d_num) 호출\n");
		
		aoservice.cancelOrder(o_d_num);
		
		System.out.println("Presentation(Controller): cancelOrderPOST(Integer o_d_num) 완료\n");		
		
		return "redirect:/adminOrder/allUsersOrdersOutput";
	}	
	// 주문취소
}
