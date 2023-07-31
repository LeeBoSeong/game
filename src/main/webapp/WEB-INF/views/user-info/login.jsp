<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user-info/login" method="POST">
		<input type="text" id="uiId" name="uiId" placeholder="아이디"><br>
		<input type="password" id="uiPwd" name="uiPwd" placeholder="비밀번호"><br>
		<button>확인</button>
	</form>
</body>
</html>