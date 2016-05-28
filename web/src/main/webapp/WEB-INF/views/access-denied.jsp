<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core">

<jsp:directive.page pageEncoding="UTF-8" contentType="text/html; UTF-8"/>
<head>
    <title>AccessDenied page</title>
</head>
<body>
You are not authorized to access this page!
<c:url var="login" value="/login"/>
<a href="${login}">Try again</a>
<c:url var="registration" value="/user?new"/>
<a href="${registration}">Registration</a>
</hr>
<c:url var="logout" value="/logout"/>
<a href="${logout}">Logout</a>
</body>
</html>