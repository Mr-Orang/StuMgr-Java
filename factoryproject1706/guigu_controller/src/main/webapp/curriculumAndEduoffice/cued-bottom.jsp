<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="layui/css/layui.css">

<body bgcolor="">
 <div style="text-align:center ;font-size: 13px">
        欢迎你：<span style="color:darkred;font-size:14px;">
        申博</span>
        管理员 /<span id="time_bottom"></span>

 </div>
<script>

        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate


       document.getElementById('time_bottom').textContent=currentdate

</script>
</body>