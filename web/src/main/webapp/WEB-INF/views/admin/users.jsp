<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <caption>Список пользователей</caption>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Имя пользователя</th>
        <th>Пароль</th>
        <th>Адрес</th>
        <th>Телефон</th>
        <th>Email</th>
        <th>Роль</th>
    </tr>

    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName}</td>
            <td>${user.secondName}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.userContacts.address}</td>
            <td>${user.userContacts.phone}</td>
            <td>${user.userContacts.email}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="/admin/users?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="/admin/users?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt numberOfPages}">
    <td><a href="/admin/users?page=${currentPage + 1}">Next</a></td>
</c:if>
<hr>
<a href="/admin/main">Admin's page</a>
</body>
</html>
