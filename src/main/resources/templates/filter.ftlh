<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/filter" modelAttribute="filter" method="get">
    <input type="text" name="name" path="name"/>
    <input type="submit" value="FILTER"/>
</form>

<#list products as product>
<div style="green 1px solid" class="card-place">
    ${product.id}
    ${product.name}
</div>
</#list>
</body>
</html>