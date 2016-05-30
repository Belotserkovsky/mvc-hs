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
        <th>Дата создания</th>
        <th>Статус</th>
    </tr>
    <c:forEach var="bidDto" items="${bidsList}" varStatus="status">
    <tr>
        <td>${bidDto.bidId}</td>
        <td>${bidDto.kindOfWorks}</td>
        <td>${bidDto.scope}</td>
        <td>${bidDto.desiredRuntime}</td>
        <td>${bidDto.brigadeTitle}</td>
        <td>${bidDto.userId}</td>
        <td>${bidDto.creationDate}</td>
        <td>
        ${bidDto.status}<br>
            <form method="POST" action="/controller">
                <input type="hidden" name="command" value="updateBid"/>
                <p><select size="3">
                <option disabled>Обновить статус:</option>
                 <c:forEach var="element" items="${statuses}" varStatus="">
                    <option value=">${element}">${element}</option>
                 </c:forEach>
                </select></p>
                <input type="submit" value="Обновить"/>
            </form>
        </td>
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
