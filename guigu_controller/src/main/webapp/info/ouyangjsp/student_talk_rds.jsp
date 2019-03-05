<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="reacher_3"></div>
<div id="reacher_3_3">
	<div style="margin:5px">
   		<a class="easyui-linkbutton" 
   			iconCls="icon-cancel"
   			onclick="close_window_1();">
   		关闭</a>
   	</div>
</div>

<script type="text/javascript">
	$('#reacher_3').datagrid({
	   //width:'100%',
	   //height:510,
	   title:'操作提示：<font style="color: red;">双击表格中的单元格可查看完整信息！</font>',
	   fitColumns:true,
	   columns:[[
		   {
			   field:'talk_details_id',
			   title:'谈话详情编号',
			   width:100
		   },
		   {
			   field:'talk_type',
			   title:'谈话类型',
			   width:100
		   },
		   {
			   field:'talk_content',
			   title:'谈话内容',
			   width:100
		   },
		   {
			   field:'viewpoint',
			   title:'学生确认状态',
			   width:100,
			   formatter: function(value,row,index){
			   		if(value==0){
			   			return '学生未确认本次谈话';
			   		}else if(value==1){
			   			return '学生同意本次谈话';
			   		}else{
			   			return '学生否定本次谈话';
			   		}
			   }
		   },
		   {
			   field:'reason',
			   title:'否定原因',
			   width:100
		   },
		   {
			   field:'talk_person',
			   title:'谈话人',
			   width:100
		   },
		   {
			   field:'talk_time',
			   title:'谈话时间',
			   width:100
		   }
	    ]],
		url:'talk/queryStudentTalkrecord.action',
		singleSelect:true,
	    rownumbers:true,
	    pagination:true,
	    pageList:[5,10,15,20],
   	    pageSize:5,
   	    pageNumber:1,
   	    pagePosition:'bottom',
   	    toolbar:'#reacher_3_3',
   	    onDblClickCell:function (index,field,value){
   	    	if(value==0){
			   	$.messager.alert('列完整信息：','学生未确认本次谈话');
			}else if(value==1){
			    $.messager.alert('列完整信息：','学生同意本次谈话');
			}else if(value==2){
			   	$.messager.alert('列完整信息：','学生否定本次谈话');
			}else{
				$.messager.alert('列完整信息：',value);	
			}
   	    },
   	    queryParams: {
			'stu_id': "${param.stu_id}",
			'emp_ids': "${param.emp_id}",
		}
	})
</script>

<script type="text/javascript">
	function close_window_1(){
		//$('#win_1').window('close');
   		$('#win_1').window('destroy');
	}

</script>