<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
	<div style="margin: 0 auto;width: 70%;height: 80%;border: 1px solid #e4e5f4;margin-top: 20px;">
		<div style="margin-top: 5%;margin: 0 auto;">
			<form>
				<table style="margin: 0 auto;">
					<tr>
						<td style="width: 90px;">学生班级：</td>
						<td><input id="talk_classs" name="classxx" value="请选择班级" style="width: 100px;"/></td>
					</tr>
					<tr>
						<td>学生姓名：</td>
						<td><input id="talk_setdentclass" class="easyui-combogrid" name="dept" style="width:260px;"/></td>
					</tr>
					<tr>
						<td>谈话类型：</td>
						<td><input name="Talk_type" maxlength="16"/></td>
					</tr>
					<tr>
						<td>谈话内容：</td>
						<td><textarea name="Talk_content" rows="11" cols="30" maxlength="100"></textarea></td>
					</tr>
					<tr><td><input id="button_talk" type="button" value="取消"/></td><td><input id="button_refer" type="button" value="提交"/></td></tr>
				</table>
			</form>
		</div>
	</div>
	
<script type="text/javascript"> 
	//获取班级信息
	$('#talk_classs').combobox({
		editable:false,
	    url:'talk/queryclass.action',    
	    valueField:'id',    
	    textField:'text',
	    onSelect:function(){
	    	var class_ids=$('#talk_classs').combobox('getValue');
	    	//但操作员选择班级后获取班级学生信息
	    	$('#talk_setdentclass').combogrid({
	    		title:'<font style="color: red;">当选择多个学生时,他们的谈话类型和内容相同</font>',    
			    delay: 450,
			    value:'请选择学生信息',    
			    mode: 'remote',
			    multiple:true,
			    editable:false,
			    url: 'talk/queryStudentInformation.action',    
			    idField: 'stuid',    
			    textField: 'stuname',    
			    columns:[[    
			        {field:'stuid',title:'学生学号',width:80},    
			        {field:'stuname',title:'学生姓名',width:80},    
		    	]],
		    	queryParams: {
					'class_id': class_ids
				}
			});
	    }  
	});  
	
	//取消谈话返回上一页
	$("#button_talk").click(function(){
		$.messager.confirm('确认','您确认取消吗？',function(r){    
    		if (r){ 
    			$('#win_2').window('close');
   				$('#win_2').window('destroy');
		 	}
		}); 
	});
	
	//提交谈话信息
	$("#button_refer").click(function(){
		$.messager.confirm('确认','您确认提交吗？',function(r){    
    		if (r){   
    			var accounts='${account}';
    			//获取班级信息 
    			var Stu_class=$('#talk_classs').combobox('getValue');
    			//获取学生信息
    			var stid="";
    			var Stu_ids=$('#talk_setdentclass').combobox('getValues');
    			if(Stu_ids!=null){
	    			for(var i=0;i<Stu_ids.length;i++){
	    				if(i==Stu_ids.length-1){
	    					stid=stid+Stu_ids[i];
	    				}else{
	    					stid=stid+Stu_ids[i]+",";
	    				}
	    			}
    			}
    			//获取谈话类型信息
    			var Talk_types=$.trim($('input[name="Talk_type"]').val());
    			//获取谈话内容信息
    			var Talk_contents=$.trim($('textarea[name="Talk_content"]').val());
    			if(accounts!=""&&Stu_ids!=""&&Stu_class!=""&&Talk_types!=""&&Talk_contents!=""&&Stu_ids!="请选择学生信息"){
    				$.ajax({
						type:'POST',
						url:'talk/saveStudentTalkInformation.action',
						data:{
							'account' : 'emp3',
							'stu_id' : stid,
							'talk_type' : Talk_types,
							'talk_content' : Talk_contents,
						},
						success:function(data){
							if(data!="1"){
								$.messager.alert('提示消息：','保存失败，请重试!'); 
							}else{
								//关闭销毁窗口
								$('#win_2').window('destroy');
							}
						}
					});
    			}else{
    				$.messager.alert('提示消息：','信息选择/填写不正确！'); 
    			}
       			/* $.ajax({
					type:'POST',
					url:'Provider/saveProvider.action',
					data:{
						'proName':$.trim($('input[name="proName"]').val()),
						'functionary':$.trim($('input[name="functionary"]').val()),
						'password':$.trim($('input[name="password"]').val()),
						'phone':$.trim($('input[name="phone"]').val()),
						'email':$.trim($('input[name="email"]').val()),
						'address':$.trim($('input[name="address"]').val())
					},
					success:function(data){
						
					}
				});     */
    		}    
		});  
	});
</script>		