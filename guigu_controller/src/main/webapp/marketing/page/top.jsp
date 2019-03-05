<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <div style="float:left;">
  <div class="font-brown"><h1>欢迎${account.account}来到市场营销系统</h1></div>
	<div style="position: absolute;right:354px;top:42px;">
		<iframe src="http://tianqi.5ikfc.com:90/plugin-code/?style=3&dy=5&cl=0000cc" allowTransparency="true" frameborder="0" scrolling="no" width="350" height="30" id="weather_frame"></iframe>
	</div>
  </div>
	
			<div style="position: absolute;right:114px;top:42px;">
				<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">切换主题</a>
			</div>
			<div id="layout_north_pfMenu" style="display:none;">
    			<div onclick="changeTheme('default');">默认</div>
    			<div onclick="changeTheme('black');">black</div>
    			<div onclick="changeTheme('bootstrap');">bootstrap</div>
    			<div onclick="changeTheme('metro');">metro</div>
    			<div onclick="changeTheme('gray');">gray</div>
    		</div>