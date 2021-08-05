<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
    </head>
    <body>
        <h3>公共资源</h3>

        <form action="${pageContext.request.contextPath}/user/login" method="post">
            用户名：<input type="text" name="username"><br/>
            密  码：<input type="text" name="password"><br/>
            <input type="submit" value="登录">
        </form>
    </body>
</html>