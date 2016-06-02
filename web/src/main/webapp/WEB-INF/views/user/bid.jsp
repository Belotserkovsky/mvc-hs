<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<title></title>
</head>
<body>
<h4><spring:message code="bid"/></h4>
<p><spring:message code="page.login.userName"/>:  <security:authentication property="principal.username"/></p>
<security:authentication property="principal.username" var="userName" scope="request"/>
<c:url value="/user/createBid" var="createBidUrl" />
<fieldset>
<form name="createBid" method="POST" action="${createBidUrl}">
    <input type="hidden" name="userName" value="${userName}">
    <p><spring:message code="kind.of.works"/>:</p>
        <c:forEach var="element" items="${kindsOfWorks}" varStatus="status">
            <p><input type="CHECKBOX" name="selected" value="${element.type}">${element.type}<Br></p>
        </c:forEach>
    <p><spring:message code="desired.runtime"/>:</p>
    <select name="desiredRuntime">
        <c:forEach var="variant" items="${variantsRuntime}" varStatus="status">
            <option value="${variant.type}">${variant.type}</option>
        </c:forEach>
    </select>
    <p><spring:message code="scope"/>:
        <input type="text" name="scope" value="" placeholder="Заполните поле"/></p>

       <p><input type="submit" value="<spring:message code="send"/>"/></p>
    </form>
</fieldset>
</body>
</html>