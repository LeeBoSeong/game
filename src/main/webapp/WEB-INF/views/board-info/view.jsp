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
				<td id="biNum">${param.biNum}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td id="biTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td id="biContent"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td id="uiNum"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td id="credat"></td>
			</tr>
				<td><button type="button" onclick="location.href='/board-info/update?biNum=${board.biNum}'">수정</button>
					<button>삭제</button>
				<td>
			</tr>
		</table>
		<script>
			function loadFunc(){
				const xhr = new XMLHttpRequest();
				xhr.open('GET','/json/one?biNum=${param.biNum}');
				xhr.onreadystatechange = function(){
					if(xhr.readyState === 4){
						if(xhr.status === 200){
							const board = JSON.parse(xhr.responseText);
							
							for(let key in board){
								console.log(key);
								if(document.querySelector('#'+key)){
									document.querySelector('#'+key).innerText = board[key];
								}
							}
						}
					}
				}
				xhr.send();
			}
			window.addEventListener('load', loadFunc);
		</script>
</body>
</html>