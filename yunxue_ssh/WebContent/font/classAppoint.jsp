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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>classAppoint</title>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<link type="text/css" href="css/header-bottom.css" rel="stylesheet">

<link type="text/css" rel="stylesheet" href="css/select_next.css">
<script src="js/jquery v3.2.1.min.js"></script>
<script src="js/select_next.js"></script>
<script type="text/javascript">
var classname={};
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
	var myDate = new Date();
	var d=myDate.getDay();
	for(var i=1;i<=7;i++){
		$("thead th:eq("+i+")").text(day[(d++)%7]);
	}
	$(".nav1 ul li").removeClass("cur").eq(2).addClass("cur");
	<c:forEach items="${classno}" begin="0" end="41" var="p">
	if(${p.planClassState}==1&&${p.planClassName==null}){
		var x=parseInt((${p.planClassNo}-1)/7)+1;
		var y=((${p.planClassNo}-1)%7+8-myDate.getDay())%7+1;
		$("tr:eq("+x+") td:eq("+y+")").addClass("can").html("<span class='${p.planClassNo}' style='width:100%;height:100%;line-height:50px;'>预约</span>").off("click").on("click",appoint);
	}
	</c:forEach>
	
	$("tr:not(:first) td:not(:first-child,.can)").addClass("ban");
	
	
	
	var s="${teamo.teacherStage}";
	var a=s.split(',');
	for(var i in a){
		classname[a[i]]=[];
	}
	s="${teamo.teacherClasses}";
	a=s.split(',');
	for(var i in a){
		classname[a[i].substring(0,2)].push(a[i].substring(2,a[i].length));
	}
	var str="";
	for(var i in classname){
		str+="<span >"+i+"</span>";
	}
	$(".tabs").html(str);
	$(".tabs span").on("click",tabactive);
	//alert("${sessionScope.stuloginer.userNo}");
	//alert(JSON.stringify(classname));
})
</script>
</head>
<body>
<jsp:include page="nav.jsp" flush="true"/>
<div class="title"><h1>预约课程</h1></div>
<div class="tabs">
</div>
	<div class="tab-box">
		<div class="subject">
		</div>
		<div style="width: 1100px; margin:0 auto;">
			<div style="width:750px; float: left; ">
				<table width="750" height="400">
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
			<div  style=" width: 300px;height: 400px; float: right; text-align: left; ">
				<span class="classtitle">课程价格</span> 
				<div style="width: 300px;height: 350px; overflow: auto;">
					<ul class="classprice">
						<p>初中英语：50元/小时</p>
						<p>初中数学：60元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
						<p>初中物理：50元/小时</p>
					</ul>
				</div>
				
			</div>
			<div class="clear"></div>
			<div style="margin-top: 10px; margin-bottom: 10px; text-align: left;">
				<img style="vertical-align: middle;" width="30" height="30" src="./IMG/teacherMessage/can.png">
				<span style="vertical-align: middle;">可预约&emsp;</span>
				
			</div>
	    	<input class="sub-appoint" onClick="confirmselect(this)" type="button" value="保存预约">
			</div>

		
    </div>
<div class="page-mask">
	<div class="bounce">
		<button class="close" onClick="closemask()">×</button>
	</div>
</div>
</body>
</html>