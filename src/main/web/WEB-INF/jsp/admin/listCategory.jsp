<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/head/head-top.jsp"%>

    <title>栏目分类管理页面</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->

<div class="box">
    <div class="box-header">
        <h3 class="box-title">栏目分类管理</h3>
    </div>
    <!-- /.box-header -->

    <div class="box-body">
        <div id="example2_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
            <div class="row">
                <div class="col-sm-6"></div>
                <div class="col-sm-6"></div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                        <thead>
                        <tr role="row">
                            <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending" aria-label="导航条栏目ID: activate to sort column descending">
                                导航条栏目ID
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="导航条栏目标题: activate to sort column ascending">
                                导航条栏目标题
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="导航条等级: activate to sort column ascending">
                                导航条等级
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="导航条等级: activate to sort column ascending">
                                编辑导航条
                            </th>
                            <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-label="导航条等级: activate to sort column ascending">
                                删除导航条
                            </th>
                        </tr>
                        </thead>

                        <tbody>

                        <c:forEach items="${categoryList}" var="c">
                        <tr role="row">
                            <td class="sorting_1">${c.categoryId}</td>
                            <td>${c.categoryTitle}</td>
                            <td>${c.categoryLevel}</td>
                            <td>
                                <button class="btn btn-info pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/admin_category_edit_page?categoryId=${c.categoryId}'">编辑此栏目</button>
                            </td>
                            <td>
                                <button class="btn btn-info pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/admin_category_delete?categoryId=${c.categoryId}'">删除此栏目</button>
                            </td>
                        </tr>
                        </c:forEach>

                        </tbody>
                        <form action="${pageContext.request.contextPath}/admin/admin_category_add" method="post">
                        <tfoot>
                        <tr>
                            <th rowspan="1" colspan="1">
                                <button type="submit" class="btn btn-info pull-left">新增导航条栏目</button>
                            </th>
                            <th rowspan="1" colspan="1">
                                <input type="text" name="categoryTitle">
                            </th>
                            <th rowspan="1" colspan="1">
                                <div class="form-group">
                                <select class="form-control" name="categoryLevel">
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
                                <button type="submit" class="btn btn-info pull-left" >新增导航条栏目</button>
                            </th>
                        </tr>
                        </tfoot>
                        </form>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-5">
                    <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">导航条栏目等级：1为最大，9为最小，等级越高在资讯页的排列越靠前</div>
                </div>


                <%@include file="../include/body/paginate.jsp"%>
                
            </div>
        </div>
    </div>
    <!-- /.box-body -->
</div>

<%@include file="../include/body/body-bottom.jsp"%>

