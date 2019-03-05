<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 	<script type="text/javascript">
		$(function(){
		     baocun={
		     	leave:function(){
		     		//alert(1);
		     		var leave_id="${param.leave_id}";
		     		//alert(leave);
		     		var state=$('input[name="dan"]:checked').val();
		     		var yuanyi="";
						if(state==2){
							yuanyi=$('#wenbyu').val();
							if(yuanyi.length<=1){
								$.messager.alert("我的消息","请在以下文本域中输入原因");
								return;
							}
						}
						$.ajax({
							type:"post",
							url:"shenpibaocun.action",
							data:{
								'leave_id':leave_id,
								'yuanyi':yuanyi,
								'state':state
							},
							success:function(b){
								$.messager.show({
								title:'我的消息',
								msg:b, 
								timeout:5000,
								showType:'slide'
								});
								$("#leavexiangxi2").window('close');
								$("#teacherleave").datagrid('reload');
								$("#leavexiangxi").datagrid('reload');//刷新详细
							
							}
							
						});
		     	}
		     }
		})
	</script> 

<!--  toolbar -->


<div style="margin:10px">
	<span style="font-weight:bold">开始时间:</span><input type="text" value="${param.leave_starttime}" readonly="readonly"/><br/>
	<span style="font-weight:bold">结束时间:</span><input type="text" value="${param.leave_endtime}" readonly="readonly"/><br/>
	<span style="font-weight:bold">请假原因:</span><br/>
	<textarea rows="3" cols="80" readonly="readonly">${param.leave_reason}</textarea><br/>
	<input type="radio" name="dan" value="1" checked="checked" />同意 <input
		type="radio" name="dan" value="2" />不同意<br />
		<span style="font-weight:bold">不同意原因</span> <br />
	<textarea rows="6" cols="80" id="wenbyu"></textarea>
	<br/>
</div>
<button onclick="baocun.leave()">保存</button>
