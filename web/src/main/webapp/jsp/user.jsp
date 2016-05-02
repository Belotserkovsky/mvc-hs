<html><%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>User page</title>
    <style>
        .content { text-align: left}
        .content2 {text-align: center}
    </style>
</head>
<div> <div class="content2">
    <c:import url="/jsp/fragment/header.jsp"/>
</div></div>
    <hr/>
<br/>
<div> <div class="content">
    <form name="bidForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="showBidForm"/>
        <input type="submit" value="Bid form"/>
    </form>
    <br/>
    <form name="contactInfo" method="POST" action="/controller">
        <input type="hidden" name="command" value="editContact"/>
        <input type="submit" value="Edit contact info"/>
    </form>
</div></div>
<br/>
    <div> <div class="content2">${success}</div></div>
<br/>
<hr/>
    <div> <div class="content2"> <c:import url="/jsp/fragment/footer.jsp"/> </div></div>
</body>
</html>
