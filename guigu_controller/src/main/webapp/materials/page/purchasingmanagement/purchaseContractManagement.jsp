<!-- 合同审核 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	/**
	 * 不同意审批，则追加文本框询问理由
	 */
	$(function() {
		//加载可生成合同的数据
		$('#GenerateContractData').datagrid({
			title : '可审批的采购合同(展开查看合同明细信息)',
			url : '${pageContext.request.contextPath}/purchaseContractManagementController/queryProtocal',
			pagination : true,
			pageList : [ 5, 10 ],
			pageSize : 5,
			pageNumber : 1,
			rownumbers : true,
			view : detailview,
			fitColumns : true,
			toolbar : [ {
				text : '审批合同',
				iconCls : 'icon-main_approve',
				handler : function() {
					//获取选中的行数据
					var getSelections = $('#GenerateContractData').datagrid("getSelections");
					if (getSelections.length == 0) {
						$.messager.alert('提示', '您还未选中数据！', 'info');
						return;
					}
					var infos = "<div id=\"PurchaseAuditConfirmationBox\">\n" +
						"    <h3>您是否同意合同编号为：\n" +
						"        <spam id=\"ContractInfo\"></spam>\n" +
						"        的请求？\n" +
						"    </h3>\n" +
						"    <br/>\n" +
						"    <input type='radio' checked=checked name='Consequence' value='0'/>同意\n" +
						"    <input type='radio' name='Consequence' value='1'/>不同意<br/>\n" +
						"    <div id='ReasonsForNotAgreeing' style='display:none'>\n" +
						"        <br/><h4>不同意理由</h4><br/>\n" +
						"        <textarea style='width: 260px;height: 80px;' id='ReasonsForNotAgreeingInfo'></textarea>\n" +
						"    </div>\n" +
						"    <br/>\n" +
						"    <br/>\n" +
						"    <a id='ConfirmationOfSubmissionOfContract'>确认提交</a>\n" +
						"    <a id='CloseWindowContract'>关闭窗口</a>\n" +
						"</div>";
					$(infos).window({
						title : '审批合同',
						modal : true,
						collapsible : false,
						minimizable : false,
						maximizable : false,
						width : 400,
						height : 400,
						onClose : function() {
							$(this).window('destroy');
						}
					});
					//设置文本框
					$('#ContractInfo').text(getSelections[0].protId);
					//设置事件
					$('input[name=Consequence]').click(function() {
						if ($(this).val() == 0) {
							$('#ReasonsForNotAgreeing').css('display', 'none');
						} else {
							$('#ReasonsForNotAgreeing').css('display', 'block');
						}
					});
					//加载提交按钮
					$('#ConfirmationOfSubmissionOfContract').linkbutton({
						onClick : function() {
							var text = "";
							if ($('input[name=Consequence]:checked').val() != "0") {
								//因为不同意需要理由
								text = $('#ReasonsForNotAgreeingInfo').val();
							}
							//去空格
							text = text.trim();
							//判断长度
							if (text.length == 0 && $('input[name=Consequence]:checked').val() == "1") {
								$.messager.alert('提示', '您还未输入不同意的理由！', 'info');
								return;
							}
							$.messager.confirm('确定？', '您确定要' + ("0" == $('input[name=Consequence]:checked').val() ? "同意" : "不同意") + '该审批？', function(choose) {
								if (choose) {
									$.ajax({
										type : 'POST',
										url : '${pageContext.request.contextPath}/purchaseContractManagementController/handleContractApprovalResults',
										data : {
											//合同编号
											protId : getSelections[0].protId,
											//审批结果
											ApprovalResults : $('input[name=Consequence]:checked').val(),
											//不同意原因
											Disagreewiththereason : text,
										},
										success : function(msg) {
											if (msg == "yes") {
												$.messager.show({
													title : '提示',
													msg : '合同审批处理成功，已通过邮件通知供应商',
													timeout : 3000,
													showType : 'slide'
												});
												//关闭窗口
												$('#PurchaseAuditConfirmationBox').window("close");
												//刷新数据表格
												$('#GenerateContractData').datagrid("reload");
												return;
											} else {
												$.messager.alert('提示', '服务器繁忙，请稍后再试', 'info');
											}
										}
									});
								}
							});
						}
					});
					//加载关闭按钮
					$('#CloseWindowContract').linkbutton({
						onClick : function() {
							$('#PurchaseAuditConfirmationBox').window('close');
						}
					});
				}
			} ],
			columns : [ [
				{
					field : 'protId',
					title : '合同编号',
					width : 100
				},
				{
					field : 'pceId',
					title : '采购编号',
					width : 100
				},
				{
					field : 'theTotalAmountOfTheContract',
					title : '合同总金额',
					width : 100
				},
			] ],
			detailFormatter : function(rowIndex, rowData) {
				return "<div style='height:170px;'><table id='bargain_" + rowData.protId + "'></table></div>";
			},
			onExpandRow : function(index, row) {
				//展开行时使用树形下拉表格展示数据
				var infoNameValues = "#bargain_" + row.protId;
				$(infoNameValues).treegrid({
					url : '${pageContext.request.contextPath}/purchaseContractManagementController/queryTheSupplierAndTotalAmountOfTheContract',
					title : row.protId + "的合同明细",
					iconCls : 'icon-main_Quotationdetails',
					singleSelect : true,
					//关键字段来标识树节点，不能重复
					idField : 'providerId',
					//树节点字段，也就是树节点的名称
					treeField : 'providerId',
					fitColumns : true,
					//显示一个行号列
					rownumbers : true,
					collapsible : true, //收起表格的内容
					loadMsg : '数据加载中...',
					//在节点展开或折叠的时候是否显示动画效果
					animate : true,
					//显示treegrid行
					lines : true,
					columns : [ [
						{
							field : 'providerId',
							title : '供应商编号',
							width : 100,
							align : 'left',
						}, {
							field : 'status',
							title : '供应商名称',
							width : 100,
							align : 'left'
						}, {
							field : 'conSum',
							title : '业务金额',
							width : 100,
							align : 'center'
						}
					] ],
					queryParams : {
						protdId : row.protId,
					},
				});
			}
		});
	});
</script>
<div>
	<table id="GenerateContractData">
	</table>
</div>
