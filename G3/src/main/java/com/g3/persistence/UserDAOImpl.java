package com.g3.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.g3.domain.UserVO;

//@Repository : DAO역활의 파일설정 ( 스프링에 해당 파일이 DAO라고 설정)
//=> root-context.xml에서 bean으로 인식

@Repository
public class UserDAOImpl implements UserDAO{
	
	// 디비연결(root-context.xml에서 다 설정했다) => 객체 의존주입 (root-context.xml)
	@Inject
	private SqlSession sqlSession;
	
	// userMapper.xml 파일에 접근가능한 이름(주소)
	private static final String namespace="com.g3.mapper.UserMapper";

	// 회원 가입
	@Override
	public void insertUser(UserVO vo) {
		System.out.println(" DAO : insertUser(vo) 메서드 호출");
		System.out.println(" DAO : userMapper.xml 이동 해당 구문 수행");
		
		sqlSession.insert(namespace+".insertUser",vo);
		
		System.out.println(" DAO : userMapper.xml-insertUser 구문 실행 완료!");
		System.out.println(" DAO : 회원가입 완료!");
	}
	
	// 로그인
	@Override
	public UserVO loginUser(UserVO vo) {
		System.out.println(" DAO : loginUser(vo) 메서드 호출");
		System.out.println(" DAO : userMapper.xml 이동 해당 구문 수행");
		
		UserVO loginVO = sqlSession.selectOne(namespace+".loginUser",vo);
		
		System.out.println(" DAO : userMapper.xml-loginUser 구문 실행 완료!");
		System.out.println(" DAO : 로그인 완료!");
		
		return loginVO;
	}
	
	// 사용자 회원 정보
	@Override
	public UserVO getUser(String u_id) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		UserVO vo = sqlSession.selectOne(namespace+".getUser",u_id);
		
		System.out.println(" DAO : 처리된 결과를 리턴 받아서 사용");
		
		return vo;
	}
	
	// 회원정보 수정
	@Override
	public void updateUser(UserVO vo) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		sqlSession.update(namespace+".updateUser",vo);
		
		System.out.println(" DAO : 정보 수정 완료!");
		
	}
	
	// 회원 탈퇴
	@Override
	public void deleteUser(UserVO vo) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		sqlSession.delete(namespace+".deleteUser",vo);
		
		System.out.println(" DAO : 회원 탈퇴 완료!");
		
	}
	
	// 아이디 유효성 검사
	@Override
	public String u_idCheck(String u_id) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		String result = sqlSession.selectOne(namespace+".u_idCheck",u_id);
		
		System.out.println(" DAO : 아이디 유효성 검사 완료!"+result);
		
		return result;
	}
	
	// ID 찾기 DB에 이메일이 있는지 확인하기
	@Override
	public UserVO getEmail(String u_email) {
		
		System.out.println(" DAO : memberMapper.xml 이동"+u_email);
		
		UserVO vo = sqlSession.selectOne(namespace+".getEmail",u_email);
		
		System.out.println(" DAO : 이메일 검사 완료"+vo);
		
		return vo;
	}
	
	// PW이메일로 보내주기 id,email맞는지 확인
	@Override
	public UserVO findPw(UserVO vo) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		vo = sqlSession.selectOne(namespace+".checkFindPw",vo);
		
		System.out.println(" DAO : 이메일 검사 완료"+vo);
		
		return vo;
	}
	
	// PW를 난수로 바꿔서 저장
	@Override
	public void updatePw(UserVO vo) {
		
		System.out.println(" DAO : memberMapper.xml 이동");
		
		sqlSession.update(namespace+".updatePw",vo);
		
		System.out.println(" DAO : 비밀번호 변경 완료 완료"+vo);
		
	}
	
	
}
