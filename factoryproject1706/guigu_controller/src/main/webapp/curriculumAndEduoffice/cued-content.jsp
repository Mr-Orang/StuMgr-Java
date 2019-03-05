<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


     <link rel="stylesheet" href="../layui/css/layui.css">
     <link rel="stylesheet" href="css/cued.css">
     <script src="../js/jquery2.js"></script>
     <script src="js/cued.js"></script>

 <!-- 右边内容块 -->
 <body bgcolor="#f5f5f5">
         <table width="100%" style="height:74px;background-color:white ;">
		     <tr>
		         <td> 
			             <table id="conten_fk">
			                     <button class="layui-btn layui-btn-warm" id="conten_fk">反馈</button>
			             </table>
		         </td>
		     </tr>
		 </table>
         <div style="width:98%;height:90.5%;margin:auto">
	         <div class="layui-tab" style="background-color:white">
	               <ul class="layui-tab-title">
	                    <li class="layui-this">管理员</li>
	               </ul>
	               <div class="layui-tab-content">
				       <iframe name="right-content" marginwidth="0" frameborder="0" id="cued-right-main" src="test.jsp">
				       </iframe>
			       </div>
	         </div>
         </div>
 <script src="../layui/layui.all.js"></script>
 	<script type="text/javascript">
layui.use('layer', function(){
      var $ = layui.jquery, layer = layui.layer;
      $(document).on('click','#conten_fk',function(){
        // layer.msg('卧槽');
               	layer.open({
     		type: 2,
            skin: 'layui-layer-demo', //样式类名
            title: '反馈模块',
            closeBtn: 1, //不显示关闭按钮
            anim: 2,
            area: ['893px', '650px'],
            shadeClose: false, //开启遮罩关闭
            content: 'eduoffice/satisfaction/satisfaction-main.jsp'
}); 
     });
  });
 	
 	</script>
 

