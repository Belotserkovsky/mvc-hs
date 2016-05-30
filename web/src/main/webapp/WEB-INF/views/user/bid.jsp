<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h3>Заявка</h3>
<br/>
User Name:  <security:authentication property="principal.username"/>
<security:authentication property="principal.username" var="userName" scope="request"/>

<c:url value="/user/createBid" var="createBidUrl" />
<fieldset>
<form name="createBid" method="POST" action="${createBidUrl}">
    <p>Род работ:</p>
        <c:forEach var="element" items="${kindsOfWorks}" varStatus="status">
            <p><input type="CHECKBOX" name="selected" value="${element.type}">${element.type}<Br></p>
        </c:forEach>
    <p>Желаемое время выполнения:</p>
    <select name="desiredRuntime">
        <c:forEach var="variant" items="${variantsRuntime}" varStatus="status">
            <option value="${variant.type}">${variant.type}</option>
        </c:forEach>
    </select>
    <p>Масштаб:
        <input type="text" name="scope" value="" placeholder="Заполните поле"/></p>

       <p><input type="submit" value="Отправить"/></p>
    </form>
</fieldset>
</body>
</html>