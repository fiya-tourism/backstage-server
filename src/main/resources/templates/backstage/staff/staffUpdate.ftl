<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改页面</title>
</head>
<body>
<script>
    $(function () {
        console.log(rowFirst);
        if(rowFirst != null && rowFirst != 'undefined'){
            $('#ffu').form('load','/staff/updateStaffById?staffId='+rowFirst.staffId);
        }
    })
</script>
<center style="margin-top:20px">
    <form id="ffu" method="post">
        <input type="hidden" name="staffId" >
        <div>
            <label for="staffName">姓名</label>
            <input class="easyui-validatebox" type="" name="staffName"/>
        </div>
        <div>
            <label for="staffSex">性别</label>
            <input class="easyui-numberspinner" type="radio" name="staffSex" value="1"/>男
            <input class="easyui-numberspinner" type="radio" name="staffSex" value="2"/>女
        </div>
        <div>
            <label for="staffPhone">联系方式</label>
            <input class="easyui-numberspinner" type="text" name="staffPhone"/>
        </div>
        <div>
            <label for="staffDate">加入时间</label>
            <input class="easyui-datebox" type="text" name="staffDate"/>
        </div>
    </form>
</center>

</body>
</html>