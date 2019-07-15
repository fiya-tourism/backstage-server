<html>
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
                url:'/getOrderList',
                method:"GET",
                fitColumns:true,
                pagination:true,
                fit:true,
                pageNumber:1,
                pageSize:10,
                pageList:[2,10,30,40,50],
                columns:[[
                    {field:'orderConId',title:'订单编号',width:50},
                    {field:'orderChildShop',title:'支付时间',width:50},
                    {field:'orderTotalPrices',title:'总价',width:50},
                    {field:'orderChildAmout',title:'单项总金额',width:50},
                    {field:'orederCount',title:'数量',width:50},
                    {field:'orderSpotsStatus',title:'交易状态',width:50},
                    {field:'orderRemark',title:'备注',width:50}
                ]],
                toolbar: [{
                    text:"修改出租单",
                    iconCls: 'icon-edit',
                    handler: function(){
                        s = $("#dg").datagrid('getSelected');
                        if (s==null){
                            return alert("请选择要编辑的出租单！！");
                        }
                        $('#xuzhen').dialog({
                            title: '修改出租单',
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

                    }
                },'-',{
                    text:"删除出租单",
                    iconCls: 'icon-no',
                    handler: function(){
                        s =$("#dg").datagrid("getSelected");
                        if (s==null){
                            return alert("请选择要删除出租单！！");
                        }
                        $.ajax({
                            type:"GET",
                            url:"/deleteOrder",
                            data:{"id":s.orderConId},
                            dataType:"json",
                            success:function () {

                            }
                        });
                        $("#dg").datagrid('reload');
                    }
                },'-',{
                    text:"房源编号：<input type='text' id='likeId'/>",

                },'-',{
                    iconCls: 'icon-search',
                    text:"搜索",
                    handler: function(){
                        var likeId= $("#likeId").val();
                        $('#dg').datagrid('load',{
                            likeId: likeId
                        });
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
</body>
</html>