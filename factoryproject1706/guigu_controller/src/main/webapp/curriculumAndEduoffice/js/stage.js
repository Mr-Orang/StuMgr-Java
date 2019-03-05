layui.use('table',function(){
	var table = layui.table;
	//渲染
	table.render({
		elem:'#test'//绑定table表格
			,height: 450
			,url:'<%=request.getConntextPath()%>/addStage.action'//后台接收course stage路径
			,page:true //分页
			,limit:10
			,id:'addStage'
			,toolbar:'#toolbarDemo'
			,cols:[[
				{type:'checkbox',fixed:'left'}
				,{field:'tc_sid',title:' 编号',width:120}
				,{field:'tc_sname',title:'阶段名称',width:120}
				,{field:'tc_sstatus',title:'阶段状态',width:120}
				,{field:'right',title:'操作',width:177,toolbar:"#toolbarDemo"}
			]]
	});
	//监听表格行点击
	table.on('tr',function(obj){
		console.log(obj)
	});
	//监听表格复选框选择
	table.on('checkbox(test)',function(obj){
		console.log(obj)
	});
	//监听表格单选框选择
	table.on('radio(test2)',function(obj){
		console.log(obj)
	});
	//监听单元格编辑
	table.on('edit(test2)',function(obj){
		var value = obj.value//得到修改后的值
		,data = obj.data//得到所在行所有键值
		,field = obj.field;//得到字段
	});
	//监听工具条
	table.on('tool(test)',function(obj){
		var data = obj.data;
		if(obj.event=='del'){
			layer.confirm('真的删除行么？',function(index){
				$.ajax({
					url:"<%=request.getContextPath()%>/deleteStage.action",
					type:'POST',
					data:{"id":data.id},
					//dataType:"json",
					success:function(data){
						obj.del();
						layer.close(index);
						layer.msg("删除成功",{icon:6});						
					},
					error:function(data){
						layer.msg("删除失败",{icon:5});
					}
				});
			});
		}
	
});

})