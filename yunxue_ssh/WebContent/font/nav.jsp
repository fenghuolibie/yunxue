<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<link type="text/css"  href="css/header-bottom.css" rel="stylesheet"/>
<script src="js/jquery v3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nav</title>

</head>
<body>
<div class="header">
 <div class="header1">
  <span class="word">客服电话：4000-888-888</span>
  <span class="word word2">办学许可证</span>
  <div class="search">
  <form method="get" action="kl/teaQuerry.action">
   <input type="text" class="search1" name="name" value="${name}" placeholder=" 请输入搜索教师"/>
   <input type="submit" class="icon" value="" />
  </form>
  </div>
  <c:if test="${empty teaLoginer && empty stuLoginer}">
  <ul class="link1">
   <li style="width:60px;"><a href="#">学生帮助</a></li>
   <li id="register" style="width:40px;"><a href="font/userRegister.jsp">注册</a></li>
   <li id="login" style="width:40px;"><a href="font/stuLogin.jsp">登录</a></li>
  </ul>
  </c:if>
  <c:if test="${not empty teaLoginer}">
  <ul class="link2">
   <li style="width:60px;"><a href="#">教师帮助</a></li>
   <li class="va"><a href="kl/teaIdentity.action">${teaLoginer.teacherPhone}教师</a></li>
   <li class="exit"><a href="kl/exit.action">退出</a></li>
  </ul>
  </c:if>
   <c:if test="${not empty stuLoginer}">
  <ul class="link2">
   <li style="width:60px;"><a href="#">学生帮助</a></li>
   <li class="va"><a href="kl/stuMsg.action">${stuLoginer.stuPhone}同学</a></li>
   <li class="exit"><a href="kl/exit.action">退出</a></li>
  </ul>
  </c:if>
 </div>
</div>
<div class="nav">
 <div class="logo">
  <a href="font/index.jsp"><img src="IMG/index/logo1.png" width="200" height="75" /></a>
 </div>
 <div class="nav1">
  <ul>
   <li class="cur"><a href="font/index.jsp">首页</a></li>
   <li><a href="#">1对1授课</a></li>
   <li><a href="kl/teaQuerry.action">师资力量</a></li>
   <li><a href="kl/buyClassFirst.action">购买课时</a></li>
  </ul>
 </div>
 <div class="nav-icon">
  <img src="IMG/index/icons-nav.png" width="190" height="34" />
 </div>
</div>
</body>
</html>