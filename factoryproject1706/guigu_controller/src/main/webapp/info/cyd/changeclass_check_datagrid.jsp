<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	//审核表格
		$("#info_change_class_check_details_datagrid").datagrid({
			height :450,
			singleSelect : true,
			columns : [ [
				{
					title : '转班编号',
					field : 'tcc_id',
					width : 100,
				},
				{
					title : '学生姓名',
					field : 'stu_name',
					width : 100,
				},
				{
					title : '转入班级',
					field : 'in_classname',
					width : 100,
				},
				{
					title : '转出班级',
					field : 'out_classname',
					width : 100, 
				},
				{
					title : '申请时间',
					field : 'time',
					width : 150,
				},
				{
					title : '转班申请人',
					field : 'out_person',
					width : 100,
				},
				{
					title : '转入审核人',
					field : 'in_person',
					width : 100,
				},
				{
					title : '转班审核日期',
					field : 'in_time',
					width : 150,
				},
				{
					title : '转班审核状态',
					field : 'in_status',
					
					formatter:function(value,row,index){
						if(value==0){
							value="未审核";
						}else　if(value==1){
							value="同意";
						}else{
							value="不同意";
						}
						return value;
					},
					width : 100,
				},
				{
					title : '操作',
					field : 'check',
					
					formatter : function(value, row, index) {
						var tccId = '"' + row.tcc_id + '"';
						return "<input type='button' value='详情' onclick='queryChangeClassDetails(" + tccId + ")'/>";
					},
					width : 100,
				},
			] ],
			toolbar:[
				{
					text:'转班审核',
					iconCls:'icon-add',
					handler:function(){
						$("#info_change_class_check_details_datagrid").datagrid({closed:true});
						$("#info_change_class_check_panel").panel({
							href:'info/cyd/changeclass_check.jsp'
						});
					}
				}
				
				
			],
			url : 'changeclassapply/queryChangeClassCheck',
			pagination : true,
			pageList : [ 5, 10, 15 ],
			pageNumber:1,
			pageSize:5
		});
		
		
</script>

	

<div id="info_change_class_check_details_datagrid"></div>
<div id="info_change_class_check_panel"></div>