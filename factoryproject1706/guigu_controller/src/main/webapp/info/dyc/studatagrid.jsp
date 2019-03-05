<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$('#stu_info').datagrid({
		url:'dyc/queryoutstudentinfo',
		height:300,
		singleSelect:true,
		columns:[[
			{field:'check',align:'center',checkbox:true},
			{field:'stu_id',title:'学生学号',width:120,align:'center',},
			{field:'stu_name',title:'学生姓名',width:120,align:'center'},
			{field:'stu_sex',title:'性别',width:120,align:'center'},
			{field:'stu_cid',title:'身份证号码',width:120,align:'center'},
			{field:'address',title:'家庭住址',width:120,align:'center'},
			{field:'stu_status',title:'就读状态',width:120,align:'center',
				formatter:function(value,row,index){switch(value){
						case 0:
							return '<font style="color:green;">在读</font>';
							break;
						case 1:
							return '<font style="color:red;">休学</font>'
					}
				}
			},
			{field:'school',title:'毕业院校',width:120,align:'center'},
			{field:'tc_name',title:'所在班级',width:120,align:'center'},
			{field:'checked',title:'选择学生',align:'center',width:120,align:'center',
					formatter:function(value,row,index){
						return '<button onclick="selectData()" style="border:none;background:#404040;color:#fff;">确定</button>'
					}
			}
		]],
		onLoadSuccess: function () {$("#stu_info").parent().find("div .datagrid-header-check").children("input[type=\"checkbox\"]").eq(0).attr("style", "display:none;"); },
		pageSize:10,
		pageList:[10,15,20],
		pagination:true,
	});
	
	
	function selectData(){
		var rows = $('#stu_info').datagrid('getSelected');
		if(rows==null){
			alert('请点击选择学生')
		}else{
			var stu_id = rows.stu_id;
			$('#stu').attr("value",stu_id);
			$('#stu_datagrid').window({closed : true});
			$('#stu_datagrid').window('close');
			$('#stu_datagrid').window('destroy');
		}
	}
</script>


<div id="stu_info"></div>