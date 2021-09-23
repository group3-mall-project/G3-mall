<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>


</head>
<body>

	<fieldset>
		<legend>이메일로 아이디 찾기</legend>
		<form action="./findUserId" name="doc" method="post" onsubmit="return findUserId();">
			<label>이메일</label>
			<input type="text" name="u_email" placeholder="이메일을 적어주세요."><br>
			<span id="checkEmail"></span>
			<input type="submit" value="아이디 찾기">
		</form>
	</fieldset>
	
<script type="text/javascript">

	function findUserId() {
		
		var u_id ='${u_id}';
		console.log("이메일"+u_id);
		if (u_id == null) {
			alert("존재하지 않는 이메일입니다.");
			return false;
		}else{
			alert("이메일로 아이디를 전송했습니다.");
		}
		
	}
	
	
</script>
	
</body>
</html>
