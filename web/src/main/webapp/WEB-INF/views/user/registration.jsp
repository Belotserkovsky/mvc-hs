<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<h3>Please fill in the fields below</h3>

<s:form method="POST" modelAttribute="userDto">
<fieldset>
    <label for="firstName">First name</label>
    <s:input id="firstName" type="text" value="" maxlength="30" path="firstName" placeholder="First Name"/><br/>
    <s:errors path="fullName" cssStyle="color: red"/>

    <label for="secondName">Second name</label>
    <s:input id="secondName" type="text" value="" maxlength="30" path="secondName" placeholder="Second Name"/><br/>
    <s:errors path="secondName" cssStyle="color: red"/>

    <label for="address">Address</label>
    <s:input id="address" type="text" path="age" value="" maxlength="50" placeholder="Address"/><br/>
    <s:errors path="address" cssStyle="color: red"/>

    <label for="phone">Phone</label>
    <s:input id="phone" type="text" path="phone" value="" maxlength="20" placeholder="Phone Number"/>
    <s:errors path="phone" cssStyle="color: red"/>

    <label for="email">Email</label>
    <s:input id="email" type="text" path="email" value="" maxlength="30" placeholder="Email"/>
    <s:errors path="email" cssStyle="color: red"/>

    <label for="userName">User name (login)</label>
    <s:input id="userName" type="text" path="userName" maxlength="20" placeholder="User Name"/>
    <small id="userName_msg">No space, please</small>
    <s:errors path="userName" cssStyle="color: red"/>

    <label for="password">Password</label>
    <s:input id="password" type="text" path="password" maxlength="20" placeholder="Password"/>
    <small id="password_msg">No space, please (at least 6 characters)</small>
    <s:errors path="password" cssStyle="color: red"/>

    <input id="button" type="submit" value="Sing up"/>
</fieldset>
</s:form>
</body>
</html>
