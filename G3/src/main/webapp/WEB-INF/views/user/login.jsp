<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link href="login.css?ddd" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 
		src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" 
		charset="utf-8">
</script>
<title>Insert title here</title>
</head>
<body>
	
<fieldset >
 <legend>Login</legend> 
	<form action="./login" method="post" name="login">
	 <input type="text" name="u_id" placeholder="id입력"><br>
  	 <input type="password" name="u_pw" placeholder="비밀번호"><br>
 <input type="submit" value="로그인">
<!--  <input type="button" value="가입하기" onclick="location.href='./join';">
 <input type="button" value="ID찾기" onclick="location.href='./findId';">
 <input type="button" value="ID찾기" onclick="location.href='./findId';"> -->
</form>
</fieldset>
<button><a href="./join">회원가입하기</a></button>
<button><a href="./findId">ID찾기</a></button>
<button><a href="./findPw">PW찾기</a></button>

<br> 
<!-- 네이버 로그인 창으로 이동 --> 
<div id="naver_id_login" style="text-align:center">
	<a href="${naver_url}"> 
		<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
	</a>
</div><br> 
<!-- 네이버아이디로로그인 버튼 노출 영역 -->
  <div id="naver_id_login"></div>
  <!-- //네이버아이디로로그인 버튼 노출 영역 -->
<!--   <script type="text/javascript">
  	var naver_id_login = new naver_id_login("unC2JZuizAwdG8LNJjlk", "http://localhost:8080/web/user/login_callback");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain("http://localhost:8080/web/user/login");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script> -->


</body>
</html>



