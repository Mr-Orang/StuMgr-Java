<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'leave.jsp' starting page</title>
    
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
  	
  	<script type="text/javascript" src="${pageContext.request.contextPath}/info/leave/js/yes.js"></script>
  	
	  	<style type="text/css">
	  		#juzho{
	  			width:300;
	  			height:200;
	  			margin: 0 auto;
	  		}
	  	</style>
	
  </head>
  
  <body>
   	<table id="leavee"></table>	<!-- 表格 -->
   	<div id="juzho">
   	 	<button type="button" class="btn btn-warning" onclick="obj.a()">请假</button>
  		<button type="button" class="btn btn-primary">修改</button>
  		<button type="button" class="btn btn-primary">查看详细信息</button>
  	</div>
   	<div id="toolbar">
   	</div> 	<!-- 工具类 -->
   	
   	<script type="text/javascript">
		$(function(){
			obj={
				a:function(){
					alert(2);
				}
			}
			
			yes.table("#leavee",{
					border:true,
					toolbar:'#toolbar', 
					hover:true,
					striped:true,
					condensed: true,
					pagination: true,
					url:'/queryleave.action',
					pageNumber:1,                  //初始化加载第一页，默认第一页
	            	pageSize:5,                   //每页的记录行数
	            	pageList:[5,10,15,20],  
		            columns:[{
			            },{
			                field: 'leave_id',
			                title: '请假编号'
			            },{
			                field: 'stu_name',
			                title: '学生姓名'
			            },{
			                field: 'leave_starttime',
			                title: '开始时间'
			            },{
			                field: 'leave_endtime',
			                title: '结束时间'
			            },{
			                field: 'leave_reason',
			                title: '请假原因'
			            },{
			                field: 'leave_time',
			                title: '申请时间'
			            },],
			            
				});
			
					});
		
	</script>
  </body>
</html>