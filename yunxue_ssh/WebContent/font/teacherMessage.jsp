<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>"/>
<meta charset="utf-8">
<title>teacher_message</title>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/teacher_message.css">
<link type="text/css" rel="stylesheet" href="css/header-bottom.css">
<script type="text/javascript">
var day={
		"1":"星期一",
		"2":"星期二",
		"3":"星期三",
		"4":"星期四",
		"5":"星期五",
		"6":"星期六",
		"0":"星期天"
	}
$(function(){
	
	$(".nav1 ul li").removeClass("cur").eq(2).addClass("cur");
	 var myDate = new Date();
	var d=myDate.getDay();
	 for(var i=1;i<=7;i++){
			$("thead th:eq("+i+")").text(day[(d++)%7]);
		}
		$(".nav1 ul li").removeClass("cur").eq(2).addClass("cur");
		<c:forEach items="${classPlan}" begin="0" end="41" var="p">
		if(${p.planClassState}==1&&${p.planClassName==null}){
			var x=parseInt((${p.planClassNo}-1)/7)+1;
			var y=((${p.planClassNo}-1)%7+8-myDate.getDay())%7+1;
			$("tr:eq("+x+") td:eq("+y+")").addClass("can").html("<span class='${p.planClassNo}' style='width:100%;height:100%;line-height:50px;'></span>");
		}
		</c:forEach>
})
</script>
</head>
<body>

<jsp:include page="nav.jsp" flush="true"/>

<div class="middle">
<div class="title"><h1>预约课程</h1></div>
	<div class="lesson">
		<div class="class-tab">
            <div class="tab-box">
        	<table width="625" height="400">
					<thead>
						<th width="50"></th><th><scrpit></scrpit></th><th></th><th></th><th></th><th></th><th></th><th></th>
					</thead>
		  	        <tbody>
		   	        <tr>
		   	        	<td style="font-size:14px">9：20-10：20</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        <tr>
		   	        	<td style="font-size:14px">10：40-11：40</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        <tr>
		   	        	<td style="font-size:14px">14：30-15：30</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        <tr>
		   	        	<td style="font-size:14px">15：50-16：50</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        <tr>
		   	        	<td style="font-size:14px">19：00-20：00</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        <tr>
		   	        	<td style="font-size:14px">20：20-21：20</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		   	        </tr>
		   	        
		   	        </tbody>
	    		</table>
        	</div>
        	
        	<div style="clear: both;"></div>
        	<div class="course-list">
				<span style="color: #F28F90">特色服务</span>
				<div class="special">
				<p style="display: block;">
					<span class="s1"><i></i>讲练结合</span>
					<span class="s2"><i></i>24小时答疑</span>
					<span class="s3"><i></i>学习群服务</span>
					<span class="s4"><i></i>离线回放</span>
					<span class="s5"><i></i>学习群服务</span>
				</p>
				</div>
			</div>
			<div class="clear"></div>
			<div class="appoint-sb">
				<input class="appoint-sb-but" type="button" onClick="window.location.href='kl/classAppopint?teacherNo=${teacher1.teacherNo}'" value="开始预约">
				<div class="support">
        		<span>
        		支持以下缓存听课
        			<i class="i1"></i><i class="i2"></i><i class="i3"></i><i class="i4"></i>
        		</span>
        	    </div>
			</div>
        </div>
    </div>
    <div class="appoint">
    	<div class="lesson-box clearboth">
	 	 <div class="lesson-box-left">
	 	     <div class="lesson-box-img"> 
	 	        <img width="80px" height="80px" src="${teacher1.teaPicture}" style="display: inline;border-radius: 50%;">
 		     </div>
         </div>	 							
	 	 <div class="lesson-box-center">
	     	<div class="lesson-p">
	     		<span style="font-size: 18px;">名师指导，在线答疑</span>
	     	</div>
	    	<div class="lesson-p-after">
	    	<p class="tea-name" style="font-size: 18px; overflow: hidden;float: left;max-width: 300px;  display: block; height: 30px; line-height: 30px;">
	    	<span style="color: rgb(153, 153, 153);">姓名：</span>${teacher1.teaName}</p>
		    <ul class="renzheng clearboth">
		      <li class="realname">身份认证</li>
		      <li class="certification">学历认证</li>  			
		    </ul>
		    
		    </div>
	 	 </div>	 
	 	 <div style="clear: both;"></div>							
	 	 <div class="lesson-box-right">
	 	 
			<div class="lesson-box-information">
				  <p>
					<span style="color: rgb(153, 153, 153);">性别：</span>${teacher1.teaSex} &nbsp;&nbsp;&nbsp;&nbsp;				
				  </p>
				  <p>
					<span style="color: rgb(153, 153, 153);">学校：</span>${teacher1.teaSchool}
				  </p>
				  <p> 
					<span style="color: rgb(153, 153, 153);">学历：</span>${teacher1.teaEducation}&nbsp;&nbsp;&nbsp;&nbsp;				
				  </p>
				  <p>
					<span style="color: rgb(153, 153, 153);">满意度：</span>${teacher1.teacherSatisfaction}
				  </p>
				  <p style="width:360px;" >
					<span style="color: rgb(153, 153, 153);">所教科目：</span>${teacher1.teacherClasses}
				  </p>
				  <div class="clear"></div>
				  <br>
				  <p style="float: none;">
					<span style="color: rgb(153, 153, 153);">家教自述：</span>${teacher1.teaDescription}
				  </p>
				  
				  <br>
				  <p style="float: none;">
					<span style="color: rgb(153, 153, 153);">授课风格：</span>${teacher1.teacherStyle}
				  </p>
				  <br>
				  <p style="float: none;">
					<span style="color: rgb(153, 153, 153);">家教经历：</span>${teacherMes.teaExperience}
				  </p>
			</div> 
			<div class="clear"></div>
		    
	 	 </div>
	 </div>
	
    </div>
</div>

</body>
</html>