<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
	</tr>
	<tbody id="tbody"></tbody>
		<tr>
			<td><button onclick="location.href='/views/user-info/insert'">등록</button>
		<tr>
</table>

<script>

function goPage(url) {
	location.href = url;
}
const loadFunc = function() {
	const xhr = new XMLHttpRequest();
	const searchStr = document.querySelector('#searchStr');
	const searchType = document.querySelector('#searchType');
	
	let url = '/user-info/list?';
	xhr.open('GET',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4){
			if(xhr.status===200){
				const user = JSON.parse(xhr.responseText);
				let html = '';
				for(const userInfo of user){
					html += '<tr>';
					html += '<td>'+ userInfo.uiNum + '</td>';
					html += '<td><a href="/views/user-info/view?uiNum=' + userInfo.uiNum +'">' + userInfo.uiName + '</a></td>';
					html += '<td>'+ userInfo.uiId + '</td>';					
					html += '</tr>';
				}
				document.querySelector('#tbody').innerHTML = html;
			}
		}
	}
	xhr.send();
}
window.addEventListener('load',loadFunc());
</script>
</body>
</html>