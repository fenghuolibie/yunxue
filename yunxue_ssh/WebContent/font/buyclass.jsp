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
<link type="text/css"  href="css/buyclass.css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery v3.2.1.min.js"></script>
<script type="text/javascript" src="js/buyclass.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BuyClass</title>
</head>
<body>
<c:choose>
<c:when test="${flag==true}" >
<script type="text/javascript">
$(document).ready(function(){
	$(".nav1 ul li").removeClass("cur").eq(3).addClass("cur");
	buy2();
});
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
$(document).ready(function(){
	$(".nav1 ul li").removeClass("cur").eq(3).addClass("cur");
});
</script>
</c:otherwise>
</c:choose> 
<jsp:include page="nav.jsp" flush="true"/>

<div class="buy">
  <ul>
	  <li class="state">购买课时</li>
	  <li class="righticon"><img src="IMG/buyclass/right-bold.png"/></li> 
	  <li>确定购买信息</li>
	  <li class="righticon"><img src="IMG/buyclass/right-bold.png"/></li>
	  <li>选择支付方式</li>
	  <li class="righticon"><img src="IMG/buyclass/right-bold.png"/></li>
	  <li>购买成功</li>
  </ul>
</div>

<div class="buyclass" id="buyprocess1">
  <p>购买课时</p>
  <ul class="buynav">
      <li>学生阶段</li>
      <li>年级</li>
      <li>课时数</li>
      <li>价格/元</li>
      <li>云币</li>
  </ul>
  
  <div class="selectClass">
      <div class="select">
        <div class="selectValue"  id="val1">选择阶段</div>
        <img src="IMG/buyclass/down.png" id="a1">
        <div class="sel-option" id="sel1">
          <ul>
            <li><span>小学</span></li><li><span>初中</span></li><li><span>高中</span></li>
          </ul>
        </div>
      </div>
  
      <div class="select2">
        <div class="selectValue" id="val2" >选择年级</div>
        <img src="IMG/buyclass/down.png" id="a2">
        <div class="sel-option" id="sel2">
          <ul id="grade1">
            <li><span>小学一年级</span></li><li><span>小学二年级</span></li>
            <li><span>小学三年级</span></li><li><span>小学四年级</span></li>
            <li><span>小学五年级</span></li><li><span>小学六年级</span></li>
          </ul>
          <ul id="grade2">
            <li><span>初一</span></li><li><span>初二</span></li>
            <li><span>初三</span></li>       
          </ul>
          <ul id="grade3">
            <li><span>高一</span></li><li><span>高二</span></li>
            <li><span>高三</span></li>
          </ul>
        </div>
      </div>
   
      <div class="select2">
        <div class="selectValue" id="val3" >选择课时数</div>
        <img src="IMG/buyclass/down.png" id="a3">
        <div class="sel-option" id="sel3">
          <ul>
            <li><span>50</span></li><li><span>100</span></li>
            <li><span>150</span></li>
          </ul>
        </div>
      </div>
      
      <div class="select2"> 
        <div class="selectValue" id="val4" ></div>
      </div>
      
      <div class="select2">
        <div class="selectValue" id="val5" ></div>
      </div>
  </div>
  
  <div class="tip">
    <p>学生须知：</p>
    <p2>1、一节课时等于一个小时课程</p2><br>
    <p2>2、云币为云学网通用虚拟币，预约教师上课会消耗一定数额的云币</p2>
  </div>
  
  <span class="buy_btn" id="buy_btn" onClick="buy1()">点击购买</span>
  
</div>

<div class="buyclass" style="display:none;" id="buyprocess2">
  <p>确认购买信息</p>
  <ul class="buynav">
      <li>学生阶段</li>
      <li>年级</li>
      <li>课时数</li>
      <li>价格/元</li>
      <li>云币</li>
  </ul>
 <form action="kl/buyClassOrder" method="post">
  <div class="queren">
    <input type="hidden" id="context1" name="box1"/><div class="queren_box" id="box1"></div>
    <input type="hidden" id="context2" name="box2"/><div class="queren_box" style="margin-left:130px;" id="box2"></div>
    <input type="hidden" id="context3" name="box3"/><div class="queren_box" style="margin-left:130px;" id="box3"></div>
    <input type="hidden" id="context4" name="box4"/><div class="queren_box" style="margin-left:130px;" id="box4"></div>
    <input type="hidden" id="context5" name="box5"/><div class="queren_box" style="margin-left:130px;" id="box5"></div>
  </div>
  
  <ul class="buynav" style="margin-top:20px;">
      <li>学生阶段</li>
      <li>年级</li>
      <li>课时数</li>
      <li>赠送价值</li>
      <li>赠送云币</li>
  </ul>
  <div class="queren">
    <div class="queren_box" id="box6"></div>
    <div class="queren_box" style="margin-left:130px;" id="box7"></div>
    <input type="hidden" id="context8" name="box8"/><div class="queren_box" style="margin-left:130px;" id="box8"></div>
    <div class="queren_box" style="margin-left:130px; color:red;" id="box9"></div>
    <div class="queren_box" style="margin-left:130px; color:red;" id="box10"></div>
    <input type="hidden" id="context10" name="box10"/><div class="gift">赠送</div>
  </div>
  
  <input type="submit" style="width:130px;height:55px; padding:0;" class="buy_btn" value="确认订单" />
  </form>
  <span style="float:right;margin-right:50px;cursor:pointer;margin-top:100px;color:blue;" onClick="returnbuy()">返回</span>
  
</div>


<div class="buyclass" style="display:none; height:900px;" id="buyprocess3">
  <form action="kl/buyClassSuccess.action" method="post">
  <div class="item-top">
   <span class="item">订单已提交，请您尽快付款！订单号： ${buyNo}<br><input type="hidden" id="buyno" value="${buyNo}" name="buyNo">
  <span style="font-weight:normal;font-size:13px;">请您在订单提交后尽快完成支付，云学网提供在线支付保障请您放心购买。
  </span>
   </span>
   <div class="itemright">应付款：<span class="item2">￥</span><span class="item2" id="item2">${box4}</span></div>
  </div>
  
  <div class="buynav" style="margin-bottom:0px;">
    <span class="buymethod">选择支付方式</span>
  </div>
  <ul class="list1">
    <li>
      <img src="IMG/buyclass/recharge8.png" width="157" height="40" class="listimg">
      <span class="listspan">可用余额￥0.00</span>
    </li>
    <li>
       <img src="IMG/buyclass/recharge1.png" width="157" height="40" class="listimg">
    </li>
    <li>
       <img src="IMG/buyclass/recharge2.png" width="157" height="40" class="listimg">
    </li>
    <li>
       <img src="IMG/buyclass/recharge3.png" width="157" height="40" class="listimg">
    </li>
    <li>
       <img src="IMG/buyclass/recharge4.png" width="157" height="40" class="listimg">
    </li>
  </ul>
  
  <div class="buynav" style="margin-bottom:0px; margin-top:20px;">
    <span class="buymethod">使用优惠券</span>
  </div>
  <div class="list2">
       <p>没有查询到相关的优惠券</p>
  </div>
  
  <div class="pay">
    <div class="pay-box">
    <span class="pay1">课时总价：</span><span class="pay2">￥</span><span class="pay2" id="pp">${box4}</span>
    <span class="pay1" style="margin-left:20px;">可得云币：</span>
    <input type="hidden" id="context10" name="bi" value="${yunbi}"><span class="pay2" id="bi">${yunbi}</span>
    <span class="pay3">应付款：</span><span class="pay4">￥</span><span class="pay4" id="id4" >${box4}</span>
    <span class="paybtn" onclick="buyok()">确认支付</span>
    </div>
  </div>
  </form> 
  <div class="success0">
  </div>
  <div class="success">
    <div class="su1"><img src="IMG/buyclass/correct.png" width="100" height="100"></div>
    <div class="su2">购买成功！</div>
     <a href="font/index.jsp" class="su3">前往主页</a>
     <a href="font/stuLogin.jsp" class="su3" style="margin-left:60px;">个人中心</a>
  </div>
   
</div>
<jsp:include page="bottom.jsp" flush="true"/>

</body>
</html>