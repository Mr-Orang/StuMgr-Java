<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
 <head>
 <script type="text/javascript" src="${pageContext.request.contextPath }../easyui/jquery.min.js"></script>	
<link rel="stylesheet" href="../../layui/css/layui.css">
<link rel="stylesheet" href="css/cued.css">
</head>
<script src="js/cued.js" type="text/javascript"></script>
<script src="../../layui/layui.all.js"></script>
<body>
	<script type="text/javascript">
		$(function(){
			$("#logins").click(function(){
				 alert("login");			
			})
		})
	</script>
	<div style="text-align: center;margin-top: 100px">
    	<div class="layui-input-inline" style="margin:auto">
    		<input name="userid" type="text" name="password" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
    	</div><br/><br/>
    	<div class="layui-input-inline" style="margin:auto;">
    		<input name="pswd" type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    	</div><br/><br>
    	<button id="logins"class="layui-btn layui-btn-radius layui-btn-primary">登录</button>
	</div>
  		
	  
</body>
</html>
     