<html><%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>Select workers</title>
    <style>
        .content { text-align: left}
    </style>
</head>
<hr/>
<br/>
<div> <div class="content">
    <form name="selectWorker" method="POST" action="/controller">
        <input type="hidden" name="command" value="selectWorkers">
        <p><b>Выберите необходимого специалиста(ов):</b></p>
        <p><input type="CHECKBOX" name="workers" value="сантехник">сантехник<Br>
            <input type="CHECKBOX" name="workers" value="сварщик">сварщик<Br>
            <input type="CHECKBOX" name="workers" value="электрик">электрик<Br>
            <input type="CHECKBOX" name="workers" value="моляр/штукатур">моляр/штукатур<Br></p>
        <p><input type="submit" value="Выбрать"></p>
    </form>
</div></div>
<hr/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div> </div>
</body>
</html>
