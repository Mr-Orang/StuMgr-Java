<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

	<script	type="text/javascript">
		$(function(){
			director ={
				shenpi:function(leave_id){
				//alert(leave_id);
					$.ajax({
					type : 'post',
					url : '/leavexingxi2.action',
					data : {
						'leave_id':leave_id
					},
					success : function(data) {
						//alert(data.leave_reason);
						$('<div id="directorshenpileave"></div>').window({
							title : '主任审批请假',
							modal : true,
							href : 'info/leave/directorshenpishuj.jsp?leave_id=' + leave_id,
							width : 800,
							height : 420,
							onClose : function() {
								$(this).window('destroy');
							},
							queryParams : {
								'leave_starttime' : data.leave_starttime,
								'leave_endtime' : data.leave_endtime,
								'leave_reason' : data.leave_reason,
								'te_name' : data.te_name
							}
						})
					}
				})
				}
			}
			
			$('#directorshenpi').datagrid({
			width : 1157,
			title : '主任审批',
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
					field : 'approver_time',
					title : '审批时间',
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
						return "<input type='button' value='审批 ' onclick='director.shenpi(" + leave_id + ")'/>";
					}
				}
			] ],
			singleSelect : true,
			rownumbers : true,
			url : '/directorshenpi.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#teachertoolbar'
		});
		
		$('#zhurenshenpixiangxi').datagrid({
			width : 1157,
			title : '详细',
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
					title : '不同意意见',
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
					field : 'te_namee',
					title : '领导审批人',
					width : 100
				},
				{
					field : 'review_status',
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
					field : 'review_reason',
					title : '不同意原因',
					width : 100
				},
				{
					field : 'review_time',
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
			url : '/leavexiangxi2.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			//toolbar : '#teachertoolbar'
		});
		
			
		})
	</script>
	
<div id="dd" class="easyui-tabs" >   
	    <div title="主任审批请假" data-options="closable:false" >   
        	<div id="directorshenpi"></div>
    	</div>   
	    <div title="主任审批详细" data-options="closable:false" >   
	          <div id="zhurenshenpixiangxi"></div>
	         <!-- <div id="leavexiangxitoolbar"></div> -->
	    </div>   
</div> 
