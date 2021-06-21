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
    </div>

</@main.renderWith>