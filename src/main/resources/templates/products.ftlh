<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <#if _csrf??>
        <form id="exit" class="flex box-128" action="/logout" method="post">
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </form>
        <button type="submit" class="flex box-128 logout-button" form="exit">Выйти </button>
    <#else>
    </#if>

    <table border="1" width="100%" cellpadding="5">
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
</@main.renderWith>