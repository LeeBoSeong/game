<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-info/insert" method="POST">
	<input type="text" id="uiName" name="uiName" placeholder="이름"><br>
	<input type="text" id="uiId" name="uiId" placeholder="아이디"><br>
	<input type="password" id="uiPwd" name="uiPwd" placeholder="비밀번호"><br>
	<textarea type="text" name="uiDesc" placeholder="소개" ></textarea><br>
	<input type="text" id="uiBirth" name="uiBirth" placeholder="생일"><br>
	<button>완료</button>
	<button type="reset">취소</button>
</form>
</body>
</html>