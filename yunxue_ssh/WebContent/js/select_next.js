function tabactive(){
	$(".tabs .active").removeClass("active");
	$(this).addClass("active");
	str="";
	for(var i in classname[$(this).text()]){
		str+="<span >"+classname[$(this).text()][i]+"</span>";
	}
	$(".subject").html(str);
	$(".subject span").on("click",subactive);
}
function subactive(){
	$(".subject .active").removeClass("active");
	$(this).addClass("active");
}
function confirmselect(o){
	var no=[];
	var name=[];
	$("table .select").each(function (){
		no.push($(this).children("span").attr('class'));
		name.push($(this).children("span").text());
	})
	if(no.length==0){
		alert("请先选择课程");
	}else{
		$.ajax({
			url:'kl/classSave',
			data:{"no":no,"name":name},
			type:'POST',
			traditional: true,
			success:function(data){
				alert("预约成功");
//				$(".page-mask").css("display","block");
//				$(".page-mask").text(data);
			},
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				alert("可能已经有别的同学预约了相同课程，请刷新试试");
			}
		})
	}
}
function appoint(){
//	alert("");
	if($(".tabs span").hasClass("active")&&$(".subject span").hasClass("active")){
		if($(this).hasClass("select")){
			$(this).removeClass("select").css({"opacity":"1","font-size":"18px"}).find("span").text("预约");
		}
		else{
			var s=$(".tabs .active").text()+$(".subject .active").text();
			$(this).addClass("select").css({"opacity":"0.5","font-size":"18px"}).find("span").text(s);
		}
	}
	else{
		alert("您还未选择课程,请先选择课程");
	}
}
function closemask(){
	$(".page-mask").css("display","none");
}

