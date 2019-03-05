<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="reacher_1"></div>
<div id="reacher_1_1">
	<div style="margin:5px">
   		<a class="easyui-linkbutton" 
   			iconCls="icon-add"
   			onclick="add_talk_record();">
   		添加谈话记录</a>
   		</div>
</div>

<script type="text/javascript">
	$('#reacher_1').datagrid({
	   //width:'100%',
	   //height:510,
	   title:'班级谈话信息',
	   fitColumns:true,
	   columns:[[
		   {
			   field:'tl_name',
			   title:'阶段名称',
			   width:100
		   },
		   {
			   field:'tc_name',
			   title:'班级名称',
			   width:100
		   },
		   {
			   field:'tc_technology',
			   title:'专业方向',
			   width:100
		   },
		   {
			   field:'te_name',
			   title:'班级负责人',
			   width:100
		   },
		   {
			   field:'tc_personnum',
			   title:'班级人数',
			   width:100
		   },
		   {
			   field:'brands',
			   title:'操作',
			   width:100,
			   formatter: function(value,row,index){
			   		var empid='"'+row.emp_id+'"';
			   		var name='"'+row.tc_name+'"';
			   		return "<input type='button' value='查看谈话记录' onclick='Talk_student("+empid+","+name+")'/>";
			   }
		   }
	    ]],
		url:'talk/querytalkclass.action',
		singleSelect:true,
	    rownumbers:true,
	    pagination:true,
	    pageList:[10,15,20,25,30],
   	    pageSize:10,
   	    pageNumber:1,
   	    pagePosition:'bottom',
   	    toolbar:'#reacher_1_1'
	})
</script>

<script type="text/javascript">
	//查看班级谈话记录
	function Talk_student(empid,name){
		if($('#info_choice_card').tabs('exists',name+'班谈话记录')){
			//如果当前页面存在则回到当前页面
			$('#info_choice_card').tabs('select',name+'班谈话记录');
		}else{
			//如果当前页面不存在则修改当前页面为新的页面
			var tabs = $('#info_choice_card').tabs('getSelected');  // 获取选择的面板
			$('#info_choice_card').tabs('add', {
				title: name+'班谈话记录',
				href: 'info/ouyangjsp/record_talk.jsp',  // 新内容的URL
				closable:true,
				queryParams: {
					'empid':empid,
					'name': name,
				},	
			});
		}
	}
	
	//添加新的谈话记录
	function add_talk_record(){
		$('<div id="win_2"></div>').window({
			title:'添加谈话记录',
			width:800,    
    		height:550,    
   		 	modal:true,
   		 	minimizable:false,
   		 	collapsible:false,
   		 	maximizable:false,
   		 	resizable:false,
   		 	shadow :false,
   		 	href:'info/ouyangjsp/add_talk.jsp',
   		 	onClose:function(){
   		 		//$('#win_2').window('close');
   		 		$('#win_2').window('destroy');
   		 	}
		});
	
		/* //$('#provider_t1').click(function(){
			if($('#info_choice_card').tabs('exists','添加谈话记录')){
				$('#info_choice_card').tabs('select','添加谈话记录');
			}else{
				$('#info_choice_card').tabs('add',{
					title:'添加谈话记录',
					href:'info/ouyangjsp/add_talk.jsp',
					closable:true,	
				});
			}
		//}); */
	}
</script>
