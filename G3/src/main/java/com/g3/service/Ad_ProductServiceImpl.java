package com.g3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.g3.domain.Ad_ProductVO;
import com.g3.persistence.Ad_ProductDAO;


@Service
public class Ad_ProductServiceImpl implements Ad_ProductService{

	@Inject
	private Ad_ProductDAO addao;
	
	@Override
	public void AddProduct(Ad_ProductVO advo) {
		System.out.println("S: AddProduct 호출");
		addao.insertProduct(advo);
	}



	@Override
	   public void CutProduct(int p_num) {
	      System.out.println("S: cutProduct 호출 @@@");
	      addao.deleteProduct(p_num);
	   }

	@Override
	public void ModifyProduct(Ad_ProductVO advo) {
		addao.updateProduct(advo);
		
	}

	@Override
	public List<Ad_ProductVO> ProductList() {
		System.out.println("S: ProductList 호출@@@");
		return addao.ProductList();
	}



	@Override
	public Ad_ProductVO getProduct(int p_num) {
   System.out.println(" S:getProduct()호출@@");
   Ad_ProductVO avo =addao.getProduct(p_num);
		return avo;
	}
	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
	 return addao.count();
	}

	// 상품 목록 + 페이징 + 검색
	@Override
	public List<Ad_ProductVO> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception {
	 return  addao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	
	// 상품 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 return addao.searchCount(searchType, keyword);
	}
}
