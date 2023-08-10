<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호 :<span id="num">${param.num}</span><br> 
	이름 :<span id="name"></span><br>
	나이 :<span id="age"></span><br> 
	주소 :<span id="address"></span><br>
	<script>
	window.addEventListener('load',function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/list/one?num='+${param.num});
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const obj = JSON.parse(xhr.responseText);
					for(const key in obj){
						document.querySelector('#'+key).innerText = obj[key];
					}
				}
			}
		}
		xhr.send();
	})
</script>
</body>
</html>