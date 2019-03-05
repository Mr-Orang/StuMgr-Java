<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 自己写的js -->
<script type="text/javascript">
	$(function() {
		kaoqinstu = {
			//早退
			kaoqinzaotui : function() {
				//考勤学生编号
				var kaoqinselect = "";
				//ty_yesno是否已考勤
				var yesnokaoqin = 1;
				var status = 2;
				var rowlit = $('#studentkaoqin').datagrid('getRows');
				if (rowlit == 0) {
					$.messager.alert('消息', '请先选定学生');
					return;
				}
				//考勤班级编号
				var kaoqinclasssObj = $("#studentkaoqin").datagrid("getSelected");
				var kaoqinclassid = kaoqinclasssObj.class_id;
				//考勤学生 编号
				var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
				for (var i = 0; i < getSelectstukaoqin.length; i++) {
					kaoqinselect += getSelectstukaoqin[i].stu_id + ",";
				}
				//考勤班级编号
				//var classidkaoqin = '${param.row}';
				//考勤类型编号
				var kaoqintype = '${param.kaoqinglx}';
				//alert(kaoqinclassid + "," + kaoqintype + "," + yesnokaoqin + "," + kaoqinselect + "," + status);
				$.ajax({
					type : 'POST',
					url : 'kaoqin/kaoqininsert.action',
					data : {
						'class_id' : kaoqinclassid,
						'type_id' : kaoqintype,
						'ty_yesno' : yesnokaoqin,
						'stu_id' : kaoqinselect,
						'status' : status
					},
					success : function(data) {
						if (data.trim() == "考勤成功") {
							$.messager.confirm('确认对话框', '本次考勤已完成,本班级考勤完毕？', function(r) {
								if (r) {
									$("#win").window("close");
								}
								var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
								if (getSelectstukaoqin.length > 0) {
									for (var i = 0; i < getSelectstukaoqin.length; i++) {
										var index = $("#studentkaoqin").datagrid('getRowIndex', getSelectstukaoqin[i]);
										$('#studentkaoqin').datagrid('deleteRow', index);
									}
								}
							});
						}
					}
				});
			},
			//旷课
			kaoqinkuanke : function() {
				//考勤学生编号
				var kaoqinselect = "";
				//ty_yesno是否已考勤
				var yesnokaoqin = 1;
				var status = 3;
				var rowlit = $('#studentkaoqin').datagrid('getRows');
				if (rowlit == 0) {
					$.messager.alert('消息', '请先选定学生');
					return;
				}
				//考勤班级编号
				var kaoqinclasssObj = $("#studentkaoqin").datagrid("getSelected");
				var kaoqinclassid = kaoqinclasssObj.class_id;
				//考勤学生 编号
				var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
				for (var i = 0; i < getSelectstukaoqin.length; i++) {
					kaoqinselect += getSelectstukaoqin[i].stu_id + ",";
				}
				//考勤班级编号
				//var classidkaoqin = '${param.row}';
				//考勤类型编号
				var kaoqintype = '${param.kaoqinglx}';
				//alert(kaoqinclassid + "," + kaoqintype + "," + yesnokaoqin + "," + kaoqinselect + "," + status);
				$.ajax({
					type : 'POST',
					url : 'kaoqin/kaoqininsert.action',
					data : {
						'class_id' : kaoqinclassid,
						'type_id' : kaoqintype,
						'ty_yesno' : yesnokaoqin,
						'stu_id' : kaoqinselect,
						'status' : status
					},
					success : function(data) {
						if (data.trim() == "考勤成功") {
							$.messager.confirm('确认对话框', '本次考勤已完成,本班级考勤完毕？', function(r) {
								if (r) {
									$("#win").window("close");
								}
								var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
								if (getSelectstukaoqin.length > 0) {
									for (var i = 0; i < getSelectstukaoqin.length; i++) {
										var index = $("#studentkaoqin").datagrid('getRowIndex', getSelectstukaoqin[i]);
										$('#studentkaoqin').datagrid('deleteRow', index);
									}
								}
							});
						}
					}
				});
			},
			//请假
			kaoqinqinjia : function() {
				//考勤学生编号
				var kaoqinselect = "";
				//ty_yesno是否已考勤
				var yesnokaoqin = 1;
				var status = 4;
				var rowlit = $('#studentkaoqin').datagrid('getRows');
				if (rowlit == 0) {
					$.messager.alert('消息', '请先选定学生');
					return;
				}
				//考勤班级编号
				var kaoqinclasssObj = $("#studentkaoqin").datagrid("getSelected");
				var kaoqinclassid = kaoqinclasssObj.class_id;
				//考勤学生 编号
				var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
				for (var i = 0; i < getSelectstukaoqin.length; i++) {
					kaoqinselect += getSelectstukaoqin[i].stu_id + ",";
				}
				//考勤班级编号
				//var classidkaoqin = '${param.row}';
				//考勤类型编号
				var kaoqintype = '${param.kaoqinglx}';
				//alert(kaoqinclassid + "," + kaoqintype + "," + yesnokaoqin + "," + kaoqinselect + "," + status);
				$.ajax({
					type : 'POST',
					url : 'kaoqin/kaoqininsert.action',
					data : {
						'class_id' : kaoqinclassid,
						'type_id' : kaoqintype,
						'ty_yesno' : yesnokaoqin,
						'stu_id' : kaoqinselect,
						'status' : status
					},
					success : function(data) {
						if (data.trim() == "考勤成功") {
							$.messager.confirm('确认对话框', '本次考勤已完成,本班级考勤完毕？', function(r) {
								if (r) {
									$("#win").window("close");
								}
								var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
								if (getSelectstukaoqin.length > 0) {
									for (var i = 0; i < getSelectstukaoqin.length; i++) {
										var index = $("#studentkaoqin").datagrid('getRowIndex', getSelectstukaoqin[i]);
										$('#studentkaoqin').datagrid('deleteRow', index);
									}
								}
							});
						}
					}
				});
			},
			//迟到
			kaoqinchidao : function() {
				//考勤学生编号
				var kaoqinselect = "";
				//ty_yesno是否已考勤
				var yesnokaoqin = 1;
				var status = 1;
				var rowlit = $('#studentkaoqin').datagrid('getRows');
				if (rowlit == 0) {
					$.messager.alert('消息', '请先选定学生');
					return;
				}
				//考勤班级编号
				var kaoqinclasssObj = $("#studentkaoqin").datagrid("getSelected");
				var kaoqinclassid = kaoqinclasssObj.class_id;
				//考勤学生 编号
				var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
				for (var i = 0; i < getSelectstukaoqin.length; i++) {
					kaoqinselect += getSelectstukaoqin[i].stu_id + ",";
				}
				//考勤班级编号
				//var classidkaoqin = '${param.row}';
				//考勤类型编号
				var kaoqintype = '${param.kaoqinglx}';
				//alert(kaoqinclassid + "," + kaoqintype + "," + yesnokaoqin + "," + kaoqinselect + "," + status);
				$.ajax({
					type : 'POST',
					url : 'kaoqin/kaoqininsert.action',
					data : {
						'class_id' : kaoqinclassid,
						'type_id' : kaoqintype,
						'ty_yesno' : yesnokaoqin,
						'stu_id' : kaoqinselect,
						'status' : status
					},
					success : function(data) {
						if (data.trim() == "考勤成功") {
							$.messager.confirm('确认对话框', '本次考勤已完成,本班级考勤完毕？', function(r) {
								if (r) {
									$("#win").window("close");
								}
								var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
								if (getSelectstukaoqin.length > 0) {
									for (var i = 0; i < getSelectstukaoqin.length; i++) {
										var index = $("#studentkaoqin").datagrid('getRowIndex', getSelectstukaoqin[i]);
										$('#studentkaoqin').datagrid('deleteRow', index);
									}
								}
							});
						}
					}
				});
			},
			//全勤
			kaoqinquanqin : function() {
				//考勤学生编号
				var kaoqinselect = "";
				//ty_yesno是否已考勤
				var yesnokaoqin = 1;
				var status = 0;
				var rowlit = $('#studentkaoqin').datagrid('getRows');
				if (rowlit == 0) {
					$.messager.alert('消息', '请先选定学生');
					return;
				}
				//考勤班级编号
				var kaoqinclasssObj = $("#studentkaoqin").datagrid("getSelected");
				var kaoqinclassid = kaoqinclasssObj.class_id;
				//考勤学生 编号
				var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
				for (var i = 0; i < getSelectstukaoqin.length; i++) {
					kaoqinselect += getSelectstukaoqin[i].stu_id + ",";
				}
				//考勤班级编号
				//var classidkaoqin = '${param.row}';
				//考勤类型编号
				var kaoqintype = '${param.kaoqinglx}';
				//alert(kaoqinclassid + "," + kaoqintype + "," + yesnokaoqin + "," + kaoqinselect + "," + status);
				$.ajax({
					type : 'POST',
					url : 'kaoqin/kaoqininsert.action',
					data : {
						'class_id' : kaoqinclassid,
						'type_id' : kaoqintype,
						'ty_yesno' : yesnokaoqin,
						'stu_id' : kaoqinselect,
						'status' : status
					},
					success : function(data) {
						if (data.trim() == "考勤成功") {
							$.messager.confirm('确认对话框', '本次考勤已完成,本班级考勤完毕？', function(r) {
								if (r) {
									$("#win").window("close");
								}
								var getSelectstukaoqin = $("#studentkaoqin").datagrid("getSelections");
								if (getSelectstukaoqin.length > 0) {
									for (var i = 0; i < getSelectstukaoqin.length; i++) {
										var index = $("#studentkaoqin").datagrid('getRowIndex', getSelectstukaoqin[i]);
										$('#studentkaoqin').datagrid('deleteRow', index);
									}
								}
							});
						}
					}
				});
			},
		}
		$("#studentkaoqin").datagrid({
			fitColumns : true,
			columns : [ [
				{
					field : 'stu_id',
					title : '学生编号',
					width : 100,
				},
				{
					field : 'stu_name',
					title : '学生姓名',
					width : 100
				},
				{
					field : 'stu_sex',
					title : '学生性别',
					width : 100
				},
				{
					field : 'class_id',
					title : '所属班级',
					width : 100,
				}
			] ],
			collapsible : false,
			maximizable : false,
			minimizable : false,
			singleSelect : false,
			url : 'kaoqin/kaoqinStudent.action?kaoqinleixing=' + '${param.row}',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#dd'
		});
	})
</script>
<!-- 按钮 -->
<div id="anniukaoqin" style="height:41px;margin-top:12px;">
	<a class="easyui-linkbutton" iconCls="icon-redo"
		="true" onclick="kaoqinstu.kaoqinzaotui()">早退</a> <a
		class="easyui-linkbutton" iconCls="icon-no"
		="true" onclick="kaoqinstu.kaoqinkuanke()">旷课</a> <a
		class="easyui-linkbutton" iconCls="icon-mini-edit"
		="true" onclick="kaoqinstu.kaoqinqinjia()">请假</a> <a
		class="easyui-linkbutton" iconCls="icon-edit"
		="true" onclick="kaoqinstu.kaoqinchidao()">迟到</a> <a
		class="easyui-linkbutton" iconCls="icon-tip"
		="true" onclick="kaoqinstu.kaoqinquanqin()">全勤</a>
	<inpyt type="hidden" id="hiddentype" value="${param.kaoqinglx}" />
	<div id="abutton" id="readbutton" style="margin-left:70%;">
		所考勤班级:<label id="classkaoqin">${param.row}</label> & 本班级应到人数:<label
			id="classpeople">${param.rowtow}</label>
	</div>
</div>
<!-- 上面按钮  -->
<!-- 装显示学生信息 -->
<div id="studentkaoqin" style="height:210px;width:100%px;"></div>