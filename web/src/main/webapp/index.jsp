<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Index</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>

<div> <div class="content"><h1>Welcome to page of housing services!</h1></div></div>

<div> <div class="content"><a href="/jsp/login.jsp">Please, log in.</a></div></div>
<br/>
<hr/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
