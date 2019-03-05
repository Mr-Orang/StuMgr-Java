<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script>
	$(function() {
		//市场人员姓名
		$('#te_names').combobox({
			url : '${pageContext.request.contextPath }/queryEmployeeName',
			valueField : 'te_id',
			textField : 'te_name'
		});
		//咨询日期
		$('#tst_dates').datebox({
			required : true
		});
		//生源等级
		$('#tsg_names').combobox({
			url : '${pageContext.request.contextPath }/queryStudentGradeName',
			valueField : 'tsg_id',
			textField : 'tsg_name'
		});
		//生源沟通记录
		$('#tst_contents').validatebox({
			required : true,
		//validType: 'email'   
		});
		$('#tijiaobut').linkbutton();
	});

	//修改生源姓名
/*function updateStudentSource(old_tss_id) {
	
	var tss_id=$('#tss_id').val();
	if(tss_id=='${param.tss_id}'){
		tss_id=old_tss_id;
	}
	var tss_name=$('#tss_name').val();
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/updateStudentSourceName",
		data : {
			'tss_id' : '${param.tss_id}',
			'tss_name':tss_name
		},
		success : function(data) {
			if (data) {
				alert(data + "修改成功！");
			} else {
				alert("修改失败！");
			}
		}
	});

}*/

	//修改生源咨询信息
	function updateConsult(old_te_id, old_tsg_id) {
		var te_id = $('#te_names').combobox('getValue');
		if (te_id == '${param.te_names}') {
			te_id = old_te_id;
		}
		var tsg_id = $('#tsg_names').combobox('getValue');
		if (tsg_id == '${param.tsg_name}') {
			tsg_id = old_tsg_id;
		}

		var tst_date = $("#tst_dates").datebox('getValue');
		var tst_content = $("#tst_contents").val();
		var tss_id = $('#tss_ids').val();
		/*if (tss_id == '${param.tss_id}') {
			tss_id = old_tss_id;
		}*/
		var tss_name = $('#tss_names').val();
		/*$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/updateStudentSourceName",
			data : {
				'tss_id' : '${param.tss_id}',
				'tss_name' : tss_name
			}
		});*/

		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/updateSourceTalk",
			data : {
				'tst_id' : $("#tst_ids").val(),
				'te_id' : te_id,
				'tst_date' : tst_date,
				'tst_content' : tst_content,
				'tsg_id' : tsg_id,
		//		'tss_id' : '${param.tss_id}',
			//	'tss_name' : tss_name
			},
			success : function(data) {
				if (data) {
					alert(data + "修改成功！");
					$.messager.confirm('提示框', '是否关闭页面?', function(r) {
						if (r) {
							$('#consultupdate').window('close');
							$('#consults').datagrid('reload');
						}
					})
				} else {
					alert("修改失败！");
				}
			}
		});

	}
</script>
<div align="center">
	<h2>生源咨询修改</h2>
</div>
<input type="hidden" id="tst_ids" value="${param.tst_id }" />
<br />
<hr>
<!-- <h3>生源姓名:</h3>
<div align="center">
	<input type="text" id="tss_names" value="${param.tss_name }" />
</div>
<br />-->

<h3>市场人员姓名:</h3>
<div align="center">
	<input type="text" id="te_names" value="${param.te_name }" />
</div>
<br />
<h3>咨询日期:</h3>
<div align="center">
	<input type="text" class="easyui-datebox" required="required" id="tst_dates" value="${param.tst_date }"/>
</div>
<br />
<h3>沟通情况记录:</h3>
<div align="center">
	<textarea id="tst_contents">${param.tst_content }</textarea>
</div><br />
<h3>生源等级:</h3>
<div align="center">
	<input id="tsg_names" value="${param.tsg_name }" />
</div><br />
<div align="center">
	<button id="tijiaobut"	onclick="updateConsult('${param.te_id}','${param.tsg_id }')">提交</button><!-- ,'${param.tss_id }' -->
</div>