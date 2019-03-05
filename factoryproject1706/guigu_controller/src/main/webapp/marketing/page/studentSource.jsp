<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function() {
		studentSourceObj = {
			addStudentSource : function() {
				$("<div id='addStudentSourceWindow'></div>").window({
					closed : false,
					title : '新增生源',
					width : 520,
					height : 350,
					modal : true,
					collapsible : false,
					maximizable : false,
					minimizable : false,
					draggable : true,
					href : '${pageContext.request.contextPath}/marketing/page/addStudentSource.jsp',
					queryParams : {
						'empID' : '${sessionScope.emplyee.te_id}'
					},
					onClose : function() {
						//销毁窗口
						$(this).window("destroy");
					}
				});
			},
			updateStudentSource : function(tss_id) {
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath }/marketing/studentSource/queryStudentSourceByID',
					data : {
						'tss_id' : tss_id
					},
					success : function(stuSourceInfo) {
						$("<div id='updateStudentSourceWindow'></div>").window({
							closed : false,
							title : '修改生源信息',
							width : 520,
							height : 450,
							modal : true,
							collapsible : false,
							maximizable : false,
							minimizable : false,
							draggable : true,
							href : '${pageContext.request.contextPath}/marketing/page/updateStudentSource.jsp',
							queryParams : {
								'tss_id' : tss_id,
								'tss_name':stuSourceInfo.tss_name,
								'tss_mobile':stuSourceInfo.tss_mobile,
								'tss_area_school':stuSourceInfo.tss_area_school,
								'tss_qq':stuSourceInfo.tss_qq,
								'trs_id':stuSourceInfo.trs_id,
								'tss_losttext':stuSourceInfo.tss_losttext,
								'tss_parent_mobile':stuSourceInfo.tss_parent_mobile,
							},
							onClose : function() {
								//销毁窗口
								$(this).window("destroy");
							}
						});
					}
				});

			},
			searchStudentSource : function() {
				var ID = $("#ID").val();
				var name = $("#name").val();
				var mobile = $("#mobile").val();
				var empName = $("#empName").val();
				var area = $("#area").val();
				var status = $("#status").combobox("getValue");
				var startDate = $("#startDate").datebox("getValue");
				var endDate = $("#endDate").datebox("getValue");
				status = (status == "--请选择--" ? null : status);
				$('#studentSourceData').datagrid('load', {
					'ID' : ID,
					'name' : name,
					'empName' : empName,
					'mobile' : mobile,
					'area' : area,
					'status' : status,
					'startDate' : startDate,
					'endDate' : endDate
				});
			},
			clearCondition : function() {
				var ID = $("#ID").val('');
				var name = $("#name").val('');
				var mobile = $("#mobile").val('');
				var area = $("#area").val('');
				var empName = $("#empName").val('');
				$("#status").combobox("setValue", '--请选择--');
				$('#startDate').datebox('setValue', '');
				$('#endDate').datebox('setValue', '');
				studentSourceObj.searchStudentSource();

			}
		};
		$("#studentSourceData").datagrid({
			title : '生源信息',
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
					width : 200,
				//checkbox:true
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
					width : 200,
				},
				{
					field : 'tss_regdate',
					title : '录入日期',
					width : 200,
				},
				{
					field : 'trs_name',
					title : '招生状态',
					width : 200,
				},
				{
					field : 'tss_losttext',
					title : '流失原因',
					width : 200,
				},
				{
					field : 'tss_parent_mobile',
					title : '父母电话',
					width : 200,
				},
				{
					field : 'tss_empName',
					title : '市场人员姓名',
					width : 200,
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 200,
					formatter : function(value, row, index) {
						return "<button onclick=studentSourceObj.updateStudentSource('" + row.tss_id + "')>修改</button>&nbsp;";
					}
				}
			] ],
			//如果为true，则只允许选择一行。
			singleSelect : true,
			//如果为true，则显示一个行号列。
			rownumbers : true,
			url : '${pageContext.request.contextPath }/marketing/studentSource/queryStudentSource',
			//如果为true，则在DataGrid控件底部显示分页工具栏。
			pagination : true,
			pageList : [ 5, 4, 3, 2 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#studentSourceBar'
		});
		$("#status").combobox({
			url : '${pageContext.request.contextPath }/marketing/studentSource/queryRecruitStatus',
			valueField : 'trs_id',
			textField : 'trs_name',
			editable : false,
		});
		$("#status").combobox("setValue", '--请选择--');
		$('#startDate').datebox({
			//required : true
		});
		$('#endDate').datebox({
			//required : true
		});
	});
</script>

<div id="studentSourceData"></div>

<div id="studentSourceBar" style="display:none">
	<div style="margin:5px">
		<div style="margin:5px 0px 5px 8px">
			<a class="easyui-linkbutton" iconCls="icon-add"
				onclick="studentSourceObj.addStudentSource()">新增生源</a> &nbsp;生源编号:<input
				id="ID" /> &nbsp;生源姓名:<input id="name" /> &nbsp;生源电话:<input
				id="mobile" />
		</div>
		<div style="margin:5px 0px 5px 8px">
			&nbsp;生源地区或院校:<input id="area" /> &nbsp;市场人员名称:<input id="empName" />
			&nbsp;招生状态:<input id="status" /> &nbsp;起始日期:<input id="startDate" />
			——截止日期:<input id="endDate" /> &nbsp;<a class="easyui-linkbutton"
				iconCls="icon-search"
				onclick="studentSourceObj.searchStudentSource()">搜索</a>&nbsp;&nbsp;
			<a class="easyui-linkbutton" iconCls="icon-remove"
				onclick="studentSourceObj.clearCondition()">清空搜索条件</a>
		</div>
	</div>
</div>