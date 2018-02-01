<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../include/head/head-top.jsp"%>

    <title>后台管理用户页面</title>

<%@include file="../include/head/head-bottom.jsp"%>

<%@include file="../include/body/body-top.jsp"%>

    <!--------------------------
    | Your Page Content Here |
    -------------------------->

<div class="col-md-8">
    <div class="box box-solid box-primary">
        <div class="box-header">
            <h3 class="box-title pull-left mid">后台管理用户管理</h3>
        </div>
    </div>
</div>

<%@include file="../include/body/body-message.jsp"%>

<div class="col-md-8">
    <div class="box box-info">
        <div class="box-body">
            <div id="wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="table" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                            <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-sort="ascending" aria-label="用户ID: activate to sort column descending">
                                    用户ID
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-label="用户名: activate to sort column ascending">
                                    用户名
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-label="用户名: activate to sort column ascending">
                                    用户密码
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-label="用户名: activate to sort column ascending">
                                    用户昵称
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-label="用户等级: activate to sort column ascending">
                                    用户等级
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="table" rowspan="1" colspan="1" aria-label="用户操作: activate to sort column ascending">
                                    用户操作
                                </th>
                            </tr>
                            </thead>
                            
                            <tbody>
                            
                            <c:forEach items="${userList}" var="u">
                                <tr role="row">
                                    <td class="sorting_1">${u.userId}</td>
                                    <td>${u.userUsername}</td>
                                    <td>********</td>
                                    <td>${u.userNickname}</td>
                                    <td id="userLevel">${u.userLevel}</td>
                                    <td>
                                        <div class="col-md-6"><button id="changeLevel" class="btn btn-info btn-sm" onclick="changeLevel(${u.userId},${u.userLevel})">编辑用户等级</button></div>
                                        <div class="col-md-6"><button class="btn btn-danger btn-sm" onclick="location.href='${pageContext.request.contextPath}/admin/user/admin_user_delete?userId=${u.userId}'">删除用户</button></div>
                                    </td>
                                </tr>
                            </c:forEach>
                            
                            </tbody>

                        </table>
                    </div>
                    <div>
                    
                    </div>
                </div>
                <div class="box-footer">
                    <div class="col-md-12">
                        <button class="btn bg-navy col-md-2 pull-left" onclick="location.href='${pageContext.request.contextPath}/admin/user/admin_user_add_page'">新增用户</button>
            
                        <button class="btn bg-navy col-md-2 pull-right" onclick="location.href='${pageContext.request.contextPath}/admin/user/admin_user_add_page'">新增用户</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-6">
                        <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">用户等级：1为最大，9为最小</div>
                    </div>
                </div>
                <div class="row col-sm-6 col-md-6">
                    <%@include file="../include/body/paginate.jsp"%>
                </div>
            </div>
        </div>
        <!-- /.box-body -->

    </div>
</div>
<script type="text/javascript">
    function changeLevel(id,level) {
        var levelTd = document.getElementById("userLevel");
        //如果没有子节点,则清空html内容
        if (!levelTd.hasAttribute("c")) {
            levelTd.setAttribute("c", "c");
            levelTd.innerHTML = "";
            //设置一个select
            var levelSelect = document.createElement("select");
            levelSelect.setAttribute("id", "select");
            levelSelect.setAttribute("class", "form-control");
            levelSelect.setAttribute("name", "userLevel");
            levelTd.appendChild(levelSelect);
            //设置select的option
            for (var i=1; i<10; i++) {
                var option = document.createElement("option");
                option.setAttribute("id", i);
                option.setAttribute("value", i);
                option.innerText = i;
                if (level === i) {
                    option.setAttribute("selected","true");
                }
                levelSelect.appendChild(option);
            }
        }
        //如果有子节点
        else if(levelTd.hasAttribute("c")){
            var select = document.getElementById("select");
            //获取被选中的option的index索引
            var index = select.selectedIndex;
            //获取被选中的option 的值
            var value = select.options[index].value;
            window.location.href = "${pageContext.request.contextPath}/admin/user/admin_user_edit_level?userId=" + id + "&userLevel=" + value;
        }
    }
</script>
<%@include file="../include/body/body-bottom.jsp"%>
