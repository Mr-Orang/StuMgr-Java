<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
	$(function(){
		Objrows={
				addSchool:function(){
					$.ajax({
						type:'POST',
						url:'${pageContext.request.contextPath }/addSchool',
						data:{
							'tst_id':$.trim($('input[name="tst_id"]').val()),
							'tst_academy':$.trim($('input[name="tst_academy"]').val()),
							'tst_sourceNumber':$.trim($('input[name="tst_sourceNumber"]').val()),
							'tst_applyCount':$.trim($('input[name="tst_applyCount"]').val()),
							'tst_enrollment':$.trim($('input[name="tst_enrollment"]').val()),
						},
						onBeforeSuccess:function(){
							$('#school').datagrid('loading');
						},
						success:function(data){
							var mg="添加成功";
							if(data!="success"){
								mg="添加失败";
							}
							$.messager.show({
									title:'消息',
									msg:mg
							})
							$('#schoolwindow').window('close');
							$('#school').datagrid('load');
						}
					})
				},
		}
	})
	
</script>

<div align="center">
	<h2>添加生源地区/院校统计招生情况</h2>
	 编号:<input type="text" name="tst_id"  checked/><br/></br>
           生源地区/院校:<input type="text" name="tst_academy"/><br/></br>
   	生源人数:<input type="text" name="tst_sourceNumber"/><br/></br>
   	报名人数:<input type="text" name="tst_applyCount"/><br/></br>
   	报名率:<input type="text" name="tst_enrollment"/><br/></br>
   	<input type="button" value="保存" onclick="Objrows.addSchool();"/>
</div>