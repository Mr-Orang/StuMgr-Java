<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		addStuSourceObj = {
			save : function() {
				var empID = '${param.empID }';
				var stuSourceName = $("#stuSourceName").val();
				var stuSourceMobile = $("#stuSourceMobile").val();
				var stuSourceArea = $("#stuSourceArea").val();
				var stuSourceQQ = $("#stuSourceQQ").val();
				var stuSourcePmobile = $("#stuSourcePmobile").val();
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/marketing/studentSource/addStudentSource',
					data : {
						'stuSourceName' : stuSourceName,
						'stuSourceMobile' : stuSourceMobile,
						'stuSourceArea' : stuSourceArea,
						'stuSourceQQ' : stuSourceQQ,
						'stuSourcePmobile' : stuSourcePmobile,
						'empID' : empID
					},
					success : function(message) {
						if (message == "ok") {
							alert("新增成功");
							$("#studentSourceData").datagrid("load");
							$("#addStudentSourceWindow").window("close");
						} else {
							alert("新增失败");
						}
					}
				});

			},
			cancle : function() {
				$("#addStudentSourceWindow").window("close");
			}
		};
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
		$('#stuSourceName').validatebox({
			required : true,
		//validType: 'email'   
		});
		$('#stuSourceArea').validatebox({
			required : true,
		//validType: 'email'   
		});
		$('#stuSourceMobile').validatebox({
			required : true,
			missingMessage : "必填信息",
			//validType : ['mobile','length[3,11]']
			validType : [ 'mobile' ]  
		});
		$('#stuSourcePmobile').validatebox({
			required : false,
			//missingMessage : "必填信息",
			//validType : ['mobile','length[3,11]']
			validType : [ 'mobile' ]  
		});
	});
</script>
<div align="center">
	生源姓名&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceName" /><br /> <br />
	电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceMobile" /><br /> <br />
	生源地区或院校&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceArea" /><br /> <br />
	qq号码&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceQQ" /><br /> <br />
	父母电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourcePmobile" /><br /> <br />
	<a class="easyui-linkbutton" iconCls="icon-save"
		onclick="addStuSourceObj.save();">保存</a> <a class="easyui-linkbutton"
		iconCls="icon-save" onclick="addStuSourceObj.cancle();">取消</a>
</div>