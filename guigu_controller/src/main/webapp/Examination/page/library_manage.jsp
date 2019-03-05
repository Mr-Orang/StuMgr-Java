<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'library_manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="../../layui/css/layui.css">
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>

  </head>
  
  <body>
  <div id="body" align="center">
   <div class="layui-bg-gray" style="height: 100%">
  <div style="padding: 15px;">
    <div class="layui-progress">
  <div class="layui-progress-bar" lay-percent="100%"></div>
</div>
    </div>
 
    <div class="layui-card" id="buttonboby" align="center" style="width: 70%;height: 90%" >
   <button class="layui-btn" style="height: 70px;width: 400px">题目数量<i>5</i> </button>
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     <button class="layui-btn" style="height: 70px;width: 400px">可用题目<i>4</i></button> 
  <div class="layui-card-body">
 
 	<button class="layui-btn layui-btn-normal">
 	<i class="layui-icon layui-icon-add-1"></i>
 	添加
 	</button>
  <table id="demo" lay-filter="test"></table>
  <script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 312
    ,url: '' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'username', title: '用户名', width:80}
      ,{field: 'sex', title: '性别', width:80, sort: true}
      ,{field: 'city', title: '城市', width:80} 
      ,{field: 'sign', title: '签名', width: 177}
      ,{field: 'experience', title: '积分', width: 80, sort: true}
      ,{field: 'score', title: '评分', width: 80, sort: true}
      ,{field: 'classify', title: '职业', width: 80}
      ,{field: 'wealth', title: '财富', width: 135, sort: true}
    ]]
  });
  
});
</script>
  </div>
</div>
    
    <br>
     </div>
    </div>
  </body>
  
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  });
</script>
</html>
