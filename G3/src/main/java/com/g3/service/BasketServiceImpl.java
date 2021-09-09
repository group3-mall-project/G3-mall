package com.g3.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;
import com.g3.persistence.BasketDAO;

@Service
public class BasketServiceImpl implements BasketService{

	@Inject
	private BasketDAO bdao;

	//새로운 장바구니 담기
	@Override
	public void insertProductInBasket(Ad_ProductVO prod, String id) {
		// 장바구니 담기전 체크
		BasketVO bvo = bdao.checkBasket(prod, id);
		if(bvo.getB_p_amount()==0) { //장바구니에 상품&&옵션 없을시
			bdao.insertProductInBasket(prod, bdao.getNewBasketNumber(), id);
		}else if(bvo.getB_p_amount()>0){ //장바구니에 상품&&옵션 있을시
			bdao.updateAmountProductInBasket(prod, bvo);
		}
	}
	//장바구니 목록 조회(VasketVO + p_image(g3_product))
	@Override
	public List basketList(String id) {
		List basketList = bdao.getBasketList(id);
		return basketList;
	}

	//찜목록 조회
	@Override
	public List<Ad_ProductVO> getLikeList(String id) {
		// g3_user - u_like 컬럼 가져오기 (X)
		// image,price List
		List<Ad_ProductVO> likeList = bdao.getLike(id);
		
		return likeList;
	}

	
	
	
	
}
