<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- 引入jQuery 核心库，这里采用的是2.0 -->
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
			<!-- 引入jQuery EasyUI 核心库，这里采用的是1.3.6 -->
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
			<!-- 引入EasyUI 中文提示信息 -->
			<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
			<!-- 引入EasyUI 核心UI 文件CSS -->
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css" />
			<!-- 引入EasyUI 图标文件 -->
			<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
		

<script type="text/javascript">
	$(function() {
	$('#classid').combobox({    
    url:'/querybyallclass.action',    
    valueField:'id',    
    textField:'text'   
}); 
$("#classid").combobox("setValue", '--请选择--');
$('#apartmentid').combobox({    
    url:'/querybyalldorm.action',    
    valueField:'id',    
    textField:'text'   
});
$("#apartmentid").combobox("setValue", '--请选择--');
		teastuinfofun = {
		studentserch:function(){
		alert('搜索');
		var stuid=$('#stuid').val();
		var stuname=$('#stuname').val();
		var stusex=$('input[name=stusex]:checked').val();
		var classid=$('#classid').combobox('getValue');
		var apartmentid=$('#apartmentid').combobox('getValue');
		classid = (classid == "--请选择--" ? null : classid);
		apartmentid = (apartmentid == "--请选择--" ? null : apartmentid);
		$('#teastuinfo').datagrid(load,function(){
		stuid:stuid;
		stuname=stuname;
		
		stusex:stusex;
		classid:classid;
		apartmentid=apartmentid;
		})
		},
	
			deleteStuInfo : function(stuid) {
				$.messager.confirm('确认对话框', '您确定要删除吗？', function(r){
	if (r){
	   $.ajax({
				type:"post",
				url:"/deletebystuid.action",
				data:{stuid:stuid},
				success:function(data){
				
				$.messager.show({
	title:'我的消息',
	msg:data,
	timeout:5000,
	showType:'slide'
});
				$('#teastuinfo').datagrid('reload');
				}
				})
				
	}
});

				

			},
			updateinfo: function(){
			var getsel=$('#teastuinfo').datagrid("getSelected");
			if(getsel==null){
			$.messager.alert('我的消息','你还未选择行,请先选择！');
}else{
			$.ajax({
				type:"post",
				url:"/querybyupstuid.action",
				data:{stuid:getsel.stuid},
				success:function(data){
	
				 	$("<div id='teauppdatestuinfo'></div>").window({
					modal : true,
					href : 'updatestudentinfo.jsp',
					draggable:true,
					minimizable:false,
					maximizable:false,
					queryParams:{
					stuid:data.stuid,
					stuname:data.stuname,
					stusex:data.stusex,
					stubirthday:data.stubirthday,
					stucid:data.stucid,
					stuphone:data.stuphone,
					parphone:data.parphone,
					address:data.address,
					classid:data.classid,
					apartmentid:data.apartmentid,
					stustatus:data.stustatus,
					school:data.school,
					rouid:data.rouid,
					},
					width : 710,
					height : 600,
					onClose:function(){
					$(this).window('destroy');
					}
				})
				}
	})
			}
			}
		}
		$('#teastuinfo').datagrid({
			title : '学生基本信息',
			fitColumns : true,
			columns : [ [
				{
					field : 'stuid',
					title : '学生学号'
				}, {
					field : 'stuname',
					title : '学生姓名'
				}, {
					field : 'stusex',
				title : '学生性别'
				}, {
					field : 'stubirthday',
					title : '出生日期'
				}, {
					field : 'stucid',
					title : '身份证号'
				}, {
					field : 'stuphone',
					title : '学生电话'
				}, {
					field : 'parphone',
					title : '家长电话'
				}, {
					field : 'address',
					title : '家庭地址'
				}, {
					field : 'classid',
					title : '班级编号'
				}, {
					field : 'apartmentid',
					title : '宿舍编号'
				}, {
					field : 'stustatus',
					title : '就读状态',
					formatter:function(value,row,index){
				   			if(value==0){
				   				return "就读";
				   			}else if(value==1){
				   				return "休学";
				   			}else if(value==2){
				   				return "退学";
				   			}else if(value==3){
				   				return "毕业";
				   			}
				 	},
				}, {
					field : 'school',
					title : '毕业院校'
				}, {
					field : 'rouid',
					title : '生源编号'
				}, {
					field : 'caozuo',
					title : '操作 ',
					width : 100,
					formatter : function(value, row, index) {
					var stuid='"'+row.stuid+'"';
						return "<input type='button' value='删除 ' onclick='teastuinfo.deleteStuInfo(" + stuid+ ")'/>";
					}
				}
			] ],
			singleSelect : true,
			rownumbers : true,
			url : '/querybyclassid.action',
			pagination : true,
			pageList : [ 5, 10, 15, 20 ],
			pageSize : 5,
			pageNumber : 1,
			pagePosition : 'bottom',
			toolbar : '#teastuinfotoolbar'
		});

	})
</script>
<div id="teastuinfo"></div>
<div id="teastuinfotoolbar">
	<a class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="teastuinfofun.updateinfo()">修改</a>
	<div style="margin:5px 0px 5px 8px">
	&nbsp;学号:<input id="stuid"/>
			&nbsp;姓名:<input type="text" name="stuname"/> &nbsp;性别:<input type="radio" name="stusex" value="男" />男<input type="radio" name="stusex" value="女"/>女
			&nbsp;班级:<input id="classid"/>&nbsp;宿舍:<input id="apartmentid"/>
			<a class="easyui-linkbutton"
				iconCls="icon-search"
				onclick="teastuinfofun.studentserch()">搜索</a>&nbsp;&nbsp;
			</div>
</div>

