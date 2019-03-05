<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	window.updateRoleObj = null;
	$('#tree').tree({
		url : '${pageContext.request.contextPath}/authority/RoleSoure/selectAllTA',
		checkbox : true
	});
	$(function() {
		addRoleObj = {
			cancle : function() {
				$("#addRoleInfoWindow").window("close");
			},
			save : function() {

				var nodes = $('#tree').tree('getChecked');
				var role_Name = $('#role_Nameadd').val();
				var status = $('input[name=status]:checked').val();
				var au_Ids = "";
				alert(role_Name);
				for (var i = 0; nodes.length > i; i++) {
					au_Ids = au_Ids + nodes[i].id + ",";
				}
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/RoleSoure/insertRole',
					data : {
						'role_Name' : role_Name,
						'au_Ids' : au_Ids,
						'status' : status,
					},
					success : function(message) {
						if (message == "ok") {
							alert("修改成功");
							$("#role_manage").datagrid("load");
							$("#addRoleInfoWindow").window("close");
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
	角色名称&nbsp;&nbsp;:&nbsp;&nbsp;<input id="role_Nameadd" /><br /> <br />
	权限&nbsp;&nbsp;:&nbsp;&nbsp;
	<div>
		<ul id="tree">

		</ul>
	</div>
	状态&nbsp;&nbsp;:&nbsp;&nbsp;正常<input id="statusAdd" name="status"
		value="0" type="radio" checked />&nbsp;&nbsp;:&nbsp;&nbsp;失效<input
		id="statusAdd" name="status" value="1" type="radio" /> <br />
	<button class="easyui-linkbutton" onclick="addRoleObj.save();">保存</button>
	<button class="easyui-linkbutton" onclick="addRoleObj.cancle();">取消</button>
</div>
