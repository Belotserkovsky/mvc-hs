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
<div> <div class="content">Please fill in the fields below to form a bid:</div></div>

<div> <div class="content">
    <form name="addBid" method="POST" action="controller">
        <input type="hidden" name="command" value="bidformcommand"/>
        <br/>
        User ID:
        <input type="text" name="u_id" value=${u_id}/>
        <br/>
        Kind of works:
        <input type="text" name="kindOfWorks" value=""/>
        <br/>
        Scope:
        <input type="text" name="scope" value=""/>
        <br/>
        Desired runtime:
        <input type="text" name="desiredRuntime" value=""/>
        <br/>
        <input type="submit" value="Form a bid."/>
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
