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
        <table style="background-color: chocolate">
            <tr>
                <td><label for="name">景点名称:</label></td>
                <td><input class="easyui-validatebox" type="text" name="spotsName" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label for="name">景区类型:</label></td>
                <td> <select id="cc" class="easyui-combobox" name="spotsType" style="width:200px;">
                        <option value="0"selected>景区</option>
                        <option value="1">休闲</option>
                     </select>
                </td>
            </tr>
            <tr>
                <td><label for="name">景点地址:</label></td>
                <td><input  type="text" name="spotsAddress"/></td>
            </tr>
            <tr>
                <td><label fot="name">门票价格:</label></td>
                <td><input  type="text" name="spotsPrice" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label fot="name">咨询电话:</label></td>
                <td><input  type="text" name="spotsPhone" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label fot="name">开放时间:</label></td>
                <td><input class= "easyui-datetimebox" type="text" name="spotsOpenTime"   /></td>
            </tr>
            <tr>
                <td><label fot="name">景点门票库存:</label></td>
                <td><input  type="text" name="spotsRepertory" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label fot="name">景点活动:</label></td>
                <td><input  type="text" name="spotsActivity" /></td>
            </tr>
            <tr>
                <td> <label fot="name">集合地点:</label>/td>
                <td><input  type="text" name="spotsVenue" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label fot="name">出发时间:</label></td>
                <td><input class="easyui-datetimebox" type="text" name="spotsGotime" data-options="required:true" /></td>
            </tr>
            <tr>
                <td><label fot="name">状态:</label></td>
                <td> <select id="cc" class="easyui-combobox" name="spotsYn" style="width:200px;">
                        <option value="0">展示</option>
                        <option value="1" selected>不展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="name">景点介绍:</label></td>
                <td>
                    <div id="div1" >
                        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                    </div>
                    <textarea id="text1" name="conentisert" style="width:300%; height:400px;" hidden></textarea>
                </td>
            </tr>
            <tr>
                <td>
                    <input type='button' onclick="submitt()" value="发布">
                </td>
            </tr>
    </form>
</table>
<script type="text/javascript" src="/commons/wangEditor.min.js"></script>
<script type="text/javascript">

    function submitt(){
        $.ajax({
            type:"POST",
            url:"/spotController/spotinsert",
            data:$("#ff").serialize(),
            success:function (data) {
                if (1==data){
                    alert("发布成功");
                } else {
                    alert("发布失败");
                }
            }
        })
    }


    var E = window.wangEditor
    var editor = new E('#div1')
    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    };
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
    //设置上传的参数名
    editor.customConfig.uploadFileName = 'file';
    // 配置服务器端地址
    editor.customConfig.uploadImgServer = '/spotController/upload';
    // 将图片大小限制为 3M
    editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;
    // 限制一次最多上传 5 张图片
    editor.customConfig.uploadImgMaxLength = 10;
    editor.customConfig.uploadImgHooks = {
        before: function (xhr, editor, files) {
            // 图片上传之前触发
            // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

            // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
            // return {
            //     prevent: true,
            //     msg: '放弃上传'
            // }
        },
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
            var url = result.url;
            insertImg(url)

            // result 必须是一个 JSON 格式字符串！！！否则报错
        }
    };

    editor.create();
    // 初始化 textarea 的值
    $text1.val(editor.txt.html());


</script>
</body>
</html>