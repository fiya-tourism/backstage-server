<form id="updateItemForm">
    <input name="itemId" type="hidden">
    <input name="iskuId" type="hidden">
    <table>
        <tr>
            <td align="right">商品名称:</td>
            <td><input name="itemName" size="10px" class="easyui-validatebox" type="text" data-options="required:true"></td>
            <td align="right">商品标题:</td>
            <td><input name="itemTitle" size="10px"></td>
            <td align="right">商品类型:</td>
            <td>
                <select name="itemType">
                    <option value="0">-请选择-</option>
                    <option value="1">农产品</option>
                    <option value="2">水果</option>
                    <option value="3">工艺品</option>
                    <option value="4">副产品</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">商品产地:</td>
            <td><input name="itemAddress" size="10px" id="d11"></td>
            <td align="right">销售价格:</td>
            <td><input name="iskuSalePrice" size="10px" class="easyui-validatebox" type="text" data-options="required:true"></td>
            <td align="right">是否上架:</td>
            <td>
                <label><input type="radio" name="itemIsActive" value="0">已上架</label>
                <label><input type="radio" name="itemIsActive" value="1">未上架</label>
            </td>
        </tr>
        <#--<tr>
            <td align="right">商品属性:</td>
            <td colspan="5">
                <table>
                    <tr>
                        <td>属性名</td>
                        <td>属性值(若选了前面的属性最少选两个值)</td>
                    </tr>
                    <tr>
                        <td><input name="attrAttrKey" size="5px"></td>
                        <td>
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                            <input name="attrAttrValue" size="5px">
                        </td>
                    </tr>
                    <tr>
                        <td><input name="attrAttrKey2" size="5px"></td>
                        <td>
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                            <input name="attrAttrValue2" size="5px">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>-->
        <tr>
            <td align="right">商品介绍:</td>
            <td colspan="5">
                <div id="div2"></div>
                <textarea id="text2" name="itemIntroduceValue" style="width:100%; height:200px;display:none"></textarea>
            </td>
        </tr>
    </table>
</form>

<script>
    //页面就绪之后查询详情
    $(function(){
        if(row!=null){
            $('#updateItemForm').form('load','/itemFeigh/getItem?itemId='+row.itemId)
        }
    })
</script>

<#--富文本编辑器-->
<script type="text/javascript" src="/commons/wangEditor.min.js"></script>
<script type="text/javascript">
    var $text2 = $('#text2')
    console.info($text2)
    var E = window.wangEditor
    var editor = new E('#div2')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text2.val(html)
    }
    editor.create();
    $.ajax({
        url:'/itemFeigh/getItem?itemId='+row.itemId,
        type:'get',
        async:false,
        dataType:'json',
        success:function(obj){
            //给编辑器回显信息
            editor.txt.html(obj.itemIntroduceValue);
        }
    })
    // 初始化 textarea 的值
    $text2.val(editor.txt.html())

</script>
