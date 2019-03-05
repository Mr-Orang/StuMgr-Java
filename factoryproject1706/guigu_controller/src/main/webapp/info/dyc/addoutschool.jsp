<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>

	$.ajax({
		type:'POST',
		url:'dyc/queryoutid',
		success:function(data){
			var dropoutid = data[0].dropout_id;
			dropoutid = dropoutid.substring(2);
			var number = Number(dropoutid)+1;
			$('#outid').attr("value","ts"+number);
		}
	});

	$('#query_stu').click(function(){
		$('<div id="stu_datagrid"></div>').window({
			title:'选择学生',
			width:1120,
			height:300,
			top:170,
			href:'info/dyc/studatagrid.jsp',
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
	})
	
	$('#saveoutinfo').click(function(){
		if($('textarea').val()==''){
			alert('请填写退学原因')
		}else{
			$.ajax({
				type:'POST',
				url:'dyc/saveoutschool',
				data:{
					dropout_id:$('#outid').val(),
					stu_id:$('#stu').val(),
					reason:$('textarea').val()
				},
				success:function(data){
						$.messager.show({
							title : '消息',
							msg : "<h3 style='color:green;'>" + data + "</h3>"
						});	
						$('#outschool').datagrid('reload');
						$('#sp_click').window({closed : true});
						$('#sp_click').window('close');
						$('#sp_click').window('destroy');
				}
			}); 
		}
	})
</script>


<div style="text-align: center;"><br/><br/>
	退学单编号：<input id="outid" type="text" readonly value=""/><br/><br/>
	退学学生：<input id="stu" type="text" readonly value=""/>&nbsp;
				<button id="query_stu" style="border: none;background: #fff"><img src="easyui/themes/icons/addBatching.png"/></button><br/><br/>
	退学原因：<textarea id="text" cols="20" style="letter-spacing: 1;padding-left: 10px;resize: none;"></textarea><br/><br/>
	<button id="saveoutinfo" style="border: none;height: 25px;width: 80px;background: #404040;color:#fff">保存</button>
</div>
<div id="stu_datagrid"></div>
