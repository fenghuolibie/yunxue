/**
 * 
 */
window.onload=function(){
	tab1();
	tab2();
	tab3();
	
	$("#a1").click(function(event){
		event.stopImmediatePropagation();
		$("#sel1").toggle();
		});
		
	$("#a2").click(function(event){
		event.stopImmediatePropagation();
		$("#sel2").toggle();
	    if($("#val1").html()=="小学"){
		  $("#grade1").show();
		  $("#grade2").hide();
		  $("#grade3").hide();
	    }
	    else if($("#val1").html()=="初中"){
	      $("#grade2").show();
		  $("#grade1").hide();
		  $("#grade3").hide();
	    }
	    else if($("#val1").html()=="高中"){
		  $("#grade3").show();
		  $("#grade2").hide();
		  $("#grade1").hide();
	    }
	    else{
		  $("#grade2").hide();
		  $("#grade1").hide();
		  $("#grade3").hide();
		  alert("请先选择学生阶段！");
	    }
     });
		
	$("#a3").click(function(event){
		event.stopImmediatePropagation();
		$("#sel1").hide();
		$("#sel2").hide();
		$("#sel3").hide();
		$("#sel3").toggle();
		});
	$(document).bind("click",function(){
		$("#sel1").hide();
		$("#sel2").hide();
		$("#sel3").hide();
		});
		
}

function tab1(){
	$("#sel1 ul li").each(function(){
		$(this).click(function(){
			$("#val1").html($(this).children("span").html());
			$("#sel1").hide();
			
			if($("#val1").html()=="小学"){
				$("#val2").html("小学一年级");
				}
			else if($("#val1").html()=="初中"){
				$("#val2").html("初一");
				}
			else if($("#val1").html()=="高中"){
				$("#val2").html("高一");
				}
				price();	
		});
	});
}

function tab2(){
	$("#sel2 ul li").each(function(){
		$(this).click(function(){
			$("#val2").html($(this).children().html());
			$("#sel2").hide();
		});
	});
}

function tab3(){
	$("#sel3 ul li").each(function(){
		$(this).click(function(){
			$("#val3").html($(this).children().html());
			$("#sel3").hide();
			price();
		});
	});
}

function price(){
	var data1=$("#val1").html();
	var data3=$("#val3").html();
	
	if(data1=="小学"&&data3=="50"){
		$("#val4").html("1000");
		$("#val5").html("1050");
		}
	else if(data1=="小学"&&data3=="100"){
		$("#val4").html("2000");
		$("#val5").html("2100");
		}
	else if(data1=="小学"&&data3=="150"){
		$("#val4").html("3000");
		$("#val5").html("3150");
		}
	else if(data1=="初中"&&data3=="50"){
		$("#val4").html("1200");
		$("#val5").html("1250");
		}
	else if(data1=="初中"&&data3=="100"){
		$("#val4").html("2400");
		$("#val5").html("2500");
		}
	else if(data1=="初中"&&data3=="150"){
		$("#val4").html("3600");
		$("#val5").html("3750");
		}
	else if(data1=="高中"&&data3=="50"){
		$("#val4").html("1500");
		$("#val5").html("1550");
		}
	else if(data1=="高中"&&data3=="100"){
		$("#val4").html("3000");
		$("#val5").html("3100");
		}
	else if(data1=="高中"&&data3=="150"){
		$("#val4").html("4500");
		$("#val5").html("4650");
		}
	else{
		$("#val4").html("");}

	}

//点击购买按钮后

  function buy1(){
	  
	if($("#val4").html()==""){
		  alert("请选择相关信息！");
		  }
	else{
	  
	  $("#box1").html($("#val1").html());
	  $("#box2").html($("#val2").html());
	  $("#box3").html($("#val3").html());
	  $("#box4").html($("#val4").html());
	  $("#box5").html($("#val5").html());
	  $("#box6").html($("#val1").html());
	  $("#box7").html($("#val2").html());
	  if($("#val3").html()=="50"){
		  $("#box8").html("4");
		  $("#box9").html("100");
		  $("#box10").html("100");
		  }
	  else if($("#val3").html()=="100"){
		  $("#box8").html("10");
		  $("#box9").html("250");
		  $("#box10").html("250");
		  }
	  else if($("#val3").html()=="150"){
		  $("#box8").html("16");
		  $("#box9").html("400");
		  $("#box10").html("400");
		  }
	  else if($("#val3").html()=="200"){
		  $("#box8").html("24");
		  $("#box9").html("600");
		  $("#box10").html("600");
		  }
	  else{
		  $("#box8").html("");
		  $("#box9").html("");
		  $("#box10").html("");
		  }
		  
	  $("#buyprocess1").hide();
	  $("#buyprocess2").show();
	  
	  $(".buy ul li").removeClass("state").eq(2).addClass("state");
	  
	  $("#context1").val($("#box1").html());
	  $("#context2").val($("#box2").html());
	  $("#context3").val($("#box3").html());
	  $("#context4").val($("#box4").html());
	  $("#context5").val($("#box5").html());
	  $("#context8").val($("#box8").html());
	  $("#context10").val($("#box10").html());
	}
 }

function returnbuy(){
	$("#buyprocess1").show();
	$("#buyprocess2").hide();
    $(".buy ul li").removeClass("state").eq(0).addClass("state");
	}



//点击确认订单后

  function buy2(){
	  
	  $(".buy ul li").removeClass("state").eq(4).addClass("state");
	  $("#buyprocess1").hide();
	  $("#buyprocess3").show();
	  $("#buyprocess2").hide();
	  
	  $(".list1 li").each(function(){
		  $(this).click(function(){
			  $(".list1 li").removeClass("current");
			  $(this).addClass("current");
			  $(".list1 li img").removeClass("listimg2");
			  $(".list1 li").removeClass("listimg2");
			  $(this).addClass("listimg2");
			  $(this).children('img').addClass("listimg2");
			  });
		  });
	  $("#context10").val($("#bi").html());
	  }


//点击确认支付后
   
  function buyok(){

	  $.post("kl/buyClassSuccess.action",{
          stuNo:$("#context0").val(),
		  bi:$("#context10").val(),
		  buyNo:$("#buyno").val()},
		  function(result){  
			  alert(result.buyMsg);
			  if ($.trim(result.buyMsg)=="ok"){
				  
				  $(".buy ul li").removeClass("state").eq(6).addClass("state");
				  if($(".list1 li").hasClass("current")){
				  var top = ($(window).height() - $(".success").height())/2;   
				  var left = ($(window).width() - $(".success").width())/2;   
				  var scrollTop = $(document).scrollTop();   
				  var scrollLeft = $(document).scrollLeft();   
				  $(".success0").css( {position: 'absolute',top:0,left:scrollLeft, width: $(document).width()
				  , height: $(document).height()}).show();
				  $(".success").css({position:'absolute',top: top+scrollTop,left:left+scrollLeft,}).show(500);  
				  }
				  else{
					  alert("请选择支付方式！");}
			  }
			  else{
				  alert("购买失败！");
			  }
		  });
  }
  