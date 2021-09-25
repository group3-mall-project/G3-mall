package com.g3.service;

import java.util.List;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;

public interface BasketService {
	
	//새 장바구니 추가
	public void insertProductInBasket(Ad_ProductVO prod, String id);

	//장바구니 목록 조회(BasketVO)
	public List<BasketVO> getBasketList(String id); 

	//장바구니 목록에 필요한 product 테이블로부터 thumbimg , amount 조회
	public List<Ad_ProductVO> getProductListToBasket(List<BasketVO> basketList);

	//삭제
	public void basketDel(int b_num);

	// 장바구니 수량 변경
	public void amountChange(BasketVO vo);
	
	//찜목록 조회 (
	public List<Ad_ProductVO> getLikeList(String id);





}
