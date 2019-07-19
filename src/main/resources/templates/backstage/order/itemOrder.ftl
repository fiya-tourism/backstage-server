<html>
<head>
    <title>订单信息管理</title>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/commons/dialog/dialog-plus.js"></script>
</head>
<body>

<table id="dg1"></table>
<script>
    var s = null;
    $(function () {
        selelctlist();
        function selelctlist(){
            //查询信息展示
            $('#dg1').datagrid({
                url:'/BackController/getItemList',
                method:"GET",
                fitColumns:true,
                pagination:true,
                fit:true,
                pageNumber:1,
                pageSize:10,
                pageList:[10,30,40,50],
                columns:[[
                    {field:'orderConId',title:'订单编号',width:32},
                    {field:'orderCreateDate',title:'订单生成时间',width:30},
                    {field:'orderChildShop',title:'支付时间',width:30},
                    {field:'orderChildTradeName',title:'商品名称',width:25},
                    {field:'orderTotalPrices',title:'订单金额',width:25},
                    {field:'orderChildPrice',title:'商品单价',width:17},
                    {field:'orederCount',title:'商品数量',width:17},
                    {field:'orderChildItemType',title:'商品类型',width:20},
                    {field:'orderChildItemAddress',title:'商品产地',width:30},
                    {field:'orderChildItemAttrkey',title:'商品属性',width:25},
                    {field:'orderChildItemAttrvalue',title:'商品属性值',width:25},
                    {field:'orderRemark',title:'备注',width:25},
                    {field:'orderTradeStatus',title:'交易状态',width:20}
                ]],
                toolbar: [{
                    text:"删除订单",
                    iconCls: 'icon-no',
                    handler: function(){
                        s =$("#dg1").datagrid("getSelected");
                        if (s==null){
                            return alert("请选择要删除订单！！");
                        }
                        $.ajax({
                            type:"GET",
                            url:"/BackController/deleteOrder",
                            data:{"id":s.orderConId},
                            dataType:"json",
                            success:function () {

                            }
                        });
                        $("#dg1").datagrid('reload');
                    }
                },'-',{
                    text:"订单号查询：<input type='text' id='likeId'/>",

                },'-',{
                    iconCls: 'icon-search',
                    text:"搜索",
                    handler: function(){
                        $('#dg1').datagrid('load',{
                            orderConId:$("#likeId").val(),
                        });
                    }
                }]


            });
        }
    });

</script>
</body>
</html>