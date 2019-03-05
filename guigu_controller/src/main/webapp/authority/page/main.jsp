<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
</head>
<title>权限管理系统</title>
<!-- 在浏览器标题栏加上图标 -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/materials/picture/headlabel/head_main.png"
	type="image/x-icon" />
<link rel="stylesheet" id="easyuiTheme" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/authority/css/menu.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/etree/jquery.etree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/etree/jquery.etree.lang.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/dataview/datagrid-detailview.js"></script>
<body>

	<div id="layout" class="easyui-layout" data-options="fit:true">

		<div
			data-options="region:'north',title:'权限管理系统',collapsible:false,height:120,href:'/authority/page/top.jsp'"></div>

		<div
			data-options="region:'west',title:'菜单',width:200,href:'${pageContext.request.contextPath}/authority/page/left.jsp'">
		</div>
<div id="choice_card" class="easyui-tabs" data-options="region:'center',title:'选项卡面板'"></div>
    
   	  </div>
>
</body>
</html>
