<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 添加奖励jsp -->
<script type="text/javascript">
	$(function() {
		commit=function(){
			$.ajax({
					url : "${pageContext.request.contextPath }/addRewardsPunish.action",
					data : {
						'rewards_type' : $('#rewardstype').val(),
						'stuidArry':$('#stuidaarry').val(),
						'textal':$('#texta1').val(),
					},
					success : function(data) { 
						$.messager.alert('我的消息',data,'info');
						$('#addrewards').window('close');
					}
				});
			}
	})
	cancel = function() {
		$('#addrewards').window('close');
	}
</script>
<div id="rewards" style="text-align:center;">
	<input type="hidden" value="${param.rewards_type}" id="rewardstype"/> 
	<input type="hidden" value="${param.stuidArry }" id="stuidaarry"/> 
	<label
		style="font-size:20px;">填写奖励详情:</label> <br />
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
