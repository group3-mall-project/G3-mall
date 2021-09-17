<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link href="login.css?ddd" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<a href="${url}"> 
		<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/>
	</a>
</div><br>



</body>
</html>



