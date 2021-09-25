package com.g3.service;

import java.util.UUID;
import javax.inject.Inject;
import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.g3.domain.UserVO;
import com.g3.persistence.UserDAO;

//@Service : 스프링에서 해당 객체를 서비스객체(bean)로 인식하도록 설정

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO udao;
	@Autowired
	private JavaMailSender mailSender;
	
	// 회원 가입
	@Override
	public void userJoin(UserVO vo) {
		System.out.println(" S : DAO - insertUser(vo) 호출");
		
		udao.insertUser(vo);
		
		System.out.println(" S : 회원가입 처리완료");
	}

	// 로그인 
	@Override
	public UserVO userLogin(UserVO vo) {
		System.out.println(" S : DAO - loginUser(vo) 호출");
		
		UserVO loginResultVO =  udao.loginUser(vo);
		
		System.out.println(" S : "+loginResultVO);
		
		System.out.println(" S : 로그인 처리완료");
		
		
		return loginResultVO;
	}
	
	// 사용자 정보 조회
	@Override
	public UserVO getUser(String u_id) {
		System.out.println(" S : DAO - getUser(id) 호출");
		
		UserVO vo = udao.getUser(u_id);
		
		System.out.println(" S : DAO -> 컨트롤러 이동 @@@@");
		
		return vo;
	}
	
	// 회원정보 수정
	@Override
	public void updateUser(UserVO vo) {
		
		System.out.println(" S : DAO - updateUser(vo) 호출");
		
		udao.updateUser(vo);
		
		System.out.println(" S : DAO -> 컨트롤러 이동 @@@@");
		
	}
	
	// 회원 탈퇴
	@Override
	public void deleteUser(UserVO vo) {
		
		System.out.println(" S : DAO - deleteUser(vo) 호출");
		
		udao.deleteUser(vo);
		
		System.out.println(" S : DAO -> 컨트롤러 이동 @@@@");
		
	}
	
	// 아이디 유효성 검사
	@Override
	public String u_idCheck(String u_id) {
		
		System.out.println(" S : DAO - idCheck(u_id) 호출");
		
		String result = udao.u_idCheck(u_id);
		
		System.out.println(" S : DAO -> 컨트롤러 이동 @@@@"+result);
		
		return result;
	}
	
	// 이메일 중복 유효성 검사
	@Override
	public String u_emailCheck(String u_email) {
		
		System.out.println(" S : DAO - u_emailCheck(u_email) 호출"+u_email);
		
		String echeck = udao.u_emailCheck(u_email);
		
		System.out.println(" S : DAO -> 컨트롤러 이동 @@@@"+echeck);
		
		return echeck;
	}
	
	
	// 이메일 인증에 필요한 난수6자리
	@Override
	public String createCertNum() {
		
		StringBuffer certNum = new StringBuffer();
		
		for (int i = 0; i < 6; ++i) {
			int randNum = (int) (Math.random() * 10.0D);
			certNum.append(randNum);
		}
		
		return certNum.toString();
	}
	
	
	
	// 이메일 인증 전송
	@Override
	public boolean emailCertSend(String u_email, String certNum){
		
		boolean result = true;
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("이메일 : "+u_email+"난수 : "+certNum);

				String setFrom = "gksaudwls124@gmail.com";
				String toMail = u_email;
				String title = "회원가입 인증 이메일 입니다.";
				String content = "G3를이용해 주셔서 감사합니다." +
						 "<br><br>" +
						 "인증 번호는" + certNum + "입니다." +
						 "<br>" +
						 "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
				
				try {
					
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
					helper.setFrom(setFrom);
					helper.setTo(toMail);
					helper.setSubject(title);
					helper.setText(content, true);
					mailSender.send(message);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
		
		return result;
	}
	
	// ID 찾기 DB에 이메일이 있는지 확인하기
	@Override
	public String confirmEmail(String u_email) {
		
		System.out.println(" S : DAO - confirmEmail(vo) 호출"+u_email);
		
		String u_id = udao.getEmail(u_email);
		
		System.out.println(" S : mapper에서 u_email이 있는지 확인"+u_id);
		
		return u_id;
	}
	
	// ID이메일로 보내주기
	@Override
	public void sendId(String u_id, String u_email) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
		
				String setFrom = "gksaudwls124@gmail.com";
				String toMail = u_email;
				String title = "회원님의 아이디 입니다.";
				String content = "G3를이용해 주셔서 감사합니다." +
						 "<br><br>" +
						 "회원님의 아이디는" +u_id+ "입니다." +
						 "<br>";
				
				try {
					
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
					helper.setFrom(setFrom);
					helper.setTo(toMail);
					helper.setSubject(title);
					helper.setText(content, true);
					mailSender.send(message);
				}catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}).start();
	}
	
	// PW이메일로 보내주기 id,email맞는지 확인
	@Override
	public String findUserPw(UserVO vo) {
		
		System.out.println(" S : DAO - findUserPw(u_id,u_email) 호출");
		
		String u_email = udao.findPw(vo);
		
		System.out.println(" S : mapper에서 u_email이 있는지 확인"+vo.getU_email());
		
		return u_email;
	}
	
	// 랜덤 변경할 비밀번호 8자리
	@Override
	public String createPw() {
		
		String randomPw = UUID.randomUUID().toString().replaceAll("-", "");
		randomPw = randomPw.substring(0, 8);
		
		return randomPw;
	}

	// PW를 난수로 바꿔서 저장
	@Override
	public void updatePw(UserVO vo) {
		
		System.out.println(" S : DAO - updatePw(UserVO vo, String createPw) 호출");
		
		udao.updatePw(vo);
		
		System.out.println(" S : 컨트롤러 이동 @@@@");
		
	}
	
	// 변경된 비밀번호 보내기
	@Override
	public void sendPw(String u_email, String createPw) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
		
				String setFrom = "gksaudwls124@gmail.com";
				String toMail = u_email;
				String title = "회원님의 비밀번호 입니다.";
				String content = "G3를이용해 주셔서 감사합니다." +
						 "<br><br>" +
						 "회원님의 비밀번호는" +createPw+ "입니다." +
						 "<br>";
				
				try {
					
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
					helper.setFrom(setFrom);
					helper.setTo(toMail);
					helper.setSubject(title);
					helper.setText(content, true);
					mailSender.send(message);
				}catch (Exception e) {
					e.printStackTrace();
				}	
			}
		}).start();
	}
	
	// 아래부터는 네이버 로그인에 필요한 것들
	
	
	
}