<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/head/head-top.jsp"%>

<title>广告管理页面</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->

<div class="col-md-12">
    <div class="box box-solid box-primary">
        <div class="box-header">
            <h3 class="box-title pull-left mid">广告管理</h3>
        </div>
    </div>
</div>

<%@include file="../include/body/body-message.jsp"%>

<div class="col-md-12">
    <div class="box box-info">
        <div class="box-body">
            <div id="wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="table" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-sort="ascending">
                                    广告ID
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    广告标题
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    创建时间
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    广告图片路径
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    广告链接
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1">
                                    广告等级
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" >
                                    广告操作
                                </th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${adList}" var="a">
                                <tr role="row">
                                    <td class="sorting_1">${a.adId}</td>
                                    <td>${a.adTitle}</td>
                                    <td><fmt:formatDate value="${a.adDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
                                    <td>${a.adImgUrl}</td>
                                    <td>${a.adLink}</td>
                                    <td>${a.adLevel}</td>
                                    <td>
                                        <button class="btn btn-info btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_ad_edit_page?adId=${a.adId}'">编辑广告</button>
                                        <button class="btn btn-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/admin_ad_delete?adId=${a.adId}'">删除广告</button>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                            <form action="${pageContext.request.contextPath}/admin/admin_ad_add" method="post" enctype="multipart/form-data">
                                <tfoot>
                                <tr>
                                    <th rowspan="1" colspan="1">
                                        <button type="submit" class="btn bg-navy btn-sm pull-left">新增广告</button>
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        <input type="text" name="adTitle" placeholder="广告标题">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        创建时间自动生成
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        上传广告图片
                                        <input type="file" name="file">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        广告地址
                                        <input type="text" name="adLink" placeholder="http://">
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        <div class="form-group">
                                            <select class="form-control" name="adLevel">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                            </select>
                                        </div>
                                    </th>
                                    <th rowspan="1" colspan="1">
                                        <button type="submit" class="btn bg-navy btn-sm pull-left" >新增广告</button>
                                    </th>
                                </tr>
                                </tfoot>
                            </form>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">广告等级：1为最大，9为最小，等级越高在资讯页的排列越靠前</div>
                    </div>


                    <%@include file="../include/body/paginate.jsp"%>

                </div>
            </div>
        </div>
        <!-- /.box-body -->
    </div>
</div>

<%@include file="../include/body/body-bottom.jsp"%>

