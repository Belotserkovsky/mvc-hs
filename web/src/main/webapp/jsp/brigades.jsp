<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Add brigade</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<hr/>
<div> <div class="content">Fill in the fields below:</div> </div>
<hr/>

<div> <div class="content"> <form name="addBrigade" method="POST" action="controller">
    <input type="hidden" name="command" value="addbrigade"/>

    <br/>
    <div><div class="content"> Brigade name:</div> </div> <br/>
    <div><div class="content"> <input type="text" name="name" value=""/> </div></div>
    <br/>

    <div> <div class="content"> <input type="submit" value="Add..."/> </div></div>
</form></div></div>
<hr/>
<br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}
    <br/>
<hr/>
<div><div class="content">
    <a href="/jsp/admin.jsp">Return to admin page.</a>
</div></div>
<br/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
