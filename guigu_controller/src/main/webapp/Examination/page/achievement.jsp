<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'achievement.jsp' starting page</title>
    
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
  <div style="padding: 15px;">
    <div class="layui-progress">
  <div class="layui-progress-bar" lay-percent="100%"></div>
</div>
    </div>
    历史成绩 <br>
  </body>
  
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  });
</script>
</html>
