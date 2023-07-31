<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board-info/insert" method="POST">
	<input type="text" id="biTitle" name="biTitle" placeholder="제목"><br>
	<textarea type="text" name="biContent" placeholder="내용" ></textarea><br>
	<button>완료</button>
	<button type="reset">취소</button>
</form>
</body>
</html>