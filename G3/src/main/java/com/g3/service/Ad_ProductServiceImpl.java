package com.g3.service;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ListProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CutProduct(int p_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModifyProduct(Ad_ProductVO advo) {
		// TODO Auto-generated method stub
		
	}

}
