package com.g3.service;

import java.util.List;

import com.g3.domain.OrderVO;
import com.g3.domain.SearchOrderVO;

public interface AdminOrderService {
	
	// 회원별 주문조회
	public List<OrderVO> getAllOrdersOfUser(String u_id);
	
	// 총 주문조회
	public List<OrderVO> getAllOrdersOfAllUsers(String u_id);
	
	// 일일정산
	public List<OrderVO> getDailySumTotal();
	
	// 월별정산
	public List<OrderVO> getMonthlySumTotal();
	
	// 주문검색
	public List<SearchOrderVO> searchOrder(SearchOrderVO svo);
}
