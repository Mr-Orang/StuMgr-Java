/**
 * 修改仓库/区域/货架
 */
$(function() {
	warehouseObjectMethods = {
		updateWarehouse : function() {
			//加载window窗口
			var info = "<div id='modifywarehousewindow'><div style='margin-left:40px;'>"
				+ "<h3>请在下拉框中选择需要修改的仓库/区域/货架</h3>"
				+ "<input id='modifyshelvesinwarehousearea'></input>"
				+ "</div><br/><br/>"
				+ '<div id="modifythewarehouse" style="display:none;margin-left:40px;"><br/>'
				+ '<h3>仓库地址：</h3><input type="text" id="storeName" value="" /><br/><br/>'
				+ '<h3>仓库状态：</h3><input name="stateofwarehouse" type="radio" value="0" />可用  <input type="radio" name="stateofwarehouse"  value="1"/>不可用<br/><br/><br/>'
				+ '<span id="storeIdInfos"></span>'
				+ '<button id="confirmmodificationwarehouse">提交修改</button>'
				+ '</div>'
				+ '<div id="modifierarea" style="display:none;margin-left:40px;">'
				+ '<h3>区域名称</h3><input type="text" id="areaName"/><br/>'
				+ '<h3>区域容量</h3><input type="number" id="areacapacity"/><br/>'
				+ '<span id="minimummodifiablecapacity"></span>'
				+ '<h3>区域状态</h3><input name="areaStatus" type="radio" value="0" />可用  <input type="radio" name="areaStatus"  value="1"/>不可用<br/><br/>'
				+ '<span id="areaprompt"></span><br/>'
				+ '<button id="submitchangestoareainformation">提交修改</button>'
				+ '</div>'
				+ '<div id="modifyshelf" style="display:none;margin-left:40px;"><br/>'
				+ '<h3>货架名称</h3><input type="text" id="nameofshelves"/><br/>'
				+ '<h3>货架容量</h3><input type="number" id="theshelfcapacity"></br>'
				+ '<span id="hintformaximumshelfcapacity"></span>'
				+ '<h3>货架存储数量</h3><input type="number" id="shelfstoragequantity"></br>'
				+ '<h3>货架存放物资类型</h3><input id="shelfstoragetype" /><br/>'
				+ '<span id="whetherthetypecanbemodified"></span>'
				+ '<h3>货架状态</h3><input name="stateoftheshelves" type="radio" value="0" />可用<input type="radio" name="stateoftheshelves" value="1"/>不可用<br/>'
				+ '<button id="modifytheshelfinformationbutton">提交修改</button>'
				+ '</div></div>';
			$(info).window({
				title : '修改仓库/区域/货架',
				width : 600,
				height : 600,
				minimizable : false,
				maximizable : false,
				collapsible : false,
				modal : true,
				onClose : function() {
					$(this).window('destroy');
				}
			});
			//加载修改仓库/区域/货架的树形下拉框
			$('#modifyshelvesinwarehousearea').combotree({
				width : 200,
				animate : true,
				lines : true,
				cascadeCheck : false,
				url : '/storeManagementController/modifyshelvesinwarehousearea',
				onSelect : function(node) {
					//判断仓库/区域/货架
					var str = node.id;
					str = str.substring(0, str.indexOf("_"));
					showViewing();
					if (str.length == 7) {
						$('#modifythewarehouse').css("display", "block");
						//查询仓库信息
						$.ajax({
							type : 'POST',
							url : '/storeManagementController/queryStoresone',
							data : "storeId=" + node.id,
							success : function(msg) {
								//填充仓库地址
								$('#storeName').val(msg.address);
								//默认让仓库选中状态
								if (msg.status == 0) {
									$('input[name=stateofwarehouse]:eq(0)').attr("checked", 'checked');
								} else {
									$('input[name=stateofwarehouse]:eq(1)').attr("checked", 'checked');
								}
								//提示是否可以修改状态
								if (msg.storeId != 0) {
									$('#storeIdInfos').html("<p style='color:red'>不可更改仓库状态(该仓库的区域为可用)</p>");
									$('input[name=stateofwarehouse]').attr('disabled', 'disabled');
								} else {
									$('#storeIdInfos').html("<p style='color:green'>可更改仓库状态</p>");
								}
							}
						});
						//加载仓库确认提交框
						$('#confirmmodificationwarehouse').linkbutton({
							onClick : function() {
								$.messager.confirm('提示', '您确定要提交仓库的修改信息吗？', function(r) {
									//仓库id
									//仓库名称
									//仓库状态
									if ($('#storeName').val().trim().length == 0) {
										$.messager.alert('提示', '您还未输入仓库地址', 'info');
										return;
									}
									if (r) {
										$.ajax({
											type : 'POST',
											data : {
												storeId : node.id,
												address : $('#storeName').val(),
												status : $('input[type=radio][name=stateofwarehouse]:checked').val()
											},
											url : '/storeManagementController/warehouseinformationmodificationsubmission',
											success : function(msg) {
												if (msg == "ok") {
													$.messager.show({
														title : '提示',
														msg : '修改仓库信息成功',
														timeout : 5000,
														showType : 'slide'
													});
													//刷新表格
													$('#WarehouseInformationDisplay').datagrid('reload');
													//关闭窗口
													$('#modifywarehousewindow').window('close');
												}
											}
										});
									}
								});
							}
						});
					}
					if (str.length == 6) {
						$('#modifierarea').css("display", "block");
						$.ajax({
							type : 'POST',
							url : '/storeManagementController/queryAreaOne',
							data : 'id=' + node.id,
							success : function(msg) {
								//填充区域名称
								$('#areaName').val(msg.areaName);
								//填充区域容量
								$('#areacapacity').val(msg.areaCount);
								//填充区域状态
								if (msg.status == 0) {
									$('input[name=areaStatus]:eq(0)').attr("checked", 'checked');
								} else {
									$('input[name=areaStatus]:eq(1)').attr("checked", 'checked');
								}
								//填充修改该区域容量的最低容量
								$('#minimummodifiablecapacity').html('<p style="color:red">该区域可修改的容量最低不能小于：<span id="theminimumcapacity">' + msg.storeId + '</span></p>');
								//判断是否可以修改区域状态
								if (msg.typeId != 0) {
									$('#areaprompt').html('<p style="color:red">不可更改区域状态(该区域的货架为可用)</p>');
									$('input[name=areaStatus]').attr('disabled', 'disabled');
								} else {
									$('#areaprompt').html('<p style="color:green">可更改仓库状态</p>');
								}
							}
						});
						//加载区域确认提交框
						$('#submitchangestoareainformation').linkbutton({
							onClick : function() {
								$.messager.confirm('提示', '您确定要提交区域的修改信息吗？', function(r) {
									//区域名称
									//区域容量
									//区域状态
									if ($('#areaName').val().trim().length == 0) {
										$.messager.alert('提示', '您还未输入区域名称', 'info');
										return;
									}
									var regex = /^[0-9]*[1-9][0-9]*$/
									if (!regex.test($('#areacapacity').val())) {
										$.messager.alert('提示', '您输入的区域容量不合法，请重新输入', 'info');
										return;
									}
									//实际值
									var under = $('#areacapacity').val().trim();
									//最小值
									var exceed = $('#theminimumcapacity').html().trim();

									if (under < exceed) {
										$.messager.alert('提示', '修改区域的容量不能小于' + exceed + '', 'info');
										return;
									}
									if (r) {
										$.ajax({
											type : 'POST',
											data : {
												areaId : node.id,
												areaName : $('#areaName').val(),
												areaCount : under,
												status : $('input[type=radio][name=areaStatus]:checked').val()
											},
											url : '/storeManagementController/areainformationmodificationsubmission',
											success : function(msg) {
												if (msg == "ok") {
													$.messager.show({
														title : '提示',
														msg : '修改区域信息成功',
														timeout : 5000,
														showType : 'slide'
													});
													//刷新表格
													$('#WarehouseInformationDisplay').datagrid('reload');
													//关闭窗口
													$('#modifywarehousewindow').window('close');
												}
											}
										});
									}
								});
							}
						});
					}
					if (str.length == 10) {
						$('#modifyshelf').css("display", "block");
						$.ajax({
							type : 'POST',
							url : '/storeManagementController/queryStoreAreaPosition',
							data : 'id=' + node.id,
							success : function(msg) {
								//填充货架名称
								$('#nameofshelves').val(msg.positionName);
								//填充货架容量
								$('#theshelfcapacity').val(msg.positionCount);
								//填充存储数量
								$('#shelfstoragequantity').val(msg.positionNumber);
								//填充货架状态
								if (msg.status == 0) {
									$('input[name=stateoftheshelves]:eq(0)').attr("checked", 'checked');
								} else {
									$('input[name=stateoftheshelves]:eq(1)').attr("checked", 'checked');
								}
								//填充最大货架容量
								$('#hintformaximumshelfcapacity').html("<p style='color:red'>可修改的最大货架容量为:<span id='maximumshelfcapacitythatcanbemodified'>" + msg.areaId + "</span></p>");
								//加载物资类型
								$('#shelfstoragetype').combotree({
									width : 200,
									url : '/materialInfo/queryGoodsType',
									loadFilter : function(rows) {
										return convert(rows);
									},
									onBeforeSelect : function(node) {
										return $(this).tree('isLeaf', node.target);
									},
									onLoadSuccess : function(node, data) {
										$('#shelfstoragetype').combotree('setValue', msg.typeId);
									}
								});
								//是否禁用切换类型的组件
								if (msg.positionNumber == 0) {
									$('#whetherthetypecanbemodified').html('<p style="color:green">可以修改该货架物资类型</p>');
								} else {
									$('#whetherthetypecanbemodified').html('<p style="color:red">无法修改该货架的物资类型(该货架存放有物资)</p>');
									$('#shelfstoragetype').combotree('disable');
								}
							}
						});
						//加载区域确认提交框
						$('#modifytheshelfinformationbutton').linkbutton({
							onClick : function() {
								$.messager.confirm('提示', '您确定要提交货架的修改信息吗？', function(r) {
									//货架名称
									//货架容量
									//货架存储数量
									//货架状态
									if ($('#nameofshelves').val().trim().length == 0) {
										$.messager.alert('提示', '您还未输入货架名称', 'info');
										return;
									}
									//									var regex = /^[0-9]*[1-9][0-9]*$/
									//									if (!regex.test($('#theshelfcapacity').val())) {
									//										$.messager.alert('提示', '您输入的货架容量不合法，请重新输入', 'info');
									//										return;
									//									}
									//									var regex2 = /^\\d+$/;
									//									if (!regex2.test($('#shelfstoragequantity').val())) {
									//										$.messager.alert('提示', '您输入的货架存储数量不合法，请重新输入', 'info');
									//										return;
									//									}
									//判断货架容量是否超出总容量之和
									if ($('#theshelfcapacity').val() > $('#maximumshelfcapacitythatcanbemodified').html().trim()) {
										$.messager.alert('提示', '该货架容量超标，请修改！', 'info');
										return;
									}
									//判断货架存储数量是否大于货架容量
									var theshelfcapacity = parseInt($('#theshelfcapacity').val());
									var shelfstoragequantity = parseInt($('#shelfstoragequantity').val());
//									if (shelfstoragequantity < shelfstoragequantity) {
//										$.messager.alert('提示', '货架容量不能大于存储数量', 'info');
//										return;
//									}
									if (r) {
										/**
										 * 货架编号
										 * 货架名称
										 * 货架容量
										 * 货架存储数量
										 * 货架存放物资类型编号
										 * 货架状态
										 */
										$.ajax({
											type : 'POST',
											data : {
												positionId : node.id,
												positionName : $('#nameofshelves').val(),
												positionCount : $('#theshelfcapacity').val(),
												positionNumber : $('#shelfstoragequantity').val(),
												typeId : $('#shelfstoragetype').combotree('getValue'),
												status : $('input[type=radio][name=stateoftheshelves]:checked').val()
											},
											url : '/storeManagementController/shelfInformationModification',
											success : function(msg) {
												if (msg == "ok") {
													$.messager.show({
														title : '提示',
														msg : '修改货架信息成功',
														timeout : 5000,
														showType : 'slide'
													});
													//刷新表格
													$('#WarehouseInformationDisplay').datagrid('reload');
													//关闭窗口
													$('#modifywarehousewindow').window('close');
												}
											}
										});
									}
								});
							}
						});
					}
				}
			});
		},
	}
});
//将视图全部英寸
function showViewing() {
	$('#modifythewarehouse').css("display", "none");
	$('#modifierarea').css("display", "none");
	$('#modifyshelf').css("display", "none");
}
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