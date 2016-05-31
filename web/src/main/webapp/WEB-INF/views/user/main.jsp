<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title></title>
</head>
<body>
<p>User Name:  <security:authentication property="principal.username"/></p>
<security:authentication property="principal.username" var="userName" scope="request"/>
<br/>
<c:url value="/user/bidForm" var="bidFormUrl" />
<form name="bidForm" method="POST" action="${bidFormUrl}">
    <input type="hidden" name="userName" value="${userName}"/>
    <input type="submit" value="Create bid"/>
</form>
<c:url value="/user/updateUser" var="updateUserUrl" />
<form name="contactInfo" method="POST" action="${updateUserUrl}">
    <input type="hidden" name="userName" value="${userName}"/>
    <input type="submit" value="Редактировать контактные данные"/>
</form>

<c:if test="${param.successAddBid != null}">
    <div class="alert alert-success">
        <p>The bid created successfully.</p>
    </div>
</c:if>

<c:if test="${param.successAuth != null}">
    <div class="alert alert-success">
        <p>Authentication is successful</p>
    </div>
</c:if>
</body>
</html>
