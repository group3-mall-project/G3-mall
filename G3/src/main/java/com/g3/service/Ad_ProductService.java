package com.g3.service;

import java.util.List;

import com.g3.domain.Ad_ProductVO;

public interface Ad_ProductService {

	//상품추가
	public void AddProduct(Ad_ProductVO advo);
	
	//상품목록
	public List<Ad_ProductVO> ProductList();
	
	//상품삭제
	public void CutProduct(int p_num);
	
	//상품수정
	public void ModifyProduct(Ad_ProductVO advo);

	//상품조회
    public Ad_ProductVO getProduct(int p_num);
    
 // 상품 총 갯수
    public int count() throws Exception;
    
    
 // 상품목록 + 페이징 + 검색
    public List<Ad_ProductVO> listPageSearch(
      int displayPost, int postNum, String searchType, String keyword) throws Exception;

 // 상품 총 갯수 + 검색 적용
    public int searchCount(String searchType, String keyword) throws Exception;
}
