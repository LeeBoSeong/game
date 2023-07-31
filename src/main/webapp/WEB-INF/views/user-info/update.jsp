<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-info/update" method="POST">
	<input type="hidden" id="uiNum" name="uiNum" value="${userInfo.uiNum}"><br>
	<input type="text" id="uiName" name="uiName" value="${userInfo.uiName}"><br>
	<input type="text" id="uiId" name="uiId" value="${userInfo.uiId}"><br>
	<input type="text" id="uiPwd" name="uiPwd" value="${userInfo.uiPwd}"><br>
	<textarea type="text" name="uiDesc" >${userInfo.uiDesc}</textarea><br>
	<input type="text" id="uiBirth" name="uiBirth" value="${userInfo.uiBirth}"><br>
	<button>완료</button>
	<button type="reset">취소</button>
</form>
</body>
</html>