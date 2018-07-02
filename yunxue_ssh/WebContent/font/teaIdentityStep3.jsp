<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<title>tIdentityStep3</title>
<link type="text/css"  href="css/tIdentity.css" rel="stylesheet"/>
<link type="text/css"  href="css/header-bottom.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<script type="text/javascript" src="js/tIdentity3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${param.passMg == '2' }">
    <script type="text/javascript">
    $(function(){
    	alert("您已通过第一步和第二步认证")
    })
    </script>
</c:if>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>

<form action="kl/teaIdentityThrid" method="post">
<div style="width:1200px;height:auto;margin:0 auto;" id="step3">
  <div class="step">
    <img src="IMG/tIdentity/step3.png" width="1200" height="110" />
  </div>
  <s:debug></s:debug>
  <p style="font-size:30px;margin-bottom: 20px;">设置上课信息</p>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>教授阶段：
     </div>
     <div class="value">
       <input style="margin-left:10px;" type="checkbox" name="stage" value="小学"/>&nbsp;&nbsp;小学
       <input style="margin-left:10px;" type="checkbox" name="stage" value="初中"/>&nbsp;&nbsp;初中
       <input style="margin-left:10px;" type="checkbox" name="stage" value="高中"/>&nbsp;&nbsp;高中
     </div>
  </div>
  <div class="info" style="height:100px;">
     <div class="key">
       <span style="color:red;">*</span>教授科目：
     </div>
     <div class="value">
      <input style="margin-left:10px;" type="checkbox" name="subject" value="语文"/>&nbsp;&nbsp;语文
      <input style="margin-left:10px;" type="checkbox" name="subject" value="数学"/>&nbsp;&nbsp;数学
      <input style="margin-left:10px;" type="checkbox" name="subject" value="英语"/>&nbsp;&nbsp;英语
      <input style="margin-left:10px;" type="checkbox" name="subject" value="奥数"/>&nbsp;&nbsp;奥数
      <input style="margin-left:10px;" type="checkbox" name="subject" value="新概念英语一册"/>&nbsp;&nbsp;新概念英语一册
      <input style="margin-left:10px;" type="checkbox" name="subject" value="新概念英语二册"/>&nbsp;&nbsp;新概念英语二册&nbsp;&nbsp;
      <input style="margin-left:10px;" type="checkbox" name="subject" value="物理"/>&nbsp;&nbsp;物理
      <input style="margin-left:10px;" type="checkbox" name="subject" value="化学"/>&nbsp;&nbsp;化学
      <input style="margin-left:10px;" type="checkbox" name="subject" value="生物"/>&nbsp;&nbsp;生物
      <input style="margin-left:10px;" type="checkbox" name="subject" value="政治"/>&nbsp;&nbsp;政治
      <input style="margin-left:10px;" type="checkbox" name="subject" value="地理"/>&nbsp;&nbsp;地理
      <input style="margin-left:10px;" type="checkbox" name="subject" value="历史"/>&nbsp;&nbsp;历史
     </div>
  </div>
  <div class="info" style="height:400px;">
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
          <td><span >
          <input  type="checkbox" name="time" value="${i.classInterval}">
          </span></td>     
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">10:40-11:40</td>
        <c:forEach items="${classList}" begin="1" end="41" var="i" step="6">
          <td><span >
          <input  type="checkbox" name="time" value="${i.classInterval}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">14:30-15:30</td>
        <c:forEach items="${classList}" begin="2" end="41" var="i" step="6">
          <td><span >
          <input  type="checkbox" name="time" value="${i.classInterval}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">15:50-16:50</td>
       <c:forEach items="${classList}" begin="3" end="41" var="i" step="6">
          <td><span>
          <input   type="checkbox" name="time" value="${i.classInterval}">
          </span></td>    
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">19:00-20:00</td>
        <c:forEach items="${classList}" begin="4" end="41" var="i" step="6">
          <td><span>
          <input type="checkbox" name="time" value="${i.classInterval}">
          </span></td> 
        </c:forEach>
      </tr>
      <tr>
        <td style="width:100px;">20:20-21:20</td>
        <c:forEach items="${classList}" begin="5" end="41" var="i" step="6">
          <td><span >
          <input type="checkbox" name="time" value="${i.classInterval}">
          </span></td> 
        </c:forEach>
      </tr>
    </table>
  </div>
  <div class="info" style="margin-bottom:100px;">
     <input type="submit"  class="nextstep" value="完成设置"/>
  </div> 
</div>
</form>

<jsp:include page="bottom.jsp" flush="true"/>
</body>
</html>