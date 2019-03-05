<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  
<link rel="stylesheet" href="../layui/css/bootstrap.css">
<style type="text/css">
	.testCon{padding: 5px 15px;}
	h4.tesTitle{color: #00B895;}
	.test-form-box{max-height: 660px;overflow: auto;}
	.assignment{margin: 30px 0 60px;text-align: center;}
	.assignment .btn{background: #00B895;width: 120px;font-size: 18px;border-color: #00B895;}
	#testForm .testCon:nth-child(odd){background: #eee;}
	label{font-weight: normal;}
	.jxz-title{text-align: justify;}
	.topic-answer{display: none;}
</style>

</head>
<body>

<div class="container">
	<div class="row clearfix" id="testArea">

	</div>
</div>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/test.js"></script>
<script type="text/javascript">
    $(function(){
        //题型    1单选2多选3判断4填空5问答8论述题6完型填空7阅读理解
        //json    格式参照data/test.json
        //交卷    点击交卷后可查看对错
        var test_id = 'get a test id';
        test(test_id);
    });
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Opera、傲游、搜狗、世界之窗. 不支持Safari、IE8及以下浏览器。</p>

</div>
</body>
</html>