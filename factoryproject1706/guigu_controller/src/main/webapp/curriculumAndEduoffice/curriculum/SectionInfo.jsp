<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>章节信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>

<body>
	<ul class="layui-nav layui-bg-green" lay-filter="">
		<li class="layui-nav-item"><a onclick="add_section_info()"
			href="javascript: void(0)">新增章节</a></li>
		<li class="layui-nav-item"><a href="javascript: void(0)">删除</a></li>
		<li class="layui-nav-item"><a href="javascript:;">阶段分类</a>
			<dl class="layui-nav-child" id="stage_view">
			</dl>
		</li>
		<li class="layui-nav-item"><a href="javascript:;">课程分类</a>
			<dl class="layui-nav-child" id="course_view">
			</dl>
		</li>
		<li class="layui-nav-item"><a href="javascript:;">章节状态</a>
			<dl class="layui-nav-child" id="status_view">
			</dl>
		</li>
		
		<li class="layui-nav-item"><a>章节名称</a></li>
		<li class="layui-nav-item"><input type="text" name="tc_cname"
			id="tc_cname" placeholder="请输入" class="layui-input" /></li>
		<div class="layui-inline">
			<li class="layui-nav-item"><a>时间段</a></li>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" id="test6" placeholder="所有时间"
					style="width: 200px">
			</div>
		</div>
	</ul>
	<!-- 数据表格！ -->
	<table id="Section_table" lay-filter="test"></table>


	<!-- -------------------------------js部分--------------------------------------------- -->
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
	<script>
	
	//弹出章节添加页面
	
	function add_section_info() {
		layer.open({
			offset: '50px',//顶部距离
			type : 2,
			skin : 'layui-layer-demo', //样式类名
			title : '章节添加',
			closeBtn : 1, //不显示关闭按钮
			anim : 2,
			area : [ '70%', '85%' ],
			shadeClose : false, //开启遮罩关闭
			content : '${pageContext.request.contextPath}/curriculumAndEduoffice/curriculum/Addsection.jsp',
		});
	}
	
	//弹出章节详细详细页面
	function show_course_info(sid) {
		layer.open({
		
			offset: '50px',//top距离为50
			type : 2,
			skin : 'layui-layer-demo', //样式类名
			title : '章节详情',
			closeBtn : 1, //不显示关闭按钮
			anim : 2,//弹出方式
			area : [ '85%', '80%' ],
			shadeClose : false, //开启遮罩关闭
			content : '/courseInfo/queryCourseInfoById?sid='+sid,
		});
	}
	
	//弹出章节信息修改页面
	function update_course_info(sid) {
		layer.open({
			offset: '50px',
			type : 2,
			skin : 'layui-layer-demo', //样式类名
			title : '编辑章节信息',
			closeBtn : 1, //不显示关闭按钮
			anim : 2,
			area : [ '75%', '75%' ],
			shadeClose : false, //开启遮罩关闭
			content : '${pageContext.request.contextPath}/curriculumAndEduoffice/curriculum/Section_UpdateInfo.jsp',
		});
	}
		<!----------------------------页面优化模板-------------------------->
	window.onload = function() {
			function eventGetAttrsWraper(callback) {
				return function wrap(ev) {
					let s = ev.srcElement.attributes;
					return callback(s);
				}
			}
			var jieduan = [];
			var status = [
				{
					id : "s1",
					code : -1,
					name : "所有"
				},
				{
					id : "s2",
					code : 0,
					name : "在线"
				},
				{
					id : "s3",
					code : 1,
					name : "下线"
				},
				{
					id : "s4",
					code : 2,
					name : "待课"
				}
			];
			let wheres = {};
			
			//章节数据表格设置
			layui.use('table', function() {
		
				var table = layui.table;
				table.render({
					id : 'Section_table',
					where : {
						cstatus : -1,
					},
					elem : '#Section_table',
					height : 520,
					groups : 3,
					url : '/courseInfo/queryAllCourseInfo', //数据接口
					page : true, //开启分页
					cols : [ [
						{
							type : 'checkbox',
							align : 'center',
							fixed : 'left'
						},
						{
							field : 'tc_cid',
							sort : true,
							title : '章节编号',
							width : 120,
							fixed : 'left'
						},
						{
							field : 'tc_cname',
							title : '章节名称',
							width : 150
						},
						{
							//连接查询阶段表 t_stage_course
							field : 'tc_sname',
							title : '章节阶段',
							sort : true,
							width : 120,
						//sort: true
						},
						{
							field : 'tc_cdate',
							title : '上传日期',
							sort : true,
							width : 220
						},
						{
							field : 'tc_cnumber',
							title : '章节数目',
							sort : true,
							width : 120
						},
						{
							field : 'tc_cdescribe',
							title : '章节介绍',
							width : 200
						},
						{
							field : 'tc_cstatus',
							title : '章节状态',
							sort : true,
							align : 'center',
							width : 120,
							templet : function(res) {
								if (res.tc_cstatus == 0) {
									return "在线";
								}
								if (res.tc_cstatus == 1) {
									return "下线";
								}
								if (res.tc_cstatus == 2) {
									return "待课";
								}
		
							}
						},
						{
							title : '操作',
							width : 220,
							templet : function(button) {
								return `
							  		<button class="layui-btn layui-btn-xs" onclick="show_course_info('${'${button.tc_cid}'}');">查看详情</button>
									<button class="layui-btn layui-btn-normal layui-btn-xs" onclick="update_course_info('${'${button.tc_cid}'}');"><i class="layui-icon"></i>修改</button>
									<button class="delbtn layui-btn layui-btn-danger layui-btn-xs" tc_cid='${'${button.tc_cid}'}' tc_cstatus='${'${button.tc_cstatus}'}'><i class="layui-icon"></i>删除</button>
									`
							}
						}
					] ],
					done(){
						document.querySelectorAll(".delbtn").forEach(elmt => {
							//章节删除方法
							
							elmt.onclick = eventGetAttrsWraper(function(attrs){
								let tc_cstatus = attrs.tc_cstatus.value;
								let tc_cid = attrs.tc_cid.value;
								if(tc_cstatus=='1'){
									layer.alert('该章节已下线', {icon: 5});
								}else{
									//弹出提示框
									layer.confirm('确认下线该章节吗?',{icon:2,title:'警告'}, function(index){
										//删除url
							  			fetch("/courseInfo/deleteCourseById?sid="+tc_cid)
										.then(resp => resp.text())
										.then(text => {
											if (text==='ok') {
												layer.close(index);
												table.reload('Section_table');
												layer.msg('下线成功');
											}
										});
							  			
									});       
							  	}
							});
						});
					}
				})
			});
			
			layui.use([ "laytpl", "table", "laydate" ], function() {
				let laytpl = layui.laytpl;
				let table = layui.table;
				var laydate = layui.laydate;
	
				//日期范围
				laydate.render({
					elem : '#test6',
					range : true,
					done (value, date, endDate) {
						if (value.length === 0) {
							wheres.sdate = null;
							wheres.edate = null;
							table.reload("Section_table", {
								where : wheres
							});
							return;
						}
						let v = value.split(' - ');
						wheres.sdate = v[0];
						wheres.edate = v[1];
						table.reload("Section_table", {
							where : wheres
						});
					}
				});
	
				let rls = laytpl(`
								{{# for (var x of d.statusList) { }}
								<dd>
									<a id="{{= x.id}}">{{= x.name}}</a>
								</dd>
								{{# } }}`).render({
					statusList : status
				});
				document.querySelector("#status_view").innerHTML = rls;
	
				let jdtpl = laytpl(`
								<dd>
									<a class="bar" tc_sid="" id="jdall">所有</a>
								</dd>
								{{# for (var x of d.jd) { }}
								<dd>
									<a class="bar" tc_sid="{{= x.tc_sid }}">{{= x.tc_sname}}</a>
								</dd>
								{{# } }}`);
	
				// ---------------------------------------------------
	
				fetch("/queryUsableStage.action").then(function(req) {
					return req.json();
				}).then(data => {
/* 					jieduan = data; */
					document.querySelector("#stage_view").innerHTML = jdtpl.render({
						jd : data
					});
/* 					jieduan.unshift({
						"tc_sname" : "jdall",
						"tc_sid" : ""
					}); */
					document.querySelectorAll(".bar").forEach(rl => {
						rl.onclick = eventGetAttrsWraper(function(attrs){
							wheres.sid = attrs.tc_sid.value;
							table.reload('Section_table',{where: wheres});
						});
					});
				});
	
				// -------------------------------------------------------
				status.forEach(function(elt) {
					let a = document.querySelector("#" + elt.id);
					a.onclick = function() {
						wheres.cstatus = elt.code;
						table.reload("Section_table", {
							where : wheres
						});
					}
				});
	
				// -------------------------------------------------------------
	
				document.querySelector("#tc_cname").onkeyup = function(et) {
					let s = et.srcElement.value;
					wheres.cname = s;
					table.reload("Section_table", {
						where : wheres
					});
				}
			});
		}
	</script>

	<!-- 执行删除章节操作进行判断 -->
	<!-- 	<script type="text/javascript">
		var msg ='${requestScope.message}';
		if(msg=="ok"){
			//下线成功提示
	  		layer.alert('章节下线成功!', {icon:1});
		}
	</script> -->
</body>
</html>
