<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="/css/main.css">
        <link rel="icon" href="data:,">
    </head>

    <div class="flex flex-justify-content-center">
        <a class="flex box-128" href="/profile"> Профиль </a>
        <#if _csrf??>
        <form class="flex box-128" action="/logout" method="post">
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            <button class="flex box-128 logout-button">Выйти </button>
        </form>
    <#else>
        <a href="/logout">Выйти</a>
        </#if><br/>
        <a class="flex box-128" href="/basket"> Корзина </a>
        <a class="flex box-128" href="/products"> Добавить в корзину продукт </a>
        <a class="flex box-128" href="/forgot-password">Изменить пароль</a>
        <a class="flex box-128" href="/feedback">Оставить отзыв</a>
    </div>

    <#if products??>
            <#if _csrf??>
        <form id="exit" class="flex box-128" action="/logout" method="post">
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </form>
        <button type="submit" class="flex box-128 logout-button" form="exit">Выйти </button>
    <#else>
    </#if>

    <table border="1 solid black" width="100%" cellpadding="5">
        <tr>
            <th>Название </th>
            <th>цена</th>
        </tr>
        <#list products as product>
            <tr>
                <th>${product.name}</th>
                <th>${product.price}</th>
                <th>
                    <form action="/basket/add" method="post" id="basket-form">
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <div>
                            <input type="number" name="id" value="${product.id}" hidden>
                            <button id="add" type="submit" >Добавить в корзину</button>
                        </div>
                    </form>
                </th>
            </tr>
        </#list>
    </table>

    <#if pages??>
        <a href="/products?page=${pages.pageNumber+1}&size=2">==></a>
    </#if>
    </#if>
</@main.renderWith>