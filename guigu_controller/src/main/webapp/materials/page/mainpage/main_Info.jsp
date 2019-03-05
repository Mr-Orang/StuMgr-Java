<!-- 首页指南 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
	$(function() {
		$('#notificationAnnouncement').panel({
			title : '通知公告',
			iconCls : 'icon-main_notificationannouncement',
			width : 370,
			height : 250,
			left : 20,
			top : 60,
			content : "<table><tr><td>1</td><td><a href='#'>中秋节每人发放价值1000元的京东卡一张</a></td><td>2018-11-26 12:09</td></tr></table>",
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('new')
				}
			} ]
		});
		$('#notificationAnnouncement').panel('panel').css('position', 'absolute');
		$('#MyTodo').panel({
			title : '我的待办',
			iconCls : 'icon-main_wait_toobedone',
			width : 370,
			height : 250,
			left : 400,
			top : 60,
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('new')
				}
			} ]
		});
		$('#MyTodo').panel('panel').css('position', 'absolute');
		$('#TodayWeather').panel({
			iconCls : 'icon-main_weather',
			title : '今日天气',
			width : 370,
			height : 250,
			left : 780,
			top : 60,
			content : '<iframe name="weather_inc" src="http://i.tianqi.com/index.php?c=code&id=55" style="border:solid 1px #7ec8ea" width="349" height="294" frameborder="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>',
			tools : [ {
				iconCls : 'icon-reload',
				handler : function() {}
			} ]
		});
		$('#TodayWeather').panel('panel').css('position', 'absolute');
		//---------------------------------------------------------------------------------------------------------------------
		$('#myApplication').panel({
			title : '我的申请',
			iconCls : 'icon-main_applyfor',
			width : 370,
			height : 250,
			left : 20,
			top : 320,
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('new');
				}
			} ]
		});
		$('#myApplication').panel('panel').css('position', 'absolute');
		$('#myDocuments').panel({
			title : '我的文档',
			iconCls : 'icon-main_document',
			width : 370,
			height : 250,
			left : 400,
			top : 320,
			tools : [ {
				iconCls : 'icon-add',
				handler : function() {
					alert('new');
				}
			} ]
		});
		$('#myDocuments').panel('panel').css('position', 'absolute');
		$('#miniNews').panel({
			iconCls : 'icon-main_news',
			title : '迷你新闻',
			width : 370,
			height : 250,
			left : 780,
			top : 320,
			//content: 'https://www.apiopen.top/journalismApi',
			href : '${pageContext.request.contextPath}/materials/page/mainpage/newsInterface.jsp',
			tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					// 刷新 -> 先销毁，后添加
					/**
					 * 销毁：把所有选项卡都关闭，然后再添加
					 */
					var new_tabs = $('#new_tabs').tabs('tabs');
					for (var i = 0; i < new_tabs.length; i++) {
						//关闭面板
						$('#new_tabs').tabs('close', new_tabs[i].panel('options').title);
						i--;
					}
					refresh();
				}
			} ],
		});
		$('#miniNews').panel('panel').css('position', 'absolute');
	});
</script>
<div id="notificationAnnouncement"></div>
<div id="MyTodo"></div>
<div id="TodayWeather"></div>
<!-- 第二版 -->
<div id="myApplication"></div>
<div id="myDocuments"></div>
<div id="miniNews"></div>