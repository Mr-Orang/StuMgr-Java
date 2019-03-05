<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$(function(){
		/* $("#info_change_class_inclassname").combobox({
			url:'changeclassapply/queryAllClassByTcId',
			valueField:'tc_id',
			textField:'tc_name',
			required:true
		}); */
		$("#info_change_class_classname").combobox({
			url:'changeclassapply/queryClassByTeId',
			valueField:'tc_id',
			textField:'tc_name',
			required:true,
			onChange:function(newValue, oldValue){
				$.ajax({
					type:'post',
					url:'changeclassapply/queryStudentByTcId',
					data:{'tc_id':newValue},
					success:function(data){
						$("#info_change_class_stuname").combobox({
							data:data,
							valueField:'stuid',
							textField:'stuname',
							required:true
						});
					}
				});
			
				$.ajax({
					type:'post',
					url:'changeclassapply/queryAllClassByTcId',
					data:{'tc_id':newValue},
					success:function(data){
						$("#info_change_class_inclassname").combobox({
							data:data,
							valueField:'tc_id',
							textField:'tc_name',
							required:true
						});
					}
				});
				
			}, 
		});
		
		
	});
	function change_class_apply_reason(){
		var put_reason=$("#info_change_class_reason").val().trim();
		var stu_id=$("#info_change_class_stuname").combobox('getValue').trim();
		var out_classid=$("#info_change_class_classname").combobox('getValue').trim();
		var in_classid=$("#info_change_class_inclassname").combobox('getValue').trim();
		if(put_reason==""||stu_id==""||out_classid==""||in_classid==""){
			$.messager.alert('提示',"请填写完整信息",'warning');
		}else{
		//alert($("#info_change_class_stuname").combobox('getValue'))
			$.ajax({
				type:'post',
				url:'changeclassapply/addChangeClassApply',
				data:{
					stu_id:stu_id,
					out_classid:out_classid,
					in_classid:in_classid,
					put_reason:put_reason
				},
				success:function(data){
					$.messager.show({
						title:'提示',
						msg:data
					});
					$("#add_change_class_apply_dialog").dialog('close');
					$("#info_change_class_apply_datagrid").datagrid("reload");
				}
			}); 
		}	
	}

</script>

<table style="margin-left:50px" cellspacing="20" >
	<tr>
		<td><label>班级名称</label></td>
		<td><input class="easyui-combobox" id="info_change_class_classname"/></td>
	</tr>
	<tr>
		<td><label>学生姓名</label></td>
		<td><input class="easyui-combobox" id="info_change_class_stuname"/></td>
	</tr>
	<tr>
		<td><label>转入班级</label></td>
		<td><input class="easyui-combobox" id="info_change_class_inclassname"/></td>
	</tr>
	<tr>
		<td><label>转班理由</label></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea cols="60" rows="5" id="info_change_class_reason">
			
			</textarea>
		</td>
	</tr>
</table>
<div >
<button class="easyui-linkbutton" style="width:300px;margin-left:150" onclick="change_class_apply_reason()">确定</button>
</div>
