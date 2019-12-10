<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>
<h4>Login Form</h4>

<c:if test="${param.error != null}">
    <div class="error">${error}</div>
</c:if>
<c:if test="${param.logout != null}">
    <div class="logout">${message}</div>
</c:if>

<form action="/login" method='POST'>
    <input type="text" required placeholder="Name" name="name"><br>
    <input type="password" required placeholder="Password" name="password"><br>
    <input class="button" type="submit" value="Login">
</form>
<a href="<c:url value='/registration' />">Registration</a></body>
</html>