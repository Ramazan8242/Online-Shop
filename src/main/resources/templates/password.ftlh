<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#--<#if _csrf??>-->
    <form  action="/resetPassword" modelattribute="Client" method="post">
<#--        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>-->
        <input type="text" name="email" placeholder="введите email">
    <button type="submit" value="Submit">Submit</button>
</form>
<#--</#if>-->
</body>
</html>