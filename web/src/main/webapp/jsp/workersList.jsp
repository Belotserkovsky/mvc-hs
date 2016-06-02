<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Workers list</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<body>
<br/>
<div> <div class="content">
    <table border="1" cellpadding="5" cellspacing="3">
        <caption>Список работников</caption>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Профессия</th>
        </tr>

        <c:forEach var="worker" items="${workersList}" varStatus="status">
        <tr>
            <td>${worker.wid}</td>
            <td>${worker.fullName}</td>
            <td>${worker.profession}</td>
        </tr>
    </c:forEach>
</table>
</div> </div>
<hr/>
<div> <div class="content">
    <a href="/controller?command=adminPage">Admin's page</a>
    <br/>
    <c:import url="/jsp/fragment/footer.jsp"/>
</div> </div>
</body>
</html>
