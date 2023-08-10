<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" id="num"> 이름:
	<input type="text" id="name">
	<br> 나이:
	<input type="text" id="age">
	<br> 주소:
	<input type="text" id="address">
	<br>
	<button onclick='sendObj()'>확인</button>
</body>
<script>
	function sendObj() {
		const param = {
			num : document.querySelector('#num').value,
			name : document.querySelector('#name').value,
			age : document.querySelector('#age').value,
			addres : document.querySelector('#address').value
		}
		console.log(param);
		const json = JSON.stringify(param);
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/list/update');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadtstatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					if (xhr.responseText === '1') {
						alert('성공입니다');
					} else {
						alert('실패');
					}
					location.href = '/views/list'
				}
			}
		}
		xhr.send(json);
	}

	window.addEventListener('load', function() {
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/list/update?num=${param.num}');
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					const obj = JSON.parse(xhr.responseText);
					for ( const key in obj) {
						document.querySelector('#' + key).value = obj[key];
					}
				}
			}
		}
		xhr.send();
	})
</script>
</html>