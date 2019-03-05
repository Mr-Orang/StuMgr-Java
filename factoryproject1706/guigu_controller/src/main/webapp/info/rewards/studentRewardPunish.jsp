<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="/layui/css/layui.css" media="all">
<!--  
<script id="toolbarDemo" type="text/html">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
  </div>
</script>
-->
<script src="/layui/layui.js"></script>
	<script>
		layui.use('table', function(){
  		var table = layui.table;
  			table.render({
    			elem: '#studentrewardspunishinfo',
    			cellMinWidth: 80,
    			//toolbar: '#toolbarDemo',
    			url : '${pageContext.request.contextPath }/queryByStudentId.action', //数据接口
    			page: true, //开启分页
    			cols : [[ 
					{
						field : 'rewards_apply_time',
						title : '申请时间',
						align : 'center',
						sort : true,
						fixed : 'left',
						templet: function(d){
							return d.rewards_apply_time.substr(0,16);
					    }
					},{
						field : 'te_name',
						title : '审批人',
						align : 'center',
					},{
						field : 'rewards_status',
						title : '审批状态',
						align : 'center',
						sort : true,
						totalRow : true,
						templet: function(d){
							if(d.rewards_status=='0'){
								return '审批中';
							}else if(d.rewards_status=='1'){
								return '同意';
							}else{
								return '不同意';
							}
					    }
					},{
						field : 'rewards_reason',
						title : '不同意原因',
						sort : true,
						templet: function(d){
							if(d.rewards_reason==null){
								return '无';
							}else{
								return d.rewards_reason;
							}
					    }
					},{
						field : 'rewards_time',
						title : '审批日期',
						align: 'center',
						sort : true,
						templet: function(d){
							return d.rewards_time.substr(0,16);
					    }
					},{
						field : 'rewards_type',
						title : '奖罚类型',
						align: 'center',
						sort : true,
						templet: function(d){
							if(d.rewards_type=='0'){
								return '奖';
							}else{
								return '罚';
							}
					      
					    }
					},{
						field : 'rewards_apply_reason',
						title : '奖罚原因',
						sort : true
					}
				]]
  			});
  
		});
</script>
<body  style="background-color: white;">
	<table id="studentrewardspunishinfo" lay-filter="test" lay-size="lg"></table>
</body>