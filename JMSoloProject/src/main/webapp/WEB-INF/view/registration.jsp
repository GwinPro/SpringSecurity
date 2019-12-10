<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>User Registration </h3>
<form method="POST" action="/registration">
    <input type="hidden"><br>
    <input type="text" required placeholder="Name" name="name"><br>
    <input type="text" required placeholder="Email" name="email"><br>
    <input type="text" required placeholder="Password" name="password"><br>
    <input class="button" type="submit" value="Registration" >
</form>
<p><c:out value='${addResult}'/></p>
<a href="<c:url value='/login' />">LoginPage</a></body>
</body>
</html>
