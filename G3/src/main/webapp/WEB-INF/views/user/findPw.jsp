<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>

<%
	String u_id = (String)session.getAttribute("u_id");

%>



<fieldset>
	<legend>이메일로 비밀번호 찾기</legend>
	
	<form action="./findUserPw" name="doc" method="post" onsubmit="return findUserPw();">
		<label>아이디</label>
		<input type="text" name="u_id" placeholder="아이디를 적어주세요."><br>
		<label>이메일</label>
		<input type="text" name="u_email" placeholder="이메일을 적어주세요."><br>
		<input type="submit" value="비밀번호 찾기">
	</form>
</fieldset>


<script type="text/javascript">
	function findUserPw() {
		
		var u_pw ='${u_pw}';
		console.log("이메일"+u_pw);
		if (u_pw == null) {
			alert("무언가 잘못되었습니다.");
			return false;
		}else{
			alert("이메일로 비밀번호를 전송했습니다.");
		}
		
		
		
	}
</script>
