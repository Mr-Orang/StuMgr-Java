<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#sale').datagrid({
						title:name,
						fixed:true,
						fitColumns:true,
						columns:[[
							{
								field:'sts_id',
								title:'编号',
								width:100
							},
							{
								field:'te_name',
								title:'市场人员姓名',
								width:100
							},
							{
								field:'sts_sourceNmber',
								title:'生源人数',
								width:100
							},
							{
								field:'sts_applyCount',
								title:'报名人数',
								width:100
							},	
							{
								field:'sts_enrollment',
								title:'报名率',
								width:100
							},
						]],
						toolbar: [{
							iconCls:'icon-add',
							text:'查看生源地区/院校统计招生情况',
							handler:function(){
								$('<div id="window"></div>').window({
									title:'生源地区/院校统计招生情况',
									width:600,
									height:400,
									modal:true,
									collapsible:false,
									maximizable:false,
									minimizable:false,
									draggable:false,
									href:'${pageContext.request.contextPath}/marketing/page/statisticsSchool.jsp',
									onClose : function() {
										$(this).window("destroy");
									}
								})
							},
						}],
					   singleSelect:true,
					   rownumbers:true,
					   url:'${pageContext.request.contextPath }/querySale',
					   pagination:true,
					   pageList:[5,10,15,20],
				   	   pageSize:5,
				   	  pageNumber:1,
				   	  pagePosition:'bottom',
		})
	})

</script>
<div id="sale">
</div>
