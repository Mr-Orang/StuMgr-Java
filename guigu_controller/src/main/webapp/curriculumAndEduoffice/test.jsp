<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<meta charset="UTF-8">
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="css/cued.css">

<script src="js/cued.js" type="text/javascript"></script>
<body bgcolor="white">
<div class="layui-carousel" id="test2" style="background-color:white">
     <div carousel-item="">
           <div >
           	<img src="img/porewillow.jpg" style="background-position: center;width:100%;height:100%"/>
           </div>
          <div class="layui-card" style="text-align: center;font-size:24px">
               <div class="layui-card-header">说明</div>
               <div class="layui-card-body">
                   		欢迎进入课程授课系统！
                   		<span style="color:darkcyan;font-size:30px">申博</span> 管理员
                   		
               </div>
          </div>
     </div>
</div>

<script src="../layui/layui.all.js"></script>
<script>
     layui.use(['carousel', 'form'], function(){
          var carousel = layui.carousel
                  ,form = layui.form;

          //改变下时间间隔、动画类型、高度
          carousel.render({
               elem: '#test2'
               ,interval: 3400
               ,anim: 'fade'
               ,height: '100%'
               ,width:'100%'
               ,indicator:'none'
               ,arrow:"none"
          });
     });
</script>
</body>
