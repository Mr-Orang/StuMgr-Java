<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function() {
		boardObj = {
			updateBoard : function() {},
			searchBoard : function() {
				var stuName = $("#stuName").val();
				var classID = $("#classID").combobox("getValue");
				var dormID = $("#dormID").datebox("getValue");
				classID = (classID == "--请选择--" ? null : classID);
				dormID = (dormID == "--请选择--" ? null : dormID);
				$('#boardData').datagrid('load', {
					'stuName' : stuName,
					'classID' : classID,
					'dormID' : dormID,
				});
			},
			clearCondition : function() {
				var stuName = $("#stuName").val('');
				$("#classID").combobox("setValue", '--请选择--');
				$('#dormID').combobox('setValue', '--请选择--');
				boardObj.searchBoard();
			},
			addBoard : function() {
				$("<div id='addBoardWindow'></div>").window({
					closed : false,
					title : '新增住宿',
					width : 520,
					height : 350,
					modal : true,
					collapsible : false,
					maximizable : false,
					minimizable : false,
					draggable : true,
					href : '${pageContext.request.contextPath}/marketing/page/addBoard.jsp',
					/* queryParams : {
						'empID' : '${sessionScope.emplyee.te_id}'
					}, */
					onClose : function() {
						//销毁窗口
						$(this).window("destroy");
					}
				});
			},
		};
		$("#boardData").datagrid({
			title : '住宿信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'tbo_id',
					title : '宿舍ID',
					width : 200
				},
				{
					field : 'tdm_number',
					title : '宿舍编号',
					width : 200,
				//checkbox:true
				},
				{
					field : 'stu_name',
					title : '学生名称',
					width : 200
				},
				{
					field : 'tc_name',
					title : '班级名称',
					width : 200
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button onclick=boardObj.updateBoard('" + row.stu_id + "')>更换宿舍</button>&nbsp;";
					}
				}
			] ],
			//如果为true，则只允许选择一行。
			singleSelect : true,
			//如果为true，则显示一个行号列。
			rownumbers : true,
			url : '${pageContext.request.contextPath }/marketing/dorm/queryBoard',
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#boardBar'
		});
		$("#classID").combobox({
			url : '${pageContext.request.contextPath }/marketing/dorm/queryClass',
			valueField : 'tc_id',
			textField : 'tc_name',
			editable : false,
		});
		$("#classID").combobox("setValue", '--请选择--');
		$("#dormID").combobox({
			url : '${pageContext.request.contextPath }/marketing/dorm/queryDorm',
			valueField : 'tdm_id',
			textField : 'tdm_number',
			editable : false,
		});
		$("#dormID").combobox("setValue", '--请选择--');
	});
</script>
<div id="boardData"></div>
<div id="boardBar" style="display:none">
	<div style="margin:5px">
		<div style="margin:5px 0px 5px 8px">
			&nbsp;<a class="easyui-linkbutton" iconCls="icon-add"
				onclick="boardObj.addBoard()">新增住宿</a> &nbsp;&nbsp;学生姓名:<input
				id="stuName" /> &nbsp;&nbsp;班级名称:<input id="classID" />
			&nbsp;&nbsp;宿舍名称:<input id="dormID" /> &nbsp; &nbsp;<a
				class="easyui-linkbutton" iconCls="icon-search"
				onclick="boardObj.searchBoard()">搜索</a>&nbsp;&nbsp; <a
				class="easyui-linkbutton" iconCls="icon-remove"
				onclick="boardObj.clearCondition()">清空搜索条件</a>
		</div>
	</div>
</div>