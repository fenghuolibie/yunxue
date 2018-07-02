function search(){
	$(this).parent().parent("div").find("a").removeClass("active");
	$(this).addClass("active");
	var seqe={
		智能排序:null,
		人气:"teacherSatisfaction",
		评价数:null,
		价格:"teacherMoney"
	}
	var search={
		stage:$(".stage").find("a.active").text()=="全部"?null:$(".stage").find("a.active").text(),
		grade:$(".grade").find("a.active").text()=="全部"?null:$(".grade").find("a.active").text(),
		subject:$(".subject").find("a.active").text()=="全部"?null:$(".subject").find("a.active").text(),
		sex:$(".sex").find("a.active").text()=="全部"?null:$(".sex").find("a.active").text(),
		sort:seqe[$(".sort").find("a.active").text()]
	}
	if(window.location.search!=""){
		var p=window.location.search.substring(1);
		var vars=p.split("&");
		for(var i =0;i<vars.length;i++){
			var s=vars[i].split("=");
			search[s[0]]=decodeURI(s[1]);
		}
	}
	$.ajax({
		url:'/yunxue_ssh/kl/teaQuerry.action',
		data:search,
		type:'POST',
		dataType:'html',
		traditional: true,
		success:function(data){
			var Obj = $("<code></code>").append($(data));//包装数据  
	        //(需要获取的对应块（如class='aa')  
	        var $html = $(".course-list-left", Obj);     
	        //获取对应块中的内容  
	        var value = $html.html(); 
			$('.course-list-left').html(value);
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
			alert("您的操作太快了，请重试");
		}
	})
//	alert(JSON.stringify(search));
}