<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<th>아이디</th>
	</tr>
	
		<c:forEach items="${userList}" var="userList">
			<tr>	
				<td>${userList.uiNum}</td>
				<td><a href="/user-info/view?uiNum=${userList.uiNum}">${userList.uiName}</a></td>	
				<td>${userList.uiId}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><button onclick="location.href='/user-info/insert'">등록</button>
		<tr>
</table>
</body>
</html>