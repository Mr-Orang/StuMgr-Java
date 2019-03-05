<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html >
<head>
 <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
 <link rel="shortcut icon" href="#" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>学生端登录</title>
    <style>
        * { margin: 0; padding: 0; }
        html { height: 100%; }
        body { height: 100%; background: #fff url(../img/login-bg.jpg) 50% 50% no-repeat; background-size: cover;}
        .dowebok { position: absolute; left: 50%; top: 50%; width: 430px; height: 550px; margin: -300px 0 0 -215px; border: 1px solid #fff; border-radius: 20px; overflow: hidden;}
        .logo { width: 104px; height: 104px; margin: 50px auto 80px; background: url(../img/login.png) 0 0 no-repeat; }
        .form-item { position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
        .form-item input { width: 288px; height: 48px; padding-left: 70px; border: 1px solid #fff; border-radius: 25px; font-size: 18px; color: #fff; background-color: transparent; outline: none;}
        .form-item button { width: 360px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fff; }
        #adm_id { background: url(../img/user.png) 20px 14px no-repeat; }
        #stu_cid { background: url(../img/password.png) 23px 11px no-repeat; }
        .reg-bar { width: 360px; margin: 20px auto 0; font-size: 14px; overflow: hidden;}
        .reg-bar a { color: #fff; text-decoration: none; }
        .reg-bar a:hover { text-decoration: underline; }
        .reg-bar .reg { float: left; }
        .reg-bar .forget { float: right; }
        .dowebok ::-webkit-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok ::-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        .dowebok :-ms-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}

        @media screen and (max-width: 500px) {
            * { box-sizing: border-box; }
            .dowebok { position: static; width: auto; height: auto; margin: 0 30px; border: 0; border-radius: 0; }
            .logo { margin: 50px auto; }
            .form-item { width: auto; }
            .form-item input, .form-item button, .reg-bar { width: 100%; }
        }
    </style>
</head>
<body>
    <div class="dowebok" align="center">
        <div class="logo"></div>
        <div class="form-item">
            <input id="adm_id" type="text" autocomplete="off" placeholder="准考证号">
        </div>
        <div class="form-item">
            <input id="stu_cid" type="text" autocomplete="off" placeholder="身份证号">
        </div>
        <div class="form-item"><button id="st_submit" style="width:288px">登 录</button></div>
        <div class="reg-bar">
           版权所有 ©2019 湖南硅谷信息技术有限公司 保留所有权利 湘ICP备15101742号
        </div>
    </div>
    <script src="../js/jquery.min1.js"></script>
    <script>
       $("#st_submit").click(function(){
       if($('#adm_id').val()==''||$('#stu_cid').val()==''){
       alert('请输入准考证号和身份证号')
       }else{
		$.ajax({
				url : "${pageContext.request.contextPath }/admission/admission_login",
				data : {
					'adm_id' : $('#adm_id').val(),
					'stu_cid' :$('#stu_cid').val()
				},
				success : function(data) {
					if(data==''){
					alert('当前准考证号考试时间未到！');
					}else{
					   window.location.href="/Examination/page/Ex_student.jsp";
					}
					
				}
			});
			}
})
    </script>
</body>
</html>
