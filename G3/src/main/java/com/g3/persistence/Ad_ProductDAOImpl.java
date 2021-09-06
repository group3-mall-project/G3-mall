package com.g3.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.g3.domain.Ad_ProductVO;

@Repository
public class Ad_ProductDAOImpl implements Ad_ProductDAO{

	//디비연결 => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;

	//memberMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace ="com.g3.mapper.adProductMapper";
	
	@Override
	public void insertProduct(Ad_ProductVO advo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int p_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Ad_ProductVO advo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ad_ProductVO getProduct(int p_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
