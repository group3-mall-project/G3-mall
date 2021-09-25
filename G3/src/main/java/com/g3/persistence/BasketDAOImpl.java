package com.g3.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.g3.domain.Ad_ProductVO;
import com.g3.domain.BasketVO;

@Repository
public class BasketDAOImpl implements BasketDAO{

	private static final Logger logger =
			LoggerFactory.getLogger(BasketDAO.class);
	
	// 디비연결 => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;
	
	// basketMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace = "com.g3.mapper.BasketMapper";

	//장바구니 담기전 체크 (b_num, b_p_amount return)
	@Override
	public BasketVO checkBasket(Ad_ProductVO prod, String id) {
		BasketVO bvo = sqlSession.selectOne(namespace+".checkBasket");
		return bvo;
	}

	//새로운 장바구니 추가
	@Override
	public void insertProductInBasket(Ad_ProductVO prod,String id) {
		sqlSession.insert(namespace+".insertProductInBasket");
	}
	
	//장바구니 이미 있을때 수량추가
	@Override
	public void updateAmountProductInBasket(Ad_ProductVO prod, BasketVO bvo) {
		bvo.setB_p_amount(prod.getP_amount());
		sqlSession.insert(namespace+".updateAmountProductInBasket",bvo);
	}

	//장바구니 목록 조회(BasketVO + p_image(g3_product))
	@Override
	public List<BasketVO> getBasketList(String id) {
		logger.info(" DAO : id : "+id);;
		List<BasketVO> list=sqlSession.selectList(namespace+".getBasketList", id);
		logger.info(" DAO : getBasketList : "+ list);
		return list;
	}
	
	//장바구니 목록에 필요한 product 테이블로부터 thumbimg , amount 조회
	@Override
	public List<Ad_ProductVO> getProductListToBasket(List<BasketVO> basketList) {
		List<Ad_ProductVO> productList = new ArrayList<>();
		for(int i=0 ; i<basketList.size() ; i++) {
			BasketVO vo = basketList.get(i);
			productList.add(sqlSession.selectOne(namespace+".getProductListToBasket",vo.getB_p_num()));
		}
		return productList;
	}
	
	//장바구니 삭제
	@Override
	public void basketDel(int b_num) {
		sqlSession.delete(namespace+".basketDel", b_num);
	}

	//장바구니 수량 변경
	@Override
	public void amountChange(BasketVO vo) {
		sqlSession.update(namespace+".amountChange", vo);
	}

	//g3_user - u_like 컬럼 가져오기 였으나
	// 코드지운거 주석처리 깜빡함
	// 첨에는 likeArr배열에 차례대로 p_num,p_image,p_price
	// 저렇게 가져와서 split(",") 하려고 했는데
	// p_num 이 리턴해도 뷰페이지에서 필요하지않아
	// List 반환 해서 그대로 사용키로 변경
	@Override
	public List<Ad_ProductVO> getLike(String id) {
		String like = sqlSession.selectOne(namespace+".getLike",id);
		String[] likeArr = like.split(",");
		List<Ad_ProductVO> likeList = new ArrayList<>();
		for(int i=0 ; i<likeArr.length ; i++) {
			likeList.add(sqlSession.selectOne(namespace+"getImagePriceFromProduct",likeArr[i]));
		}
		return likeList;
	}
	
	
}
