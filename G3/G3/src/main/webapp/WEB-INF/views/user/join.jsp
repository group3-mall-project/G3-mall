<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link href="join.css?dd" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<title>Join</title>

<script type="text/javascript">
	var id_Check = false;
	var email_Check = false;
	
	
	// 비밀번호 재확인
	function u_pwCheck() {
		var u_pw = document.doc.u_pw.value;
		var irmPassword = document.doc.irmPassword.value;
		
		if (u_pw != irmPassword ) {
			console.log("비밀번호"+u_pw+"확인"+irmPassword);
			$("#u_pwCheck").html("비밀번호가 일치하지 않습니다.").css("color","red");
			return false;
		}else{
			console.log("비밀번호"+u_pw+"확인"+irmPassword);
			$("#u_pwCheck").html("비밀번호가 동일합니다.").css("color","green");
			
		}
		
	}
	
	// 이메일 유효성 검사 및 인증
	function u_emailSend() {
		var u_email = document.doc.u_email.value;
		
		$.ajax({
			type: 'post',
			url: './emailCheck',
			data:({
				u_email: $("#u_email").val()
			}),
			success: function (echeck) {
				
				if (echeck != u_email) {
					console.log("이메일 유효성: "+echeck);
					console.log("이메일 유효성이메: "+u_email);
					$("#u_emailCheck").html("사용 가능한 이메일입니다.");
					$("#u_emailCheck").css("color", "green");
					window.open("./emailCert?u_email="+u_email,'Email 인증요청','width=500, height=400, menubar=no, status=no, toolbar=no');
					email_Check = true;
				}else if(echeck == u_email){
					console.log("이메일 유효성: "+echeck);
					console.log("이메일 유효이쿠: "+u_email);
					$("#u_emailCheck").html("사용 불가능한 이메일 입니다.");
					$("#u_emailCheck").css("color", "red");
					email_Check = false;
				}
			}
			
		});
	}
	
 	function u_idCheck() {
 		var u_id = document.doc.u_id.value;
		
		$.ajax({
			type: 'post',
			url: './idCheck',
			data:({
					u_id: $("#u_id").val()
				}),
			 
			success: function (result) {
				
				if (result != u_id) {
					$("#u_idCheck").html("사용가능한 아이디입니다.");
					$("#u_idCheck").css("color", "green");
					id_Check = true;
				}else if(result == u_id){
					$("#u_idCheck").html("이미 사용중인 아이디입니다.");
					$("#u_idCheck").css("color", "red"); 
					id_Check = false;
				}
			}
		});
	}
	
	
	

	
	function fun1() {
		
		var u_id = document.doc.u_id.value.length;
		var u_pw = document.doc.u_pw.value.length;
		var irmPassword = document.doc.irmPassword.value.length;
		var u_email = document.doc.u_email.value;
		var u_phone = document.doc.u_phone.value;
		
		
		if(u_id == 0 ){
			alert("ID를 입력하세요");
			document.doc.u_id.focus();
			return false;
		}
		if(u_id < 5  || u_id > 13)	{
			alert("ID를 5자리 이상 13자리 이하로 입력하세요");
			document.doc.u_id.focus();
			return false;
		}
		if( u_pw < 7 || u_pw >17 ){
			alert("비밀번호는 8~16자리 사이로 입력하세요");
			document.doc.u_pw.focus();
			return false;	
		}
		
		if( irmPassword == 0  ){
			alert("비밀번호를  확인하세요");
			document.doc.irmPassword.focus();
			return false;	
		}
		
			
		 if(document.doc.u_pw.value != document.doc.irmPassword.value){
			alert("비밀번호가 일치하지 않습니다");
			document.doc.irmPassword.focus();
			return false;	
		} 
		
		if( document.doc.u_name.value.length == 0  ){
			alert("이름을 입력하세요");
			document.doc.u_name.focus();
			return false;	
		}
		
			if(document.doc.u_address.value.length== 0){
			alert("주소를 입력하세요");
			document.doc.u_address.focus();
			return false;
		} 
		
		if(/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/.test(u_email) == false){
			alert("이메일의 양식이 맞지 않습니다.");
			document.doc.u_email.focus();
			return false;
		}
		
		if (/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/.test(u_phone) == false) {
			alert("(-)을 넣어주세요. 전화번호 양식이 맞지 않습니다.");
			document.doc.u_phone.focus();
			return false;
		}
		
		if (document.doc.u_birth.value.length== 0) {
			alert("생일을 입력하세요");
			document.doc.u_birth.focus();
			return false;
		}
		
		if (email_Check == true && id_Check == true) {
			$("#doc").submit();
		}else{
			return false;
		}
		
	}
	
	function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } /* else {
                    document.getElementById("sample6_extraAddress").value = '';
                } */

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('addr1').value = data.zonecode;
                document.getElementById("u_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                //document.getElementById("addr3").focus();
            }
        }).open();
    }
	
		
</script>


</head>
<body>



	 <fieldset class="join">
	 <legend> JOIN </legend>
	 <form action="./join" method="post" name= "doc" id="doc">
	 
	 <label>아이디</label>
	 <input type="text" name="u_id" id="u_id" placeholder="아이디" onblur="u_idCheck();" required><br>
	 <span id="u_idCheck"></span><br>
	 
	 
	 <label>비밀번호</label>
	 <input type="password" name="u_pw" placeholder="비밀번호" required><br>
	 
	 <label>비밀번호 확인</label>
	 <input type="password" name="irmPassword" placeholder="비밀번호확인" onblur="u_pwCheck();" required>
	 <span id="u_pwCheck"></span><br>
	 				
	 <label>이름</label>
	 <input type="text" name="u_name" placeholder="이름" required><br>
	
	 <label>주소</label>
	 <!-- <input type="text" name="addr1" id="addr1" placeholder="우편번호" required> -->
	 <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	 <input type="text" name="u_address" id="u_address" placeholder="주소" required readonly="readonly"><br>
	 <!-- <input type="text" name="addr3" id="addr3" placeholder="상세주소" required><br> -->
	  
	 <label>이메일</label>
	 <input type="email" name="u_email" id="u_email" placeholder="email" required >
	 <input type="button" name="certBtn" id="certBtn" value="메일인증" onclick="u_emailSend();">
	 <span id="u_emailCheck"></span><br>
	 
	<label>전화번호</label>
	<input type="text" name="u_phone" placeholder="전화번호" required><br>
 	
 	
 	<label>성별</label>
 	<input type="radio" name="u_gender" value="남" checked="checked">남자
 	<input type="radio" name="u_gender" value="여">여자<br>
 	
 	<label>생일</label>
 	<input type="date" name="u_birth" placeholder="생일">
 	
 	
 	 <hr>
 	 <input type="button" value="회원가입" onclick="fun1()">
 	 <input type="reset" value="초기화">		
  </form>
 </fieldset>

</body>
</html>