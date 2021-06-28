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
                <th>Feedback</th>
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
                    <div id="review"  style="border: 1px solid red; padding-bottom: 2rem; margin-bottom: 3rem" hidden>

                        <#list product.text as review>
                            <li>${review.text}</li>
                        </#list>
                    </div>
                    <div id="com" hidden>
                        <form id="text" action="/addFeedback" modelAttribute ="comment" method="POST">
                            <p>
                                <textarea  name="reviewContent" placeholder="Комментарий" required autofocus form="text"></textarea>
                                <input type="number" name="orderFor" value="${product.id}" hidden>
                            </p>
                            <p><input type="submit" value="Отправить" form="text"></p>
                        </form>
                    </div>
                </div>
            </#list>
            <br>
        </table>
    </div>
    <a href="/filter?page=${pages.pageNumber+1}">==></a>
</body>
<script>
    let btn = document.getElementById("btn");
    btn.addEventListener("click",function getReview(e) {
        e.preventDefault()

        document.getElementById("review").hidden = document.getElementById("review").hidden === false;
    })

    let com = document.getElementById("com-btn");
    com.addEventListener("click",function addCom(e) {
        e.preventDefault()
        document.getElementById("com").hidden=document.getElementById("com").hidden===false;

    })
</script>
</html>