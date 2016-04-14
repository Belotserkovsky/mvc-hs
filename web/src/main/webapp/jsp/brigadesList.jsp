<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Brigades list</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content">
    <h2> Currently available brigades </h2>
</div> </div>
<br/>
<div> <div class="content">
    <table>
        <c:forEach var="brigade" items="${brigadesList}" varStatus="status">
            <tr>
                <td><c:out value="${ brigade.id }" /></td>
                <td><c:out value="${ brigade.name }" /></td>
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
    <a href="/jsp/admin.jsp">Return to admin...</a>
</div> </div>
<hr/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</body>
</html>
