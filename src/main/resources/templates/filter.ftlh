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
    <link rel="icon" href="data:,">
    <HEAD>
</form>
<#if products??>
    <div style="border: green 1px solid">
        <table border="1" width="100%" cellpadding="5">
            <tr>
                <th>Id </th>
                <th>Name </th>
                <th>Price</th>
                <th>Basket</th>
            </tr>
            <#list products as product>
                <div id="id">
                    <tr>
                        <th>${product.id}</th>
                        <th>${product.name}</th>
                        <th>${product.price}</th>
                        <th>
                            <form action="/cart/add" method="POST">
                                <input name="id" value="${product.id}" hidden>
                                <button type="submit" >Добавить в корзину</button>
                            </form>
                        </th>
                    </tr>
                </div>
            </#list>
            <br>
        </table>
    </div>
    <a href="/filter?page=${pages.pageNumber+1}">==></a>
</#if>
</body>
</html>