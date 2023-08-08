<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글</h2>
	<select name="searchType" id="searchType">
		<option value="1">제목</option>
		<option value="2">작성자</option>
		<option value="3">내용</option>
		<option value="4">제목+내용</option>
		<option value="5">작성자+내용</option>
		<option value="6">제목+작성자</option>
		<option value="7">제목+작성자+내용</option>
	</select>
	<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
	<button onclick="loadFunc()">검색</button>
	<div>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<tbody id="tbody"></tbody>
			<tr>
				<td><button onclick="location.href='/board-info/insert'">등록</button>
			<tr>
		</table>
	</div>
	<script>
		function goPage(url) {
			location.href = url;
		}
		const loadFunc = function() {
			const xhr = new XMLHttpRequest();
			const searchStr = document.querySelector('#searchStr');
			const searchType = document.querySelector('#searchType');
			
			let url = '/json/list?';
			if(searchStr.value!==''){
			url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;

			}
			
			xhr.open('GET', url);
			xhr.onreadystatechange = function(){
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					const obj = JSON.parse(xhr.responseText);
					let html = '';
					for (const board of obj) {
					
						html += '<tr>';
						html += '<td>' + board.biNum + '</td>';
						html += '<td><a href="/views/board-info/view?biNum=' + board.biNum +'">' + board.biTitle + '</a></td>';
						html += '<td>' + board.uiName + '</td>';
						html += '<td>' + board.credat + '</td>';
						html += '</tr>';
					}
					  document.querySelector('#tbody').innerHTML = html;
				}
			}
			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc);
	</script>
</body>
</html>