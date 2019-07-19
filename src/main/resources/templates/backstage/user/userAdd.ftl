<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <form id="insert_form" method="post">
        用户名称:<input name="userName" class="easyui-validatebox" data-options="" /><br>
        性别:<input type="radio" value="1" name="userSex"/>男
             <input type="radio" value="2" name="userSex"/>女<br>
        年龄:<input name="userAge" class="easyui-validatebox" data-options=""/><br>
       用户手机号:<input class="easyui-validatebox" type="text" name="userPhone" data-options=""/><br>
       身份证号:<input class="easyui-validatebox" type="text" name="userIdentity" data-options=""/><br>
        居住城市:<input name="userDwell" class="easyui-validatebox" data-options=""/><br>
        出生日期:<input name="userBir" class="easyui-datebox" data-options=""/><br>
        邮箱:<input name="userEmail" class="easyui-validatebox" data-options=""/><br>
        个性签名:<input name="userSignature" class="easyui-validatebox" data-options=""/><br>
      <#--  密码:<input name="userPassword" class="easyui-validatebox" data-options=""/><br> -->

    <#--    <input type="hidden" name="userPhoto" id="hiddenId"/>
            <div id="uploader-demo">
                <!--用来存放item&ndash;&gt;
                <div id="fileList" class="uploader-list"></div>
                <div id="filePicker">选择图片</div>
            </div>-->
    </form>
</center>

<#--<script type="text/javascript">
    $(function(){
        $('#lease-form').form({
            url: '/lease/add',
            onSubmit: function(){
                var isValid = $(this).form('validate');
                if (!isValid){
                    // 如果表单是无效的则隐藏进度条
                    $.messager.progress('close');
                }
                // 返回false终止表单提交
                return isValid;
            },
            success: function(msg){
                // 如果提交成功则隐藏进度条
                $.messager.progress('close');

                $.messager.show({
                    title:'消息',
                    msg:msg,
                    timeout:2000,
                    showType:'slide'
                });
                //重置form
                $('#lease-form').form('reset');
                //刷新列表数据
                $("#wu").datagrid("reload");
            }
        });
    });

    function letFun(){
        var vals = $("input[name='letId']").val();
        console.log(1)
        $.get('${request.contextPath}/lease/sendSelectLetId',{"letId":vals},function (msg) {
            if(msg == "√"){
                $("#letSpan").html("<font color='green'>"+msg+"</font>");
            }else{
                $("#letSpan").html("<font color='red'>"+msg+"</font>");
            }
        },'html');
    }

    //初始化Web Uploader
    var uploader = WebUploader.create({

        //设置文件上传域的name
        fileVal:"upfile",

        // 选完文件后，是否自动上传。
        auto: true,

        // swf文件路径
        swf: '/commons/webuploader-0.1.5/Uploader.swf',

        // 文件接收服务端。
        server: '/lease/uploadFileInfo',

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
        $("#hxUrl").attr("style","display:none");
        var $li = $(
                        '<div id="' + file.id + '" class="file-item thumbnail">' +
                        '<img>' +
                        '<div class="info">' + file.name + '</div>' +
                        '</div>'
                ),
                $img = $li.find('img');


        // $list为容器jQuery实例
        $("#fileList").append( $li );

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
    uploader.on( 'uploadSuccess', function( file,res ) {
        $( '#'+file.id ).addClass('upload-state-done');
        $("#hiddenId").val(res._raw);
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
</script>-->
</body>
</html>