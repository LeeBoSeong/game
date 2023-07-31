<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board-info/update" method="POST">
	<input type="hidden" id="biNum" name="biNum" value="${board.biNum}"><br>
	<input type="text" id="biTitle" name="biTitle" value="${board.biTitle}"><br>
	<textarea type="text" name="biContent" >${board.biContent}</textarea><br>
	<button>완료</button>
	<button type="reset">취소</button>
</form>
</body>
</html>