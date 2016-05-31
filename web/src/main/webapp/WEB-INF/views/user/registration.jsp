<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<p>Please fill in the fields below</p>
<c:url value="/user/addUser" var="addUserUrl" />
<s:form method="POST" modelAttribute="userDto" action="${addUserUrl}">
<fieldset>
    <table cellspacing="0">
        <tr>
        <th><label for="firstName">First name</label></th>
                <td>
                    <s:input id="firstName" type="text" value="${userDto.firstName}" path="firstName" size="30" placeholder="First Name"/><br/>
                    <s:errors path="firstName" cssStyle="color: red"/>
                </td>
        </tr>
        <tr>
            <th><label for="secondName">Second name</label></th>
            <td>
                <s:input id="secondName" type="text" value="${userDto.secondName}" path="secondName" size="30" placeholder="Second Name"/><br/>
                <s:errors path="secondName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="address">Address</label></th>
            <td>
                <s:input id="address" type="text" path="address" value="" placeholder="Address"/><br/>
                <s:errors path="address" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="phone">Phone</label></th>
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
            <th><label for="userName">User name (login)</label></th>
            <td>
                <s:input id="userName" type="text" path="userName" maxlength="20" placeholder="User Name"/>
                <small id="userName_msg">No space, please (at least 6 characters)</small><br/>
                <s:errors path="userName" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th><label for="password">Password</label></th>
            <td>
                <s:input id="password" type="text" path="password" maxlength="20" placeholder="Password"/>
                <small id="password_msg">No space, please (at least 6 characters)</small><br/>
                <s:errors path="password" cssStyle="color: red"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input id="button" type="submit" value="Sing up"/>
            </td>
        </tr>
        </table>
</fieldset>
</s:form>
</body>
</html>
