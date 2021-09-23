package com.g3.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.g3.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private final Logger logger = 
			LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private static final String namespace ="com.g3.mapper.BoardMapper";
	
	@Override
	public List getBoardList() {
		System.out.println("DAO:List getBoardList() 호출");
		System.out.println("DAO: boardMapper.xml로 이동");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		boardList = sqlSession.selectList(namespace+".getBoardList");
		
		
		return boardList;
	}

	

	@Override
	public void insertBoard(BoardVO bovo) {
		System.out.println("DAO: insertBoard(BoardVO bovo) 메서드 호출");
		System.out.println("DAO: boardMapper.xml 이동해서 해당 구문을 수행");
		System.out.println(sqlSession.selectOne(namespace+".maxBo_num")+"@@@@@@@@@@");
		int bo_ref = 0;
		if(sqlSession.selectOne(namespace+".maxBo_num")==null) {
			bo_ref = 0;
		}else {bo_ref = Integer.parseInt((String)sqlSession.selectOne(namespace+".maxBo_num"));}
		
		
		bovo.setBo_re_ref(bo_ref);
		
		sqlSession.insert(namespace+".insertBoard", bovo);
		
		System.out.println("DAO: boardMapper.xml-insertBoard 구문 실행완료!");
		System.out.println("DAO: 게시글 저장 완료!");
		
	}



	@Override
	public List getCategoryBoardList(String bo_category) {
		System.out.println("DAO: getCategoryBoardList(String bo_category) 메서드 호출");
		System.out.println("DAO: boardMapper.xml 이동해서 해당 구문을 수행");
		//System.out.println("DAO: bo_category"+bo_category+"@@@@@@@@@@@@@@@@@@@@");
		
		List<BoardVO> categoryBoardList = new ArrayList<BoardVO>();
		
		categoryBoardList = sqlSession.selectList(namespace+".getCategoryBoardList", bo_category);
		
		//System.out.println(categoryBoardList+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		return categoryBoardList;
	}



	@Override
	public BoardVO getBoardContent(int bo_num) {
		System.out.println("DAO: getBoardContent(int bo_num) 메서드 호출");
		System.out.println("DAO: boardMapper.xml 이동해서 해당 구문을 수행");
		
		BoardVO bovo = sqlSession.selectOne(namespace+".getBoardContent", bo_num);
		
		return bovo;
	}



	@Override
	public void reWriteBoard(BoardVO bovo) {
		System.out.println("DAO: reWriteBoard(BoardVO bovo) 메서드 호출");
		System.out.println("DAO: boardMapper.xml 이동해서 해당 구문을 수행");
		bovo.setBo_re_ref(Integer.parseInt((String)sqlSession.selectOne(namespace+".bo_re_ref", bovo)));
		bovo.setBo_re_seq(Integer.parseInt((String)sqlSession.selectOne(namespace+".bo_re_seq", bovo)));
		sqlSession.update(namespace+".reWriteupdate", bovo);
		sqlSession.insert(namespace+".reWriteBoard", bovo);
		System.out.println("DAO: boardMapper.xml-insertBoard 구문 실행완료!");
		System.out.println("DAO: 답글 저장 완료!");
		
	}



	@Override
	public void deleteContent(int bo_num) {
		System.out.println("DAO : deleteContent(int bo_num) 메서트 호출");
		System.out.println("DAO: boardMapper.xml 이동해서 해당 구문을 수행");
		sqlSession.delete(namespace+".deleteContent",bo_num);
		System.out.println("DAO: boardMapper.xml-insertBoard 구문 실행완료!");
		System.out.println("DAO: 글 삭제 실행완료!");
		
	}



	@Override
	public void modify(BoardVO vo) {
		
		logger.info("modify(BoardVO vo) 연결!");
		sqlSession.update(namespace+".modify", vo);
		logger.info("modify(BoardVO vo) 수정완료!");
		
		
	}
	
	
	}


