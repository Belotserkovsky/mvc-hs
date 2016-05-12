<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head>
    <title>Login</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content"><h3>Введите данные для входа:</h3></div></div>
<div><div class="content">
    <form name="loginForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="login"/>
        Имя пользователя:
        <br/>
        <input type="text" name="login" value=""/>
        <br/>
        Пароль:
        <br/>
        <input type="text" name="password" value=""/>
        <br/>
        <input type="submit" value="Log in"/>
</form>
    </div></div>
<br/>
    <div><div class="content">${errorLoginPassMessage}</div></div>
<br/>
    <div><div class="content">${wrongAction}</div></div>
<br/>
    <div><div class="content">${nullPage}</div></div>
<br/>
    <div><div class="content">${successfulReg}</div></div>
<br/>
    <div> <div class="content"> <a href="/jsp/registration.jsp">Регистрация</a> </div></div>
<br/>
<hr/>
    <div> <div class="content"> <c:import url="/jsp/fragment/footer.jsp"/> </div></div>
</body></html>
