<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 添加处罚jsp -->
<script type="text/javascript">
	$(function() {
		commit = function() {
			$.ajax({
				url : "${pageContext.request.contextPath }/noAgreeExamine.action",
				data : {
					'rewardsid' : $('#rewardsid').val(),
					'Rewards_reason':$('#texta1').val()
				},
				success : function(data) {
					$.messager.alert('我的消息', data, 'info');
					$('#queryRewardsApplyInfo').datagrid("reload");
					$('#noagree').window('close');
				}
			});
		}
	})
	cancel = function() {
		$('#noagree').window('close');
	}
</script>
<div id="rewards" style="text-align:center;">
	<input type="hidden" value="${param.rewardsid }" id="rewardsid" /> 
	<label style="font-size:20px;">填不同意理由:</label> <br/>
	<div>
		<textarea rows="7" cols="40" id="texta1"></textarea>
	</div>
	<div>
		<table style="margin: auto;" width='300px;'>
			<tr>
				<td style="text-align: center;" onclick="commit();"><button>提交</button></td>
				<td style="text-align: center;" onclick="cancel();"><button>取消</button></td>
			</tr>
		</table>
	</div>
</div>
