$(function(){
	
	//phone
   $("#phone").blur(function(){//用户名文本框失去焦点触发验证事件
	  if(!$(this).val()||!(/^[1][3,4,5,7,8][0-9]{9}$/).test($(this).val())){
		 $("#cuo1").removeClass("wrong").addClass("wrong1");
		 
	  }else{
		  //用户名格式合法，判断是否已经被注册
		  $.post("kljson/stuPhoneExist.action", {stuPhone:$(this).val()}, 
		  function (result){  //参数不一定为result，他只是一个变量用来接收json类型数据
				  if ($.trim(result.regMsg)=="3"){
					  $("#phone").val("");
					  alert("您已注册");
				  }else if($.trim(result.regMsg)=="2"){
					  $("#phone").val("");
					  alert("您已是教师，不能再注册为学生");
				  }
			  });
	  }	  
  });
  $("#phone").focus(function(){
	  $("#cuo1").removeClass("wrong1").addClass("wrong");
  })
  
  //password
  $("#mima").blur(function(){
	  if(!$(this).val()||!(/^[a-zA-Z0-9]{6,16}$/).test($(this).val())){
		  $("#cuo2").removeClass("wrong").addClass("wrong1");
	  }
  }) 
  $("#mima").focus(function(){
	  $("#cuo2").removeClass("wrong1").addClass("wrong");
  })

  //check
  $("#remima").blur(function(){
	  if(!$(this).val||$("#mima").val() !== $(this).val()){
		  $("#cuo3").removeClass("wrong").addClass("wrong1");
	  }
  })
  $("#remima").focus(function(){
	  $("#cuo3").removeClass("wrong1").addClass("wrong");
  })

  
  
  $("#change").click(function(){
	  $("#tea").show("slow");
	  $("#stu").hide("slow");
  })
  
  $("#change2").click(function(){
	  $("#tea").hide("slow");
	  $("#stu").show("slow");
  })
  
  
  //phone
   $("#phone2").blur(function(){//用户名文本框失去焦点触发验证事件
	  if(!$(this).val()||!(/^[1][3,4,5,7,8][0-9]{9}$/).test($(this).val())){
		 $("#cuo12").removeClass("wrong").addClass("wrong1");
	  }else{
		  //用户名格式合法，判断是否已经被注册
		  $.post("kljson/teaPhoneExist.action", {teaPhone:$(this).val()},
		  function (result){  
			  if ($.trim(result.regMsg)=="2"){
				  $("#phone2").val("");
				  alert("您已注册，请直接登录");
			  }else if($.trim(result.regMsg)=="3"){
				  $("#phone2").val("");
				  alert("您已是学生，不能再注册为教师");
			  }
			  });
	  }	  
  });
  $("#phone2").focus(function(){
	  $("#cuo12").removeClass("wrong1").addClass("wrong");
  })
  
  //password
  $("#mima2").blur(function(){//用户名文本框失去焦点触发验证事件
	  if(!$(this).val()||!(/^[a-zA-Z0-9]{6,16}$/).test($(this).val())){
		  $("#cuo22").removeClass("wrong").addClass("wrong1");
	  }
  }) 
  $("#mima2").focus(function(){
	  $("#cuo22").removeClass("wrong1").addClass("wrong");
  })

  //check
  $("#remima2").blur(function(){//用户名文本框失去焦点触发验证事件
	  if(!$(this).val||$("#mima2").val() !== $(this).val()){
		  $("#cuo32").removeClass("wrong").addClass("wrong1");
	  }
  })
  $("#remima2").focus(function(){
	  $("#cuo32").removeClass("wrong1").addClass("wrong");
  })
  
  
  
})