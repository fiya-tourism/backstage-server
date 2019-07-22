
var datas ;
        if (spot!=null){
            $("#submitButto").attr({"value":"保存修改"});
            $.ajax({
                type:"GET",
                url:"/spotController/spotById",
                data:{"Id":spot.spotsId},
                async:false,
                success:function (data) {
                    spot = null;
                    datas = data;
                    $("#ff").form("load",data);
                },
                error:function () {
                    alert("错误！！！");
                }
            })
        }

    $("#submitButto").click(function () {
        $.ajax({
            type:"POST",
            url:"/spotController/spotinsert",
            data:$("#ff").serialize(),
            success:function (data) {
                $("#rightcontent").empty();
                var str = $("#submitButto").val;
                if (str=="发布景点"){
                    if (1==data){
                        alert("发布成功");
                        $.ajax({
                            type:"GET",
                            url:"/skip/spotsList",
                            dataType:"html",
                            async:false,
                            success:function (data) {
                                $("#spotsListId").attr("class","current-menuleft");
                                $("#rightcontent").html(data);
                            }
                        })
                    } else {
                        alert("发布失败");
                    }
                }else {
                    if (1==data){
                        alert("保存成功");
                        $.ajax({
                            type: "GET",
                            url: "/skip/spotsList",
                            dataType: "html",
                            async: false,
                            success: function (data) {
                                $("#spotsListId").attr("class", "current-menuleft");
                                $("#rightcontent").html(data);
                            }
                        })
                    } else {
                        alert("保存失败");
                    }
                }
            }
        })
    })

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
    editor.customConfig.uploadImgMaxLength = 2;
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
    if (datas!=null){
        // 初始化 textarea 的值
        $text1.val(editor.txt.html());
        $text1.val(datas.conentisert);
        editor.txt.html($text1.val());
    }

     // editor.customConfig.onchange = function (html) {
     //     // 监控变化，同步更新到 textarea
     //     console.log(html);
     //     // 读取 html
     //     editor.txt.html($text1);
     //     $text1.val(html);
     // };



    $("#submitButto").mousedown(function(){
        $("submitButto").attr({"style":"background-color: #8baa4a;border-color: #8baa4a;width:84pt;height:32pt;"});
    });

    $("#submitButto").mouseover(function(){
        $("#submitButto").css("background-color","#5DB796");
    });
    $("#submitButto").mouseout(function(){
        $("#submitButto").css("background-color","#4781B7");
    });
