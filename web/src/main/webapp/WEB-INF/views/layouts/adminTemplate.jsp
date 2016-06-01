<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title><h3>${title}</h3></title>
    </c:if>
</head>
<body>
<tiles:insertAttribute name="header"/>

<c:url var="getUsers" value="/admin/users"/>
<c:url var="getBids" value="/admin/bids"/>
<c:url var="getWorkers" value="/admin/workers"/>
<fieldset>
    <table cellspacing="0">
        <tr>
            <th><a href="${getUsers}">Users</a></th>
            <th><a href="${getBids}">Bids</a></th>
            <th><a href="${getWorkers}">Workers</a></th>
        </tr>
        </table>
    </fieldset>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>
