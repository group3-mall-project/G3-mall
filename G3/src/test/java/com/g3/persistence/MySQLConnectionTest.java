package com.g3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	
	// 드라이버 주소
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// DB명
	public static final String DBURL
		= "jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=Asia/Seoul";
	
	// 아이디
	public static final String DBID = "root";
	
	// 비밀번호
	public static final String DBPW = "1234"; 
	
	@Test
	public void testConn() throws Exception {
		// 1. 드라이버 로딩
		Class.forName(DRIVER);
		
		// 2. DB 연결
		Connection conn = DriverManager.getConnection(DBURL,DBID,DBPW);
		System.out.println("DB 연결정보: "+conn);
	}
}
