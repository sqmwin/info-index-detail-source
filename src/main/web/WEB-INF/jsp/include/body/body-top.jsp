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
        <nav class="navbar navbar-fixed-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">导航开关</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#"><span class="hidden-xs">${pageContext.session.getAttribute("user").userNickname}</span></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/admin_user_change_password_page">修改密码</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/admin_user_logout">退出登录</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">页面列表</li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_category_list"><i class="fa fa-circle-o"></i> <span>栏目管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_news_list"><i class="fa fa-circle-o"></i> <span>新闻管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_ad_list"><i class="fa fa-circle-o"></i> <span>广告管理页面</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/admin_user_list"><i class="fa fa-circle-o"></i> <span>管理用户页面</span></a></li>
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
                后台管理系统
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/admin/admin_home"><i class="fa fa-dashboard"></i>Home</a></li>
                <li class="active">Here</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">