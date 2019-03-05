<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script>
	var row = $('#outschool').datagrid('getSelections','info/dyc/outschool.jsp')
	var stu_id;
	for(var i=0;i<row.length;i++){
		stu_id = row[i].stu_id;
	}
	
	$.ajax({
		type:'POST',
		url:'dyc/querystatus_reson',
		data:{
			stu_id:stu_id
		},
		success:function(data){
			var comVal ;
			if(data[0].review_status==0){
				comVal = '未审核'
			}
			if(data[0].review_status==1){
				comVal = '同意'
			}
			if(data[0].review_status==2){
				comVal = '不同意'
			}
			
			document.getElementById("text").value=data[0].review_reason;
			$('#sp_yes').combobox('select',comVal);
		}
	});
	
	
	$('#jd_money').datagrid({
		fitColumns : true,
		url:'dyc/queryoutschool_money',
		fitColumns:true,
		singleSelect:true,
		columns:[[
			{field:'tp_id',title:'学费收缴编号',width:150,hidden:true},
			{field:'stu_name',title:'学生名字',width:150,align:'center'},
			{field:'tl_name',title:'学习阶段',width:150,align:'center'},
			{field:'tlf_statement',title:'缴费说明',width:150,align:'center'},
			{field:'tlf_fee',title:'阶段缴费标准',width:150,align:'center'},
			{field:'tp_cash',title:'实际缴费',width:150,align:'center'},
			{field:'tp_date',title:'缴费时间',width:154,align:'center'},
			{field:'te_name',title:'收费人',width:150,align:'center'},
			{field:'tp_tip_status',title:'是否给发票',width:150,align:'center'},
		]],
		queryParams:{
			stu_id:stu_id
		}
	});
	
	$('#sp_query').click(function(){
		if($('#sp_yes').combobox('getText')=='不同意' && $('textarea').val()==''){
			alert('请填写不同意原因')
			return false;
		}
		$.ajax({
			type:'POST',
			url:'dyc/updatetoutschool',
			data:{
				sp_yes:$('#sp_yes').combobox('getText'),
				text_no:$('textarea').val(),
				stu_id:stu_id
			},
			success:function(data){
				if(data = '审核成功，已通知该学生'){
					$.messager.show({
						title : '消息',
						msg : "<h3 style='color:green;'>" + data + "</h3>"
					});
				}else{
					$.messager.show({
						title : '消息',
						msg : "<h3 style='color:red;'>" + data + "</h3>"
					});
				}	
					$('#outschool').datagrid('reload');
					$('#sp_click').window({closed : true});
					$('#sp_click').window('close');
					$('#sp_click').window('destroy');
			}
		});
	});
</script>



<div id="jd_money"></div><br/>
<div style="padding-left: 90px;">
	是否同意：<select id="sp_yes" class="easyui-combobox" data-options="panelHeight : 'auto',editable : false">
				<option>同意</option>
				<option>不同意</option>
				<option>未审核</option>
			 </select>
	不同意原因：<samp style="color: red;font-size: 10px;">如不同意请填写原因</samp><br/><textarea id="text" rows="5" cols="80" style="letter-spacing: 1;padding-left: 10px;resize: none;"></textarea>
	<button id="sp_query" style="border: none;background: Navy;height: 25px;width: 60px;color:#fff;">确认</button>
</div>
