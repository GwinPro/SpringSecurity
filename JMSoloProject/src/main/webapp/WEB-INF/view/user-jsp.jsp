<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Fly
  Date: 10.11.2019
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>Hello, ==<c:out value='${userName}'/>==</h1>
<div>
    <a href="/logout">Logout</a>
</div>

</body>
</html>
