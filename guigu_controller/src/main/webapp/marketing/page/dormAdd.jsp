<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$('#tdf_number').combobox({ //宿舍栋号
		url : '${pageContext.request.contextPath }/queryDromFloor',
		valueField : 'tdf_id',
		textField : 'tdf_number',
		width : 80,
		height : 20
	});
	$('#tloor_number').numberspinner({ //宿舍楼层
		min : 1,
		max : 5,
		width : 80,
		height : 20,
		editable : false,
		value:'#tloor_number'
	});
	$('#tloor_house').numberspinner({ //宿舍号
		min : 1,
		max : 20,
		width : 80,
		height : 20,
		editable : false,
		value:'tloor_house'
	});

	//宿舍床位
	$('#tdm_bed').combobox({
		url : '${pageContext.request.contextPath }/queryDromFloorBeD',
		valueField : 'tdf_id',
		textField : '#floor_bed'
	});

	//保存
	$('#baocunDormAdd').linkbutton({
		onClick : function() {
			var tdf_number = $("#tdf_number").combobox('getText');
			var tloor_number = $('#tloor_number').numberspinner('getValue');
			var tloor_house = $('#tloor_house').numberspinner('getValue');
			var tdm_number = $("#tdm_number").val(); //宿舍楼层编号
			tdm_number = tdf_number + "-" + tloor_number + "-" + tloor_house;
			var tdf_id = $("#tdf_id").val(); //序列id
			var tdm_bed = $("#tdm_bed").combobox('getText'); //宿舍床位
			var tdm_state = $("#tdm_state").val(); //说明
			var tdm_typeID = $("input[name='tdm_typeID']:radio:checked").val(); //宿舍类型
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/addDormMessages',
				data : {
					'tdf_id' : tdf_id,
					'tdm_number' : tdm_number,
					'tdm_bed' : tdm_bed,
					'tdm_state' : tdm_state,
					'tdm_typeID' : tdm_typeID
				},
				success : function(data) {
					if (data != "no") {
						alert("保存成功！");
						$.messager.confirm('提示框', '是否关闭页面?', function(r) {
							if (r) {
								$('#dormMessageAdd').window('close');
								$('#dormMessage').datagrid('reload');
							}
						});
					} else {
						alert("保存失败！");
					}
				}
			});



		}
	});
</script>
<div align="center">
	<h2>宿舍添加</h2>
</div>

<hr />
<br />
<input type="hidden" id="tdf_id" />
<h3>宿舍编号：</h3>
<div align="center">

	栋号： <input id="tdf_number" /> 楼层： <input id="tloor_number" /> 宿舍号： <input
		id="tloor_house" /><br />
</div>
<input type="hidden" id="tdm_number" />
<h3>宿舍床位：</h3>
<div align="center">
	<input id="tdm_bed" /><br />
</div>
<!--  <h3>实住床位：</h3>
<div align="center">
	<input id="tdm_nowbed" /><br />
</div>-->
<h3>说明：</h3>
<div align="center">
	<textarea id="tdm_state">学生寝室</textarea>
	<br />
</div>
<h3>宿舍类型：</h3>
<div align="center">
	<input type="radio" name="tdm_typeID" value="1" checked id="tdm_typeID" />男
	<input type="radio" name="tdm_typeID" value="2" id="tdm_typeID" />女<br />
</div>
<br />
<div align="center">
	<button id="baocunDormAdd">保存</button>
</div>