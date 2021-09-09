package com.g3.persistence;

import java.sql.Date; // Leave it as it is for now
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.g3.domain.OrderVO;
import com.g3.domain.SearchOrderVO;

// root-context.xml에서 DAO 객체(bean)로 인식
@Repository
public class AdminOrderDAOImpl implements AdminOrderDAO {
	
	// DB 연결, SqlSession 객체 의존성 주입
	@Inject
	private SqlSession sqlSession;
	
	// adminOrderMapper.xml 파일에 접근 가능한 이름(주소)
	private static final String namespace = "com.g3.mapper.AdminOrderMapper";
	
	// 회원별 주문조회, 오류 처리 필요 X
	@Override
	public List<OrderVO> getAllOrdersOfUser(String u_id) {
		// Q&A: new 할당 필요? -> selectList가 할당!
		List<OrderVO> allOrdersOfUserList;
		
		System.out.println("Persistence(DAO): getAllOrdersOfUser(String u_id) 호출");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행");
		
		allOrdersOfUserList = sqlSession.selectList(namespace+".getAllOrdersOfUser", u_id);
		
		System.out.println("Persistence(Mapper): getAllOrdersOfUser SQL 구문 실행완료");
		System.out.println("Persistence(DAO): 회원별 주문조회 완료");
		
		return allOrdersOfUserList;
	}
	// 회원별 주문조회, 오류 처리 필요 X

	
	// 총 주문조회, 오류 처리 필요 X
	@Override
	public List<OrderVO> getAllOrdersOfAllUsers(String u_id) {
		// Q&A: new 할당 필요? -> selectList가 할당!		
		List<OrderVO> allOrdersOfAllUsersList;
		
		System.out.println("Persistence(DAO): getAllOrdersOfAllUsers() 호출");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행");
		
		allOrdersOfAllUsersList = sqlSession.selectList(namespace+".getAllOrdersOfAllUsers", u_id);

		System.out.println("Persistence(Mapper): getAllOrdersOfAllUsers SQL 구문 실행완료");
		System.out.println("Persistence(DAO): 총 주문조회 완료");
		
		return allOrdersOfAllUsersList;
	}
	// 총 주문조회, 오류 처리 필요 X
	

	// 일일정산, 오류 처리 필요 X
	@Override
	public List<OrderVO> getDailySumTotal() {
		List<OrderVO> dailySumTotalList;
		
		System.out.println("Persistence(DAO): getDailySumTotal() 호출");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행");

		dailySumTotalList = sqlSession.selectList(namespace+".getDailySumTotal");
		
		System.out.println("Persistence(Mapper): getDailySumTotal SQL 구문 실행완료");
		System.out.println("Persistence(DAO): 일일정산 완료");
		
		return dailySumTotalList;
	}
	// 일일정산, 오류 처리 필요 X
	

	// 월별정산, 오류 처리 필요 X
	@Override
	public List<OrderVO>getMonthlySumTotal() {
		List<OrderVO> monthlySumTotalList;
		
		System.out.println("Persistence(DAO): getMonthlySumTotal() 호출");
		System.out.println("Persistence(Mapper): adminOrderMapper.xml 이동 후 SQL 구문 실행");
		
		monthlySumTotalList = sqlSession.selectList(namespace+".getMonthlySumTotal");
		
		System.out.println("Persistence(Mapper): getMonthlySumTotal SQL 구문 실행완료");
		System.out.println("Persistence(DAO): 월별정산 완료");
		
		return monthlySumTotalList;
	}
	// 월별정산, 오류 처리 필요 X

	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// Work in progress
	// 주문검색
	@Override
	public List<SearchOrderVO> searchOrder(SearchOrderVO sovo) {
		String inquiryPeriod = sovo.getInquiryPeriod();
		LocalDate beginningDate, endDate, currentDate;
		
		// 조회기간
		currentDate = LocalDate.now(); // 오늘 날짜로 고정
		currentDate.getClass().getSimpleName();
		
		if(inquiryPeriod != null) { // 오늘, 1주일, 1개월, 3개월
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
				case "threeMonths":
					endDate = currentDate;
					beginningDate = currentDate.minusMonths(3);
					break;
			}
		}else { // 사용자 지정
			// 전달된 문자열 String을 파서해서 LocalDate로 변환
			beginningDate = LocalDate.parse(sovo.getBeginningDate());
			endDate = LocalDate.parse(sovo.getEndDate());
		}
		
		// 상세조건
		
		
		return null;
	}
	// Work in progess
	// 주문검색
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
