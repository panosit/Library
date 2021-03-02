<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library</title>
</head>
<body>
  <h3>Login</h3>
      <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
          <c:if test="${param.error!=null}">
              <i>Invalid username/password</i>
              <br>
          </c:if>
          <input type="text" name="username" id="username" placeholder="Username"><br>
          <input type="password" name="password" id="password" placeholder="Password"><br>
          <button class="btn" type="submit">Login</button>
      </form:form>
  <h3>Register</h3>
    <form action="register" method="post">
        <input type="text" name="usernamer" id="usernamer" placeholder="Username"><br>
        <input type="password" name="passwordr" id="passwordr" placeholder="Password"><br>
        <input type="password" name="passwordc" id="passwordc" placeholder="Confirm password"><br>
        <input type="submit" value="Register" id="register">
    </form>
  <h1 id="result">${result}</h1>
 <script type="text/javascript">
     document.getElementById("register").addEventListener("click",(e)=>{
         const passwordr=document.getElementById("passwordr").value
         const passwordc=document.getElementById("passwordc").value
         if(passwordc!==passwordr){
             e.preventDefault()
             document.getElementById("result").innerHTML="Passwords are different!"
         }
     })
 </script>
</body>
</html>