<!-- 物资类型管理 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script type="text/javascript">
    <%--var menu = {--%>
    <%--setting: {--%>
    <%--isSimpleData: true,--%>
    <%--treeNodeKey: "id",--%>
    <%--treeNodeParentKey: "pid",--%>
    <%--showLine: true,--%>
    <%--root: {--%>
    <%--isRoot: true,--%>
    <%--nodes: []--%>
    <%--}--%>
    <%--},--%>
    <%--loadMenuTree: function () {--%>
    <%--$.post("${pageContext.request.contextPath }/materialType/queryTypeData.action", null, function (data) {--%>
    <%--//data返回json数据，封装List<ElecPopedom>--%>
    <%--$("#treeDemo").zTree(menu.setting, data);--%>
    <%--})--%>
    <%--}--%>
    <%--};--%>
    <%--$().ready(function () {--%>
    <%--menu.loadMenuTree();--%>
    <%--});--%>
    //以上是对z-tree的尝试
    //显示文本
    $(function () {
        var statusType = [];
        $('#createNew').linkbutton({
            iconCls: 'icon-add',
            onClick: function () {
                //显示数据框
                $('#promptInfo').css("display", "block");
            }
        });
        $('#submit_Ok').linkbutton({
            onClick: function () {
                // 获取用户输入的值
                var nodeVal = $('#newNode').val();
                if (nodeVal.length == 0) {
                    $.messager.alert('提示', '您还未输入节点名!', 'info');
                    return;
                }
                $('#treeDemo').etree('create', nodeVal);
                //清空
                $('#newNode').val("");
            }
        });
        //关闭数据框
        $('#close_dataWin').linkbutton({
            onClick: function () {
                //隐藏数据框
                $('#promptInfo').css("display", "none");
                //清空数据
                $('#newNode').val("");
            }
        });
        //禁用节点
        $('#disableNode').linkbutton({
            iconCls: 'icon-remove',
            onClick: function () {
                //获取选中的节点
                var selected = $('#treeDemo').etree('getSelected');
                if (selected == null) {
                    $.messager.alert('提示', '您还未选中需要禁用的类型！', 'info');
                    return;
                }
                for (var i = 0; i < statusType.length; i++) {
                    if (selected.id == statusType[i].id) {
                        if (statusType[i].status == 1) {
                            $.messager.alert('提示', '该节点已经被禁用了！', 'info');
                            return;
                        }
                    }
                }
                $.messager.confirm('确认框', '您确认要禁用该类型以及该类型的子类型？', function (r) {
                    if (r) {
                        $.ajax({
                            type: 'POST',
                            url: '${pageContext.request.contextPath}/materialType/modifyStatus',
                            data: {
                                'id': selected.id,
                            },
                            success: function (msg) {
                                if (msg == "yes") {
                                    statusType = [];
                                    $('#treeDemo').etree('reload');
                                }
                            }
                        });
                    }
                });
            }
        });
        //启用节点
        $('#startUseNode').linkbutton({
            iconCls: 'icon-ok',
            onClick: function () {
                //获取选中的节点
                var selected = $('#treeDemo').etree('getSelected');
                if (selected == null) {
                    $.messager.alert('提示', '您还未选中需要启用的类型！', 'info');
                    return;
                }
                for (var i = 0; i < statusType.length; i++) {
                    if (selected.id == statusType[i].id) {
                        if (statusType[i].status == 0) {
                            $.messager.alert('提示', '该类型已经被启用了！', 'info');
                            return;
                        }
                    }
                }
                $.messager.confirm('确认框', '您确认要启用该类型以及该类型的子类型？', function (r) {
                    if (r) {
                        $.ajax({
                            type: 'POST',
                            url: '${pageContext.request.contextPath}/materialType/startUsing',
                            data: {
                                'id': selected.id,
                            },
                            success: function (msg) {
                                if (msg == "yes") {
                                    //将数组清空
                                    statusType = [];
                                    $('#treeDemo').etree('reload');
                                }
                            }
                        });
                    }
                });
            }
        });
        $('#treeDemo').etree({
            url: '${pageContext.request.contextPath}/materialType/queryTypeData',
            loadFilter: function (rows) {
                for (var i = 0; i < rows.length; i++) {
                    statusType.push(rows[i]);
                }
                return convert(rows);
            },
            //渲染文本节点
            formatter: function (node) {
                for (var i = 0; i < statusType.length; i++) {
                    if (node.id == statusType[i].id) {
                        if (statusType[i].status == 1) {
                            return '<span style="color:red">' + node.text + '</span>';
                        }
                    }
                }
                return node.text;
            },
            //推拽之前的事件
            onBeforeDrag: function (node) {
                for (var i = 0; i < statusType.length; i++) {
                    if (node.id == statusType[i].id) {
                        if (statusType[i].status == 1) {
                            $.messager.alert('提示', '该类型已被禁用，不能进行拖拽操作！', 'info');
                            return false;
                        }
                    } else {
                        var nodes = node;
                        while (true) {
                            nodes = $('#treeDemo').etree('getParent', nodes.target);
                            if (nodes == null) {
                                break;
                            }
                            if (nodes.id == statusType[i].id) {
                                if (statusType[i].status == 1) {
                                    $.messager.alert('提示', '该类型的父类型或祖类型已被禁用，禁止进行修改操作！', 'info');
                                    return false;
                                }
                            }
                        }
                    }
                }
            },
            //拖拽时的操作
            dndUrl: '${pageContext.request.contextPath}/materialType/dropProcessingFunctions',
            //更新节点时的操作
            updateUrl: '${pageContext.request.contextPath}/materialType/updateHandler',
            //添加节点
            createUrl: '${pageContext.request.contextPath}/materialType/addNode',
            method: 'get',
            animate: true,
            dnd: true,
            lines: true,
        });

        //父子类型
        function convert(rows) {
            function exists(rows, parentId) {
                for (var i = 0; i < rows.length; i++) {
                    if (rows[i].id == parentId) return true;
                }
                return false;
            }

            var nodes = [];
            // get the top level nodes
            for (var i = 0; i < rows.length; i++) {
                var row = rows[i];
                if (!exists(rows, row.parentId)) {
                    nodes.push({
                        id: row.id,
                        text: row.text
                    });
                }
            }
            var toDo = [];
            for (var i = 0; i < nodes.length; i++) {
                toDo.push(nodes[i]);
            }
            while (toDo.length) {
                var node = toDo.shift();	// the parent node
                // get the children nodes
                for (var i = 0; i < rows.length; i++) {
                    var row = rows[i];
                    if (row.parentId == node.id) {
                        var child = {id: row.id, text: row.text};
                        if (node.children) {
                            node.children.push(child);
                        } else {
                            node.children = [child];
                        }
                        toDo.push(child);
                    }
                }
            }
            return nodes;
        }
    });
</script>
<div id="material_mainDivs">
	<h2>物资类型结构</h2>
	<a id="createNew">创建新类型</a>&nbsp;&nbsp;&nbsp;<a id="disableNode">禁用该类型</a>&nbsp;&nbsp;&nbsp;<a
		id="startUseNode">启用该类型</a><br />
	<div id="promptInfo" style="display: none">
		<h2>步骤：</h2>
		<p>1.请输入新类型名称</p>
		<p>2.请在下方选择该新类型的父类型(未选择父类型默认为顶层父类型)</p>
		请输入新类型名称：&nbsp;<input type="text" id="newNode" />&nbsp;&nbsp;&nbsp;<a
			id="submit_Ok">确认</a>&nbsp;&nbsp;<a id="close_dataWin">关闭数据框</a>
	</div>
	<div style="padding-top: 50px;">
		<ul id="treeDemo"></ul>
	</div>
</div>
