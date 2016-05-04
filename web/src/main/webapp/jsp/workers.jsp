<html><%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>Select workers</title>
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
    <form name="selectWorker" method="POST" action="/controller">
        <input type="hidden" name="command" value="selectWorkers">
        <p><b>Select the needed specialist:</b></p>
        <p><input type="CHECKBOX" name="workers" value="Plumber">Plumber<Br>
            <input type="CHECKBOX" name="workers" value="Welder">Welder<Br>
            <input type="CHECKBOX" name="workers" value="Electrician">Electrician<Br>
            <input type="CHECKBOX" name="workers" value="House painter">House painter<Br></p>
        <p><input type="submit" value="Select"></p>
    </form>
</div></div>
<br/>
<div> <div class="content2">${success}</div></div>
<br/>
<hr/>
<div> <div class="content2"> <c:import url="/jsp/fragment/footer.jsp"/> </div></div>
</body>
</html>
