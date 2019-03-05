<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 所有未通过审批的奖罚单JSP -->
<script type="text/javascript">
		$(function(){
			$('#queryRewardsApplyInfo').datagrid({
				fitColumns : true,
				columns : [ 
				[
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
						field : 'operation',
						title : '操作',
						width : 170,
						formatter: function(value,row,index){
								return  '<button onclick="openStudentInfo('+row.rewards_id+')">查看详情</button>';
							}
					}
				] ],
				collapsible : false,
				maximizable : false,
				minimizable : false,
				singleSelect:true,
				url : '${pageContext.request.contextPath }/queryRewardsInfo.action',
				pagination : true,
				pageList : [ 5, 10, 15, 20 ],
				pageSize : 5,
				pageNumber : 1,
				pagePosition : 'bottom',
				toolbar : [
					{
					iconCls: 'icon-ok',
					text:'同意',
					handler: function(){
						var select=$('#queryRewardsApplyInfo').datagrid("getSelected");
						if(select==null){
							alert('请选择');
						}else{
							$.ajax({
								url : "${pageContext.request.contextPath }/examineAdopt.action",
								data : {
									'rewards_id' :select.rewards_id
								},
								success : function(data) {
									$.messager.alert('我的消息', data, 'info');
									$('#queryRewardsApplyInfo').datagrid("reload");
								}
							});
						}
					}
				},{
					iconCls: 'icon-no',
					text:'不同意',
					handler: function(){
						var select=$('#queryRewardsApplyInfo').datagrid("getSelected");
						if(select==null){
							alert('请选择');
						}else{
							$('<div id="noagree"></div>').window({
								title:'意见',
								height:'210',
								width:'400',
								modal:true,
								collapsible:false,
								minimizable:false,
								maximizable:false,
								draggable:false,
								resizable:false,
							   	href:"${pageContext.request.contextPath }/info/rewards/noAgreeExamine.jsp?rewardsid="+select.rewards_id,
							   	onClose:function(){
									$('#noagree').window("destroy");
									$('#queryRewardsApplyInfo').datagrid("reload");
								}
							})
						}
					}
				}
				]
			});
		})
		openStudentInfo=function(rewardsid){
			$('<div id="openExamineApply"></div>').window({
							title:'学生信息',
							height:'300',
							width:'800',
							modal:true,
							collapsible:false,
							minimizable:false,
							maximizable:false,
							draggable:false,
							resizable:false,
						   	href:"${pageContext.request.contextPath }/info/rewards/examineApply.jsp?rewardsid="+rewardsid,
						   	onClose:function(){
								$('#openExamineApply').window("destroy");
							}
						})
		}
</script>
<div id="queryRewardsApplyInfo"></div>
