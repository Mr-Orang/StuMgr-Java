<!-- 供应商采购报价 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		$('#purcjaseMainData').datagrid({
			title : '当前可报价采购列表(报价提交后不可更改与撤回)',
			fitColumns : true,
			striped : true,
			singleSelect : true,
			pagination : true,
			pageList : [ 5, 10 ],
			pageSize : 5,
			pageNumber : 1,
			url : '${pageContext.request.contextPath}/supplierQuotationController/queryQuotation',
			columns : [ [
				{
					field : 'pceId',
					title : '采购编号',
					width : 100
				},
				{
					field : 'pceDate',
					title : '采购日期',
					width : 100
				},
			] ],
			toolbar : [ {
				iconCls : 'icon-main_examine',
				text : '选择该采购单报价',
				handler : function() {
					//获取选中的行
					var getSelections = $('#purcjaseMainData').datagrid('getSelections');
					if (getSelections.length == 0) {
						$.messager.alert('提示', '您还未选中数据行！', 'info');
						return;
					}
					//显示信息框
					$('#purchaseMain').css("display", "none");
					$('#prepareAQuote').css("display", "block");
					$('#datapurcjeseMainDatago').datagrid({
						title : '需要进行报价的物资',
						singleSelect : true,
						fitColumns : true,
						striped : true,
						columns : [ [
							{
								field : 'goodsId',
								title : '物资编号',
								width : 100
							},
							{
								field : 'brand',
								title : '物资品牌',
								width : 100
							},
							{
								field : 'description',
								title : '物资说明',
								width : 100
							},
							{
								field : 'typeName',
								title : '物资类型',
								width : 100
							},
							{
								field : 'declaredValue',
								title : '申报价格',
								width : 100,
								formatter : function() {
									return "<input type='text' name='theDeclaredValue' value='1' />";
								}
							},
						] ],
						toolbar : [
							{
								iconCls : 'icon-main_Chooseaquote',
								text : '选择报价物资',
								handler : function() {
									var info = '<div id="two">\n' +
										'    <table id="dataBasket">\n' +
										'    </table>\n' +
										'</div>';
									$(info).window({
										title : '请选择可报价的物资',
										width : 400,
										height : 300,
										minimizable : false,
										maximizable : false,
										collapsible : false,
										modal : true,
										onClose : function() {
											$(this).window('destroy');
										}
									});
									$('#dataBasket').datagrid({
										title : '该采购单的物资明细',
										fitColumns : true,
										fit:true,
										striped : true,
										singleSelect : true,
										url : '${pageContext.request.contextPath}/supplierQuotationController/queryGoodsUser',
										columns : [ [
											{
												field : 'goodsId',
												title : '物资编号',
												width : 100
											},
											{
												field : 'brand',
												title : '物资品牌',
												width : 100
											},
											{
												field : 'description',
												title : '物资说明',
												width : 100
											},
											{
												field : 'typeName',
												title : '物资类型',
												width : 100
											},
										] ],
										queryParams : {
											'id' : getSelections[0].pceId,
										},
										onClickRow : function(rowIndex, rowData) {
											var dataBasket = $('#datapurcjeseMainDatago').datagrid('getRows');
											for (var i = 0; i < dataBasket.length; i++) {
												if (dataBasket[i].goodsId == rowData.goodsId) {
													$.messager.alert('提示', '您已经添加过该物资了！', 'info');
													return;
												}
											}
											$('#datapurcjeseMainDatago').datagrid('appendRow', {
												goodsId : rowData.goodsId,
												brand : rowData.brand,
												description : rowData.description,
												typeName : rowData.typeName,
											});
										}
									});
								}
							}, {
								iconCls : 'icon-main_empty',
								text : '移除报价物资',
								handler : function() {
									//获取选中的数据行
									var getSelections = $('#datapurcjeseMainDatago').datagrid("getSelections");
									if (getSelections.length != 0) {
										var index = $('#datapurcjeseMainDatago').datagrid('getRowIndex', getSelections[0]);
										$('#datapurcjeseMainDatago').datagrid('deleteRow', index);
										return;
									}
									$.messager.alert('提示', '您还未选中数据行！', 'info');
								}
							}, {
								iconCls : 'icon-main_quote',
								text : '提交报价',
								handler : function() {
									$.messager.confirm('确认框', '您确定需要提交报价吗？（不可撤回）', function(r) {
										if (r) {
											var getRows = $('#datapurcjeseMainDatago').datagrid('getRows');
											if (getRows.length > 0) {
												//物资编号
												var goodsIdArrays = new Array();
												//供货价
												var priceArrays = new Array();
												//获取输入的价格
												var theDeclaredValue = $('input[name=theDeclaredValue]');
												//保存数据
												for (var i = 0; i < getRows.length; i++) {
													goodsIdArrays.push(getRows[i].goodsId);
													var reg = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;
													if (!reg.test($(theDeclaredValue[i]).val())) {
														$.messager.alert('提示', '您输入的价格字符不合法，请检查后再提交！', 'info');
														return;
													}
													priceArrays.push($(theDeclaredValue[i]).val());
												}
												$.ajax({
													type : 'POST',
													url : '${pageContext.request.contextPath}/supplierQuotationController/querySubmitPrice',
													traditional : true,
													data : {
														//采购单编号
														pceId : getSelections[0].pceId,
														//物资编号
														goodsIdArrays : goodsIdArrays,
														//供货价
														priceArrays : priceArrays,
													},
													success : function(msg) {
														if (msg = "yes") {
															$.messager.show({
																title : '提示',
																msg : '报价成功',
																timeout : 3000,
																showType : 'slide'
															});
															$('#two').window('close');
															$('#prepareAQuote').css("display", "none");
															$('#purchaseMain').css("display", "block");
															$('#purcjaseMainData').datagrid("reload");
															return;
														}
														$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
													}
												});
												return;
											}
											$.messager.alert('提示', '您还未添加报价物资！', 'info');
										}
									});
								}
							} ],
					});
				}
			}, {
				text : '报价签约成功信息',
				iconCls : 'icon-main_SupplysigningNotice',
				handler : function() {
					$('#purchaseMain').css("display", "none");
					$('#prepareAQuote').css("display", "none");
					$('#SigningNotice').css("display", "block");
					$('#SigningNoticeInfo').datagrid({
						title : '签约成功的采购',
						url : '${pageContext.request.contextPath}/supplierQuotationController/queryViewQuotationsSignedContractsSorSuccess',
						height : 400,
						fitColumns : true,
						striped : true,
						singleSelect : true,
						pagination : true,
						pageList : [ 5, 10 ],
						pageSize : 5,
						pageNumber : 1,
						view : detailview,
						detailFormatter : function(rowIndex, rowData) {
							return "<div style='height:150px;'><table id='ContractPurchase_" + rowData.protId + "'></table></div>";
						},
						columns : [ [
							{
								field : 'protId',
								title : '合同编号',
								width : 100
							},
							{
								field : 'protdId',
								title : '采购编号',
								width : 100
							},
							{
								field : 'conSum',
								title : '本次金额',
								width : 100
							},
						] ],
						onExpandRow : function(index, row) {
							// 物资id 数量 单价
							var IdValueName = "#ContractPurchase_" + row.protId;
							$(IdValueName).datagrid({
								url : '${pageContext.request.contextPath}/supplierQuotationController/queryChoicePriceDetail',
								fitColumns : true,
								striped : true,
								columns : [ [
									{
										field : 'goodsId',
										title : '物资id',
										width : 100
									},
									{
										field : 'chPriceID',
										title : '物资描述',
										width : 100
									},
									{
										field : 'amount',
										title : '供货数量',
										width : 100
									},
									{
										field : 'price',
										title : '单位金额',
										width : 100
									},
								] ],
								queryParams : {
									pceId : row.protdId,
								}
							});
						}
					});
				}
			}],
		});
	});
</script>
<!-- 第一数据框 -->
<div id="purchaseMain" style="display: block">
	<table id="purcjaseMainData">
	</table>
</div>
<!-- 第二数据框 -->
<div id="prepareAQuote" style="display: none">
	<table id="datapurcjeseMainDatago">
	</table>
</div>
<!-- 第三数据框 -->
<div id="SigningNotice" style="display: none">
	<table id="SigningNoticeInfo">
	</table>
</div>