<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>物资管理系统-首页</title>
<!-- 在浏览器标题栏加上图标 -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/materials/picture/headlabel/head_main.png"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
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
<!-- 加载动画效果 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/materials/loading-flush/jq_mydialog.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/materials/loading-flush/my_dialog.css"/>
<!-- 加载动画效果 -->
<script type="text/javascript">
	$(function() {
		//自定义缓冲标题
		$.myloading({
			title : '正在加载中'
		});
		setTimeout(function() {
			//关闭缓冲效果
			$.myloading("hide");
		}, 2500);
		$('#mainWin').layout({
			fit : true,
		});
		$('#tabs').tabs({
			fit : true,
		});
		//加载首页指南
		$('#tabs').tabs('add', {
			title : '系统首页',
			iconCls : 'icon-tip',
			href : '${pageContext.request.contextPath}/materials/page/mainpage/main_Info.jsp',
		});
	});

	function logout() {
		$.messager.confirm('确认框', '您想要退出该系统并且注销登录吗？', function(r) {
			if (r) {
				window.location.href = '${pageContext.request.contextPath}/loginAndLogoutController/loginOut';
			}
		});
	}
</script>
<style>
a {
	cursor: pointer;
}

.head {
	background:
		url('${pageContext.request.contextPath}/materials/picture/timg.jpg')
		no-repeat;
	background-size: 100%;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',noheader:true" style="background-color:#e0ecff;height:70px;" class="head">
		<h1 style="color: white;margin-left: 15px;">
			<!--  
        <c:if test="${not empty sessionScope.emplyee}">
            硅谷物资采购管理系统
        </c:if>
        <c:if test="${not empty sessionScope.provider}">
            硅谷物资采购系统·供应商服务平台
        </c:if>
        -->
			硅谷云科技物资采购管理平台
		</h1>
	</div>
	<div data-options="region:'west',title:'菜单列表',iconCls:'icon-main_menuIcon',split:true" style="width:182px;">
		<jsp:include page="${pageContext.request.contextPath}/materials/page/mainpage/left_menu.jsp" flush="true" />
	</div>
	<div data-options="region:'center',title:'首页内容',noheader:true"
		style="padding:5px;background:#eee;">
		<div id="tabs"></div>
	</div>
</body>
</html>
