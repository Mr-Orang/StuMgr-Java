<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<link rel="stylesheet" href="/layui/css/layui.css" media="all">
<body  style="background-color: white;">
	<table id="demo" lay-filter="test" lay-size="lg"></table>
</body>

<script id="toolbarDemo" type="text/html">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取未审核的数据</button>
	<button class="layui-btn layui-btn-sm" lay-event="getCheckAgreeData">获取同意的数据</button>
	<button class="layui-btn layui-btn-sm" lay-event="getCheckNoAgreeData">获取不同意的数据</button>
	<button class="layui-btn layui-btn-sm" lay-event="getCheckTotalData">获取全部的数据</button>
  </div>
</script>

<script src="/layui/layui.js"></script>
	<script>
		layui.use('table', function(){
  		var table = layui.table;
  			//第一个实例
  			table.render({
    			elem: '#demo',
    			cellMinWidth: 80,
    			toolbar: '#toolbarDemo',
    			url : '/talk/queryStudentTalk.action', //数据接口
    			page: true, //开启分页
    			where:{
    				stu_id:'s1003',
    			},
    			cols : [[ // 表头
					/* {
						title : '选择',
						type : 'radio',
					 	fixed : 'left',
					 	align : 'center',
					 	width : 100,
					}, */
					{
						field : 'talk_details_id',//从后台传过来的数据项
						title : '谈话详情编号',
						align : 'center',
						//width : 100,
						sort : true,
						fixed : 'left'
					},{
						field : 'talk_type',
						title : '谈话类型',
						align : 'center',
						//width : 130
					},{
						field : 'stu_name',
						title : '姓名',
						align : 'center',
						//width : 110,
						sort : true,
						totalRow : true
					},{
						field : 'talk_content',
						title : '谈话内容',
						//color : '#7fe5ec',
						//width : 200,
						sort : true
					},{
						field : 'talk_person',
						title : '谈话人',
						align: 'center',
						//width : 110,
						sort : true
					},{
						field : 'viewpoint',
						title : '状态',
						align: 'center',
						sort : true,
						templet:function(d){
							if(d.viewpoint==0){
								return '未确认';
							}else if(d.viewpoint==1){
								return '同意';
							}
							return '不同意';
						}
					},{
						field : 'reason',
						title : '否定原因',
						//width : 200,
						sort : true
					},{
						field : 'talk_time',
						title : '添加谈话时间',
						width : 160,
						sort : true
					},{
						fixed : 'right',
						title : '操作',
						align : 'center', 
						//toolbar : '#barDemo',
						templet:function(d){
							if(d.viewpoint==0){
								return '<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">查看审核</a>';
							}
							return '';
						}
					}
				]]
  			});
  
		});
</script>

<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">查看审核</a>
</script>

<script>
layui.use('table', function(){
  	var table = layui.table;
  	//监听工具条
  	table.on('tool(test)', function(obj){
	    var datas = obj.data;
	    if(obj.event === 'detail'){
	    	//显示谈话信息
	        layer.open({
	        	//type : 3,
	  			title: '谈话信息确认：',
	  			content: '<table style="margin: 0 auto;" border="1"><tr><td>编号：</td><td>'+datas.talk_details_id+'</td></tr><tr><td>谈话类型：</td><td>'+datas.talk_type+'</td></tr><tr><td>姓名：</td><td>'+datas.stu_name+'</td></tr><tr><td>谈话内容：</td><td><textarea rows="8" cols="18">'+datas.talk_content+'</textarea></td></tr><tr><td>谈话人：</td><td>'+datas.talk_person+'</td></tr><tr><td>谈话时间：</td><td>'+datas.talk_time+'</td></tr></table>',
				area:['350px','410px'],
				offset: '30px',//top
				resize:false,//不允许放大窗口
				skin:'layui-layer-molv',
				fixed:false,//固定
				move:false,
				btn:['取消','同意','不同意'],
				yes:function(){
					layer.close(layer.index); //它获取的始终是最新弹出的某个层，值是由layer内部动态递增计算的
				},
				btn2:function(){
					layer.confirm('确认同意本次谈话么？', function(index){
						var $ = layui.jquery;
						$.ajax({
							type:'POST',
							url:'${pageContext.request.contextPath}/talk/updateStudentAgreeTalk.action',
							data:{
								'talk_details_id' : datas.talk_details_id,
							},
							success:function(data){
								if(data=="0"){
									layer.alert('提交失败，请重试!'); 
								}else{
									layer.alert('提交成功!'); 
									//关闭窗口
									layer.close(index);
									layui.table.reload('demo',{page:{curr:1}});
								}
							}
						});
						
					});
				},
				btn3:function(){
					layer.open({
						type:0,
	  					title: '不同意意见填写：',
	  					content: '<table><tr><td>不同意原因：</td><td><textarea id="reason" rows="12" cols="20" maxlength="100"></textarea></td></tr></table>',
						area:['350px','400px'],
						offset: '30px',//top
						resize:false,//不允许放大窗口
						skin:'layui-layer-molv',
						fixed:false,//固定
						move:false,
						btn:['取消','提交'],
						yes:function(){
							layer.close(layer.index); //它获取的始终是最新弹出的某个层，值是由layer内部动态递增计算的
						},
						btn2:function(){
							var $ = layui.jquery;
							var reasons = $('#reason').val();
							if(reasons!=null&&reasons!=""){
								$.ajax({
									type:'POST',
									url:'${pageContext.request.contextPath}/talk/updateStudentNoAgreeTalk.action',
									data:{
										'talk_details_id' : datas.talk_details_id,
										'reason' : reasons,
									},
									success:function(data){
										if(data=="0"){
											alert('提交失败，请重试!'); 
										}else{
											alert('提交成功!'); 
											//关闭窗口
											layer.close(layer.index);
											//刷新数据表格demo是表格的id
											layui.table.reload('demo',{page:{curr:1}});
										}
									}
								});
								return false; 
							}else{
								alert("请填写不同意原因！");
								return false; 
							}
						}
					});	
				}
			});
	    }
  	});
  
  //工具栏
table.on('toolbar(test)', function(obj){
    //var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      	case 'getCheckData':
	        //重载查询未审核数据
	        table.reload('demo', {
				url: '/talk/queryStudentTalk.action',
				where: {
					viewpoint : '0',//设定异步数据接口的额外参数
				} 
			});
      	break;
      	case 'getCheckAgreeData':
	        //重载查询同意数据
	        table.reload('demo', {
				url: '/talk/queryStudentTalk.action',
				where: {
					viewpoint : '1',//设定异步数据接口的额外参数
				} 
			});
      	break;
      	case 'getCheckNoAgreeData':
	        //重载查询不同意数据
	        table.reload('demo', {
				url: '/talk/queryStudentTalk.action',
				where: {
					viewpoint : '2',//设定异步数据接口的额外参数
				} 
			});
      	break;
      	case 'getCheckTotalData':
	       //重载查询全部数据
	        table.reload('demo', {
				url: '/talk/queryStudentTalk.action',
				where: {
					viewpoint : '',//设定异步数据接口的额外参数
				} 
			});
      	break;
    }
  });
  
});

</script>
