<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script type="text/javascript">
	
$(function() {
		//身份证验证
		var aCity = {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江",
		31 : "上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北",
		43 : "湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏",
		61 : "陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外"
	}

		
		function isCardID(sId){ 
		var iSum = 0;

		var info = "";

		if (!/^\d{17}(\d|x)$/i.test(sId)) return info="你输入的身份证长度或格式错误";

		sId = sId.replace(/x$/i, "a");

		if (aCity[parseInt(sId.substr(0, 2))] == null) return info="你的身份证地区非法";

		sBirthday = sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2));

		var d = new Date(sBirthday.replace(/-/g, "/"));

		if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) return info="身份证上的出生日期非法";

		for (var i = 17; i >= 0; i--) iSum += (Math.pow(2, i) % 11) * parseInt(sId.charAt(17 - i), 11);

		if (iSum % 11 != 1) return info="你输入的身份证号非法";

		return true; //aCity[parseInt(sId.substr(0,2))]+","+sBirthday+","+(sId.substr(16,1)%2?"男":"女")   

	}

	$.extend($.fn.validatebox.defaults.rules, {
		idcared : {
			validator : function(value, param) {

				var flag = isCardID(value);
				$.fn.validatebox.defaults.rules.idcared.message=flag;
				return flag==true?true:false; 

			},

			message : ''
		}
	});



	$('#stuSourcecidadd').validatebox({
		required : true,
		missingMessage : "必填信息",
		validType : [ 'idcared' ],
		//invalidMessage:''
	});
		joinStudentobj={
			cancle : function() {
				$("#addStudentClassWindow").window("close");
			},
			save : function() {
				var rouid = '${param.tss_id }';
				var classid= '${param.tc_id }';
				var sts_id='${param.sts_id }';
				//alert(sts_id);
				var stuname = $("#stuSourceNameadd").val();
				var stuphone = $("#stuSourceMobileadd").val();
				var address = $("#stuSourceAreaadd").val();
				var parphone = $("#stuSourcePmobileadd").val();
				var stusex=$('input[name="sex"]:checked').val();
				var stubirthday=$("#stuSourcechushengadd").val();
				//alert(stubirthday)
				var stucid=$("#stuSourcecidadd").val();
				var school=$("#stuSourceschooladd").val();
				var apply=$("#apply").val();
				//alert(apply);
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/Class/saveJoinClass',
					data : {
						'rouid' : rouid,
						'classid' : classid,
						'sts_id' : sts_id,
						'apply' : apply,
						'stuname' : stuname,
						'stuphone' : stuphone,
						'address' : address,
						'stusex' : stusex,
						'parphone' : parphone,
						'stubirthday' : stubirthday,
						'stucid' : stucid,
						'school' : school
					},
					success : function(data) {
						$.messager.show({
							title:'消息',
							msg:data						
						});
						$("#addStudentClassWindow").window("close");
						$('#choose').combobox('clear'); 
						$("#studentSourceData").datagrid("load");
					}
				});
			},
		
		}
	});
</script>
<div align="center">
	生源姓名&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceNameadd"
		value="${param.tss_name }" readonly="readonly" /><br /> <br />
	电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceMobileadd"
		value="${param.tss_mobile }" readonly="readonly" /><br /> <br />
	生源地区或院校&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceAreaadd"
		value="${param.tss_area_school }" readonly="readonly" /><br /> <br />
	qq号码&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceQQadd"
		value="${param.tss_qq }" readonly="readonly" /><br /> <br />
	父母电话&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourcePmobileadd"
		value="${param.tss_parent_mobile }" readonly="readonly" /><br /> <br />
	性别&nbsp;&nbsp;:&nbsp;&nbsp;<input type="radio" id="stuSourcesexadd"
		name="sex" value="男" checked="checked"/>男 <input type="radio" id="stuSourcesexadd"
		name="sex" value="女" />女<br /> <br /> 出生日期&nbsp;&nbsp;:&nbsp;&nbsp;
	<input id="stuSourcechushengadd" type="date" /> <br /> <br />
	身份证&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourcecidadd" value="" /><br />
	<br /> 毕业院校&nbsp;&nbsp;:&nbsp;&nbsp;<input id="stuSourceschooladd"
		value="" /><br /> <br />
		<select id="apply" class="easyui-combobox" style="width:200px;">   
	    <option>报名</option>   
	    <option>预座</option>   
		</select> 
		 <a class="easyui-linkbutton"
		iconCls="icon-save" onclick="joinStudentobj.save();">确认入班</a> <a
		class="easyui-linkbutton" iconCls="icon-save"
		onclick="joinStudentobj.cancle();">取消入班</a>
</div>
