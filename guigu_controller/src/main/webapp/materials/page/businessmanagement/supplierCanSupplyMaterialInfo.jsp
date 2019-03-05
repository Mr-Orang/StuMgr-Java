<!-- 供应商可供物资配置 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#materialInformation').datagrid({
            title: '供应商:${sessionScope.provider.proName}，可供物资列表',
            fitColumns: true,
            striped: true,
            singleSelect: true,
            pagination: true,
            pageList: [5, 10],
            pageSize: 5,
            pageNumber: 1,
            url: '${pageContext.request.contextPath}/supplyOfMaterialsController/queryGoodsMaterials',
            columns: [[
                {field: 'goodsId', title: '物资编号', width: 100},
                {field: 'brand', title: '物资品牌', width: 100},
                {field: 'description', title: '物资说明', width: 100},
                {field: 'typeName', title: '物资类型', width: 100},
            ]],
            //-------------------------------------------------------------------------------------------
            toolbar: [{
                iconCls: 'icon-main_add',
                text: '添加可供应物资',
                handler: function () {
                    //把第一div隐藏
                    $('#maingosone').css('display', "none");
                    //显示第二div
                    $('#quoteConfirmationWindow').css('display', 'block');
                    //加载数据表格
                    $('#quoteMaterInfo').datagrid({
                        title: '添加可供应物资',
                        fitColumns: true,
                        striped: true,
                        columns: [[
                            {field: 'goodsId', title: '物资编号', width: 100},
                            {field: 'brand', title: '物资品牌', width: 100},
                            {field: 'description', title: '物资说明', width: 100},
                            {field: 'typeName', title: '物资类型', width: 100},
                        ]],
                        toolbar: [{
                            iconCls: 'icon-add',
                            text: '添加可供物资',
                            handler: function () {
                                var infos =
                                    '<div id="TheThirdSelectionMaterialDrame">\n' +
                                    '    <table id="goodsMaterlgos">\n' +
                                    '    </table>\n' +
                                    '</div>';
                                $(infos).window({
                                    title: '添加物资',
                                    collapsible: false,
                                    minimizable: false,
                                    maximizable: false,
                                    width: 600,
                                    height: 350,
                                    modal: true,
                                    onClose: function () {
                                        $(this).window("destroy");
                                    }
                                });
                                $('#goodsMaterlgos').datagrid({
                                    title: '点击数据行添加可供物资',
                                    fitColumns: true,
                                    striped: true,
                                    singleSelect: true,
                                    fit:true,
                                    pagination: true,
                                    pageList: [5, 10],
                                    pageSize: 5,
                                    pageNumber: 1,
                                    url: '${pageContext.request.contextPath}/supplyOfMaterialsController/queryMaterials',
                                    columns: [[
                                        {field: 'goodsId', title: '物资编号', width: 100},
                                        {field: 'brand', title: '物资品牌', width: 100},
                                        {field: 'description', title: '物资说明', width: 100},
                                        {field: 'typeName', title: '物资类型', width: 100},
                                    ]],
                                    onClickRow: function (rowIndex, rowData) {
                                        //判断该物资是否已经添加
                                        var getRows = $('#quoteMaterInfo').datagrid("getRows");
                                        for (var i = 0; i < getRows.length; i++) {
                                            if (getRows[i].goodsId == rowData.goodsId) {
                                                $.messager.alert('提示', '您已经添加过该物资了！', 'info');
                                                return;
                                            }
                                        }
                                        $('#quoteMaterInfo').datagrid('appendRow', {
                                            goodsId: rowData.goodsId,
                                            brand: rowData.brand,
                                            description: rowData.description,
                                            typeName: rowData.typeName
                                        });
                                    }
                                });
                            }
                        }, {
                            iconCls: 'icon-remove',
                            text: '删除可供物资',
                            handler: function () {
                                //获取选中的数据
                                var getSelectionstes = $('#quoteMaterInfo').datagrid('getSelections');
                                if (getSelectionstes.length != 0) {
                                    for (var i = 0; i < getSelectionstes.length; i++) {
                                        var index = $('#quoteMaterInfo').datagrid('getRowIndex', getSelectionstes[i]);
                                        $('#quoteMaterInfo').datagrid('deleteRow', index);
                                    }
                                } else {
                                    $.messager.alert('提示', '您还未选中数据行！', 'info');
                                }
                            }
                        }, {
                            iconCls: 'icon-ok',
                            text: '保存可供物资',
                            handler: function () {
                                var quoteMaterInfo = $('#quoteMaterInfo').datagrid('getRows');
                                if (quoteMaterInfo.length != 0) {
                                    $.messager.confirm('确认框', '您确认需要添加供应？', function (r) {
                                        if (r) {
                                            //物资id
                                            var idArrayMatro = new Array();
                                            for (var i = 0; i < quoteMaterInfo.length; i++) {
                                                idArrayMatro.push(quoteMaterInfo[i].goodsId);
                                            }
                                            $.ajax({
                                                type: 'POST',
                                                url: '${pageContext.request.contextPath}/supplyOfMaterialsController/addSupplies',
                                                traditional: true,
                                                data: {
                                                    'idArrayMatro': idArrayMatro,
                                                },
                                                success: function (msg) {
                                                    if (msg = "yes") {
                                                        $.messager.show({
                                                            title: '提示',
                                                            msg: '添加供应关系成功！',
                                                            timeout: 3000,
                                                            showType: 'slide'
                                                        });
                                                        //清空数据
                                                        EmptyData();
                                                        //把第一div隐藏
                                                        $('#maingosone').css('display', "block");
                                                        //显示第二div
                                                        $('#quoteConfirmationWindow').css('display', 'none');
                                                        //刷新数据行
                                                        $('#materialInformation').datagrid('reload');
                                                        return;
                                                    }
                                                    $.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
                                                }
                                            });
                                        }
                                    });
                                    return;
                                }
                                $.messager.alert('提示', '您还未添加物资！', 'info');
                            }
                        }],
                    });
                }
            }, {
                iconCls: 'icon-main_queryMaterialInfo',
                text: '移除可供应物资',
                handler: function () {
                    var optionsgo = $('#materialInformation').datagrid("getSelections");
                    if (optionsgo.length != 0) {
                        $.messager.confirm('确定？', '您确定要移除该供应关系吗？', function (r) {
                            if (r) {
                                $.ajax({
                                    type: 'POST',
                                    url: '${pageContext.request.contextPath}/supplyOfMaterialsController/removalOfSuppliesAvailable',
                                    data: {
                                        'id': optionsgo[0].goodsId,
                                    },
                                    success: function (msg) {
                                        if (msg == "yes") {
                                            $.messager.show({
                                                title: '提示',
                                                msg: '移除供应关系成功！',
                                                timeout: 3000,
                                                showType: 'slide'
                                            });
                                            $('#materialInformation').datagrid('reload');
                                            return;
                                        }
                                        $.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
                                    }
                                });
                            }
                        });
                        return;
                    }
                    $.messager.alert('我的消息', '您还未选择需要删除的行！', 'info');
                }
            }],
        });
    });

    //清空所有数据
    function EmptyData() {
        var selecttions = $('#quoteMaterInfo').datagrid('getRows');
        if (selecttions.length != 0) {
            for (var i = 0; i < selecttions.length; i++) {
                var index = $('#quoteMaterInfo').datagrid('getRowIndex', selecttions[i]);
                $('#quoteMaterInfo').datagrid('deleteRow', index);
                i--;
            }
        }
    }
</script>
<div id="maingosone" style="display:block">
    <table id="materialInformation"></table>
</div>
<!-- 预备可供物资窗口 -->
<div id="quoteConfirmationWindow" style="display: none">
    <table id="quoteMaterInfo">
    </table>
</div>
