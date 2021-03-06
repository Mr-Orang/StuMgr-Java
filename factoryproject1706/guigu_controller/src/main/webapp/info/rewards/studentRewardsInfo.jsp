<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
		$(function(){
			$('#queryStudentApply').datagrid({
				fitConlumn : true,
				columns : [ 
				[
					{
						field : 'stu_name',
						title : '学生姓名',
						width : 100,
					},
					{
						field : 'stu_sex',
						title : '学生性别',
						width : 100
					},
					{
						field : 'tc_name',
						title : '班级名称',
						width : 100
					},
					{
						field : 'rewards_type',
						title : '奖惩类型',
						width : 100,
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
						title : '奖惩原因',
						width : 190,
						formatter: function(value){
								return '<a title='+value+' class="easyui-tooltip">'+value+'</a>';
							}
					},
					{
						field : 'rewards_apply_time',
						title : '申请日期',
						width : 130,
						formatter: function(value){
								return  value.substr(0,19);
							}
					},
					{
						field : 'rewards_time',
						title : '审批日期',
						width : 130,
						formatter: function(value){
								if(value==null){
									return null;
								}else{
									return  value.substr(0,19);
								}
							}
					},
					{
						field : 'te_name',
						title : '审批人',
						width : 100
					},
					{
						field : 'rewards_status',
						title : '审批状态',
						width : 100,
						formatter: function(value){
							if(value=='0'){
								return '审批中';
							}else if(value=='1'){
								return '同意';
							}else(value=='2')
								return '不同意';
							}
					},
					{
						field : 'rewards_reason',
						title : '不同意原因',
						width : 190,
						formatter: function(value){
								if(value==null){
									return '无';
								}else{
									return '<a title='+value+' class="easyui-tooltip">'+value+'</a>';
								}
							}
					}
				] ],
				collapsible : false,
				maximizable : false,
				minimizable : false,
				singleSelect : true,
				url : '${pageContext.request.contextPath }/queryStudent.action',
				pagination : true,
				pageList : [ 5, 10, 15, 20 ],
				pageSize : 5,
				pageNumber : 1,
				pagePosition : 'bottom',
				toolbar : [{
					iconCls: 'icon-add',
					text:'打开申请',
					handler: function(){
						$('<div id="openstudent"></div>').window({
							title:'学生信息',
							height:'400',
							width:'926',
							modal:true,
							collapsible:false,
							minimizable:false,
							maximizable:false,
							draggable:false,
							resizable:false,
						   	href:"${pageContext.request.contextPath }/info/rewards/teacherApply.jsp",
						   	onClose:function(){
								$('#openstudent').window("destroy");
								$('#queryStudentApply').datagrid('reload');
							}
						})
					}
				}]
			});
		})
		
</script>
	<div id="queryStudentApply"></div>
    <div id="rewards_1_2">
	</div>