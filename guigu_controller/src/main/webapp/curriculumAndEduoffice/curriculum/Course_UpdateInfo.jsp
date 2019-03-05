<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程详细信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
<script src="../../layui/layui.all.js"></script>
<script src="../../layui/layui.js"></script>
</head>

<body>
	<div class="layui-container">
		<!-- 表单元素 -->
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<!-- 添加课程信息时课程ID 后台添加 拼接 加序列  tc_cid -->
				<label class="layui-form-label">课程名称</label>
				<div class="layui-input-block">
					<input type="text" name="tc_cname" id="tc_cname" required
						lay-verify="required" placeholder="请输入课程名称" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">课程别名</label>
				<div class="layui-input-inline">
					<input type="password" name="password" required
						lay-verify="required" placeholder="给这门课程取个别名吧" autocomplete="off"
						class="layui-input">
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">选择阶段</label>
					<div class="layui-input-block">
						<!--课程阶段关联表	t_course_stage -->
						<select name="tc_coid" id="tc_coid" lay-verify="required"
							lay-filter="xmFilter">
							<option value=""></option>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">课程大纲</label>
					<div class="layui-upload-drag" id="test10">
						<i class="layui-icon"></i>
						<p>点击上传课程大纲，或将文件拖拽到此处</p>
					</div>
				</div>
				<!-- 拖拽上传 -->
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">课程描述</label>
					<div class="layui-input-block">
						<textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>

				<!-- --------------元素分割----------------------- -->
		</form>
	</div>
	
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form;
			form.render();
		});
	</script>
</body>