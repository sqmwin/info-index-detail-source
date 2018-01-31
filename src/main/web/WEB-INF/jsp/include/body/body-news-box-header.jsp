<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/31
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="col-md-12">
    <div class="box box-solid box-primary">
        <div class="box-header">
            <h3 class="box-title pull-left mid">新闻管理</h3>
        </div>
        <div class="box-body">
            <p>
                <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_list'">全部</button>
                <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_list_recommend'">推荐</button>
                <c:forEach items="${categoryList}" var="c">
                    <button class="btn btn-info" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_list_by_category_id?categoryId=${c.categoryId}'">${c.categoryTitle}</button>
                </c:forEach>
            </p>
        </div>
    </div>
</div>