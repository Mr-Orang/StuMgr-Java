<!-- 采购申请 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		//加载当前账户的采购信息
		$('#PurchasingInformation').datagrid({
			title : '${sessionScope.emplyee.te_name}的采购信息列表',
			//分页工具栏
			pagination : true,
			//选择分页大小
			pageList : [ 5, 10 ],
			//初始化分页大小
			pageSize : 5,
			//初始化页码
			pageNumber : 1,
			fitColumns : true,
			striped : true,
			singleSelect : true,
			url : '${pageContext.request.contextPath}/purchaseRequisition/userPurchaseDetails',
			columns : [ [
				{
					field : 'pceId',
					title : '采购编号',
					width : 100
				},
				{
					field : 'pceDate',
					title : '填写日期',
					width : 100
				},
				{
					field : 'status',
					title : '审核状态',
					width : 100,
					formatter : function(value, row, index) {
						return value == 0 ? "未审批" : (value == 1 ? "未同意" : (value == 2 ? "已同意" : ""))
					}
				}
			] ],
			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加采购信息',
				handler : function() {
					objectMethods.objes();
				}
			}, {
				iconCls : 'icon-main_examine',
				text : '查看采购详细信息',
				handler : function() {
					viewDetailsOfTheFunction();
				}
			} ],
		});
		objectMethods = {
			manualPurchase : function() {
				var info = '<div id="dav02">'
					+ '<table id="dataInfo"></table>'
					+ '</div>';
				$(info).window({
					title : '请手动选择需要采购的物资',
					width : 500,
					height : 400,
					collapsible : false,
					minimizable : false,
					maximizable : false,
					modal : true,
					onClose : function() {
						$(this).window('destroy');
					}
				});
				$('#dataInfo').datagrid({
					title : '物资列表',
					fitColumns : true,
					singleSelect : true,
					striped : true,
					fit : true,
					pagination : true,
					pageList : [ 5, 10 ],
					pageSize : 5,
					pageNumber : 1,
					url : '${pageContext.request.contextPath}/purchaseRequisition/queryGoodsAndType',
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
							field : 'goodsStock',
							title : '物资库存',
							width : 100
						},
						{
							field : 'upStore',
							title : '库存上限',
							width : 100
						},
						{
							field : 'floorStore',
							title : '库存下限',
							width : 100
						}
					] ],
				});
				//创建事务点击添加
				$('#dataInfo').datagrid({
					onClickRow : function(rowIndex, rowData) {
						var tehg = $('#MaterialsThatNeedToBePurchased').datagrid('getRows');
						for (var i = 0; i < tehg.length; i++) {
							if (rowData.goodsId == tehg[i].goodsId) {
								$.messager.alert('提示', '你已经添加过该物资', 'info');
								return;
							}
						}
						$('#MaterialsThatNeedToBePurchased').datagrid('appendRow', {
							goodsId : rowData.goodsId,
							brand : rowData.brand,
							typeName : rowData.typeName,
							description : rowData.description,
						})
					}
				});
			},
			objes : function() {
				//关闭第一窗口，开启第一预备窗口
				$('#dav01').css('display', 'none');
				$('#winInfo').css('display', 'block');
				$('#MaterialsThatNeedToBePurchased').datagrid({
					title : '需要采购的物资',
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
							field : 'purchaseQuantity',
							title : '采购数量',
							width : 100,
							formatter : function() {
								return "<input type='number' name='purchaseNum' value = '1' min='1' />";
							}
						},
					] ],
					toolbar : [
						{
							iconCls : 'icon-add',
							text : '选择物资',
							handler : function() {
								//弹出选择物资的窗口，点一个选一个
								objectMethods.manualPurchase();
							}
						},
						{
							iconCls : 'icon-remove',
							text : '删除采购数据',
							handler : function() {
								var selecttions = $('#MaterialsThatNeedToBePurchased').datagrid('getSelections');
								if (selecttions.length != 0) {
									for (var i = 0; i < selecttions.length; i++) {
										var index = $('#MaterialsThatNeedToBePurchased').datagrid('getRowIndex', selecttions[i]);
										$('#MaterialsThatNeedToBePurchased').datagrid('deleteRow', index);
									}
									return;
								}
								$.messager.alert('提示', '请选择需要删除的行！', 'info');
							}
						},
						{
							iconCls : 'icon-save',
							text : '提交采购',
							handler : function() {
								var getSelections = $('#MaterialsThatNeedToBePurchased').datagrid('getRows');
								if (getSelections.length != 0) {
									$.messager.confirm('确认框', '您确认需要提交采购吗？', function(r) {
										if (r) {
											//物资数量数组
											var numArrays = new Array();
											//物资id数组
											var idArray = new Array();
											var theGoods = $('input[name=purchaseNum]');
											var regPos = /^[1-9]+[0-9]*]*$/
											for (var i = 0; i < getSelections.length; i++) {
												idArray.push(getSelections[i].goodsId);
												//验证输入的数量是否合法
												if(!regPos.test($(theGoods[i]).val())){
													$.messager.alert('提示','您输入的采购数量不合法，请检查','info');
													return;
												}
												numArrays.push($(theGoods[i]).val());
											}
											$.ajax({
												type : 'POST',
												url : '${pageContext.request.contextPath}/purchaseRequisition/manualPurchase',
												traditional : true,
												data : {
													'idArray' : idArray,
													'numArrays' : numArrays,
												},
												success : function(msg) {
													if (msg == 'yes') {
														$.messager.show({
															title : '提示',
															msg : '申请采购成功',
															timeout : 3000,
															showType : 'slide'
														});
														$('#PurchasingInformation').datagrid('reload');
														$('#winInfo').css("display", "none");
														$('#dav01').css('display', 'block');
													} else {
														$.messager.alert('提示', '服务器繁忙，请重试！', 'info');
														return;
													}
												}
											});
										}
									});
								} else {
									$.messager.alert('提示', '您还没有需要采购的物资', 'info');
									return;
								}
							}
						}
					],
				});
			}
		};
	});

	//查看详情的函数
	function viewDetailsOfTheFunction() {
		//获取选中的文本框
		var getSelect = $('#PurchasingInformation').datagrid('getSelected');
		if (getSelect == null) {
			$.messager.alert('提示', '您还未选中数据行！', 'info');
			return;
		}
		var info = "<div id='viewDetailsArea'></div>";
		$(info).window({
			title : '采购明细详情',
			width : 500,
			height : 400,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			draggable : false,
			modal : true,
			onClose : function() {
				$(this).window('destroy');
			}
		});
		var infogos = "<table id='goss'></table><br/>";
		$('#viewDetailsArea').html(infogos);
		$('#goss').datagrid({
			title : '' + getSelect.pceId + '物料领用明细',
			url : '${pageContext.request.contextPath}/purchaseRequisition/queryPurchaseDetails',
			striped : true,
			fit : true,
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			pageList : [ 5, 10 ],
			pageSize : 5,
			pageNumber : 1,
			columns : [ [
				{
					field : 'goodsId',
					title : '物料编号',
					width : 100
				},
				{
					field : 'brand',
					title : '物料品牌',
					width : 100
				},
				{
					field : 'company',
					title : '物料单位',
					width : 100
				},
				{
					field : 'description',
					title : '物料说明',
					width : 100
				},
				{
					field : 'accountNum',
					title : '采购数量',
					width : 100
				},
			] ],
			queryParams : {
				'id' : getSelect.pceId,
			},
		});
	}
</script>
<!-- 当前账户的采购信息 -->
<div style="display:block" id="dav01">
	<table id="PurchasingInformation">
	</table>
</div>
<!-- 预备物资区域 -->
<div style="display: none" id="winInfo">
	<table id="MaterialsThatNeedToBePurchased"></table>
</div>

