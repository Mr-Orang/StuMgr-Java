<!-- d3库画图 -->
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<title>硅谷云科技仓库容量情况图</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/materials/d3/demo.css">
<script src="${pageContext.request.contextPath}/materials/d3/d3.v4.min.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/materials/d3/dagre-d3.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/materials/d3/tipsy.css">
<!-- 引入jquery依赖 -->
<script src="${pageContext.request.contextPath}/materials/d3/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/materials/d3/tipsy.js"></script>

<h1>硅谷云科技仓库容量结构图</h1>

<style id="css">
text {
	font-weight: 300;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serf;
	font-size: 14px;
}

.node rect {
	stroke: #333;
	fill: #fff;
}

.edgePath path {
	stroke: #333;
	fill: #333;
	stroke-width: 1.5px;
}

.node text {
	pointer-events: none;
}

/* 样式化工具提示的标题 */
.tipsy .name {
	font-size: 1.5em;
	font-weight: bold;
	color: #60b1fc;
	margin: 0;
}

/* 样式化工具提示的主体*/
.tipsy .description {
	font-size: 1.2em;
}
</style>

<svg width=960 height=600></svg>
<!-- 
<section>
	<p>
		The TCP state diagram (<a
			href="http://www.rfc-editor.org/rfc/rfc793.txt">source: RFC 793</a>)
		with hover support. Uses <a href="http://bl.ocks.org/ilyabo/1373263">tipsy
			JS and CSS</a> for the tooltip.
</section>
 -->

<script id="js">
	// 创建一个新的有向图
	var g = new dagreD3.graphlib.Graph().setGraph({});

	// RFC 793的状态和转换
	var states = {
		CLOSED : {
			description : "represents no connection state at all.",
			style : "fill: #f77"
		},

		LISTEN : {
			description : "represents waiting for a connection request from any " +
				"remote TCP and port."
		},

		"SYN SENT" : {
			description : "represents waiting for a matching connection " +
				"request after having sent a connection request."
		},

		"SYN RCVD" : {
			description : "represents waiting for a confirming connection " +
				"request acknowledgment after having both received and sent a " +
				"connection request."
		},


		ESTAB : {
			description : "represents an open connection, data received " +
				"can be delivered to the user.  The normal state for the data " +
				"transfer phase of the connection.",
			style : "fill: #7f7"
		},

		"FINWAIT-1" : {
			description : "represents waiting for a connection termination " +
				"request from the remote TCP, or an acknowledgment of the " +
				"connection termination request previously sent."
		},

		"FINWAIT-2" : {
			description : "represents waiting for a connection termination " +
				"request from the remote TCP."
		},


		"CLOSE WAIT" : {
			description : "represents waiting for a connection termination " +
				"request from the local user."
		},

		CLOSING : {
			description : "represents waiting for a connection termination " +
				"request acknowledgment from the remote TCP."
		},

		"LAST-ACK" : {
			description : "represents waiting for an acknowledgment of the " +
				"connection termination request previously sent to the remote " +
				"TCP (which includes an acknowledgment of its connection " +
				"termination request)."
		},

		"TIME WAIT" : {
			description : "represents waiting for enough time to pass to be " +
				"sure the remote TCP received the acknowledgment of its " +
				"connection termination request."
		}
	};

	// 向图形添加状态、设置标签和样式
	Object.keys(states).forEach(function(state) {
		var value = states[state];
		value.label = state;
		value.rx = value.ry = 5;
		g.setNode(state, value);
	});

	// Set up the edges
	g.setEdge("CLOSED", "LISTEN", {
		label : "open"
	});
	g.setEdge("LISTEN", "SYN RCVD", {
		label : "rcv SYN"
	});
	g.setEdge("LISTEN", "SYN SENT", {
		label : "send"
	});
	g.setEdge("LISTEN", "CLOSED", {
		label : "close"
	});
	g.setEdge("SYN RCVD", "FINWAIT-1", {
		label : "close"
	});
	g.setEdge("SYN RCVD", "ESTAB", {
		label : "rcv ACK of SYN"
	});
	g.setEdge("SYN SENT", "SYN RCVD", {
		label : "rcv SYN"
	});
	g.setEdge("SYN SENT", "ESTAB", {
		label : "rcv SYN, ACK"
	});
	g.setEdge("SYN SENT", "CLOSED", {
		label : "close"
	});
	g.setEdge("ESTAB", "FINWAIT-1", {
		label : "close"
	});
	g.setEdge("ESTAB", "CLOSE WAIT", {
		label : "rcv FIN"
	});
	g.setEdge("FINWAIT-1", "FINWAIT-2", {
		label : "rcv ACK of FIN"
	});
	g.setEdge("FINWAIT-1", "CLOSING", {
		label : "rcv FIN"
	});
	g.setEdge("CLOSE WAIT", "LAST-ACK", {
		label : "close"
	});
	g.setEdge("FINWAIT-2", "TIME WAIT", {
		label : "rcv FIN"
	});
	g.setEdge("CLOSING", "TIME WAIT", {
		label : "rcv ACK of FIN"
	});
	g.setEdge("LAST-ACK", "CLOSED", {
		label : "rcv ACK of FIN"
	});
	g.setEdge("TIME WAIT", "CLOSED", {
		label : "timeout=2MSL"
	});

	// 创建渲染器
	var render = new dagreD3.render();

	// 设置一个SVG组，以便我们可以转换最终的图形。
	var svg = d3.select("svg"),
		inner = svg.append("g");

	// 设置缩放支持
	var zoom = d3.zoom()
		.on("zoom", function() {
			inner.attr("transform", d3.event.transform);
		});
	svg.call(zoom);

	// 用于为给定节点设计工具提示样式的简单函数
	var styleTooltip = function(name, description) {
		return "<p class='name'>" + name + "</p><p class='description'>" + description + "</p>";
	};

	// 渲染器运行。这就是最终的图形。
	render(inner, g);

	inner.selectAll("g.node")
		.attr("title", function(v) {
			return styleTooltip(v, g.node(v).description)
		})
		.each(function(v) {
			$(this).tipsy({
				gravity : "w",
				opacity : 1,
				html : true
			});
		});

	// 中心图
	var initialScale = 0.75;
	svg.call(zoom.transform, d3.zoomIdentity.translate((svg.attr("width") - g.graph().width * initialScale) / 2, 20).scale(initialScale));
	svg.attr('height', g.graph().height * initialScale + 40);
</script>

<script src="${pageContext.request.contextPath}/materials/d3/demo.js"></script>
