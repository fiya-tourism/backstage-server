<#--jquery-->
<script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
<#--easyui-->
<script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">

<table id="itemDg"></table>
<div id="itemDd">Dialog Content.</div>

<script>


    var row = null;
    //列表展示
    $('#itemDg').datagrid({
        url:'/itemFeigh/queryList',
        pagination:true,
        fit:true,
        fitColumns:true,
        singleSelect:true,
        pagePosition:'both',
        columns:[[
            {field:'itemId',title:'商品主键',width:100,sortable:true},
            {field:'pictureUrl',title:'图片',width:100,
                formatter: function(value){
                    if (value){
                        return "<img src='${request.contextPath}"+value+"' width='30px' height='30px'/>";
                    }
                }
            },
            {field:'itemName',title:'商品名称',width:100},
            {field:'itemType',title:'类型',width:100,
                formatter: function(value){
                    if (value==1){
                        return "农产品";
                    } else if (value==2){
                        return "水果";
                    } else if (value==3){
                        return "工艺品";
                    } else if (value==4){
                        return "副产品";
                    }
                }
            },
            {field:'itemAddress',title:'产地',width:100},
            {field:'itemRelease',title:'发布时间',width:100,sortable:true},
            {field:'itemIsActive',title:'是否上架',width:100,
                formatter: function(value){
                    if (value==0){
                        return "已上架";
                    } else if (value==1){
                        return "未上架";
                    }
                }
            },
            {field:'itemSkuList',title:'销售价格',width:100,
                formatter: function(value){
                    var show = "";
                    $.each(value,function(i){
                        show = value[i].iskuSalePrice+"元";
                    });
                    return show;
                }
            }
        ]],
        toolbar: [{
            iconCls: 'icon-edit',
            text:'修改',
            handler: function(){
                row = $('#itemDg').datagrid('getSelected');
                if(row==null){
                    $.messager.alert('提示','没有选中要修改的数据');
                }else{
                    openUpdate(row.itemId);  //打开修改页面
                }
            }
        },'-',{
            iconCls: 'icon-cancel',
            text:'删除',
            handler: function(){
                row = $('#itemDg').datagrid('getSelected');
                if(row==null){
                    $.messager.alert('提示','没有选中要删除的数据');
                }else{
                    deleteData(row.itemId);  //删除
                }
            }
        },'-',{
            text:'类型: <label><input type="radio" name="type" value="1"/>农产品</label>' +
                        '<label><input type="radio" name="type" value="2"/>水果</label>' +
                        '<label><input type="radio" name="type" value="3"/>工艺品</label>' +
                        '<label><input type="radio" name="type" value="4"/>副产品</label>',
            handler: function(){}
        },'-',{
            text:'是否上架:<label><input type="radio" name="active" value="0"/>已上架</label>' +
                            '<label><input type="radio" name="active" value="1"/>未上架<label>',
            handler: function(){}
        },'-',{
            text:'产地:<input id="address"/>',
            handler: function(){}
        },'-',{
            text:'发布时间:<input type="date" id="timeB"/>-<input type="date" id="timeE"/>',
            handler: function(){}
        },'-',{
            iconCls: 'icon-search',
            text:'搜索',
            handler: function(){
                var type = $("input[name='type']:checked");
                var active = $("input[name='active']:checked");
                var address = $("#address");
                var timeB = $("#timeB");
                var timeE = $("#timeE");
                $('#itemDg').datagrid('reload',{
                    itemType:type.val(),
                    itemIsActive:active.val(),
                    itemAddress:address.val(),
                    timeB:timeB.val(),
                    timeE:timeE.val()
                })
            }
        }]
    });

    //打开修改页面
    function openUpdate(id){
        $('#itemDd').dialog({
            title: '修改信息',
            width: 900,
            height: 600,
            closed: false,
            cache: false,
            href: '/itemFeigh/toUpdate',
            modal: true,
            buttons:[{
                text:'修改',
                handler:function(){
                    updateItem(); //修改商品
                }
            },{
                text:'关闭',
                handler:function(){
                    $('#itemDd').dialog('close'); //关闭弹框
                }
            }]
        });
    }

    //修改商品
    function updateItem(){
        $.messager.progress();	// 显示进度条
        $('#updateItemForm').form('submit', {
            url: "/itemFeigh/update",
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
                $('#itemDg').datagrid('reload'); //刷新列表展示
                $('#itemDd').dialog('close'); //关闭弹框
            }
        });
    };

    //删除
    function deleteData(itemId){
        $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
            if (r){
                $.ajax({
                    url:'/itemFeigh/delete/'+itemId,
                    type:'delete',
                    dataType:'json',
                    success:function(data){
                        $.messager.show({
                            title:'我的消息',
                            msg:data.msg,
                            timeout:5000,
                            showType:'slide'
                        });
                        $('#itemDg').datagrid('reload'); //刷新列表展示
                        $('#itemDd').dialog('close'); //关闭弹框
                    }
                })
            }
        });
    }
</script>
