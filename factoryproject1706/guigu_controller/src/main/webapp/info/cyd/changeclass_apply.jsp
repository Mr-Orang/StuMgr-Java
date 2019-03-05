<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		//申请表格
		$("#info_change_class_apply_datagrid").datagrid({
			fitColumns : true,
			height : 450,
			singleSelect : true,
			columns : [ [
				{
					title : '转班编号',
					field : 'tcc_id',
					width : 50,
				},
				{
					title : '学生姓名',
					field : 'stu_name',
					width : 50,
				},
				{
					title : '转入班级',
					field : 'in_classname',
					width : 80,
				},
				{
					title : '转出班级',
					field : 'out_classname',
					width : 80,
				},
				{
					title : '审核状态',
					field : 'in_status',
					width : 80,
					formatter:function(value,row,index){
						if(value==0){
							value="未审核";
						}else　if(value==1){
							value="同意";
						}else{
							value="不同意";
						}
						return value;
					}
				},
				{
					title : '申请时间',
					field : 'time',
					width : 100,
				},
				{
					title : '申请人',
					field : 'out_person',
					width : 50
				},
				{
					title : '操作',
					field : 'ddd',
					formatter : function(value, row, index) {
						var tcc_id = '"' + row.tcc_id + '"';
						return "<input type='button' value='详情' onclick='queryChangeClassDetails(" + tcc_id + ")'/>";
					},
					width : 100
				}
			] ],
			url : 'changeclassapply/queryChangeClassApply',
			pagination : true,
			pageList : [ 1, 5, 10 ],
			toolbar : '#info_change_class_toolbar'
		});

		//班级下拉框
		$("#info_change_class_apply_class").combobox({
			url : 'changeclassapply/queryClassByTeId',
			valueField : 'tc_id',
			textField : 'tc_name',
		});

		//班级下拉框改变事件
		$("#info_change_class_apply_class").combobox({
			onChange : function(newValue, oldValue) {
				$("#info_change_class_apply_datagrid").datagrid('load', {
					time : $("#info_apply_time").datebox('getValue').trim(),
					in_status : $("#info_change_class_in_status").val().trim(),
					out_classid : newValue
				});
			}
		});

	});

	//显示添加转班申请dialog
	function show_add_change_class_apply_dialog() {
		$("<div id='add_change_class_apply_dialog'></div>").dialog({
			title : '添加转班申请',
			width : 630,
			height : 400,
			maximizable : false,
			minimizable : false,
			collapsible : false,
			href : 'info/cyd/add_changeclass_apply.jsp',
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}
	;

	//根据点击的转班编号查询转班详情
	function queryChangeClassDetails(tcc_id) {
		$.ajax({
			type : 'post',
			url : 'changeclassapply/queryChangeClassByTccId',
			data : {
				'tcc_id' : tcc_id
			},
			success : function(data) {
				$("<div id='show_change_class_details_dialog'></div>").window({
					title : '转班申请详情',
					width : 630,
					height : 570,
					maximizable : false,
					minimizable : false,
					collapsible : false,
					href : 'info/cyd/changeclass_apply_details.jsp',
					queryParams : {
						stu_name : data[0].stu_name,
						in_classname : data[0].in_classname,
						out_classname : data[0].out_classname,
						put_reason : data[0].put_reason,
						out_person:data[0].out_person,
						in_person:data[0].in_person,
						in_reason:data[0].in_reason
					},
					onClose : function() {
						$(this).dialog('destroy');
					}
				});
			}
		});



	}
	;

	//条件查询
	queryApplyBySearch = function() {
		$("#info_change_class_apply_datagrid").datagrid('load', {
			time : $("#info_apply_time").datebox('getValue').trim(),
			in_status : $("#info_change_class_in_status").val().trim(),
			out_classid : $("#info_change_class_apply_class").combobox('getValue')
		});
	}

	$("#info_change_class_check_tabs").tabs({
		onSelect : function() {
			$("#info_change_class_check_tabs").panel({
				href : 'info/cyd/changeclass_check_datagrid.jsp'
			});
		}
	})
</script>

<div class="easyui-tabs">
	<div data-options="title:'转班申请'">
		<!-- 转班申请datagrid -->
		<div id="info_change_class_apply_datagrid"></div>

		<!-- 转班申请工具栏 -->
		<div id="info_change_class_toolbar">
			<div>
				<!-- 添加转班申请按钮 -->
				<button class="easyui-linkbutton" iconCls="icon-add"
					onclick="show_add_change_class_apply_dialog()" plain="true">添加转班申请
				</button>
				<label>转班状态</label> <select id="info_change_class_in_status"
					onchange="queryApplyBySearch()">
					<option value="">--请选择--</option>
					<option value="0">未审核</option>
					<option value="1">同意</option>
					<option value="2">不同意</option>
				</select> <label>班级</label><input id="info_change_class_apply_class"
					class="easyui-combobox" /> <label>申请时间</label><input type="text"
					id="info_apply_time" class="easyui-datebox" />
				<button class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="queryApplyBySearch()">搜索</button>
			</div>

		</div>
	</div>
	<div
		data-options="title:'转班审核',href:'info/cyd/changeclass_check_datagrid.jsp'"
		id="info_change_class_check_tabs"></div>
</div>

