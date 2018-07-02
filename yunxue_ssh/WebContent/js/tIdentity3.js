

	  
//	  $("table tr td span").children("input:visible").each(function() {
//		 $(this).click(function(){
//			     obj=$(this).next("input:hidden");
//				 $.post("http://localhost:8080/YunXue/ssjson/plan",{
//					 classno:$(this).val(),
//					 check:$(this).next("input:hidden").val()},
//					 function(result){
//						 if($.trim(result.planMsg)=="1"){
//						     obj.val("1");
//						     change();
//						 }
//						 else{
//							 obj.val("0");
//						     change();
//						 }
//					 }); 
//
//			 });
//	  });

$(function(){
	 $("table tr td span").children("input:hidden").each(function() {
		 if($(this).val()=="1"){
			 $(this).closest("span").removeClass("checkpic");
		     $(this).closest("span").addClass("checkpic2"); 
		 }
		 else{
			 $(this).closest("span").removeClass("checkpic2");
		     $(this).closest("span").addClass("checkpic");  
		 }
	 });
})