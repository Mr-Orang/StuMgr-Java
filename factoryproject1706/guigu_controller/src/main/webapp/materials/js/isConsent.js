$(function () {
    /**
     * 不同意审批，则追加文本框询问理由
     */
    $('input[name=choose]').click(function () {
        if ($(this).val() == 0) {
            $('#isInfos').css('display', 'none');
        } else {
            $('#isInfos').css('display', 'block');
        }
    });
    methods = {
        submitData: function () {
            var text = "";
            if ($('input[name=choose]:checked').val() != "0") {
                //因为不同意需要理由
                text = $('#textareai').val();
            }
            $.messager.confirm('确定？', '您确定要' + ("0" == $('input[name=choose]:checked').val() ? "同意" : "不同意") + '该审批？', function (choose) {
                if (choose) {
                    $.ajax({
                        type: 'POST',
                        url: '/PickingManagement/ProcessApproval.action',
                        data: 'userId=' + methods.getValue() + '&text=' + text + "&decide=" + ("0" == $('input[name=choose]:checked').val() ? "0" : "1"),
                        success: function (msg) {
                            if (msg == "yes") {
                                $.messager.show({
                                    title: '提示',
                                    msg: '审批处理成功',
                                    timeout: 3000,
                                    showType: 'slide'
                                });
                                $('#PromptInformation').window('close');
                                $('#windowInfo').datagrid('reload');
                            } else {
                                $.messager.alert('提示', '服务器正在升级！', 'info');
                            }
                        }
                    });
                }
            });
        },
        //返回申请id
        getValue: function () {
            return $('#TheValue').val();
        },
        closeWindow: function () {
            $('#PromptInformation').window('close');
        }
    };
});