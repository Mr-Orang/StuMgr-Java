<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$(function() {
		Consults = {
			ConsultUpdate : function(tst_id) {
				//
				$.ajax({
					type : "POST",
					url : '${pageContext.request.contextPath}/queryConsultById',
					data : {
						'tst_id' : tst_id
					},
					success : function(data) {
						$('<div id="consultupdate"></div>').window({
							title : '修改生源咨询信息',
							width : 500,
							height : 600,
							modal : true,
							minimizable : false,
							maximizable : false,
							href : '${pageContext.request.contextPath}/marketing/page/consultUpdate.jsp',
							queryParams : {
								'tst_id' : data.tst_id,
								'tss_id' : data.tss_id,
								'te_id' : data.te_id,
								'te_name' : data.te_name,
								'tst_date' : data.tst_date,
								'tst_content' : data.tst_content,
								'tsg_name' : data.tsg_name,
								'tsg_id' : data.tsg_id,
								'tss_name' : data.tss_name
							},
							onClose : function() {
								$(this).window('destroy');
							}
						});
					}
				});
			//
			},
			//添加生源咨询信息
			ConsultAdd:function(){
					$('<div id="addConsult"></div>').window({
						title : '添加生源咨询信息',
						width : 500,
						height : 600,
						modal : true,
						minimizable : false,
						maximizable : false,
						href : '${pageContext.request.contextPath }/marketing/page/consultAdd.jsp',
						queryParams : {
							'te_id' : '${sessionScope.emplyee.te_id}'
						},
						onClose : function() {
							$(this).window('destroy');
						}
					});
			},
			//条件查询
			queryConsultLike : function() {
				var tst_id = $('#tst_id').val();
				var tss_name = $('#tss_name').val();
				var te_name = $('#te_name').val();
				var tst_date = $('#tst_date').datebox('getValue');
				var end_date=$('#end_date').datebox('getValue');
				var tst_content = $('#tst_content').val();
				var tsg_name = $('#tsg_name').combobox('getValue');
				//alert(tst_id+","+tss_name+","+tst_date+","+end_date+","+tst_content+","+tsg_name);
				$('#consults').datagrid('load', {
					'tst_id' : tst_id,
					'tss_name' : tss_name,
					'te_name' : te_name,
					'tst_date' : tst_date,
					'end_date':end_date,
					'tst_content' : tst_content,
					'tsg_name' : tsg_name
				});
			},
			clearConsultLike:function(){
				var tst_id = $('#tst_id').val('');
				var tss_name = $('#tss_name').val('');
				var te_name = $('#te_name').val('');
				var tst_date = $('#tst_date').datebox("setValue", '');
				var end_date = $('#end_date').datebox("setValue",'');
				var tst_content = $('#tst_content').val('');
				var tsg_name = $('#tsg_name').combobox("setValue", '');
				Consults.queryConsultLike();
			}
		}
		$('#consults').datagrid({
			closed : false,
			//url : '${pageContext.request.contextPath }/queryConsult',
			url:'${pageContext.request.contextPath }/queryLikeStdentConsult',
			columns : [ [
				{
					field : 'tst_id',
					title : '编号',
					width : 100
				},
				{
					field : 'tss_name',
					title : '生源姓名',
					width : 100
				},
				{
					field : 'te_name',
					title : '市场人员姓名',
					width : 100
				},
				{
					field : 'tst_date',
					title : '沟通日期',
					width : 100
				},
				{
					field : 'tst_content',
					title : '沟通情况记录',
					width : 100
				},
				{
					field : 'tsg_name',
					title : '生源等级',
					width : 100
				},
				{
					field : 'shenpi',
					title : '修改/删除',
					formatter : function(value, row, index) {
						return "<input type='button' onclick=Consults.ConsultUpdate('" + row.tst_id + "') value='修改'/>";

					}
				}
			] ],
			toolbar :'#consultsSS' ,
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom'
			
		});
		//咨询日期
		$('#tst_date').datebox({
			//required : true
		});
		//end日期
		$('#end_date').datebox({
			//required : true
		});
		
		//生源等级
		$('#tsg_name').combobox({
			url : '${pageContext.request.contextPath }/queryStudentGradeName',
			valueField : 'tsg_id',
			textField : 'tsg_name'
		});
	})
</script>
<div id="consults"></div>
<div id="consultsSS" style="display:none">
	<a class="easyui-linkbutton" iconCls="icon-add"	onclick="Consults.ConsultAdd()">添加</a>
	<div style="margin:5px 0px 5px 8px">
		&nbsp;编号:<input id="tst_id" /> 
		&nbsp;生源姓名:<input id="tss_name" />
		&nbsp;市场人员姓名:<input id="te_name" /> 
		&nbsp;沟通情况记录:<input id="tst_content" /> <br /> 
		&nbsp;&nbsp;&nbsp;&nbsp;<br/>
		&nbsp;沟通日期:<input id="tst_date" />——截止日期:<input id="end_date" /> 
		&nbsp;生源等级:<input	id="tsg_name" /> 
		&nbsp;<a class="easyui-linkbutton" iconCls="icon-search" onclick="Consults.queryConsultLike()">搜索</a>
		&nbsp;&nbsp;<a class="easyui-linkbutton" iconCls="icon-search"	onclick="Consults.clearConsultLike()">清空</a>
	</div>
</div>