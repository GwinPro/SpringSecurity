<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/css/horizontal.css"%>
    </style>
</head>

<body>
<div class="outer">
    <div class="inner inner1">
        <h2 align="center">List of Users</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Roles</th>
                <th>Choose action</th>
            </tr>

            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><c:forEach var="role" items="${user.roles}">
                            ${role.role}
                        </c:forEach>
                    <td>
                        <a href="admin/update?id=<c:out value='${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="admin/delete?id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="inner inner2">
        <h3>Add User</h3>
        <form:form action="/admin/add" method="POST" modelAttribute="user" name="addUser">
            <form:input type="text" required="true" placeholder="Name" path="name"></form:input> <br>
            <form:input type="text" required="true" placeholder="Email" path="email"></form:input> <br>
            <form:input type="password" required="true" placeholder="Password" path="password"></form:input> <br>
            <select required name="userRole" multiple >
                <option disabled selected value="">Choose role</option>
                <c:forEach var="role" items="${rolesName}" >
                    <option value="${role.role}">${role.role}</option>
                </c:forEach>
            </select><br>
            <input class="button" type="submit" value="Add">
        </form:form>
        <p><c:out value='${addResult}'/></p>
    </div>
</div>
<div>
    <a href="/logout">Logout</a>
</div>

</body>
</html>