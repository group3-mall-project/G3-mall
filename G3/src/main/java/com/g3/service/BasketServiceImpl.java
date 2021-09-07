package com.g3.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.g3.persistence.BasketDAO;

@Service
public class BasketServiceImpl implements BasketService{

	@Inject
	private BasketDAO bdao;
	
	
	
}
