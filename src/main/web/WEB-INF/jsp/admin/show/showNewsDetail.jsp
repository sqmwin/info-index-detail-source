<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/27
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../../include/head/head-top.jsp"%>

<title>新闻详情页面</title>

<%@include file="../../include/head/head-bottom.jsp"%>

<%@include file="../../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->
<!-- Horizontal Form -->
<div class="col-md-12">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">新闻详情页面</h3>
            <h3 class="box-title alert-message">${message}</h3>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
            <div class="row col-md-12">
                <c:choose>
                    <c:when test="${news.videoUrl != '' && news.videoUrl != null}">
                            <video src="${news.videoUrl}" controls="controls"  width="320px" height="200px"></video>
                    </c:when>
                    <c:otherwise> </c:otherwise>
                </c:choose>
            </div>
            <div class="row col-md-12">
                <h3 class="box-title">新闻标题：${news.newsTitle}</h3>
            </div>
            <div class="row ">
                <div class="col-md-4">
                    创建时间：<fmt:formatDate value="${news.newsDate}" pattern="yyyy-MM-dd"/>
                </div>
                <div class="col-md-4">
                    作者(来源):${news.newsAuthor}
                </div>
                <div class="col-md-4">
                    编译:${news.newsTranslator}
                </div>
            </div>
            <div class="row col-md-12">
                新闻内容
            </div>
            <div class="row col-md-12">
                ${news.newsContent}
            </div>
        </div>
        <div class="box-footer">
            <div class="row col-md-12">
                <button type="button" class="btn btn-default btn-sm col-md-3"
                        onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_list'">返回</button>
                <button type="button" class="btn btn-info btn-sm col-md-3 pull-right"
                        onclick="location.href='${pageContext.request.contextPath}/admin/news/admin_news_edit_page?newsId=${news.newsId}'">修改新闻</button>
            </div>
        </div>
    </div>
    <!-- /.box -->
</div>

<%@include file="../../include/body/body-message.jsp"%>

<%--wangEditor--%>
<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wang_editor/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');

    //debug模式
    editor.customConfig.debug = true;
    // 通过 url 参数配置 debug 模式。url 中带有 wangeditor_debug_mode=1 才会开启 debug 模式
    // editor.customConfig.debug = location.href.indexOf('wangeditor_debug_mode=1') > 0

    // 自定义菜单配置
    editor.customConfig.menus = [
        'head',  // 标题
        'bold',  // 粗体
        'italic',  // 斜体
        'underline',  // 下划线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'justify',  // 对齐方式
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'code'  // 插入代码
    ];
    //获取此编辑框的textarea
    var $newsContent = $('#newsContent');
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $newsContent.val(html)
    };
    //上传图片
    //图片上传接口路径
    var path = "${pageContext.request.contextPath}/file/upload_pic";
    editor.customConfig.uploadImgServer = path;
    editor.customConfig.uploadImgMaxSize = 1.5 * 1024 * 1024; //限制上传图片的大小
    editor.customConfig.uploadImgMaxLength = 1; //限制一次上传图片的数量
    editor.customConfig.uploadFileName = 'file';//设置上传文件的name属性，对应@RequestParam的value
    editor.customConfig.uploadImgHooks = {
        success: function (xhr, editor, result) {

            // 图片上传并返回结果，图片插入成功之后触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
        },
        fail: function (xhr, editor, result) {


            // 图片上传并返回结果，但图片插入错误时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
        },
        error: function (xhr, editor) {


            // 图片上传出错时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },
        timeout: function (xhr, editor) {


            // 图片上传超时时触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
        },

        // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        customInsert: function (insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
            // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
            // var imgArr = result.data;//获取服务器返回的图片路径数组
            // for (var i = 0, length = imgArr.length; i < length; i++) {
                // var str = "http";
                // if (imgArr[i].indexOf(str) > -1) {
                //     insertImg(imgArr[i]);
                // } else {
                //     insertImg("http://" + imgArr[i]);
                // }
                // insertImg(imgArr[i]);
            // }
            // result 必须是一个 JSON 格式字符串！！！
            insertImg(result);
        }
    };
    editor.create();
    // 初始化 textarea 的值
    $newsContent.val(editor.txt.html())
</script>

<script type="text/javascript">
    //是否上传视频
    function uploadVideo(boolean) {
        //获取上传块的父元素
        var parent = document.getElementById("uploadVideo");
        if (!boolean) {
            // 删除父元素中的所有元素
            while (parent.hasChildNodes()) {
                parent.removeChild(parent.childNodes[0]);
            }
        }else {
            // 删除父元素中的所有元素
            while (parent.hasChildNodes()) {
                parent.removeChild(parent.childNodes[0]);
            }
            //连一个新的上传input
            var input = document.createElement("input");
            input.setAttribute("type", "file");
            input.setAttribute("name", "file");
            parent.appendChild(input);
        }
    }

    // 点击num张展示图片，提供num个上传框
    function uploadPic(num) {
        //获取上传块父元素
        var parent = document.getElementById("uploadDiv");

        // 删除父元素中的所有元素
        while (parent.hasChildNodes()) {
            parent.removeChild(parent.childNodes[0]);
        }

        //创建file input,根据传回的num
        for (var i = 0; i < num ; i++) {
            var input = document.createElement("input");
            input.setAttribute("type", "file");
            input.setAttribute("name", "file");
            parent.appendChild(input);
        }
    }
</script>

<%@include file="../../include/body/body-bottom.jsp"%>
