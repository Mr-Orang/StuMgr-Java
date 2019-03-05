<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="../../layui/css/layui.css">
<script src="../js/cued.js" type="text/javascript"></script>
<script src="../../layui/layui.all.js"></script>
	<table id="cuedstudent_tb"></table>
	
	<!-- 操作列按钮 -->
	<script type="text/html" id="student_tool">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">检查作业</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">关注</a>
	</script>
	         
<script>
	layui.use('table', function(){
	  var table = layui.table; 
	  //通过班级编号搜素班级学生
	  table.render({
	    elem: '#cuedstudent_tb' 
	    ,url: '/curriculumAndEduoffice/queryStudentsByCid?class_id=${param.class_id}'//数据接口
	     ,loading : true//加载条
	    ,cols: [[ //表头
	      {field: 'stu_name', title: '学生名称',  fixed: 'left'}
	      ,{field: 'stu_id', title: '编号',sort: true,}
	      ,{field: 'stu_sex', title: '性别', sort: true}
	      ,{field: 'stu_phone', title: '电话'} 
	      ,{field: 'address', title: '家庭住址'}
	      ,{field: 'par_phone', title: '监护人电话'}
	      ,{field : '',title : '操作',toolbar : '#student_tool',align:'center'}
	    ]]
	  });
	});
</script>
