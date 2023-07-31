<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/user-info/delete?uiNum=${userInfo.uiNum}" method="POST">
	<input type="hidden" id="uiNum" name="uiNum" value="${userInfo.uiNum}">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${userInfo.uiNum}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${userInfo.uiName}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${userInfo.uiId}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${userInfo.uiPwd}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${userInfo.uiDesc}</td>
			</tr>
			<tr>
				<th>생일</th>
				<td>${userInfo.uiBirth}</td>
			</tr>
			<tr>

				<td><button type="button" onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'">수정</button>
					<button>삭제</button>
				<td>
			</tr>
			</form>
		</table>
</body>
</html>