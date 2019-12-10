<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>UPDATE CRUD</title>
</head>
<body>
<form:form action="/admin/update" modelAttribute="user" method="post">

    <input type="hidden" name="id" value="<c:out value='${user.id}'/>"><br>
    <input type="text" required placeholder="Name" name="name" value="<c:out value='${user.name}'/>"><br>
    <input type="text" required placeholder="Email" name="email" value="<c:out value='${user.email}'/>"><br>
    <input type="text" required placeholder="Password" name="password" value="<c:out value='${user.password}'/>"><br>
    <select required name="role">
        <option disabled selected value="">Choose role</option>
        <option value="1">ROLE_ADMIN</option>
        <option value="2">ROLE_USER</option>
    </select><br>
    <input class="button" type="submit" value="Update">
</form:form>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>