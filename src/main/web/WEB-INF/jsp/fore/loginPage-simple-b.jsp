<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>后台管理登陆页</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/admin_user_login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userUsername"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="userPassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登陆"></td>
        </tr>
        <tr>
            <td>${message}</td>
        </tr>
    </table>
</form>

</body>
</html>




