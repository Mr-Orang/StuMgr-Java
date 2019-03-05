<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	//老师查看所带的复学学生
	$(function() {
		$('#returnT').datagrid({
			fitConlumn : true,
			columns : [
				[
					{
						field : 'lEAVE_ID',
						title : '休学编号',
						width : 100,
					},
					{
						field : 'sTU_NAME',
						title : '学生姓名',
						width : 100
					},
					{
						field : 'sTU_SEX',
						title : '学生性别',
						width : 100
					},
					{
						field : 'tc_NAME',
						title : '原班级名称',
						width : 100
					},
					{
						field : 'tl_NAME',
						title : '阶段',
						width : 100
					},
					{
						field : 'lEAVE_STARTTIME',
						title : '休学时间',
						width : 100
					},
					{
						field : 'leave_reason',
						title : '休学理由',
						width : 100
					}
					, {
						field : 'leave_endtime',
						title : '结束时间',
						width : 100
					},
					{
						field : 'return_time',
						title : '复学时间',
						width : 100
					},
					{
						field : 'review_status',
						title : '审批状态',
						formatter : function(value, row, index) {
							if (value == 1) {
								return "未审批";
							} else if (value == 2) {
								return "不同意";
							} else if (value == 3) {
								return "同意";
							}
						},
						width : 100
					},
					{
						title : '操作',
						field : 'chaozuoT',
						width : 100,
						formatter : function(value, row, index) {
							var lEAVE_ID = '"' + row.lEAVE_ID + '"';
							return "<input type='button' value='审批' onclick='returnst(" + lEAVE_ID + ")'/>";
						}
					}
				] ],
			collapsible : false,
			maximizable : false,
			minimizable : false,
			singleSelect : true,
			url : '${pageContext.request.contextPath }/SelReturnVos.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom'
		});
	})
	<!--js审批操作-->
		function returnst(lEAVE_ID) {
			$.ajax({
				type : 'post',
				url : '/SReturnvo.action',
				data : {
					'lEAVE_ID' : lEAVE_ID
				},
				success : function(data) {
					$("<div id='return_shenpi_chakan'></div>").window({
						title : '复学审核',
						width : 630,
						height : 630,
						maximizable : false,
						minimizable : false,
						model:true,
						href : '/info/return/returnT_shenpi.jsp',
						queryParams : {
								'lEAVE_ID':data.lEAVE_ID,
								'sTU_NAME':data.sTU_NAME,
								'sTU_SEX':data.sTU_SEX,
								'tc_NAME':data.tc_NAME,
								'tl_NAME':data.tl_NAME,
								'lEAVE_STARTTIME':data.lEAVE_STARTTIME,
								'leave_reason':data.leave_reason,
								'return_time':data.return_time
						}
					});
				}
			})
		}
</script>
<!--returnT表的div-->
<div id="returnT"></div>

