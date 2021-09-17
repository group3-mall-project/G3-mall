<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String u_id = (String)session.getAttribute("u_id");
	
		if(u_id == null){
	%>		
			<a href="./login">로그인</a>&nbsp;&nbsp;&nbsp;
			<a href="./join">회원가입</a>
	<%		
		}else if(u_id != null || !u_id.equals("admin")){
	%>		
			<a href="./logout">로그아웃</a>
			<a href="./userInfo">회원정보</a>
	<%		
		}else{
			
			//관리자 
			
		}
		
	%>
	
	
	
	
	
	
	
	
</body>
</html>