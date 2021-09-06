package com.g3.persistence;

import com.g3.domain.Ad_ProductVO;

public interface Ad_ProductDAO {
	
	public void insertProduct(Ad_ProductVO advo);
	
	public Ad_ProductVO getProduct(int p_num);
	
	public void deleteProduct(int p_num);
	
	public void updateProduct(Ad_ProductVO advo);
}
