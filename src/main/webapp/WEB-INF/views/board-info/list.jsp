<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글</h2>
	<form action="/board-info/list" method="GET">
		<select name="searchType">
			<option value="1">제목</option>
			<option value="2">작성자</option>
			<option value="3">내용</option>
			<option value="4">제목+내용</option>
			<option value="5">작성자+내용</option>
			<option value="6">제목+작성자</option>
			<option value="7">제목+작성자+내용</option>
		</select> <input type="text" name="searchStr" placeholder="검색어">
		<button>검색</button>
	</form>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>글쓴이</th>

		</tr>

		<c:forEach items="${boardList}" var="boardList">
			<tr>
				<td>${boardList.biNum}</td>
				<td><a href="/board-info/view?biNum=${boardList.biNum}">${boardList.biTitle}</a></td>
				<td>${boardList.biContent}</td>
				<td>${boardList.uiName}</td>
			</tr>
		</c:forEach>
		<tr>
			<td><button onclick="location.href='/board-info/insert'">등록</button>
		<tr>
	</table>
</body>
</html>