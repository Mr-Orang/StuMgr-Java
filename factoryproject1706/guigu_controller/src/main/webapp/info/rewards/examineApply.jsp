<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 审批学生详情jsp -->
<script type="text/javascript">
		$(function(){
			$('#queryStudentApplyInfo').datagrid({
				fitColumns : true,
				columns : [ 
				[
					{
						field : 'stu_name',
						title : '学生姓名',
						width : 110,
					},
					{
						field : 'stu_sex',
						title : '学生性别',
						width : 110
					},
					{
						field : 'tc_name',
						title : '班级名称',
						width : 110
					},
					{
						field : 'te_name',
						title : '举荐人名字',
						width : 110
					},
					{
						field : 'rewards_apply_time',
						title : '申请日期',
						width : 170,
						formatter: function(value){
								return  value.substr(0,19);
							}
					},
					{
						field : 'rewards_type',
						title : '奖惩类型',
						width : 110,
						formatter: function(value){
								if (value=='0'){
									return '奖';
								} else {
									return '罚';
								}
							}
					},
					{
						field : 'rewards_apply_reason',
						title : '奖惩详情',
						width : 180,
						formatter: function(value){
								return '<a title='+value+' class="easyui-tooltip">'+value+'</a>';
							}
					}
				] ],
				collapsible : false,
				maximizable : false,
				minimizable : false,
				url : '${pageContext.request.contextPath }/queryStudentApplyInfo.action?rewardsid='+${param.rewardsid },
				pagination : true,
				pageList : [ 5, 10, 15, 20 ],
				pageSize : 5,
				pageNumber : 1,
				pagePosition : 'bottom',
				toolbar : []
			});
		})
		
</script>
<div id="queryStudentApplyInfo"></div>