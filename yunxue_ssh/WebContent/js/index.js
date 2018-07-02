//轮播图左右箭头
function turnicon(){
	$("#turnleft").css("opacity","1");
	$("#turnright").css("opacity","1");}

function outicon(){
	$("#turnleft").css("opacity","0");
	$("#turnright").css("opacity","0");}


window.onload=function(){
	
	fudong();
	
	
	//轮播图
	var i,left,right,box,boxli,boxleng,width,dot,first,last,IsAuto;
	i = 0;    
	left = $("#turnleft"); 	
	right = $("#turnright");	
	box = $(".content ul");	
	boxli = $(".content li");	
	dotbox = $(".sel ul");	
	dot = $(".sel ul li");	
	width = boxli.width();	
	boxleng = boxli.length;	
	boxli.css({width:width});	
	dot.eq(0).addClass("on");
	boxli.eq(0).addClass("bar1");
		
	boxli.each(function(index) {
       zindex = boxleng-(index+1);
	   $(this).css({"z-index":zindex})
    });
	
	IsAuto = true;

	left.click(function(){
		if(box.is(":animated")){return}
		i--;
		if(i<0){i=boxleng-1};
		boxanimate();
		
	})
	
	right.click(function(){
		if(box.is(":animated")){return}
		i++;
		boxanimate();
	})
	
	function boxanimate(){
		if(i>boxleng-1){i=0}		
		boxli.addClass("bar");
		setTimeout(function(){
			boxli.removeClass("bar");
			boxli.removeClass("bar1").eq(i).addClass("bar1");
			boxli.stop().animate({opacity:0,"z-index":"1"},300).eq(i).stop().animate({opacity:1,"z-index":boxleng},300);
			bannerdot(i)
		},100)	
	}
	
	function bannerdot(i){
		if(i>boxleng-1){i=0}
		dot.removeClass("on").eq(i).addClass("on");
	}

	dot.mouseenter(function(){
		i = $(this).index();
		bannerdot(i);
		boxanimate(i);
	})
	
	setInterval(function(){
		if(IsAuto){
			i++;
			boxanimate();
			bannerdot(i)
		}
	},2000)
	
	box.hover(function(){
		IsAuto = false;
	},function(){
		IsAuto = true;
	})
	
	dotbox.hover(function(){
		IsAuto = false;
	},function(){
		IsAuto = true;
	})
	
	left.hover(function(){
		IsAuto = false;
	},function(){
		IsAuto = true;
	})
	
	right.hover(function(){
		IsAuto = false;
	},function(){
		IsAuto = true;
	})
	
	
//“获取体验课”浮动栏

	//处理加载、刷新页面后
 function fudong(){
	   
	var rollSet = $('#bottomdiv');
    var offset = rollSet.offset();                     //获取加载出页面后浮动栏当前位置
	var scrollTop = $(window).scrollTop();            //滚动条滚动了的高度
	var fwidth = $(".help2").height()+$(".bottom").height();    //想要停止滚动位置距底部的距离
	var scrollBtm = $(document).height() - fwidth-$(window).height(); 
	  //html内容高度-底部距离-当前电脑屏幕可视化页面高度
	if(offset.top>scrollBtm){  
		rollSet.removeClass('sco').addClass('sco1');}
	
    //处理滚动页面后
    $(window).scroll(function() {
        var scrollTop = $(window).scrollTop();
        if (scrollTop <=scrollBtm) {     //浮动栏处于停止移动位置上方时
			   $("#bottomdiv2").show();
                rollSet.removeClass('sco1').addClass('sco');
        } else {
			 $("#bottomdiv2").hide();
            rollSet.removeClass('sco').addClass('sco1');
        }
		
	
	//当滚动高度大于200px时“回到顶部”按钮出现
	if(scrollTop>200){
		$("#top").fadeIn(500);}
		else{
			$("#top").fadeOut(500);}
    });
	
 }


  //当浏览器进行比例缩放后
  window.onresize=function(){
	  fudong();
	  }
  
  
}
	//回到页面顶部
	function gotop(){
	 $('html,body').animate({scrollTop:0},500);}