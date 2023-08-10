<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호: <span id="num">${param.uiNum}</span><br>
	이름: <span id="name"></span><br>
	생년월일: <span id="birth"></span><br>
	소개: <span id="desc"></span><br>
	가입일: <span id="credat"></span><br>
	<button onclick="goPage('/views/user-info/update?uiNum=${param.uiNum}')">수정</button>
	<button onclick="deleteObj()">삭제</button>
</body>
<script>
	function deleteObj(){
		const param = {
				num : '${param.uiNum}'
		}
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST','/user-info/delete');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					if(xhr.responseText === '1'){
						alert('삭제 완료');
					}else{
						alert('삭제 불가');
					}
					location.href='/views/user-info/list';
				}
			}
		}
		xhr.send(json);
	}
	

	function goPage(url){
		location.href = url;
	}
	window.addEventListener('load',function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/user-info/view?uiNum=${param.uiNum}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const obj = JSON.parse(xhr.responseText);					
						document.querySelector('#name').innerText = obj.uiName;
						document.querySelector('#birth').innerText = obj.uiBirth;
						document.querySelector('#desc').innerText = obj.uiDesc;
						document.querySelector('#credat').innerText = obj.credat;
				}
			}
		}
		xhr.send();
	})
</script>
</html>