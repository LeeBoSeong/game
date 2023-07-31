<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board-info/delete" method="POST">
	<input type="hidden" id="biNum" name="biNum" value="${board.biNum}">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${board.biNum}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.biTitle}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${board.biContent}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.uiNum}</td>
			</tr>
			

				<td><button type="button" onclick="location.href='/board-info/update?biNum=${board.biNum}'">수정</button>
					<button>삭제</button>
				<td>
			</tr>
			</form>
		</table>

</body>
</html>