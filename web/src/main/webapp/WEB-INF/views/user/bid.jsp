<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form a bid</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<body>
<div> <div class="content"><h3>Заявка</h3></div></div>
<div> <div class="content">Пожалуйста, заполните пустые поля:</div></div>
<div> <div class="content">
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
</body>
</html>