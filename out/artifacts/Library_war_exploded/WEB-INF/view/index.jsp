<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
<title>Library</title>
</head>
<body>
    <h3>Hello, ${username}</h3>
	<input type="submit" value="Αποσύνδεση" onClick="window.location.href='<c:url value="/logout" />'"/>
	<sec:authorize access="hasRole('ADMIN')">
		<h3>Admin</h3>
	<h2>Books</h2>
	<table>
		<tr>
			<th>Username</th>
			<th>Author</th>
			<th>Title</th>
			<th>Genre</th>
			<th>Price</th>
		</tr>
		<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.username}</td>
			<td>${book.author}</td>
			<td>${book.title}</td>
			<td>${book.genre}</td>
			<td>${book.price}</td>
		</tr>
		</c:forEach>
	</sec:authorize>
	<sec:authorize access="hasRole('USER')">
		<h2>Add a book</h2>
		<form action="add" method="POST">
			<input type="text" id="author" name="author" placeholder="Author" required><br>
			<input type="text" id="title" name="title" placeholder="Title" required><br>
			<input type="text" id="genre" name="genre" placeholder="Genre" required><br>
			<input type="text" id="price" name="price" placeholder="Price" required><br>
			<input type="Submit" value="add"><br>
		</form>
		<h2>Search a book</h2>
		<form method="GET" action="search">
			<input type="text" id="search" name="searchtitle" placeholder="title" required><br>
			<input type="Submit" value="search" >
		</form>
		<h2>Show all books</h2>
		<form method="GET" action="show">
			<input type="Submit" id="show" value="show">
		</form>
		<h2>Delete a book</h2>
		<form method="post" action="delete">
			<input type="text" name="titled" id="titled" placeholder="title"><br>
			<input type="submit" value="delete"><br>
		</form>
	</sec:authorize>
</body>
</html>