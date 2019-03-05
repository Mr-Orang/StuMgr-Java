<!-- 审批物资 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	/**
	 * 不同意审批，则追加文本框询问理由
	 */
	methods = {
		submitData : function() {
			var text = "";
			if ($('input[name=choose]:checked').val() != "0") {
				//因为不同意需要理由
				text = $('#textareai').val();
			}
			//去空格
			text = text.trim();
			//判断长度
			if (text.length == 0 && $('input[name=choose]:checked').val() == "1") {
				$.messager.alert('提示', '您还未输入理由！', 'info');
				return;
			}
			$.messager.confirm('确定？', '您确定要' + ("0" == $('input[name=choose]:checked').val() ? "同意" : "不同意") + '该审批？', function(choose) {
				if (choose) {
					$.ajax({
						type : 'POST',
						url : '${pageContext.request.contextPath}/pickingManagement/processApproval',
						data : 'userId=' + methods.getValue() + '&text=' + text + "&decide=" + ("0" == $('input[name=choose]:checked').val() ? "0" : "1"),
						success : function(msg) {
							if (msg == "yes") {
								$.messager.show({
									title : '提示',
									msg : '审批处理成功',
									timeout : 3000,
									showType : 'slide'
								});
								$('#okssmm').window('close');
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
		getValue : function() {
			return $('#TheValue').val();
		},
		closeWindow : function() {
			$('#PromptInformation').window('close');
		}
	};
	//-------------------------------------------------------------------------------------
	$(function() {
		$('#windowInfo').datagrid({
			title : '未审批的物料',
			url : '${pageContext.request.contextPath}/pickingManagement/queryApplicationInformation',
			//分页工具栏
			pagination : true,
			//选择分页大小
			pageList : [ 5, 10 ],
			//初始化分页大小
			pageSize : 5,
			//初始化页码
			pageNumber : 1,
			singleSelect : true,
			striped : true,
			fitColumns : true,
			columns : [ [
				{
					field : 'useId',
					title : '申请编号',
					width : 100
				},
				{
					field : 'empName',
					title : '申请人姓名',
					width : 100
				},
				{
					field : 'fillTime',
					title : '申请日期',
					width : 100
				},
				{
					field : 'latesTime',
					title : '最迟领用日期',
					width : 100
				}
			] ],
			toolbar : [ {
				iconCls : 'icon-main_approve',
				text : '审批领用',
				handler : function() {
					var selectRow = $('#windowInfo').datagrid('getSelected');
					if (selectRow != null) {
						var info = '<div id="okssmm"><div id="PromptInformation">'
							+ '<h3>是否同意员工名称为：<span id="empName"></span>的物资审批请求？</h3><br/>'
							+ '<table id="goodsInfo"></table>'
							+ '<br/>'
							+ '<input type="radio" name="choose" value="0"/>同意'
							+ '<input type="radio" name="choose" value="1"/>不同意<br/>'
							+ '<div id="isInfos" style="display:none">'
							+ '<br/><h4>不同意理由</h4><br/>'
							+ '<textarea style="width: 260px;height: 80px;" id="textareai"></textarea></div><br/><br/>'
							+ '<button onclick="methods.submitData();">确认提交</button>'
							+ '<input type="hidden" value="0" id="TheValue"/>'
							+ '</div></div>';
						$(info).window({
							height : 400,
							width : 600,
							title : '确认审批',
							modal : true,
							collapsible : false,
							minimizable : false,
							maximizable : false,
							onClose : function() {
								$(this).window('destroy');
							}
						});
						//为用户决定创建点击事件
						$('input[name=choose]').click(function() {
							if ($(this).val() == 0) {
								$('#isInfos').css('display', 'none');
							} else {
								$('#isInfos').css('display', 'block');
							}
						});
						$('#empName').text(selectRow.empName);
						$('#TheValue').val(selectRow.useId);
						/**
						 * 该申请单号物资列表
						 */
						$('#goodsInfo').datagrid({
							url : '${pageContext.request.contextPath}/pickingManagement/applicationInquiry',
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
									field : 'description',
									title : '物资说明',
									width : 100
								},
								{
									field : 'company',
									title : '物资规格',
									width : 100
								},
								{
									field : 'countNum',
									title : '物资数量',
									width : 100
								}
							] ],
							queryParams : {
								id : methods.getValue(),
							}
						});
					} else {
						$.messager.alert('提示', '您还未选择需要审批的领用单！', 'info');
						return;
					}
				}
			}, {
				text : '历史物资审批',
				iconCls : 'icon-main_Historicalapprovals',
				handler : function() {
					$('#DataThatNeedsToBeApproved').css("display", "none");
					$('#PromptInformation').css("display", "none");
					$('#ApprovalOfHistoricalMaterials').css("display", "block");
					$('#ApproveData').datagrid({
						url : '${pageContext.request.contextPath}/pickingManagement/queryHistoryApprovalRecords',
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
								field : 'useId',
								title : '领用编号',
								width : 100
							},
							{
								field : 'takeEmpNO',
								title : '申请人姓名',
								width : 100
							},
							{
								field : 'fillTime',
								title : '申请日期',
								width : 100
							},
							{
								field : 'latesTime',
								title : '最迟日期',
								width : 100
							},
							{
								field : 'examineStatus',
								title : '审批结果',
								width : 100,
								formatter : function(value, row, index) {
									return value == 1 ? "不同意" : "同意";
								}
							},
							{
								field : 'reason',
								title : '不同意原因',
								width : 100
							},
							{
								field : 'checkEmpName',
								title : '审批人',
								width : 100
							},
						] ],
						view : detailview,
						detailFormatter : function(rowIndex, rowData) {
							return "<div style='height:300px'><table id='applicationData_" + rowData.useId + "'></table></div>";
						},
						onExpandRow : function(rowIndex, rowData) {
							var infoValuesgos = "#applicationData_" + rowData.useId;
							$(infoValuesgos).datagrid({
								url : '${pageContext.request.contextPath}/pickingManagement/applicationInquiry',
								fitColumns : true,
								singleSelect : true,
								pagination : true,
								pageList : [ 5, 10 ],
								pageSize : 5,
								pageNumber : 1,
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
										field : 'description',
										title : '物资说明',
										width : 100
									},
									{
										field : 'company',
										title : '物资规格',
										width : 100
									},
									{
										field : 'countNum',
										title : '物资数量',
										width : 100
									}
								] ],
								queryParams : {
									id : rowData.useId,
								}
							});
						}
					});
				}
			}
			],
		});
	});
</script>
<div id="DataThatNeedsToBeApproved" style="display: block">
	<table id="windowInfo">
	</table>
</div>
<!-- 历史物资审批 -->
<div id="ApprovalOfHistoricalMaterials" style="display: none">
	<table id="ApproveData">
	</table>
</div>
