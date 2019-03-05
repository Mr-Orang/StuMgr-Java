<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stustudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- bootstrap核心样式文件 -->
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
  	<!-- jquery库 必须在其他js库前引入-->
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.1.1.min.js"></script>
  	<!-- bootstrap库 必须在其他js库前引入-->
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  	<!-- application库 必须在其他js库前引入-->
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/application.js"></script>
  	<!-- holder库 必须在其他js库前引入-->
  	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/holder.js"></script>
  	
<script type="text/javascript">
$(function(){
stustuinfo={
stureturn:function(){

}
}
})

</script>
  </head>
  <style type="text/css">
  #stustudent{text-align:center;}
  </style>
  <body>
  <div id="stustudent"><h1>学生基本信息</h1></div><br/>
  <table class="table table-striped">
  <tr><td> 学号： ${param.stuid}</td> </tr>
  <tr><td> 姓名： ${param.stuname} </td> </tr>
  <tr> <td>性别： ${param.stusex} </td> </tr>
    <tr><td>日期： ${param.stubirthday} </td></tr>
   <tr><td>身份证号： ${param.stucid}</td>  </tr>
 <tr><td>学生电话： ${param.stuphone}</td> </tr>
 <tr><td>家长电话： ${param.parphone}</td>  </tr>
 <tr><td> 家庭地址： ${param.address} </td></tr>
 <tr><td>班级编号： ${param.classid}</td> </tr>
 <tr><td>宿舍编号： ${param.apartmentid}</td> </tr>
<tr><td>就读状态： ${param.stustatus}</td>  </tr>
<tr><td>毕业院校：  ${param.school}</td> </tr>
<tr><td> 生源编号： ${param.rouid}</td></tr>
 </table>
 <button  class="btn btn-primary" onclick="stustuinfo.stureturn()">返回</button>
  </body>
</html>
