<!-- 审批采购申请 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		/**
		 * 不同意审批，则追加文本框询问理由
		 */
		methods = {
			submitData : function() {
				var text = "";
				if ($('input[name=decide]:checked').val() != "0") {
					//因为不同意需要理由
					text = $('#disagree').val();
				}
				text = text.trim();
				if (text.length == 0 && $('input[name=decide]:checked').val() == "1") {
					$.messager.alert('提示', '您还未输入理由！', 'info');
					return;
				}
				$.messager.confirm('确定？', '您确定要' + ("0" == $('input[name=decide]:checked').val() ? "同意" : "不同意") + '该审批？', function(choose) {
					if (choose) {
						//对象数组(采购物资id和追加数量)
						var goArray = new Array();
						$.ajax({
							type : 'POST',
							traditional : true,
							url : '${pageContext.request.contextPath}/purchaseRequisition/finalDecisionWhetherToApproveThePurchase',
							data : 'pceId=' + methods.getValue() + '&text=' + text + "&decide=" + ("0" == $('input[name=choose]:checked').val() ? "0" : "1") + "&Array=" + Arrays,
							success : function(msg) {
								if (msg == "yes") {
									$.messager.show({
										title : '提示',
										msg : '审核采购成功',
										timeout : 3000,
										showType : 'slide'
									});
									$('#ProcurementAuditDataWindow').datagrid('reload');
									$('#Okdiv2').window('close');
								} else {
									$.messager.alert('提示', '服务器繁忙,请稍后再试！', 'info');
								}
							}
						});
					}
				});
			},
			//返回申请id
			getValue : function() {
				return $('#hideInformation').val();
			},
			closeWindow : function() {
				$('#Okdiv2').window('close');
			},
		};
		$('#ProcurementAuditDataWindow').datagrid({
			title : '未审批的采购信息',
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
			url : '${pageContext.request.contextPath}/purchaseRequisition/queryPurchase',
			columns : [ [
				{
					field : 'pceId',
					title : '采购编号',
					width : 100
				},
				{
					field : 'applyName',
					title : '采购人姓名',
					width : 100
				},
				{
					field : 'pceDate',
					title : '填写日期',
					width : 100
				},
				{
					field : 'pceType',
					title : '采购单类型',
					width : 100
				},
			] ],
			toolbar : [ {
				iconCls : 'icon-main_approve',
				text : '审核采购申请',
				handler : function() {
					var data = $('#ProcurementAuditDataWindow').datagrid('getSelected');
					if (data == null) {
						$.messager.alert('提示', '请选择数据行', 'info');
						return;
					}
					var info = "<div id='Okdiv2'>"
						+ "<table id='procurementMaterialData'>"
						+ "</table>"
						+ "<br/>"
						+ "<h3>是否同意员工名为：<span id='employeeName'></span>的采购请求？</h3>"
						+ "<br/>"
						+ "<input type='radio' name='decide' value='0'/>同意"
						+ "<input type='radio' name='decide' value='1'/>不同意<br/>"
						+ "  <div id='messageBox' style='display:none'>"
						+ "<br/><h4>不同意理由</h4><br/>"
						+ "<textarea style='width: 260px;height: 80px;' id='disagree'></textarea>"
						+ "</div><br/><br/>"
						+ "<button onclick='methods.submitData();'>确认提交</button>"
						+ "<input type='hidden' id='hideInformation'/>"
						+ "</div>";
					$(info).window({
						title : '审批采购',
						width : 600,
						height : 500,
						collapsible : false,
						minimizable : false,
						maximizable : false,
						modal : true,
						onClose : function() {
							$(this).window('destroy');
						}
					});
					$('input[name=decide]').click(function() {
						if ($(this).val() == 0) {
							$('#messageBox').css('display', 'none');
						} else {
							$('#messageBox').css('display', 'block');
						}
					});
					$('#hideInformation').val(data.pceId);
					$('#employeeName').text(data.applyName);
					$('#procurementMaterialData').datagrid({
						title : '采购物资详细信息',
						url : '${pageContext.request.contextPath}/purchaseRequisition/listOfPurchasedMaterialsForApplication',
						fitColumns : true,
						striped : true,
						singleSelect : true,
						queryParams : {
							'pceId' : data.pceId,
						},
						columns : [ [
							{
								field : 'goodsId',
								title : '物资编号',
								width : 100
							},
							{
								field : 'brand',
								title : '物资名称',
								width : 100
							},
							{
								field : 'typeName',
								title : '物资类型',
								width : 100
							},
							{
								field : 'accountNum',
								title : '采购数量',
								width : 100
							},
							{
								field : 'additionalQuantity',
								title : '追加数量',
								width : 100,
								formatter : function(value, row, index) {
									var infos = '<input type="text" id="purchase_' + row.goodsId + '" value="0" onblur="additionalQuantity(this);">';
									return infos;
								}
							}
						] ]
					});
				}
			}, {
				iconCls : 'icon-main_Historicalapprovals',
				text : '历史审核',
				handler : function() {
					$('#div1').css("display", "none");
					$('#Okdiv2').css("display", "none");
					$('#HistoricalMaterialApprovalInquiry').css("display", "block");
					$('#HistoricallyApprovedData').datagrid({
						title:'历史审批记录',
						url : '${pageContext.request.contextPath}/purchaseRequisition/queryHistoricalApprovalInformation',
						fitColumns : true,
						singleSelect : true,
						//分页工具栏
						pagination : true,
						//选择分页大小
						pageList : [ 5, 10 ],
						//初始化分页大小
						pageSize : 5,
						//初始化页码
						pageNumber : 1,
						striped : true,
						columns : [ [
							{
								field : 'pceId',
								title : '采购编号',
								width : 100
							},
							{
								field : 'applyEmpNo',
								title : '申请人姓名',
								width : 100
							},
							{
								field : 'pceDate',
								title : '申请日期',
								width : 100
							},
							{
								field : 'pceType',
								title : '采购类型',
								width : 100
							},
							{
								field : 'status',
								title : '审批结果',
								width : 100,
								formatter : function(value, row, index) {
									return value == 1 ? "不同意" : "同意";
								}
							},
							{
								field : 'checkReason',
								title : '不同意原因',
								width : 100
							},
							{
								field : 'checkEmpName',
								title : '审核人姓名',
								width : 100
							},
						] ],
						view : detailview,
						detailFormatter : function(rowIndex, rowData) {
							return "<div style='height:300px;'><table id='PurchaseAuditDetails_" + rowData.pceId + "'></table></div>";
						},
						onExpandRow : function(rowIndex, rowData) {
							var infoValuesgos = "#PurchaseAuditDetails_" + rowData.pceId;
							$(infoValuesgos).datagrid({
								url : '${pageContext.request.contextPath}/purchaseRequisition/listOfPurchasedMaterialsForApplication',
								fitColumns : true,
								singleSelect : true,
								striped : true,
								columns : [ [
									{
										field : 'goodsId',
										title : '物资编号',
										width : 100
									},
									{
										field : 'brand',
										title : '物资名称',
										width : 100
									},
									{
										field : 'typeName',
										title : '物资类型',
										width : 100
									},
									{
										field : 'accountNum',
										title : '采购数量',
										width : 100
									},
									{
										field : 'countNum',
										title : '追加数量',
										width : 100,
									}
								] ],
								queryParams : {
									pceId : rowData.pceId,
								}
							});
						}
					});
				}
			} ],
		});

	});

	var Arrays = new Array();

	function additionalQuantity(obj) {
		//获取用户输入的追加数量
		var info = $(obj).val();
		//获取物资id
		var attr = $(obj).attr("id");
		//截取物资id
		attr = attr.substr(9, attr.length);
		//------------------------------------------------------------------------------------
		for (var i = 0; i < Arrays.length; i++) {
			var goInfo = Arrays[i].split(":");
			if (goInfo[0] == attr) {
				Arrays[i] = "" + goInfo[0] + ":" + info + "";
				return;
			}
		}
		Arrays.push("" + attr + ":" + info + "");
	}
</script>
<div id="div1" style="display: block">
	<table id="ProcurementAuditDataWindow"></table>
</div>
<!-- 历史物资审批 -->
<div id="HistoricalMaterialApprovalInquiry" style="display: none">
	<table id="HistoricallyApprovedData">
	</table>
</div>
