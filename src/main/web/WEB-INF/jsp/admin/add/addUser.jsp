<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/31
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@include file="../../include/head/head-top.jsp"%>

<title>新增后台管理用户页面</title>

<%@include file="../../include/head/head-bottom.jsp"%>

<%@include file="../../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->
<!-- Horizontal Form -->
<div class="col-md-8">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">新增后台管理用户</h3>
            <h3 class="box-title alert-message">${message}</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/user/admin_user_add">
            <div class="box-body">
                <div class="form-group">
                    <label for="userId" class="col-sm-3 control-label">用户ID</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" id="userId" placeholder="用户ID" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="userUsername" class="col-sm-3 control-label">用户名（登录名）</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="userUsername" placeholder="用户名（登录名）" name="userUsername"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="userNickname" class="col-sm-3 control-label">用户昵称</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="userNickname" placeholder="用户昵称" name="userNickname"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" placeholder="密码为5-16位" name="password"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="ensure" class="col-sm-3 control-label">确认密码</label>
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="ensure" placeholder="确认密码" name="ensure"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">用户等级</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="userLevel">
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
                </div>
            
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">提交</button>
                
                <button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/user/admin_user_list'" class="btn btn-default">取消</button>
            </div>
            <!-- /.box-footer -->
        </form>
    </div>
    <!-- /.box -->
</div>

<%--<script type="text/javascript">--%>
    <%--$(document).ready(--%>
        <%--function () {--%>
            <%--${"#userUsername"}.blur(--%>
                <%--function () {--%>
                    <%--${"#userUsername"}.var --%>
                <%--}--%>
            <%--);--%>
        <%--}--%>
    <%--);--%>
<%--</script>--%>

<%@include file="../../include/body/body-bottom.jsp"%>
