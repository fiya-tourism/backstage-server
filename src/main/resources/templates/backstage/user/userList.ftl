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
<table id="wu" class="easyui-datagrid" data-options="fitColumns:true,fit:true,pagePosition:'top',toolbar: '#yu',pagination:true,pageSize:3,pageList:[3,6,9,12,15],url:'/user/queryUserList'">
    <thead>
    <tr>
        <th data-options="field:'userId',width:50,sortable:true">用户编号</th>
        <th data-options="field:'userName',width:50">用户名</th>user
        <th data-options="field:'userPhone',width:50">手机号</th>
        <th data-options="field:'userEmail',width:50">邮箱</th>
        <th data-options="field:'userDwell',width:50">居住城市</th>
        <th data-options="field:'userSex',width:50,formatter:sexFmt">性别</th>
        <th data-options="field:'userAge',width:50">年龄</th>
        <th data-options="field:'userBir',width:60,align:'right',sortable:true">出生日期</th>
        <th data-options="field:'comCreate',width:60,align:'right',sortable:true">注册时间</th>
        <th data-options="field:'comUpdate',width:60,align:'right',sortable:true">修改时间</th>
    </tr>
    </thead>
<#--工具栏-->
    <div id="yu" style="padding:5px;height:auto">
        <div>
            用户编号: <input id="userId"  name="userId" style="width:50px">
            用户名: <input id="userName"  name="userName" style="width:100px">
            用户生日:<input id="userBir" name="userBir" class="easyui-datebox" style="width:120px">
            <a href="javascript:searchCondition();" class="easyui-linkbutton" iconCls="icon-search">查询</a>

        </div>
        <!-- 修改 -->
        <a href="javascript:toUpdate();" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
        <!-- 删除-->
        <a href="javascript:deleteUser();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
        <!-- 添加 -->
        <a href="javascript:toAdd();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>

    <!-- 添加弹框 -->
    <div id="toAdd" class="easyui-dialog" title="添加" style="width:800px;height:400px;"
         data-options="buttons:'#addInfo',iconCls:'icon-save',resizable:true,modal:true,closed:true,href:'/user/toAdd'">
    </div>

    <!-- 添加弹框按钮-->
    <div id="addInfo">
        <a href="javascript:addInfo()" class="easyui-linkbutton">添加</a>
        <a href="javascript:closeAdd();" class="easyui-linkbutton">关闭</a>
    </div>

    <!-- 修改弹框 -->
    <div id="up">
    </div>

    <script type="text/javascript">


        /*
*   根据Id回显信息
*
* */
        function toUpdate() {
            //获取选中的行
            var row = $("#wu").datagrid('getSelected');
            console.log(row);
            if(row==null){
                $.messager.alert('警告','请选择一条修改数据')
                return;
            }
            rowFirst = row;

            $.ajax({

                type:"POST",
                url:"/user/toUpdate",
                data:{"userId":row.userId},
                dataType:"json",
                success:function (user) {
                    console.log(user);
                    userFirst   = user;

                },
                error:function () {
                    alert(1);
                }
            });

            $('#up').dialog({
                title: '修改用户信息',
                width: 700,
                height: 330,
                closed: false,
                cache: false,
                href: '/user/toUpdate1',
                modal: true,
                buttons:[{
                    text:'修改',
                    handler:function(){
                        //保存报案信息到数据库
                        updateStuById();
                    }
                },{
                    text:'关闭',
                    handler:function(){
                        console.log('点击关闭');
                        $('#up').dialog("close");
                    }
                }]
            });
        }

        //修改用户信息
        function  updateStuById() {
            $.messager.progress();
            $('#update-form').form('submit', {
                url:"/user/updateInfo",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    if (!isValid){
                        $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                    }
                    return isValid;                    	// 返回false终止表单提交
                },
                success: function(msg){
                    $.messager.progress('close');	// 如果提交成功则隐藏进度条

                    $.messager.show({
                        title:'消息',
                        msg:msg,
                        timeout:2000,
                        showType:'slide'
                    });


                    //关闭dialog
                    $('#up').dialog('close');
                    //刷新列表数据
                    $("#wu").datagrid("reload");
                }
            });
        }


        /* 打开弹框 */
        function toAdd(){
            /* 打开界面 */
            $("#toAdd").dialog('open');
        }

        function addInfo(){
            $.ajax({
                type:'post',
                async:false,
                url:'/user/add',
                data:$("#insert_form").serialize()
            })
            /* 使用form组件 提供的方法进行提交 */
            $("#insert_form").form('submit',{
                onSubmit:function(){
                    var isValid = $(this).form('validate');
                    return isValid;;
                },
                success:function(data){
                    /* 关闭dialog */
                    $("#wu").datagrid("reload");
                    $("#toAdd").dialog("close");
                }
            })

            /* 关闭dialog */
            $("#wu").datagrid("reload");
            $("#toAdd").dialog("close");
        }


        function closeAdd(){
            $("#toAdd").dialog("close");
            $("#insert_form").form("clear");
        }
        /*逻辑删除*/
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

        function sexFmt(value,rows,index){
            if(value==1){
                return "男";
            }
            if(value==2){
                return "女";
            }
        }

        /* 条件查询 */
        function searchCondition(){
            $("#wu").datagrid('load',{
                userId:$("#userId").val(),
                userName:$("#userName").val(),
                userBir:$("input[name='userBir']").val()

            });
        }

</script>
</body>
</html>