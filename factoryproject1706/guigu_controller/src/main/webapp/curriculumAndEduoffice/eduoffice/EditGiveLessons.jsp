<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">

<form class="layui-form" action="">
	<div class="layui-form-item">
		<label class="layui-form-label"></label>
		<div class="layui-input-block" style="width:200">
			<input class="layui-input" name="gl_id" id="gl_id" type="hidden"
				value="${param.gl_id }" /> <input class="layui-input" name="tc_cid"
				id="tc_cid" type="hidden" value="${param.tc_cid }" /> <input
				class="layui-input" id="te_name" type="hidden"
				value="${param.te_name }" />
			<c:if test="${param.status=='未结课' }">
				<input class="layui-input" id="status1" type="hidden"
					readonly="readonly" value="0" />
			</c:if>
			<c:if test="${param.status=='已结课' }">
				<input class="layui-input" id="status1" type="hidden"
					readonly="readonly" value="1" />
			</c:if>
			<input class="layui-input" id="te_id" type="hidden"
					readonly="readonly" value="${param.te_id }" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">班级名称</label>
		<div class="layui-input-block" style="width:200">
			<input class="layui-input" type="text" readonly="readonly"
				value="${param.tc_name}" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">课程名称</label>
		<div class="layui-input-block" style="width:200">
			<input class="layui-input" type="text" readonly="readonly"
				value="${param.tc_cname}" />
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">老师名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="empInfo1" lay-filter="empInfo1" lay-verify="required"
				name="empInfo1">
				<option value="${param.te_id }">${param.te_name}</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">老师名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="status" lay-filter="status" lay-verify="required"
				name="status">
				<c:if test="${param.status=='未结课' }">
					<option value="0" selected>未结课</option>
					<option value="1">已结课</option>
					<option value="2">授课中</option>
				</c:if>
				<c:if test="${param.status=='已结课' }">
					<option value="0">未结课</option>
					<option value="1" selected>已结课</option>
					<option value="2">授课中</option>
				</c:if>
				<c:if test="${param.status=='授课中' }">
					<option value="0">未结课</option>
					<option value="1">已结课</option>
					<option value="2" selected>授课中</option>
				</c:if>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
		</div>
	</div>
</form>

<script src="../../layui/layui.all.js"></script>

<script>
	var form,
		layedit,
		layer,
		laydate;

	$ = layui.jquery;

	layui.use([ 'form' ], function(gg) {
		form = layui.form;
		layer = layui.layer
		layedit = layui.layedit
		laydate = layui.laydate;

		loadSelectData($('#tc_cid').val());

		form.on('submit(formDemo)', function(data) {
			if (data.field.empInfo1 == $('#te_id').val() && data.field.status==$('#status1').val()) {
				layer.alert('无修改', function(index) {
					layer.close(index);
					window.parent.layer.closeAll();
				});
				return false;
			} else {
				layer.confirm('确认修改么', function(index) {
					$.post('/giveLessons/editGiveLessonsTeacher', data.field, function(msg) {
						if (msg == "ok") {
							layer.alert('修改成功', function(index) {
								layer.close(index);
								window.parent.layer.closeAll();
							});
						} else {
							layer.alert('修改失败', function(index) {
								layer.close(index);
								window.parent.layer.closeAll();
							});
						}
					});
				});
				return false;
			}
		});
	});

	function loadSelectData(tc_cid) {
		$.ajax({
			url : '/giveLessons/loadSelectDataByScId',
			method : 'POST',
			data : {
				'sc_id' : tc_cid
			},
			success : function(msg) {
				var role = document.getElementById("empInfo1");
				$.each(msg, function(index, data) {
					if (data.te_name != $('#te_name').val()) {
						var option = document.createElement("option");
						option.setAttribute("value", data.te_id);
						option.innerText = data.te_name;
						role.appendChild(option);
					}
				});
				form.render("select");
			}
		});
	}
</script>
