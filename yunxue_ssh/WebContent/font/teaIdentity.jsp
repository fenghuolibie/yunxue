<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"/>
<link type="text/css"  href="css/tIdentity.css" rel="stylesheet"/>
<link type="text/css"  href="css/header-bottom.css" rel="stylesheet"/>
<script type="text/javascript" src="js/tIdentity.js"></script>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>teacher identity</title>
<c:if test="${param.passMg == '1' }">
    <script type="text/javascript">
    $(function(){
    	$("#step1").hide();
    	$("#step2").show();
    	alert("您已通过第一步认证")
    })
    </script>
</c:if>
<c:if test="${param.markMsg == 'fillok' }">
    <script type="text/javascript">
    $(function(){
    	$("#step1").hide();
    	$("#step2").show();
    	alert("您已通过第一步认证")
    })
    </script>
</c:if>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<h1>${param.markMsg }</h1>
<!-- 第一步认证 -->
<div style="width:1200px;height:auto;margin:0 auto" id="step1">
  <div class="step">
   <img src="IMG/tIdentity/step.png" width="1200" height="110" />
  </div>
  <p style="font-size:30px;margin-bottom: 20px;">基本信息</p>
  <span style="color:red;margin-left:50px;">*</span>本人头像：
  <br/> <br/>
  <div class="pic">
   <img src="${teacher.teaPicture}" id="headtest" class="headtest"/>
   <div>
     <canvas id="res1" style="display:none"></canvas>
     <canvas id="res2" style="display:none"></canvas>
     <canvas id="res3" style="display:none"></canvas>       
   </div>
    <span class="fileinput">
	<span>选择本地照片</span>
	<input type="file" name="teacherImg" id="fileinput"/>
  </span>
   <div id="canvasContainer">
      <canvas id="container" style="float:left;"></canvas>
      <div id="picker"></div>
   </div>
       <div class="container-button">
        <input type="button" class="con-button" id="bigger" value="原图放大"/>
        <input type="button" class="con-button" id="smaller" value="原图缩小"/>
        <input type="button" class="con-button" style="margin-top:70px;" id="upload" value="保存"/> 
        <input type="hidden" id="uploadres" name="imgurl"/>      
       </div>       
   </div>
   
   <div class="info">
     <div class="key">
       <span style="color:red;">*</span>真实姓名：
     </div>
     <div class="value">
       <input type="text" class="input1" id="tname" name="tname" value="${teacher.teaName}" placeholder=" 请输入真实姓名"/>
       <span>姓名一经认证不可修改</span>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>我的性别：
     </div>
     <div class="value">
       <span><input type="radio" name="sex" value="男"/>&nbsp;&nbsp;男</span>
       <span><input type="radio" name="sex" value="女"/>&nbsp;&nbsp;女</span>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>身份证号：
     </div>
     <div class="value">
       <input type="text" class="input1" value="${teacher.teaIdCard}" name="tIdcard" id="tIdcard" placeholder=" 请输入身份证号"/>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>出生年月：
     </div>
     <div class="value">
       <div class="like-select">
         <input type="hidden" name="year" id="year">
         <div class="select-value" id="val1">请选择出生年份</div>
         <a class="controls" id="a1"></a>
         <div class="option" id="sel1"  style="height:198px;display:none;">
           <ul>
             <li>2010</li><li>2009</li><li>2008</li><li>2007</li><li>2006</li><li>2005</li>
             <li>2004</li><li>2003</li><li>2002</li><li>2001</li><li>2000</li><li>1999</li>
             <li>1998</li><li>1997</li><li>1996</li><li>1995</li><li>1994</li><li>1993</li>
             <li>1992</li><li>1991</li><li>1990</li><li>1989</li><li>1988</li><li>1987</li>
             <li>1986</li><li>1985</li><li>1984</li><li style="border:0;">1983</li>
           </ul>   
         </div>
       </div>
       <div class="like-select">
         <input type="hidden" name="month" id="month">
         <div class="select-value" id="val2">请选择出生月份</div>
         <a class="controls" id="a2"></a>
         <div class="option" id="sel2"  style="height:198px;display:none;">
           <ul style="widht:100%">
             <li>1</li><li>2</li><li>3</li><li>4</li><li>5</li><li>6</li><li>7</li>
             <li>8</li><li>9</li><li>10</li><li>11</li><li style="border:0;">12</li>
           </ul>
         </div>
       </div>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>我的学历：
     </div>
     
     <div class="value">
       <div class="like-select">
         <input type="hidden" name="tEducation" id="tEducation">
         <div class="select-value" id="val3">
          <c:choose>
            <c:when test="${teacher.teaEducation!=null}">
                ${teacher.teaEducation}
            </c:when>
            <c:otherwise>
                                     其他
            </c:otherwise>
          </c:choose>
         </div>
         <a class="controls" id="a3"></a>
         <div class="option"  id="sel3"  style="height:auto;display:none;">
           <ul style="widht:100%">
             <li>高中</li><li>本科</li><li>硕士</li><li>博士</li><li style="border:0;">其他</li>
           </ul>
         </div>
       </div>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>就读院校：
     </div>
     <div class="value">
       <input type="text" class="input1" value="${teacher.teaSchool}" id="tschool" placeholder=" 请输入就读院校"/>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>所学专业：
     </div>
     <div class="value">
       <input type="text" class="input1" id="tmajor" value="${teacher.teaMajor}" placeholder=" 请输入所学专业方向"/>
     </div>
  </div>
  <div class="info">
     <div class="key">
       <span style="color:red;">*</span>所在地区：
     </div>
     <div class="value">
       <input type="text" class="input1" id="tarea" value="${teacher.teaArea}" placeholder=" 请输入本人所在地区"/>
     </div>
  </div>
  <div class="info" style="height:200px;">
     <div class="key">
       <span style="color:red;">*</span>自我描述：
     </div>
     <textarea style="width:300px;height:180px;" value="${teacher.teaDescription}" id="tDescription"></textarea> 
  </div>
   <div class="info" style="height:200px;">
     <div class="key">
       <span style="color:red;">*</span>家教经历：
     </div>
     <textarea style="width:400px;height:180px;" value="${teacher.teaExperience}" id="tExperience"></textarea> 
  </div>
  <div class="info" style="margin-bottom:100px;">
     <input type="button" onclick="step1()" class="nextstep" value="下一步"/>
  </div>
</div>

<!--第二步认证  -->
<form action="kl/teaIdentitySecond.action" method="post" enctype="multipart/form-data">
<div style="width:1200px;height:auto;margin:0 auto;display:none;" id="step2">
  <div class="step">
    <img src="IMG/tIdentity/step2.png" width="1200" height="110" />
  </div>
  <s:debug></s:debug>
  
  <span style="color:red;margin-left:50px;">*</span>身份证照片：
  <span class="fileinput2"><span>选择本地照片</span>
	<input type="file" name="teacherImg" id="fileinput2"/>
  </span>
  <div class="pic" style="height:450px;">
   <div>
     <canvas id="res4" style="display:none"></canvas>
     <canvas id="res5" style="display:none"></canvas>
     <canvas id="res6" style="display:none"></canvas>       
   </div>
   <div id="canvasContainer2" class="canvasContainer2">
      <canvas id="container2"></canvas>          
    </div>
   </div>
   
  <span style="color:red;margin-left:50px;">*</span>教师证照片照片：
  <span class="fileinput2"><span>选择本地照片</span>
	<input type="file" name="teacherImg" id="fileinput3"/>
  </span>
  <div class="pic" style="height:450px;">
   <div>
     <canvas id="res7" style="display:none"></canvas>
     <canvas id="res8" style="display:none"></canvas>
     <canvas id="res9" style="display:none"></canvas>       
   </div>
   <div id="canvasContainer3" class="canvasContainer2">
      <canvas id="container3"></canvas>          
    </div>
   </div>
  <div class="info" style="margin-bottom:100px;">
     <input type="submit"  class="nextstep" value="下一步"/>
  </div> 
</div>
</form>

<jsp:include page="bottom.jsp" flush="true"/>
</body>
</html>