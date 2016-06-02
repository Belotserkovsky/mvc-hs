<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title></title>
</head>
<body>
<br/>
<table border="1" cellpadding="3" cellspacing="3">
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
    <c:forEach var="bidDto" items="${bidsList}">
        <tr>
            <td>${bidDto.bidId}</td>
            <td>${bidDto.kindOfWorks}</td>
            <td>${bidDto.scope}</td>
            <td>${bidDto.desiredRuntime}</td>
            <td>${bidDto.brigadeTitle}</td>
            <td>${bidDto.userId}</td>
            <td>${bidDto.creationDate}</td>
            <td><p>${bidDto.status}</p>
                        <c:url var="updateBidUrl" value="/admin/bids/update"/>
                        <form method="POST" action="${updateBidUrl}">
                            <p><select name="status">
                                <option disable>Статус:</option>
                                <c:forEach var="element" items="${statuses}" varStatus="">
                                    <option value="${element}">${element}</option>
                                </c:forEach>
                            </select></p>
                            <input type="hidden"  name="bidId" value="${bidDto.bidId}"/>
                            <input type="submit" value="Обновить"/>
                        </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>
