<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
	$(function() {
		$("#stuSourceStatusUpdate").combobox({
			url : '${pageContext.request.contextPath }/marketing/studentSource/queryRecruitStatus',
			valueField : 'trs_id',
			textField : 'trs_name',
			editable : false,
		});
		$("#stuSourceStatusUpdate").combobox({
			onSelect : function(record) {
				//alert(record.trs_name);
				updateStuSourceObj.display(record);
			},
			onLoadSuccess : function() {
				var statusValue = $("#stuSourceStatusUpdate").combobox("getText");
				//console.log(statusValue);
				if (statusValue != "流失") {
					$("#display").css('display', 'none');
				} else {
					$("#display").css('display', 'block');
				}
			},
		});
		$("#stuSourceStatusUpdate").combobox("setValue", '${param.trs_id}');
		updateStuSourceObj = {
			save : function() {
				var tss_id = '${param.tss_id }';
				var tss_name = $("#stuSourceNameUpdate").val();
				var tss_mobile = $("#stuSourceMobileUpdate").val();
				//alert(tss_mobile);
				var tss_area_school = $("#stuSourceAreaUpdate").val();
				var tss_qq = $("#stuSourceQQUpdate").val();
				//alert(tss_qq=="");
				//tss_qq = (tss_qq == "" ? "" : deptId);
				var tss_parent_mobile = $("#stuSourcePmobileUpdate").val();
				var trs_id = $("#stuSourceStatusUpdate").combobox("getValue");
				var tss_losttext = $("#stuSourceLostTextUpdate").val();
				if ($("#display").css("display") == "none") {
					tss_losttext = '';
				}
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/marketing/studentSource/updateStudentSource',
					data : {
						'tss_id' : tss_id,
						'tss_name' : tss_name,
						'tss_mobile' : tss_mobile,
						'tss_area_school' : tss_area_school,
						'tss_qq' : tss_qq,
						'tss_parent_mobile' : tss_parent_mobile,
						'trs_id' : trs_id,
						'tss_losttext' : tss_losttext
					},
					success : function(message) {
						if (message == "ok") {
							alert("修改成功");
							$("#studentSourceData").datagrid("load");
							$("#updateStudentSourceWindow").window("close");
						} else {
							alert("修改失败");
						}
					}
				});

			},
			cancle : function() {
				$("#updateStudentSourceWindow").window("close");
			},
			display : function(record) {
				if (record.trs_name != "流失") {
					$("#display").css('display', 'none');
				} else {
					$("#display").css('display', 'block');
				}
			},
		};

		$('#stuSourceNameUpdate').validatebox({
			required : true,
			missingMessage : "必填信息"
		//validType: 'email'   
		});
		$('#stuSourceAreaUpdate').validatebox({
			required : true,
			missingMessage : "必填信息"
		//validType: 'email'   
		});
		$.extend($.fn.validatebox.defaults.rules, {
			mobile : {
				validator : function(value, param) {
					//(400正则)|(800正则)|(手机号)|(座机号)
					///^400[0-9]{7}/|/^800[0-9]{7}/|/^1(3|4|7|5|8)([0-9]{9})/|^0[0-9]{2,3}-[0-9]{8}|.test(value);
					//纯数字  -->  /^\d+$/
					return /^400[0-9]{7}/.test(value) || /^800[0-9]{7}/.test(value) ||
						/^1(3|4|7|5|8)([0-9]{9})/.test(value) || /^0[0-9]{2,3}-[0-9]{8}/.test(value);
				},
				message : ' 号码不正确 '
			},
		});
		$('#stuSourceMobileUpdate').validatebox({
			required : true,
			missingMessage : "必填信息",
			//validType : ['mobile','length[3,11]']
			validType : [ 'mobile' ]
		});
		$('#stuSourcePmobileUpdate').validatebox({
			required : false,
			//missingMessage : "必填信息",
			//validType : ['mobile','length[3,11]']
			validType : [ 'mobile' ]
		});
		

	});
</script>

<div align="center">
	生源姓名&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceNameUpdate"
		value="${param.tss_name }" /><br /> <br />
	电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceMobileUpdate"
		value="${param.tss_mobile }" /><br /> <br />
	生源地区或院校&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceAreaUpdate"
		value="${param.tss_area_school }" /><br /> <br />
	qq号码&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceQQUpdate"
		value="${param.tss_qq }" /><br /> <br />
	招生状态&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceStatusUpdate" /><br />
	<br />
	<div id="display">
		流失原因&nbsp;&nbsp;:&nbsp;&nbsp;
		<textarea id="stuSourceLostTextUpdate">
	${param.tss_losttext }
	</textarea>
	</div>
	<br /> <br /> 父母电话&nbsp;&nbsp;:&nbsp;&nbsp;<input
		id="stuSourcePmobileUpdate" value="${param.tss_parent_mobile }" /><br />
	<br /> <a class="easyui-linkbutton" iconCls="icon-save"
		onclick="updateStuSourceObj.save();">保存</a> <a
		class="easyui-linkbutton" iconCls="icon-save"
		onclick="updateStuSourceObj.cancle();">取消</a>
</div>