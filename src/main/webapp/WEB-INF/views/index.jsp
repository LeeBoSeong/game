<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${user != null}">
<a href="/user-info/list">유저 정보</a>
<a href="/board-info/list">게시글</a>
<button onclick="location.href='/user-info/logout'">로그아웃</button>
</c:if>

<c:if test="${user == null}">
	로그인을 하세요
	<button onclick="location.href='/user-info/login'">로그인 하러 가기</button>
</c:if>
</body>
</html>