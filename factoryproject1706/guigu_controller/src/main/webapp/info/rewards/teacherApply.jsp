<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
		$(function(){
			$('#queryStudentinfo').datagrid({
				fitColumn : true,
				columns : [ [
					{
						field : 'stu_name',
						title : '学生姓名',
						width : 100,
					},
					{
						field : 'stu_sex',
						title : '学生性别',
						width : 100
					},
					
					{
						field : 'stu_phone',
						title : '学生电话',
						width : 100
						
					},
					{
						field : 'par_phone',
						title : '家长电话',
						width : 100
					},
					{
						field : 'address',
						title : '家庭地址',
						width : 100
					}
					,{
						field : 'tc_name',
						title : '班级名称',
						width : 100
					},
					{
						field : 'apartment_id',
						title : '宿舍编号',
						width : 100
					},
					{
						field : 'school',
						title : '毕业院校',
						width : 100,
						formatter: function(value){
								return '<a title='+value+' class="easyui-tooltip">'+value+'</a>';
							}
					}
					
				] ],
				collapsible : false,
				maximizable : false,
				minimizable : false,
				url : '${pageContext.request.contextPath }/queryStudentByTeacherid.action',
				pagination : true,
				pageList : [ 5, 10, 15, 20 ],
				pageSize : 5,
				pageNumber : 1,
				pagePosition : 'bottom',
				toolbar : '#reacher_1_1',
			});
		})
		addrewred=function(){
			var stuidArry = new Array();
			var stuid=$('#queryStudentinfo').datagrid("getSelections");
			for(var i=0;i<stuid.length;i++)
			{
			  stuidArry[i]=stuid[i].stu_id;
			}
			if(stuid.length==0){
				alert("请选择")
			}else{
				$('<div id="addrewards"></div>').window({
					 title:'添加申请奖励',
					 height:'210',
					 width:'400',
					 modal:true,
					 collapsible:false,
					 minimizable:false,
					 maximizable:false,
					 draggable:false,
					 resizable:false,
	   			     href:"${pageContext.request.contextPath }/info/rewards/addrewards.jsp?rewards_type=0"+"&&stuidArry="+stuidArry,
	   			     onClose:function(){
							$('#addrewards').window("destroy");
					}
				})
			}
		}
		addpunish=function(){
			var stuidArry = new Array();
			var stuid=$('#queryStudentinfo').datagrid("getSelections");
			for(var i=0;i<stuid.length;i++)
			{
			  stuidArry[i]=stuid[i].stu_id;
			}
			if(stuid.length==0){
				alert("请选择")
			}else{
				$('<div id="addpunish"></div>').window({
					 title:'添加处分申请',
					 height:'210',
					 width:'400',
					 modal:true,
					 collapsible:false,
					 minimizable:false,
					 maximizable:false,
					 draggable:false,
					 resizable:false,
		   		     href:"${pageContext.request.contextPath }/info/rewards/addpunish.jsp?rewards_type=1"+"&&stuidArry="+stuidArry,
		   		     onClose:function(){
							$('#addpunish').window("destroy");
					}
				})
			}
		}
	</script>
    <div id="queryStudentinfo"></div>
    <div id="reacher_1_1">
		<div style="margin:5px">
	   		<a class="easyui-linkbutton" 
	   			iconCls="icon-add"
	   			onclick="addrewred();">
	   		申请奖励</a>
	   		<a class="easyui-linkbutton" 
	   			iconCls="icon-remove"
	   			onclick="addpunish();">
	   		申请处分</a>
	   		</div>
	</div>
