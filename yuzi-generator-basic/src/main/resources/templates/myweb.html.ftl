<!DOCTYPE html>
<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome ${user}!</h1>
<ul>
    <#--循环渲染-->
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}</a></li>
    </#list>
</ul>
<footer>${currentYear} ${user}.</footer>
</body>
</html>