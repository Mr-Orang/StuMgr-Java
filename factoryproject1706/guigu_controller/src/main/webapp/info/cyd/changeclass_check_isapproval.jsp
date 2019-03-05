<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	function info_change_class_disapproval_text() {
		$(".info_check_changeclass_disapproval").css('visibility', 'visible');
	}

	change_class_check_submit = function() {

		$.ajax({
			type : 'post',
			url : 'changeclassapply/updateChangeClassInStatus',
			data : {
				tcc_id : '${param.tcc_id}',
				in_reason : $("#info_check_change_class_disapprovalreason").val().trim(),
				stu_id : '${param.stu_id}',
				in_classid : '${param.in_classid}'
			},
			success : function(data) {
				$.messager.show({
					title : '提示',
					msg : data
				});
				$.messager.confirm("提示", "是否继续审核", function(r) {
					if (r) {
						$("#info_change_class_check_window").window('close');
							$("#info_change_class_check_datagrid").datagrid('reload');
						
					} else {
						$("#info_change_class_check_window").window('close');
						$("#info_change_class_check_datagrid").datagrid({closed:true});
						$("#info_change_class_check_tabs").panel({href:'info/cyd/changeclass_check_datagrid.jsp'});
						$("#info_change_class_check_details_datagrid").datagrid('reload');
						
					}
				})
			}
		})

	}
	info_change_class_approval_text = function() {
		$(".info_check_changeclass_disapproval").css('visibility', 'hidden');
	}
</script>
<table style="margin-left:50px" cellspacing="20">
	<tr>
		<td><label>班级名称</label></td>
		<td><input type="text" value="${param.out_classname }"
			readonly="readonly" /></td>
	</tr>
	<tr>
		<td><label>学生姓名</label></td>
		<td><input type="text" value="${param.stu_name }"
			readonly="readonly" /></td>
	</tr>
	<tr>
		<td><label>转入班级</label></td>
		<td><input type="text" value="${param.in_classname }"
			readonly="readonly" /></td>
	</tr>
	<tr>
		<td><label>转班理由</label></td>
	</tr>
	<tr>
		<td colspan="2"><textarea cols="60" rows="5"
				id="info_change_class_reason" readonly="readonly">
				${param.put_reason}
			</textarea></td>
	</tr>
	<tr>
		<td><input type="radio" name="info_change_class_isapproval_radio"
			checked onclick="info_change_class_approval_text()" />同意 <input
			type="radio" name="info_change_class_isapproval_radio"
			onclick="info_change_class_disapproval_text()" />不同意</td>
	</tr>
	<tr style="visibility:hidden"
		class="info_check_changeclass_disapproval">
		<td><label>不同意理由</label></td>
	</tr>
	<tr style="visibility:hidden"
		class="info_check_changeclass_disapproval">
		<td colspan="2"><textarea cols="60" rows="5"
				id="info_check_change_class_disapprovalreason">
				
			</textarea></td>
	</tr>
</table>
<div>
	<button class="easyui-linkbutton" style="width:300px;margin-left:150"
		onclick="change_class_check_submit()">确定</button>
</div>