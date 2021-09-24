package com.g3.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.Ad_ProductViewVO;

@Repository
public class Ad_ProductDAOImpl implements Ad_ProductDAO{

	//디비연결 => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;

	//memberMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace ="com.g3.mapper.adProductMapper";
	
	@Override
	public void insertProduct(Ad_ProductVO advo) {
		System.out.println("DAO: insertProduct 호출@@@@@@");
		sqlSession.insert(namespace+".AddProduct", advo);
	}

   @Override
   public void deleteProduct(int p_num) {
      System.out.println("dao:deleteProduct() 호출@@@");
      sqlSession.delete(namespace+".deleteProduct",p_num);
   }

	@Override
	public void updateProduct(Ad_ProductVO advo) {
		sqlSession.update(namespace+".modifyProduct",advo);
		
	}


	@Override
	public Ad_ProductVO getProduct(int p_num) {
		System.out.println("DAO:getProduct()호출");
		
		System.out.println("DAO:상품조회 리턴");
		Ad_ProductVO pvo= sqlSession.selectOne(namespace+".getProduct",p_num);
		
		return pvo;
	}

	// 게시물 총 갯수
		@Override
		public int count() throws Exception {
		 return sqlSession.selectOne(namespace + ".count"); 
		}

		 
		// 게시물 목록 + 페이징 + 검색 + 카테고리
		 @Override
		 public List<Ad_ProductViewVO> listPageSearch2(
		   int displayPost, int postNum, String searchType, String keyword) throws Exception {

		  HashMap<String, Object> data = new HashMap<String, Object>();
		  
		  data.put("displayPost", displayPost);
		  data.put("postNum", postNum);
		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		  
		  return sqlSession.selectList(namespace + ".listPageSearch2", data);
		 }
		// 게시물 총 갯수 + 검색 적용
		 @Override
		 public int searchCount(String searchType, String keyword) throws Exception {
		  
		  HashMap data = new HashMap();
		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		  
		  return sqlSession.selectOne(namespace + ".searchCount", data); 
		 }
	}

