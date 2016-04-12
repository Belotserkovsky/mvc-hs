<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form a bid</title>
    <style>
        .content { text-align: center}
    </style>
</head>
<body>
<div> <div class="content">
    <form name="addBid" method="POST" action="controller">
        <input type="hidden" name="command" value="addbidcommand"/>

        <br/>
        <div><div class="content"> Kind of works:</div></div> <br/>
        <div><div class="content">
            <input type="text" name="kindOfWorks" value=""/></div></div>
        <br/>

        <div><div class="content"> Scope: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="scope" value=""/> </div> </div>
        <br/>

        <div><div class="content"> Desired runtime: </div> </div> <br/>
        <div><div class="content">
            <input type="text" name="phone" value=""/> </div> </div>
        <br/>

        <input type="submit" value="Form a bid."/>
    </form>
</div></div>
</body>
</html>
