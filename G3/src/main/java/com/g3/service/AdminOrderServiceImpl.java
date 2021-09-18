package com.g3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.g3.domain.Criteria;
import com.g3.domain.OrderSearchVO;
import com.g3.domain.OrderVO;
import com.g3.persistence.AdminOrderDAO;

// root-context.xml에서 Service 객체(bean)로 인식
@Service
public class AdminOrderServiceImpl implements AdminOrderService {
	// AdminOrderDAO 객체 의존성 주입
	@Inject
	private AdminOrderDAO aodao;
	

	
	// 주문조회
	@Override
	public List<OrderVO> getListOfOrders(String u_id, Criteria cri) {
		List<OrderVO> listOfOrders;
		
		System.out.println("Business(Service): Persistence(DAO) getListOfOrders(String u_id, Criteria cri) 호출\n");
		
		listOfOrders = aodao.getListOfOrders(u_id, cri);
		
		System.out.println("Business(Service): 주문조회 완료\n");		
		
		return listOfOrders;
	}
	// 주문조회
	
	// 주문개수
	@Override
	public Integer getNumOfOrders(String u_id) {
		Integer numOfOrders;
		
		System.out.println("Business(Service): Persistence(DAO)  getNumOfOrders(String u_id) 호출\n");
		
		numOfOrders = aodao.getNumOfOrders(u_id);
		
		System.out.println("Business(Service): 주문개수 완료\n");
		
		return numOfOrders;
	}
	// 주문개수	
	
	
	
	// 일일정산
	@Override
	public List<OrderVO> getListOfDailySumTotal(Criteria cri) {
		List<OrderVO> listOfDailySumTotal;
		
		System.out.println("Business(Service): Persistence(DAO) getListOfDailySumTotal(Criteria cri) 호출\n");
	
		listOfDailySumTotal = aodao.getListOfDailySumTotal(cri);
		
		System.out.println("Business(Service): 일일정산 완료\n");
				
		return listOfDailySumTotal;
	}	 
	// 일일정산
	
	// 일일정산 개수
	@Override
	public Integer getNumOfDailySumTotal() {
		Integer numOfDailySumTotal;
		
		System.out.println("Business(Service): Persistence(DAO) getNumOfDailySumTotal() 호출\n");
		
		numOfDailySumTotal = aodao.getNumOfDailySumTotal();
		
		System.out.println("Business(Service): 일일정산 개수 완료\n");
		
		return numOfDailySumTotal;
	}
	// 일일정산 개수
	
	
	
	// 월별정산
	@Override
	public List<OrderVO> getListOfMonthlySumTotal(Criteria cri) {
		List<OrderVO> listOfMonthlySumTotal;
		
		System.out.println("Business(Service): Persistence(DAO) getListOfMonthlySumTotal(Criteria cri) 호출\n");
		
		listOfMonthlySumTotal = aodao.getListOfMonthlySumTotal(cri);
		
		System.out.println("Business(Service): 월별정산 완료\n");
		
		return listOfMonthlySumTotal; 
	}	 
	// 월별정산
	
	// 월별정산 개수
	@Override
	public Integer getNumOfMonthlySumTotal() {
		Integer numOfMonthlySumTotal;
		
		System.out.println("Business(Service): Persistence(DAO) getNumOfMonthlySumTotal() 호출\n");
		
		numOfMonthlySumTotal = aodao.getNumOfMonthlySumTotal();
		
		System.out.println("Business(Service): 월별정산 개수 완료\n");
		
		return numOfMonthlySumTotal;
	}
	// 월별정산 개수
	
	
	
	// 주문검색
	@Override
	public List<OrderVO> getListOfSearchOrder(OrderSearchVO osvo, Integer beginNumOfOrders, Integer numOfItemsPerPage) {
		List<OrderVO> listOrderSearch;
		
		System.out.println("Business(Service): Persistence(DAO) getListOfSearchOrder(OrderSearchVO osvo, Integer beginNumOfOrders, Integer numOfItemsPerPage) 호출\n");
		
		listOrderSearch = aodao.getListOfSearchOrder(osvo, beginNumOfOrders, numOfItemsPerPage);
		
		System.out.println("Business(Service): 주문검색 완료\n");
		
		return listOrderSearch;
	}
	// 주문검색
	
	
	
	// 주문검색 개수
	@Override
	public Integer getNumOfSearchOrder(OrderSearchVO osvo) {
		Integer numOfSearchOrder;
		
		System.out.println("Business(Service): Persistence(DAO) getNumOfSearchOrder(OrderSearchVO osvo) 호출\n");
		
		numOfSearchOrder = aodao.getNumOfSearchOrder(osvo);
		
		System.out.println("Business(Service): 주문검색 개수 완료\n");
		
		return numOfSearchOrder;
	}
	// 주문검색 개수

	
	
	// 중복되지 않는 운송장 번호생성
	@Override
	public String generateUniqueTrackingNumber() {
		String trackingNumber;
		
		System.out.println("Business(Service): Persistence(DAO) generateUniqueTrackingNumber() 호출\n");
		
		trackingNumber = aodao.generateUniqueTrackingNumber();
		
		System.out.println("Business(Service): 중복되지 않는 운송장 번호생성 완료\n");		
		
		return trackingNumber;
	}
	// 중복되지 않는 운송장 번호생성
	

	
	// 운송장 번호
	@Override
	public String getTrackingNumber(Integer o_d_num) {
		String trackingNumber;
		
		System.out.println("Business(Service): Persistence(DAO) geTrackingNumber() 호출\n");
		
		trackingNumber = aodao.getTrackingNumber(o_d_num);
		
		System.out.println("Business(Service): 운송장 번호 완료\n");		
		
		return trackingNumber;
	}
	// 운송장 번호
	

	
	// 운송장 번호부여
	@Override
	public void addTrackingNumber(Integer o_d_num, String o_way_num) {
		System.out.println("Business(Service): Persistence(DAO) addTrackingNumber() 호출\n");
		
		aodao.addTrackingNumber(o_d_num, o_way_num);
		
		System.out.println("Business(Service): 운송장 번호부여 완료\n");		
	}
	// 운송장 번호부여



	// 주문 상세정보
	@Override
	public List<OrderVO> getOrderDetail(Integer o_d_num) {
		List<OrderVO> listOrderDetail;
		
		System.out.println("Business(Service): Persistence(DAO) getOrderDetail(Integer o_d_num) 호출\n");
		
		listOrderDetail = aodao.getOrderDetail(o_d_num);
		
		System.out.println("Business(Service): 주문 상세정보 완료\n");	
	
		return listOrderDetail;
	}
	// 주문 상세정보



	// 주문 상세정보 수정
	@Override
	public void editOrderDetail(OrderVO ovo) {
		System.out.println("Business(Service): Persistence(DAO) editOrderDetail(OrderVO ovo) 호출\n");
		
		aodao.editOrderDetail(ovo);
		
		System.out.println("Business(Service): 주문 상세정보 수정 완료\n");				
	}
	// 주문 상세정보 수정


	
	// 주문취소
	@Override
	public void cancelOrder(Integer o_d_num) {	
		System.out.println("Business(Service): Persistence(DAO) cancelOrder(Integer o_d_num) 호출\n");
	
		aodao.cancelOrder(o_d_num);
	
		System.out.println("Business(Service): 주문취소 완료\n");
	}
	// 주문취소
}
