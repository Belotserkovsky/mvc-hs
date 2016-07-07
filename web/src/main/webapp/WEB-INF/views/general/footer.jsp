<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <title></title>
</head>
<body>
<c:url var="logout" value="/user/logout"/>
<a href="${logout}"><spring:message code="page.footer.logout"/></a>
</body>
</html>
