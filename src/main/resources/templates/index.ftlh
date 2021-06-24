<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith>

    <div class="flex flex-justify-content-center">
        <a class="flex box-128" href="/registration"> Регистрация </a>
        <a class="flex box-128" href="/login"> Войти </a>
        <a class="flex box-128" href="/profile"> Профиль </a>
        <#if _csrf??>
            <form class="flex box-128" action="/logout" method="post">
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                <button class="flex box-128 logout-button">Выйти </button>
            </form>
        <#else>
            <a href="/logout">Выйти</a>
        </#if>
        <a class="flex box-128" href="/cart"> Корзина </a>
        <a class="flex box-128" href="/cart"> Добавить в корзину продукт </a>
    </div>
    <div class="card-group">
        <div class="1s card my-3">
            <img src="image/1.jpg" style="height: 250px;width: 300px" class="rounded  d-block  pt-4 pb-4 pr-4 col-12 col-sm-6  col-lg-4"  alt="...">
            <div class="card-body"><button type="submit">Добавить в корзину</button></div>
            <p>=====================================</p>
        </div><br/>
        <div class="1s card my-3">
            <img src="image/2.jpg" style="height: 250px;width: 370px" class="rounded  d-block  pt-4 pb-4 pr-4 col-12 col-sm-6  col-lg-4"  alt="...">
            <div class="card-body"><button type="submit">Добавить в корзину</button></div>
            <p>=====================================</p>
        </div><br/>
        <div class="1s card my-3">
            <img src="image/3.jpg" style="height: 250px;width: 370px" class="rounded  d-block  pt-4 pb-4 pr-4 col-12 col-sm-6  col-lg-4"  alt="...">
            <div class="card-body"><button type="submit">Добавить в корзину</button></div>
            <p>=====================================</p>
        </div><br/>
        <div class="1s card my-3">
            <img src="image/4.jpg" style="height: 250px;width: 370px" class="rounded  d-block  pt-4 pb-4 pr-4 col-12 col-sm-6  col-lg-4"  alt="...">
            <div class="card-body"><button type="submit">Добавить в корзину</button></div>
            <p>=====================================</p>
        </div><br/>
    </div>

</@main.renderWith>