package com.g3.persistence;

import java.util.List;

import com.g3.domain.Ad_ProductVO;

public interface Ad_ProductDAO {
	
	//상품정보등록
	public void insertProduct(Ad_ProductVO advo);
	//상품목록
	public List<Ad_ProductVO> ProductList();
	//상품 삭제
	public void deleteProduct(int p_num);
	//상품 업데이트
	public void updateProduct(Ad_ProductVO advo);
	//상품조회
	public Ad_ProductVO getProduct(int p_num);
	// 상품 총 갯수
	public int count() throws Exception;
	// 상품 목록 + 페이징 + 검색
	 public List<Ad_ProductVO> listPageSearch(
	   int displayPost, int postNum, String searchType, String keyword) throws Exception;
	// 상품 총 갯수 + 검색 적용
	 public int searchCount(String searchType, String keyword) throws Exception;
}
