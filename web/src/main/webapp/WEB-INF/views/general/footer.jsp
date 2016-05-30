<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>
<c:url var="logout" value="/user/logout"/>
<a href="${logout}">Logout</a>
</body>
</html>
