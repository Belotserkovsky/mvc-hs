<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Administrator page</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>

<div> <div class="content">
    <c:import url="/jsp/fragment/header.jsp" />
</div> </div>
<br/>

<div> <div class="content">
    <a href="/controller?command=usersList">Список пользователей</a>
</div></div>
<br/>

<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
