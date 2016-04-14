<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Workers list</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content">
    <h2> Currently available workers </h2>
</div> </div>
<br/>
<div> <div class="content">
    <table>
    <c:forEach var="worker" items="${workersList}" varStatus="status">
        <tr>
            <td><c:out value="${ worker.id }" /></td>
            <td><c:out value="${ worker.FullName }" /></td>
            <td><c:out value="${ worker.Profession }" /></td>
            <td><c:out value="${ worker.BrigadeId }" /></td>
        </tr>
    </c:forEach>
</table>
</div> </div>
<hr/>
<br/>
${errorLoginPassMessage}
<br/>
${wrongAction}
<br/>
${nullPage}
<br/>
<div> <div class="content">
    <a href="/jsp/admin.jsp">Return to admin page...</a>
</div> </div>
</body>
</html>
