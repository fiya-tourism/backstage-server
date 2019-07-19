<#--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="/commons/wangEditor.min.js"></script>
</head>
<body>
<form id="ff" method="post">
    <input  type="hidden" name="spotsId" data-options="required:true" />
    <div>
        <label for="name">景点名称:</label>
        <input class="easyui-validatebox" type="text" name="spotsName" data-options="required:true" />
    </div>
    <div>
        <label for="name">景区类型:</label>
        <input  type="text" name="spotsType" data-options="required:true" />
    </div>
    <div>
        <label for="name">景点介绍:</label>
        <input  type="text" name="conentisert"/>
    </div>
    <div>
        <label for="name">景点地址:</label>
        <input  type="text" name="spotsAddress"/>
    </div>
    <div>
        <label fot="name">门票价格:</label>
        <input  type="text" name="spotsPrice" data-options="required:true" />
    </div>
    <div>
        <label fot="name">咨询电话:</label>
        <input  type="text" name="spotsPhone" data-options="required:true" />
    </div>
    <div>
        <label fot="name">开放时间:</label>
        <input class= "easyui-datebox" type="text" name="spotsOpenTime"   />
    </div>
    <div>
        <label fot="name">景点门票库存:</label>
        <input  type="text" name="spotsRepertory" data-options="required:true" />
    </div>
    <div>
        <label fot="name">景点活动:</label>
        <input  type="text" name="spotsActivity" />
    </div>
    <div>
        <label fot="name">集合地点:</label>
        <input  type="text" name="spotsVenue" data-options="required:true" />
    </div>
    <div>
        <label fot="name">出发时间:</label>
        <input class="easyui-datetimebox" type="text" name="spotsGotime" data-options="required:true" />
    </div>
    <div>
        <label fot="name">状态:</label>
        <select id="cc" class="easyui-combobox" name="spotsYn" style="width:200px;">
            <option value="0">展示</option>
            <option value="1" selected>不展示</option>
        </select>
    </div>
    <div id="buttonId"></div>
</form>
<script>

</script>
</body>
</html>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/commons/dialog/dialog-plus.js"></script>
</head>
<body>
<form id="ff">
    <input  type="hidden" name="spotsId" data-options="required:true" />
    <table>
        <tr>
            <td><label for="name">景点名称:</label></td>
            <td><input class="easyui-validatebox" type="text" name="spotsName" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label for="name">景点地址:</label></td>
            <td><input  type="text" name="spotsAddress"/></td>

            <td><label fot="name">门票价格:</label></td>
            <td><input  type="text" name="spotsPrice" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label fot="name">咨询电话:</label></td>
            <td><input  type="text" name="spotsPhone" data-options="required:true" /></td>

            <td><label fot="name">开放时间:</label></td>
            <td><input class= "easyui-datetimebox" type="text" name="spotsOpenTime"  data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label fot="name">景点门票库存:</label></td>
            <td><input  type="text" name="spotsRepertory" data-options="required:true" /></td>

            <td><label fot="name">景点活动:</label></td>
            <td><input  type="text" name="spotsActivity" /></td>
        </tr>
        <tr>
            <td> <label fot="name">集合地点:</label></td>
            <td><input  type="text" name="spotsVenue" data-options="required:true" /></td>

            <td><label fot="name">出发时间:</label></td>
            <td><input class="easyui-datetimebox" type="text" name="spotsGotime" data-options="required:true" /></td>
        </tr>
        <tr>
            <td><label fot="name">状态:</label></td>
            <td>
                <select id="cc" class="easyui-combobox" name="spotsYn" data-options="panelHeight:'auto'" >
                    <option value="0">展示</option>
                    <option value="1" selected>不展示</option>
                </select>
                <label for="name">景区类型:</label>
                <select id="cc" class="easyui-combobox" name="spotsType"  data-options="panelHeight:'auto'">
                    <option value="0"selected>景区</option>
                    <option value="1">休闲</option>
                </select>
            </td>
            <td>
                <textarea id="text1" name="conentisert" style="width:300%; height:400px;" hidden></textarea>
            </td>
        </tr>

        <tr>
           <td><input type="button" id="submitButto" onclick="submitt(2)" style="background-color: #4781B7;border-color: #4781b7;width:84pt;height:32pt;" value="发布景点"></td>
            <td><label for="name">景点介绍:</label></td>
        </tr>


</table>
<div id="div1" style="background-color: #BEDED4;height: auto">

</div>
</form>
<script type="text/javascript" src="/commons/wangEditor.min.js"></script>
<script type="text/javascript">

    $(function (spot) {
        if (spot.spotsId !=null){
            $("#submitButto").attr(onclick,"submitt(1)",value,"保存修改");
            //$("#ff").form("load",s);
            $.ajax({
                type:"GET",
                url:"/spotController/spotById",
                data:{"Id":s.spotsId},
                async:false,
                success:function (date) {
                    $("#ff").form("load",data);
                },
                error:function () {
                    alert("错误！！！");
                }
            })
        }
    })

    function submitt(str){
        $.ajax({
            type:"POST",
            url:"/spotController/spotinsert",
            data:$("#ff").serialize(),
            success:function (data) {
                if (str==2){
                    if (1==data){
                        alert("发布成功");
                        location.href="javascript:openFtl('/skip/spotsList')
                    } else {
                        alert("发布失败");
                    }
                }else {
                    if (1==data){
                        alert("保存成功");
                    } else {
                        alert("保存失败");
                    }
                }

            }
        })
    }

    var E = window.wangEditor;
    var editor = new E('#div1');
    var $text1 = $('#text1');
    // 自定义配置颜色（字体颜色、背景色）
    editor.customConfig.colors = [
        '#000000',
        '#eeece0',
        '#1c487f',
        '#4d80bf',
        '#c24f4a',
        '#8baa4a',
        '#7b5ba1',
        '#46acc8',
        '#f9963b',
        '#ffffff'
    ];
    // 通过 url 参数配置 debug 模式。url 中带有 errno:0 才会开启 debug 模式
    //editor.customConfig.debug = location.href.indexOf('errno:0') > 0;
    //设置上传的参数名
    editor.customConfig.uploadFileName = 'file';
    // 配置服务器端地址
    editor.customConfig.uploadImgServer ='/spotController/upload';
    // 将图片大小限制为 3M
    editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;
    // 限制一次最多上传 5 张图片
    editor.customConfig.uploadImgMaxLength = 10;
    editor.customConfig.uploadImgHooks = {
        customInsert: function (insertImg, result, editor) {
            var url =result.data;//获取后台返回的url
            insertImg(url);
        }
    };
    // 表情面板可以有多个 tab ，因此要配置成一个数组。数组每个元素代表一个 tab 的配置
    editor.customConfig.emotions = [
        {
            // tab 的标题
            title: '默认',
            // type -> 'emoji' / 'image'
            type: 'image',
            // content -> 数组
            content: [
                {
                    alt: '[坏笑]',
                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png'
                },
                {
                    alt: '[舔屏]',
                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png'
                }
            ]
        },
        {
            // tab 的标题
            title: 'emoji',
            // type -> 'emoji' / 'image'
            type: 'emoji',
            // content -> 数组
            content: ['😀', '😃', '😄', '😁', '😆']
        }
    ]
    //初始化
    editor.create();
    // 初始化 textarea 的值
    $text1.val(editor.txt.html());
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    };
    if ($text1.length!=1){
            // 读取 html
        editor.txt.html($text1);
    }


    $("#submitButto").mousedown(function(){
        $("submitButto").attr(style,"background-color: #8baa4a;border-color: #8baa4a;width:84pt;height:32pt;");
    });

    $("#submitButto").mouseover(function(){
        $("#submitButto").css("background-color","#5DB796");
    });
    $("#submitButto").mouseout(function(){
        $("#submitButto").css("background-color","#4781B7");
    });
</script>
</body>
</html>