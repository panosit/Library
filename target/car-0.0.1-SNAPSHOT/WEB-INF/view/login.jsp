<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
  <h3>Σύνδεση στο Εσωτερικό Σύστημα</h3>
      <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
          <c:if test="${param.error!=null}">
              <i>Sorry! Invalid username/password!</i>
              <br>
          </c:if>
          <label class="form-label" for="username">Username:</label><br>
          <input type="text" name="username" id="username"><br>
          <label class="form-label" for="password">Password:</label><br>
          <input type="password" name="password" id="password"><br>
          <button class="btn" type="submit">Login</button>
      </form:form>
</body>
</html>