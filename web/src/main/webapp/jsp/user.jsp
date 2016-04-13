<html><%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>User page</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<div> <div class="content">
    <c:import url="/jsp/fragment/header.jsp"/>
</div></div>
    <hr/>

<br/>
<div> <div class="content">
    <form name="addBid" method="POST" action="controller">
        <input type="hidden" name="command" value="brigadeAddCommand"/>

        <br/>
        <div><div class="content">
            <input type="CHECKBOX" name="workers" value="Plumber>Plumber"/></div></div>
        <br/>
        <div><div class="content">
            <input type="CHECKBOX" name="workers" value="Welder>Welder"/></div></div>
        <br/>
        <div><div class="content">
            <input type="CHECKBOX" name="workers" value="Electrician>Electrician"/></div></div>
        <br/>
        <div><div class="content">
            <input type="CHECKBOX" name="workers" value="House painter>House painter"/></div></div>
        <br/>
        <div> <div class="content"><input type="submit" value="Select"/></div></div>
    </form>
</div></div>



<br/>
<hr/>
    <div> <div class="content"></div>
        <c:import url="/jsp/fragment/footer.jsp"/>
    </div></div>
<br/>
</body>
</html>
