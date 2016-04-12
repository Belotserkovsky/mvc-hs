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
<div> <div class="content">Select the needed specialist:</div></div>
<br/>
<div> <div class="content">
    <form name="addBid" method="POST" action="controller">
        <input type="hidden" name="command" value="choiceWorkerCommand"/>

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
