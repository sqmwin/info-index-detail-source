<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@include file="../../include/head/head-top.jsp"%>

    <title>更改密码</title>

<%@include file="../../include/head/head-bottom.jsp"%>

<%@include file="../../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->
<div class="col-md-6">
    <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">修改密码</h3>
                <%@include file="../../include/body/body-message.jsp"%>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" action="${pageContext.request.contextPath}/admin/user/admin_user_change_password" method="post">
                <div class="box-body">
                    <div class="form-group col-md-7">
                        <label for="password">新密码</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="输入新密码">
                    </div>
                    <div class="form-group col-md-7">
                        <label for="ensure">确认新密码</label>
                        <input type="password" class="form-control" id="ensure" name="ensure" placeholder="确认新密码">
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label for="exampleInputFile">File input</label>--%>
                        <%--<input type="file" id="exampleInputFile">--%>
                        <%----%>
                        <%--<p class="help-block"></p>--%>
                    <%--</div>--%>
                    <%--<div class="checkbox">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox"> Check me out--%>
                        <%--</label>--%>
                    <%--</div>--%>
                </div>
                <!-- /.box-body -->
                
                <div class="box-footer">
                    <button type="button" class="btn btn-default pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/admin_home'">取消修改</button>
                    <button type="submit" class="btn btn-info pull-right">确认修改</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="../../include/body/body-bottom.jsp"%>
