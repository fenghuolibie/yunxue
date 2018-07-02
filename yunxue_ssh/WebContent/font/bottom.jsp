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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bottom</title>
</head>
<body>
<div class="help">
 <div class="help2">
  <div class="logo2">
   <a href="index.html"><img src="IMG/index/logo1.png" width="180" height="65" /></a>
  </div>
  <i class="spacer"></i>
  <div class="f1 f">
   <p class="f2 ff"><strong>帮助中心</strong></p>
   <dd class="f0 f3"><a href="#">学生帮助</a></dd>
   <dd class="f0 f3"><a href="#">家教入驻</a></dd>
   <dd class="f0 f3"><a href="#">注册登录</a></dd>
   <dd class="f0 f3"><a href="#">平台保障</a></dd>
   <dd class="f0 f3"><a href="#">网站地图</a></dd>
   <dd class="f0 f3"><a href="#">网站条款</a></dd>
   <dd class="f0 f3"><a href="#">友情链接</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1" style="width:100px">
   <p class="f2" style="width:80px;"><strong>服务支持</strong></p>
   <dd class="f3"><a href="#">支付方式</a></dd>
   <dd class="f3"><a href="#">意见反馈</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1 f">
   <p class="f2 ff"><strong>关于云学</strong></p>
   <dd class="f0 f3"><a href="#">网站简介</a></dd>
   <dd class="f0 f3"><a href="#">新闻报道</a></dd>
   <dd class="f0 f3"><a href="#">加入我们</a></dd>
   <dd class="f0 f3"><a href="#">活动公告</a></dd>
   <dd class="f0 f3"><a href="#">联系我们</a></dd>
   <dd class="f0 f3"><a href="#">行业大会</a></dd>
  </div>
  <i class="spacer"></i>
  <div class="f1" style="width:100px">
   <p class="f2" style="width:80px"><strong>关注我们</strong></p>
   <dd class="f3"><a href="#">官网微信</a></dd>
   <dd class="f3"><a href="#">新浪微博</a></dd>
  </div>
 </div>
</div>

<div class="bottom0">
 <div class="bottom">
  <div class="copyright">
   办学许可证：111010873931661&nbsp;&nbsp;&nbsp;&nbsp;
   电信与信息服务业务经营许可证：京ICP证150105号&nbsp;&nbsp;&nbsp;&nbsp;
   京ICP备14035240号-2 &nbsp;&nbsp;&nbsp;&nbsp;   京公网安备11010802016334号
   <br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;江西师范大学瑶湖校区&nbsp;&nbsp;&nbsp;&nbsp;2015级软件技术一班&nbsp;&nbsp;&nbsp;&nbsp;云学网开发小组
  </div>
  <div class="copyr">
   <img src="IMG/index/pit.png" width="132" height="48" />
  </div>
 </div>
</div>
</body>
</html>