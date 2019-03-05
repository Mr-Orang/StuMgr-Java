<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="../../layui/css/layui.css">
	<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
	
  </head>
   
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">在线考试系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
        	亦柯
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <li class="layui-nav-item">
<<<<<<< .mine
          <a class="layui-nav-item " href="/Examination/page/home.jsp" target="ifram">首页</a>
=======
          <a class="" href="${pageContext.request.contextPath }/Examination/page/home.jsp" target="ifram">首页</a>
>>>>>>> .r983
         </li>
        <li class="layui-nav-item">
<<<<<<< .mine
          <a class="" href="/Examination/page/library_manage.jsp" target="ifram">题库管理</a>
=======
          <a class="" href="${pageContext.request.contextPath }/Examination/page/library_manage.jsp" target="ifram">题库管理</a>
>>>>>>> .r983
         </li>
        <li class="layui-nav-item">
<<<<<<< .mine
          <a href="/Examination/page/ex_application.jsp" target="ifram">考试申请</a>
=======
          <a href="${pageContext.request.contextPath }/Examination/page/ex_application.jsp" target="ifram">考试申请</a>
>>>>>>> .r983
          
        </li>
        <li class="layui-nav-item">
<<<<<<< .mine
          <a href="/Examination/page/achievement.jsp" target="ifram">历史成绩</a>
=======
          <a href="${pageContext.request.contextPath }/Examination/page/achievement.jsp" target="ifram">历史成绩</a>
>>>>>>> .r983
          
        </li>
        
        <li class="layui-nav-item"><a href="">---</a></li>
        <button id="jinru" class="layui-btn layui-btn-radius layui-btn-normal" style="width: 100%">
        help
        </button>
       
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->

      <iframe name="ifram" style="height: 100%;width: 100%;"scrolling="no";frameborder="0" src="/Examination/page/home.jsp"></iframe>
  </div>
  <div class="layui-footer">
    <!-- 底部固定区域 -->
                        版权所有 ©2019 湖南硅谷信息技术有限公司 保留所有权利 湘ICP备15101742号  


  </div>
</div>

<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  });
</script>
</body>
</html>
