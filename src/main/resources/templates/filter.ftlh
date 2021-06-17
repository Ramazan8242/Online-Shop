<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/filter" modelAttribute="filter" method="get">
    <input type="text" name="name" path="name"/>
    <input type="text" name="price" path="maxPrice"/>
    <input type="text" name="price" path="minPrice"/>
    <input type="submit" value="FILTER"/>
</form>
<#if products??>

<#list products as product>
<div style="green 1px solid" class="card-place">
    ${product.id}
    ${product.name}
    ${product.price}
</div>
</#list>
</#if>
</body>
</html>