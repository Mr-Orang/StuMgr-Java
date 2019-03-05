<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<script>
	$(function() {
		$.ajax({
			type : 'post',
			url : 'teachermenu/queryMenuByAccount',
			success : function(data) {
				$.each(data, function(index, item) {
					if (index == 0) {
						$("#info_left_menu").accordion('add', {
							title : item.menu_name,
							content : '<div style="padding:10px"><ul name="' + item.menu_name + '"></ul></div>',
							selected : true
						});
					} else {
						$("#info_left_menu").accordion('add', {
							title : item.menu_name,
							content : '<div style="padding:10px"><ul name="' + item.menu_name + '"></ul></div>',
							selected : false
						});
					}
				})
			}
		});

		$("#info_left_menu").accordion({
			onSelect : function(title, index) {
				$.ajax({
					type : 'post',
					url : 'teachermenu/queryMenuByParentName?text=' + title,
					success : function(data) {

						$("ul[name='" + title + "']").tree({
							data : data,
							onClick : function(node) {
								var isExsits = $("#info_choice_card").tabs("exists", node.text);
								if (isExsits) {
									//选中选项卡
									$("#info_choice_card").tabs('select', node.text);
									//得到选中的选项卡
									var getSelectTab=$("#info_choice_card").tabs('getTab', node.text);
									//修改选项卡内容
									$("#info_choice_card").tabs('update',{
										tab:getSelectTab,
										 options: {
                                            title: node.text,
                                            href: node.menu_url,
                                            closable: true
                                        }
									});
								} else {
									$("#info_choice_card").tabs('add', {
										title : node.text,
										href : node.menu_url,
										selected : true,
										closable : true,
									});
								}

							}
						});
					}
				})
			}
		});
	});
</script>


<div class="easyui-accordion" width="300px" id="info_left_menu"></div>
