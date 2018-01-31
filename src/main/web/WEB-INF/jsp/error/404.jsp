<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/22
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../include/head/head-top.jsp"%>

<title>404：找不到此页面</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>
<div class="error-page">
    <h2 class="headline text-yellow"> 404</h2>
    
    <div class="error-content">
        <h3><i class="fa fa-warning text-yellow"></i>无此页面</h3>
        
        <p>
            <a href="${pageContext.request.contextPath}/admin/admin_home">点此返回首页</a>
        </p>
        
    </div>
    <!-- /.error-content -->
</div>
<!-- /.error-page -->
<%@include file="../include/body/body-bottom.jsp"%>