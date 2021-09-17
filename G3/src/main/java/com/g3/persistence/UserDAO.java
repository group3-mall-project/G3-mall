package com.g3.persistence;

import com.g3.domain.UserVO;

public interface UserDAO {
	
	// 구현동작 - 추상메서드
	
	// 회원정보 가입
	public void insertUser(UserVO vo);
	
	// 로그인
	public UserVO loginUser(UserVO VO); 
	
	// 사용자 정보 조회
	public UserVO getUser(String u_id);
	
	// 회원정보 수정
	public void updateUser(UserVO vo);
	
	// 회원 탈퇴
	public void deleteUser(UserVO vo);
	
	// 아이디 유효성 검사
	public String u_idCheck(String u_id);
	
	// ID 찾기 DB에 이메일이 있는지 확인하기
	public UserVO getEmail(String u_email);
	
	// PW이메일로 보내주기 id,email맞는지 확인
	public UserVO findPw(UserVO vo);
	
	// PW를 난수로 바꿔서 저장
	public void updatePw(UserVO vo);
	
	
}
