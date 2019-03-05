<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		$('#ac').accordion({
			fit : true,
		});
		<!-- 异步请求菜单 -->
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : '${pageContext.request.contextPath}/menuController/loadMenuDataInfo',
			success : function(data) {
				//加载父类节点
				$.each(data, function(i, n) {
					if (i == 0) {
						$('#ac').accordion('add', {
							title : n.text,
							iconCls : n.iconCls,
							content : '<ul name=' + n.text + '></ul>',
							selected : true
						});
					} else {
						$('#ac').accordion('add', {
							title : n.text,
							iconCls : n.iconCls,
							content : '<ul name=' + n.text + '></ul>',
							selected : false
						});
					}
				});
			}
		});
		//请求子菜单
		$('#ac').accordion({
			onSelect : function(title, index) {
				$.ajax({
					type : 'POST',
					url : '${pageContext.request.contextPath}/menuController/loadMenuSonData',
					data : 'text=' + title,
					success : function(msg) {
						$('ul[name=' + title + ']').tree({
							data : msg,
							onClick : function(node) {
								if ($('#tabs').tabs('exists', node.text) == false) {
									$('#tabs').tabs('add', {
										href : node.menuUrl,
										title : node.text,
										iconCls : node.iconCls,
										closable : true
									})
								} else {
									//让面板选中
									$('#tabs').tabs('select', node.text);
									//获取该面板
									var selectTabs = $('#tabs').tabs('getTab', node.text);
									// //更新面板
									$('#tabs').tabs('update', {
										//要更新的选项卡面板
										tab : selectTabs,
										options : {
											title : node.text,
											href : node.menuUrl,
											iconCls : node.iconCls,
											closable : true
										}
									});
								}
							}
						});
					}
				});
			}
		});
	});
</script>
<div id="ac"></div>