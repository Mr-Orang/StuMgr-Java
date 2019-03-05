<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
		$(function(){
			objmod={
				modifySchool:function(){
						$.ajax({
							type:'POST',
							url:'${pageContext.request.contextPath }/updateSchoolByid',
							data:{
								'tst_id':$.trim($('input[name="tst_id"]').val()),
								'tst_academy':$.trim($('input[name="tst_academy"]').val()),
								'tst_sourceNumber':$.trim($('input[name="tst_sourceNumber"]').val()),
								'tst_applyCount':$.trim($('input[name="tst_applyCount"]').val()),
								'tst_enrollment':$.trim($('input[name="tst_enrollment"]').val()),
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
								$('#schoolwindow').window('close');
								$('#school').datagrid('load');
							}
						});
					},
				}
		})

</script>
<div align="center">
	<h2>添加生源地区/院校统计招生情况</h2>
	 编号:<input type="text" name="tst_id" value="${param.tst_id}" checked/><br/></br>
           生源地区/院校:<input type="text" name="tst_academy" value="${param.tst_academy}"/><br/></br>
   	生源人数:<input type="text" name="tst_sourceNumber" value="${param.tst_sourceNumber}"/><br/></br>
   	报名人数:<input type="text" name="tst_applyCount" value="${param.tst_applyCount}"/><br/></br>
   	报名率:<input type="text" name="tst_enrollment" value="${param.tst_enrollment}"/><br/></br>
   	<input type="button" value="保存" onclick="objmod.modifySchool();"/>
</div>