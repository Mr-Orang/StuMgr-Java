<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'survey_menu.jsp' starting page</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src="../../../layui/layui.js"></script>
   <script src="../../js/survey_menu.js"></script>
  <body>
    <div class="layui-tab layui-tab-card site-demo-button" style="position: relative;">
            <ul class="layui-nav layui-nav-tree layui-nav-side">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">默认展开</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a data-url="a" data-id="11" data-title="选项a" href="teachers-satisfaction.jsp" class="site-demo-active" data-type="tabAdd">选项a</a>
                        </dd>
                        <dd>
                            <a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a>
                        </dd>
                        <dd>
                            <a href="">跳转</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="">移动模块</a>
                        </dd>
                        <dd>
                            <a href="">后台模版</a>
                        </dd>
                        <dd>
                            <a href="">电商平台</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="#" data-url="c" data-title="选项c"  data-id="33" class="site-demo-active" data-type="tabAdd">产品c</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">大数据</a>
                </li>
            </ul>

            <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
                <ul class="layui-tab-title">
                </ul>
                <ul class="rightmenu" style="display: none;position: absolute;">
                    <li data-type="closethis">关闭当前</li>
                    <li data-type="closeall">关闭所有</li>
                </ul>
                <div class="layui-tab-content">
                </div>
            </div>

        </div>
  </body>
</html>
