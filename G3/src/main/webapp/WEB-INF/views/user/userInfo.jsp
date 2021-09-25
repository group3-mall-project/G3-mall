<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="join.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member_Info</title>
</head>
<body>
	<%
		String u_id = (String)session.getAttribute("u_id");
	%>
	
		
 	 <fieldset >
	 <legend>회원 정보 </legend>
	 아이디 : ${vo.u_id }<br>
	 이름 : ${vo.u_name }<br>
	 이메일 : ${vo.u_email }<br>
	 주소 : ${vo.u_address }<br>
	 전화번호 : ${vo.u_phone }<br>
	 
 	 <hr>
 	 
 	 <button ><a href="./userUpdate">정보 수정</a></button>
 	 <button ><a href="./main">닫기</a></button>
 	 <button ><a href="./withdraw">회원탈퇴</a></button>
  
 </fieldset>

</body>
</html>