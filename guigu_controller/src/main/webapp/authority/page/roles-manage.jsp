<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	window.RoleChange = null;
	$(function() {
		RoleChange = {
			add : function() {
				$("<div id='addRoleInfoWindow'></div>").window({
					closed : false,
					title : '添加角色信息',
					width : 520,
					height : 450,
					modal : true,
					collapsible : false,
					maximizable : false,
					minimizable : false,
					draggable : true,
					href : "${pageContext.request.contextPath}/authority/page/role-add.jsp",
					onClose : function() {
						//销毁窗口
						$(this).window("destroy");
					}
				});
			},
			update : function(role_ID) {
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/RoleSoure/queryRoleById',
					data : {
						'role_ID' : role_ID
					},
					success : function(roleinfo) {
						$("<div id='updateRoleInfoWindow'></div>").window({
							closed : false,
							title : '修改角色信息',
							width : 520,
							height : 450,
							modal : true,
							collapsible : false,
							maximizable : false,
							minimizable : false,
							draggable : true,
							href : '${pageContext.request.contextPath}/authority/page/role-update.jsp',
							queryParams : {
								'role_ID' : role_ID,
								'role_Name' : roleinfo.role_Name,
								'status' : roleinfo.status,
							},
							onClose : function() {
								//销毁窗口
								$(this).window("destroy");
							}
						});
					}
				});

			},
		};
		$("#role_manage").datagrid({
			title : '用户信息',
			fitColumns : true,
			url : '${pageContext.request.contextPath}/authority/RoleSoure/queryAllRole',
			columns : [ [
				{
					field : 'role_ID',
					title : '角色编号',
					width : 200
				},
				{
					field : 'role_Name',
					title : '角色名称',
					width : 200,
				//checkbox:true
				},
				{
					field : 'status',
					title : '状态',
					width : 200,
					formatter : function(value) {
						if (value == 0) {
							return "正常";
						} else {
							return "失效";
						}

					}
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button class='easyui-linkbutton'onclick=RoleChange.update('" + row.role_ID + "')>修改</button>&nbsp;";
					}
				}
			] ],
			singleSelect : true,
			rownumbers : true,
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
		});

	});
</script>
<button class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick=RoleChange.add()>添加角色</button>
<table id="role_manage"></table>
<div id="updateRole" ></div>
