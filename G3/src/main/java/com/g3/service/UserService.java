package com.g3.service;

import com.g3.domain.UserVO;

public interface UserService {
	
	// 수행할 동작을 선언(추상메서드)
	// DAO와 컨트롤러의 연결 => DAO객체의 메서드 호출 
	
	// 회원 가입
	public void userJoin(UserVO vo);
	
	// 로그인
	public UserVO userLogin(UserVO vo);
	
	// 사용자 회원정보
	public UserVO getUser(String u_id);
	
	// 회원 정보 수정
	public void updateUser(UserVO vo);
	
	// 회원 탈퇴
	public void deleteUser(UserVO vo);
	
	// 아이디 유효성 검사
	public String u_idCheck(String u_id);
	
	// 이메일 유효성 검사
	public String u_emailCheck(String u_email);
	
	// 이메일 인증에 필요한 난수6자리
	public String createCertNum();
	
	// 이메일 인증 전송 
	public boolean emailCertSend(String u_email, String certNum);
	
	// ID 찾기 DB에 이메일이 있는지 확인하기
	public String confirmEmail(String u_email); 
	
	// ID이메일로 보내주기
	public void sendId(String u_id, String u_email);
	
	// PW이메일로 보내주기 id,email맞는지 확인
	public String findUserPw(UserVO vo);
	
	// PW를 난수로 바꿔서 저장
	public void updatePw(UserVO vo);
	
	// 랜덤 변경할 비밀번호 8자리
	public String createPw();
	
	// 변경된 비밀번호 보내기
	public void sendPw(String u_email, String createPw);
	
	// 아래부터는 네이버 로그인에 필요한 것들
	
	
	
	
	
	
}
