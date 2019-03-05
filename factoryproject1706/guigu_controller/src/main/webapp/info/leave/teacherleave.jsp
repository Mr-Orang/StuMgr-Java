<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<script type="text/javascript">
	$(function() {
		teacher = {
			shenpi : function(leave_id) {
				$.ajax({
					type : 'post',
					url : 'leavexingxi.action',
					data : {
						'leave_id' : leave_id
					},
					success : function(data) {
						//alert(data.leave_reason);
						$('<div id="leavexiangxi2"></div>').window({
							title : '审批请假',
							modal : true,
							href : 'info/leave/shenpileave.jsp?leave_id=' + leave_id,
							width : 800,
							height : 420,
							onClose : function() {
								$(this).window('destroy');
							},
							queryParams : {
								'leave_starttime' : data.leave_starttime,
								'leave_endtime' : data.leave_endtime,
								'leave_reason' : data.leave_reason
							}
						})
					}
				})

			}
		}

		$('#teacherleave').datagrid({
			width : 1157,
			title : '老师审批',
			fitColumns : true,
			columns : [ [
				{
					field : 'leave_id',
					title : '请假编号',
					width : 100
				},
				{
					field : 'stu_name',
					title : '学生姓名',
					width : 100
				},
				{
					field : 'leave_starttime',
					title : '开始时间',
					width : 100
				},
				{
					field : 'leave_endtime',
					title : '结束时间',
					width : 100
				},
				{
					field : 'leave_reason',
					title : '请假原因',
					width : 100
				},
				{
					field : 'leave_time',
					title : '申请时间',
					width : 100
				},
				{
					field : 'tc_name',
					title : '学生班级',
					width : 100
				},
				{
					field : 'anniu',
					title : '审批',
					width : 100,
					formatter : function(value, row, index) {
						var leave_id = '"' + row.leave_id + '"'
						return "<input type='button' value='审批 ' onclick='teacher.shenpi(" + leave_id + ")'/>";
					}
				}
			] ],
			singleSelect : true,
			rownumbers : true,
			url : '/approveleave.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#teachertoolbar'
		});
		
			$('#leavexiangxi').datagrid({
			width : 1157,
			title : '审批请假详细',
			fitColumns : true,
			columns : [ [
				{
					field : 'leave_id',
					title : '请假编号',
					width : 100
				},
				{
					field : 'stu_name',
					title : '学生姓名',
					width : 100
				},
				{
					field : 'leave_starttime',
					title : '开始时间',
					width : 100
				},
				{
					field : 'leave_endtime',
					title : '结束时间',
					width : 100
				},
				{
					field : 'leave_reason',
					title : '请假原因',
					width : 100
				},
				{
					field : 'leave_time',
					title : '申请时间',
					width : 100
				},
				{
					field : 'te_name',
					title : '审批人',
					width : 100
				},
				{
					field : 'approver_reason',
					title : '审批不同意意见',
					width : 100
				},
				{
					field : 'approver_status',
					title : '审批状态',
					formatter:function(value,row,index){
				   			if(value==1){
				   				return "同意";
				   			}else{
				   				return "不同意";
				   			}
				 	},
					width : 100
				},
				{
					field : 'approver_time',
					title : '审批时间',
					width : 100
				},
				{
					field : 'tc_name',
					title : '学生班级',
					width : 100
				}
			] ],
			singleSelect : true,
			rownumbers : true,	
			url : '/leavexiangxi.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#leavexiangxitoolbar'
		});

	});
</script>

<!-- 
<div id="teacherleave"> </div> 表格
<div id="teachertoolbar"></div>老师工具栏 
-->


<div id="tt" class="easyui-tabs" >   
	    <div title="学生请假审批" data-options="closable:false" >   
        	<div id="teacherleave"></div>
    	</div>   
	    <div title="审批请假详细" data-options="closable:false" >   
	         <div id="leavexiangxi"></div>
	         <div id="leavexiangxitoolbar"></div>
	    </div>   
</div> 
    
    
