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
<div> <div class="content">
    <c:import url="/jsp/fragment/header.jsp" />
</div> </div>
<hr/>
<div> <div class="content">Please fill in the fields below:</div> </div>
<br/>
<div> <div class="content">
    <form name="regForm" method="POST" action="controller">
        <input type="hidden" name="command" value="registration"/>

        <br/>
        <div><div class="content"> Full Name:</div></div> <br/>
        <div><div class="content">
            <input type="text" name="fullName" value=""/></div></div>
        <br/>

        <div><div class="content"> Address: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="address" value=""/> </div> </div>
        <br/>

        <div><div class="content"> Phone: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="phone" value=""/> </div> </div>
        <br/>

        <div><div class="content"> E-mail: </div> </div>
        <div><div class="content">
            <input type="text" name="email" value=""/> </div> </div>
        <br/>

        <div><div class="content"> Login: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="login" value=""/> </div> </div>
        <br/>

        <div><div class="content"> Password: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="password" value=""/> </div> </div>
        <br/>

        ${errorLoginPassMessage}
        <br/>
        ${wrongAction}
        <br/>
        ${nullPage}
        <br/>

        <div> <div class="content">
            <input type="submit" value="Send..."/> </div></div>
    </form></div></div>
<hr/>
<br/>

<div> <div class="content"> <c:import url="/jsp/fragment/footer.jsp"/></div></div>

</body>
</html>