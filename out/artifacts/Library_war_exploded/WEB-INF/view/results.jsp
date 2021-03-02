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
<sec:authorize access="hasRole('USER')">
    <h2>Books</h2>
        <table>
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Price</th>
            </tr>
    <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.author}</td>
                <td>${book.title}</td>
                <td>${book.genre}</td>
                <td>${book.price}</td>
            </tr>
    </c:forEach>
        </table>
    <form action="return" method="get">
        <input type="submit" value="return"/>
    </form>
</sec:authorize>
</body>
</html>