// JavaScript Document
$(function(){
	$(".sidebar-box li").each(function(index){
		$(".sidebar-box li").eq(index).mouseover(function(){
		$(".border").eq(index).css({"transform": "scaleX(1.6)"});
	    }).mouseout(function(){
		$(".border").eq(index).css({"transform": "scaleX(1)"});
	    })
	})
	//错误
})

