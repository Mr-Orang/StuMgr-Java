<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
<form class="layui-form" action="">
	<div class="layui-form-item">
		<label class="layui-form-label"></label>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label"></label>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">员工名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="empInfo1" lay-filter="empInfo1" lay-verify="required"
				name="empInfo1">
				<option value="">请选择身份</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">课程名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="courseInfo1" lay-filter="courseInfo1"
				lay-verify="required" name="courseInfo1">
				<option value="">请选择课程</option>
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
	var info;
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
		//selectCourseInfo(); // 调用查询方法
		queryCourseInfo();
		selectEmpInfo();

		form.on('select(empInfo1)', function(data) {
			var val = data.value;
			layui.use([ 'form' ], function() {
				form = layui.form;
				layer = layui.layer
				layedit = layui.layedit
				laydate = layui.laydate;
				selectCourseInfo(val);
			});
		});
		form.on('submit(formDemo)', function(data) {
			//ajax 提交
			$.post('/empCourse/addEmpCourse', data.field, function(msg) {
				if (msg == "ok") {
					layer.confirm('添加成功', function(index) {
						layer.close(index);
						window.parent.layer.closeAll();
					});
				}else{
					layer.confirm('添加失败', function(index) {
						layer.close(index);
						window.parent.layer.closeAll();
					});
				}
				
			});
			return false;
		});
	});

	function selectCourseInfo(emp_id) {
		$.ajax({
			url : '/courseInfo/loadSelectCourseInfo',
			method : 'POST',
			data : {
				'emp_id' : emp_id
			},
			success : function(msg) {
				var role = document.getElementById("courseInfo1");
				$("#courseInfo1").empty();
				for (var j = 0; j < info.length; j++) {
					var option = document.createElement("option");
					option.setAttribute("value", info[j].tc_cid);
					option.innerText = info[j].tc_cname;
					role.appendChild(option);
				}
				for (var k = 0; k < msg.length; k++) {
					for (var i = 0; i < role.length; i++) {
						if (msg[k].tc_cid == role[i].value) {
							role[i] = null;
						}
					}
				}
				form.render("select");
			}
		});
	}
	function queryCourseInfo() {
		$.ajax({
			url : '/empCourse/queryCourseInfoVo',
			method : 'POST',
			data : {},
			success : function(msg) {
				info = msg;
			}
		});
	}
	function selectEmpInfo() {
		$.ajax({
			url : '/empCourse/loadEmpSelect',
			method : 'POST',
			data : {},
			success : function(msg) {
				var role = document.getElementById("empInfo1");
				$.each(msg, function(index, data) {
					var option = document.createElement("option");
					option.setAttribute("value", data.te_id);
					option.innerText = data.te_name;
					role.appendChild(option);
				});
				form.render("select");
			}
		});
	}
</script>