<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form a bid</title>
    <style>
        .content { text-align: center}
        .content2 {text-align: left}
    </style>
</head>
<body>
<div> <div class="content"><h3>Заявка</h3></div></div>
    <br/>
    <hr/>
<br/>
<div> <div class="content">Пожалуйста, заполните пустые поля:</div></div>

<div> <div class="content2">
    <form name="addBid" method="POST" action="/controller">
        <input type="hidden" name="command" value="bidform"/>
        <br/>
        Род работ:
        <br/>
        <input type="text" name="kindOfWorks" value="" >
        <br/>
        Масштаб:
        <br/>
        <input type="text" name="scope" value=""/>
        <br/>
        Желаемое время выполнения:
        <br/>
        <input type="text" name="desiredRuntime" value="">
        <br/>
        <input type="submit" value="Отправить"/>
    </form>
</div></div>
<br/>
<div> <div class="content2">${success}</div></div>
<br/>
<hr>
<div> <div class="content"><c:import url="/jsp/fragment/footer.jsp"/></div></div>
<br/>
</body>
</html>

<%--<form name="addBid" method="POST" action="/controller">--%>
<%--<input type="hidden" name="command" value="brigadeAdd">--%>
<%--<p><b>Select the required specialist:</b></p>--%>
<%--<p><input type="CHECKBOX" name="workers" value="Plumber">Plumber<Br>--%>
<%--<input type="CHECKBOX" name="workers" value="Welder">Welder<Br>--%>
<%--<input type="CHECKBOX" name="workers" value="Electrician">Electrician<Br>--%>
<%--<input type="CHECKBOX" name="workers" value="House painter">House painter<Br></p>--%>
<%--<p><input type="submit" value="Select"></p>--%>
<%--</form>--%>
