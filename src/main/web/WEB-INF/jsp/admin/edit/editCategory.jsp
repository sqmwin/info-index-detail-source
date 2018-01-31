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
<div class="col-md-8">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">编辑栏目</h3>
            <h3 class="box-title alert-message">${message}</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/category/admin_category_edit">
            <div class="box-body">
                <div class="form-group">
                    <label for="categoryId" class="col-sm-3 control-label">导航条栏目ID</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="categoryId" placeholder="导航条栏目ID" disabled value="${category.categoryId}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="categoryTitle" class="col-sm-3 control-label">导航条栏目标题</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="categoryTitle" name="categoryTitle" placeholder="导航条栏目标题" maxlength="8" value="${category.categoryTitle}">
                    </div>
                </div>
                <!-- select -->
                <div class="form-group">
                    <label for="categoryLevel" class="col-sm-3 control-label">导航条栏目等级</label>
                    <div class="col-sm-6">
                        <select class="form-control " id="categoryLevel" name="categoryLevel">
                            <option value="1" <c:if test="${category.categoryLevel == 1}"> selected </c:if>>1</option>
                            <option value="2" <c:if test="${category.categoryLevel == 2}"> selected </c:if>>2</option>
                            <option value="3" <c:if test="${category.categoryLevel == 3}"> selected </c:if>>3</option>
                            <option value="4" <c:if test="${category.categoryLevel == 4}"> selected </c:if>>4</option>
                            <option value="5" <c:if test="${category.categoryLevel == 5}"> selected </c:if>>5</option>
                            <option value="6" <c:if test="${category.categoryLevel == 6}"> selected </c:if>>6</option>
                            <option value="7" <c:if test="${category.categoryLevel == 7}"> selected </c:if>>7</option>
                            <option value="8" <c:if test="${category.categoryLevel == 8}"> selected </c:if>>8</option>
                            <option value="9" <c:if test="${category.categoryLevel == 9}"> selected </c:if>>9</option>
                        </select>
                    </div>
                </div>

                <div class="form-group col-sm-12">
                    <div class="col-sm-12 help-block">导航条栏目等级：1为最大，9为最小，等级越高在资讯页的排列越靠前</div>
                </div>

            </div>
            <!-- /.box-body -->
            <div class="box-footer">

                <button type="submit" class="btn btn-info pull-right">提交修改</button>
                <input type="hidden" name="categoryId" value="${category.categoryId}">


                <button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/category/admin_category_list'" class="btn btn-default">取消修改</button>
            </div>
            <!-- /.box-footer -->
        </form>
    </div>
    <!-- /.box -->
</div>

<%@include file="../../include/body/body-message.jsp"%>

<%@include file="../../include/body/body-bottom.jsp"%>
