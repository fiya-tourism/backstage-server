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
<script>
    var s = null;
    $(function () {
        selelctlist();
        function selelctlist(){
            //查询信息展示
            $('#dg').datagrid({
                url:'/tr/selTrael',
                method:"GET",
                fitColumns:true,
                pagination:true,
                fit:true,
                pageNumber:1,
                pageSize:5,
                pageList:[2,5,12,20],
                columns:[[
                    {field:'travelsId',title:'订单编号',width:50},
                    {field:'travelsUserId',title:'用户Id',width:50},
                    {field:'travelsContentId',title:'合并展示',width:50},
                    {field:'travelsTitle',title:'标题',width:50},
                    {field:'travelsRelease',title:'发布时间',width:50},
                    {field:'travelsPicture',title:'头像',width:50},
                    {field:'travelsText',title:'主题',width:50},
                    {field:'travelsYn',title:'状态',width:50},
                    {field:'travelsUpdate',title:'修改时间',width:50},
                    {field:'travelsCreate',title:'新增时间',width:50}
                ]],
                toolbar: [{
                    /*text:"查看详情",
                    iconCls: 'icon-edit',
                    handler: function(){
                        s = $("#dg").datagrid('getSelected');
                        if (s==null){
                            return alert("请选择要编辑的出租单！！");
                        }
                        $('#xuzhen').dialog({
                            title: '不通过',
                            width: 470,
                            height: 280,
                            href: '/housrent/toupdate',
                            modal: true,
                            buttons:[{
                                text:'保存',
                                handler:function(){
                                    updates()
                                    $("#dg").datagrid('reload');
                                }
                            },{
                                text:'关闭',
                                handler:function(){
                                    $("#xuzhen").dialog('close');
                                }
                            }]
                        });

                    }*/
                },'-',{
                    text:"bu通过",
                    iconCls: 'icon-no',
                    handler: function(){

                        s = $("#dg").datagrid("getSelected");
                        if(s==null){
                            $.messager.alert("提示","请选择一行进行删除");
                            return;
                        }
                        $.messager.confirm('删除提示', '你确定要删除数据吗？', function(r){
                            if (r){
                                $.ajax({
                                    url:'/tr/delTravel',
                                    type:'put',
                                    data:{travelsId:s.travelsId},
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
                },'-',{
                    iconCls: 'icon-search',
                    text:"搜索",
                    handler: function(){

                    }
                }]

            });
        }
    });
    function updates() {
        $.messager.progress();	// 显示进度条
        $('#ff').form('submit', {
            url: "/housrent/leaseUpdate",
            onSubmit: function(data){
                var isValid = $(this).form('validate');
                if (!isValid){
                    $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                }
                return isValid;	// 返回false终止表单提交
            },
            success: function(){
                alert("提交成功！！");
                $.messager.progress('close');	// 如果提交成功则隐藏进度条
                $("#xuzhen").dialog('close');
                $("#dg").datagrid('reload');
            }
        });

    }

</script>
</html>