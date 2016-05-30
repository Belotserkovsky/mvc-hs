<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<head>
    <title>AccessDenied page</title>
</head>
<body>
You are not authorized to access this page!
<c:url var="login" value="/home"/>
<a href="${login}">Try again</a>
<c:url var="registration" value="/hs/user?new"/>
<a href="${registration}">Registration</a>
</hr>
<c:url var="logout" value="/j_spring_security_logout"/>
<a href="${logout}">Logout</a>
</body>
</html>