<html>
<head>
    <title>景点预览</title>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/commons/dialog/dialog-plus.js"></script>
</head>
<body>
<table id="dg"></table>
<div id="pzx" style="width: initial;height: 500pt"></div>
<script>
    $(function () {
        selelctlist();
        function selelctlist(){
            //查询信息展示
            $('#dg').datagrid({
                url:'/spotController/spotselect',
                method:"GET",
                fitColumns:true,
                pagination:true,
                fit:true,
                pageNumber:1,
                pageSize:10,
                pageList:[2,10,30,40,50],
                columns:[[
                    {field:'spotsId',title:'旅游编号',width:50},
                    {field:'spotsName',title:'景点名称',width:50},
                    {field:'spotsType',title:'园区类型',width:50,formatter:function (value) {
                            if (value==1){
                                return "景区"
                            } else {
                                return "休闲"
                            }
                        }},
                    {field:'spotsPhone',title:'资讯电话',width:50},
                    {field:'spotsActivity',title:'景点活动',width:50},
                    {field:'spotsVenue',title:'集合地点',width:50},
                    {field:'spotsAddress',title:'景点地址',width:50},
                    {field:'easintroduce',title:'景点简介',width:50},
                    {field:'spotsPhone',title:'资讯电话',width:50},
                    {field:'spotsRepertory',title:'景点门票库存',width:50},
                    {field:'spotsOpenTime',title:'开放时间',width:50},
                    {field:'spotsPrice',title:'门票价格',width:50},
                    {field:'spotsUpdate',title:'修改时间',width:50
            //         {field:'spotsGrounding',title:'状态',width:50,formatter:function (value,row,index) {
            //                 if (value==1){
            //                     return "已上架"
            //                 } else {
            //                     return "未上架"
            //                 }
            // }
                    },
                    {field:'staffId',title:'发布员工',width:50}
                ]],
                toolbar: [{
                    text:"修改景点",
                    iconCls: 'icon-edit',
                    handler: function(){
                        spot = $("#dg").datagrid('getSelected');
                        if (spot==null){
                            return alert("请选择要修改的景点数据！！");
                        }
                        $("#rightcontent").empty();

                        $.ajax({
                            type:"GET",
                            url:"/spotController/spotupdateftl",
                            data:{"Id":spot.spotsId},
                            dataType:"html",
                            async:false,
                            success:function (data) {
                                $("#addSpotsId").attr("class","current-menuleft");
                                $("#rightcontent").html(data);


                            },
                            error:function () {

                            }
                        })
                        // $('#pzx').dialog({
                        //     title: '修改出景点',
                        //     width: 470,
                        //     height: 480,
                        //     href: '/spotController/spotupdateftl',
                        //     modal: true,
                        //     buttons:[{
                        //         text:'保存',
                        //         handler:function(){
                        //             updates();
                        //             $("#dg").datagrid('reload');
                        //         }
                        //     },{
                        //         text:'关闭',
                        //         handler:function(){
                        //             $("#xuzhen").dialog('close');
                        //         }
                        //     }]
                        // });

                    }
                },'-',{
                    text:"下架并删除",
                    iconCls: 'icon-no',
                    handler: function(){
                        spot =$("#dg").datagrid("getSelected");
                        if (spot==null){
                            return alert("请选择要删除出的景点数据！！");
                        }
                        $.ajax({
                            type:"GET",
                            url:"/spotController/spotdelete",
                            data:{"Id":spot.spotsId},
                            dataType:"json",
                            success:function (data) {
                                if (data==1){
                                    return "已上架";
                                } else {
                                    return "未上架";
                                }
                            }
                        });
                        $("#dg").datagrid('reload');
                    }
                },'-',{
                    text:"景区编号：<input type='text' id='likeId'/> "
                },'-',{
                    iconCls: 'icon-search',
                    text:"搜索",
                    handler: function(){
                        var likeId= $("#likeId").val();
                        $('#dg').datagrid('load',{
                            postId: likeId
                        });
                    }
                }]
            });
        }
    });
    function updates() {
        $.messager.progress();	// 显示进度条
        $('#ff').form('submit', {
            url: "/spotController/spotinsert",
            onSubmit: function(data){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                }
                return isValid;	// 返回false终止表单提交
            },
            success: function(data){
                if (1==data){
                    alert("修改成功");
                } else {
                    alert("修改失败");
                }
                $.messager.progress('close');	// 如果提交成功则隐藏进度条
                $("#pzx").dialog('close');
                $("#dg").datagrid('reload');
            }
        });

    }
</script>
</body>
</html>