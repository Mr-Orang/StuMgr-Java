<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'GiveLessons.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">

</head>

<body>
	<div class="demoTable1">
		班级名称：
		<div class="layui-inline">
			<input class="layui-input" id="tc_name" autocomplete="off">
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
	<table id="demo1" lay-filter="text2"></table>

	<script src="../../layui/layui.all.js"></script>

	<!-- 操作列按钮 -->
	<script type="text/html" id="barDemo1">
		<!--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>-->
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">结课</a>
	</script>

	<!-- 添加按钮 -->
	<script type="text/html" id="add">
		<a class="layui-btn layui-btn-danger layui-btn-add" lay-event="del">添加</a>
	</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#demo1',
				url : '/giveLessons/queryGiveLessons', //数据接口
				page : true, //开启分页
				loading : true, //加载条
				cols : [ [ //表头
					{
						field : 'gl_id',
						title : 'ID',
						sort : true,
						fixed : 'left'
					}, {
						field : 'tc_name',
						title : '班级名称',
					}, {
						field : 'tc_cid',
						title : '课程编号',
						hide : true
					}, {
						field : 'tc_cname',
						title : '课程名称',
					}, {
						field : 'te_id',
						title : '老师编号',
						hide : true
					},{
						field : 'te_name',
						title : '老师名称',
					}, {
						field : 'status',
						title : '状态',
					}, {
						field : '',
						title : '操作',
						toolbar : '#barDemo1'
					}
				] ],
			});
	
			//操作列业务
			table.on('tool(text2)', function(obj) {
				var tc_name = obj.data.tc_name;
				var tc_cname = obj.data.tc_cname;
				var te_name = obj.data.te_name;
				var tc_cid = obj.data.tc_cid;
				var gl_id = obj.data.gl_id;
				var data = obj.data;
				$ = layui.jquery;
				if (obj.event === 'edit') {
					layer.open({
						type : 2,
						title : '编辑',
						area : [ '500px', '400px' ],
						content : 'curriculumAndEduoffice/eduoffice/EditGiveLessons.jsp?tc_name=' + tc_name + '&tc_cname=' + tc_cname + '&te_name=' + te_name + '&tc_cid=' + tc_cid + '&gl_id=' + gl_id+'&status='+obj.data.status+'&te_id='+obj.data.te_id,
						end : function() {
							table.reload('demo1');
						}
					});
				} else if (obj.event === 'del') {
					if (obj.data.status == '已结课') {
						layer.alert('该课程已结课', function(index) {
							layer.close(index);
							window.parent.layer.closeAll();
							table.reload('demo1');
						});
					} else {
						layer.confirm('确认结课么', function(index) {
							$.ajax({
								url : '/giveLessons/editGiveLessonsStatus',
								method : 'POST',
								data : {
									'gl_id' : gl_id
								},
								success : function(msg) {
									if (msg == "ok") {
										layer.alert('已结课', function(index) {
											layer.close(index);
											window.parent.layer.closeAll();
											table.reload('demo1');
										});
									} else {
										layer.alert('结课失败', function(index) {
											layer.close(index);
											window.parent.layer.closeAll();
											table.reload('demo1');
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
							area : [ '500px', '400px' ],
							content : 'curriculumAndEduoffice/eduoffice/AddGiveLessons.jsp',
							end : function() {
								table.reload('demo1');
							}
						});
					},
					//搜索按钮业务
					reload : function() {
						var tc_name = $('#tc_name');
						var tc_cname = $('#tc_cname');
						var te_name = $('#te_name');
						//执行重载
						table.reload('demo1', {
							page : {
								curr : 1
							},
							where : {
								'tc_name' : tc_name.val(),
								'tc_cname' : tc_cname.val(),
								'te_name' : te_name.val()
							}
						});
					}
				};
			$('.demoTable1 .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
		});
	</script>
</body>
</html>
