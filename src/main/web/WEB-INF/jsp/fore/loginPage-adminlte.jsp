<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


<%@include file="../include/head/head-top.jsp"%>

    <title>后台管理登陆页</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>

<form action="${pageContext.request.contextPath}/admin/admin_user_login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
        <tr>
            <td>${message}</td>
        </tr>
    </table>
</form>

<%@include file="../include/body/body-bottom.jsp"%>