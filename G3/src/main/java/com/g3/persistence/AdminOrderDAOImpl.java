package com.g3.persistence;

import java.sql.Date; // Leave it as it is for now
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.g3.domain.Criteria;
import com.g3.domain.OrderSearchVO;
import com.g3.domain.OrderVO;

// root-context.xml에서 DAO 객체(bean)로 인식
@Repository
public class AdminOrderDAOImpl implements AdminOrderDAO {
	// DB 연결, SqlSession 객체 의존성 주입
	@Inject
	private SqlSession sqlSession;
	
	
	
	// adminOrderMapper.xml 파일에 접근 가능한 이름(주소)
	private static final String namespace = "com.g3.mapper.AdminOrderMapper";
	
	
	
	// 주문조회
	@Override
	public List<OrderVO> getListOfOrders(String u_id, Criteria cri) {
		List<OrderVO> listOfOrders;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("u_id", u_id);
		map.put("cri", cri);
		
		System.out.println("Persistence(DAO): getListOfOrders(String u_id, Criteria cri) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		listOfOrders = sqlSession.selectList(namespace+".getListOfOrders", map);

		System.out.println("Persistence(Mapper): getListOfOrders SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문조회 완료\n");
		
		return listOfOrders;		
	}
	// 주문조회
	
	// 주문개수
	@Override
	public Integer getNumOfOrders(String u_id) {
		Integer numOfOrders;
		
		System.out.println("Persistence(DAO): getNumOfOrders(String u_id) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		numOfOrders = sqlSession.selectOne(namespace+".getNumOfOrders", u_id);
		// null일 경우 0을 삽입
		if(numOfOrders == null)
			numOfOrders = 0;
			
		System.out.println("Persistence(Mapper): getNumOfOrders SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문개수 완료\n");
		
		return numOfOrders;
	}
	// 주문개수


	
	// 일일정산
	@Override
	public List<OrderVO> getListOfDailySumTotal(Criteria cri) {
		List<OrderVO> listOfDailySumTotal;
		
		System.out.println("Persistence(DAO): getListOfDailySumTotal(Criteria cri) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");

		listOfDailySumTotal = sqlSession.selectList(namespace+".getListOfDailySumTotal", cri);
		
		System.out.println("Persistence(Mapper): getListOfDailySumTotal SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 일일정산 완료\n");
		
		return listOfDailySumTotal;
	}	 
	// 일일정산	 
	
	// 일일정산 개수
	@Override
	public Integer getNumOfDailySumTotal() {
		Integer numOfDailySumTotal;
		
		System.out.println("Persistence(DAO): getNumOfDailySumTotal() 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		numOfDailySumTotal = sqlSession.selectOne(namespace+".getNumOfDailySumTotal");
		// null일 경우 0을 삽입
		if(numOfDailySumTotal == null)
			numOfDailySumTotal = 0;
		
		System.out.println("Persistence(Mapper): getNumOfDailySumTotal SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 일일정산 개수 완료\n");
		
		return numOfDailySumTotal;
	}
	// 일일정산 개수
	
	

	// 월별정산
	@Override
	public List<OrderVO> getListOfMonthlySumTotal(Criteria cri) {
		List<OrderVO> listOfMonthlySumTotal;
		
		
		System.out.println("Persistence(DAO): getListOfMonthlySumTotal(Criteria cri) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");

		listOfMonthlySumTotal = sqlSession.selectList(namespace+".getListOfMonthlySumTotal", cri);
		
		System.out.println("Persistence(Mapper): getListOfMonthlySumTotal SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 월별정산 완료\n");
		
		return listOfMonthlySumTotal;
	}
	// 월별정산
	
	// 월별정산 개수
	@Override
	public Integer getNumOfMonthlySumTotal() {
		Integer numOfMonthlySumTotal;
		
		System.out.println("Persistence(DAO): getNumOfMonthlySumTotal() 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		numOfMonthlySumTotal = sqlSession.selectOne(namespace+".getNumOfMonthlySumTotal");
		// null일 경우 0을 삽입
		if(numOfMonthlySumTotal == null)
			numOfMonthlySumTotal = 0;
		
		System.out.println("Persistence(Mapper): getNumOfMonthlySumTotal SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 월별정산 개수 완료\n");
		
		return numOfMonthlySumTotal;
	}
	// 월별정산 개수
	
	
	
	// 주문검색
	@Override
	public List<OrderVO> getListOfOrderSearch(OrderSearchVO osvo, Criteria cri) {
		List<OrderVO> listOfOrderSearch;
		Map<String, Object> map = new HashMap<String, Object>();
		
		String queryPeriod = osvo.getQueryPeriod();
		LocalDate beginningDate, endDate, currentDate;
		
		// 조회기간
		beginningDate = endDate = currentDate = LocalDate.now(); // 오늘 날짜로 초기화
		currentDate.getClass().getSimpleName();
		
		if(queryPeriod.equals("") == false) { // 오늘, 1주일, 1개월, 3개월
			switch(queryPeriod) {
				case "today":
					beginningDate = endDate = currentDate;
					break;
				case "oneWeek":
					endDate = currentDate;
					beginningDate = currentDate.minusWeeks(1);
					break;
				case "oneMonth":
					endDate = currentDate;
					beginningDate = currentDate.minusMonths(1);
					break;
				default:
					endDate = currentDate;
					beginningDate = currentDate.minusMonths(3);
					break;
			}
		}else { // 사용자 지정
			// 전달된 문자열 String을 파싱해서 LocalDate로 변환
			beginningDate = LocalDate.parse(osvo.getBeginningDate());
			endDate = LocalDate.parse(osvo.getEndDate());
		}
		
		
		// 상세조건
		String advacnedSearch = osvo.getAdvancedSearch();
		String searchQuery = osvo.getSearchQuery();
		
		
		System.out.println("상세조건: "+advacnedSearch);
		System.out.println("검색질의: "+searchQuery);
		System.out.println("시작날: "+advacnedSearch);
		System.out.println("끝날: "+advacnedSearch);
		
		map.put("cri", cri); // 페이징 정보
		map.put("o_srch_qy", searchQuery); // 검색질의
		map.put("o_srch_type", advacnedSearch); // 상세조건
		map.put("o_begin_date", Date.valueOf(beginningDate)); // LocalDate를 SQL Date로 변환
		map.put("o_end_date", Date.valueOf(endDate)); // LocalDate를 SQL Date로 변환
		
		System.out.println("Persistence(DAO): getListOfOrderSearch(OrderSearchVO osvo, Criteria cri) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		listOfOrderSearch = sqlSession.selectList(namespace+".getListOfSearchOrder", map);
		
		System.out.println("Persistence(Mapper): getListOfOrderSearch SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문검색 완료\n");
		
		return listOfOrderSearch;
	}
	// 주문검색
	
	
	
	// 주문검색 개수
	@Override
	public Integer getNumOfOrderSearch(OrderSearchVO osvo) {
		Integer numOfOrderSearch;
		Map<String, Object> map = new HashMap<String, Object>();
		
		String inquiryPeriod = osvo.getQueryPeriod();
		LocalDate beginningDate, endDate, currentDate;
		
		// 조회기간
		beginningDate = endDate = currentDate = LocalDate.now(); // 오늘 날짜로 초기화
		currentDate.getClass().getSimpleName();
		
		if(inquiryPeriod.equals("") == false) { // 오늘, 1주일, 1개월, 3개월
			switch(inquiryPeriod) {
				case "today":
					beginningDate = endDate = currentDate;
					break;
				case "oneWeek":
					endDate = currentDate;
					beginningDate = currentDate.minusWeeks(1);
					break;
				case "oneMonth":
					endDate = currentDate;
					beginningDate = currentDate.minusMonths(1);
					break;
				default:
					endDate = currentDate;
					beginningDate = currentDate.minusMonths(3);
					break;
			}
		}else { // 사용자 지정
			// 전달된 문자열 String을 파싱해서 LocalDate로 변환
			beginningDate = LocalDate.parse(osvo.getBeginningDate());
			endDate = LocalDate.parse(osvo.getEndDate());
		}
		
		
		// 상세조건
		String advacnedSearch = osvo.getAdvancedSearch();
		String userQuery = osvo.getSearchQuery();
				
		map.put("o_srch_qy", userQuery); // 상세조건
		map.put("o_srch_type", advacnedSearch); // 사용자 질의
		map.put("o_begin_date", Date.valueOf(beginningDate)); // LocalDate를 SQL Date로 변환
		map.put("o_end_date", Date.valueOf(endDate)); // LocalDate를 SQL Date로 변환
		
		System.out.println("Persistence(DAO): getNumOfOrderSearch(OrderSearchVO osvo) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		numOfOrderSearch = sqlSession.selectOne(namespace+".getNumOfSearchOrder", map);
		// null일 경우 0을 삽입
		if(numOfOrderSearch == null)
			numOfOrderSearch = 0;
		
		System.out.println("Persistence(Mapper): getNumOfOrderSearch SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문검색 개수 완료\n");
		
		return numOfOrderSearch;
	}
	// 주문검색 개수
	
	
	
	// 중복되지 않는 운송장 번호생성
	@Override
	public String generateUniqueTrackingNumber() {
		// 날짜를 YYYYMMDD 형식으로 변환 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		// 현재 날짜에 형식을 적용
		String trackingNumber = LocalDate.now().format(formatter);
		String tempTrackingNumber = "";
		String randomNumber = "";
		
		// selectOne의 결과저장
		String ret; 
		
		System.out.println("Persistence(DAO): generateUniqueTrackingNumber() 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		while(true) {
			// 반복마다 초기화
			tempTrackingNumber = trackingNumber;
			randomNumber = "";
			
			// 뒤에 6자리를 추가로 생성, 의사난수
			for(int i = 0; i < 6; i++)
				randomNumber += (int)Math.floor(Math.random()*10);
			
			// 임시 운송장 번호
			tempTrackingNumber += randomNumber;
			
			ret = sqlSession.selectOne(namespace+".generateUniqueTrackingNumber", tempTrackingNumber);
			
			// DB에서 찾을 수 없을 경우 null 반환, 즉 중복이 아닌 새로운 운송장 번호
			if(ret == null) {
				trackingNumber = tempTrackingNumber;
				break;
			}
		}
		
		System.out.println("Persistence(Mapper): generateUniqueTrackingNumber SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 중복되지 않는 운송장 번호생성 완료\n");
		
		return trackingNumber;
	}
	// 중복되지 않는 운송장 번호생성
	
	// 운송장 번호
	@Override
	public String getTrackingNumber(String o_d_num) {
		String trackingNumber;
		
		System.out.println("Persistence(DAO): getTrackingNumber(Integer o_d_num) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		trackingNumber = sqlSession.selectOne(namespace+".getTrackingNumber", o_d_num);
		
		System.out.println("Persistence(Mapper): getTrackingNumber SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 운송장 번호 완료\n");
		
		return trackingNumber;
	}
	// 운송장 번호
	
	// 운송장 번호부여
	@Override
	public void addTrackingNumber(String o_d_num, String o_way_num) {
		
		// 자료형이 다르기 때문에 Map 사용
		Map<String, Object> map  = new HashMap<String, Object>();
		
		map.put("o_d_num", o_d_num);
		map.put("o_way_num", o_way_num);
			
		System.out.println("Persistence(DAO): addTrackingNumber(Integer o_d_num, String o_way_num) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		sqlSession.insert(namespace+".addTrackingNumber", map);
		
		System.out.println("Persistence(Mapper): addTrackingNumber SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 운송장 번호부여 완료\n");
	}
	// 운송장 번호부여


	
	// 주문 상세정보
	@Override
	public List<OrderVO> getOrderDetail(String o_d_num) {
		List<OrderVO> listOrderDetail;
		
		System.out.println("Persistence(DAO): getOrderDetail(Integer o_d_num) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		listOrderDetail = sqlSession.selectList(namespace+".getOrderDetail", o_d_num);
		
		System.out.println("Persistence(Mapper): getOrderDetail SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문 상세정보 완료\n");
		
		return listOrderDetail;
	}
	// 주문 상세정보

	// 주문 상세정보 수정
	@Override
	public void editOrderDetail(OrderVO ovo) {
		System.out.println("Persistence(DAO):  editOrderDetail(OrderVO ovo) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		sqlSession.update(namespace+".editOrderDetail", ovo);
		
		System.out.println("Persistence(Mapper): editOrderDetail SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문 상세정보 수정 완료\n");		
	}
	// 주문 상세정보 수정

	// 주문취소
	@Override
	public void cancelOrder(String o_d_num) {
		System.out.println("Persistence(DAO): cancelOrder(Integer o_d_num) 호출\n");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행\n");
		
		sqlSession.delete(namespace+".cancelOrder", o_d_num);
		
		System.out.println("Persistence(Mapper): cancelOrder SQL 구문 실행완료\n");
		System.out.println("Persistence(DAO): 주문삭제 완료\n");		
	}
	// 주문취소
}
