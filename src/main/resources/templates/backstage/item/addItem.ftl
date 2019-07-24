<html>
<head>
    <title></title>
<#--jquery-->
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
<#--easyui-->
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
<#--upload-->
    <script type="text/javascript" src="/commons/webuploader-0.1.5/webuploader.js"></script>
    <link rel="stylesheet" href="/commons/webuploader-0.1.5/webuploader.css">
    <style>
        table {
            width: 100%;
            padding: 10px;
            background-color: #E6EEF8;
        }
        td {
            font-size: 20px;
        }
    </style>
</head>
<body>
<form id="addItemForm">
    <table>
        <tr>
            <td align="right">商品名称:</td>
            <td><input name="itemName" size="10px" class="easyui-validatebox" type="text" data-options="required:true"></td>
            <td align="right">商品标题:</td>
            <td><input name="itemTitle" size="10px"></td>
            <td align="right">商品类型:</td>
            <td>
                <select name="itemType">
                    <option value="0">-请选择-</option>
                    <option value="1">农产品</option>
                    <option value="2">水果</option>
                    <option value="3">工艺品</option>
                    <option value="4">副产品</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">商品产地:</td>
            <td><input name="itemAddress" size="10px"></td>
            <td align="right">销售价格:</td>
            <td><input name="iskuSalePrice" size="10px" class="easyui-validatebox" type="text" data-options="required:true"></td>
            <td align="right">是否上架:</td>
            <td>
                <label><input type="radio" name="itemIsActive" value="0">已上架</label>
                <label><input type="radio" name="itemIsActive" value="1">未上架</label>
            </td>
        </tr>
        <tr>
            <td align="right">商品属性:</td>
            <td colspan="5">
                <table>
                    <tr>
                        <td>属性名</td>
                        <td>属性值(若选了前面的属性最少选两个值)</td>
                    </tr>
                    <tr>
                        <td><input name="attrAttrKey" size="5px"></td>
                        <td>
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                        </td>
                    </tr>
                   <#-- <tr>
                        <td><input name="attrAttrKey2" size="5px"></td>
                        <td>
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                        </td>
                    </tr>-->
                </table>
            </td>
        </tr>
        <tr>
            <td align="right" valign="top">上传图片:</td>
            <td valign="top" colspan="5">
                <div id="uploader-demo">
                    <img id="img" name="imgs">
                    <div id="fileList" class="uploader-list"></div><!--用来回显图片的div-->
                    <div id="filePicker">选择图片</div>
                    <div id="imgUrls"></div>
                </div>
            </td>
        </tr>
        <tr>
            <td align="right" height="">商品介绍:</td>
            <td colspan="5">
                <div id="div1"></div>
                <textarea id="text1" name="itemIntroduceValue" style="width:100%; height:200px;display: none"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="6" align="center">
                <input type="button" value="提交" id="commit">
                <input type="reset">
            </td>
        </tr>
    </table>
</form>
</body>
<script>

    //发布商品(新增)
    $("#commit").click(function(){
        $.messager.progress();	// 显示进度条
        $('#addItemForm').form('submit', {
            url: "/itemFeigh/insert",
            onSubmit: function(){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                }
                return isValid;	// 返回false终止表单提交
            },
            success: function(data){
                $.messager.progress('close');	// 如果提交成功则隐藏进度条
                data = eval("("+data+")");
                //提示信息
                $.messager.show({
                    title:'我的消息',
                    msg:data.msg,
                    timeout:5000,
                    showType:'slide'
                });
                //提示是否跳转页面
                $.messager.confirm('确认','是否去商品信息展示页面？',function(r){
                    if (r){
                        openFtl('/skip/itemList');
                    }
                }).panel("options").top = $(document).scrollTop() + 80;
            }
        });
    });

</script>

<#--富文本编辑器-->
<script type="text/javascript" src="/commons/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1')
    var $text1 = $('#text1')
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
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    //初始化
    editor.create();


     editor.customConfig.onchange = function (html) {
         // 监控变化，同步更新到 textarea
         console.log(html);
         // 读取 html
         editor.txt.html($text1);
         $text1.val(html);
     };
</script>

<#include "upload.ftl">
</html>