<?xml version="1.0" encoding="UTF-8"?>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:spring="http://www.springframework.org/tags"
      xmlns:tiles="http://tiles.apache.org/tags-tiles">

<head>
    <tiles:insertAttribute  name="title"/>
    <c:if test="${not empty title}">
        <title>${title}</title>
    </c:if>
    <style>
        text {
            height: 16px;
            width: 40px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div> <div class="content"><h3>Housing ang communal services</h3></div> </div>
</br>
<spring:url var="authUrl" value="/j_spring_security_check" />
<form method="post" class="login" action="${authUrl}">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid username and password.</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <fieldset>
        <br>
            <label for="username">User name</label>
            <input id="username" name="userName" placeholder="Enter Username" required="required" type="text"/>

            <label for="password">Password</label>
            <input id="password" name="password" placeholder="Enter Password" required="required" type="password"/>

            <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
            <label for="remember_me" class="inline">Remember me</label>
            </br>
            <input type="submit" value="Log in"/>
        </div>
    </fieldset>
    <c:url var="registration" value="/user/registration"/>
    <a href="${registration}">Registration</a>
</form>
</body>
</html>
