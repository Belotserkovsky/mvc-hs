<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head>
    <title>Login</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content"><h1>Please login...</h1></div></div>

<div><div class="content"></div>
    <form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
         <br/>
    ${errorLoginPassMessage}
        <br/>
    ${wrongAction}
        <br/>
        ${nullPage}
        <br/>
    <input type="submit" value="Log in"/>
</form>
    </div></div></hr>

Links for guest...<br/>
User status: $sessionScope

<div> <div class="content"> <a href="controller?command=registration">Registration</a> </div></div>
<br/>
<div> <div class="content"> <a href="controller?command=logout">Logout.</a> </div></div>
</body></html>
