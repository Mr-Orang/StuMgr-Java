<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 宿舍管理信息  lijianghua -->
<script>
	Dorm = {
		addDorm : function() {
			$('<div id="dormMessageAdd"></div>').window({
				title : '添加宿舍信息',
				width : 500,
				height : 600,
				modal : true,
				collapsible : false,
				maximizable : false,
				minimizable : false,
				draggable : false,
				href : '${pageContext.request.contextPath}/marketing/page/dormAdd.jsp',
				onClose : function() {
					$(this).window("destroy");
				}
			})
		},
		queryDorms : function() {
			var tdm_id=$("#tdm_ids").val();
			var tdm_number=$("#tdm_numbers").val();			
			var tdm_bed=$("#tdm_beds").val();
			var tdm_nowbed=$("#tdm_nowbeds").val();
			var tdm_state=$("#tdm_states").val();
			var tdm_typename=$("input[name='tdm_typenames']:radio:checked").val();
			$('#dormMessage').datagrid('load', {
				"tdm_id":tdm_id,
				"tdm_number":tdm_number,
				"tdm_bed":tdm_bed,
				"tdm_nowbed":tdm_nowbed,
				"tdm_state":tdm_state,
				"tdm_typename":tdm_typename
			
			});
		},
		clearDorms : function() {
			var tdm_id=$("#tdm_ids").val('');
			var tdm_number=$("#tdm_numbers").val('');			
			var tdm_bed=$("#tdm_beds").val('');
			var tdm_nowbed=$("#tdm_nowbeds").val('');
			var tdm_state=$("#tdm_states").val('');
			var tdm_typename=$("input[name='tdm_typenames']:radio:checked").val('');
			Dorm.queryDorm();
		}
	}

	$('#dormMessage').datagrid({
		closed : false,
		url : '${pageContext.request.contextPath }/quereyDormMessages',
		columns : [ [
			{
				field : 'tdm_id',
				title : '编号',
				width : 100
			},
			{
				field : 'tdm_number',
				title : '宿舍编号',
				width : 100
			},
			{
				field : 'tdm_bed',
				title : '宿舍床位',
				width : 100
			},
			{
				field : 'tdm_nowbed',
				title : '实住床位',
				width : 100
			},
			{
				field : 'tdm_state',
				title : '说明',
				width : 100
			},
			{
				field : 'tdm_typename',
				title : '宿舍类型',
				width : 100
			}
		] ],
		toolbar : '#likeDorm',

		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		pageSize : 5,
		pageNumber : 1,
		pagePosition : 'bottom'
	});
</script>
<div id="dormMessage"></div>


<div id="likeDorm" style="display:none">
		<div style="margin:5px 0px 5px 8px">
			<a class="easyui-linkbutton" iconCls="icon-add"	onclick="Dorm.addDorm()">添加</a>
			&nbsp;编号:<input id="tdm_ids" /> 
			&nbsp;宿舍编号:<input id="tdm_numbers" />
			&nbsp;宿舍床位:<input id="tdm_beds" /><br /> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;说明:<input id="tdm_states"/>
			&nbsp;实住床位:<input	id="tdm_nowbeds" /> 
			&nbsp;宿舍类型:<input type="radio" name="tdm_typenames" value="1" checked id="tdm_typenames" />男 
						 <input type="radio" name="tdm_typenames" value="2" id="tdm_typenames" />女 &nbsp;
			<a class="easyui-linkbutton" iconCls="icon-search" 	onclick="Dorm.queryDorms()">搜索</a> &nbsp;&nbsp;
			<a class="easyui-linkbutton" iconCls="icon-search" 	onclick="Dorm.clearDorms()">清空</a>
		</div>
	</div>
