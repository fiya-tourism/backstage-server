<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" href="/commons/webuploader-0.1.5/webuploader.css">
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/commons/dialog/dialog-plus.js"></script>
    <script type="text/javascript" src="/commons/webuploader-0.1.5/webuploader.js"></script>
</head>
<body>
<form id="ff">
    <input  type="hidden" name="spotsId" data-options="required:true" />
    <table>
        <tr>
            <td><label for="name"><font color="#f5f5dc">景点名称:</font></label></td>
            <td><input class="easyui-validatebox" type="text" name="spotsName" data-options="required:true" /></td>
            <td><label for="name"><font color="#f5f5dc">景点简介:</font></label></td>
            <td><input class="easyui-validatebox" type="text" name="spotsActivity" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label for="name"><font color="#f5f5dc">景点地址:</font></label></td>
            <td><input  type="text" name="spotsAddress"/></td>

            <td><label fot="name"><font color="#f5f5dc">门票价格:</font></label></td>
            <td><input  type="text" name="spotsPrice" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label fot="name"><font color="#f5f5dc">咨询电话:</font></label></td>
            <td><input  type="text" name="spotsPhone" data-options="required:true" /></td>

            <#--<td><label fot="name">开放时间:</label></td>-->
            <#--<td><input class= "easyui-datetimebox" type="text" name="spotsOpenTime"  data-options="required:true" /></td>-->
        </tr>
        <tr>
            <td><label fot="name"><font color="#f5f5dc">景点门票库存:</font></label></td>
            <td><input  type="text" name="spotsRepertory" data-options="required:true" /></td>
        </tr>
        <tr>
            <td> <label fot="name"><font color="#f5f5dc">集合地点:</font></label></td>
            <td><input  type="text" name="spotsVenue" data-options="required:true" /></td>

            <td><label fot="name"><font color="#f5f5dc">出发时间:</font></label></td>
            <td><input class="easyui-datetimebox" type="text" name="spotsGotime" data-options="required:true" /></td>
        </tr>
        <tr>
            <td>
                <label for="name"><font color="#f5f5dc">景区类型:</font></label>
                <select id="cc" class="easyui-combobox" name="spotsType"  data-options="panelHeight:'auto',required:true" >
                    <option value="0"selected>请选择</option>
                    <option value="1">景区</option>
                    <option value="2">休闲</option>
                </select>
            </td>
            <td>
                <textarea id="text1" name="conentisert" style="width:300%; height:400px;" hidden></textarea>
            </td>
        </tr>

        <tr>
           <td><input type="button" id="submitButto"  style="background-color: #4781B7;border-color: #4781b7;width:84pt;height:32pt;" value="发布景点"></td>
           <dt><!--dom结构部分-->
            <div id="uploader-demo" >
                <!--用来存放item-->
                <#--<div id="fileList" class="uploader-list"  ></div>-->
                <div id="filePicker">选择景点图片</div>
            </div>
               <input type="hidden" name="pictureUrl" id="pictureUrl" />
               <img src="" name="pictureUrl" id="pictureUrl" width="100px" >
           </dt>
            <td><label for="name"><font color="#f5f5dc">景点介绍:</font></label></td>
        </tr>
</table>
<div id="div1" style="background-color: #BEDED4;height: auto">
</div>
</form>

<script type="text/javascript" src="/commons/wangEditor.min.js"></script>
<script type="text/javascript">
    $(function () {
        spot = null;
    })
    var i= 0;
    <#include  "mongodb.ftl"/>

 $list = $("#fileList");
 //初始化Web Uploader
 var uploader = WebUploader.create({

     //设置文件上传域的name
     fileVal:"upfile",

     // 选完文件后，是否自动上传。
     auto: true,

     // swf文件路径
     swf: '<%=request.getContextPath()%>/commons/webuploader-0.1.5/Uploader.swf',

     // 文件接收服务端。
     server: '/spotController/uploadImg',

     // 选择文件的按钮。可选。
     // 内部根据当前运行是创建，可能是input元素，也可能是flash.
     pick: '#filePicker',

     // 只允许选择图片文件。
     accept: {
         title: 'Images',
         extensions: 'gif,jpg,jpeg,bmp,png',
         mimeTypes: 'image/*'
     }
 });

 //当有文件添加进来的时候
 uploader.on( 'fileQueued', function( file ) {
     $list.empty();
     var $li = $(
             '<div id="' + file.id + '" class="file-item thumbnail">' +
             '<img>' +
             '<div class="info">' + file.name + '</div>' +
             '</div>'
             ),
             $img = $li.find('img');

     // $list为容器jQuery实例
     $list.append( $li );

     // 创建缩略图
     // 如果为非图片文件，可以不用调用此方法。
     // thumbnailWidth x thumbnailHeight 为 100 x 100
     uploader.makeThumb( file, function( error, src ) {
         if ( error ) {
             $img.replaceWith('<span>不能预览</span>');
             return;
         }

         $img.attr( 'src', src );
     }, 100, 100 );
 });

 //文件上传过程中创建进度条实时显示。
 uploader.on( 'uploadProgress', function( file, percentage ) {
     var $li = $( '#'+file.id ),
             $percent = $li.find('.progress span');

     // 避免重复创建
     if ( !$percent.length ) {
         $percent = $('<p class="progress"><span></span></p>')
                 .appendTo( $li )
                 .find('span');
     }

     $percent.css( 'width', percentage * 100 + '%' );
 });

 //文件上传成功，给item添加成功class, 用样式标记上传成功。
 uploader.on( 'uploadSuccess', function(file,res) {
     // $( '#'+file.id ).addClass('upload-state-done');
     //上传的图片路径
     //$("#urlHiddens").val(res._raw);
     //console.log($("img[name='pictureUrl']").);
     if (spot==null){
         spot= $("img[name='pictureUrl']").attr({"src":res._raw});
         $("#pictureUrl").val(res._raw);
     }
     if (i!=0){
         var str = "pictureUrl";
         str+i;
     $("#pictureUrl").after("<img name='pictureUrl' id=str width='100px'/>");
     $("#str").attr({"src":res._raw});
     $("#pictureUrl").val($("#pictureUrl").val()+","+res._raw);
     }
     i=1;
 });

 // 文件上传失败，显示上传出错。
 uploader.on( 'uploadError', function( file ) {
     var $li = $( '#'+file.id ),
             $error = $li.find('div.error');

     // 避免重复创建
     if ( !$error.length ) {
         $error = $('<div class="error"></div>').appendTo( $li );
     }

     $error.text('上传失败');
 });

 // 完成上传完了，成功或者失败，先删除进度条。
 uploader.on( 'uploadComplete', function( file ) {
     $( '#'+file.id ).find('.progress').remove();
 });

</script>
</body>
</html>