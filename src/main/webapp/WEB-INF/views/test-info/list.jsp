<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<th>내용</th>
		</tr>
		<tbody id="tbody"></tbody>
	</table>
	<script>
		const getTest = function() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET','/test-info/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						console.log(xhr.responseText);
						const testlist = JSON.parse(xhr.responseText);
						let html = '';
						for(const test of testlist){
							html += '<tr>';
							html += '<td>' + test.tiNum + '</td>';
							html += '<td>' + test.tiName + '</td>';
							html += '<td>' + test.tiDesc + '</td>';
							html += "</tr>";
						}
						document.querySelector('#tbody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load',getTest);
	</script>
</body>
</html>