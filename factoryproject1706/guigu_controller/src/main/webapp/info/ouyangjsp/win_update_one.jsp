<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!--
<table><tr><td>编号：</td><td><input id="talk_details_id" type="text" value="'+data.talk_details_id+'"/></td></tr><tr><td>谈话类型：</td><td><input type="text" value="'+data.talk_type+'"/></td></tr><tr><td>姓名：</td><td><input type="text" value="'+data.stu_name+'"/></td></tr><tr><td>谈话内容：</td><td><textarea rows="8" cols="18">'+data.talk_content+'</textarea></td></tr><tr><td>谈话人：</td><td><input type="text" value="'+data.talk_person+'"/></td></tr><tr><td>谈话时间：</td><td><input type="text" value="'+data.talk_time+'"/></td></tr></table>
-->
<table>
	<tr><td>编号：</td><td><input id="talk_details_id" type="text" value="${param.talk_details_id}"/></td></tr><tr><td>谈话类型：</td><td><input type="text" value="'+data.talk_type+'"/></td></tr>
	<tr><td>姓名：</td><td><input type="text" value="${param.stu_name }"/></td></tr>
	<tr><td>谈话内容：</td><td><textarea rows="8" cols="18">${param.talk_content}</textarea></td></tr>
	<tr><td>谈话人：</td><td><input type="text" value="${param.talk_person }"/></td></tr>
	<tr><td>谈话时间：</td><td><input type="text" value="${param.talk_time }"/></td></tr>
</table>