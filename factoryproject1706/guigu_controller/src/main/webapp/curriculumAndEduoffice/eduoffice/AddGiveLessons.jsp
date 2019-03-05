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
		<label class="layui-form-label">班级名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="class1" lay-filter="class1" lay-verify="required"
				name="class1">
				<option value="">请选择班级</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">课程名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="course" lay-filter="course" lay-verify="required"
				name="course">
				<option value="">请选择课程</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">老师名称</label>
		<div class="layui-input-block" style="width:200">
			<select id="empInfo1" lay-filter="empInfo1" lay-verify="required"
				name="empInfo1">
				<option value="">请选择身份</option>
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

		loadClassSelect();

		form.on('select(class1)', function(data) {
			var val = data.value;
			layui.use([ 'form' ], function() {
				form = layui.form;
				layer = layui.layer
				layedit = layui.layedit
				laydate = layui.laydate;

				loadCourseSelectByTcId(val);

				form.on('select(course)', function(data) {
					var val = data.value;
					layui.use([ 'form' ], function() {
						form = layui.form;
						layer = layui.layer
						layedit = layui.layedit
						laydate = layui.laydate;

						loadEmpSelectByScId(val);
					});
				});

			});
		});

		form.on('submit(formDemo)', function(data) {
			//ajax 提交
			$.post('/giveLessons/addGiveLessons', data.field, function(msg) {
				if (msg == "ok") {
					layer.alert('添加成功', function(index) {
						layer.close(index);
						window.parent.layer.closeAll();
					});
				} else {
					layer.alert('添加失败', function(index) {
						layer.close(index);
						window.parent.layer.closeAll();
					});
				}
			});
			
			return false;
		});
	});
	//加载下拉框班级信息
	function loadClassSelect() {
		$.ajax({
			url : '/giveLessons/loadClassSelect',
			method : 'POST',
			data : {},
			success : function(msg) {
				var role = document.getElementById("class1");
				if (msg.length == 0) {
					$("#class1").empty();
					var option = document.createElement("option");
					option.setAttribute("value", '');
					option.innerText = '暂无可用班级';
					role.appendChild(option);
				} else {
					$.each(msg, function(index, data) {
						var option = document.createElement("option");
						option.setAttribute("value", data.tc_id);
						option.innerText = data.tc_name;
						role.appendChild(option);
					});
				}
				form.render("select");
			}
		});
	}
	//根据班级id加载课程下拉框
	function loadCourseSelectByTcId(tcid) {
		$.ajax({
			url : '/giveLessons/loadCourseSelectByTcId',
			method : 'POST',
			data : {
				'tc_id' : tcid
			},
			success : function(msg) {
				var role = document.getElementById("course");
				if (msg.length == 0) {
					$("#course").empty();
					var option = document.createElement("option");
					option.setAttribute("value", '');
					option.innerText = '暂无可用课程';
					role.appendChild(option);
				} else {
					$("#course").empty();
					$("#empInfo1").empty();
					var option = document.createElement("option");
					option.setAttribute("value", '');
					option.innerText = '请选择课程';
					role.appendChild(option);
					$.each(msg, function(index, data) {
						var option = document.createElement("option");
						option.setAttribute("value", data.tc_cid);
						option.innerText = data.tc_cname;
						role.appendChild(option);
					});
				}
				form.render("select");
			}
		});
	}
	function loadEmpSelectByScId(tc_cid) {
		$.ajax({
			url : '/giveLessons/loadSelectDataByScId',
			method : 'POST',
			data : {
				'sc_id' : tc_cid
			},
			success : function(msg) {
				var role = document.getElementById("empInfo1");
				if (msg.length == 0) {
					$("#empInfo1").empty();
					var option = document.createElement("option");
					option.setAttribute("value", '');
					option.innerText = '暂无老师可指定该课程';
					role.appendChild(option);
				} else {
					$("#empInfo1").empty();
					var option = document.createElement("option");
					option.setAttribute("value", '');
					option.innerText = '请选择老师';
					role.appendChild(option);
					$.each(msg, function(index, data) {
						var option = document.createElement("option");
						option.setAttribute("value", data.te_id);
						option.innerText = data.te_name;
						role.appendChild(option);
					});
				}
				form.render("select");
			}
		});
	}
</script>
