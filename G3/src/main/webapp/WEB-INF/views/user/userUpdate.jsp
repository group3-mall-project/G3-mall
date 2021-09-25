<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link href="join.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Member_Update</title>
<%
	String u_id = (String)session.getAttribute("u_id");
%>

	
<script type="text/javascript">
	
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
	
	
	function fun1() {
		
		
		if( document.doc.u_pw.value.length == 0 ){
			alert("비밀번호을 입력하세요");
			document.doc.pass.focus();
			return false;	
		}
		if( document.doc.irmPassword.value.length == 0  ){
			alert("비밀번호를  확인하세요");
			document.doc.irmPassword.focus();
			return false;	
		} 
		
		if(document.doc.u_name.value.length == 0 ){
			alert("이름을 입력하세요");
			document.doc.u_name.focus();
			return false;	
		}
		if(document.doc.u_address.value.length == 0 ){
			alert("주소를 입력하세요");
			document.doc.addr.focus();
			return false;	
		}
		
		if (/^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/.test(u_phone) == false) {
			alert("(-)을 넣어주세요. 전화번호 양식이 맞지 않습니다.");
			document.doc.u_phone.focus();
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

	

 <fieldset >
   <legend> 회원 정보 변경</legend>
	 <form action="./userUpdate" method="post" name= "doc" onsubmit="return fun1();" >
	 
	 <input type="hidden" name="u_id" value="${vo.u_id}">
	 
	 <label>비밀번호</label>
	 <input type="password" name="u_pw" placeholder="비밀번호" ><br>
	 
	 <label>비밀번호 확인</label>
	 <input type="password" name="irmPassword" placeholder="비밀번호확인" onblur="u_pwCheck();" required>
	 <span id="u_pwCheck"></span><br>
	 
	 <label>이름</label>
	 <input type="text" name="u_name" value="${vo.u_name}"><br>
	 
	 <label>주소</label>
	 <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
	 <input type="text" name="u_address" id="u_address" value="${vo.u_address}" required readonly="readonly"><br>
	 
	 <label>전화번호</label>
	 <input type="text" name="u_phone" value="${vo.u_phone}"><br>	
 			 	
 	 <hr>
 	 <input type="submit" value="정보수정">
 	 <input type="button" value="돌아가기" onclick="history.back();">
 		
 
  	</form>
 </fieldset>




</body>
</html>