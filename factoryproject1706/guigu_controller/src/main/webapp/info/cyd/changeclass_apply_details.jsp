<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<table style="margin-left:50px" cellspacing="20" >
	<tr>
		<td><label>班级名称</label></td>
		<td><input type="text" value="${param.out_classname }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td><label>学生姓名</label></td>
		<td><input type="text" value="${param.stu_name }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td><label>转入班级</label></td>
		<td><input type="text" value="${param.in_classname }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>申请人</td>
		<td><input type="text" value="${param.out_person }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td><label>转班理由</label></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea cols="60" rows="5" id="info_change_class_reason" readonly="readonly">
				${param.put_reason}
			</textarea>
		</td>
	</tr>
	<tr>
		<td>审核人</td>
		<td><input type="text" value="${param.in_person}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>不同意原因</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea cols="60" rows="5" id="info_change_class_reason" readonly="readonly">
				${param.in_reason}
			</textarea>
		</td>
	</tr>
</table>