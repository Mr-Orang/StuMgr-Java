<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function() {
		Objrow = {
			addSale : function() {
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath }/addSale',
					data : {
						'sts_id' : $.trim($('input[name="sts_id"]').val()),
						'sts_empid' : $.trim($('input[name="sts_empid"]').val()),
						'sts_sourceNmber' : $.trim($('input[name="sts_sourceNmber"]').val()),
						'sts_applyCount' : $.trim($('input[name="sts_applyCount"]').val()),
						'sts_enrollment' : $.trim($('input[name="sts_enrollment"]').val()),
					},
					onBeforeSuccess : function() {
						$('#sale').datagrid('loading');
					},
					success : function(data) {
						var mg = "添加成功";
						if (data != "success") {
							mg = "添加失败";
						}
						$.messager.show({
							title : '消息',
							msg : mg
						})
						$('#window').window('close');
						$('#sale').datagrid('load')
					}
				})
			},
			ResultNum :function () {
				var numA = $("#sts_sourceNmber").val();
				var numB = $("#sts_applyCount").val();
				var resultnumber;
				alert(numA+""+numB);
				 if (document.getElementById("scurce").value == "" || document.getElementById("apply").value == "") {
					alert("请输入两个数！");
				}else {
					resultnumber = parseInt(numB) / parseInt(numA);
					alert(resultnumber)
					$("#sts_enrollment").val(resultnumber);
				}
			}
		}
	})
</script>
<div align="center">
	<h2>添加市场人员统计招生情况</h2>
	编号:<input type="text" name="sts_id" /><br /></br> 
	市场人员:<input type="text"name="sts_empid" /><br /></br> 
	生源人数:<input type="text" id="sts_sourceNmber"name="sts_sourceNmber" /><br /></br> 
	报名人数:<input type="text"id="sts_applyCount" name="sts_applyCount" /><br /></br>
	 报名率:<input type="text" id="sts_enrollment" name="sts_enrollment" onblur="Objrow.ResultNum()"/><br /></br>
	<input type="button" value="保存" onclick="Objrow.addSale();" />
</div>