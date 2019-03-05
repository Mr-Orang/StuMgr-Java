<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {

		$('#UserdeptIdAdd').combobox({
			url : '${pageContext.request.contextPath}/authority/UserSoure/queryDepart',
			valueField : 'deptId',
			textField : 'deptName',
			panelHeight : '100px',
		});
		$('#Userrole_NameAdd').combobox({
			url : '${pageContext.request.contextPath}/authority/UserSoure/queryRole',
			valueField : 'role_ID',
			textField : 'role_Name',
		});
		addObj = {
			cancle : function() {
				$("#addUserInfoWindow").window("close");
			},
			save : function() {
				var te_NAME = $('#Userte_NAMEAdd').val();
				var te_mobil = $('#Userte_mobileAdd').val();
				var te_card_id = $('#Userte_card_idAdd').val();
				var te_sex = $('input[name=sex]:checked').val();
				var te_age = $('#Userte_ageAdd').val();
				var te_marry_status = $('input[name=marry]:checked').val();
				var te_add = $('#Userte_addressAdd').val();
				var deptId = $('input[name=UserdeptIdAdd]').val();
				var role_ID = $('input[name=Userrole_NameAdd]').val();
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/authority/UserSoure/addEmp',
					data : {
						'te_name' : te_NAME,
						'te_mobile' : te_mobil,
						'te_card_id' : te_card_id,
						'te_sex' : te_sex,
						'te_age' : te_age,
						'te_marry_status' : te_marry_status,
						'te_address' : te_add,
						'deptId' : deptId,
						'role_ID' : role_ID,
					},
					success : function(message) {
						alert(message);
						if (message == "ok") {
							alert("添加成功");
							$("#user_manage").datagrid("load");
							$("#addUserInfoWindow").window("close");
						} else {
							alert("添加失败");
						}
					}
				});
			}
		}
	});
</script>

<div align="center">
	员工姓名&nbsp;&nbsp;:&nbsp;&nbsp;<input id="Userte_NAMEAdd" /><br /> <br />
	电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="Userte_mobileAdd" /><br /> <br />
	身份证号&nbsp;&nbsp;:&nbsp;&nbsp;<input id="Userte_card_idAdd" /><br /> <br />
	性别&nbsp;&nbsp;:&nbsp;&nbsp;男<input id="Userte_sexAdd" name="sex"
		value="男" type="radio" checked />&nbsp;&nbsp;:&nbsp;&nbsp;女<input
		id="Userrte_sexAdd" name="sex" value="女" type="radio" /> <br />
	年龄&nbsp;&nbsp;:&nbsp;&nbsp;<input name="Userte_ageAdd"
		id="Userte_ageAdd" /><br /> 是否已婚&nbsp;&nbsp;:&nbsp;&nbsp;是<input
		id="Userte_marry_statusAdd" name="marry" value="是" type="radio" />&nbsp;&nbsp;:&nbsp;&nbsp;否<input
		id="Userte_marry_statusAdd" name="marry" value="否 " type="radio"
		checked /> <br /> <br /> 住址&nbsp;&nbsp;:&nbsp;&nbsp;
	<textarea id="Userte_addressAdd"></textarea>
	<br /> 部门&nbsp;&nbsp;:&nbsp;&nbsp;<input id="UserdeptIdAdd"
		name="UserdeptIdAdd" /><br /> 角色&nbsp;&nbsp;:&nbsp;&nbsp;<input
		id="Userrole_NameAdd" name="Userrole_NameAdd" /><br /> <br />
	<button class="easyui-linkbutton" onclick="addObj.save();">保存</button>
	<button class="easyui-linkbutton" onclick="addObj.cancle();">取消</button>
</div>
