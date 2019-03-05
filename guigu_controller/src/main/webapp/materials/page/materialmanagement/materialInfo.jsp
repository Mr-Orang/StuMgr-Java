<!-- 物料管理 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 异步上传插件 -->
<script type="text/javascript">
	$('#mInfo').datagrid({
		title : '所有物资信息',
		url : '${pageContext.request.contextPath}/materialInfo/queryMaterialInfo',
		fit : true,
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
				title : '物资编号',
				width : 100
			},
			{
				field : 'brand',
				title : '物资品牌',
				width : 100
			},
			{
				field : 'company',
				title : '物资单位',
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
				field : 'status',
				title : '该物资是否可用',
				width : 100,
				formatter : function(value, row, index) {
					if (value == 0) {
						return "可用";
					}
					if (value == 1) {
						return "不可用";
					}
				}
			},
			{
				field : 'goodStock',
				title : '库存',
				width : 100
			},
			{
				field : 'upStore',
				title : '上限',
				width : 100
			},
			{
				field : 'floorStore',
				title : '下限',
				width : 100
			},
		] ],
		toolbar : [ {
			iconCls : 'icon-main_batching',
			text : '批添加物资信息',
			handler : function() {
				//显示与隐藏
				$('#batchProcessingWindow').css("display", "block");
				$('#mainInfogoos').css("display", "none");
				//设置按钮
				$('#downloadTemplates').linkbutton({
					iconCls : 'icon-downloadTemplates',
					onClick : function() {
						window.location.href = "${pageContext.request.contextPath}/download/downloadExcel";
					}
				});
			}
		},
			//------------------------------------------------------------------------------------------------------------------------
			{
				iconCls : 'icon-add',
				text : '添加物资信息',
				handler : function() {
					//设置未对话框
					var infos = '        <div style="margin-left: 130px;margin-top: 40px;">\n' +
						'            物资品牌:<input type="text" id="add_brand"/><br/><br/>\n' +
						'            物资单位:<input type="text" id="add_company"/><br/><br/>\n' +
						'            物资说明:<input type="text" id="add_description"/><br/><br/>\n' +
						'            物资类型：\n' +
						'            <div id="add_treeType" style="width: 300px;"></div>\n' +
						'            <br/><br/>\n' +
						'            库存上限：<input type="text" id="add_upStore"/><br/><br/>\n' +
						'            库存下限：<input type="text" id="add_floorStore"><br/><br/>\n' +
						'            <a id="add_save_data">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;\n' +
						'        </div>';
					var infosgo = "<div id='addsdatago'>" + infos + "</div>";
					$(infosgo).window({
						width : 600,
						height : 400,
						modal : true,
						title : '导入新的物资信息',
						collapsible : false,
						minimizable : false,
						maximizable : false,
						onClose : function() {
							$(this).window('destroy');
						}
					});
					//初始化集合
					dataPopulation("0");
					//加载保存按钮
					$('#add_save_data').linkbutton({
						onClick : function() {
							$.messager.confirm('确认框', '您确认需要添加新物资信息吗？', function(r) {
								if (r) {
									//保存新文字
									//准备文本数据
									var add_brand = $('#add_brand').val();
									var add_company = $('#add_company').val();
									var add_description = $('#add_description').val();
									var add_upStore = $('#add_upStore').val();
									var add_floorStore = $('#add_floorStore').val();
									//准备物资类型数据
									var add_treeType = $('#add_treeType').combotree('getValue');
									$.ajax({
										type : 'POST',
										url : '${pageContext.request.contextPath}/materialInfo/addGoodsGogs',
										data : {
											'brand' : add_brand,
											'company' : add_company,
											'description' : add_description,
											'typeId' : add_treeType,
											'upStore' : add_upStore,
											'floorStore' : add_floorStore,
										},
										success : function(msg) {
											if (msg == "yes") {
												//弹出数据
												$.messager.show({
													title : '消息',
													msg : '保存成功',
													timeout : 3000,
													showType : 'slide'
												});
											}
											if (msg == "no") {
												$.messager.alert('提示', '服务器繁忙，请稍后再试', 'info');
											}
											//更新数据表格
											$('#mInfo').datagrid('reload');
											//关闭窗口
											$('#addsdatago').window('close');
										}
									});
								}
							});
						}
					});
					//显示div
					$('#addsdatago').css("display", "block");
				}
			}, {
				iconCls : 'icon-edit',
				text : '修改物资信息',
				handler : function() {
					var getSelections = $('#mInfo').datagrid('getSelections');
					if (getSelections.length == 0) {
						$.messager.alert('提示', '您还为选中任何需要修改的物资！', 'info');
						return;
					}
					//查询具体的物资信息
					$.ajax({
						type : 'POST',
						data : 'id=' + getSelections[0].goodsId,
						url : '${pageContext.request.contextPath}/materialInfo/queryMJ',
						success : function(msg) {
							var infosgo = '    <div style="margin-left: 130px;margin-top: 40px;">\n' +
								'        物资品牌:<input type="text" id="up_brand"/><br/><br/>\n' +
								'        物资单位:<input type="text" id="up_company"/><br/><br/>\n' +
								'        物资说明:<input type="text" id="up_description"/><br/><br/>\n' +
								'        物资类型：\n' +
								'        <div id="treeType" style="width: 300px;"></div>\n' +
								'        <br/><br/>\n' +
								'        库存上限：<input type="text" id="up_upStore"/><br/><br/>\n' +
								'        库存下限：<input type="text" id="up_floorStore"><br/><br/>\n' +
								'        <a id="save_data">保存</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="restore_data">还原</a>\n' +
								'    </div>';
							var woosdx = "<div id='inso'>" + infosgo + "</div>";
							//将div设置为对话框
							$(woosdx).window({
								collapsible : false,
								minimizable : false,
								maximizable : false,
								width : 600,
								height : 400,
								modal : true,
								title : '修改物资信息',
								onClose : function() {
									$(this).window("destroy");
								}
							});
							dataPopulation(msg);
							//加载保存按钮
							$('#save_data').linkbutton({
								iconCls : 'icon-ok',
								onClick : function() {
									$.messager.confirm('确定？', '您确定想要修改该物资信息吗？', function(r) {
										if (r) {
											//保存修改
											//准备文本数据
											var up_brand = $('#up_brand').val();
											var up_company = $('#up_company').val();
											var up_description = $('#up_description').val();
											var up_upStore = $('#up_upStore').val();
											var up_floorStore = $('#up_floorStore').val();
											//准备物资类型数据
											var treeType = $('#treeType').combotree('getValue');
											$.ajax({
												type : 'POST',
												url : '${pageContext.request.contextPath}/materialInfo/updateMJ',
												data : {
													'brand' : up_brand,
													'company' : up_company,
													'description' : up_description,
													'typeId' : treeType,
													'upStore' : up_upStore,
													'floorStore' : up_floorStore,
													'goodsId' : getSelections[0].goodsId,
												},
												success : function(msg) {
													if (msg == "yes") {
														//弹出数据
														$.messager.show({
															title : '消息',
															msg : '修改成功',
															timeout : 3000,
															showType : 'slide'
														});
													}
													if (msg == "no") {
														$.messager.alert('提示', '服务器繁忙，请稍后再试', 'info');
													}
													//更新数据表格
													$('#mInfo').datagrid('reload');
													//关闭窗口
													$('#inso').window('close');
												}
											});
										}
									});
								}
							});
							//加载还原按钮
							$('#restore_data').linkbutton({
								iconCls : 'icon-reload',
								onClick : function() {
									dataPopulation(msg);
								}
							});
						}
					});
				}
			}, {
				iconCls : 'icon-remove',
				text : '下架物资',
				handler : function() {
					var getSelections_remove = $('#mInfo').datagrid('getSelections');
					if (getSelections_remove.length == 0) {
						$.messager.alert('提示', '您还未选择需要下架的物资！', 'info');
						return;
					}
					//判断是否以及为下架物资
					if (getSelections_remove[0].status == "1") {
						$.messager.alert('提示', '该物资以及下架了！', 'info');
						return;
					}
					$.messager.confirm('确认框', '您确认需要下架该物资吗？', function(r) {
						if (r) {
							$.ajax({
								type : 'POST',
								url : '${pageContext.request.contextPath}/materialInfo/removeGoods',
								data : {
									"id" : getSelections_remove[0].goodsId,
								},
								success : function(msg) {
									if (msg == "yes") {
										$.messager.show({
											title : '消息',
											msg : '该物资下架成功!',
											timeout : 3000,
											showType : 'slide'
										});
									}
									if (msg == "no") {
										$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
									}
									//更新数据表格
									$('#mInfo').datagrid('reload');
								}
							});
						}
					});
				}
			}, {
				iconCls : 'icon-main_Shelves',
				text : '上架物资',
				handler : function() {
					var getSelections_add = $('#mInfo').datagrid('getSelections');
					if (getSelections_add.length == 0) {
						$.messager.alert('提示', '您还未选择需要上架的商品！', 'info');
						return;
					}
					if (getSelections_add[0].status == "0") {
						$.messager.alert('提示', '该物资以及上架了！', 'info');
						return;
					}
					$.messager.confirm('确认框', '您确认需要上架该物资吗？', function(r) {
						if (r) {
							$.ajax({
								type : 'POST',
								url : '${pageContext.request.contextPath}/materialInfo/addGoods',
								data : {
									"id" : getSelections_add[0].goodsId,
								},
								success : function(msg) {
									if (msg == "yes") {
										$.messager.show({
											title : '消息',
											msg : '该物资上架成功!',
											timeout : 3000,
											showType : 'slide'
										});
									}
									if (msg == "no") {
										$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
									}
									//更新数据表格
									$('#mInfo').datagrid('reload');
								}
							});
						}
					});
				}
			}
		//------------------------------------------------------------------------------------------------------------------------
		]
	});

	function convert(rows) {
		//父选项集合
		var nodes = [];
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if (exists(rows, rows[i].ptId) == false) {
				//为false就是父选项
				nodes.push({
					id : row.typeId,
					text : row.typeName,
				});
			}
		}
		//拷贝父选项
		var toDo = [];
		for (var i = 0; i < nodes.length; i++) {
			toDo.push(nodes[i]);
		}
		while (toDo.length) {
			//用完后删除
			var node = toDo.shift();
			for (var i = 0; i < rows.length; i++) {
				var row = rows[i];
				if (row.ptId == node.id) {
					var child = {
						id : row.typeId,
						text : row.typeName,
					};
					if (node.children) {
						node.children.push(child);
					} else {
						node.children = [ child ];
					}
					toDo.push(child);
				}
			}
		}
		return nodes;
	}

	//如果父类型id与本身类型的id系统，则添加为顶层父选项
	function exists(rows, ptId) {
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].typeId == ptId) {
				//不是父选项
				return true;
			}
		}
		return false;
	}

	//填充数据
	function dataPopulation(msg) {
		//添加物资时调用
		if (msg == "0") {
			$('#add_treeType').combotree({
				width : 200,
				url : '${pageContext.request.contextPath}/materialInfo/queryGoodsType',
				loadFilter : function(rows) {
					return convert(rows);
				},
				panelHeight : 'auto',
				//当用户在选择一个节点之前就触发
				onBeforeSelect : function(node) {
					//判断是否为叶节点
					return $(this).tree('isLeaf', node.target);
				}
			});
			return;
		}
		//文本数据填充
		$('#up_brand').val(msg.brand);
		$('#up_company').val(msg.company);
		$('#up_description').val(msg.description);
		$('#up_upStore').val(msg.upStore);
		$('#up_floorStore').val(msg.floorStore);
		//类型数据填充
		$('#treeType').combotree({
			width : 200,
			url : '${pageContext.request.contextPath}/materialInfo/queryGoodsType',
			loadFilter : function(rows) {
				return convert(rows);
			},
			panelHeight : 'auto',
			onLoadSuccess : function(node, data) {
				//默认选中之前应该判断是否存在
				var trssValues = $('#treeType').combotree('tree');
				var typeIdObject = $(trssValues).tree('find', msg.typeId);
				if (typeIdObject == null) {
					$.messager.alert('提示', '该物资类型已经被禁用，建议更换其他类型！', 'info');
					return;
				}
				//让节点默认选中
				$('#treeType').combotree('setValue', msg.typeId);
			},
			//当用户在选择一个节点之前就触发
			onBeforeSelect : function(node) {
				//判断是否为叶节点
				return $(this).tree('isLeaf', node.target);
			}
		});
	}
</script>
<div id="mainInfogoos" style="display: block;width: 100%;height: 100%">
	<div id="mInfo"></div>
</div>

