<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr.link {
	background-color: white;
	color: black;
	cursor: pointer;
}

tr.link:hover {
	color: blue;
	cursor: pointer;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
		</tr>
		<tbody id="tbody">
		</tbody>
	</table>
	<script>
		function goPage(num){
			location.href = '/views/one?num=' + num;
		}
		function loadFunc(){
			const xhr = new XMLHttpRequest();
			xhr.open("GET","/list/list");
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const obj = JSON.parse(xhr.responseText);
						let html = '';
						for(const list of obj){
							html += '<tr class="link" onclick="goPage('+ list.num +')">';
							html += '<td>'+list.num + '</td>';
							html += '<td>'+list.name + '</td>';
							html += '<td>'+list.age + '</td>';
							html += '<td>'+list.address + '</td>';
							html += '</tr>';							
						}
						document.querySelector('#tbody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load',loadFunc);
	</script>
</body>
</html>