<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'ex_application.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<<<<<<< .mine
	<link rel="stylesheet" href="../../layui/css/layui.css">
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
  </head>
  
  <body>
  <div style="padding: 15px;">
    <div class="layui-progress">
  <div class="layui-progress-bar" lay-percent="100%"></div>
</div>
    </div>
    考试申请 <br>
    
  </body>
  

<link rel="stylesheet" href="../../layui/css/layui.css">
<script src="../../layui/layui.all.js"></script>
<script src="../../layui/layui.js"></script>
</head>

<body>
	<div style="padding: 15px;">
		<div class="layui-progress">
			<div class="layui-progress-bar" lay-percent="100%"></div>
		</div>
	</div>
	<table id="exam_apply_query" lay-filter="test"></table>
	<br>
</body>


<script>
	//JavaScript代码区域
	layui.use('element', function() {
		var element = layui.element;
	});

	layui.use('table', function() {
		var table = layui.table;
		table.render({
			id : 'exam_apply_query',
			elem : '#exam_apply_query',
			url : '${pageContext.request.contextPath}/exam/apply/queryApply.action',
			page : true, //开启分页
			groups : 6,
			cols : [ [
				{
					field : 'apply_id',
					sort : true,
					title : '申请编号'
				//width : 120,
				//fixed : 'left'
				}, {
					field : 'apply_name',
					sort : true,
					title : '申请人'
				}, {
					field : 'apply_reason',
					sort : true,
					title : '申请说明'
				}, {
					field : 'class_name',
					sort : true,
					title : '申请班级'
				}, {
					field : 'take_name',
					sort : true,
					title : '审批名称'
				}, {
					field : 'take_date',
					sort : true,
					title : '审批时间'
				}, {
					field : 'reson',
					sort : true,
					title : '不同意原因'
				}, {
					field : 'apply_state',
					sort : true,
					title : '审批状态'
				}, {
					sort : true,
					title : '操作',
					templet : function(res) {
						if (res.apply_state == 1) {
							return `
							  		<button class="layui-btn layui-btn-xs">查看详情</button>
									<button class="layui-btn layui-btn-xs">考前准备</button>
									`
						} else {
							return `
							  		<button class="layui-btn layui-btn-xs">查看详情</button>
									`
						}

					}
				}
			] ]
		});
	});
</script>
</html>
