<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="reacher_2"></div>
<div id="reacher_2_2">
	<div style="margin:5px">
   		<a class="easyui-linkbutton" 
   			iconCls="icon-back"
   			onclick="Returnsyy();">
   		返回上一页</a>
   	</div>
</div>

<script type="text/javascript">
	$('#reacher_2').datagrid({
	   //width:'100%',
	   //height:510,
	   title:'班级学生谈话信息',
	   fitColumns:true,
	   columns:[[
		   {
			   field:'tc_name',
			   title:'班级名称',
			   width:100
		   },
		   {
			   field:'stu_name',
			   title:'学生姓名',
			   width:100
		   },
		   {
			   field:'stu_sex',
			   title:'学生性别',
			   width:100
		   },
		   {
			   field:'shulian',
			   title:'谈话记录次数',
			   width:100
		   },
		   {
			   field:'brandcz',
			   title:'操作',
			   width:100,
			   formatter: function(value,row,index){
			   		var stuid='"'+row.stu_id+'"';
			   		var shulian='"'+row.shulian+'"';
			   		var stu_name='"'+row.stu_name+'"';
			   		return "<input type='button' value='查看谈话记录' onclick='Talk_CalssStudent("+stuid+","+shulian+","+stu_name+")'/>";
			   }
		   }
	    ]],
		url:'talk/queryClassStudentTalkdetail.action',
		singleSelect:true,
	    rownumbers:true,
	    pagination:true,
	    pageList:[10,15,20,25,30],
   	    pageSize:10,
   	    pageNumber:1,
   	    pagePosition:'bottom',
   	    toolbar:'#reacher_2_2',
		queryParams: {
			'emp_id':"${param.empid}",
			'tc_name': "${param.name}",
		}						
	});
</script>

<script type="text/javascript">
	function Talk_CalssStudent(stuid,shulian,stu_name){
		if(shulian==0||shulian=="0"){
			$.messager.alert('提示消息：','当前学生没有谈话记录!'); 
		}else{
			$('<div id="win_1"></div>').window({
				title:'学生 <font style="color: red;">'+stu_name+'</font> 的谈话记录',
				width:800,    
    			height:500,    
   		 		modal:true,
   		 		minimizable:false,
   		 		collapsible:false,
   		 		maximizable:false,
   		 		resizable:false,
   		 		shadow :false,
   		 		href:'info/ouyangjsp/student_talk_rds.jsp',
   		 		onClose:function(){
   		 			//$('#win_1').window('close');
   		 			$('#win_1').window('destroy');
   		 		},
   		 		queryParams: {
					'stu_id': stuid,
					'emp_id': "${param.empid}",
				}
			});
		}
	}
	
	//返回上一页Returnsyy()
	function Returnsyy(){
		if($('#info_choice_card').tabs('exists','学生谈话管理')){
			//获取当前选项卡
			var tabclose = $('#info_choice_card').tabs('getSelected');
			//获取当前选项卡索引
			var indexclose = $('#info_choice_card').tabs('getTabIndex',tabclose);
			//关闭选项卡
			$('#info_choice_card').tabs('close',indexclose);
			//如果当前页面存在则回到当前页面
			$('#info_choice_card').tabs('select','学生谈话管理');
		}else{
			//获取当前选项卡
			var tabclose = $('#info_choice_card').tabs('getSelected');
			//获取当前选项卡索引
			var indexclose = $('#info_choice_card').tabs('getTabIndex',tabclose);
			//关闭选项卡
			$('#info_choice_card').tabs('close',indexclose);
			//添加新的选项卡
			$('#info_choice_card').tabs('add', {
				title: '学生谈话管理',
				href: 'info/ouyangjsp/reacher_a.jsp',  // 新内容的URL
				closable:true,	
			});
		} 
	}
	
</script>