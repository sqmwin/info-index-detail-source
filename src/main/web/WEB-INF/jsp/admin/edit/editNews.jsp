<%--
  Created by IntelliJ IDEA.
  User: songqiming
  Date: 2018/1/27
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../../include/head/head-top.jsp"%>

<title>新增新闻页面</title>

<%@include file="../../include/head/head-bottom.jsp"%>

<%@include file="../../include/body/body-top.jsp"%>

<!--------------------------
| Your Page Content Here |
-------------------------->
<!-- Horizontal Form -->
<div class="col-md-12">
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">编辑新闻</h3>
            <h3 class="box-title alert-message">${message}</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/admin_news_edit" enctype="multipart/form-data">
            <div class="box-body">
                <div class="form-group">
                    <label for="newsId" class="col-sm-3 control-label">新闻ID</label>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" id="newsId" placeholder="${news.newsId}" disabled/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="categoryId" class="col-sm-3 control-label">新闻所属分类</label>
                    <div class="col-sm-4">
                    <select class="form-control" id="categoryId" name="categoryId">
                        <c:forEach items="${categoryList}" var="c">
                            <option value="${c.categoryId}" <c:if test="${news.categoryId == c.categoryId}"> selected </c:if>>
                                    ${c.categoryTitle}
                            </option>
                        </c:forEach>
                    </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="newsTitle" class="col-sm-3 control-label">新闻标题</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="newsTitle" placeholder="新闻标题" name="newsTitle" value="${news.newsTitle}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="newsAuthor" class="col-sm-3 control-label">新闻作者</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="newsAuthor" placeholder="新闻作者" name="newsAuthor" value="${news.newsAuthor}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="newsTranslator" class="col-sm-3 control-label">新闻翻译</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="newsTranslator" placeholder="新闻翻译" name="newsTranslator" value="${news.newsTranslator}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">是否更改视频或重新上传视频？</label>
                    <div class="col-sm-6">
                        <p class="col-sm-3 control-label text-left">
                            <input type="radio" name="reUploadVideo" class="iradio_flat-blue" value="no" onclick="displayOption(false,'hasVideoDiv')" checked>
                            否
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="reUploadVideo" class="iradio_flat-blue" value="yes" onclick="displayOption(true,'hasVideoDiv')">
                            是
                        </p>
                    </div>
                </div>
                <div id="hasVideoDiv" style="display:none">
                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻是否包含视频</label>
                    <div class="col-sm-6">
                        <!-- 是否有视频，若有视频提供上传视频框 -->
                        <p class="col-sm-3 control-label text-left">
                            <input type="radio" name="hasVideoOption" class="iradio_flat-blue" value="no" onclick="uploadVideo(false)"
                                   <c:if test="${news.hasVideo == false}">checked</c:if>>
                            无
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="hasVideoOption" class="iradio_flat-blue" value="yes" onclick="uploadVideo(true)"
                                   <c:if test="${news.hasVideo == true}">checked</c:if>>
                            有
                        </p>
                        <br/><br/>
                        <div class="help-block">若有视频只需在"新闻展示图片张数"中选择"一张"作为视频展示图片<br/>(若选择"两张"或"三张"，第二张和第三张图片无法在新闻列表中展示)</div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻视频</label>
                    <div class="col-sm-8" id="uploadVideo">
                    </div>
                </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">是否更改图片或重新上传图片？</label>
                    <div class="col-sm-6">
                        <p class="col-sm-3 control-label text-left">
                            <input type="radio" name="reUploadPic" class="iradio_flat-blue" value="no" onclick="displayOption(false,'uploadPicDiv')" checked>
                            否
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="reUploadPic" class="iradio_flat-blue" value="yes" onclick="displayOption(true,'uploadPicDiv')">
                            是
                        </p>
                    </div>
                </div>
                <div id="uploadPicDiv" style="display:none">
                <div class="form-group">
                    <label class="col-sm-3 control-label">新闻展示图片张数</label>
                    <div class="col-sm-6">
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="showImgCount" class="iradio_flat-blue" value="1" onclick="uploadPic(1)">
                            一张
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="showImgCount" class="iradio_flat-blue" value="2" onclick="uploadPic(2)">
                            两张
                        </p>
                        <p class="col-sm-3 control-label">
                            <input type="radio" name="showImgCount" class="iradio_flat-blue" value="3" onclick="uploadPic(3)">
                            三张
                        </p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">上传新闻展示图片</label>
                    <div class="col-sm-6" id="uploadDiv">
                    </div>
                </div>
                </div>
                <div class="form-group">
                    <label for="newsContent" class="col-sm-3 control-label">新闻内容</label>
                    <div class="col-sm-8">
                        <div id="editor">
                            ${news.newsContent}
                        </div>
                        <textarea class="form-control" id="newsContent" name="newsContent" style="display:none"></textarea>
                    </div>
                </div>

            </div>
            <!-- /.box-body -->
            <div class="box-footer">


                <button type="submit" class="btn btn-info pull-right">提交</button>
                <input type="hidden" name="newsId" value="${news.newsId}">
        </form>
                <button onclick="location.href='${pageContext.request.contextPath}/admin/admin_news_list'" class="btn btn-default">取消</button>
            </div>
            <!-- /.box-footer -->

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
    var path = "http://127.0.0.1:8080" + "${pageContext.request.contextPath}/admin/admin_upload_pic";
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
            // result 必须是一个 JSON 格式字符串！！！否则报错
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

<%@include file="../../include/body/body-bottom.jsp"%>
