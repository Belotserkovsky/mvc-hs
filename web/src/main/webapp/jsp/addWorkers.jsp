<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Workers</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<hr/>
<div> <div class="content">Fill in the fields below:</div> </div>
<hr/>

<div> <div class="content"> <form name="addWorker" method="POST" action="controller">
    <input type="hidden" name="command" value="addworker"/>

    <br/>
    <div><div class="content"> Full Name:</div></div> <br/>
    <div><div class="content"> <input type="text" name="fullName" value=""/></div></div>
    <br/>

    <div><div class="content"> Profession: </div> </div> <br/>
    <div><div class="content"> <input type="text" name="profession" value=""/> </div> </div>
    <br/>
    <div> <div class="content"> <input type="submit" value="Add..."/> </div></div>
</form></div></div>
<hr/>
<br/>
<div> <div class="content"> <form name="updateWorker" method="POST" action="controller">
    <input type="hidden" name="command" value="updateworker"/>

    <br/>
    <div><div class="content"> Worker ID:</div></div> <br/>
    <div><div class="content"> <input type="text" name="id" value=""/></div></div>
    <br/>

    <br/>
    <div><div class="content"> Full Name:</div></div> <br/>
    <div><div class="content"> <input type="text" name="fullName" value=""/></div></div>
    <br/>

    <div><div class="content"> Profession: </div> </div> <br/>
    <div><div class="content"> <input type="text" name="profession" value=""/> </div> </div>
    <br/>

    <br/>
    <div><div class="content"> Brigade ID:</div></div> <br/>
    <div><div class="content"> <input type="number" name="brigadeId" value=""/></div></div>

    <div> <div class="content"> <input type="submit" value="Update..."/> </div></div>
</form></div></div>

<hr/>
<br/>
${errorLoginPassMessage}
<br/>
${wrongAction}
<br/>
${nullPage}
<br/>
<div><div class="content">
    <a href="/jsp/admin.jsp">Return to admin page.</a>
</div></div>
<br/>
<div> <div class="content">
    <c:import url="/jsp/fragment/footer.jsp"/>
</div></div>
</body>
</html>
