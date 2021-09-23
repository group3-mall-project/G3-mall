package com.g3.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.g3.domain.OrderSearchVO;
import com.g3.domain.OrderVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class AdminOrderDAOTest {
	
	// AdminOrderDAO 객체 의존성 주입
	@Inject
	private AdminOrderDAO aodao;
	
	/*
	// 회원별 주문조회
	//@Test
	public void testGetAllOrdersOfUser() throws Exception {
		List<OrderVO> allOrdersOfUserList;
		
		allOrdersOfUserList = aodao.getAllOrdersOfUser("user3");
		
		for(int i = 0; i < allOrdersOfUserList.size(); i++) {
			OrderVO ovo = allOrdersOfUserList.get(i);
			
			// 아이디
			System.out.println("");			
			System.out.println("동일 아이디: "+ovo.getU_id());
			System.out.println("");
			
			// 주문 테이블
			System.out.println("주문 테이블번호(o_num): "+ovo.getO_num());
			
			
			// 주문정보
			System.out.println("주문번호(o_d_num): "+ovo.getO_d_num());
			System.out.println("주문한 상품번호(o_p_num): "+ovo.getO_p_num());
			System.out.println("주문한 상품이름(o_p_name): "+ovo.getO_p_name());
			System.out.println("주문한 상품수량(o_p_amount): "+ovo.getO_p_amount());
			System.out.println("주문한 상품옵션(o_p_option): "+ovo.getO_p_option());
			System.out.println("주문한 아이디(u_id): "+ovo.getU_id());
			
			
			// 배송정보
			System.out.println("배송받는 사람이름(o_d_name): "+ovo.getO_d_name());
			System.out.println("배송받는 주소(o_d_add): "+ovo.getO_d_add());
			System.out.println("배송받는 전화번호(o_d_phone): "+ovo.getO_d_phone());
			System.out.println("배송 메세지(o_d_msg): "+ovo.getO_d_msg());
			
			
			// 결제정보
			System.out.println("총 결제금액(o_sum_money): "+ovo.getO_sum_money());
			System.out.println("결제종류(o_acc_type): "+ovo.getO_acc_type());
			System.out.println("결제하는 사람(o_acc_payer): "+ovo.getO_acc_payer());
			System.out.println("결제하는 날짜(o_acc_date): "+ovo.getO_acc_date());
			
			// 배송정보
			System.out.println("운송장 번호(o_way_num): "+ovo.getO_way_num());
			System.out.println("주문날짜(o_date): "+ovo.getO_date());
			System.out.println("주문상태(o_status): "+ovo.getO_status());
		}
		
	}
	// 회원별 주문조회
	
	
	// 총 주문조회
	//@Test
	public void testGetAllOrdersOfAllUsers() throws Exception {
		List<OrderVO> allOrdersOfAllUsersList;
		
		allOrdersOfAllUsersList = aodao.getAllOrdersOfAllUsers("admin");
		
		for(int i = 0; i < allOrdersOfAllUsersList.size(); i++) {
			OrderVO ovo = allOrdersOfAllUsersList.get(i);
			
			// 주문 테이블
			System.out.println("");
			System.out.println("주문 테이블번호(o_num): "+ovo.getO_num());
			
			
			// 주문정보
			System.out.println("주문번호(o_d_num): "+ovo.getO_d_num());
			System.out.println("주문한 상품번호(o_p_num): "+ovo.getO_p_num());
			System.out.println("주문한 상품이름(o_p_name): "+ovo.getO_p_name());
			System.out.println("주문한 상품수량(o_p_amount): "+ovo.getO_p_amount());
			System.out.println("주문한 상품옵션(o_p_option): "+ovo.getO_p_option());
			System.out.println("주문한 아이디(u_id): "+ovo.getU_id());
			
			
			// 배송정보
			System.out.println("배송받는 사람이름(o_d_name): "+ovo.getO_d_name());
			System.out.println("배송받는 주소(o_d_add): "+ovo.getO_d_add());
			System.out.println("배송받는 전화번호(o_d_phone): "+ovo.getO_d_phone());
			System.out.println("배송 메세지(o_d_msg): "+ovo.getO_d_msg());
			
			
			// 결제정보
			System.out.println("총 결제금액(o_sum_money): "+ovo.getO_sum_money());
			System.out.println("결제종류(o_acc_type): "+ovo.getO_acc_type());
			System.out.println("결제하는 사람(o_acc_payer): "+ovo.getO_acc_payer());
			System.out.println("결제하는 날짜(o_acc_date): "+ovo.getO_acc_date());
			
			// 배송정보
			System.out.println("운송장 번호(o_way_num): "+ovo.getO_way_num());
			System.out.println("주문날짜(o_date): "+ovo.getO_date());
			System.out.println("주문상태(o_status): "+ovo.getO_status());
		}
	}
	// 총 주문조회
	
	
	// 일일정산
	//@Test
	public void testGetDailySumTotal() throws Exception {
		List<OrderVO> dailySumTotalList;
		
		dailySumTotalList = aodao.getDailySumTotal();
		
		for(int i = 0; i < dailySumTotalList.size(); i++) {
			OrderVO ovo = dailySumTotalList.get(i);

			System.out.println("일일정산: "+ovo.getO_sum_money()+", "+"날짜: "+ovo.getO_acc_date());
		}
		
	}
	// 일일정산
	
	
	// 월별정산
	//@Test
	public void testGetMonthlySumTotal() throws Exception {
		List<OrderVO> monthlySumTotalList;
		
		monthlySumTotalList = aodao.getMonthlySumTotal();
		
		for(int i = 0; i < monthlySumTotalList.size(); i++) {
			OrderVO ovo = monthlySumTotalList.get(i);
			System.out.println("월별정산: "+ovo.getO_sum_money()+", 연: "+ovo.getO_p_num()+", 월: "+ovo.getO_p_amount());
		}
	}
	// 월별정산
	
	
	// 주문검색
	//@Test
	public void testSearchOrder() throws Exception {
		List<OrderVO> orderSearchList;
		
		OrderSearchVO osvo = new OrderSearchVO();
		
		osvo.setInquiryPeriod("");
		osvo.setBeginningDate("2000-01-01");
		osvo.setEndDate("2021-10-31");
		osvo.setAdvancedSearch("receiverName");
		osvo.setUserQuery("user2");
		
		orderSearchList = aodao.searchOrder(osvo);
		
		for(int i = 0; i < orderSearchList.size(); i++) {
			OrderVO ovo = orderSearchList.get(i);
			
			// 주문 테이블
			System.out.println("");
			System.out.println("주문 테이블번호(o_num): "+ovo.getO_num());
			
			
			// 주문정보
			System.out.println("주문번호(o_d_num): "+ovo.getO_d_num());
			System.out.println("주문한 상품번호(o_p_num): "+ovo.getO_p_num());
			System.out.println("주문한 상품이름(o_p_name): "+ovo.getO_p_name());
			System.out.println("주문한 상품수량(o_p_amount): "+ovo.getO_p_amount());
			System.out.println("주문한 상품옵션(o_p_option): "+ovo.getO_p_option());
			System.out.println("주문한 아이디(u_id): "+ovo.getU_id());
			
			
			// 배송정보
			System.out.println("배송받는 사람이름(o_d_name): "+ovo.getO_d_name());
			System.out.println("배송받는 주소(o_d_add): "+ovo.getO_d_add());
			System.out.println("배송받는 전화번호(o_d_phone): "+ovo.getO_d_phone());
			System.out.println("배송 메세지(o_d_msg): "+ovo.getO_d_msg());
			
			
			// 결제정보
			System.out.println("총 결제금액(o_sum_money): "+ovo.getO_sum_money());
			System.out.println("결제종류(o_acc_type): "+ovo.getO_acc_type());
			System.out.println("결제하는 사람(o_acc_payer): "+ovo.getO_acc_payer());
			System.out.println("결제하는 날짜(o_acc_date): "+ovo.getO_acc_date());
			
			// 배송정보
			System.out.println("운송장 번호(o_way_num): "+ovo.getO_way_num());
			System.out.println("주문날짜(o_date): "+ovo.getO_date());
			System.out.println("주문상태(o_status): "+ovo.getO_status());
		}
	}
	// 주문검색
	
	// 운송장 번호부여
	//@Test
	public void testGenerateTrackingNumber() throws Exception {
		
		// 중복되지 않는 운송장 번호생성
		String trackingNumber = aodao.generateUniqueTrackingNumber();
		
		System.out.println("운송장 번호: "+trackingNumber);
		
		// 운송장 번호 부여
		aodao.addTrackingNumber(8, trackingNumber);
	}
	// 운송장 번호부여
	*/
}
