<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	window.updateRoleObj = null;
	$('#tree').tree({
		url : '${pageContext.request.contextPath}/authority/RoleSoure/queryAutByRoleId?role_ID=${param.role_ID}',
		checkbox : true
	});
	$(function() {
		updateRoleObj = {
			cancle : function() {
				$("#updateRoleInfoWindow").window("close");
			},
			save : function() {
				var role_ID=$('#role_IDUpdate').val();
				var nodes = $('#tree').tree('getChecked');
				var role_Name = $('#role_NameUpdate').val();
				var status = $('input[name=status]:checked').val();
				var au_Ids="";
				for( var i=0;nodes.length>i;i++){
					au_Ids=au_Ids+nodes[i].id+",";
				}
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/RoleSoure/updateRole',
					data : {
						'role_ID' : role_ID,
						'role_Name' : role_Name,
						'au_Ids' : au_Ids,
						'status' :status,
					},
					success : function(message) {
						if (message == "ok") {
							alert("修改成功");
							$("#role_manage").datagrid("load");
							$("#updateRoleInfoWindow").window("close");
						} else {
							alert("修改失败");
						}
					}
				});
			}
		}
	});
</script>
<div align="center">
	<input hidden="hidden" id="role_IDUpdate" value="${param.role_ID }">
	角色名称&nbsp;&nbsp;:&nbsp;&nbsp;<input id="role_NameUpdate"
		value="${param.role_Name }" /><br /> <br />
	权限&nbsp;&nbsp;:&nbsp;&nbsp;
	<div style="overflow-y: auto;height: 200px">
		<ul id="tree">

		</ul>
	</div>
	<c:if test="${param.status ==0}">
	状态&nbsp;&nbsp;:&nbsp;&nbsp;正常<input id="statusUpdate" name="status"
			value="0" type="radio" checked />&nbsp;&nbsp;:&nbsp;&nbsp;失效<input
			id="UserstatusUpdate" name="status" value="1" type="radio" />
		<br />
	</c:if>
	<c:if test="${param.status ==1}">
			状态&nbsp;&nbsp;:&nbsp;&nbsp;正常<input id="statusUpdate" name="status"
			value="0" type="radio" />&nbsp;&nbsp;:&nbsp;&nbsp;失效<input
			id="UserstatusUpdate" name="status" value="1" type="radio" CHECKED />
		<br />
	</c:if>

	<button class="easyui-linkbutton" onclick="updateRoleObj.save();">保存</button>
	<button class="easyui-linkbutton" onclick="updateRoleObj.cancle();">取消</button>
</div>
