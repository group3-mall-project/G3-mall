package com.g3.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlConnectionTest {
	
	// 드라이버 주소 (8.0버전을 사용할때는 cj가 중간에 들어간다)
	public static String DRIVER = "com.mysql.cj.jdbc.Driver";
	// 디비명 (8.0버전을 사용할때는 =Aisa/Seoul을 써줘야한다
	public static String DBURL = "jdbc:mysql://localhost:3306/g3?useSSL=false&serverTimezone=Asia/Seoul";
	// 계정(ID)
	public static String DBID = "root";
	// 계정(PW)
	public static String DBPW = "1234";
	
	// @Test가 안나타날때는 pom.xml에 4.12버전이 맞는지 확인
	// 그래도 안되면 프로젝트 오른쪽클릭 ->메이븐->업데이트 차례로 눌러 준다
	// 그래도 안되면 C:\Users\ITWILL\.m2\repository 경로로 가서 삭제후 Spring을 다시 시작한다
	@Test
	public void testConn() throws Exception{
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 디비 연결
		Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
		
		System.out.println("디비 연결 정보 : "+conn);
		
	}
	
	@Test
	public void testConn2() {
		// try~catch
//		try {
//			// 1.드라이버 로드
//			Class.forName(DRIVER);
//			// 2. 디비 연결
//			Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);
//			
//			System.out.println("디비 연결 정보 : "+conn);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		// 1.드라이버 로드
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//try~with 구문 (JDK 1.7이후 사용가능)
		// finally 블럭을 제거한 예외처리 구문
		// => 자원해제 구문을 포함한 예외처리 구문
		// try(AutoCloseeable 인터페이스를 구현한 객체 작성/사용)
		// 예외 처리 끝나고 자동으로 자원해제
		try(Connection conn = DriverManager.getConnection(DBURL, DBID, DBPW);) {
			// 2. 디비 연결
			
			System.out.println("디비 연결 정보 : "+conn);
			
			//conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
