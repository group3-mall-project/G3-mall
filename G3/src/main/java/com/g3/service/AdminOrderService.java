package com.g3.service;

import java.util.List;

import com.g3.domain.Criteria;
import com.g3.domain.OrderSearchVO;
import com.g3.domain.OrderVO;

public interface AdminOrderService {
	// 주문조회
	public List<OrderVO> getListOfOrders(String u_id, Criteria cri);
	// 주문개수
	public Integer getNumOfOrders(String u_id);
	
	

	// 일일정산
	public List<OrderVO> getListOfDailySumTotal(Criteria cri);
	// 일일정산 개수
	public Integer getNumOfDailySumTotal();
	
	
	
	// 월별정산
	public List<OrderVO> getListOfMonthlySumTotal(Criteria cri);
	// 월별정산 개수
	public Integer getNumOfMonthlySumTotal();
	
	
	
	// 주문검색
	public List<OrderVO> getListOfSearchOrder(OrderSearchVO osvo, Integer beginNumOfItems, Integer numOfItemsPerPage);
	
	
	// 주문검색 개수
	public Integer getNumOfSearchOrder(OrderSearchVO osvo);	
	
	
	// 중복되지 않는 운송장 번호생성
	public String generateUniqueTrackingNumber();
	
	
	// 운송장 번호
	public String getTrackingNumber(Integer o_d_num);
	
	
	// 운송장 번호부여
	public void addTrackingNumber(Integer o_d_num, String o_way_num);
	
	
	// 주문 상세정보
	public List<OrderVO> getOrderDetail(Integer o_d_num);
	
	
	// 주문 상세정보 수정
	public void editOrderDetail(OrderVO ovo);
	
	
	// 주문 취소
	public void cancelOrder(Integer o_d_num);
}
