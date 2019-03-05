<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 引入jQuery 核心库，这里采用的是2.0-->
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<!-- 引入jQuery EasyUI 核心库，这里采用的是1.3.6 -->
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI 中文提示信息 -->
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入EasyUI 核心UI 文件CSS-->
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<!-- 引入EasyUI 图标文件 -->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
</head>

 <body>
  	<div id="divs" class="easyui-layout" fit="true">
  		<div data-options="region:'north',height:100,collapsible:false,href:'info/common/top.jsp'"></div>
  		<div data-options="region:'center',fit:true,title:'内容',collapsible:false,href:'info/common/right.jsp'"></div>
  		<div data-options="region:'west',width:200,title:'系统菜单',collapsible:false,href:'info/common/left.jsp',iconCls:'icon-navigation'"></div>
  	</div>
  </body>

</html>
