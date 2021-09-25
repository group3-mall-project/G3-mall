package com.g3.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;
import com.g3.service.BasketService;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	private static final Logger logger = LoggerFactory.getLogger(BasketController.class);
	
	@Inject
	private BasketService service;
	
	// 장바구니에 상품있으면 amount만큼 추가
	// 장바구니에 상품없으면 추가 @@@@@amount@@@@@ parameter 수정필요할수도있음
	@RequestMapping(value = "/addProductInBasket", method = RequestMethod.POST)
	@ResponseBody
	public String addProductInBasketPOST(@RequestParam("amount") int amount, Ad_ProductVO prod, HttpSession session) throws Exception {
		//ad product -> porduct 변경 고민@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String result = "added";
		logger.info(" C : addProductInBasket(Ad_ProductVO prod, HttpSession session) 호출");
		String id = (String) session.getAttribute("u_id");
		logger.info(" C : id : "+id);
		prod.setP_amount(amount);
		service.insertProductInBasket(prod,id);
		logger.info(" C : 장바구니추가완료");
		// 장바구니 중복 경우 id, p_name, p_option 같으면 개수 +a 필요
		return result;
	}
	
	//장바구니 메인 + get,post 둘다 되도록 method 지움
		@RequestMapping(value = "/main")
		public void basket(HttpSession session,Model model) throws Exception {
			String id = (String) session.getAttribute("u_id");
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			// order 페이지 주문/배송 간단조회 추가필요
			// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			logger.info(" C : basketList(HttpSession session,Model model) 호출");
			logger.info(" C : id : "+id);
			List<BasketVO> basketList = service.getBasketList(id);
			model.addAttribute("basketList", basketList);
			model.addAttribute("productList", service.getProductListToBasket(basketList));
			model.addAttribute("likeList", service.getLikeList(id));
			
			
			// ad_product - amount 조회해서 5개미만시
			// => 빨간글씨로 품절임박 *개 남음 표시 추가해야함 
		}
	
    // http://localhost:8088/basket/basketList
	//장바구니 목록 + get,post 둘다 되도록 method 지움
	@RequestMapping(value = "/basketList",method=RequestMethod.GET)
	public void basketListGET(HttpSession session,Model model) throws Exception {
		String id = (String) session.getAttribute("u_id");
		
		logger.info(" C : basketListGET(HttpSession session,Model model) 호출");
		logger.info(" C : id : "+id);
		List<BasketVO> basketList = service.getBasketList(id);
		model.addAttribute("basketList", basketList);
		model.addAttribute("productList", service.getProductListToBasket(basketList));
		// ad_product - amount 조회해서 5개미만시
		// => 빨간글씨로 품절임박 *개 남음 표시 추가해야함 
	}
	
	//장바구니 삭제
	@RequestMapping(value="/basketDel", method = RequestMethod.GET)
	public String basketDelGET(HttpSession session,int b_num) throws Exception{
		logger.info(" C : basketDelGET() 호출");
		service.basketDel(b_num);
		logger.info(" C : "+b_num+"장바구니 삭제완료");
		return "redirect:/basket/basketList";
	}
	
	// 장바구니 수량 증가
	@RequestMapping(value="/amountChange", method=RequestMethod.POST)
	public String amountIncreasePOST(HttpSession session, BasketVO vo) throws Exception{
		logger.info(" C : amountIncreasePOST() 호출");
		String id = (String) session.getAttribute("u_id");
		vo.setU_id(id);
		logger.info(" C : BasketVO : "+vo);
		service.amountChange(vo);
		logger.info(" C : 수량변경 성공 : 변경 수량"+vo.getB_p_amount());
		return "redirect:/basket/basketList";
	}
	
	// 찜목록
	@RequestMapping(value = "/likeList", method= RequestMethod.GET)
	public void likeList(HttpSession session,Model model) throws Exception {
		String id = (String) session.getAttribute("u_id");
		logger.info(" C : likeList(HttpSession session,Model model) 호출");
		logger.info(" C : id : "+id);
		model.addAttribute("like",service.getLikeList(id));
		//해당 찜 product 모든 옵션 품절여부 리턴받아서 품절인지아닌지
		// => 품절 o / x 여부만 
	}
	
	
}