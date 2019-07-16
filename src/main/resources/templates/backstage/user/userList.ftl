<html>
    <head>
        <title>用户查询</title>
    </head>
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" href="/commons/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/commons/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/commons/jquery-easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/commons/dialog/dialog-plus.js"></script>
<body>
<table id="wu" class="easyui-datagrid" data-options="fitColumns:true,fit:true,toolbar: '#yu',pagination:true,pageSize:3,pageList:[3,6,9,12,15],url:'/user/queryUserList'">
    <thead>
    <tr>
        <th data-options="field:'userId',width:50,sortable:true">用户编号</th>
        <th data-options="field:'userName',width:50">用户名</th>user
        <th data-options="field:'userPhone',width:50">手机号</th>
        <th data-options="field:'userDwell',width:50">居住城市</th>
        <th data-options="field:'userSex',width:50">性别</th>
        <th data-options="field:'userAge',width:50">年龄</th>
        <th data-options="field:'userBir',width:60,align:'right',sortable:true">出生日期</th>
        <th data-options="field:'comCreate',width:60,align:'right',sortable:true">注册时间</th>
    </tr>
    </thead>
<#--工具栏-->
    <div id="yu" style="padding:5px;height:auto">
        <div>
            用户编号: <input id="userId"   style="width:50px">
            用户名: <input id="userName"   style="width:50px">
            用户生日:<input id="userBir" name="endDate" class="easyui-datebox" style="width:120px">
            <a href="javascript:searchCondition();" class="easyui-linkbutton" iconCls="icon-search">查询</a>

        </div>
        <!-- 修改 -->
        <a href="javascript:toUpdate();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <!-- 删除-->
        <a href="javascript:deleteUser();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    </div>

    <script type="text/javascript">

        function deleteUser() {
            var row = $('#wu').datagrid('getSelected');
            if(row!=null){
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if(r){
                        $.ajax({
                            url:'/user/delete',
                            data:{"id":row.userId},
                            type:'get',
                            dataType:'text',
                            success:function(msg){
                                console.info(msg);
                                $.messager.show({
                                    title:'消息',
                                    msg:msg,
                                    timeout:2000,
                                    showType:'slide'
                                });

                                //刷新列表数据
                                $("#wu").datagrid("reload");
                            },
                            erroe:function(){
                                alert(error);
                            }
                        })
                    }
                });
                return;
            }else {
                $.messager.alert('警告','请选择一行进行删除');
            }
        }
</script>
</body>
</html>