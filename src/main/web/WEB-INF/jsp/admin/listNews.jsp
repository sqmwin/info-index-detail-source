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
<div class="col-md-8">
    <div class="box box-solid box-primary">
        <div class="box-header">
            <h3 class="box-title pull-left mid">新闻管理</h3>
        </div>
        <div class="box-body">
            <p>
                <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_list'">全部</button>
                <button class="btn btn-success" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_list_recommend'">推荐</button>
                <c:forEach items="${categoryList}" var="c">
                    <button class="btn btn-info" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_list_by_category_id?categoryId=${c.categoryId}'">${c.categoryTitle}</button>
                </c:forEach>
            </p>
        </div>
    </div>
</div>

<%@include file="../include/body/body-message.jsp"%>

<div class="col-md-12 col-xs-12">
    <div class="box box-info">
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
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    创建时间
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    新闻标题
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻作者
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻翻译
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻展示图片(路径)
                                </th>
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    新闻所属视频(路径)
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
                                <th tabindex="0" aria-controls="table" rowspan="1" colspan="1">
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
                                    <td>${n.showImgUrls}</td>
                                    <td>${n.videoUrl}</td>
                                    <td>${n.showImgCount}</td>
                                    <td>${n.newsTop}</td>
                                    <td>${n.recommend}</td>
                                    <td>${n.newsRecommendTop}</td>
                                    <td>
                                        <button class="btn btn-warning btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_top?newsId=${n.newsId}'">设为置顶</button>
                                        <button class="btn btn-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_top_cancel?newsId=${n.newsId}'">取消置顶</button>
                                        <button class="btn btn-success btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_recommend?newsId=${n.newsId}'">设为推荐</button>
                                        <button class="btn btn-danger btn-sm " onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_recommend_cancel?newsId=${n.newsId}'">取消推荐</button>
                                        <button class="btn btn-success btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_recommend_top?newsId=${n.newsId}'">设为推荐置顶</button>
                                        <button class="btn btn-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_recommend_top_cancel?newsId=${n.newsId}'">取消推荐置顶</button>
                                        <button class="btn btn-info btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_edit_page?newsId=${n.newsId}'">编辑新闻</button>
                                        <button class="btn btn-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_delete?newsId=${n.newsId}'">删除新闻</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                                <tfoot>
                                <tr>
                                    <th rowspan="1" colspan="1">
                                        <button class="btn bg-navy btn-sm pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_add_page'">新增新闻</button>
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        <button class="btn bg-navy btn-sm pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_add_page'">新增新闻</button>
                                    </th>
                                </tr>
                                </tfoot>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">注意：</div>
                    </div>


                    <%@include file="../include/body/paginate.jsp"%>

                </div>
            </div>
        </div>
        <!-- /.box-body -->
    </div>
</div>
<%@include file="../include/body/body-bottom.jsp"%>