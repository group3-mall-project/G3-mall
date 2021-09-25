package com.g3.web;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith(SpringJUnit4ClassRunner.class)
// => 해당 클래스를 스프링 Junit4사용해서 테스트용으로 설정
// @ContextConfiguration(
//locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//)
// => 해당 클래스를 스프링 Junit4사용해서 테스트용으로 설정
// 	+ 스프링에 정보를 가져오는 역할


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	// 디비 연결태스트 (root-context.xml에있는 dataSource객체를 사용)
	
	// 디비 연결정보를 저장하는 객체를 생성(DataSource)
	// DataSource ds = new DataSource();
	// 객체 의존 주입
	@Inject
	private DataSource ds;
	
	
	@Test
	public void testConn() throws Exception{
		System.out.println("DataSource 객체 정보 : "+ds);
		
		// 디비 연결
		Connection conn = ds.getConnection();
		
		System.out.println("디비 연결정보 : "+conn);
		
		//PreparedStatement pst = conn.prepareStatement(sql);
		
		
	}
	
	
}
