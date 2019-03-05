<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
   
    
    <title>市场营销</title>
    <!-- 在浏览器标题栏加上图标 -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/materials/picture/headlabel/head_main.png" type="image/x-icon"/>
    <link rel="stylesheet" id="easyuiTheme" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/etree/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/etree/jquery.etree.lang.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/dataview/datagrid-detailview.js"></script>
   
    
	
  </head>
  <script type="text/javascript">
  				changeTheme=function(themeName){
  					var easyuitheme=$('#easyuiTheme');
  					var url=easyuitheme.attr('href');
  					var href=url.substring(0,url.indexOf('themes'))+'themes/'+themeName+'/easyui.css';
  					easyuitheme.attr('href',href);
  					var iframes=$('iframe');
  					if(iframes.length>0){
  						for(var i=0;i<iframes.length;i++){
  							var ifr=iframes[i];
  							$(ifr).contents().find('#easyuiTheme').attr('href',href);
  						}
  					}
  					$.cookie('easyuiThemeName',themeName,{
  						expires:7
  					})
  				}
  	</script>
  
  <body>
    
      <div id="layout" class="easyui-layout" data-options="fit:true">
      
  	  <div data-options="region:'north',title:'市场营销管理系统',collapsible:false,height:120,href:'/marketing/page/top.jsp'"></div>
  	  
	  <div data-options="region:'west',title:'菜单',width:200,href:'${pageContext.request.contextPath}/marketing/page/left_menu.jsp'">
	   </div>
	   
	  <div id="choice_card" class="easyui-tabs" data-options="region:'center',title:'选项卡面板'"></div>
    
   	  </div>
  </body>
</html>
