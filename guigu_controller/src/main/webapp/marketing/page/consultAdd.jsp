<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
/*市场人员姓名
$('#te_id').combobox({
	url : '${pageContext.request.contextPath }/queryEmployeeName',
	valueField : 'te_id',
	textField : 'te_name'
});*/

	//生源等级
	$('#tsg_idss').combobox({
		url : '${pageContext.request.contextPath }/queryStudentGradeName',
		valueField : 'tsg_id',
		textField : 'tsg_name'
	});
	//生源姓名
	$('#tss_idss').combobox({
		url : '${pageContext.request.contextPath }/queryStudentConsult',
		valueField : 'tss_id',
		textField : 'tss_name'
	});
	//生源沟通记录
	$('#tst_contentss').validatebox({
		required : true,
	});

	$('#baocun').linkbutton({
		onClick : function() {
			var te_id = '${param.te_id}';
			var tss_id = $('#tss_idss').combobox('getValue');
			var tst_content = $("#tst_contentss").val();
			var tsg_id = $("#tsg_idss").combobox('getValue');
			var tst_id=$("#tst_idss").val();
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/addSourceTalk',
				data : {
					'te_id' : te_id,
					'tss_id' : tss_id,
					'tst_content' : tst_content,
					'tsg_id' : tsg_id,
					'tst_id':tst_id
				},
				success : function(data) {
					if (data!="no") {
						alert("保存成功！");
						$.messager.confirm('提示框', '是否关闭页面?', function(r) {
							if (r) {
								$('#addConsult').window('close');
								$('#consults').datagrid('reload');
							}
						});
					} else {
						alert("保存失败！");
					}
				}
			});


		}
	});
</script>
<div align="center">
	<h2>生源咨询添加</h2>
</div>
<input type="hidden" id="tst_idss"/>
<br />
<hr>
<h3>生源姓名:</h3>
<div align="center">
	<input id="tss_idss"/>
</div>
<br />
<!-- <h3>市场人员姓名:</h3> -->
<input type="hidden" id="te_idss"/>

<h3>沟通情况记录:</h3>
<div align="center">
	<textarea id="tst_contentss"></textarea>
</div>
<br />
<h3>生源等级:</h3>
<div align="center">
	<input id="tsg_idss" />
</div>
<br />
<div align="center">
	<button id="baocun">保存</button>
</div>
