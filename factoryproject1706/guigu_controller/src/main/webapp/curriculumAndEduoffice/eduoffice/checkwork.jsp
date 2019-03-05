<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
 <head>
     <link rel="stylesheet" href="../layui/css/layui.css">
     <link rel="stylesheet" href="css/cued.css">
 </head>
<link rel="stylesheet" href="../../layui/css/layui.css">
<link rel="stylesheet" href="../css/cued.css">

<script src="../js/cued.js" type="text/javascript"></script>
<script src="../../layui/layui.all.js"></script>
   <script src="../js/jquery2.js"></script>
 <script >
 $(function(){
 	checkwork={
       menu_css:function (e) {
          alert(b);
          $(".cued_c").removeClass("cued_work_content_y");
          $("#check_menu"+b).addClass('cued_work_content_y');
       }
    }
 });
 </script>
<body >
<table id="checkwork_tb">
	<tr height="10%">
		<td width="13%" >
			<c:forEach var="vo" varStatus="idx" items="${clist}">
				<a onclick="checkwork.menu_css('${vo.tc_id}')" target="check_work_iframe" href="/curriculumAndEduoffice/eduoffice/check_main.jsp?class_id=${vo.tc_id}&cinfo_id=${vo.sc_id}&cname=${vo.tc_cname}&sname=${vo.tc_sname}&class_name=${vo.tc_name}">
					<div class="cued_work_content cued_c" id="check_menu${vo.tc_id}">
						   <table class="cued_work_content_th">
						       <tr>
						            <td colspan="2" style="text-align: center;background-color:gray;color:white">
						                 ${vo.tc_name}
						            </td>
						       </tr>
						        <tr height='70%'>
						            <td width="20%" style="border: 0.1px solid gray;">
						                    	${vo.tc_sname}
						            </td>
						            <td>
						                    	${vo.tc_cname}
						            </td>
						       </tr>
						 </table>
					</div>
				</a>
				</c:forEach>			
		</td>
		<th width="87%">
			 <iframe style='width:100%; height:100%;background-color: white;box-shadow: inset 0px 0px 1.5px 0px gray;' name="check_work_iframe" marginwidth="1" frameborder="0.1" src="/curriculumAndEduoffice/test.jsp">
			 </iframe>
		</th>
	</tr>
</table>	
    
</body>

</html>

        
 