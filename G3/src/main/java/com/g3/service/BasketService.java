package com.g3.service;

import java.util.List;

import com.g3.domain.Ad_ProductVO;

public interface BasketService {
	
	//새 장바구니 추가
	public void insertProductInBasket(Ad_ProductVO prod, String id);

	//장바구니 목록 조회(VasketVO + p_image(g3_product))
	public List basketList(String id);

	//찜목록 조회 (
	public List<Ad_ProductVO> getLikeList(String id);
}
