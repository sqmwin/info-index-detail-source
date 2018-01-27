<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/26
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">
        <!-- Logo -->
        <%--回到主页--%>
        <a href="${pageContext.request.contextPath}/admin/admin_home" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">管理</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">后台管理系统</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <%--&lt;%&ndash;信息按钮&ndash;%&gt;--%>
                    <%--<li class="dropdown messages-menu">--%>
                    <%--<!-- Menu toggle button -->--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                    <%--<i class="fa fa-envelope-o"></i>--%>
                    <%--<span class="label label-success">4</span>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li class="header">You have 4 messages</li>--%>
                    <%--<li>--%>
                    <%--<!-- inner menu: contains the messages -->--%>
                    <%--<ul class="menu">--%>
                    <%--<li><!-- start message -->--%>
                    <%--<a href="#">--%>
                    <%--<div class="pull-left">--%>
                    <%--<!-- User Image -->--%>
                    <%--<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                    <%--</div>--%>
                    <%--<!-- Message title and timestamp -->--%>
                    <%--<h4>--%>
                    <%--Support Team--%>
                    <%--<small><i class="fa fa-clock-o"></i> 5 mins</small>--%>
                    <%--</h4>--%>
                    <%--<!-- The message -->--%>
                    <%--<p>Why not buy a new awesome theme?</p>--%>
                    <%--</a>--%>
                    <%--</li>--%>
                    <%--<!-- end message -->--%>
                    <%--</ul>--%>
                    <%--<!-- /.menu -->--%>
                    <%--</li>--%>
                    <%--<li class="footer"><a href="#">See All Messages</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<!-- /.messages-menu -->--%>

                    <%--<!-- Notifications Menu -->--%>
                    <%--<li class="dropdown notifications-menu">--%>
                    <%--<!-- Menu toggle button -->--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                    <%--<i class="fa fa-bell-o"></i>--%>
                    <%--<span class="label label-warning">10</span>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li class="header">You have 10 notifications</li>--%>
                    <%--<li>--%>
                    <%--<!-- Inner Menu: contains the notifications -->--%>
                    <%--<ul class="menu">--%>
                    <%--<li><!-- start notification -->--%>
                    <%--<a href="#">--%>
                    <%--<i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
                    <%--</a>--%>
                    <%--</li>--%>
                    <%--<!-- end notification -->--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li class="footer"><a href="#">View all</a></li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<!-- /。Notifications Menu -->--%>

                    <%--<!-- Tasks Menu -->--%>
                    <%--<li class="dropdown tasks-menu">--%>
                    <%--<!-- Menu Toggle Button -->--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                    <%--<i class="fa fa-flag-o"></i>--%>
                    <%--<span class="label label-danger">9</span>--%>
                    <%--</a>--%>
                    <%--<ul class="dropdown-menu">--%>
                    <%--<li class="header">You have 9 tasks</li>--%>
                    <%--<li>--%>
                    <%--<!-- Inner menu: contains the tasks -->--%>
                    <%--<ul class="menu">--%>
                    <%--<li><!-- Task item -->--%>
                    <%--<a href="#">--%>
                    <%--<!-- Task title and progress text -->--%>
                    <%--<h3>--%>
                    <%--Design some buttons--%>
                    <%--<small class="pull-right">20%</small>--%>
                    <%--</h3>--%>
                    <%--<!-- The progress bar -->--%>
                    <%--<div class="progress xs">--%>
                    <%--<!-- Change the css width attribute to simulate progress -->--%>
                    <%--<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar"--%>
                    <%--aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">--%>
                    <%--<span class="sr-only">20% Complete</span>--%>
                    <%--</div>--%>
                    <%--</div>--%>
                    <%--</a>--%>
                    <%--</li>--%>
                    <%--<!-- end task item -->--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li class="footer">--%>
                    <%--<a href="#">View all tasks</a>--%>
                    <%--</li>--%>
                    <%--</ul>--%>
                    <%--</li>--%>
                    <%--<!-- /。Tasks Menu -->--%>

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <%--<img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">--%>
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${pageContext.session.getAttribute("user").userNickname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <%--<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>

                                <p>
                                    ${pageContext.session.getAttribute("user").userNickname}
                                    <%--<small>Member since Nov. 2012</small>--%>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <%--<div class="row">--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Followers</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Sales</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Friends</a>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="${pageContext.request.contextPath}/admin/admin_user_change_password_page" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a href="${pageContext.request.contextPath}/admin/admin_user_logout" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- /。User Account Menu -->
                </ul>
            </div>
        </nav>
    </header>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <%--<div class="user-panel">--%>
                <%--<div class="pull-left image">--%>
                <%--<img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                <%--</div>--%>
                <%--<div class="pull-left info">--%>
                    <%--<p>${pageContext.session.getAttribute("user").userNickname}</p>--%>
                    <%--<!-- Status -->--%>
                    <%--<a href="#"><i class="fa fa-circle text-success"></i> Online</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <!-- /.Sidebar user panel (optional) -->

            <%--<!-- search form (Optional) -->--%>
            <%--<form action="#" method="get" class="sidebar-form">--%>
            <%--<div class="input-group">--%>
            <%--<input type="text" name="q" class="form-control" placeholder="Search...">--%>
            <%--<span class="input-group-btn">--%>
            <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>--%>
            <%--</button>--%>
            <%--</span>--%>
            <%--</div>--%>
            <%--</form>--%>
            <%--<!-- /.search form -->--%>

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header"></li>
                <!-- Optionally, you can add icons to the links -->
                <%--<li class="active"><a href="#"><i class="fa fa-link"></i> <span>栏目管理页面</span></a></li>--%>
                <li><a href="${pageContext.request.contextPath}/admin/admin_category_list"><i class="fa fa-link"></i> <span>栏目管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_news_list"><i class="fa fa-link"></i> <span>新闻管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_ad_list"><i class="fa fa-link"></i> <span>广告管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_user_list"><i class="fa fa-link"></i> <span>管理用户页面</span></a></li>
                <%--<li class="treeview">--%>
                <%--<a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>--%>
                <%--<span class="pull-right-container">--%>
                <%--<i class="fa fa-angle-left pull-right"></i>--%>
                <%--</span>--%>
                <%--</a>--%>
                <%--<ul class="treeview-menu">--%>
                <%--<li><a href="#">Link in level 2</a></li>--%>
                <%--<li><a href="#">Link in level 2</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <%--Page Header--%>
                <%--<small>Optional description</small>--%>
                后台管理系统
            </h1>
            <%--<ol class="breadcrumb">--%>
                <%--<li><a href="${pageContext.request.contextPath}/admin/admin_home"><i class="fa fa-dashboard"></i> Home</a></li>--%>
                <%--<li class="active">Here</li>--%>
            <%--</ol>--%>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">