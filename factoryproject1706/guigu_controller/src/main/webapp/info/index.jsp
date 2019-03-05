<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>学生信息系统首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 引入layui.css -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
  	<!-- 引入layui.js-->
  	<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
	
	<script>
		layui.use('element', function(){
			var $ = layui.jquery;
			var element = layui.element;
			//右侧打开选项卡
			$('.checkName').click(function(){
				var name = $('a:hover font').text();
				var id  = $('a:hover').attr('data-id');
				var url  = $('a:hover').attr('data-url');
				if($('li[lay-id="'+id+'"]').length==0){
				element.tabAdd('demo',{
					title:name,
					content:'<iframe id="'+id+'" src="'+url+'" width="100%" height="90.5%" frameborder="no"></iframe>',
					id:id
				})
				}
				element.tabChange('demo', id);
			});
			$('#tabtitle i').css('display','none');
			
			//禁止鼠标右键
			document.oncontextmenu = function(){
　　				return false;
			} 
			//禁用F12审查元素
			/* document.onkeydown = function(){
				var e = window.event || arguments[0];
				if(e.keyCode == 123){
					alert('F12禁用');
					return false;
				}
			} */
		})
	</script>
	
	<script>
		//图片轮播
		layui.use('carousel',function(){
			var carousel = layui.carousel;
			carousel.render({
				elem:'#img_main',
				width: '100%',
				height:'380px',
				arrow:'hover',
				full: false,
				autoplay: true,
				interval: 1000
			});
		})
	</script>
	
	<!-- 面板css样式 -->
	<style type="text/css">
   		#ka_pane a:hover{color: MediumBlue;text-decoration:underline;}
   	</style>
	
  </head>
  
  <body class="layui-layout-body" style="background-color: #F0F0F0;">
   	<div class="layui-layout layui-layout-admin">
   		<!-- 头部logo -->
   		<div class="layui-header">
   			 <div class="layui-logo">学生信息管理平台</div>
   			 
   			 <!-- 天气预报插件 -->
   			 <div class="layui-nav layui-layout-right" style="position: absolute;right: 150px;top:17px;">
   			 	<iframe id="chajian" allowTransparency="true" src="http://tianqi.5ikfc.com:90/plugin-code/?style=3&dy=3&cl=ffffff&th=ff9900&tl=ff6633" frameborder="0" scrolling="no" width="350" height="30"></iframe>
   			 </div>
   			 
   			 <!-- 头部右侧按钮 -->
   			 <ul class="layui-nav layui-layout-right">
   			 	<li class="layui-nav-item">
   			 		<a><i class="layui-icon layui-icon-component"></i>组件</a>
   			 		<dl class="layui-nav-child">
   			 			<dd><a>啥啥组件</a></dd>
   			 			<dd><a>啥啥组件</a></dd>
   			 		</dl>
   			 	</li>
   			 	<li class="layui-nav-item">
   			 		<a><i class="layui-icon layui-icon-user"></i></a>
   			 		<dl class="layui-nav-child">
   			 			<dd><a>退出</a></dd>
   			 		</dl>
   			 	</li>
   			 </ul>
   		</div>
   		
   		
   		<div class="layui-side layui-bg-black">
   			<!-- 左侧导航栏 -->
   			<div class="layui-side-scroll">
   				<ul class="layui-nav layui-nav-tree" lay-filter="test" id="menu">
  					<li class="layui-nav-item">
  					
  						<a>
  						<i class="layui-icon layui-icon-templeate-1" style="font-size: 20px;padding-right: 20px;padding-left: 20px;"></i><font>学生信息管理</font>
  						</a>
  						
  						<dl class="layui-nav-child">
  						
  							<dd>
  								<a class="checkName" data-id="1" data-url="#">
  								<i class="layui-icon layui-icon-username" style="padding-right: 20px;padding-left: 20px;"></i><font>我的基本信息</font>
  								</a>
  							</dd>
  							
  							
  							<dd><a class="checkName" data-id="2" data-url="#"><font>我的退学信息</font></a></dd>
  							
  							<dd><a class="checkName" data-id="3" data-url="#"><font>我的休学申请</font></a></dd>
  							
  							<dd><a class="checkName" data-id="4" data-url="ouyangjsp/student_talk_info.jsp"><font>学生谈话管理</font></a></dd>
  							
  							<dd><a class="checkName" data-id="5" data-url="info/return/return_chakan.jsp"><font>我的复学申请</font></a></dd>
  							
  							<dd><a class="checkName" data-id="6" data-url="cyd/querystuchangeclassinfo.jsp"><font>查看转班申请</font></a></dd>
  							
  							<dd><a class="checkName" data-id="7" data-url="#"><font>请假申请</font></a></dd>
  							
  							<dd>
  								<a class="checkName" data-id="8" data-url="#">
  								<i class="layui-icon layui-icon-survey" style="font-size: 20px;padding-right: 20px;padding-left: 20px;"></i><font>我的考勤</font>
  								</a>
  							</dd>
  							
  							<dd>
  								<a class="checkName" data-id="9" data-url="#">
  								<i class="layui-icon layui-icon-form" style="font-size: 20px;padding-right: 20px;padding-left: 20px;"></i><font>我的请假</font>
  								</a>
  							</dd>
  							
  						</dl>
  					</li>
   				</ul>
   			</div>
   		</div>
   		
   		<!-- 右侧选项卡 -->
   		<div class="layui-body">
   			<div style="margin: 15px;">
   				<div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="demo">
   					<ul class="layui-tab-title" style="background: #fff;">
   						<li id="tabtitle" class="layui-this" lay-id="demo">网站首页</li>
   					</ul>
   					
   					<!-- 选项卡内容 -->
   					<div class="layui-tab-content">
   						<div class="layui-tab-item layui-show">
   							<!-- 轮播效果 -->
   							<div class="layui-carousel" id="img_main" style="margin-bottom: 20px;">
   								<div carousel-item>
   									<div><img src="${pageContext.request.contextPath}/info/img/3.jpg"></div>
   									<div><img src="${pageContext.request.contextPath}/info/img/4.jpg"></div>
   								</div>
   							</div>
   							
   							<!-- 卡片面板1 -->
   							<div class="layui-card" style="width: 400px;height: 300px;">
   								<div class="layui-card-header" style="color: red;">
   								<i class="layui-icon layui-icon-notice" style="font-size: 15px;padding-right: 10px;"></i>最新消息
   								</div>
   								<div id="ka_pane" class="layui-card-body">
   									<a href="#">教务处最新规定：每人上交一千元...</a><hr/>
   									<a href="#">校长说明：排座位必须男女同坐,等...</a><hr/>
   								</div>
   								
   								<!-- 卡片面板2 -->
   							<div class="layui-card" style="position: absolute;left: 470px;top: 466px;width: 823px;height: 300px;">
   								<div class="layui-card-header">
   								<i class="layui-icon layui-icon-survey" style="font-size: 15px;padding-right: 10px;"></i>我的请假记录
   								</div>
   								<div class="layui-card-body">
   									<a>面板内容啊</a>
   								</div>
   							</div>
   							
   							</div>
   							
   							
   							
   						</div>
   					</div>
   				</div>
   			</div>
   		</div>
   		
   		<!-- 底部区域  -->
   		<div class="layui-footer" style="background-color: #989898;">
   			NBCLASS ——  底部区域
   		</div>
   	</div>
  </body>
</html>
