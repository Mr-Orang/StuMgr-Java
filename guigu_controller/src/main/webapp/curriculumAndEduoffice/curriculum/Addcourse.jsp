<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Addcourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all">
		<script src="../../layui/layui.all.js"></script>
	<script src="../../layui/layui.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <!-- 表单元素 -->
    <form class="layui-form" action="">
  		<div class="layui-form-item">
  		<!-- 添加课程信息时课程ID 后台添加 拼接 加序列  tc_cid -->
    		<label class="layui-form-label">课程名称</label>
    		<div class="layui-input-block">
      			<input type="text" lay-verify="tc_cname" name="tc_cname" id="tc_cname" required  lay-verify="required" placeholder="请输入课程名称" autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    <label class="layui-form-label">课程别名</label>
    <div class="layui-input-inline">
      <input type="text" name="tc_calias" id="tc_calias" lay-verify="tc_calias" required lay-verify="required" placeholder="给这门课程取个别名吧" autocomplete="off" class="layui-input">
    </div>
    
    <div class="layui-form-item">
    <label class="layui-form-label">选择阶段</label>
    <div class="layui-input-block">
    	<!--课程阶段关联表	t_course_stage -->
         <select name="tc_coid" id="tc_coid" lay-verify="required" lay-filter="xmFilter">
             <option value=""></option>
         </select>
     </div>
  </div>
        <!-- 拖拽上传 -->  
    <div class="layui-form-item">
    	<label class="layui-form-label">课程大纲</label>
    	<div class="layui-upload-drag" id="test10">
  <i class="layui-icon"></i>
  <p>点击上传课程大纲，或将文件拖拽到此处</p>
  <!-- 隐藏input 用于藏文件URL -->
  <input type="hidden" id="fileUrl" name="fileUrl" value=""/>
</div>
    </div>
    <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">课程描述</label>
    <div class="layui-input-block">
      <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
    
    <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="save" id="save">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
    
    <!-- --------------元素分割----------------------- -->
	</form>
 
<script>
//Demo
layui.use(['form','upload','layer'],function(){
  var form = layui.form;
  //文件上传layui所需参数
  var $=layui.jquery;
  var upload=layui.upload;
  
  //指定允许上传的文件类型
	//拖拽上传
	var upload =layui.upload.render({
		elem:'#test10'//绑定元素
		,url:'${pageContext.request.contextPath}/courseInfo/FileCourse'
		,accept:'file'
		,size: 10240//文件大小
		,bindAction:'#save'//绑定文件提交事件
		,exts: 'ppt|docx|xlsx|doc' //指定文件后缀类型
		,auto: false//选择文件后不自动上传
		,done: function(res){
      		//如果上传失败
      		console.log(res)
      		
     		 if(res.code > 0){
       		 	return layer.msg('上传失败'+res.data.src);
      		}
      //上传成功
      layer.msg("上传成功"+res.src);
      document.getElementById("fileUrl").value = res.url;
      return layer.msg('上传成功'); 
      
    }
	});
	

  //定义填写规范
  form.verify({
  //课程名字限制
  	tc_cname:function(value){
  		if(value.length<2){
  			return '课程名至少得两个字符';
  		}if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
  			return '课程名不能有特殊字符';
  		}
  	}
  	//限制课程别名
  	,tc_calias:function(value){
  		if(value.length<2){
  			return '别名至少两字符';
  		}if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
  			return '别名不能有特殊字符';
  		  }
  	}
  	,content:function(value){
  		 layedit.sync(editIndex);
  	}
  });
  //表单提交submit
 form.on('submit(save)', function(data){
 	 
            $.ajax({   
                url:'./add',//数据接口       
                method:'post',       
                data:data.field,        
                dataType:'JSON',         
                success:function(res){       
                     if(res.code='0'){       
                        parent.closeIframe(res.msg);
                        }
                    else            
                        alert(res.msg);   
                    },              
                    error:function (data) {
                        
                    }           
                    }) ;         
                
            });   
	
  //下拉列表后台赋值
  $.ajax({
  	url:'/queryUsableStage.action',//数据接口
  	datatype:'json',//返回数据格式
  	type:'get',
  	success:function(data){
  		$.each(data,function(index,item){
  		//给下拉列表添加元素
  		 $('#tc_coid').append(new Option(item.tc_sname, item.tc_sstatus));
  		});
  		layui.form.render("select");
  		//重新渲染 固定方法
  	},error:function(){
  		alert("数据读取失败");
  	}
  
  })
  //监听提交表单上是否填写完成
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});
</script>
  </body>
</html>
