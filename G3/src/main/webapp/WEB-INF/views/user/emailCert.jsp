<%@page import="com.g3.domain.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<%
	UserVO vo = new UserVO();
%>
<script type="text/javascript">
	var certNum = ${certNum};
 	function checkAuthNum() {
		var checkNum = document.getElementById("authNum").value;
		
		console.log(checkNum);
		console.log(certNum);
		if (!checkNum) {
			alert("인증번호를 입력하세요");
		}else{
			if (checkNum == certNum) {
				alert("성공적으로 인증 되었습니다.");
				opener.document.getElementById("u_email").readOnly = true;
				$("#u_emailCheck",parent.opener.document).text("이메일 인증이 완료되었습니다.").css("color","green");
				opener.document.getElementById("certBtn").disabled = true;
				window.open('','_self').close();
			}else{
				alert("인증번호가 잘못되었습니다.");
				return false;
			}
		}
	}
	
	
	
</script>
	
</head>
<body>
	console.log(${result});
	console.log(${certNum});
	<h1>메일 인증</h1>
	<c:if test="${result == true }">
	<b>${u_email}로 인증 메일을 발송했습니다.</b>
	
	<label>인증번호를 입력해주세요</label>
	<input type="text" id="authNum" name="authNum"><br>
	
	<button type="button" onclick="checkAuthNum()">인증번호 확인하기</button>
	</c:if>
	<c:if test="${result != true}">
		인증 메일 전송 실패
	</c:if>
	
</body>
</html>