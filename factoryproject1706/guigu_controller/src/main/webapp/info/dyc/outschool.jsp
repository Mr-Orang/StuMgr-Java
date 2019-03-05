<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$(function(){
		$('#outschool').datagrid({
			url:'dyc/queryoutschool',
			height: 500,
			singleSelect:true,
			columns:[[
				{field:'dropout_id',title:'退学编号',width:170,hidden:true},
				{field:'stu_id',title:'学生编号',width:170,align:'center',hidden:true},
				{field:'stu_name',title:'学生姓名',width:170,align:'center'},
				{field:'dropout_reason',title:'退学原因',width:170,align:'center'},
				{field:'approver_time',title:'申请日期',width:170,align:'center'},
				{field:'review_id',title:'审批人',width:170,align:'center'},
				{field:'review_status',title:'审批状态',width:170,align:'center',
					formatter:function(value,row,index){switch(value){
							case 0:
								return '<font style="color:blue;">未审核</font>';
								break;
							case 1:
								return '<font style="color:green;">同意</font>';
								break;
							case 2:
								return '<font style="color:red;">不同意</font>';
						}
					}
				},
				{field:'review_reason',title:'不同意原因',width:170,align:'center'},
				{field:'review_time',title:'审批日期',width:170,align:'center'},
				{field:'outschool_click',title:'进行审批',align:'center',width:140,align:'center',
					formatter:function(value,row,index){
						return '<button onclick="out_click();" style="border:none;background:RoyalBlue;color:#fff;">进行审批</button>'
					}
				}
			]],
			pageSize:10,
			pageList:[5,10,15],
			pagination:true,
			toolbar:[{
				iconCls:'icon-edit',
				text:'<font style="color:Navy;">填写学生退学申请单</font>',
				handler:function(){
					$('<div id="sp_click"></div>').window({
						title:'退学申请单填写',
						width:500,
						height:300,
						top:170,
						href:'info/dyc/addoutschool.jsp',
						collapsible:false,
						maximizable:false,
						minimizable:false,
						draggable:false,
						resizable:false,
						modal:true,
						onClose:function(){
							$(this).window('destroy');
						}
					});
				}
			}],
		});
	})
	function out_click(){
		$('<div id="sp_click"></div>').window({
			title:'退学审批',
			width:1000,
			height:300,
			top:170,
			href:'info/dyc/outschool_sp.jsp',
			collapsible:false,
			maximizable:false,
			minimizable:false,
			draggable:false,
			resizable:false,
			modal:true,
			onClose:function(){
				$(this).window('destroy');
			}
		});
	}
</script>
<div id="outschool"></div>
<div id="sp_click"></div>
