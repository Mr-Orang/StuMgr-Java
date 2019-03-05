<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function() {
		addBoardObj = {
			save : function() {
				var stuList = $("#addBoardData").datagrid("getSelections");
				var stuIDs = [];
				$.each(stuList, function(index, row) {
					//console.log(index + "," + stuList[index].stu_id);
					stuIDs[index] = stuList[index].stu_id;
				});
				var tdmID = $("#dormCombobox").combobox("getValue");
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath }/marketing/dorm/addBoard',
					traditional : true,
					data : {
						'stuIDs' : stuIDs,
						'tdmID' : tdmID
					},
					success : function(data) {
						if (data == "ok") {
							alert("新增成功");
							$("#dormCombobox").combobox("setValue", '--请选择--');
							$("#dormTypeCombobox").combobox("setValue", '--请选择--');
							$("#classCombobox").combobox("setValue", '--请选择--');
							$("#ableNumber").html("");
							//$("#addBoardWindow").window("close");
							$("#addBoardData").datagrid('loadData', {
								total : 0,
								rows : []
							});
						} else {
							alert("新增住宿失败!!!");
						}
					}
				});
			},
			cancle : function() {
				$("#addBoardWindow").window("close");
			},
		};
		$("#addBoardData").datagrid({
			title : '学生信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'stu_id',
					title : '学生学号',
					width : 200
				},
				{
					field : 'stu_name',
					title : '学生姓名',
					width : 200,
				//checkbox:true
				},
				{
					field : 'stu_sex',
					title : '性别',
					width : 200
				},
				{
					field : 'address',
					title : '地址',
					width : 200,
				//checkbox:true
				},
				{
					field : 'tc_name',
					title : '班级名称',
					width : 200
				}
			] ],
			//如果为true，则只允许选择一行。
			singleSelect : false,
			//如果为true，则显示一个行号列。
			rownumbers : true,
			//url : '${pageContext.request.contextPath }/marketing/dorm/queryNotBoard',
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#addBoardBar'
		});
	});
	$("#classCombobox").combobox({
		url : '${pageContext.request.contextPath }/marketing/dorm/queryNotBoardClass',
		valueField : 'tc_id',
		textField : 'tc_name',
		editable : false,
	});
	$("#classCombobox").combobox("setValue", '--请选择--');
	$("#dormTypeCombobox").combobox({
		url : '${pageContext.request.contextPath }/marketing/dorm/queryDormType',
		valueField : 'tdm_typeID',
		textField : 'tdm_typeName',
		editable : false,
		onSelect : function(rec) {
			console.log(rec.tdm_typeName + ',' + $("#classCombobox").combobox("getValue"));
			$("#dormCombobox").combobox({
				url : '${pageContext.request.contextPath }/marketing/dorm/queryAbleChangeDorm?sex=' + rec.tdm_typeName + '&classID=' + $("#classCombobox").combobox("getValue") + '&tdmID=no',
				valueField : 'tdm_id',
				textField : 'tdm_number',
				editable : false,
				/* queryParams : {
					'sex' : rec.tdm_typeName,
					'classID' : $("#classCombobox").combobox("getValue"),
					'tdmID' : 'no'
				} */
				onSelect : function(rec2) {
					$("#addBoardData").datagrid({
						url : '${pageContext.request.contextPath }/marketing/dorm/queryBoardNoOK',
						queryParams : {
							'sex' : rec.tdm_typeName,
							'classID' : $("#classCombobox").combobox("getValue"),
						}
					});
					$.ajax({
						type : 'POST',
						url : '${pageContext.request.contextPath }/marketing/dorm/queryDormAbleNumber',
						data : {
							'tdm_id' : rec2.tdm_id
						},
						success : function(data) {
							$("#ableNumber").html(data);
						}
					});

				}
			});
			$("#dormCombobox").combobox("setValue", '--请选择--');

		}
	});
	$("#dormTypeCombobox").combobox("setValue", '--请选择--');
	$("#dormCombobox").combobox({
		/* url : '${pageContext.request.contextPath }/marketing/dorm/queryNotBoardClass',
		valueField : 'tc_id',
		textField : 'tc_name',
		editable : false, */
	});
	$("#dormCombobox").combobox("setValue", '--请选择--');
</script>
<div id="addBoardData"></div>
<div id="addBoardBar" style="display:none">
	<div style="margin:5px">
		<div style="margin:5px 0px 5px 8px">
			&nbsp;安排班级名称:<input id="classCombobox" /> &nbsp;安排宿舍类型:<input
				id="dormTypeCombobox" />&nbsp;选择宿舍:<input id="dormCombobox" />
			&nbsp;当前宿舍床位剩余&nbsp;&nbsp;<label id="ableNumber" style="color: red"></label>&nbsp;&nbsp;位<br />
			<label style="color: red">注:请先选择班级再选择宿舍类型，最后选择宿舍。</label> <br /> <a
				class="easyui-linkbutton" iconCls="icon-save"
				onclick="addBoardObj.save()">保存</a> <a class="easyui-linkbutton"
				iconCls="icon-cancle" onclick="addBoardObj.cancle();">取消</a>
		</div>
	</div>
</div>