<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Registration page</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content"><h3>Регистрация</h3></div> </div>
<hr/>
<hr/>
<div> <div class="content">Пожалуйста, заполните поля ниже:</div> </div>
<br/>
<div> <div class="content">
    <form name="regForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="registration"/>
        <br/>
        Имя:
        <br/>
            <input type="text" name="firstName" value="${firstName}"/>
        <br/>
        Фамилия:
        <br/>
            <input type="text" name="secondName" value="${secondName}"/>
        <br/>
        Адрес:
        <br/>
            <input type="text" name="address" value="${address}"/>
        <br/>
        Телефон:
        <br/>
            <input type="text" name="phone" value="${phone}"/>
        <br/>
        E-mail:
        <br/>
            <input type="text" name="email" value="${email}"/>
        <br/>
        Имя пользователя:
        <br/>
            <input type="text" name="login" value="${login}"/>
        <br/>
        Пароль:
        <br/>
            <input type="text" name="password" value="${pass}"/>
        <br/>
        <input type="submit" value="Зарегистрироваться"/>
    </form>
</div></div>

<div> <div class="content">${errorLoginPassMessage}</div></div>
<br/>
<div> <div class="content">${wrongAction}</div></div>
<br/>
<div> <div class="content">${nullPage}</div></div>
<br/>
<hr/>

<div> <div class="content"> <c:import url="/jsp/fragment/footer.jsp"/></div></div>

</body>
</html>