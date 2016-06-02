<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <c:url var="adminMain" value="/admin/main"/>
    <p><a href="${adminMain}" name="adminPage"><spring:message code="go.to.admin.page"/></a></p>
</security:authorize>

<p><spring:message code="page.login.userName"/> :  <security:authentication property="principal.username"/></p>
<security:authentication property="principal.username" var="userName" scope="request"/>
<br/>

<c:url value="/user/bidForm" var="bidFormUrl" />
<form name="bidForm" method="POST" action="${bidFormUrl}">
    <input type="hidden" name="userName" value="${userName}"/>
    <input type="submit" value="<spring:message code="create.bid"/>"/>
</form>
<c:url value="/user/updateUser" var="updateUserUrl" />
<form name="contactInfo" method="POST" action="${updateUserUrl}">
    <input type="hidden" name="userName" value="${userName}"/>
    <input type="submit" value="<spring:message code="edit.user.info"/>"/>
</form>

<c:if test="${param.successAddBid != null}">
    <div class="alert alert-success">
        <p><spring:message code="bid.created.successfully"/>!</p>
    </div>
</c:if>
</body>
</html>