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
            <h3 class="box-title">编辑广告</h3>
            <h3 class="box-title alert-message">${message}</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/admin_category_edit">
            <div class="box-body">
                <div class="form-group">
                    <label for="adId" class="col-sm-3 control-label">广告ID</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="adId" placeholder="广告ID" disabled value="${ad.adId}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="adTitle" class="col-sm-3 control-label">广告标题</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="adTitle" name="adTitle" placeholder="广告标题" value="${ad.adTitle}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">是否更改图片或重新上传图片？</label>
                    <div class="col-sm-6">
                        <p class="col-sm-3 control-label text-left">
                            <input type="radio" name="changeImg" class="iradio_flat-blue" value="no" onclick="displayOption(false,'uploadPicDiv')" checked>
                            否
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="changeImg" class="iradio_flat-blue" value="yes" onclick="displayOption(true,'uploadPicDiv')">
                            是
                        </p>
                    </div>
                </div>
                <div class="form-group" id="uploadPicDiv" style="display:none">
                    <label class="col-sm-3 control-label">上传广告图片</label>
                    <div class="col-sm-6">
                        <input type="file" name="file">
                    </div>
                </div>
                <div class="form-group">
                    <label for="adLink" class="col-sm-3 control-label">广告链接</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="adLink" name="adLink" placeholder="广告链接" value="${ad.adLink}">
                    </div>
                </div>
                <!-- select -->
                <div class="form-group">
                    <label for="adLevel" class="col-sm-3 control-label">广告等级</label>
                    <div class="col-sm-6">
                        <select class="form-control " id="adLevel" name="adLevel">
                            <option value="1" <c:if test="${ad.adLevel == 1}"> selected </c:if>>1</option>
                            <option value="2" <c:if test="${ad.adLevel == 2}"> selected </c:if>>2</option>
                            <option value="3" <c:if test="${ad.adLevel == 3}"> selected </c:if>>3</option>
                            <option value="4" <c:if test="${ad.adLevel == 4}"> selected </c:if>>4</option>
                            <option value="5" <c:if test="${ad.adLevel == 5}"> selected </c:if>>5</option>
                            <option value="6" <c:if test="${ad.adLevel == 6}"> selected </c:if>>6</option>
                            <option value="7" <c:if test="${ad.adLevel == 7}"> selected </c:if>>7</option>
                            <option value="8" <c:if test="${ad.adLevel == 8}"> selected </c:if>>8</option>
                            <option value="9" <c:if test="${ad.adLevel == 9}"> selected </c:if>>9</option>
                        </select>
                    </div>
                </div>

                <div class="form-group col-sm-12">
                    <div class="col-sm-12 help-block">广告等级：1为最大，9为最小，等级越高在资讯页的排列越靠前</div>
                </div>

            </div>
            <!-- /.box-body -->
            <div class="box-footer">

                <button type="submit" class="btn btn-info pull-right">提交修改</button>
                <input type="hidden" name="adId" value="${ad.adId}">

        </form>
        <button onclick="location.href='${pageContext.request.contextPath}/admin/admin_ad_list'" class="btn btn-default">取消修改</button>
    </div>
    <!-- /.box-footer -->

</div>
<!-- /.box -->
</div>
<script type="text/javascript">
    //是否显示div选项
    function displayOption(boolean,element) {
        var div = document.getElementById(element);
        if (boolean) {
            div.setAttribute("style", "display:block");
        }else {
            div.setAttribute("style", "display:none");
        }
    }
</script>

<%@include file="../../include/body/body-message.jsp"%>

<%@include file="../../include/body/body-bottom.jsp"%>
