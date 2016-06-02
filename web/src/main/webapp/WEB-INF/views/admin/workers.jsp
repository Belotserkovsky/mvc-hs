<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<br/>
<table border="1" cellpadding="3" cellspacing="5">
    <caption>Список работников</caption>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Профессия</th>
    </tr>
    <c:forEach var="worker" items="${workersList}">
        <tr>
            <td>${worker.workerId}</td>
            <td>${worker.fullName}</td>
            <td>${worker.profession}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
