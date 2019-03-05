<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	window.updateObj = null;
	var role_ID = null;
	var deptId = null;
	$(function() {
		$('#Userrole_NameUpdate').combobox({
			url : '${pageContext.request.contextPath}/authority/UserSoure/queryRole',
			valueField : 'role_ID',
			textField : 'role_Name',
		});
		$('#UserdeptNameUpdate').combobox({
			url : '${pageContext.request.contextPath}/authority/UserSoure/queryDepart',
			valueField : 'deptId',
			textField : 'deptName',
		});
		$("#Userrole_NameUpdate").combobox("setValue", '${param.role_ID}');
		$("#UserdeptNameUpdate").combobox("setValue", '${param.deptId}');
		updateObj = {
			cancle : function() {
				$("#updateUserInfoWindow").window("close");
			},
			save : function() {
				var te_ID = $('#Userte_IDUpdate').val();
				var te_NAME = $('#Userte_NAMEUpdate').val();
				var account = $('#UseraccountUpdate').val();
				var password = $('#UserpasswordUpdate').val();
				var status = $('input[name=status]:checked').val();
				var role_ID = $('input[name=Userrole_NameUpdate]').val();
				var deptId = $('input[name=UserdeptNameUpdate]').val();

				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/UserSoure/updateUser',
					data : {
						'te_ID' : te_ID,
						'te_NAME' : te_NAME,
						'account' : account,
						'password' : password,
						'status' : status,
						'role_ID' : role_ID,
						'deptId' : deptId,
					},
					success : function(message) {
						if (message == "ok") {
							alert("修改成功");
							$("#role_manage").datagrid("load");
							$("#updateUserInfoWindow").window("close");
						} else {
							alert("修改失败");
						}
					}
				})
			}
		}
	});
</script>
<div align="center">
	<input hidden="hidden" id="Userte_IDUpdate" value="${param.te_ID }">
	员工姓名&nbsp;&nbsp;:&nbsp;&nbsp;<input id="Userte_NAMEUpdate"
		value="${param.te_NAME }" /><br /> <br />
		
	账号&nbsp;&nbsp;:&nbsp;&nbsp;<input id="UseraccountUpdate"
		value="${param.account }" readOnly="true" /><br /> <br />
	密码&nbsp;&nbsp;:&nbsp;&nbsp;<input id="UserpasswordUpdate"
		value="${param.password }" /><br /> <br />

	<c:if test="${param.status ==0}">
			状态&nbsp;&nbsp;:&nbsp;&nbsp;在职<input id="UserstatusUpdate"
			name="status" value="0" type="radio" checked />&nbsp;&nbsp;:&nbsp;&nbsp;离职<input
			id="UserstatusUpdate" name="status" value="1" type="radio" />
		<br />
	</c:if>
	<c:if test="${param.status ==1}">
			状态&nbsp;&nbsp;:&nbsp;&nbsp;在职<input id="UserstatusUpdate"
			name="status" value="0" type="radio" />&nbsp;&nbsp;:&nbsp;&nbsp;离职<input
			id="UserstatusUpdate" name="status" value="1" type="radio" CHECKED />
		<br />
	</c:if>
	角色&nbsp;&nbsp;:&nbsp;&nbsp;<input name="Userrole_NameUpdate" id="Userrole_NameUpdate"
	 value=""/><br /> <br /> 所属部门&nbsp;&nbsp;:&nbsp;&nbsp; 
		 <input name="UserdeptNameUpdate" id="UserdeptNameUpdate" /><br /> <br /> <br />
	<button class="easyui-linkbutton" onclick="updateObj.save();">保存</button>
	<button class="easyui-linkbutton" onclick="updateObj.cancle();">取消</button>
</div>