<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	
	<script type="text/javascript">
		 director={
		     	shenpileave:function(){
		     		//alert(1);
		     		var leave_id="${param.leave_id}";
		     		var state2=$('input[name="dan2"]:checked').val();
		     		var yuanyi2="";
						if(state2==2){
							yuanyi=$('#wenbyu2').val();
							if(yuanyi2.length<=1){
								$.messager.alert("我的消息","请在以下文本域中输入原因");
								return;
							}
						}
						$.ajax({
							type:"post",
							url:"shenpibaocun2.action",
							data:{
								'leave_id':leave_id,
								'yuanyi2':yuanyi2,
								'state2':state2
							},
							success:function(b){
								$.messager.show({
								title:'我的消息',
								msg:b, 
								timeout:5000,
								showType:'slide'
								});
								$("#directorshenpileave").window('close');
								$("#directorshenpi").datagrid('reload');
								$("#zhurenshenpixiangxi").datagrid('reload');//刷新详细
							
							}
							
						});
		     	}
		     }
	</script>	
		
<div style="margin:10px">
	<span style="font-weight:bold">开始时间:</span><input type="text" value="${param.leave_starttime}" readonly="readonly"/><br/>
	<span style="font-weight:bold">结束时间:</span><input type="text" value="${param.leave_endtime}" readonly="readonly"/><br/>
	<span style="font-weight:bold">审批人:</span><input type="text" value="${param.te_name}" readonly="readonly"/><br/>
	<span style="font-weight:bold">请假原因:</span><br/>
	<textarea rows="3" cols="80" readonly="readonly">${param.leave_reason}</textarea><br/>
	<input type="radio" name="dan2" value="1" checked="checked" />同意 <input
		type="radio" name="dan2" value="2" />不同意<br />
		<span style="font-weight:bold">不同意原因</span> <br />
	<textarea rows="6" cols="80" id="wenbyu2"></textarea>
	<br/>
</div>
<button onclick="director.shenpileave()">保存</button>