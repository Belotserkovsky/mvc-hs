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
<div> <div class="content"><h2>REGISTRATION PAGE</h2></div> </div>
<hr/>
<hr/>
<div> <div class="content">Please fill in the fields below:</div> </div>
<br/>
<div> <div class="content">
    <form name="regForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="registration"/>
        <br/>
        First name:
        <br/>
            <input type="text" name="firstName" value=""/>
        <br/>
        Second name:
        <br/>
            <input type="text" name="secondName" value=""/>
        <br/>
        Address:
        <br/>
            <input type="text" name="address" value=""/>
        <br/>
        Phone:
        <br/>
            <input type="text" name="phone" value=""/>
        <br/>
        E-mail:
        <br/>
            <input type="text" name="email" value=""/>
        <br/>
        Login:
        <br/>
            <input type="text" name="login" value=""/>
        <br/>
        Password:
        <br/>
            <input type="text" name="password" value=""/>
        <br/>

        <input type="submit" value="Send..."/>
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