<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function(){
			obj={
				closewindow:function(){
					$('#window').window('close');
				}
			},
			$('#school').datagrid({
						title:name,
						fixed:true,
						fitColumns:true,
						columns:[[
							{
								field:'tst_id',
								title:'编号',
								width:100
							},
							{
								field:'tst_academy',
								title:'生源地区/院校',
								width:100
							},
							{
								field:'tst_sourceNumber',
								title:'生源人数',
								width:100
							},
							{
								field:'tst_applyCount',
								title:'报名人数',
								width:100
							},	
							{
								field:'tst_enrollment',
								title:'报名率',
								width:100
							},
						]],
					   singleSelect:true,
					   rownumbers:true,
					   url:'${pageContext.request.contextPath }/querySchool',
					   pagination:true,
					   pageList:[5,10,15,20],
				   	   pageSize:5,
				   	  pageNumber:1,
				   	  pagePosition:'bottom',
		})
	})
</script>
<a class="easyui-linkbutton" iconCls="icon-save"
	onclick="obj.closewindow();">退出</a>
<div id="school">
</div>