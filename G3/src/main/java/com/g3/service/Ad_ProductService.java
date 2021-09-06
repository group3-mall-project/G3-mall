package com.g3.service;

import com.g3.domain.Ad_ProductVO;

public interface Ad_ProductService {

	public void AddProduct(Ad_ProductVO advo);
	
	public void ListProduct();
	
	public void CutProduct(int p_num);
	
	public void ModifyProduct(Ad_ProductVO advo);
}
