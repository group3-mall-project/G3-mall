package com.g3.service;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.g3.domain.BoardVO;
import com.g3.persistence.BoardDAO;




@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bodao;
	
	private final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public void insertBoard(BoardVO bovo) {
		System.out.println("S : DAO-insertBoard(BoardVO bovo) 호출 (연결)");
		bodao.insertBoard(bovo);
		System.out.println("S: 게시물 저장 완료!");
	}
	
	@Override
	public void reWriteBoard(BoardVO bovo) {
		System.out.println("S : DAO-insertBoard(BoardVO bovo) 호출 (연결)");
		bodao.reWriteBoard(bovo);
		System.out.println("S: 게시물 저장 완료!");
	}

	@Override
	public List getBoardList() {
		System.out.println("S : getBoardList() 호출 (연결)");
		
		List boardList = bodao.getBoardList();
		
		return boardList;
	}

	@Override
	public List getCategoryBoardList(String bo_category) {
		System.out.println("S : getCategoryBoardList(String category) 호출 (연결)");
		System.out.println("S : category"+bo_category+"@@@@@@@@@@@");
		
		List categoryBoardList = bodao.getCategoryBoardList(bo_category);
		
		return categoryBoardList;
	}

	@Override
	public BoardVO getBoardContent(int bo_num) {
		System.out.println("S : getBoardContent(int bo_num) 호출 (연결)");
		
		BoardVO bovo = bodao.getBoardContent(bo_num);
		
		return bovo;
	}

	@Override
	public void deleteContent(int bo_num) {
		System.out.println("S : deleteContent(int bo_num) 호출 (연결)");
		
		bodao.deleteContent(bo_num);
		
		System.out.println("S : 글 삭제 완료");
	}

	@Override
	public void modify(BoardVO vo) {
		
		logger.info("S: modify(BoardVO vo) 호출! ");
		
		bodao.modify(vo);
		
		logger.info("S: 글 수정완료");
		
		
		
	}
	
	

	

}
