<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>阶段添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	
<link rel="stylesheet" href="../../layui/css/layui.css">
<script type="text/javascript" src="layui/layui.all.js"></script>
 <script src="/curriculumAndEduoffice/js/stage.js" type="text/javascript"></script> 
  </head>
  <body>
	<form class="layui-form layui-panel" id="tc_sname" name="tc_sname" action="<%=request.getContextPath()%>/addStage.action";
	method="POST" lay-filter="first">
	<div class="layui-form-item">
	<label class="layui-form-label">阶段名称</label>
	<div class="layui-input-inline">
	<select name="power" lay-verify="required" lay-filter="interest-search"lay-search>
	<option value=""></option>
	<option value="S1">S1</option>
	<option value="S2">S2</option>
	<option value="S3">S3</option>
	<option value="S4">S4</option>
	</select>
	</div>
	</div>
	<div class="layui-form-item">
	<label class="layui-form-label">阶段状态</label>
	<div class="layui-input-inline">
	<select name="tc_sstatus" lay-verify="required" lay-filter="interest-search"lay-search>
	<option value=""></option>
	<option value="可用">可用</option>
	<option value="停用">停用</option>
	</select>
	</div>
	</div>
	<div class="layui-form-item">
	<div class="layui-input-block">
	<button class="layui-btn" lay-submit lay-filter="*">添加</button>
	<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	</div>
	</div>
	</form>
</body>
</html>
