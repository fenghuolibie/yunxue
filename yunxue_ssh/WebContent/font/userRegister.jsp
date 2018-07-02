<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>"/>
<meta charset="utf-8">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<title>学生注册</title>
<link href="css/student_login.css" rel="stylesheet" type="text/css">
<link href="css/student_register.css" rel="stylesheet" type="text/css">
<link href="css/_footer.css" rel="stylesheet" type="text/css">
<script src="js/jquery v3.2.1.min.js"></script>
<script src="js/stu-register.js"></script>
<style type="text/css">
	.main{
		background-color:beige;
	}
</style>
<script type="text/javascript">
$(function (){
	 $("#checkCode1").click(function(){
		 var timestamp = new Date().getTime();
	     $(this).attr("src",$(this).attr("src")+"?"+timestamp);
	 });
	 $("#checkCode2").click(function(){
		 var timestamp = new Date().getTime();
	     $(this).attr("src",$(this).attr("src")+"?"+timestamp);
	 });
 })
</script>
<c:if test="${param.regMsg == '8'}">
    <script type="text/javascript">
        $(function(){
        	alert("验证码错误")
        })
    </script>
</c:if>
</head>

<body class="main">
    <header>
    	<img src="IMG/index/logo1.png" height="70">
   	    <span class="word1">欢迎注册</span>
   	    <span class="word1" style="display:none"><a href="font/user_login.jsp">直接登录</a></span>
   	    <h3>有了云学网，学习就是爽</h3>
    </header>
    <div class="register">
    	<div class="register_tab" id="stu">
    		<div class="register_tab_0">
    			<span class="register_0">家长/学生</span>
    			<span class="register_f" id="change">我想做家教</span>
    			<form action="kl/stuRegister.action" method="post">
    			    <input id="type" type="hidden" name="type" value="S">
    				<div class="register_tab_0_1">
    				    <input class="register_in" type="text" id="phone" name="userPhone" placeholder="请输入电话号码" >
    			    </div>
                    <span class="wrong" id="cuo1">手机号码格式错误</span>
    			    <div class="register_tab_0_11">
    				    <input class="register_in" type="password" id="mima" name="userPwd" placeholder="请设置您的密码">
    			    </div>
                    <span class="wrong" id="cuo2">密码只能由6-16位的数字字母组成</span>
    			    <div class="register_tab_0_11">
    				    <input class="register_in" type="password" id="remima"  name="password_0" placeholder="请确认您的密码">
    			    </div>
                    <span class="wrong" id="cuo3">两次密码不一致</span>
                    
                    <div class="yanz">    			    
                    <div class="register_tab_0_2">
    			       <input class="register_in_0" type="text" id="code"  name="checkCode" placeholder="请输入验证码">   
					</div>
                     <img alt="验证码更换" src="kl/c.action?001" id="checkCode1">
                    </div>
                    <span class="wrong" id="cuo4">验证码输入错误</span>
    		        <input class="register_in_1" type="submit" id="check" value="注              册">
    			</form>
    			<p class="register_h">注册代表您已经同意<a href="#">《云学网服务条款》</a></p>
    		</div>           
    	</div>
        
        
        <div class="register_tab" style="display:none;" id="tea">
    		<div class="register_tab_0">
    			<span class="register_0">老师</span>
                &nbsp;&nbsp;<span class="register_1">注册在平台授课</span><br>
                <span class="register_ff" id="change2" >我是学生</span>
    			<form action="kl/teaRegister.action" method="post">
    			    <input type="hidden" name="type" value="T" id="type1">
    				<div class="register_tab_0_3">
    				    <input class="register_in2" type="text" id="phone2"  name="userPhone" placeholder="请输入电话号码">
    			    </div>
                    <span class="wrong" id="cuo12">手机号格式不对</span>
    			    <div class="register_tab_0_33">
    				    <input class="register_in2" type="password" id="mima2"  name="userPwd" placeholder="请设置您的密码">
    			    </div>
                    <span class="wrong" id="cuo22">密码只能由6-16位的数字字母组成</span>
    			    <div class="register_tab_0_33">
    				    <input class="register_in2" type="password" id="remima2"  name="password_0" placeholder="请确认您的密码">
    			    </div>
                    <span class="wrong" id="cuo32">两次密码不一样</span>
                    
                    <div class="yanz">
    			    <div class="register_tab_0_4">
    			    <input class="register_in_00" type="text" id="code2"  name="checkCode" placeholder="请输入验证码">   
					</div>
                     <img alt="验证码更换" src="kl/c.action?001" id="checkCode2">
                    </div>
                    <span class="wrong" id="cuo42">验证码输入错误</span>
    		        <input class="register_in_1" type="submit" id="check2" value="入              驻">
    			</form>
    			<p class="register_h">注册代表您已经同意<a href="#">《云学网服务条款》</a></p>
    		</div>           
    	</div>
        
    </div>
    
    <div class="footer">
    	<div class="footer-box1">
    		<a href="#" target="_blank">关于云学网</a>
    		<a href="#" target="_blank">联系我们</a>
    		<a href="#" target="_blank">加入我们</a>
    		<a href="#" target="_blank">网站条款</a>
    		<a href="#" target="_blank">帮助我们</a>
    		<a href="#" target="_blank">服务支持</a>
    		<a href="#" target="_blank">官方微信</a>
    	</div>
    	<div class="footer-box2">
    		<p>高新技术企业证书：GR201611005838 办学许可证：111010873931661 电信与信息服务业务经营许可证：京公网安备11010802016334号 yxw.com</p>
    	</div>
    	<div class="footer-box3">
    	    <img src="IMG/register/link1.jpg" height="33">
    	    <img src="IMG/register/aqyz.png" height="33">
    	    <img src="IMG/register/link2.jpg" height="33">
		</div>
    </div>
    
</body>
</html>
