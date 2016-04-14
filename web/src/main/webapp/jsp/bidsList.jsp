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
<div> <div class="content">
    <h2> Currently available brigades </h2>
</div> </div>
<table border="1">
    <caption>Bids list</caption>
    <tr>
        <th>id</th>
        <th>Kind of work</th>
        <th>Scope</th>
        <th>Desired runtime</th>
        <th>User ID</th>
        <th>Brigade ID</th>
    </tr>
    <c:forEach var="bid" items="${bidsList}" varStatus="status">
    <tr>
        <td>${bid.id}</td><td>${bid.kindOfWorks}</td><td>${bid.scope}</td><td>${bid.desiredRuntime}</td><td>${bid.userId}</td><td>${bid.brigadeId}</td>
    </tr>
    </c:forEach>
</table>
<hr/>
<br/>
${errorLoginPassMessage}
<br/>
${wrongAction}
<br/>
${nullPage}
<br/>
<div> <div class="content">
    <a href="/jsp/admin.jsp">Return to admin...</a>
</div> </div>
<hr/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</body>
</html>
