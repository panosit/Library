<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
<link
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
</head>
<body>
	<h1>Book list</h1>
	<c:forEach var="book" items="${books}">
		<ol>
			<li>Author: ${book.author}</li>
			<li>Title: ${book.title}</li>
			<li>Genre: ${book.genre}</li>
			<li>Price: ${book.price}</li>
		</ol>
	</c:forEach>
	<form action="return" method="get">
	  <input type="submit" value="return"/>
	</form>
</body>
</html>