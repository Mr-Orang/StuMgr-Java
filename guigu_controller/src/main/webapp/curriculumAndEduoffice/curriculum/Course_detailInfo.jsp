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
	<!-- 	<form class="layui-form layui" action=""> -->
	<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md1">
				<strong>课程编号:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_cid }
			</div>
			<div class="layui-col-md1">
				<strong>课程名称:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_cname }
			</div>
			<div class="layui-col-md1">
				<strong>课程别名:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_calias == null ? "(暂无)" : course.tc_calias }
			</div>
			<div class="layui-col-md1">
				<strong>章节数量:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_cnumber }
			</div>
		</div>
		<br>
		<div class="layui-row">
			<div class="layui-col-md1">
				<strong>课程状态:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_cstatus == 0 ? "在线" : course.tc_cstatus == 1 ? "下线" : "待课" }
			</div>
			<div class="layui-col-md1">
				<strong>上线日期:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_cdate }
			</div>
			<div class="layui-col-md1">
				<strong>提交人:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.te_name }
			</div>
			<div class="layui-col-md1">
				<strong>阶段:</strong>
			</div>
			<div class="layui-col-md2">
				${ course.tc_sname }
			</div>
		</div>
		<br>		

		<div class="layui-row">
			<div class="layui-col-md1">
				<strong>课程简介:</strong>
			</div>
			<div class="layui-col-md10">
				${course.tc_cdescribe }
			</div>
		</div>
		<br>
		<div class="layui-row">
			<div class="layui-col-md1">
				<strong>课程大纲:</strong>
			</div>
			<div>
				<button class="layui-btn layui-btn-xs">下载大纲</button>
				<span>${course.tc_coutline }</span>
			</div>
		</div>
		<br>
		<div class="layui-row">
			<div  class="layui-col-md12">
				<strong>章节列表</strong>	
				<table id="section_table"></table>
			</div>
		</div>
	</div>
	<!-- 数据表格！ -->

	<!-------------------------自定义js----------------------------------------->
	<script type="text/javascript">
		layui.use(['table', 'layer'], function() {
			/**
			 *事件转HTML元素装饰器
			 */
			function eventGetAttrsWraper(callback) {
				return function wrap(ev) {
					let s = ev.srcElement.attributes;
					return callback(s);
				}
			}
			var table = layui.table;
			var layer = layui.layer;
			table.render({
				id : 'demo',
				where : {
					tc_cid: '${course.tc_cid}',
				},
				elem : '#section_table',
				height : 298,
				groups : 3,
				url : '/courseInfo/querySectionsByCourseId', //数据接口
				page : true, //开启分页
				limit: 5,
				limits: [5, 10, 15],
				cols : [[
					{
						field : 'tc_chid',
						sort : true,
						title : '章节编号',
						width : "30%"
					},
					{
						field : 'tc_chname',
						title : '章节名称',
						width : "50%"
					},
					{
						title : '操作',
						width : "20%",
						align : "center",
						templet : function(button) {
						console.log(button.tc_chstatus);
									return `
									 		<button class="foo layui-btn layui-btn-danger layui-btn-xs ${'${button.tc_chstatus===1?"layui-btn-disabled":""}'}" ${'${button.tc_chstatus===1?"disabled":""}'} tc_chid="${'${button.tc_chid}'}">删除章节</button>
										`;
						}
					}
				]],
				done: function(resp, curr, count){
					let s = document.querySelectorAll('.foo');
					for (let x of s) {
						x.onclick = eventGetAttrsWraper(function (attrs) {
							let value = attrs.tc_chid.value;
							layer.confirm('是否将'+ value +'删除?', {title: '询问'}, function(idx) {
								fetch("/courseInfo/deleteCourseSectionById?s_id="+value)
								.then(resp => resp.text())
								.then(data => {
									if (data === "ok") {
										layer.msg('删除成功');
										table.reload('demo');
									} else {
										layer.msg('删除失败');
									}
								}).catch(error => {
									layer.msg('操作失败');
								});
								layer.close(idx);
							}, function(idx) {
								layer.close(idx);
							});
						})
					}
				}
			});
		});
	</script>
</body>
</html>
