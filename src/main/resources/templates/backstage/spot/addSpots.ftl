<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form id="ff" method="post" type="">
    <input  type="hidden" name="spotsId" data-options="required:true" />
    <div>
        <label for="name">景点名称:</label>
        <input class="easyui-validatebox" type="text" name="spotsName" data-options="required:true" />
    </div>
    <div>
        <label for="name">景区类型:</label>
        <input  type="text" name="spotsType" data-options="required:true" />
    </div>
    <div>
        <label for="name">景点介绍:</label>
        <input  type="text" name="conentisert"/>
    </div>
    <div>
        <label for="name">景点地址:</label>
        <input  type="text" name="spotsAddress"/>
    </div>
    <div>
        <label fot="name">门票价格:</label>
        <input  type="text" name="spotsPrice" data-options="required:true" />
    </div>
    <div>
        <label fot="name">咨询电话:</label>
        <input  type="text" name="spotsPhone" data-options="required:true" />
    </div>
    <div>
        <label fot="name">开放时间:</label>
        <input class= "easyui-datebox" type="text" name="spotsOpenTime"   />
    </div>
    <div>
        <label fot="name">景点门票库存:</label>
        <input  type="text" name="spotsRepertory" data-options="required:true" />
    </div>
    <div>
        <label fot="name">景点活动:</label>
        <input  type="text" name="spotsActivity" />
    </div>
    <div>
        <label fot="name">集合地点:</label>
        <input  type="text" name="spotsVenue" data-options="required:true" />
    </div>
    <div>
        <label fot="name">出发时间:</label>
        <input class="easyui-datetimebox" type="text" name="spotsGotime" data-options="required:true" />
    </div>
    <div>
        <label fot="name">状态:</label>
        <select id="cc" class="easyui-combobox" name="spotsYn" style="width:200px;">
            <option value="0">展示</option>
            <option value="1" selected>不展示</option>
        </select>
    </div>
    <div id="buttonId"></div>
</form>
<script>
    $(function () {
        if (s !=null){
            $("#ff").form("load",s);
            // $.ajax({
            //     type:"GET",
            //     url:"/spotController/spotById",
            //     data:{"Id":s.spotsId},
            //     async:false,
            //     success:function (date) {
            //         $("#ff").form(data);
            //     },
            //     error:function () {
            //         alert("错误！！！");
            //     }
            // })
        }else {
            $("#buttonId").after("<input type='submit'>")
        }
    })
</script>
</body>
</html>