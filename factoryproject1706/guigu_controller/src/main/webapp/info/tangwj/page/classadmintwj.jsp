<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 自己写的js -->
<!-- 装上面的考勤类型和时间 -->
<div id="kaoqintime" style="height:'80px'; width:'100%';margin:'0px'">
	考勤类型:<input class="easyui-combobox" value="请选择考勤类型" name="kaoqinglx"
		type="text" id="kaoqintype" width="30px" /> 考勤时间:<input type="text"
		width="25px" readonly="readonly" id="kaoqinbegintime" />--<input
		type="text" readonly="readonly" id="kaoqinendtime" width="25px" />
</div>
<!-- 装显示班级 -->
<div id="mthodclasstwj"></div>
<script type="text/javascript">
	$(function() {
		var abc="";
		kaoqintwj = {
			kaoqinclass : function(kaoqinleixing, rowtow) {
			//取下拉框所选中的文本
				abc = $("#kaoqintype").combobox('getText');
				var kaoqinglx = $("input[name='kaoqinglx']").val();
				if (kaoqinglx == "请选择考勤类型") {
					$.messager.alert("消息", "请先选择考勤类型");
					return;
				}
				$.ajax({
					type : 'POST',
					url : '',
					data : {
						'classnamekaoqin' : kaoqinleixing,
						'kaoqinglx' : kaoqinglx
					},
					success : function(data) {
						//if (data.trim() == "未考勤") {
							$('<div id="win"></div>').window({
								title : '学生考勤',
								height : 300,
								width : 780,
								modal : true,
								href : 'info/tangwj/page/studentkaoqin.jsp?row=' + kaoqinleixing
									+ "&rowtow=" + rowtow
									+ "&kaoqinglx=" + kaoqinglx,
								onClose : function() {
									$("#win").window("destroy");
								}
							});
						//}
						
					}
				});
			}
		};
		$("#mthodclasstwj").datagrid({
			fitColumns : true,
			columns : [ [
				{
					field : 'tc_name',
					title : '班级名称',
					width : 100,
				},
				{
					field : 'tc_personnum',
					title : '班级人数',
					width : 100
				},
				{
					field : 'tc_technology',
					title : '专业名称',
					width : 100,
					formatter : function(value,row,index){
						if(value==1){
							return "Java";
						}else{
							return ".Net";
						}
						
					}
				},
				{
					field : 'caozuo',
					title : '操作',
					width : 100,
					formatter : function(value, row, index) {
						var on = '"' + row.tc_name + '"';
						return "<button  onclick=kaoqintwj.kaoqinclass(" + on + "," + row.tc_personnum + ")>开始考勤</button>"
					}
				}
			] ],
			collapsible : false,
			maximizable : false,
			minimizable : false,
			singleSelect : true,
			url : 'kaoqin/kaoqincalssshow.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#dd',
		});
	});
	$("#kaoqintype").combobox({
		url : 'kaoqin/kaoqintypeselect.action',
		valueField : 'id',
		textField : 'text',
		onSelect : function(rec) {
			$.ajax({
				type : 'POST',
				url : 'kaoqin/kaoqinTime.action',
				data : {
					'text' : rec.text
				},
				success : function(data) {
					$("#kaoqinbegintime").val(data.inbegin);
					$("#kaoqinendtime").val(data.eend);
					//$("#kaoqintime").tabs("reload");
					return;
				}
			});
		}
	});
</script>
