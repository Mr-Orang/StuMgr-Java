<!-- 物料申请 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$('#application').datagrid({
		title : '${sessionScope.emplyee.te_name}的物料申请记录',
		url : '${pageContext.request.contextPath}/pickingManagement/queryPicking',
		striped : true,
		fit:false,
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
		columns : [ [
			{
				field : 'useId',
				title : '领用编号',
				width : 100
			},
			{
				field : 'fillTime',
				title : '填写日期',
				width : 100
			},
			{
				field : 'latesTime',
				title : '最迟日期',
				width : 100
			},
			{
				field : 'examineStatus',
				title : '审批状态',
				width : 100,
				formatter : function(value, row, index) {
					return value == 0 ? "未审批" : (value == 1 ? "未同意" : (value == 2 ? "已同意" : ""))
				}
			}
		] ],
		toolbar : [ {
			iconCls : 'icon-add',
			text : '添加新的申请',
			handler : function() {
				checkButton();
			}
		}, {
			iconCls : 'icon-main_examine',
			text : '查看详细信息',
			handler : function() {
				viewDetailsOfTheFunction();
			}
		}
		]
	});

	//查看详情的函数
	function viewDetailsOfTheFunction() {
		//获取选中的文本框
		var getSelect = $('#application').datagrid('getSelected');
		if (getSelect == null) {
			$.messager.alert('提示', '您还未选中数据行！', 'info');
			return;
		}
		var infoye = "<div id='materialDetailWindow'></div>";
		$(infoye).window({
			title : '领用物资明细',
			width : 500,
			height : 300,
			collapsible : false,
			minimizable : false,
			maximizable : false,
			modal : true,
			onClose:function(){
				$(this).window('destroy');
			}
		});
		var infogos = "<table id='gohh'></table><br/>";
		$('#materialDetailWindow').html(infogos);
		$('#gohh').datagrid({
			title : '' + getSelect.useId + '物料领用明细',
			url : '${pageContext.request.contextPath}/pickingManagement/pickupDetails',
			striped : true,
			fit:true,
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
					field : 'typeName',
					title : '物料类型',
					width : 100
				},
				{
					field : 'countNum',
					title : '申请数量',
					width : 100
				},
			] ],
			queryParams : {
				'id' : getSelect.useId,
			},
		});

	}

	//添加新的申请
	function checkButton() {
		var info = "<table id='dataUse'></table>";
		$('#div02').html(info);
		$('#div01').css('display', 'none');
		$('#div02').css('display', 'block');
		$('#dataUse').datagrid({
			striped : true,
			fitColumns : true,
			autoSizeColumn : true,
			columns : [ [
				{
					field : 'goodsId',
					title : '物资编号',
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
					field : 'goodsNum',
					title : '物资数量',
					width : 100,
					formatter : function(value, row, index) {
						return "<input type='number' name='GoodsNum' value= '1' min='1' />";
					}
				}
			] ],
			toolbar : [ {
				iconCls : 'icon-add',
				text : '添加物资',
				handler : function() {
					var infogosy = '<div id="windowInfogo"></div>';
					$(infogosy).window({
						title : '请选择需要的物资',
						width : 650,
						height : 300,
						modal : true,
						collapsible : false,
						minimizable : false,
						maximizable : false,
						onClose: function () {
                            $(this).window('destroy');
                        }
					});
					$('#windowInfogo').html("<table id='materias'></table>");
				    $('#materias').datagrid({
						url : '${pageContext.request.contextPath}/pickingManagement/queryGoods',
						title : '物资列表',
						fitColumns : true,
						fit:true,
						singleSelect : true,
						//分页工具栏
						pagination : true,
						//选择分页大小
						pageList : [ 5, 10 ],
						//初始化分页大小
						pageSize : 5,
						//初始化页码
						pageNumber : 1,
						columns : [ [
							{
								field : 'goodsId',
								title : '编号',
								width : 100
							},
							{
								field : 'brand',
								title : '品牌',
								width : 100
							},
							{
								field : 'company',
								title : '规格',
								width : 100
							},
							{
								field : 'description',
								title : '说明',
								width : 100
							},
							{
								field : 'typeName',
								title : '类型',
								width : 100
							},
						] ],
						//点击添加
						onClickRow : function() {
							var data = $('#materias').datagrid('getSelected');
							AddMthod.Add(data);
						}
					});
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '移除物资',
				handler : function() {
					var selecttions = $('#dataUse').datagrid('getSelections');
					if (selecttions.length != 0) {
						for (var i = 0; i < selecttions.length; i++) {
							var index = $('#dataUse').datagrid('getRowIndex', selecttions[i]);
							$('#dataUse').datagrid('deleteRow', index);
						}
						return;
					}
					$.messager.alert('提示', '请选择需要删除的行！', 'info');
				}
			}, '-', {
				iconCls : 'icon-save',
				text : '保存提交',
				handler : function() {
					var getRows = $('#dataUse').datagrid('getRows');
					if (getRows.length == 0) {
						$.messager.alert('提示', '还没有需要保存的物资！', 'info');
						return;
					}
					var infosuus = '<div id="EnterTheLatestDateWindow">'
								   + '<input id="TheLatestDate" type="text"></input><br/>'
								   + '<a id="ok_gos">确定</a>'
								   +'</div>;'
					$(infosuus).window({
						title : '请选择最迟领用日期',
						width : 200,
						height : 100,
						modal:true,
						collapsible : false,
						minimizable : false,
						maximizable : false,
						onClose: function () {
                            $(this).window('destroy');
                        }
					});
					$('#TheLatestDate').datebox({
						required : true
					});
					$('#ok_gos').linkbutton({
						onClick : function() {
							//获取用户选择的日期值
							var inputDate = $('#TheLatestDate').datebox('getValue');
							if (inputDate.length == 0) {
								$.messager.alert('提示', '您还未选中时间！', 'info');
								return;
							}
							//获取系统当前时间
							var systemDate = new Date();
							var year = systemDate.getFullYear();
							var month = systemDate.getMonth() + 1;
							var day = systemDate.getDate();

							var newStrTime = year + "-" + month + "-" + day;

							var time1 = new Date(Date.parse(inputDate.replace(/-/g, "/")));
							var time2 = new Date(Date.parse(newStrTime.replace(/-/g, "/")));

							//判断时间是否合法
							if (time1 < time2) {
								$.messager.alert('提示', '您选择的日期晚于当前时间，请重新选择', 'info');
								return;
							}
							$.messager.confirm('确认框', '您确定需要提交物资领用申请吗？', function(r) {
								if (r) {
								//把窗口关掉
									$('#EnterTheLatestDateWindow').window("close");
									var GoodsNum = $('input[name="GoodsNum"]');
									var idArray = new Array();
									var numArray = new Array();
									var regPos = /^[1-9]+[0-9]*]*$/
									for (var i = 0; i < GoodsNum.length; i++) {
										idArray.push(getRows[i].goodsId);
										//判断是否为合法数字
										if(!regPos.test($(GoodsNum[i]).val())){
											$.messager.alert('提示','您输入的领用数量不合法','info');
											return;
										}
										numArray.push($(GoodsNum[i]).val());
									}
									$.ajax({
										type : 'POST',
										traditional : true,
										url : '${pageContext.request.contextPath}/pickingManagement/insertMater',
										data : {
											idsArray : idArray,
											numsArray : numArray,
											latestTime : inputDate,
										},
										success : function(msg) {
											if (msg == 'yes') {
												$.messager.show({
													title : '提示',
													msg : '申请物资成功！',
													timeout : 5000,
													showType : 'slide'
												});
												$('#application').datagrid('reload');
												$('#div02').css('display', 'none');
												$('#div01').css('display', 'block');
											} else {
												$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
											}
										}
									});
								}
							});
						}
					});
				}
			} ]
		});
		/**
		 * 添加物资，记得要进行判断之前是否已经添加过了
		 * @type {{Add: AddMthod.Add}}
		 */
		AddMthod = {
			Add : function(data) {
				if (data != null) {
					var dataUsego = $('#dataUse').datagrid('getRows');
					for (var i = 0; i < dataUsego.length; i++) {
						if (dataUsego[i].goodsId == data.goodsId) {
							$.messager.alert('提示', '您已经添加过该物资了！', 'info');
							return;
						}
					}
					$('#dataUse').datagrid('appendRow', {
						goodsId : data.goodsId,
						description : data.description,
						typeName : data.typeName
					});
				}
			}
		};
	}
</script>
<div>
	<!-- 加载当前用户申请领用的物资编号 -->
	<div id="div01" style="display:block">
		<table id="application">
		</table>
	</div>
	<div id="div02" style="display:none">
	</div>
</div>
