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
			bdao.insertProductInBasket(prod, id);
		}else if(bvo.getB_p_amount()>0){ //장바구니에 상품&&옵션 있을시
			bdao.updateAmountProductInBasket(prod, bvo);
		}
	}
	//장바구니 목록 조회(BasketVO)
	  @Override 
	public List<BasketVO> getBasketList(String id) {
		return bdao.getBasketList(id); 
	}

	//장바구니 목록에 필요한 product 테이블로부터 thumbimg , amount 조회
	@Override
	public List<Ad_ProductVO> getProductListToBasket(List<BasketVO> basketList) {
		return bdao.getProductListToBasket(basketList);
	}
	
	//장바구니 삭제
	@Override
	public void basketDel(int b_num) {
		bdao.basketDel(b_num);
	}
	
	// 장바구니 수량 변경
	@Override
	public void amountChange(BasketVO vo) {
		bdao.amountChange(vo);
	}
	
	//찜목록 조회
	@Override
	public List<Ad_ProductVO> getLikeList(String id) {
		// g3_user - u_like 컬럼 가져오기 (X)
		// image,price List
		return bdao.getLike(id);
	}

	
	
	
	
}
