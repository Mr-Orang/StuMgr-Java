<!-- 仓库信息管理 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 修改/下架仓库/区域/货架 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/materials/js/approveThePurchaseOfJs.js"></script>
<!-- 新增/仓库/区域/货架 -->
<script type="text/javascript">
	$(function() {
		$('#WarehouseInformationDisplay').datagrid({
			title : '仓库信息列表',
			singleSelect : true,
			url : '${pageContext.request.contextPath}/storeManagementController/queryListStore',
			fit : true,
			pagination : true,
			pageList : [ 5, 10 ],
			pageSize : 5,
			pageNumber : 1,
			rownumbers : true,
			view : detailview,
			fitColumns : true,
			columns : [ [
				{
					field : 'storeId',
					title : '仓库编号',
					width : 100
				},
				{
					field : 'address',
					title : '仓库地址',
					width : 100
				},
				{
					field : 'status',
					title : '仓库状态',
					width : 100,
					formatter : function(value, row, index) {
						return value == "0" ? "可用" : "不可用";
					}
				},
			] ],
			detailFormatter : function(rowIndex, rowData) {
				return "<div style='height: 300px'><table id='warehouseInfo_" + rowData.storeId + "'></table></div>";
			},
			onExpandRow : function(index, row) {
				var warehouseId = "#warehouseInfo_" + row.storeId;
				$(warehouseId).treegrid({
					url : '${pageContext.request.contextPath}/storeManagementController/loadAreaAndShelfInformation',
					idField : 'areaId',
					treeField : 'areaId',
					fitColumns : true,
					columns : [ [
						{
							field : 'areaId',
							title : '区域编号/货架编号',
							width : 100
						},
						{
							field : 'areaName',
							title : '区域名称',
							width : 100
						},
						{
							field : 'areaCount',
							title : '区域容量',
							width : 100
						},
						//---------------------------------------------------------------
						{
							field : 'positionName',
							title : '货架名称',
							width : 100
						},
						{
							field : 'positionCount',
							title : '货架容量',
							width : 100
						},
						{
							field : 'typeId',
							title : '存储类型',
							width : 100
						},
						{
							field : 'positionNumber',
							title : '存储数量',
							width : 100
						},
						{
							field : 'status',
							title : '状态',
							width : 100,
							formatter : function(value, row, index) {
								return value == "0" ? "可用" : "不可用";
							}
						},
					] ],
					queryParams : {
						storeId : row.storeId,
					},
				});
			},
			toolbar : [ {
				iconCls : 'icon-warehouseadd',
				text : '新增仓库/区域/货架',
				handler : function() {
					//选择信息
					var info = "<div id='AddWindowOfShelfInWarehouseArea'><div>"
						+ "<div style='margin-top: 20px;margin-left:30px;'>"
						+ "<h3>请选择需要增加的类型:</h3>"
						+ "<select id='WarehouseAreaShelf' class='easyui-combobox' style='width:120px;'>"
						+ "<option value='0'>仓库</option>"
						+ "<option value='1'>区域</option>"
						+ "<option value='2'>货架</option>"
						+ "</select>"
						+ "</div>"
						+ "<div>";
					//仓库
					info += "<div id='wa_warehouse' style='display: none;margin-left: 30px;margin-top: 20px'>"
						+ "请输入新仓库地址：<input type='text' id='warehourceName' style='width: 100px' onBlur='iswareName();'/><span id='warehource_Info'></span>"
						+ "</div>";
					//区域
					info += "<div id='wa_area' style='display: none;margin-left: 30px;margin-top: 20px;'>"
						+ "请选择仓库:&nbsp;&nbsp;&nbsp;<input id='choose_warehource'/>&nbsp;&nbsp;<br/><br/>输入区域名称:<input id='areaName' style='width:140px;' type='text' onblur='VerifyAreaName();'/><br/><br/>请输入区域容量:<input type='text' id='RegionalCapacity' style='width: 140px;'/><span id='warehourcename_Infogo'></span>"
						+ "</div>";
					//货架
					info += "<div id='wa_storageRack' style='display: none;margin-left: 30px;margin-top: 20px''>"
						+ "请选择仓库的区域：<input id='warehouseAndArea'/>&nbsp;&nbsp;&nbsp;<br/><br/>请输入货架名称：<input type='text' style='width:140px' id='warehouseAndArea_input' onblur='VerifyThatTheShelfNameIsValid();'/><span id='informationOnTheAreaOfWarehouseD'></span><br/><br/>请输入货架容量:<input type='text' id='shelfCapacity_input' style='width: 140px;'/><br/><br/>"
						+ "请选择货架存放类型:<div id='multi-selectionMaterialType'></div><br/>"
						+ "<span id='cargoCapacityPromptInformation'><span>"
						+ "</div>";
					info += "<button style='margin-left: 30px;margin-top: 20px;' id='warehouse_ConfirmToSubmit'>确认提交</button></div>";
					$(info).window({
						title : '新增仓库/区域/货架',
						collapsible : false,
						minimizable : false,
						maximizable : false,
						resizable : false,
						width : 500,
						height : 400,
						modal : true,
						onClose : function() {
							$(this).window("destroy");
						}
					});
					//加载仓库的区域
					$('#warehouseAndArea').combotree({
						url : '${pageContext.request.contextPath}/storeManagementController/aueryTheWarehouseAndArea',
						//定义为必填字段
						required : true,
						width : 140,
						onBeforeSelect : function(node) {
							var isLeaf = $('#warehouseAndArea').tree('isLeaf', node.target);
							if (!isLeaf) {
								return false;
							}
						},
						onChange : function(newValue, oldValue) {
							verifyThatTheShelfCapacityIsAvailable();
						}
					});
					//加载选择仓库
					$('#choose_warehource').combotree({
						url : '${pageContext.request.contextPath}/storeManagementController/queryWarehouseInformation',
						//定义为必填字段
						required : true,
						width : 140,
					});
					//加载物资类型的多选择
					$('#multi-selectionMaterialType').combotree({
						checkbox : true,
						width : 120,
						//设置复选框
						multiple : true,
						//设置只有叶节点可以多选
						onlyLeafCheck : true,
						url : '${pageContext.request.contextPath}/materialInfo/queryGoodsType',
						loadFilter : function(rows) {
							return wareconvert(rows);
						},
						panelHeight : 'auto',
						// 当用户在选择一个节点之前就触发
						onBeforeSelect : function(node) {
							//判断是否为叶节点
							return $(this).tree('isLeaf', node.target);
						}
					});
					$('#warehouse_ConfirmToSubmit').linkbutton({
						onClick : function() {
							//确认提交需要进行规则判断
							//获取用户选择的类型
							var getValue = $('#WarehouseAreaShelf').combotree('getValue');
							//-----------------------------------------添加仓库-----------------------------------------------------------------
							if (getValue == 0) {
								//添加仓库
								//判断字符串长度是否大于0
								var warehourceName = $('#warehourceName').val().trim();
								if (warehourceName.length == 0) {
									$.messager.alert('提示', '您还未输入仓库名称！', 'info');
									return;
								}
								//获取结果
								var boo = $('#TheWarehouseNamePromptsForTheId').text();
								if (boo == "可用") {
									//可用
									$.messager.confirm('提示', '您确定要新增仓库信息吗？', function(r) {
										if (r) {
											$.ajax({
												type : 'POST',
												url : '${pageContext.request.contextPath}/storeManagementController/addWarehouseInformation',
												data : {
													wareHouseName : warehourceName,
												},
												success : function(msg) {
													if (msg == "ok") {
														$.messager.show({
															title : '提示',
															msg : '新增仓库成功',
															timeout : 5000,
															showType : 'slide'
														});
														//关闭窗口
														$('#AddWindowOfShelfInWarehouseArea').window("close");
														//刷新数据表格
														$('#WarehouseInformationDisplay').datagrid("reload");
														return;
													}
													$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
												}
											});
										}
									});
								}
							}
							//-----------------------------------------添加仓库----------------------------------------------------------------------------
							//-----------------------------------------添加区域----------------------------------------------------------------------------
							if (getValue == 1) {
								//判断是否已经选中仓库
								var tree = $('#choose_warehource').combotree('tree');
								var data = tree.tree('getSelected');
								if (data == null) {
									$.messager.alert("提示", "您还未选中仓库", "info");
									return;
								}
								//判断是否已经输入区域名
								var areaName = $('#areaName').val().trim();
								if (areaName.length == 0) {
									$.messager.alert('提示', '您还未输入区域名称！', 'info');
									return;
								}
								//判断是否已经输入区域容量
								var RegionalCapacity = $('#RegionalCapacity').val().trim();
								if (RegionalCapacity.length == 0) {
									$.messager.alert('提示', '您还未输入区域容量！', 'info');
									return;
								}
								//判断用户输入的容量是否为数字
								var regex = /^[0-9]+.?[0-9]*$/;
								if (!regex.test(RegionalCapacity)) {
									$('#RegionalCapacity').val("");
									$.messager.alert('提示', '您输入的不是合法数字，请重新输入！', 'info');
									return;
								}
								var warehourcename_Infogo = $('#warehourcename_Infogo').text().trim();
								if (warehourcename_Infogo == "可用") {
									$.messager.confirm('提示', '您确定需要添加该仓库的区域吗？', function(r) {
										if (r) {
											/**
											 * 1.仓库id
											 * 2.区域名
											 * 3.区域容量
											 */
											$.ajax({
												type : 'POST',
												url : '${pageContext.request.contextPath}/storeManagementController/addedAreaStr',
												data : {
													id : data.id,
													name : areaName,
													capacity : RegionalCapacity,
												},
												success : function(msg) {
													if (msg == "ok") {
														$.messager.show({
															title : '提示',
															msg : '新增区域成功',
															timeout : 5000,
															showType : 'slide'
														});
														//关闭窗口
														$('#AddWindowOfShelfInWarehouseArea').window("close");
														//刷新数据表格
														$('#WarehouseInformationDisplay').datagrid("reload");
														return;
													}
													$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
												}
											});
										}
									});
								}
							}
							//----------------------------------------------------添加区域---------------------------------------------------------------
							if (getValue == 2) {
								/**
								 * 1.仓库id
								 * 2.区域id
								 * 3.货架容量
								 * 3.1.判断输入的容量是否为数字
								 * 3.2.判断输入的容量是否大于区域id
								 */
								var tree = $('#warehouseAndArea').combotree('tree');
								var data = tree.tree('getSelected');
								if (data == null) {
									$.messager.alert("提示", "您还未选中仓库的区域", "info");
									return;
								}
								var warehouseAndArea_input = $('#warehouseAndArea_input').val().trim();
								if (warehouseAndArea_input.length == 0) {
									$.messager.alert("提示", "您还未输入货架名称", "info");
									return;
								}
								//判断货架容量
								var shelfCapacity_input = $('#shelfCapacity_input').val().trim();
								if (shelfCapacity_input.length == 0) {
									$.messager.alert("提示", "您还未输入货架容量", "info");
									return;
								}
								//判断是否为数字
								var regex = /^[0-9]+.?[0-9]*$/;
								if (!regex.test(shelfCapacity_input)) {
									$('#shelfCapacity_input').val("");
									$.messager.alert("提示", "您输入的不是合法数字,请重新输入", "info");
									return;
								}
								//判断用户输入的容量是否大于异步传递过来
								var areaSize = $('#areaSize').text().trim();
								if (shelfCapacity_input > areaSize) {
									$.messager.alert("提示", "您输入的货架容量大于区域剩余容量，请重新调整！", "info");
									return;
								}
								//1.区域id
								//2.货架名称
								//3.货架容量
								//4.货架存放类型id
								var goodsTypeTress = $('#multi-selectionMaterialType').combotree('tree');
								var getChecked = goodsTypeTress.tree("getChecked");
								if (getChecked.length == 0) {
									$.messager.alert("提示", "您还未选择该货架可以存放的类型", "info");
									return;
								}
								var arrayTypeId = new Array();
								for (var i = 0; i < getChecked.length; i++) {
									arrayTypeId.push(getChecked[i].id);
								}
								$.messager.confirm('提示', '您确定要添加该区域得到货架吗？', function(r) {
									if (r) {
										$.ajax({
											type : 'POST',
											url : '${pageContext.request.contextPath}/storeManagementController/addShelf',
											traditional : true,
											data : {
												areaId : data.id,
												shelfName : warehouseAndArea_input,
												shelfCapacity : areaSize,
												goodsTypeId : arrayTypeId,
											},
											success : function(msg) {
												if (msg == "ok") {
													$.messager.show({
														title : '提示',
														msg : '添加货架成功',
														timeout : 3000,
														showType : 'slide'
													});
													//关闭窗口
													$('#AddWindowOfShelfInWarehouseArea').window("close");
													//刷新数据表格
													$('#WarehouseInformationDisplay').datagrid("reload");
													return;
												}
												$.messager.alert('提示', '服务器繁忙，请稍后再试！', 'info');
											}
										});
									}
								});
							}
						}
					});
					//添加更换数据的事件
					$('#WarehouseAreaShelf').combobox({
						onChange : function(newValue, oldValue) {
							//传递选择的类型值
							divNoneBlock(newValue);
						}
					});
					divNoneBlock(0);
				}
			}, {
				iconCls : 'icon-main_Modifythewarehouse',
				text : '修改仓库/区域/货架',
				handler : function() {
					warehouseObjectMethods.updateWarehouse();
				}
			}, {
				iconCls : 'icon-main_Warehouseshelves',
				text : '一键仓库甘特图生成',
			} ],
		});
	});

	//验证方法
	function proofTechnique(obj) {
		//根据用户选择的下拉框来选择相对应的验证方法
		if (obj == 0) {
			var warehourceName = $('#warehourceName').val().trim();
			if (warehourceName.length == 0) {
				$.messager.alert("提示", "您还未数据仓库名称", "info");
				return;
			}
		}
	}

	//切换视图
	function divNoneBlock(values) {
		$('#wa_warehouse').css("display", "none");
		$('#wa_area').css("display", "none");
		$('#wa_storageRack').css("display", "none");
		if (values == 0) {
			$('#wa_warehouse').css("display", "block");
		}
		if (values == 1) {
			$('#wa_area').css("display", "block");
		}
		if (values == 2) {
			$('#wa_storageRack').css("display", "block");
		}
	}

	//验证仓库取名
	function iswareName() {
		var name = $('#warehourceName').val().trim();
		if (name.length == 0) {
			$('#warehource_Info').html("<p id='TheWarehouseNamePromptsForTheId' style='color: red'>您还未输入仓库名称<p>");
			return;
		}
		//验证仓库取名是否有用
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/storeManagementController/verifyThatTheWarehouseNameIsUseful',
			data : {
				name : name,
			},
			success : function(msg) {
				if (msg == "ok") {
					$('#warehource_Info').html("<p id='TheWarehouseNamePromptsForTheId' style='color: green'>可用<p>");
				} else {
					$('#warehource_Info').html("<p id='TheWarehouseNamePromptsForTheId' style='color: red'>不可用<p>");
				}
			}
		});
	}

	//验证区域名称
	function VerifyAreaName() {
		//获取区域名称
		var warehourcename_Infogo = $('#areaName').val().trim();
		if (warehourcename_Infogo.length == 0) {
			$('#warehourcename_Infogo').html("<p id='WarehousePrompts' style='color: red'>您还未输入区域名称<p>");
			return;
		}
		var tree = $('#choose_warehource').combotree('tree');
		var data = tree.tree('getSelected');
		if (data == null) {
			$('#warehourcename_Infogo').html("<p id='WarehousePrompts' style='color: red'>不可用<p>");
			return;
		}
		//验证仓库取名是否有用
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/storeManagementController/verifyThatTheRegionNameIsAvailable',
			data : {
				name : warehourcename_Infogo,
				wareName : data.id,
			},
			success : function(msg) {
				if (msg == "ok") {
					$('#warehourcename_Infogo').html("<p id='WarehousePrompts' style='color: green'>可用<p>");
				} else {
					$('#warehourcename_Infogo').html("<p id='WarehousePrompts' style='color: red'>不可用<p>");
				}
			}
		});
	}

	//验证货架名称是否有效
	function VerifyThatTheShelfNameIsValid() {
		/**
		 * 区域编号
		 * 货架名称
		 */
		var warehouseAndArea_input = $('#warehouseAndArea_input').val().trim();
		var tree = $('#warehouseAndArea').combotree('tree');
		var data = tree.tree('getSelected');
		if (data == null) {
			$('#informationOnTheAreaOfWarehouseD').html("<p id='shelfInformation' style='color: red'>不可用<p>");
			return;
		}
		if (warehouseAndArea_input.length == 0) {
			$('#informationOnTheAreaOfWarehouseD').html("<p id='shelfInformation' style='color: red'>您还未输入货架名称<p>");
			return;
		}
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/storeManagementController/verifyThatTheShelfNameIsValid',
			data : {
				areaId : data.id,
				nameOfShelfM : warehouseAndArea_input,
			},
			success : function(msg) {
				if (msg == "ok") {
					$('#informationOnTheAreaOfWarehouseD').html("<p id='shelfInformation' style='color: green'>可用<p>");
				} else {
					$('#informationOnTheAreaOfWarehouseD').html("<p id='shelfInformation' style='color: red'>不可用<p>");
				}
			}
		});
	}

	//获取区域容量
	function verifyThatTheShelfCapacityIsAvailable() {
		//区域id
		var warehouseAndArea_input = $('#warehouseAndArea_input').val().trim();
		var tree = $('#warehouseAndArea').combotree('tree');
		var data = tree.tree('getSelected');
		$.ajax({
			type : 'POST',
			url : '${pageContext.request.contextPath}/storeManagementController/queryAreaCapacityInformation',
			data : {
				areaName : data.id,
			},
			success : function(msg) {
				if (msg == "0") {
					$('#cargoCapacityPromptInformation').html("<p id='warehouseCapacityPromptInformation' style='color: red'>该区域没有可用容量,请更换区域,或修改该区域容量</p>");
					//不可编辑
					$('#shelfCapacity_input').val("");
					$('#warehouseAndArea_input').val("");
					$('#warehouseAndArea_input').attr("disabled", "disabled");
					$('#shelfCapacity_input').attr("disabled", "disabled");
				} else {
					$('#cargoCapacityPromptInformation').html("<p id='warehouseCapacityPromptInformation' style='color:green'>该区域的可用容量为:<span id='areaSize'>" + msg + "</span></p>");
					//可写
					$("#shelfCapacity_input").removeAttr("disabled");
					$("#warehouseAndArea_input").removeAttr("disabled");
				}
			}
		});
	}

	function wareconvert(rows) {
		//父选项集合
		var nodes = [];
		for (var i = 0; i < rows.length; i++) {
			var row = rows[i];
			if ((rows, rows[i].ptId) == false) {
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
</script>
<!-- 仓库信息展示 -->
<div id="WarehouseInformationDisplay"></div>


