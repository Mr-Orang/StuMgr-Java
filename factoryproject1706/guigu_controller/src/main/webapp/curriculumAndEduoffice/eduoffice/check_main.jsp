<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<link rel="stylesheet" href="../../layui/css/layui.css">
<link rel="stylesheet" href="../css/cued.css">

<script src="../js/cued.js" type="text/javascript"></script>
<script src="../../layui/layui.all.js"></script>
<body><hr/><p align="center">班级课程信息</p>
	<table id="cuedclass_tb"></table>
	<table id="cuedstudent_tb"></table>
	<table id="cuedcinfo_tb"></table>
</body>

	<!-- 操作列按钮 -->
	<script type="text/html" id="cuedclass_tool">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">班主任</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" onclick="open_student_info()">学生列</a>
	</script>
	
	<!-- 操作列按钮 -->
	<script type="text/html" id="select_cstu">
  		<a class="layui-btn layui-btn-xs" lay-event="edit">启用</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">停用</a>
	</script>
<script>
function open_student_info() {
		layer.open({
			offset: '0px',//顶部距离
			move: false,
			type : 2,
			skin : 'layui-layer-demo', //样式类名
			title : '学生列表',
			closeBtn : 1, //不显示关闭按钮
			anim : 2,
			area : [ '100%', '100%' ],
			shadeClose : false, //开启遮罩关闭
			content : '${pageContext.request.contextPath}/curriculumAndEduoffice/eduoffice/student_work.jsp?class_id=${param.class_id}',
		});
	};
	layui.use('table', function(){
	  var table = layui.table;

	  //通过课程信息搜索课程章节
	  table.render({
	    elem: '#cuedcinfo_tb'
	    ,url: '/curriculumAndEduoffice/queryCuedSectionsByid?cinfo_id=${param.cinfo_id}' //数据接口
	    ,page: false //开启分页
	    ,loading : true //加载条
	    ,cols: [[ //表头
	      {field: 'tc_chid', width:'400',title: '章节编号', hide:true}
	      ,{field: 'tc_chname',title: '章节名称'}
	      ,{field: 'tc_chstatus', title: '可用状态', sort: true}
	      ,{field : '',title : '操作',toolbar : '#select_cstu',align:'center'}
	    ]]
	  });
	
	//通过班级编号搜素班级学生
	  table.render({
	    elem: '#cuedclass_tb' 
	     ,loading : true//加载条
	    ,cols: [[ //表头
	      {field: 'id', title: '班级编号',  fixed: 'left'}
	      ,{field: 'name', title: '班级名称',sort: true,}
	      ,{field: 'cname', title: '当前课程', sort: true}
	      ,{field: 'sname', title: '当前阶段'}
	      ,{field : '',title : '操作',toolbar : '#cuedclass_tool',align:'center'}
	    ]]
	    ,data:[{id:'${param.class_id}',name:'${param.class_name}',cname:'${param.cname}',sname:'${param.sname}'}]
	  });
	  
	});
</script>
