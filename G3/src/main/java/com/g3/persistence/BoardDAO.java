package com.g3.persistence;

import java.util.List;

import com.g3.domain.BoardVO;

public interface BoardDAO {
	
	// 게시물 저장
	public void insertBoard(BoardVO bovo);
	
	public List getBoardList();
	
	public List getCategoryBoardList(String bo_category);
	
	public BoardVO getBoardContent(int bo_num);
	
	public void reWriteBoard(BoardVO bovo);
	
	public void deleteContent(int bo_num);
	
	public void modify(BoardVO vo);
	
}
