<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <title>Welcome page</title>
    <link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet"  type="text/css"/>
</head>
<body>

<div style = "text-align: center;">

<div style="float: left;">
    <a href="/home?locale=ru" style="padding: 5px">RU</a> | <a href="/home?locale=en" style="padding: 5px">EN</a>
</div>
<br>
<c:url value="/j_spring_security_check" var="loginUrl" />

<c:if test="${param.logout != null}">
    <div class="alert alert-success">
        <p><spring:message code="page.login.successLogout"/></p>
    </div>
</c:if>
<c:if test="${param.login != null}">
    <div class="alert-success">
        <p><spring:message code="page.login.successRegister"/></p>
    </div>
</c:if>

<form class="form-horizontal" name="login" action="${loginUrl}" method="post">

    <div class="control-group">
        <label class="control-label" for="username"><spring:message code="page.login.userName"/></label>
            <input type="text" id="username" name="userName" placeholder="Enter Username" required="required" />
    </div>

    <div class="control-group">
        <label class="control-label" for="password"><spring:message code="page.login.password"/></label>
        <input type="password" id="password" name="password" placeholder="Enter password" required="required">
    </div>

    <div class="control-group">
        <div class="controls">
            <label class="checkbox">
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox">
                <spring:message code="page.login.rememberMe"/>
            </label>
        </div>
    </div>

    <%--<input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>--%>
    <%--<label for="remember_me" class="inline"><spring:message code="page.login.rememberMe"/></label>--%>

    <button type="submit" class="btn"><spring:message code="page.login.singIn"/></button>

    <c:if test="${param.loginFail != null}">
        <div class="alert-warning">
            <p><spring:message code="page.login.loginFail"/></p>
        </div>
    </c:if>

    <button class="btn-link">
        <c:url var="registration" value="/user?new"/>
        <a href="${registration}"><spring:message code="page.login.register"/></a>
    </button>
</form>

</div>

</body>
</html>
