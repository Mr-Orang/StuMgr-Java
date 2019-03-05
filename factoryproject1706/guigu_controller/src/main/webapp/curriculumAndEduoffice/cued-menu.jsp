<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
     <link rel="stylesheet" href="../layui/css/layui.css">
     <link rel="stylesheet" href="css/cued.css">
 </head>
 <script src="js/jquery2.js"></script>
 <script src="js/cued.js"></script>
 <body bgcolor="">

 <!--左边菜单块-->
 <div id="cued-menu">
     <div style="margin-bottom: 23px">

         <span class="text-span">教学管理系统</span>
     </div>

     <hr/><br/>
     
		<c:forEach var="vo" varStatus="idx" items="${muenlist}">
		  	<a  target="right-content" href="${vo.menu_Url}">
				<div id="div_${vo.menu_Id}" class="bu-menu div_menu" onclick="cude_menu.menu_css('${vo.menu_Id}')">
			         <table class="text-class-th">
			             <tr>
			                 <td>${vo.menu_Name}</td>
			             </tr>
			         </table>
			     </div>
    		 </a>
		</c:forEach>

     
 </div>
 <script src="../layui/layui.all.js"></script>

 </body>
</html>