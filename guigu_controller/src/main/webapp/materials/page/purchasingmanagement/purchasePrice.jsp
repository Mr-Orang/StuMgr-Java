<!-- 采购选价 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $('#purcjasePriceData').datagrid({
        title: '供应商采购单报价列表（采购单在2个工作日内还未报价完毕的，则取消该采购单的报价请求）',
        //分页工具栏
        pagination: true,
        //选择分页大小
        pageList: [5, 10],
        //初始化分页大小
        pageSize: 5,
        //初始化页码
        pageNumber: 1,
        // fit:true,
        fitColumns: true,
        rownumbers: true,
        singleSelect: true,
        striped: true,
        url: '${pageContext.request.contextPath}/purchasePriceController/querySupplierPurchaseOrderQuotation',
        columns: [[
            {field: 'pceId', title: '采购单编号', width: 100},
            {field: 'applyEmpNo', title: '采购人姓名', width: 100},
            {field: 'pceDate', title: '采购单填写日期', width: 100},
            {field: 'checkEmpNo', title: '审核人姓名', width: 100},
            {field: 'quotationStatus', title: '报价状态', width: 100}
        ]],
        toolbar: [{
            iconCls: 'icon-main_examine',
            text: '查看供应商物资报价情况',
            handler: function () {
                var getSelectionsyes = $('#purcjasePriceData').datagrid('getSelections');
                if (getSelectionsyes.length == 0) {
                    $.messager.alert('提示', '您还未选中数行！', 'info');
                    return;
                }
                /**
                 * 验证该采购单中的每个物资是否都报价完毕
                 */
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath}/purchasePriceController/queryPceGoods',
                    data: {
                        id: getSelectionsyes[0].pceId,
                    },
                    success: function (msg) {
                        if (msg == "ok") {
                            $('#mainDataPurchaseroce').css("display", "none");
                            $('#infoMatrohkk').css("display", "block");
                            $('#hjyuxx').datagrid({
                                title: '各个供应商对物资的报价情况',
                                fitColumns: true,
                                fit: true,
                                singleSelect: true,
                                striped: true,
                                url: '${pageContext.request.contextPath}/purchasePriceController/checkTheMaterialsInTheOrder',
                                columns: [[
                                    {field: 'goodsId', title: '物资编号', width: 100},
                                    {field: 'brand', title: '物资品牌', width: 100},
                                    {field: 'company', title: '物资单位', width: 100},
                                    {field: 'description', title: '物资说明', width: 100},
                                    {field: 'typeName', title: '物资类型', width: 100},
                                    {field: 'accountNum', title: '该物资采购数量', width: 100},
                                    {
                                        field: 'PriceSelectionStatus',
                                        title: '选价状态',
                                        width: 100,
                                        formatter: function (value, row, index) {
                                            return "<span id='status_" + row.goodsId + "'>未选价</span>";
                                        }
                                    },
                                ]],
                                queryParams: {
                                    id: getSelectionsyes[0].pceId,
                                },
                                toolbar: [{
                                    text: '提交选价',
                                    iconCls: 'icon-main_prices',
                                    handler: function () {
                                        var getRowsye = $('#hjyuxx').datagrid("getRows");
                                        for (var i = 0; i < getRowsye.length; i++) {
                                            var infos = '#status_' + getRowsye[i].goodsId;
                                            if ($(infos).text().trim() != "选价完成") {
                                                $.messager.alert('提示', '选价还未完成！', 'info');
                                                return;
                                            }
                                        }
                                        /**
                                         * 采购单编号
                                         * 供货商编号
                                         * 物资编号
                                         * 供货数量
                                         * 供货价
                                         */
                                        var ArrayOptions = new Array();
                                        for (var i = 0; i < getRowsye.length; i++) {
                                            //获取物资中供应商集合
                                            var goodsInfo = $('input[name=na_' + getRowsye[i].goodsId + ']');
                                            for (var j = 0; j < goodsInfo.length; j++) {
                                                if (goodsInfo[j].checked) {
                                                    //物资编号
                                                    //供应商编号
                                                    var sId = "#sId_" + getRowsye[i].goodsId + "_" + j;
                                                    //供应商报价
                                                    var sPrice = "#sPrice_" + getRowsye[i].goodsId + "_" + j;
                                                    //供应量
                                                    var ui = "#ui_" + getRowsye[i].goodsId + "_" + j;
                                                    var dataInfoStr = "goodsId=" + getRowsye[i].goodsId + ":" + "sId=" + $(sId).text().trim() + ":" + "sPrice=" + $(sPrice).text().trim() + ":" + "ui=" + $(ui).val();
                                                    ArrayOptions.push(dataInfoStr);
                                                }
                                            }
                                        }
                                        $.messager.confirm('提示', '您确定需要提交该采购单的选价吗？', function (r) {
                                            if (r) {
                                                $.ajax({
                                                    type: 'POST',
                                                    url: '${pageContext.request.contextPath}/purchasePriceController/submissionOfMaterialSelectionPrice',
                                                    traditional: true,
                                                    data: {
                                                        pceId: getSelectionsyes[0].pceId,
                                                        ArrayOptions: ArrayOptions,
                                                    },
                                                    success: function (msg) {
                                                        if (msg == "yes") {
                                                            $.messager.show({
                                                                title: '提示',
                                                                msg: '采购选价成功',
                                                                timeout: 3000,
                                                                showType: 'slide'
                                                            });
                                                            $('#purcjasePriceData').datagrid("reload");
                                                            $('#mainDataPurchaseroce').css("display", "block");
                                                            $('#infoMatrohkk').css("display", "none");
                                                            return;
                                                        }
                                                        $.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
                                                    }
                                                });
                                            }
                                        });
                                    }
                                }],
                                view: detailview,
                                detailFormatter: function (rowIndex, rowData) {
                                    var info = "";
                                    for (var i = 0; i < rowData.list.length; i++) {
                                        info += "<p><input type='hidden' id='" + rowData.goodsId + "' value='" + rowData.accountNum + "'/>&nbsp;&nbsp;" +
                                            "<input type='checkbox' onclick='oks(this);' name='na_" + rowData.goodsId + "' id='ch_" + rowData.goodsId + "_" + i + "' />&nbsp;&nbsp;" +
                                            "供应商编号:<span id='sId_" + rowData.goodsId + "_" + i + "'>" + rowData.list[i].providerId + "</span>&nbsp;&nbsp;" +
                                            "供应商名称:<span id='sName_" + rowData.goodsId + "_" + i + "'>" + rowData.list[i].proName + "<span>&nbsp;&nbsp;" +
                                            "供应商报价:<span style='font-family:黑体;color: red' id='sPrice_" + rowData.goodsId + "_" + i + "'>" + rowData.list[i].price + "</span>&nbsp;&nbsp;" +
                                            "<div id='cd_" + rowData.goodsId + "_" + i + "' style='display: none'>&nbsp;&nbsp;" +
                                            "供应量：<input type='text' onblur='CalculationOfSupplyQuantity(this);' name='names_" + rowData.goodsId + "' id='ui_" + rowData.goodsId + "_" + i + "' value='0'/>" +
                                            "</div></p>";
                                    }
                                   	info = "<div style='height:150px;'>"+info+"</div>";
                                    return info;
                                },
                            });
                            return;
                        }
                        $.messager.alert('提示', '物资供应商还未全部报价，请等待供应商报价完毕！', 'info');
                        return;
                    }
                });
            }
        }],
    });

    function oks(obj) {
        var id = $(obj).attr("id");
        var idgo = "#cd_" + id.substr("3");
        //获取input输入框对象
        var inputgo = "#ui_" + id.substr("3");
        if (obj.checked) {
            $(idgo).css("display", "block");
            //初始化为1
            id = "#ui_" + id.substr("3");
            $(id).val(1);
        } else {
            $(idgo).css("display", "none");
            //初始化为0
            id = "#ui_" + id.substr("3");
            $(id).val(0);
        }
        // CalculationOfSupplyQuantity(obj);
        //传递点击同行的文本框对象
        var inputObj = $(inputgo);
        CalculationOfSupplyQuantity(inputObj, "yes");
    }

    function CalculationOfSupplyQuantity(obj, info) {
        if (arguments.length == 1) {
            //判断是否为数字
            if ($(obj).val().trim() == 0) {
                $.messager.alert('警告', '最小值为1！', 'info');
                $(obj).val(1);
                return;
            }
        }
        //-----------------------------------------------
        var reg = new RegExp("^[0-9]*$");
        if (!reg.test($(obj).val().trim())) {
            $.messager.alert('警告', '您输入的不是合法数字！', 'info');
            $(obj).val(1);
            return;
        }
        //-----------------------------------------------
        //获取name值AE
        var nameValues = $(obj).attr("name");
        var ArrayInput = $('input[name=' + nameValues + ']');
        var value = 0;
        for (var i = 0; i < ArrayInput.length; i++) {
            value += parseInt($(ArrayInput[i]).val());
        }
        //获取采购数量值
        var pceId = "#" + nameValues.substr("6");
        var pceNum = $(pceId).val();
        var info = "#status_" + nameValues.substr("6");
        if (value == 0) {
            //提示大于
            $(info).css("color", "black");
            $(info).text("未选价");
            return;
        }
        if (value > pceNum) {
            //提示大于
            $(info).css("color", "red");
            $(info).text("供货量超标，请修改");
            return;
        }
        if (value == pceNum) {
            //选价完成
            $(info).css("color", "green");
            $(info).text("选价完成");
            return;
        }
        if (value < pceNum) {
            //请继续分配
            $(info).css("color", "green");
            $(info).text("请继续分配");
            return;
        }
    }
</script>
<div id="mainDataPurchaseroce" style="display: block">
    <table id="purcjasePriceData"></table>
</div>
<div id="infoMatrohkk" style="display: none;height: 500px;">
    <table id="hjyuxx"></table>
</div>