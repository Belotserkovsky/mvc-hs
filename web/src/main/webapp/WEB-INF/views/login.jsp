<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<head></head>
<body>

<c:url value="/j_spring_security_check" var="loginUrl" />
<form name="login" action="${loginUrl}" method="post">
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <c:if test="${param.login != null}">
        <div class="alert alert-success">
            <p>Registration is successfully. Please log in...</p>
        </div>
    </c:if>
    <fieldset>
        <table cellspacing="0">
            <tr>
                <th><label for="username">User name</label></th>
                <td><input id="username" name="userName" placeholder="Enter Username" required="required" type="text"/></td>
            </tr>
            <tr>
                <th><label for="password">Password</label></th>
                <td><input id="password" name="password" placeholder="Enter Password" required="required" type="password"/></td>
            </tr>
            <tr>
                <th><input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Remember me</label></th>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" value="Log in"/></td>
            </tr>
        </table>
    </fieldset>
    <c:url var="registration" value="/user?new"/>
    <a href="${registration}">Registration</a>
</form>
</body>
</html>
