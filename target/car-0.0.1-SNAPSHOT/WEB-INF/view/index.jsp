<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
<title>Παιδικός Σταθμός</title>
</head>
<body>
    <h3>Hello, ${username}</h3>
	<input type="submit" value="Αποσύνδεση" onClick="window.location.href='<c:url value="/logout" />'"/>
	<sec:authorize access="hasRole('ADMIN')">
		<h1>Συνδεθήκατε ως ADMIN</h1>
		<h3>Register</h3>
		<form action="register" method="post">
			<label for="musername">Username:</label><br>
			<input name="musername" id="musername" type="text" required><br>
			<label for="mpassword">Κωδικός:</label><br>
			<input name="mpassword" id="mpassword" type="password" required><br>
			<label for="role">Role(admin, teacher, manager):</label><br>
			<input id="role" name="role" type="text" required><br>
			<label for="tmima">Τμήμα(for teacher, -1 role is not teacher):</label><br>
			<input id="tmima" type="text" name="tmima"><br>
			<input type="submit" value="Register">
		</form>
		<h3>Users</h3>
		<c:forEach items="${users}" var="user">
			<ul>
				<li>Ονομα: ${user.username} Ρόλος: ${user.authority}</li>
			</ul>
		</c:forEach>
		<h3>Τμήματα</h3>
		<c:forEach items="${tmimata}" var="tmimata">
			<ul>
				<li>Ονομα: ${tmimata.username} Τμήμα: ${tmimata.tmima}</li>
			</ul>
		</c:forEach>
		<h3>Delete</h3>
		<form action="delete" method="post">
			<label for="deleteUsername">Username:</label><br> <input
				type="text" id="deleteUsername" name="deleteUsername"><br>
			<input type="submit" value="Delete"><br>
		</form>
		<h3>Update</h3>
		<form action="update" method="post">
		     <label for="uusername">Username:</label><br>
		     <input id="uusername" name="uusername" type="text" required><br>
		     <label for="oldpassword">Old password:</label><br>
		     <input id="oldpassword" name="oldpassword" type="password" required><br>
		     <label for="newpassword">New password:</label><br>
		     <input id="newpassword" name="newpassword" type="password" required><br>
		     <input type="submit" value="Update">
		</form>
	</sec:authorize>
	<sec:authorize access="hasRole('MANAGER')">
		<h1>Συνδεθήκατε ως Διευθυντής</h1>
		<h3>Εκπαιδευτικοί</h3>
		<c:forEach items="${tmimata}" var="tmimata">
			<ul>
				<li>Ονομα: ${tmimata.username} Τμήμα: ${tmimata.tmima}</li>
			</ul>
		</c:forEach>
		<h3>Applications</h3>
		<c:forEach items="${applications}" var="application">
			<ul>
                <li>${application.toString()}</li>
			</ul>
		</c:forEach>
		<h3>Register child</h3>
		<form action="registerChild" method="post">
          <label for="firstname">Firstname:</label><br>
		  <input id="firstname" type="text" name="firstname"><br>
		  <label for="lastname">Lastname:</label><br>
		  <input id="lastname" type="text" name="lastname"><br>
		  <label for="class">Class:</label><br>
		  <input id="class" type="text" name="class"><br>
		  <input type="submit" value="register">
		</form>
	</sec:authorize>
	<sec:authorize access="hasRole('TEACHER')">
		<h1>Συνδεθήκατε ως εκπαιδευτικός είστε στο τμήμα ${teacher.tmima}</h1>
		<h3>Παιδιά</h3>
		<c:forEach items="${child}" var="child">
			<ul>
				<li>Ονομα: ${child.firstname} Επώνυμο: ${child.lastname} Τμήμα: ${child.tmima}</li>
			</ul>
		</c:forEach>
	</sec:authorize>
</body>
</html>