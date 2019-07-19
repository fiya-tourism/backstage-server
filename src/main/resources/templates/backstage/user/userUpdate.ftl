<html>
    <head>
        <title></title>
    </head>
    <body>
    <center>
        <form id="update-form">
            <input type="hidden" name="userId"/>
            用户名称:<input name="userName" class="easyui-validatebox" data-options="" /><br>
            性别:<input type="radio" value="1" name="userSex"/>男
                 <input type="radio" value="2" name="userSex"/>女<br>
            年龄:<input name="userAge" class="easyui-validatebox" data-options=""/><br>
            用户手机号:<input class="easyui-validatebox" type="text" name="userPhone" data-options=""/><br>
            身份证号:<input class="easyui-validatebox" type="text" name="userIdentity" data-options=""/><br>
            居住城市:<input name="userDwell" class="easyui-validatebox" data-options=""/><br>
                出生日期:<input name="userBir" class="easyui-datebox" data-options=""/><br>
            邮箱:<input name="userEmail" class="easyui-validatebox" data-options=""/><br>
            个性签名:<input name="userSignature" class="easyui-validatebox" data-options=""/><br>

        </form>

        <script type="text/javascript">
            $(function () {
                if (rowFirst != null && rowFirst != 'undefined'){
                    $("#update-form").form('load','/user/toUpdate?userId='+rowFirst.userId)
                }
            })
        </script>

    </body>
</html>