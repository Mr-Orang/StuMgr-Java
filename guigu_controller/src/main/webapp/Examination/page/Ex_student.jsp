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
	
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
<link rel="stylesheet" href="../../layui/css/layui.css">
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
  </head>
  
  <body style="background-color: #E0E0E0">
  <div align="center" style="margin-top:60px;">
  <div style="width: 40%;height: 70%;background-color: #FFFFFF">
  <img src="${pageContext.request.contextPath }Examination/img/6.png"><br>
  <i>当前准考证号：jatc00100001</i><br>
  <i>考试时间：30</i>分钟<br>
  <i>考试分数：100</i><br>
  <i>考试规则</i><br>
  <i>如果考试异常中断请，<br>及时退出并按照同样步骤进行考试</i><br>
  <button class="layui-btn layui-btn-lg layui-btn-normal" id="kaoshi">进入考试
  <i class="layui-icon layui-icon-triangle-r"></i>
  </button>
  <script>
$("#kaoshi").click(function(){
		window.location.href="/Examination/page/Ex_student2.jsp";
})
  </script>
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
