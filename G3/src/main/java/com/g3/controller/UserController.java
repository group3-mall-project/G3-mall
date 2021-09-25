package com.g3.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g3.domain.UserVO;
import com.g3.service.SNSLogin;
import com.g3.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@Autowired
	private NaverLoginBO naverSns;
	
	// 이메일 전송때필요한 파일 적용
	@Autowired
	private JavaMailSender mailSender;
	
	// RequestMethod.GET매핑할시 redirect를 안쓴다
	// RequestMethod.POST 매핑할시 redirect를 쓴다
	// POST는 데이터를 submit 시킬때 사용한다
	
	   // http://localhost:8088/user/main
	// 메인페이지 보는 메서드
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public void mainGet() throws Exception{
		
		logger.info(" mainGet() 호출!!");
		logger.info(" /view/user/main.jsp 페이지로 이동");
		
	}
	
	  // http://localhost:8088/user/join
	// 회원 가입 창으로 넘어가는 메서드
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public void joinGet() throws Exception{
		
		logger.info(" joinGet() 호출!!");
		logger.info(" /view/user/join.jsp 페이지로 이동");
		
	}
	
	// 회원 가입성공시 정보를 넘겨주고 메인 페이지로 이동
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String joinPOST(UserVO vo) throws Exception{
		
		logger.info(" joinPOST() 호출@@@@");
		
		logger.info(" 회원 가입 정보"+vo);
		
		service.userJoin(vo);
		
		// main.jsp 페이지 이동
		logger.info(" main 페이지로 이동");
		return "redirect:/user/main";
	}
	
	// 아이디 유효성 검사
	@RequestMapping(value = "/idCheck",method = RequestMethod.POST,produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String idCheck(@RequestParam("u_id") String u_id, Model model)throws Exception{
		
		logger.info("idCheck() 호출@@@@"+u_id+"@@");
		
		String result = service.u_idCheck(u_id);
		
		model.addAttribute("result", result);
		
		logger.info(" join 페이지로 이동 : "+result);
		
		return result;
	}
	
	// 이메일 중복 유효성 검사
	@RequestMapping(value = "/emailCheck",method = RequestMethod.POST,produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String emailCheck(@RequestParam("u_email") String u_email, Model model)throws Exception {
		
		logger.info("emailCheck() 호출@@@@"+u_email);
		String echeck = service.u_emailCheck(u_email);
		
		model.addAttribute("echeck",echeck);
		
		logger.info(" join 페이지로 이동"+echeck);
		
		return echeck;
	}
	
	// 이메일 인증 하기
	@RequestMapping(value = "/emailCert",method = RequestMethod.GET)
	public void emailCert(UserVO vo, HttpSession session, Model model)throws Exception{
		
		logger.info("emailCert() 호출@@@@");
		session.setAttribute("u_email",vo.getU_email());
		String certNum = service.createCertNum();
		
		boolean result = service.emailCertSend(vo.getU_email(),certNum);
		
		logger.info(" emailCert.jsp 페이지로 이동"+vo.getU_email());
		
		
		model.addAttribute("u_email",vo.getU_email());
		model.addAttribute("result",result);
		model.addAttribute("certNum",certNum);
		
		logger.info("이메일 전송 하는곳 마지막"+vo.getU_email());
		logger.info("이메일 인증 성공 여부"+result);
		
	}
	
	
	// 로그인 창으로 넘어가기
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void loginGet(Model model) throws Exception {
		
		logger.info(" loginGet() 호출!!");
		
		SNSLogin snsLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", snsLogin.getNaverAuthURL());
		
		
		
		logger.info(" /view/user/login.jsp 페이지로 이동");
		
	}
	
	// 로그인시 메인 화면으로 넘어오기
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String loginPOST(UserVO vo,HttpSession session)throws Exception{
		
		logger.info(" loginPOST() 호출!!");
		logger.info(" 회원 가입 정보"+vo);
		
		UserVO loginVO = service.userLogin(vo);
		
		if (loginVO == null) {
			return "redirect:/user/login";
		}
		
		session.setAttribute("u_id", loginVO.getU_id());
		
		// main.jsp 페이지 이동
		logger.info("로그인 성공 main페이지로 이동");
		
		return "redirect:/user/main";
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logoutGet(HttpSession session) throws Exception{
		
		logger.info("logoutGet() 호출!!");
		
		session.invalidate();
		
		logger.info("로그아웃 완료@@@@");
		
		return "redirect:/user/main";
	}
	
	// 사용자 회원 정보조회
	@RequestMapping(value = "/userInfo",method = RequestMethod.GET)
	public void userInfoGet(HttpSession session,Model model) throws Exception{
		
		logger.info("userInfoGet() 호출@@@");
		
		String u_id  = (String) session.getAttribute("u_id");
		
		UserVO vo = service.getUser(u_id);
		logger.info("회원정보 : "+vo);
		
		model.addAttribute("vo",vo);
		
	}
	
	// 회원정보 수정 페이지 이동
	@RequestMapping(value = "/userUpdate",method = RequestMethod.GET)
	public void userUpdateGet(HttpSession session,Model model) throws Exception{
		
		logger.info("userUpdateGet() 호출@@@@");
		
		String u_id = (String) session.getAttribute("u_id");
		
		// 기존의 회원정보를 가져오기
		model.addAttribute("vo",service.getUser(u_id));
		
		logger.info("/user/userUpdate.jsp페이지 이동");
		
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/userUpdate",method = RequestMethod.POST)
	public String userUpdatePOST(UserVO vo) throws Exception{
		
		logger.info("userUpdatePOST() 호출@@@@@");
		
		service.updateUser(vo);
		
		logger.info("main 페이지 이동");
		
		return "redirect:/user/main";
	}
	
	// 회원 탈퇴 페이지 이동
	@RequestMapping(value = "withdraw",method = RequestMethod.GET)
	public void userDeleteGet(HttpSession session,Model model) throws Exception{
		
		logger.info("userDeleteGet() 호출@@@@@");
		
		String u_id = (String) session.getAttribute("u_id");
		
		model.addAttribute("vo",service.getUser(u_id));
		
		logger.info("withdraw 페이지 이동");
		
	}
	
	// 회원 탈퇴
	@RequestMapping(value = "/withdraw",method = RequestMethod.POST)
	public String userDeletePOST(UserVO vo,HttpSession session) throws Exception{
		
		logger.info("userDeletePOST() 호출@@@@@");
		
		service.deleteUser(vo);
		
		session.invalidate();
		
		logger.info("main 페이지 이동");
		
		return "redirect:/user/main";
	}
	
	// 회원 아이디 찾기 페이지 이동
	@RequestMapping(value = "/findId",method = RequestMethod.GET)
	public void findUserIdGet()throws Exception{
		
		logger.info("findUserIdGet() 호출@@@@@");
		
		logger.info("findId.jsp 페이지 이동");
	}
	
	// 회원 아이디 이메일로 전송하기
	// if문 고쳐야함 
	@RequestMapping(value = "/findUserId",method = RequestMethod.POST)
	public String findUserIdPOST(@RequestParam("u_email") String u_email,Model model) throws Exception{
		
		logger.info("findUserIdPOST() 호출@@@@@"+u_email);
		
		String u_id = service.confirmEmail(u_email);
		logger.info("이메일 받아오는값 : "+u_id);
		if (u_id == null) {
			model.addAttribute("u_id",u_id);
			return "redirect:/user/findId";
		}
		model.addAttribute("u_id",u_id);
		service.sendId(u_id,u_email);
		
		logger.info("유저가 적은 이메일이 DB에 있는지 확인"+u_id);
		
		return "redirect:/user/login";
	}
	
	// 회원 비밀번호 찾기 페이지 이동
	@RequestMapping(value = "/findPw",method = RequestMethod.GET)
	public void findPwGet()throws Exception{
		logger.info("findPwGet() 호출@@@@@");
		
		logger.info("findPw.jsp 페이지 이동");
		
	}
	
	// 회원 비밀번호 이메일 전송
	// if문으로 제어를 해줘야함
	@RequestMapping(value = "/findUserPw",method = RequestMethod.POST)
	public String sendPwPOST(UserVO vo,Model model) throws Exception{
		logger.info("sendPwPOST() 호출@@@@@");
		
		String u_email = service.findUserPw(vo);
		logger.info("확인 : "+u_email);
		if(u_email == null) {
			return "redirect:/user/findPw";
		}
		
		String createPw = service.createPw();
		
		logger.info("이메일? : "+u_email+vo.getU_email());
		vo.setU_pw(createPw);
		service.updatePw(vo);
		
		service.sendPw(u_email,createPw);
		
		return "redirect:/user/login";
	}
	
	
	
	
	
	
}






