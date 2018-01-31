<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/31
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<button class="btn btn-primary btn-xs col-md-12" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_detail?newsId=${n.newsId}'">查看新闻详情页</button>
</div>
<div>
    <button class="btn btn-warning btn-xs col-md-6" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_top?newsId=${n.newsId}'">设为分类置顶</button>
    <button class="btn btn-danger btn-xs col-md-6 pull-right" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_top_cancel?newsId=${n.newsId}'">取消分类置顶</button>
</div>
<div>
    <button class="btn btn-success btn-xs col-md-6" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_recommend?newsId=${n.newsId}'">设为推荐</button>
    <button class="btn btn-danger btn-xs col-md-6 pull-right" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_recommend_cancel?newsId=${n.newsId}'">取消推荐</button>
</div>
<div>
    <button class="btn btn-success btn-xs col-md-6" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_recommend_top?newsId=${n.newsId}'">设为推荐置顶</button>
    <button class="btn btn-danger btn-xs col-md-6 pull-right" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_recommend_top_cancel?newsId=${n.newsId}'">取消推荐置顶</button>
</div>
<div>
    <button class="btn btn-info btn-xs col-md-6" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_edit_page?newsId=${n.newsId}'">编辑新闻</button>
    <button class="btn btn-danger btn-xs col-md-6 pull-right" onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_delete?newsId=${n.newsId}'">删除新闻</button>