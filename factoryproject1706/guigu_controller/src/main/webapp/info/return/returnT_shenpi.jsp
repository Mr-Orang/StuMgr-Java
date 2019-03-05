<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">

</script>
<table style="margin-left:50px" cellspacing="20">
  <tr>
    <td>休学编号</td>
    <td><input type="text" value="${param.lEAVE_ID}"/></td>
  </tr>
  <tr>
    <td>学生姓名</td>
    <td><input type="text" value="${param.sTU_NAME}"/></td>
  </tr>
  <tr>
    <td>学生性别</td>
    <td><input type="text" value="${param.sTU_SEX}"/></td>
  </tr>
  <tr>
    <td>原班级名称</td>
    <td><input type="text" value="${param.tc_NAME}"/></td>
  </tr>
  <tr>
    <td>阶段</td>
    <td><input type="text" value="${param.tl_NAME}"/></td>
  </tr>
  <tr>
    <td>休学时间</td>
    <td><input type="text" value="${param.lEAVE_STARTTIME}"/></td>
  </tr>
   <tr>
    <td>复学时间</td>
    <td><input type="text" value="${param.return_time}"/></td>
  </tr>
  <tr>
    <td>休学理由</td>
    <td><input type="text" value="${param.leave_reason}"/></td>
  </tr>
  <tr>
		<td>
			<input type="radio" name="return_radio" checked/>同意
			<input type="radio" name="return_radio" onclick=""/>不同意
		</td>
	</tr>
	<tr>
		<td><strong>不同意理由：</strong></td>
	</tr>
	<tr>
		<td colspan="2">
			<!--文本域-->
			<textarea rows="6" cols="60" id="return_wenben"></textarea>
		</td>
	</tr>
</table>
<div >
<button class="easyui-linkbutton" 
	style="width:300px;margin-left:150" onclick="">确定</button>
</div>

