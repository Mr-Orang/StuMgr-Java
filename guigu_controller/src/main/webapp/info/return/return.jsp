<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!--学生端复学申请-->
<title>复学申请</title>
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
	
	<!--返回上一级按钮点击事件-->
    <script type="text/javascript">
		$(document).ready(function() {
			$("#ret").click(function() {
				location.href="${pageContext.request.contextPath}/info/index.jsp";
			});
		});
		/* ajax传参*/
		function retuden(){
			alert("提交");
			//获取到复学时间	
			alert($('#return_time').val());
			$.ajax({
				    url: "/InsertReturn.action",
         			type: "POST",
         			data:{
         				leave_id:$('#leave_id').val(),
         				return_time:new Date(return_time)
        		 	}
			})
		}
	</script>
</head>
<body>
	<form class="form-horizontal" role="form">
		<!--标题 -->
		<div class="text-center">
			<h1>复学申请信息</h1>
		</div>
		<!--休学编号-->
		<div class="form-group">
			<label for="lEAVE_ID" class="col-sm-2 control-label">休学编号</label>
			<div class="col-sm-10">
				<input id="lEAVE_ID" type="text" value="${ReturnVo.lEAVE_ID}"  
				style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!--姓名-->
		<div class="form-group">
			<label for="sTU_NAME" class="col-sm-2 control-label">姓名</label>
			<div class="col-sm-10">
				<input id="sTU_NAME" type="text" value="${ReturnVo.sTU_NAME}" 
					style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!--性别-->
		<div class="form-group">
			<label for="sTU_SEX" class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<input id="sTU_SEX" type="text" value="${ReturnVo.sTU_NAME}" 
					style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!--休学时间-->
		<div class="form-group">
			<label for="lEAVE_STARTTIME" class="col-sm-2 control-label">休学时间</label>
			<div class="col-sm-10">
				<input id="lEAVE_STARTTIME" type="text" value="${ReturnVo.lEAVE_STARTTIME}" 
					style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!--请假理由-->
		<div class="form-group">
			<label for="leave_reason" class="col-sm-2 control-label">请假理由</label>
			<div class="col-sm-10">
				<input id="leave_reason" type="text" value="${ReturnVo.leave_reason}" 
					style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!--结束时间-->
		<div class="form-group">
			<label for="leave_endtime" class="col-sm-2 control-label">结束时间</label>
			<div class="col-sm-10">
				<input id="leave_endtime" type="text" value="${ReturnVo.leave_endtime}" 
					style="width:880px" class="form-control" disabled="true">
			</div>
		</div>
		<!-- 复学时间 -->
		<div class="form-group">
			<label for="returns" class="col-sm-2 control-label">申请复学时间</label>
			<div class="col-sm-10">
				<input id="return_time" type="date" value="$"
					style="width:880px" class="form-control">
			</div>
		</div>
		<!-- 提交申请按钮-->
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<!--btn btn-warning 危险按钮-->
				<button type="button" onclick="retuden()" style="width:880px" class="btn btn-primary btn-lg btn-block">提交申请</button>
				<button id="ret" style="width:880px" type="button" class="btn btn-primary btn-lg btn-block">返回上级</button>
			</div>
		</div>
	</form>
</body>