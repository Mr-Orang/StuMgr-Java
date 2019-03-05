<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
		<script type="text/javascript">
			$(function(){
				
				$.ajax({
					type:"post",
					url:'/queryMenu',
					success:function(data){
						$.each(data,function(index,item){
							if(index==0){
						$("#left_menus").accordion('add',{
							title:item.text,
							iconCls:item.menuIconcls,
							content: '<div style="padding:10px"><ul name="'+item.text+'"></ul></div>',
							selected:true
						});
						
					}else{
						$("#left_menus").accordion('add',{
							iconCls:item.menuIconcls,
							title:item.text,
							content : '<div style="padding:10px"><ul name="'+item.text+'"></ul></div>',
							selected:false
						});
					}
									
				});
			},
		});
		$("#left_menus").accordion({
			onSelect:function(title,index){
				$.ajax({
					type:'post',
					url:'/queryMenuByName?text='+title,
					success:function(data){
						$("ul[name='"+title+"']").tree({
							data:data,
							onClick:function(node){
								var isExsits=$("#choice_card").tabs("exists",node.text);
								if(isExsits){
									$.messager.alert("提示","该选项卡已存在","warning");
								}else{
									$("#choice_card").tabs('add',{
										title:node.text,
										href:node.url,
										iconCls:node.menuIconcls,
										selected:true,
										closable:true,
										
									});
								}
								
							}
					});
				}
					
		
				})
			}
		});
		
	})

</script>
<div class="easyui-accordion" width="300px" id="left_menus">
</div>        