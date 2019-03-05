<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	$('#tt').tree({
		url : '${pageContext.request.contextPath}/authority/menuSoure/queryfatherMenu',
		onSelect : function(node) {
			var isExsits = $("#choice_card").tabs("exists", node.text);
			if (isExsits) {
				$.messager.alert("提示", "该选项卡已存在", "warning");
			} else {
				$("#choice_card").tabs('add', {
					title : node.text,
					href : node.url,
					selected : true,
					closable : true,
					fit:true,
				});
			}
		}
	});
</script>
<div>
	<ul id="tt" class="easyui-tree;">

	</ul>
</div>


