<#--jquery-->
<script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
<#--easyui-->
<script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">

<table id="itemDg"></table>

<script>
    $('#itemDg').datagrid({
        url:'/itemFeigh/queryList',
        pagination:true,
        fit:true,
        fitColumns:true,
        pagePosition:'top',
        columns:[[
            {field:'itemId',title:'商品主键',width:100},
            {field:'itemName',title:'商品名称',width:100},
            {field:'itemType',title:'类型',width:100,
                formatter: function(value){
                    if (value==1){
                        return "农产品";
                    } else if (value==2){
                        return "水果";
                    } else if (value==3){
                        return "工艺品";
                    }
                }
            },
            {field:'itemAddress',title:'产地',width:100},
            {field:'itemRelease',title:'发布时间',width:100},
            {field:'itemIsActive',title:'是否上架',width:100,
                formatter: function(value){
                    if (value==1){
                        return "已上架";
                    } else if (value==2){
                        return "未上架";
                    }
                }
            }
        ]]
    });
</script>
