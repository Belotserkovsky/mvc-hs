<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title></title>
</head>
<body>
<p><spring:message code="please.fill.in.the.fields.below"/>:</p>
<c:url value="/user/addUser" var="addUserUrl" />
<s:form method="POST" modelAttribute="userDto" action="${addUserUrl}">
<fieldset>
    <table cellspacing="0">
        <tr>
        <th><label for="firstName"><spring:message code="first.name"/></label></th>
                <td>
                    <s:input id="firstName" type="text" value="${userDto.firstName}" path="firstName" size="30" placeholder="First Name"/><br/>
                    <s:errors path="firstName" cssStyle="color: red"/>
                </td>
        </tr>
        <tr>
            <th><label for="secondName"><spring:message code="second.name"/></label></th>
            <td>
                <s:input id="secondName" type="text" value="${userDto.secondName}" path="secondName" size="30" placeholder="Second Name"/><br/>
                <s:errors path="secondName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="address"><spring:message code="address"/></label></th>
            <td>
                <s:input id="address" type="text" path="address" value="" placeholder="Address"/><br/>
                <s:errors path="address" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="phone"><spring:message code="phone"/></label></th>
            <td>
                <s:input id="phone" type="text" path="phone" value="" maxlength="20" placeholder="Phone Number"/>
                <s:errors path="phone" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="email">Email</label></th>
            <td>
                <s:input id="email" type="text" path="email" value="" placeholder="Email"/>
                <s:errors path="email" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="userName"><spring:message code="user.name.login"/></label></th>
            <td>
                <s:input id="userName" type="text" path="userName" maxlength="20" placeholder="User Name"/>
                <small id="userName_msg"><spring:message code="no.space.characters"/></small><br/>
                <s:errors path="userName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="password"><spring:message code="page.login.password"/></label></th>
            <td>
                <s:input id="password" type="text" path="password" maxlength="20" placeholder="Password"/>
                <small id="password_msg"><spring:message code="no.space.characters"/></small><br/>
                <s:errors path="password" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input id="button" type="submit" value="<spring:message code="sing.up"/>"/>
            </td>
        </tr>
        </table>
</fieldset>
</s:form>
</body>
</html>
