<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Administrator page</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content">
    <c:import url="/jsp/fragment/header.jsp" />
</div> </div>
<br/>
<div> <div class="content"></div>
    <a href="/jsp/workers.jsp">Link for add or update workers.</a>
</div></div>

<div> <div class="content"></div>
    <a href="/jsp/brigades.jsp">Link for add brigade.</a>
</div></div>

<div> <div class="content"></div>
    <a href="controller?command=workerslist"> Get list of workers.</a>
</div></div>

<div> <div class="content">
    <form name="workersList" method="POST" action="controller">
        <input type="hidden" name="command" value="workerslist"/>
        <input type="submit" value="Get list of workers"/>
</form>
</div></div>

<div> <div class="content">
    <form name="brigadesList" method="POST" action="controller">
        <input type="hidden" name="command" value="brigadeslist"/>
        <input type="submit" value="Get list of brigades"/>
    </form>
</div></div>
<br/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
