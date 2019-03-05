<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

    <title>考勤登陆页面</title>
	
	<!-- 自己写的js -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/info/tangwj/js/kaoqintwj.js"/>
  <style type="text/css">
  	#kaoqingtwj{
  		margin-top:100px;
  	}
  </style>
  	<!--装登陆页面 -->
   <div id="kaoqingtwj">
	<table border="0" width="260" height="120" cellspacing="0" align="center">
		<caption><h3>考勤登陆</h3></caption>
		<tr>
			<th>员工编号:</th>	<th><input type="text" value="admin" id="empaccounttwj" /></th>
		</tr>
		<tr>
			<th>密码：</th><th><input type="text"value="admin" id="emppasswordtwj"/></th>
		</tr>
		<tr>
			<th colspan="2">
				<a class="easyui-linkbutton" iconCls="icon-ok" ="true"	onclick="obj.loginemplyeetwj();">登陆</a> 
			</button></th>
		</tr>
	</table>
</div>