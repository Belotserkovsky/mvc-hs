<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <title>Users List</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="5">
    <caption>Список пользователей</caption>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилич</th>
        <th>Имя пользователя</th>
        <th>Пароль</th>
        <th>Адрес</th>
        <th>Телефон</th>
        <th>Email</th>
    </tr>

    <c:forEach var="userDTO" items="${usersList}">
        <tr>
            <td>${userDTO.uid}</td>
            <td>${userDTO.firstName}</td>
            <td>${userDTO.secondName}</td>
            <td>${userDTO.login}</td>
            <td>${userDTO.password}</td>
            <td>${userDTO.address}</td>
            <td>${userDTO.phone}</td>
            <td>${userDTO.email}</td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="/controller?command=usersList&page=${currentPage - 1}">Previous</a></td>
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
                    <td><a href="/controller?command=usersList&page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt numberOfPages}">
    <td><a href="/controller?command=usersList&page=${currentPage + 1}">Next</a></td>
</c:if>
<hr>
<a href="/controller?command=adminPage">Admin's page</a>
<br/>
    <c:import url="/jsp/fragment/footer.jsp"/>
</body>
</html>
