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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<link type="text/css" href="css/header-bottom.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="css/teacher_center.css">

<script src="js/jquery v3.2.1.min.js"></script>
<script>
window.onload = function(){
	$(".nav1 ul li").removeClass("cur");
	 $("table tr td span").children("input:hidden").each(function() {
		 if($(this).val()=="1"){
			 $(this).closest("span").removeClass("checkpic");
		     $(this).closest("span").addClass("checkpic2"); 
		 }
		 else{
			 $(this).closest("span").removeClass("checkpic2");
		     $(this).closest("span").addClass("checkpic");  
		 }
	 });
}
</script>
<script src="js/teacher_center.js"></script>
</head>

<body>
<jsp:include page="nav.jsp" flush="true"/>
<div class="wrap">
	<div class="main">
        <!--侧边栏-->
		<div class="sidebar-box">
            <div class="empty" style="text-align:center;">
              <img src="IMG/person_center/teacher.png" style="width:30px;height:30px;margin-top:10px;">
            </div>
            <ul class="clear">
                <!--全部链接-->
            	<a href="#"><li>我的信息<div class="border"></div></li></a>
            	<a href="#"><li>我的课程<div class="border"></div></li></a>
            	<a href="#"><li>我的钱包<div class="border"></div></li></a>
            	<a href="#"><li>上课记录<div class="border"></div></li></a>
            </ul>
		</div>
		<div class="message-box">
		    <h3>个人概况</h3>
			<div class="teacher-message-box">
				<div class="teacher-image">
        	    	<img src="${teacher1.teaPicture}" width="100" height="100">
        	    	<div class="mask">
    			        <img src="IMG/person_center/mask-3.png" width="100" height="100">
    		        </div>
        	    </div>
        	    <div class="message-box-left">
        	    	<p class="a">${teacher1.teaName}</p>
        	    	<ul class="clear">
        	    		<li>年龄：<span>${teacher1.teaAge}</span></li>
        	    		<li>性别：<span>${teacher1.teaSex}</span></li>
        	    		<li class="a">专业：<span>${teacher1.teaMajor}</span></li>
        	    	</ul>
        	        <p class="b">学校：<span>${teacher1.teaSchool}</span></p><br>
        	        <p class="b">教授课程：<span>${teacher1.teacherClasses}</span></p>
        	    </div>
        	    <div style="clear:both"></div>
			</div>
			<h3>我的课表</h3>
			<div class="tea-class-tab">
			      <div class="info" style="height:300px;">
    <div class="key">
       <span style="color:red;">*</span>上课时间：
    </div>
    <table>
      <tr>
        <td></td><td>周一</td><td>周二</td><td>周三</td>
        <td>周四</td><td>周五</td><td>周六</td><td>周日</td>
      </tr>
      <tr>
        <td style="width:100px;">09:20-10:20</td>
        <c:forEach items="${classList}" begin="0" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td>     
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">10:40-11:40</td>
        <c:forEach items="${classList}" begin="1" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">14:30-15:30</td>
        <c:forEach items="${classList}" begin="2" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">15:50-16:50</td>
       <c:forEach items="${classList}" begin="3" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td>    
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">19:00-20:00</td>
        <c:forEach items="${classList}" begin="4" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">20:20-21:20</td>
        <c:forEach items="${classList}" begin="5" end="41" var="i" step="6">
          <td><span class="checkpic">
          <input  class="time" type="checkbox" name="time" value="${i.planClassNo}" style="display: none;">
          <input type="hidden" value="${i.planClassState}">
          </span></td> 
        </c:forEach>
      </tr>
    </table>
     <a class="gochange" href="TidentityStep3.do">去修改</a>
  </div>
   
			</div>
		</div>
	</div>
</div>


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
</body>
</html>
