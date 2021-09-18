package com.g3.persistence;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(DataSourceTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testConn() throws Exception {
		System.out.println("DataSource 객체정보: "+ds);
		
		// DB 연결
		Connection conn = ds.getConnection();
		logger.info("DB 연결정보"+conn);
		//System.out.println("DB 연결정보: "+conn);
	}	
}
