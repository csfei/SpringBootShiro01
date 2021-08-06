<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
        <h3>受限资源</h3>

        <a href="${pageContext.request.contextPath}/user/logout">退出</a>

        <ul>
            <shiro:hasRole name="admin">
                <li> <a href="">订单模块</a></li>
                <li> <a href="">商品模块</a></li>
            </shiro:hasRole>
            <shiro:hasAnyRoles name="user,admin">
                <li> <a href="">用户模块</a>
                <ul>
                    <shiro:hasPermission name="user:update:*">
                        <li><a href="">修改</a></li>
                    </shiro:hasPermission>
                        <li><a href="">删除</a></li>
                        <li><a href="">添加</a></li>
                    </ul>
                </li>
            </shiro:hasAnyRoles>
        </ul>




    </body>
</html>