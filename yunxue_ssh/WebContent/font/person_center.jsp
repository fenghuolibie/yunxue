<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>" />
<link type="text/css" href="css/header-bottom.css" rel="stylesheet" />
<link type="text/css" href="css/person_center.css" rel="stylesheet" />
<link type="text/css" href="css/message-config.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<script type="text/javascript" src="js/jqueryPhoto.js"></script>
<script type="text/javascript" src="js/message_config.js"></script>
<title>person_center</title>
</head>
<body class="main">
	<script type="text/javascript">
		$(document).ready(function() {
			$(".nav1 ul li").removeClass("cur");
		});
	</script>
    <jsp:include page="nav.jsp" flush="true"></jsp:include>

	<div class="line"></div>
	<div class="container">
		<div class="stu-box-left">
			<div class="stu-message">
				<div class="stu-image">
					<img src="${student.stuImg}" width="150" height="150"
						style="border-radius: 50%;">
				</div>
				<div class="stu-per">
					<p>
						<span>姓名：</span>${student.stuName}</p>
					<ul>
						<li class="a">云币：<span>${student.stuMoney}</span></li>
						<li class="b">奖章：<span>5</span></li>
					</ul>
					<div class="stu-data">
						资料完整度：<em id="integrity"></em><span class="stu-data2" id="data2"></span>
					</div>
					<div class="stu-line">
						<div class="stu-line2" id="line2"></div>
					</div>
				</div>
				<div class="stu-per2">
					<ul>
						<li><a href="font/buyclass.jsp"><img
								src="IMG/person_center/user_info1.png" width="40" height="40"><br>
								<span style="font-size: 13px; color: black;">购买课时</span></a></li>
						<li><a href="#"><img
								src="IMG/person_center/user_info2.png" width="40" height="40"><br>
								<span style="font-size: 13px; color: black;">预约试听课</span></a></li>
						<li><a href="#"><img
								src="IMG/person_center/user_info3.png" width="40" height="40"><br>
								<span style="font-size: 13px; color: black;">可用优惠券</span></a></li>
						<li><a href="#"><img src="IMG/person_center/po.png"
								width="40" height="40"><br> <span
								style="font-size: 13px; color: black;">预约课程</span></a></li>
					</ul>
				</div>
				<div style="clear: both"></div>
				<div class="in-line"></div>
				<div class="stu-tab" style="height: 245px; overflow: hidden;">
					<p>我的课表</p>
					<table border="0px" cellspacing="3">
						<tr>
							<td width="130px">教 师 名</td>
							<td width="130px">课 程 名</td>
							<td width="340px">上 课 日期</td>
							<td width="150px">上课时间</td>
						</tr>
						<c:forEach items="${timeTable}" var="t">
							<tr>
								<td>${t.teacherName}</td>
								<td>${t.className}</td>
								<td class="classdate">${t.classDate}</td>
								<td class="classtime">${t.classTime}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="stu-icon">
				<ul>
					<li><a href="#"><img src="IMG/person_center/po.png"
							height="60"> <span style="font-size: 17px; color: black;">预约课程</span></a>
					</li>
					<li><a href="#"><img src="IMG/person_center/bubble.png"
							height="60" /> <span style="font-size: 17px; color: black;">我要请假</span></a>
					</li>
					<li id="infochange"><a href="#"><img
							src="IMG/person_center/setting.png" height="60" /> <span
							style="font-size: 17px; color: black;">个人设置</span></a></li>
					<li><a href="#"><img src="IMG/person_center/pen.png"
							height="60" /> <span style="font-size: 17px; color: black;">上课设置</span></a>
					</li>
					<li><a href="#"><img src="IMG/person_center/help.png"
							height="60" /> <span style="font-size: 17px; color: black;">帮助中心</span></a>
					</li>
					<li><a href="font/teachernamequery.do"><img
							src="IMG/person_center/user.png" height="60" /> <span
							style="font-size: 17px; color: black;">查看教师</span></a></li>
				</ul>
			</div>
			<div class="stu-lesson">
				<div class="stu-lesson-box1">
					<img src="IMG/person_center/book.png">
					<p>我最近完成的课程</p>
					<a href="#">查看更多上课履历</a>
				</div>
				<div style="clear: both"></div>
				<div class="in-line"></div>
				<div class="stu-lesson-asses">
					<ul>
						<c:forEach items="${classItem}" var="c" end="3">
							<li class="clear">
								<div class="stu-asses-image">
									<img src="${c.teaPicture}" width="70" height="70"
										style="border-radius: 50%;">
								</div>
								<div class="stu-mess-message">
									<p>
										<span>教师姓名：</span><a href="#">${c.teacherName}</a>
									</p>
									<p>
										<span>课程名：</span>${c.className}</p>
									<p>
										<span>课程状态：</span>已上课
									</p>
									<p style="width: 360px;">
										<span>上课时间：</span>${c.classDate}&nbsp;&nbsp;${c.classTime}</p>
								</div>
								<div class="stu-asses-but">
									<a href="#">评 价</a> <a href="#">课后复习</a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="stu-box-right">
			<div class="contact-sidebar">
				<p>紧急联系卡</p>
				<div class="contact-teacher">
					<ul>
						<li>
							<div style="padding-left: 25px">
								<img class="c" src="IMG/person_center/teim.png" height="25">
								<p class="a">
									我的学习导师：<a href="#">程飞</a>
								</p>
								<br>
								<p class="b">
									微信号：<span style="color: blue">a123456</span>
								</p>
								<p class="b">
									手机号：<span style="color: blue">12345678901</span>
								</p>

							</div>
							<div class="in-line"></div>
						</li>
						<li>
							<div style="padding-left: 25px">
								<img class="c" src="IMG/person_center/teim.png" height="25">
								<p class="a">
									我的学习导师：<a href="#">程飞</a>
								</p>
								<br>
								<p class="b">
									微信号：<span style="color: blue">a123456</span>
								</p>
								<p class="b">
									手机号：<span style="color: blue">12345678901</span>
								</p>

							</div>
							<div class="in-line"></div>
						</li>
						<li>
							<div style="padding-left: 25px">
								<img class="c" src="IMG/person_center/teim.png" height="25">
								<p class="a">
									我的学习导师：<a href="#">程飞</a>
								</p>
								<br>
								<p class="b">
									微信号：<span style="color: blue">a123456</span>
								</p>
								<p class="b">
									手机号：<span style="color: blue">12345678901</span>
								</p>

							</div>
							<div class="in-line"></div>
						</li>
					</ul>
				</div>
			</div>
			<div class="adv-sidebar">
				<p>公告栏</p>
				<div class="in-line"></div>
				<img src="IMG/person_center/p2.jpg" width="290px">
			</div>
		</div>
	</div>

	<div class="can"></div>
	<div class="message-config">
		<div class="message-config-head">
			<span>编辑信息</span> <img src="IMG/index/item_r.png" height="20"
				onclick="" id="close">
			<div class="in-line"></div>
		</div>
		<form action="kl/stuUpdateMsg" method="post">
			<div class="message-config-main">
				<h4>
					您的编号：<span>${stuloginer.userNo}</span>
				</h4>
				<div class="config-img">
					<div style="width: 250px; height: 170px; float: left;">
						<div style="width: 200px; height: 40px;">
							<p>本人头像：</p>
							<!--chorm默认字高21px，宽16px；-->
							<span class="fileinput-button"> <span>上传图片</span> <input
								type="file" name="personImg" id="fileinput">
							</span>
						</div>
						<img src="${student.stuImg}" id="headtest"
							style="width: 100px; height: 100px; margin-left: 20px; margin-top: 10px;" />
						<div>
							<canvas id="res1" style="display:none"></canvas>
							<canvas id="res2" style="display:none"></canvas>
							<canvas id="res3" style="display:none"></canvas>
						</div>
					</div>
					<div id="canvasContainer">
						<canvas id="container"></canvas>
						<div id="picker"></div>
						<input type="button"
							style="cursor: pointer; margin-top: 10px; margin-left: 10px;"
							id="bigger" value="原图放大" /> <input type="button"
							style="cursor: pointer; margin-top: 10px; margin-left: 10px;"
							id="smaller" value="原图缩小" /> <input type="button"
							style="cursor: pointer; margin-top: 70px; margin-left: 10px;"
							id="upload" value="确定" /> <input type="hidden" id="uploadres"
							value="${student.stuImg}" name="imgurl" />
					</div>

				</div>
				<ul style="margin-top: 20px;">
					<li>
						<p>我的名字：</p> <input style="width: 65px;" class="a"
						value="${student.stuName}" type="text" name="personName">
					</li>
					<li>
						<p>我的性别：</p>
						<input type="hidden" id="sex" value="${student.stuSex}"> <input
						type="radio" name="sex" value="1" id="nan" />男&nbsp;&nbsp; <input
						type="radio" name="sex" value="0" id="nv" />女
					</li>
					<li>
						<p>出生年月：</p>
						<input type="hidden" id="birth" value="${student.stuBirth}">
						<div class="like-select">
							<input type="hidden" name="year" id="year">
							<div class="select-value" id="val1">年份</div>
							<a class="controls" id="a1"></a>
							<div class="option" id="sel1"
								style="height: 94px; display: none;">
								<ul>
									<li>2016</li>
									<li>2015</li>
									<li>2014</li>
									<li>2013</li>
									<li>2012</li>
									<li>2011</li>
									<li>2010</li>
									<li>2009</li>
									<li>2008</li>
									<li>2007</li>
									<li>2006</li>
									<li>2005</li>
									<li>2004</li>
									<li>2003</li>
									<li>2002</li>
									<li>2001</li>
									<li>2000</li>
									<li>1999</li>
									<li>1998</li>
									<li>1997</li>
									<li>1996</li>
									<li>1995</li>
									<li style="border: 0;">1996</li>
								</ul>
							</div>
						</div>
						<div class="like-select">
							<input type="hidden" name="month" id="month">
							<div class="select-value" id="val2">月份</div>
							<a class="controls" id="a2"></a>
							<div class="option" id="sel2"
								style="height: 94px; display: none;">
								<ul style="widht: 100%">
									<li>1</li>
									<li>2</li>
									<li>3</li>
									<li>4</li>
									<li>5</li>
									<li>6</li>
									<li>7</li>
									<li>8</li>
									<li>9</li>
									<li>10</li>
									<li>11</li>
									<li style="border: 0;">12</li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<p>教育阶段：</p>
						<div class="like-select">
							<input type="hidden" name="stage" id="stage"
								value="${student.stuStage}">
							<div class="select-value" id="val3">${student.stuStage}</div>
							<a class="controls" id="a3"></a>
							<div class="option" id="sel3"
								style="height: 94px; display: none;">
								<ul style="widht: 100%">
									<li>小学</li>
									<li>初中</li>
									<li style="border: 0;">高中</li>
								</ul>
							</div>
						</div>
					</li>
					<li>
						<p>就读学校：</p> <input class="a" value="${student.stuSchool}"
						type="text" name="personSchool">
					</li>
				</ul>
				<input class="c" type="submit" name="submit" value="确认修改">
			</div>
		</form>
	</div>
	<jsp:include page="bottom.jsp" flush="true" />

</body>
</html>