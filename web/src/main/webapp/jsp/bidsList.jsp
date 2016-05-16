<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bids list</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <caption>Заявки</caption>
    <tr>
        <th>ID</th>
        <th>Вид работ</th>
        <th>Масштаб</th>
        <th>Время выполнения</th>
        <th>Бригада</th>
        <th>ID пользователя</th>
    </tr>
    <c:forEach var="bidDto" items="${bidsList}" varStatus="status">
    <tr>
        <td>${bidDto.bId}</td>
        <td>${bidDto.kindOfWorks}</td>
        <td>${bidDto.scope}</td>
        <td>${bidDto.desiredRuntime}</td>
        <td>${bidDto.brigadeTitle}</td>
        <td>${bidDto.uid}</td>
    </tr>
    </c:forEach>
</table>
<br/>
<div> <div class="content">
    <a href="/controller?command=adminPage">Admin's page</a>
</div> </div>
<hr/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</body>
</html>
