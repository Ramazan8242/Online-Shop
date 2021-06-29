<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<div class="container">
    <h1>Ваша корзина</h1>
    <#if basketItems??>
    <table border="1" width="100%" cellpadding="5"/>
    <tr>
        <th>Название </th>
        <th>Цена</th>
    <#list basketItems as item>
    <tr>
        <th><p>${item.name}</p></th>
        <th><p>${item.price}</p></th>
        <th><label>
                <input type="number" value="1">
            </label>
        </th>
        </#list>
        <#if _csrf??>
            <form action="/basket/add" method="post">
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                <button>Очистить корзину</button>
            </form>
        </#if>
        <#else>
            <p>тут ничего нет!</p>
        </#if>

        <div>
            <a href="/">назад</a>
        </div>
</div>

</body>
</html>