<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form a bid</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content"><h3>Bid for work</h3>
    <br/>
    <hr/>
<div> <div class="content">Number of your brigade: ${brigade_id}.</div></div>
<br/>
<div> <div class="content">Please fill in the empty fields below to form a bid:</div></div>

<div> <div class="content">
    <form name="addBid" method="POST" action="controller">
        <input type="hidden" name="command" value="bidform"/>
        <br/>
        User ID:
        <br/>
        <input type="text" name="u_id" value=${u_id} >
        <br/>
        Kind of works:
        <br/>
        <input type="text" name="kindOfWorks" value="" >
        <br/>
        Scope:
        <br/>
        <br/>
        <input type="text" name="scope" value=""/>
        <br/>
        Desired runtime:
        <br/>
        <input type="text" name="desiredRuntime" value="">
        <br/>
        Brigade ID:
        <br/>
        <input type="text" name="brigade_id" value=${brigade_id} >
        <br/>
        <input type="submit" value="Form a bid."/>
    </form>
</div></div>

<br/>
<hr/>
<div> <div class="content"><c:import url="/jsp/fragment/footer.jsp"/></div></div>
<br/>
</body>
</html>
