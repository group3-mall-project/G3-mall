package com.g3.persistence;

import java.util.List;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;

public interface BasketDAO {

	//새로운 장바구니 번호
	public int getNewBasketNumber();
	
	//장바구니 담기전 체크
	public BasketVO checkBasket(Ad_ProductVO prod, String id);
	
	//새로운 장바구니 추가
	public void insertProductInBasket(Ad_ProductVO prod, int newNumber, String id);

	//장바구니 수량추가
	public void updateAmountProductInBasket(Ad_ProductVO prod, BasketVO bvo);

	//장바구니 목록 조회(VasketVO + p_image(g3_product))
	public List getBasketList(String id);

	// g3_user - u_like 컬럼 가져오기 (X)
	// image,price List
	public List<Ad_ProductVO> getLike(String id);
	
}
