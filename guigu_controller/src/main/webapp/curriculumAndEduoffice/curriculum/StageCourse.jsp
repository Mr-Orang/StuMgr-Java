<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程阶段信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
<script type="text/javascript">
	function addstage()
	{
	layer.open({
    	 type: 2,
            skin: 'layui-layer-demo', //样式类名
            title: '阶段添加',
            closeBtn: 1, //不显示关闭按钮
            anim: 2,
            area: ['893px', '600px'],
            shadeClose: true, //开启遮罩关闭
            content: 'Addstage.jsp'
});
}
	function updatestage(){
	layer.open({
	type:3,
	skin:'layui-layer-demo',
	title:'阶段修改',
	closeBtn:1,
	anim:2,
	area:['893px','600px'],
	shadeClose:true,
	content:'Updatestage.jsp'
});
}
	function deletestage(){
	var data = obj.data;
	if(obj.event=='del'){
	layer.confirm('真的删除行吗?',function(deletestage){
	$.ajax({
	url:'/deletestage.action',
	type:"POST",
	data:{"tc_sid":data.tc_sid},
	success:function(data){
	obj.del();
	layer.close(del);
	layer.msg("删除成功");
	},
	error:function(data){
	layer.msg("删除失败");
	}
	});
	});
	
	}
	
	}
		</script>
		</head>
		<body>	
		<ul class="layui-nav layui-bg-green" lay-filter="">
		<li class="layui-nav-item"><a onclick="addstage()">新增阶段</a></li>
		<li class="layui-nav-item"><a onclick="updatestage()">修改阶段</a></li>
		<li class="layui-nav-item"><a onclick="deletestage()">删除</a></li>
		<li class="layui-nav-item">
    		<a href="javascript:;">阶段分类</a>
   			<dl class="layui-nav-child"> <!-- 二级菜单 -->
      			<dd><a href="">S1</a></dd>
      			<dd><a href="">S2</a></dd>
      			<dd><a href="">S3</a></dd>
      			<dd><a href="">S4</a></dd>
    		</dl>
  		</li>
  		<li class="layui-nav-item">		<a href="javascript:;">阶段状态</a>
   			<dl class="layui-nav-child"> <!-- 二级菜单 -->
      			<dd><a href="">可用</a></dd>
      			<dd><a href="">不可用</a></dd>
    		</dl>
  		</li>
  		<li class="layui-nav-item"><a>阶段名称</a></li>
  		<li class="layui-nav-item"><input type="text" name="tc_sname" id="tc_sname" placeholder="请输入" class="layui-input" /></li>
  		<div class="layui-inline">
    <li class="layui-nav-item"><a>时间段</a></li>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test6" placeholder=" - ">
      </div>
  </div>
  <button class="layui-btn layui-btn-normal">查询！</button>
  		</ul>
  		<!-- 数据表格！ -->
 <table id="demo" lay-filter="test"></table>
 	
 
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
	<script>
		layui.use('laydate', function(){
  		var laydate = layui.laydate;
  			  //日期范围
  			laydate.render({
    		elem: '#test6'
    		,range: true
  		});
  		})
		layui.use('table',function(){
			var table=layui.table;
			
			//表格数据
		table.render({
			elem:'#demo',
			height:520,
			groups:3,
			url:'/queryStage.action',//数据接口
			page:true,//开启分页
			cols:[[
			{
				type : 'checkbox',
				align:'center',
				fixed : 'left'
			},
			{
				field: 'tc_sid',
				 sort: true,
			 	title: '阶段编号',
			 	width:120, 
			   	fixed: 'left'
			},
			{
				field: 'tc_sname', 
				title: '阶段名称',
				width:100
			 },
			
		
			 {
			  	field: 'tc_sstatus',
			  	title: '阶段状态', 
			  	align:'center',
			  	width: 100
			  },
			]]
		})
		})
	</script>
</body>
</html>
