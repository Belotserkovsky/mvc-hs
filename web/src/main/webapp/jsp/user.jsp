<html><%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>User page</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<div> <div class="content2">
    <c:import url="/jsp/fragment/header.jsp"/>
</div></div>
    <hr/>
<br/>
<div> <div class="content">
    <form name="createBid" method="POST" action="/controller">
        <input type="hidden" name="command" value="createBid"/>
        <input type="submit" value="Создать заявку"/>
    </form>
    <br/>
    <form name="contactInfo" method="POST" action="/controller">
        <input type="hidden" name="command" value="editContact"/>
        <input type="submit" value="Редактировать контактные данные"/>
    </form>
</div></div>
<br/>
    <div> <div class="content">${success}</div></div>
<br/>
<hr/>
    <div> <div class="content"> <c:import url="/jsp/fragment/footer.jsp"/> </div></div>
</body>
</html>
