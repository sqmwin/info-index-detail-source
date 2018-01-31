<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/head/head-top.jsp"%>

    <title>新闻管理页面</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>

<%@include file="../include/body/body-news-box-header.jsp"%>

<%@include file="../include/body/body-message.jsp"%>

<div class="col-md-12 col-xs-12">
    <div class="box box-info">
        <div class="box-header">
            <%@include file="../include/button/admin-news-add.jsp"%>
        </div>
        <div class="box-body">
            <div class="dataTables_wrapper form-horizontal dt-bootstrap">
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-xs-12 table-responsive">
                        <table id="table" class="table table-bordered table-hover table-condensed dataTable" role="grid">
                            <thead>
                            <tr role="row">
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻id
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    栏目分类
                                </th>
                                <th class="col-md-1" tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    创建时间
                                </th>
                                <th class="col-md-1" tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    新闻标题
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻作者
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻翻译
                                </th>
                                <th class="col-md-4" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻展示图片
                                </th>
                                <th class="col-md-1" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻包含视频路径
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    展示图片数量
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    是否置顶
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    是否推荐
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    是否推荐中置顶
                                </th>
                                <th class="col-md-2" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻操作
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${newsList}" var="n">
                                <tr role="row">
                                    <td>${n.newsId}</td>
                                    <td>${n.categoryTitle}</td>
                                    <td class="sorting_1"><fmt:formatDate value="${n.newsDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                    <td>${n.newsTitle}</td>
                                    <td>${n.newsAuthor}</td>
                                    <td>${n.newsTranslator}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${n.showImgUrls != '' && n.showImgUrls != null}">
                                                <c:forEach items="${imgUrlMap.get(n.newsId)}" var="url">
                                                    <img src="${url}" alt="" width="160px" height="100px">
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                没有展示图片
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${n.videoUrl != '' && n.videoUrl != null}">
                                                <%--${n.videoUrl}--%>
                                                <video src="${n.videoUrl}" controls="controls" width="160px" height="100px">
                                                    你的浏览器不支持HTML5的video标签
                                                </video>
                                            </c:when>
                                            <c:otherwise>
                                                没有视频
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${n.showImgCount}</td>
                                    <td>${n.newsTop}</td>
                                    <td>${n.recommend}</td>
                                    <td>${n.newsRecommendTop}</td>
                                    <td>
                                        <div>
                                            <%@include file="../include/button/admin-news-list-operator.jsp"%>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="box-footer">
                    <%@include file="../include/button/admin-news-add.jsp"%>
                </div>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="dataTables_info" role="status" aria-live="polite">注意：</div>
                    </div>
                </div>
                <div class="col-md-4"></div>
                <div class="row col-md-4">
                    <%@include file="../include/body/paginate.jsp"%>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
        <!-- /.box-body -->
    </div>
</div>
<%@include file="../include/body/body-bottom.jsp"%>