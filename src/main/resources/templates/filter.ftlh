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
    <table class="table table-sm">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Basket</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td> ${product.name}</td>
            <td> ${product.price}</td>
            <td><button>Добавить в корзину</button></td>
        </tr>
    </table>
</#list>
</#if>
<#--<#list  products as product>-->
<#--    <a href="/filter?page=${product.pageNumber+1}&size=2">==></a>-->
<#--</#list>-->
</body>
</html>