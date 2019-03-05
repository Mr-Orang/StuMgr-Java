<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
	$(function() {
		$('#student_class').datagrid({
			title : '学生入班信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'tss_id',
					title : '生源编号',
					width : 200
				},
				{
					field : 'tss_name',
					title : '生源姓名',
					width : 200
				
				},
				{
					field : 'tss_mobile',
					title : '电话',
					width : 200
				},
				{
					field : 'tss_area_school',
					title : '生源地区/院校名称',
					width : 200
				},
				{
					field : 'tss_qq',
					title : 'qq号码',
					width : 200
				},
				{
					field : 'tss_regdate',
					title : '录入日期',
					width : 200
				},
				{
					field : 'trs_name',
					title : '招生状态',
					width : 200
				},
				{
					field : 'tss_parent_mobile',
					title : '父母电话',
					width : 200
				},
				{
					field : 'tss_empName',
					title : '市场人员姓名',
					width : 200
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button onclick=>查看详情</button>&nbsp;";
					}
				}
			] ],
			singleSelect : true,
			rownumbers : true,
			url : '/Class/queryStudentSource',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#student_toolbar'
		});
		$('#choose').combobox({    
			    url:'/Class/queryJoinClass',    
			    valueField:'id',    
			    textField:'text',
			    editable: true ,
			    onSelect: function(){
			         var tc_id=$("#choose").combobox("getValue");
			   		 $.ajax({
			    		type:'POST',
						url:'${pageContext.request.contextPath }/Class/queryClass',
						data:{
								'tc_id':tc_id
							},
						success:function(data){
							$('#nowpn').val(data.tc_personnum);
							$('#level').val(data.tl_name);
							$('#cteacher').val(data.te_name);
						}
			    	})
			    	
			    }  
		});
		StudentOjb={
			addStudentClass : function() {
				var rowObj=$('#student_class').datagrid('getSelections');
				if(rowObj.length==0){
				$.messager.alert('提示','请先选择要入班的学生','warning');
				return;
				}
				var tc_id=$("#choose").combobox("getValue");
				//alert(tc_id)
				if(tc_id==""){
				$.messager.alert('提示','请先选择进入的班级','warning');
				return;
				}
				var tss_id=rowObj[0].tss_id;
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath }/Class/queryStudentById',
					data : {
						'tss_id' : tss_id
					},
					success : function(data) {
					$("<div id='addStudentClassWindow'></div>").window({
					closed : false,
					title : '学生入班',
					width : 520,
					height : 550,
					modal : true,
					collapsible : false,
					maximizable : false,
					minimizable : false,
					draggable : true,
					href : '${pageContext.request.contextPath}/marketing/page/student_class/joinClass.jsp',
					queryParams : {
						    'tc_id':tc_id,
						    'tss_id':tss_id,
						    'tss_name':data.tss_name,
							'tss_mobile':data.tss_mobile,
							'tss_area_school':data.tss_area_school,
							'tss_qq':data.tss_qq,
							'tss_parent_mobile':data.tss_parent_mobile,
					},
					onClose : function() {
						//销毁窗口
						$(this).window("destroy");
					}
				});
				}
				})
			},
			
			
			
		}
	})
</script>
<div id="student_class"></div>
<div id="student_toolbar">
	<div style="margin:5px 0px 5px 8px">
		 <span style="color:red">*</span>选择班级：<input id="choose"/>
		 班级当前人数：<input id="nowpn" readonly="readonly"/> 
		 班级阶段：<input id="level" readonly="readonly"/>
		 班主任：<input id="cteacher" readonly="readonly"/>&nbsp; &nbsp;
		 <a class="easyui-linkbutton" iconCls="icon-add"
				onclick="StudentOjb.addStudentClass()">学生入班</a> &nbsp;
	</div>
</div>