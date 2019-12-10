<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<H1>YOU DO NOT HAVE ENOUGH RIGHTS</H1>
<form:form action="/login" method="GET">
    <input type="submit" value="GO TO LOGIN PAGE"/>
</form:form>
</body>
</html>