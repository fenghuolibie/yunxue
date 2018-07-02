window.onload=function(){
	
	  first();
	

	  $("#a1").click(function(event){
			event.stopImmediatePropagation();
			$("#sel1").toggle();
			$("#sel2").hide();
			$("#sel3").hide();
	  });
			
	  $("#a2").click(function(event){
			event.stopImmediatePropagation();
			$("#sel2").toggle();
			$("#sel1").hide();
			$("#sel3").hide();
		});
		
	  $("#a3").click(function(event){
			event.stopImmediatePropagation();
			$("#sel3").toggle();
			$("#sel2").hide();
			$("#sel1").hide();
		});
	 
	  $(document).bind("click",function(){
			$("#sel1").hide();
			$("#sel2").hide();
			$("#sel3").hide();})
	  

		$("#sel1 ul li").each(function(){
			$(this).click(function(){
				$("#val1").html($(this).html());
				$("#year").val($("#val1").html());
				$("#sel1").hide();
			});
		});
	  

		$("#sel2 ul li").each(function(){
			$(this).click(function(){
				$("#val2").html($(this).html());
				$("#month").val($("#val2").html());
				$("#sel2").hide();
			});
		});
		
		
		$("#sel3 ul li").each(function(){
			$(this).click(function(){
				$("#val3").html($(this).html());
				$("#stage").val($("#val3").html());
				$("#sel3").hide();
			});
		});
		
	$(".stu-data2").click(function () {
		var top = $(window).height()/2 - $(".message-config").height()/2;   
		var left = $(window).width()/2 - $(".message-config").width()/2;   
		var scrollTop = $(document).scrollTop();   
		var scrollLeft = $(document).scrollLeft();   
		$(".can").css( {position: 'absolute',top:0,left:scrollLeft, width: $(document).width()
	    , height: $(document).height()}).show();
		$(".message-config").css({position:'absolute',top: top+scrollTop,left:left+scrollLeft,}).show(500);
    });
	$("#infochange").click(function () {
		var top = $(window).height()/2 - $(".message-config").height()/2;   
		var left = $(window).width()/2 - $(".message-config").width()/2;   
		var scrollTop = $(document).scrollTop();   
		var scrollLeft = $(document).scrollLeft();   
		$(".can").css( {position: 'absolute',top:0,left:scrollLeft, width: $(document).width()
	    , height: $(document).height()}).show();
		$(".message-config").css({position:'absolute',top: top+scrollTop,left:left+scrollLeft,}).show(500);
    });
    $("#close").click(function () {
        $(".can").fadeOut("slow");
		$(".message-config").fadeOut("slow");
    });
    
    
    var canvas = document.getElementById("container"),
    context = canvas.getContext("2d"),
    //文件服务器地址
    fileServer = "kl/stuImg",
    //适配环境，随时修改事件名称
    eventName = { down: "mousedown", move: "mousemove", up: "mouseup", click: "click" };
//////////canvas尺寸配置
var canvasConfig = {
    //容器canvas尺寸
    width: 150,
    height: 150,
    //原图放大/缩小
    zoom: 1,
    //图片对象
    img: null,
    //图片完整显示在canvas容器内的尺寸
    size: null,
    //图片绘制偏移，为了原图不移出框外，这个只能是负值or 0
    offset: { x: 0, y: 0 },
    //当前应用的滤镜
    filter: null
}
canvas.width = canvasConfig.width;
canvas.height = canvasConfig.height;
///////////设置选择工具配置
var config = {
    //图片选择框当前大小、最大大小、最小大小
    pickerSize: 50,

    x: canvas.width / 2 - 100 / 2,
    y: canvas.height / 2 - 100 / 2
}
/////////////结果canvas配置
var resCanvas = [$("#res1")[0].getContext("2d"), $("#res2")[0].getContext("2d"), $("#res3")[0].getContext("2d")];
//结果canvas尺寸配置
var resSize = [100, 50, 32]
resSize.forEach(function (size, i) {
    $("#res" + (i + 1))[0].width = 100;
    $("#res" + (i + 1))[0].height = 100;
});

//上传图片
$("#upload").on(eventName.click, function () {
    var imgData = $("#res1")[0].toDataURL("jpg");
    imgData = imgData.replace(/^data:image\/(png|jpg);base64,/, "");
    if (!fileServer) {
	//alert(imgData);
        alert("请配置文件服务器地址");
        return;
    }

    var blobBin = atob(imgData);
    var array = [];
    for (var i = 0; i < blobBin.length; i++) {
        array.push(blobBin.charCodeAt(i));
    }
    var blob = new Blob([new Uint8Array(array)], { type: 'image/jpg' });
    var file = new File([blob], "userlogo.jpg", { type: 'image/jpg' });
    var formdata = new FormData();
    formdata.append("userlogo", file);
    $.ajax({
        type: 'POST',
        url: fileServer,
        data: formdata,
        processData: false,
        contentType: false,
        success: function (result) {
        	if (result.msg!="") alert("头像上传成功");
        	else return;
        	$("#headtest").attr('src',msg);
        	$("#uploadres").val(msg);
        }
    });
});
//绑定选择图片事件
$("#fileinput").change(function () {
    var file = this.files[0],
        URL = (window.webkitURL || window.URL),
        url = URL.createObjectURL(file),
        img = new Image();
    img.src = url;
    img.onload = function () {
        canvasConfig.img = img;
        canvasConfig.size = getFixedSize(img, canvas);
        draw(context, img, canvasConfig.size);
        setPicker();
    }

});
//移动选择框
//绑定鼠标在选择工具上按下的事件
$("#picker").on(eventName.down, function (e) {
   e.stopPropagation();
   var start = { x: e.clientX, y: e.clientY, initX: config.x, initY: config.y };
   $("#canvasContainer").on(eventName.move, function (e) {
        // 将x、y限制在框内
     config.x = Math.min(Math.max(start.initX + e.clientX - start.x, 0), canvasConfig.width - 2*config.pickerSize);
     config.y = Math.min(Math.max(start.initY + e.clientY - start.y, 0), canvasConfig.height - 2*config.pickerSize);
     setPicker();
    })
});


$(document).on(eventName.up, function (e) {
    $("#canvasContainer").unbind(eventName.move);
})
//原图放大、缩小
$("#bigger").on(eventName.click, function () {
    canvasConfig.zoom = Math.min(3, canvasConfig.zoom + 0.1);
    //重绘蒙版
    draw(context, canvasConfig.img, canvasConfig.size);
})
$("#smaller").on(eventName.click, function () {
    canvasConfig.zoom = Math.max(0.4, canvasConfig.zoom - 0.1);
    //重绘蒙版
    draw(context, canvasConfig.img, canvasConfig.size);
})

// 定位选择工具
function setPicker() {
    $("#picker").css({
        width: 100 + "px", height: 100 + "px",
        top: config.y, left: config.x
    });
    //重绘蒙版
    draw(context, canvasConfig.img, canvasConfig.size);
}
//绘制canvas中的图片和蒙版
function draw(context, img, size) {
    var pickerSize = config.pickerSize,
        zoom = canvasConfig.zoom,
        offset = canvasConfig.offset;
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.drawImage(img, 0, 0, img.width, img.height, offset.x, offset.y, size.width * zoom, size.height * zoom);
    //绘制挖洞后的蒙版
    context.save();
    context.beginPath();
    pathRect(context, config.x, config.y, 100, 100);
    context.rect(0, 0, canvas.width, canvas.height);
    context.closePath();
    context.fillStyle = "rgba(255,255,255,0.3)";
    context.fill();
    context.restore();
    //绘制结果
    var imageData = context.getImageData(config.x, config.y, 100, 100)
    resCanvas.forEach(function (resContext, i) {
        resContext.clearRect(0, 0, 100, 100);
        resContext.drawImage(canvas, config.x, config.y, 100, 100, 0, 0, 100,100);
     
    });
}
//逆时针用路径自己来绘制矩形，这样可以控制方向，以便挖洞
// 起点x，起点y，宽度，高度
function pathRect(context, x, y, width, height) {
    context.moveTo(x, y);
    context.lineTo(x, y + height);
    context.lineTo(x + width, y + height);
    context.lineTo(x + width, y);
    context.lineTo(x, y);
}
// 根据图片和canvas的尺寸，确定图片显示在canvas中的尺寸
function getFixedSize(img, canvas) {
    var cancasRate = canvas.width / canvas.height,
        imgRate = img.width / img.height, width = img.width, height = img.height;
    if (cancasRate >= imgRate && img.height > canvas.height) {
        height = canvas.height;
        width = imgRate * height;
    }
    else if (cancasRate < imgRate && img.width > canvas.width) {
        width = canvas.width;
        height = width / imgRate;
    }
    return { width: width, height: height };
}    
}

function first(){
	
	  var birth=$("#birth").val();
	  var y=birth.substr(0,4);
	  var m=birth.substr(5);
	  $("#year").val(y);
	  $("#month").val(m);
	  $("#val1").html(y);
	  $("#val2").html(m);
	  
	  var s=$("#sex").val();
	  if(s.indexOf("男")>=0){
		  $("#nan").attr("checked","checked");
	  }
	  else if(s.indexOf("女")>=0){
		  $("#nv").attr("checked","checked");
	  }
	  else if(s==""){}
	  
	  var infoNum=0;
	  $("input:hidden").each(function(){
		  if($(this).val()!=""){
			  infoNum+=1;
		  }
	  });
	  infoNum=infoNum-4;
	  var integrity=infoNum*10+"%";
	  $("#integrity").html(integrity);
	  $("#line2").css("width",integrity);
	  if(infoNum==10){
		  $("#data2").text("更新资料");
	  }
	  else{
		  $("#data2").text("完善资料");
	  }
	  
}