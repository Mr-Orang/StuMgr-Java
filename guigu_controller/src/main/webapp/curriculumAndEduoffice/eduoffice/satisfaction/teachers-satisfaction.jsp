<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>教师满意度调查</title>
<link rel="stylesheet" href="../../../layui/css/layui.css" media="all">

</head>
<body>

  <div><h1>教职工满意度调查</h1></div></br></br>
		<form class="layui-form" action="">

  <div class="layui-form-item" id="select_role">
     <label class="layui-form-label" >选择角色:</label>
    <div class="layui-input-block">
      <select name="city" lay-verify="required">
       		 <option value="">校长</option>
             <option value="">老师</option>
             <option value="">班主任</option>
             <option value="">教导主任</option> 
             <option value="">宿管人员</option>
             <option value="">教务员</option>
      </select>
    </div>
  </div>
  
   <div class="layui-form-item" id="select_role">
     <label class="layui-form-label">选择名字:</label>
    <div class="layui-input-block">
      <select name="city" lay-verify="required">
           <option value="">二龙</option>
             <option value="">刘洋</option>
             <option value="">唐伟</option>
             <option value="">张勇</option> 
             <option value="">小森</option>
             <option value="">王五</option>
             <option value="">申博</option>
             <option value="">张三</option>
             <option value="">刚哥</option>
      </select>
    </div>
  </div>
  
  		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend ><input type="text" name="price_min" id="price_min1" style="width:520px" value="讲解内容是否条例清晰，重点突出，是否生动" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test1"></div></div>
	
				<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min2" style="width:520px" value="对学员的问题解答是否清晰易懂" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test2"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min3" style="width:520px" value="老师工作认真，有很强的敬业精神" onfocus=this.blur() onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test3"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min4" style="width:520px" value="有无迟到、早退行为" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test4"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min5" style="width:520px" value="教学期间不做与教学无关的事" onfocus=this.blur() onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test5"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min6" style="width:520px" value="严格实施对所带班级的考勤和纪律管理" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test6"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min7" style="width:520px" value="课堂气氛是否活跃及教学课堂控制能力" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test7"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min8" style="width:520px" value="是否经常收集学生意见，注重与学生的沟通" onfocus=this.blur() onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test8"></div></div>
	
  	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend><input type="text" name="price_min" id="price_min9" style="width:520px" value="培养学生良好的学习习惯和方法，努力培养学生" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test9"></div></div>
	
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
	
  <legend ><input type="text" name="price_min" id="price_min10" style="width:520px" value="关心学生的听课情况，给予学生帮助和建议" onfocus=this.blur() autocomplete="off"></legend>
	</fieldset>
	<div><div id="test10"></div></div> 

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">给他/她的建议：</label>
    <div class="layui-input-block">
      <textarea name="desc" placeholder="请输入内容" class="layui-textarea" id="hh"></textarea>
    </div>
  </div>
</form>

  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn"  lay-filter="*" id="submit_question">立即提交</button>
    </div>
  </div>
<script src="../../../layui/layui.all.js"></script>
<script type="text/javascript">
layui.use(['rate'], function(){
  var rate = layui.rate;
  rate.render({
    elem: '#test1'
    ,length: 10
  });
   rate.render({
    elem: '#test2'
    ,length: 10
  });
   rate.render({
    elem: '#test3'
    ,length: 10
  });
   rate.render({
    elem: '#test4'
    ,length: 10
  });
   rate.render({
    elem: '#test5'
    ,length: 10
  });
   rate.render({
    elem: '#test6'
    ,length: 10
  });
   rate.render({
    elem: '#test7'
    ,length: 10
  });
   rate.render({
    elem: '#test8'
    ,length: 10
  }); rate.render({
    elem: '#test9'
    ,length: 10
  });
   rate.render({
    elem: '#test10'
    ,length: 10
  });
  
});


layui.use(['rate','layer'], function(){
      var $ = layui.jquery, layer = layui.layer;
      var rate =layui.rate;
      $(document).on('click','#submit_question',function(){
        // layer.msg('卧槽');
         layer.alert(document.getElementById("price_min10").value,{offset: '100px'});
         //alert(document.getElementById("hh").value);
         //alert(document.getElementById("price_min10").value);
     });
  });
</script>
<style>
	div{text-align:center;margin:0 auto;}
	#select_role{
			text-align:center;
			width: 300px;
	
	}
	#lable_role{
			text-align:center;
			margin-left:13%;
	
	}
</style>

</body>

</html>
