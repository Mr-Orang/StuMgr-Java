<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	window.onchanges = null;
	$(function() {
		onchanges = {
			add : function() {
				$("<div id='addUserInfoWindow'></div>").window({
					closed : false,
					title : '添加用户信息',
					width : 520,
					height : 450,
					modal : true,
					collapsible : false,
					maximizable : false,
					minimizable : false,
					draggable : true,
					href : "${pageContext.request.contextPath}/authority/page/user-add.jsp",
					onClose : function() {
						//销毁窗口
						$(this).window("destroy");
					}
				});
			},
			update : function(te_ID) {
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/UserSoure/queryUserById',
					data : {
						'te_ID' : te_ID
					},
					success : function(userinfo) {
						$("<div id='updateUserInfoWindow'></div>").window({
							closed : false,
							title : '修改用户信息',
							width : 520,
							height : 450,
							modal : true,
							collapsible : false,
							maximizable : false,
							minimizable : false,
							draggable : true,
							href : '${pageContext.request.contextPath}/authority/page/user-update.jsp',
							queryParams : {
								'te_ID' : te_ID,
								'te_NAME' : userinfo.te_NAME,
								'account' : userinfo.account,
								'password' : userinfo.password,
								'status' : userinfo.status,
								'role_ID' : userinfo.role_ID,
								'deptId' : userinfo.deptId
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
		$("#user_manage").datagrid({
			title : '用户信息',
			fitColumns : true,
			url : '${pageContext.request.contextPath}/authority/UserSoure/queryAllUser',
			columns : [ [
				{
					field : 'te_ID',
					title : '员工编号',
					width : 200
				},
				{
					field : 'te_NAME',
					title : '员工姓名',
					width : 200,
				//checkbox:true
				},
				{
					field : 'account',
					title : '账号',
					width : 200
				},
				{
					field : 'password',
					title : '密码',
					width : 200
				},
				{
					field : 'status',
					title : '状态',
					width : 200,
					formatter : function(value) {
						if (value == 0) {
							return "在职";
						} else {
							return "离职";
						}

					}
				},
				{
					field : 'role_Name',
					title : '所属角色',
					width : 200
				},
				{
					field : 'deptName',
					title : '所属部门',
					width : 200
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button class='easyui-linkbutton' onclick=onchanges.update('" + row.te_ID + "')>修改</button>&nbsp;";
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
<button class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick=onchanges.add()>添加员工</button>
<table id="user_manage"></table>
<div id="update"></div>
<div id="add"></div>
