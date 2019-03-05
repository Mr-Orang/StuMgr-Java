<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
		$(function(){
			objmodify={
				modifySale:function(){
						var sts_empid=$('#sts_empid').combobox('getValue');
						alert(sts_empid)
						$.ajax({
							type:'POST',
							url:'${pageContext.request.contextPath }/updateSaleByid',
							data:{
								'sts_id':$.trim($('input[name="sts_id"]').val()),
								'sts_empid':sts_empid,
								'sts_sourceNmber':$.trim($('input[name="sts_sourceNmber"]').val()),
								'sts_applyCount':$.trim($('input[name="sts_applyCount"]').val()),
								'sts_enrollment':$.trim($('input[name="sts_enrollment"]').val()),
							},
							success:function(data){
								var mg="修改成功";
								if(data!="success"){
									mg="修改失败";
								}
								$.messager.show({
										title:'消息',
										msg:mg
								});
								$('#window').window('close');
								$('#sale').datagrid('load');
							}
						});
					},
				}
		})
		$('#sts_empid').combobox({
			url : '${pageContext.request.contextPath }/queryEmp',
			valueField : 'te_id',
			textField : 'te_name',
			editable : false,
		});
		$("#sts_empid").combobox("setValue", '${param.sts_empid}');
</script>
<div align="center">
	<h2>修改生源地区/院校统计招生情况</h2>
	 编号:<input type="text" name="sts_id" value="${param.sts_id}" checked/><br/></br>
           市场人员姓名:<input id="sts_empid"/><br/></br>
   	生源人数:<input type="text" name="sts_sourceNmber" value="${param.sts_sourceNmber}"/><br/></br>
   	报名人数:<input type="text" name="sts_applyCount" value="${param.sts_applyCount}"/><br/></br>
   	报名率:<input type="text" name="sts_enrollment" value="${param.sts_enrollment}"/><br/></br>
   	<input type="button" value="保存" onclick="objmodify.modifySale();"/>
</div>
