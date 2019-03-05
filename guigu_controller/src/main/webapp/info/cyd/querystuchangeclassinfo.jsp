<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="/layui/css/layui.css" media="all">

<script src="/layui/layui.js"></script>
	
	<script>
		layui.use('table',function(){
			var table=layui.table;
			
			table.render({
				elem:'#info_change_class_querystu_change_class_table',
				//height:300,
				url:'${pageContext.request.contextPath}/changeclassapply/queryChangeClassApplyByStuId',
				page:true,//开启分页
				cols:[[
					{
						field:'tcc_id',
						title:'转班编号',
					 	sort: true, 
					 	fixed: 'left'
					},
					{
						field:'stu_id',
						title:'学号',
					
					},
					{
						field:'stu_name',
						title:'姓名',
					
					},
					{
						field:'put_reason',
						title:'申请原因',
						
					},
					{
						field:'in_status',
						title:'审核状态',
						templet:function(d){
							if(d.in_status==0){
								return "未审核";
							}else if(d.in_status==1){
								return "通过";
							}else{
								return "未通过";
							}
						}
						
					},
					{
						field:'in_reason',
						title:'不同意原因',
					
					}
					
				]],
				limits:[1,5,10,15],
				limit:5,
				loading:true,
				title:'转班信息'
			})
			
		});
	</script>

 
  <body>
   	<table id="info_change_class_querystu_change_class_table" lay-filter="test"></table>
  </body>

