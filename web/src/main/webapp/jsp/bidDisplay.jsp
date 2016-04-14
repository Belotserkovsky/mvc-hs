<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bid display</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>

<table border="1">
    <caption>${user} ' s bid</caption>
    <tr>
        <th>id</th>
        <th>Kind of work</th>
        <th>Scope</th>
        <th>Desired runtime</th>
        <th>User ID</th>
        <th>Brigade ID</th>
    </tr>
    <tr><td>${bid.id}</td><td>${bid.kindofwork}</td><td>${bid.scope}</td><td>${bid.desiredruntime}</td>
    <td>${bid.userId}</td><td>${bid.BrigadeId}</td></tr>
</table>
<br/>
<hr/>
<div> <div class="content"> <c:import url="/jsp/fragment/footer.jsp"/> </div></div>
</body>
</html>
