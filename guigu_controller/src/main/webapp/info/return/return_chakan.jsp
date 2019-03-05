<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!--学生端复学查询-->
<title>查看是否休学</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- bootstrap核心样式文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<!-- jquery库 必须在其他js库前引入-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.1.1.min.js"></script>
<!-- bootstrap库 必须在其他js库前引入-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- application库 必须在其他js库前引入-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/application.js"></script>
<!-- holder库 必须在其他js库前引入-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/holder.js "></script>
<!-- 引入layui.css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
<!-- 引入layui.js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<!--样式-->
<style type="text/css">
/*背景图片*/
body
  { 
  background-image:url('/info/img/chaxun.png');
  }
</style>
<!--复学之前查看休学记录根据编号和身份证-->
<script type="text/javascript">
	
	function retuden(){
			//获取到复学时间	
			var tex=$("#lay").val().trim();
			if(tex==""){
				alert("请输入学号/身份证号码");
			}else{
			$.ajax({
				    url: "/SelStucid.action",
         			type: "POST",
         			data:{'stuid': tex},
        		 	success:function(data){
        		 			alert(data);
        		 	 	 if(data==1){
        		 	 	 		alert("身份正确")
        		 	 	 }else if(data==0){
							 alert("你输入的学号/身份证号码错误！");
        		 	 	 }
        			},
        			error:function(data){
         				alert(2);
         			},
			})
			}
		}
		
</script>
</head>
<body >
	<!--根据学号和身份证查看是否休学-->
	<div class="login-main" align="center">
		<form class="layui-form">
			<br><br><br><br><br><br><br><br>
			<div class="layui-input-inline">
				<input id="lay" type="text" required placeholder="請輸入:学号/身份证"
					class="layui-input">
			</div>
			<br><br><br>
			<div class="layui-input-inline login-btn">
				<button onclick="retuden()" class="layui-btn">查看休学信息</button>
			</div>
		</form>
	</div>
</body>