<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<base href="<%=basePath%>" />
<link type="text/css" href="css/index.css" rel="stylesheet" />
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
    <c:if test="${identityMsg == 'fillok'}">
        <script type="text/javascript">
			$(function() {
				alert("验证成功");
			})
		</script>
    </c:if>
	<c:if test="${loginTip == 1}">
		<script type="text/javascript">
			$(function() {
				alert("您不是学生或者您未登录");
			})
		</script>
	</c:if>
	<c:choose>
		<c:when test=""></c:when>
	</c:choose>

	<jsp:include page="nav.jsp" flush="true" />
	<div class="con">
		<div class="content" onmousemove="turnicon()" onmouseout="outicon()">
			<ul>
				<li class="bar1"><a href="#"><img
						src="IMG/index/banner2.jpg" width="1500" height="450" /></a></li>
				<li><a href="#"><img src="IMG/index/banner3.jpg"
						width="1500" height="450" /></a></li>
				<li><a href="#"><img src="IMG/index/banner4.jpg"
						width="1500" height="450" /></a></li>
			</ul>
			<div class="turnleft" id="turnleft"></div>
			<div class="turnright" id="turnright"></div>
		</div>

		<div class="column" onmousemove="turnicon()" onmouseout="outicon()">
			<div class="menu">
				<ul>
					<li class="menu-first">获得专属培养方案</li>
					<li class="menu-li">
						<div class="image">
							<img src="IMG/index/primary1.png" width="24" height="24" />
						</div>
						<p class="zi">小学</p>
						<div class="course">
							<span class="ke">课程：</span>
							<ul>
								<li><a href="#">语文</a></li>
								<li><a href="#">数学</a></li>
								<li><a href="#">英语</a></li>
								<li><a href="#">奥数</a></li>
								<li><a href="#">新概念英语</a></li>
							</ul>
						</div>
					</li>
					<li class="menu-li">
						<div class="image">
							<img src="IMG/index/junior1.png" width="24" height="24" />
						</div>
						<p class="zi">初中</p>
						<div class="course">
							<span class="ke">课程：</span>
							<ul>
								<li><a href="#">语文</a></li>
								<li><a href="#">数学</a></li>
								<li><a href="#">英语</a></li>
								<li><a href="#">物理</a></li>
								<li><a href="#">化学</a></li>
								<li><a href="#">生物</a></li>
								<li><a href="#">政治</a></li>
								<li><a href="#">地理</a></li>
								<li><a href="#">历史</a></li>
							</ul>
						</div>
					</li>
					<li class="menu-li">
						<div class="image">
							<img src="IMG/index/high1.png" width="24" height="24" />
						</div>
						<p class="zi">高中</p>
						<div class="course">
							<span class="ke">课程：</span>
							<ul>
								<li><a href="#">语文</a></li>
								<li><a href="#">数学</a></li>
								<li><a href="#">英语</a></li>
								<li><a href="#">物理</a></li>
								<li><a href="#">化学</a></li>
								<li><a href="#">生物</a></li>
								<li><a href="#">政治</a></li>
								<li><a href="#">地理</a></li>
								<li><a href="#">历史</a></li>
							</ul>
						</div>
					</li>
					<li class="menu-last">加入云学课堂，赢得精彩明天</li>
				</ul>
			</div>
			<div class="sel">
				<ul>
					<li class="on"></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>

	</div>


	<div class="content2" style="height: 520px;">
		<div class="wrapp">
			<div class="mingshi">
				<img src="IMG/index/mingshi.jpg" width="800" height="520" />
			</div>
			<div class="mingshi2">
				<p class="aa">99%名校师资+一线教研</p>
				<br /> <span class="a2">强强组合，层层筛选，助力起飞</span>
				<ul>
					<li><img src="IMG/index/item_r.png" width="16" height="16" />
						<span>&nbsp;&nbsp;<strong>名校师资:</strong></span>&nbsp;&nbsp;北大、清华等名校团队
					</li>
					<li><img src="IMG/index/item_r.png" width="16" height="16" />
						<span>&nbsp;&nbsp;<strong>状元坐镇:</strong></span>&nbsp;&nbsp;汇集近百名各地区高考状元
					</li>
					<li><img src="IMG/index/item_r.png" width="16" height="16" />
						<span>&nbsp;&nbsp;<strong>层层筛选:</strong></span>&nbsp;&nbsp;笔试、面试、试讲、考核四道关卡层层把关
					</li>
					<li><img src="IMG/index/item_r.png" width="16" height="16" />
						<span>&nbsp;&nbsp;<strong>一线教研:</strong></span>&nbsp;&nbsp;一线名师教研，诊断教学，个性化定制学习方案
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="content2" style="background-color: rgb(247, 247, 247)">
		<div class="wrap">
			<img src="IMG/index/biaoyu.PNG" width="1300" height="190" />
		</div>
	</div>

	<div class="wrap" style="height: 520px;">
		<video class="video" loop src="IMG/index/video.mp4" autoplay>
		</video>
		<div class="shh">
			<h3>师生面对面，真人直播互动</h3>
			<p>四路视频看、写、听、讲轻松自如，师生“面对面”学，高清习题手写演算，作业远程批改，老师“手把手”教。</p>
			<h3 style="margin-top: 70px;">家长手机旁听，随时随地参与</h3>
			<p>家长使用APP，随时随地参与课堂远程实时旁听，收取学习反馈。观看过程老师学生不受打扰，孩子学习状态一手掌握。</p>
			<h3 style="margin-top: 70px;">专属学管师全程跟踪，保障教学效果</h3>
			<p>7×24小时金牌学管师“管家式服务”，互联网+智能服务生态，学员安心，家长放心。</p>
		</div>
	</div>

	<div class="content2">
		<div class="wrap">
			<img src="IMG/index/banner1.jpg" width="1300" height="487" />
		</div>
	</div>

	<div class="content2" style="background-color: rgb(247, 247, 247)">
		<div class="wrap">
			<div class="biao">
				<a href="#" class="biaoyu">孩子提分，就现在！点击咨询免费课程</a>
			</div>
		</div>
	</div>

	<div class="service">
		<div class="s1">
			<i class="icon1" style="background-position: -58px -2px"> <em>在线咨询</em>
			</i>
		</div>
		<div class="s1">
			<i class="icon1" style="background-position: -2px -2px"> <em>意见反馈</em>
			</i>
		</div>
		<div class="s2" id="top" onclick="gotop();">
			<i class="icon1" style="background-position: -30px -2px"></i>
		</div>
	</div>

	<div class="sco0" id="bottomdiv2"></div>
	<div class="sco" id="bottomdiv">
		<div class="tiyan">
			<ul>
				<li style="width: 200px"><p>申请免费试听课</p></li>
				<li class="shuru"><input type="text" class="put"
					placeholder="   输入姓名" /></li>
				<li class="shuru"><input type="text" class="put"
					placeholder="   输入手机号" /></li>
				<li style="width: 210px"><input type="text" class="tijiao"
					value="立即申请" /></li>
				<li style="width: 270px"><p1>客服热线：400-888-888</p1></li>
			</ul>
		</div>
	</div>

	<jsp:include page="bottom.jsp" flush="true" />

</body>
</html>