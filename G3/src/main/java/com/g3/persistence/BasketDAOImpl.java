package com.g3.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class BasketDAOImpl implements BasketDAO{

	
	
	
	// 디비연결 => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;
	
	// basketMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace = "com.g3.mapper.basketMapper.xml";
}
