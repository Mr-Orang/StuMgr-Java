<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function() {
		addBoardObj = {
			save : function() {},
		};
		$("#boardData").datagrid({
			title : '学生信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'stuID',
					title : '学生学号',
					width : 200
				},
				{
					field : 'stuName',
					title : '学生姓名',
					width : 200,
				//checkbox:true
				},
				{
					field : 'className',
					title : '班级名称',
					width : 200
				},
			] ],
			//如果为true，则只允许选择一行。
			singleSelect : false,
			//如果为true，则显示一个行号列。
			rownumbers : true,
			url : '${pageContext.request.contextPath }/marketing/dorm/queryNotBoard',
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#addBoardBar'
		});
	});
</script>
<div id="addBoardData"></div>
<div id="addBoardBar" style="display:none">
	<div style="margin:5px">
		<div style="margin:5px 0px 5px 8px">
			&nbsp;&nbsp;安排班级名称:<input id="classCombobox" />
			&nbsp;&nbsp;&nbsp;选择宿舍:<input id="dormCombobox" />
			&nbsp;&nbsp;&nbsp;<a class="easyui-linkbutton" iconCls="icon-search"
				onclick="addBoardObj.save()">保存</a>
		</div>
	</div>
</div>