<#import "partials/main.ftlh" as main />
<@main.renderWith>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
    <#if client??><div>${client.name}!</div></#if>
    </body>
    </html>
</@main.renderWith>