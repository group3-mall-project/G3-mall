package com.g3.persistence;

import java.util.List;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;

public interface BasketDAO {

	//장바구니 담기전 체크
	public BasketVO checkBasket(Ad_ProductVO prod, String id);
	
	//새로운 장바구니 추가
	public void insertProductInBasket(Ad_ProductVO prod, String id);

	//장바구니 이미 있을때 수량추가
	public void updateAmountProductInBasket(Ad_ProductVO prod, BasketVO bvo);

	//장바구니 목록 조회(VasketVO)
	public List<BasketVO> getBasketList(String id);
	//장바구니 목록에 필요한 productVO 
	public List<Ad_ProductVO> getProductListToBasket(List<BasketVO> basketList);

	// 장바구니 삭제
	public void basketDel(int b_num);

	// 장바구니 수량 변경
	public void amountChange(BasketVO vo);
	
	//찜목록 image,price List
	public List<Ad_ProductVO> getLike(String id);


	

	
}
