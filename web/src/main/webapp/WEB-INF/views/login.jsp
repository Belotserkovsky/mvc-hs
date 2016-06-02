<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<head></head>
<body>
<div style="float: left;">
    <a href="/home?locale=ru" style="padding: 5px">RU</a> | <a href="/home?locale=en" style="padding: 5px">EN</a>
</div>
<br>
блаблабла
<c:url value="/j_spring_security_check" var="loginUrl" />
<form name="login" action="${loginUrl}" method="post">
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p><spring:message code="page.login.successLogout"/></p>
        </div>
    </c:if>
    <c:if test="${param.login != null}">
        <div class="alert alert-success">
            <p><spring:message code="page.login.successRegister"/></p>
        </div>
    </c:if>
        <table cellspacing="0">
            <tr>
                <th><label for="username"><spring:message code="page.login.userName"/></label></th>
                <td><input id="username" name="userName" placeholder="Enter Username" required="required" type="text"/></td>
            </tr>
            <tr>
                <th><label for="password"><spring:message code="page.login.password"/></label></th>
                <td><input id="password" name="password" placeholder="Enter Password" required="required" type="password"/></td>
            </tr>
            <tr>
                <th><input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline"><spring:message code="page.login.rememberMe"/></label></th>
            </tr>
            <tr>
                <th></th>
                <td>
                    <input type="submit" value="<spring:message code="page.login.singIn"/>"/>
                </td>
            </tr>
        </table>
    <c:if test="${param.loginFail != null}">
        <div class="alert alert-success">
            <p><spring:message code="page.login.loginFail"/></p>
        </div>
    </c:if>
    <c:url var="registration" value="/user?new"/>
    <a href="${registration}"><spring:message code="page.login.register"/></a>
</form>
</body>
</html>
