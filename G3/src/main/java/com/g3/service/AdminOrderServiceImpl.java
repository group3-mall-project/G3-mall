package com.g3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.g3.domain.OrderVO;
import com.g3.domain.SearchOrderVO;
import com.g3.persistence.AdminOrderDAO;

// root-context.xml에서 Service 객체(bean)로 인식
@Service
public class AdminOrderServiceImpl implements AdminOrderService {

	// AdminOrderDAO 객체 의존성 주입
	@Inject
	private AdminOrderDAO aodao;
	
	
	// 회원별 주문조회
	@Override
	public List<OrderVO> getAllOrdersOfUser(String u_id) {
		List<OrderVO> allOrdersOfUserList;
		
		System.out.println("Business(Service): Persistence(DAO) getAllOrdersOfUser(String u_id) 호출");
		
		allOrdersOfUserList = aodao.getAllOrdersOfUser(u_id);
		
		System.out.println("Business(Service): 회원별 주문조회 완료");
		
		return allOrdersOfUserList;
	}
	// 회원별 주문조회
	
	
	// 총 주문조회
	@Override
	public List<OrderVO> getAllOrdersOfAllUsers(String u_id) {
		List<OrderVO> allOrdersOfAllUsersList;
		
		System.out.println("Business(Service): Persistence(DAO) getAllOrdersOfAllUsers() 호출");
		
		allOrdersOfAllUsersList = aodao.getAllOrdersOfAllUsers(u_id);
		
		System.out.println("Business(Service): 총 주문조회 완료");
		
		return allOrdersOfAllUsersList;
	}
	// 총 주문조회
	

	// 일일정산
	@Override
	public List<OrderVO> getDailySumTotal() {
		List<OrderVO> dailySumTotalList;
		
		System.out.println("Business(Service): Persistence(DAO) getDailySumTotal() 호출");
	
		dailySumTotalList = aodao.getDailySumTotal();
		
		System.out.println("Business(Service): 일일정산 완료");
				
		return dailySumTotalList;
	}
	// 일일정산

	
	// 월별정산
	@Override
	public List<OrderVO> getMonthlySumTotal() {
		List<OrderVO> monthlySumTotalList;
		
		System.out.println("Business(Service): Persistence(DAO) getMonthlySumTotal() 호출");
		
		monthlySumTotalList = aodao.getMonthlySumTotal();
		
		System.out.println("Business(Service): 월별정산 완료");
		
		return monthlySumTotalList; 
	}
	// 월별정산
	

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// Work in progress
	// 주문검색
	@Override
	public List<SearchOrderVO> searchOrder(SearchOrderVO svo) {
		// TODO Auto-generated method stub
		return null;
	}
	// 주문검색
	// Work in progress
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
