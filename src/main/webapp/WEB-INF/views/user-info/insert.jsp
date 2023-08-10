<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="text" id="uiName"  placeholder="이름"><br>
	<input type="text" id="uiId"  placeholder="아이디"><br>
	<input type="password" id="uiPwd"  placeholder="비밀번호"><br>
	<textarea type="text" id="uiDesc" placeholder="소개" ></textarea><br>
	<input type="text" id="uiBirth"  placeholder="생일"><br>
	<button onclick="sendObj()">완료</button>
	<button type="reset">취소</button>
</body>
<script>
	function sendObj(){
		const param={
				uiName : document.querySelector('#uiName').value,
				uiId : document.querySelector('#uiId').value,
				uiPwd : document.querySelector('#uiPwd').value,
				uiDesc : document.querySelector('#uiDesc').value,
				uiBirth : document.querySelector('#uiBirth').value
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/user-info/insert');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					if(xhr.responseText === '1'){
						alert('성공');
					}else{
						alert('실패');
					}
					location.href='/views/user-info/list';
				}
			}
		}
		xhr.send(json);
	}
</script>
</html>