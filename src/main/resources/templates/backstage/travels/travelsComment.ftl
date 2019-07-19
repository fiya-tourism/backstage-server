<!DOCTYPE html>
<html lang="en">
<head>
    <title>租赁信息管理</title>
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
<div id="dd"></div>
<script>
    var s = null;
    $(function () {
        selelctlist();
        function selelctlist(){
            //查询信息展示
            $('#dg').datagrid({
                url:'/con/selTravelsQuery',
                method:"GET",
                fitColumns:true,
                pagination:true,
                fit:true,
                pageNumber:1,
                pageSize:5,
                pageList:[2,5,12,20],
                columns:[[
                    {field:'comTravelsId',title:'游记评论Id',width:50},
                    {field:'travelsId',title:'游记主键',width:50},
                    {field:'comTravelsRelease',title:'发布时间',width:50},
                    {field:'comTravelsContent',title:'信息',width:50},
                    {field:'comTravelsYn',title:'状态',width:50},
                    {field:'comTravelsUpdate',title:'修改时间',width:50},
                    {field:'comTravelsCreate',title:'新增时间',width:50}
                ]],
                toolbar: [{
                    iconCls: 'icon-add',
                    text:'新增',
                    handler: function(){
                        openWindow();
                    }
                },'-',{
                    text:"审核",
                    iconCls: 'icon-no',
                    handler: function(){

                        s = $("#dg").datagrid("getSelected");
                        if(s==null){
                            $.messager.alert("提示","请选择一行进行审核");
                            return;
                        }
                        $.messager.confirm('删除提示', '确定不通过数据吗？', function(r){
                            if (r){
                                $.ajax({
                                    url:'/con/upTravelsYn',
                                    type:'put',
                                    data:{comTravelsId:s.comTravelsId},
                                    dataType:'json',
                                    success:function(data){
                                        $.messager.show({
                                            title:'提示',
                                            msg:data.msg,
                                            timeout:2000,
                                            showType:'fade'
                                        })
                                        $("#dg").datagrid('reload');
                                    }
                                });
                            }
                        });

                    }
                }]

            });
        }
    });

    //新增修改打开窗口
    function openWindow(title){
        $('#dd').dialog({
            title:title,
            width:400,
            height:200,
            closed:false,
            cache:false,
            href:'/con/goAdd',
            modal:true,
            buttons:[{
                text:'保存',
                handler:function(){
                    addStaff();
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#dd').dialog("close")
                }
            }]
        });
    }
    function  addStaff() {
        $.messager.progress();	// 显示进度条
        var s= $('#insertinto').val();
        console.log(s+"save");
        $('#insertinto').form('submit', {
            url: "/con/insertComment",
            onSubmit: function(){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                }
                return isValid;	// 返回false终止表单提交
            },
            success: function(){
                $.messager.progress('close');	// 如果提交成功则隐藏进度条
                $('#dg').datagrid('reload');
                $('#dd').dialog('close');
            }
        });
    }
</script>
</html>