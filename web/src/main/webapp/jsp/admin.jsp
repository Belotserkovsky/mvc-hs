<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Administrator page</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<body>

<div> <div class="content">
    <c:import url="/jsp/fragment/header.jsp" />
</div> </div>
<hr/>
<br/>
<div> <div class="content">
    <a href="/controller?command=usersList">Пользователи</a>
</div></div>
<br/>
<div> <div class="content">
    <a href="/controller?command=bidsList">Заявки</a>
</div></div>
<br/>
<div> <div class="content">
    <a href="/controller?command=workersList">Работники</a>
</div></div>
<hr/>
<br/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
