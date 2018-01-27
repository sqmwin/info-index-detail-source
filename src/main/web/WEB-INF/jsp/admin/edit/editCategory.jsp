<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/27
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../../include/head/head-top.jsp"%>

<title>栏目编辑页面</title>

<%@include file="../../include/head/head-bottom.jsp"%>

<%@include file="../../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->
<!-- Horizontal Form -->
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">编辑此栏目。。。</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/admin_category_edit">
        <div class="box-body">
            <div class="form-group">
                <label for="categoryId" class="col-sm-2 control-label">导航条栏目ID</label>
                <div class="col-sm-8">
                    <input type="number" class="form-control" id="categoryId" placeholder="导航条栏目ID" disabled value="${category.categoryId}">
                </div>
            </div>
            <div class="form-group">
                <label for="categoryTitle" class="col-sm-2 control-label">导航条栏目标题</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="categoryTitle" name="categoryTitle" placeholder="Password" maxlength="8" value="${category.categoryTitle}">
                </div>
            </div>
            <!-- select -->
            <div class="form-group">
                <label for="categoryLevel" class="col-sm-2 control-label">导航条栏目等级</label>
                <select class="form-control" id="categoryLevel" name="categoryLevel">
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
            <!-- radio -->
            <div class="form-group">
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                        Option one is this and that&mdash;be sure to include why it's great
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                        Option two can be something else and selecting it will deselect option one
                    </label>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-8"><b>导航条栏目等级：1为最大，9为最小，等级越高在资讯页的排列越靠前</b></div>
            </div>

        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <button onclick="location.href='${pageContext.request.contextPath}/admin/admin_category_list'" class="btn btn-default">取消修改</button>
            <button type="submit" class="btn btn-info pull-right">提交修改</button>

            <input type="hidden" name="categoryId"value="${category.categoryId}">
        </div>
        <!-- /.box-footer -->
    </form>
</div>
<!-- /.box -->

<%@include file="../../include/body/body-bottom.jsp"%>
