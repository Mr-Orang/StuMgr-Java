<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'EmpCourse.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>

<body>
	<div class="demoTable">
		搜索ID：
		<div class="layui-inline">
			<input class="layui-input" id="ec_id" autocomplete="off">
		</div>
		课程名称：
		<div class="layui-inline">
			<input class="layui-input" id="tc_cname" autocomplete="off">
		</div>
		老师名称：
		<div class="layui-inline">
			<input class="layui-input" id="te_name" autocomplete="off">
		</div>
		<button class="layui-btn" data-type="reload">搜索</button>
		<button class="layui-btn" data-type="add">新增</button>
	</div>

	<table id="demo" lay-filter="text1"></table>

	<script src="../../layui/layui.all.js"></script>

	<!-- 操作列按钮 -->
	<script type="text/html" id="barDemo">
		<!--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>-->
  		<a class="layui-btn layui-btn-xs" lay-event="edit">启用</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">停用</a>
	</script>
	<!-- 添加按钮 -->
	<script type="text/html" id="add">
		<a class="layui-btn layui-btn-danger layui-btn-add" lay-event="del">添加</a>
	</script>
	<!-- table -->
	<script>
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#demo',
				url : '/empCourse/queryEmpCourseList', //数据接口
				page : true, //开启分页
				loading : true, //加载条
				cols : [ [ //表头
					{
						field : 'ec_id',
						title : 'ID',
						sort : true,
						fixed : 'left'
					}, {
						field : 'tc_cname',
						title : '课程名称',
					}, {
						field : 'te_name',
						title : '员工名称',
					}, {
						field : 'status',
						title : '状态',
					}, {
						field : '',
						title : '操作',
						toolbar : '#barDemo'
					}
				] ],
			});
			//操作按钮业务
			table.on('tool(text1)', function(obj) {
				var data = obj.data;
				$ = layui.jquery;
				if (obj.event === 'detail') {
	
				} else if (obj.event === 'del') {
					if (data.status == "不可用") {
						layer.alert('已经时停用状态了哦', function(index) {
							layer.close(index);
							table.reload('demo');
						});
					} else {
						layer.confirm('确定停用么', function(index) {
							$.ajax({
								url : '/empCourse/updateStatus',
								method : 'POST',
								data : {
									'ec_id' : data.ec_id
								},
								success : function(msg) {
									layer.close(index);
									if (msg == 'ok') {
										layer.alert('以修改状态为不可用', function(index) {
											layer.close(index);
											table.reload('demo');
										});
									} else {
										layer.alert('修改失败', function(index) {
											layer.close(index);
											table.reload('demo');
										});
									}
								}
							});
						});
					}
				} else if (obj.event === 'edit') {
					//layer.alert('编辑行：<br>' + JSON.stringify(data))
					if (data.status == "可用") {
						layer.alert('已经是启用状态了哦', function(index) {
							layer.close(index);
							table.reload('demo');
						});
					} else {
						layer.confirm('确定启用么', function(index) {
							$.ajax({
								url : '/empCourse/updateStatus2',
								method : 'POST',
								data : {
									'ec_id' : data.ec_id
								},
								success : function(msg) {
									if (msg == "ok") {
										layer.alert('以修改状态为可用', function(index) {
											layer.close(index);
											table.reload('demo');
										});
									} else {
										layer.alert('修改失败', function(index) {
											layer.close(index);
											table.reload('demo');
										});
									}
								}
							});
						});
					}
				}
			});
	
			var $ = layui.$,
				active = {
					//新增按钮业务
					add : function() {
						layer.open({
							type : 2,
							title : '新增',
							area : [ '500px', '300px' ],
							content :'AddEmpCourse.jsp',
							end : function() {
								table.reload('demo');
							}
						});
					},
					//搜索按钮业务
					reload : function() {
						var ec_id = $('#ec_id');
						var tc_cname = $('#tc_cname');
						var te_name = $('#te_name');
						//执行重载
						table.reload('demo', {
							page : {
								curr : 1
							},
							where : {
								'ec_id' : ec_id.val(),
								'tc_cname' : tc_cname.val(),
								'te_name' : te_name.val()
							}
						});
					}
				};
			$('.demoTable .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
		});
	</script>
</body>
</html>
