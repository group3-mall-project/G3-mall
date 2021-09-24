package com.g3.service;

import java.util.List;

import com.g3.domain.BoardVO;

public interface BoardService {

	
	// 게시글 저장
	public void insertBoard(BoardVO bovo);

	public void reWriteBoard(BoardVO bovo);
	
	public List getBoardList();
	
	public List getCategoryBoardList(String bo_category);
	
	public BoardVO getBoardContent(int bo_num);
	
	public void deleteContent(int bo_num);
	
	public void modify(BoardVO vo);
	
	
}
