<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function(){
		$("#info_change_class_check_datagrid").datagrid({
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
					width : 100,
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
					width : 100,
				},
				{
					title : '转班审核状态',
					field : 'in_status',
					width : 100,
					formatter:function(value,row,index){
						if(value==0){
							value="未审核";
						}else　if(value==1){
							value="同意";
						}else{
							value="不同意";
						}
						return value;
					}
				},
				{
					title : '操作',
					field : 'check',
					width : 100,
					formatter : function(value, row, index) {
						var tccId = '"' + row.tcc_id + '"';
						return "<input type='button' value='审批' onclick='checkChangeClass("+tccId+")'/>";
					}
				},
			] ],
			url:'changeclassapply/queryChangeClassCheck',
			queryParams:{'in_status':0},
			pagination:true,
			pageList:[1,5,10],
			pageNumber:1,
			pageSize:5,
			toolbar:[{
				text:'返回详细信息',
				iconCls:'icon-back',
				handler:function(){
					$("#info_change_class_check_tabs").panel({href:'info/cyd/changeclass_check_datagrid.jsp'});
				}
			}]
		});
	
	
	});
	function checkChangeClass(tcc_id){
	
		$.ajax({
			type:'post',
			url:'changeclassapply/queryChangeClassByTccId',
			data:{'tcc_id':tcc_id},
			success:function(data){
			
				$("<div id='info_change_class_check_window'><div>").window({
					title:'转班审核',
					width:630,
					height:550,
					maximizable:false,
					minimizable:false,
					collapsible:false,
					href:'info/cyd/changeclass_check_isapproval.jsp',
					queryParams:{
						tcc_id:data[0].tcc_id,
						in_classid:data[0].in_classid,
						out_classname:data[0].out_classname,
						stu_id:data[0].stu_id,
						stu_name:data[0].stu_name,
						in_classname:data[0].in_classname,
						put_reason:data[0].put_reason
					},
					onClose:function(){
						$(this).dialog('destroy');
					}
				});
			}
		})
	}
</script>

<div id="info_change_class_check_datagrid"></div>
