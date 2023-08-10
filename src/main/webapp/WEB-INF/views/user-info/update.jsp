<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input type="hidden" id="uiNum"  ><br>
	이름:<input type="text" id="uiName" ><br>
	아이디:<input type="text" id="uiId"  ><br>
	비번:<input type="text" id="uiPwd"  ><br>
	소개:<textarea type="text" id="uiDesc" ></textarea><br>
	생년월일:<input type="text" id="uiBirth"  ><br>
	<button onclick='sendObj()'>완료</button>
	<button type="reset">취소</button>

</body>
<script>
function sendObj(){
	const param = {
			uiNum : document.querySelector('#uiNum').value,
			uiName : document.querySelector('#uiName').value,
			uiId : document.querySelector('#uiId').value,
			uiPwd : document.querySelector('#uiPwd').value,
			uiDesc : document.querySelector('#uiDesc').value,
			uiBirth : document.querySelector('#uiBirth').value
	}
	const json = JSON.stringify(param);

	const xhr = new XMLHttpRequest();
	xhr.open('POST','/user-info/update');
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

window.addEventListener('load',function(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','/user-info/view?uiNum=${param.uiNum}');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				const obj = JSON.parse(xhr.responseText);		
					document.querySelector('#uiNum').value = obj.uiNum;
					document.querySelector('#uiName').value = obj.uiName;
					document.querySelector('#uiId').value = obj.uiId;
					document.querySelector('#uiPwd').value = obj.uiPwd;
					document.querySelector('#uiDesc').value = obj.uiDesc;
					document.querySelector('#uiBirth').value = obj.uiBirth;
			}
		}
	}
	xhr.send();
})
</script>
</html>