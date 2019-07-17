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
                    {field:'orderConId',title:'订单编号',width:25},
                    {field:'orderCreateDate',title:'订单生成时间',width:25},
                    {field:'orderChildShop',title:'支付时间',width:25},
                    {field:'orderTotalPrices',title:'订单金额',width:25},
                    {field:'orderChildTradeName',title:'商品名称',width:25},
                    {field:'orderChildPrice',title:'商品单价',width:25},
                    {field:'orederCount',title:'商品数量',width:25},
                    {field:'orderRemark',title:'备注',width:25},
                    {field:'orderSpotsStatus',title:'交易状态',width:25}
                ]],
                toolbar: [{
                    text:"删除订单",
                    iconCls: 'icon-no',
                    handler: function(){
                        s =$("#dg").datagrid("getSelected");
                        if (s==null){
                            return alert("请选择要删除订单！！");
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
                    text:"订单号查询：<input type='text' id='likeId'/>",

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

</script>
</body>
</html>