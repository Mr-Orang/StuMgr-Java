<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function(){
		$("#dormData").datagrid({
			title : '宿舍信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'tdm_id',
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
					field : 'tss_bed',
					title : '床位',
					width : 200
				},
				{
					field : 'tss_nowbed',
					title : '实住床位',
					width : 200
				},
				{
					field : 'tss_state',
					title : '说明',
					width : 200,
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button onclick=dormObj.updateDorm('" + row.tss_id + "')>修改</button>&nbsp;";
					}
				}
			] ],
			//如果为true，则只允许选择一行。
			singleSelect : true,
			//如果为true，则显示一个行号列。
			rownumbers : true,
			url : '${pageContext.request.contextPath }/marketing/dorm/queryDorm',
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#dormBar'
		});
	
	});
</script>

<div id="dormData">
</div>