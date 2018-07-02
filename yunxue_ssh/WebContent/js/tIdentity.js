window.onload=function(){
    
	var canvas = document.getElementById("container"),
    context = canvas.getContext("2d"),
    //文件服务器地址
    fileServer = "ssjson/teaImgupload.action",
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
    var imgData = $("#res1")[0].toDataURL("png");
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
    var blob = new Blob([new Uint8Array(array)], { type: 'image/png' });
    var file = new File([blob], "userlogo.png", { type: 'image/png' });
    var formdata = new FormData();
    formdata.append("userlogo", file);
    $.ajax({
        type: 'POST',
        url: fileServer,
        data: formdata,
        processData: false,
        contentType: false,
        success: function (msg) {
        	if (msg!="") alert("头像上传成功");
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
 //   alert(img.width);
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
			$("#tEducation").val($("#val3").html());
			$("#sel3").hide();
		});
	});

  
    $(".input1").focus(function(){
		$(this).css("border","1px solid #00c5ef");
		});
	
	$(".input1").blur(function(){
		$(this).css("border","#eee solid 1px");
		});
	
		

	
	
	var canvas2 = document.getElementById("container2"),
    context2 = canvas2.getContext("2d"),

    eventName2 = { down: "mousedown", move: "mousemove", up: "mouseup", click: "click" };

    var canvasConfig2 = {
		
        width: 800,
        height: 400,
        zoom: 1,
        img: null,
        size: null,
        offset: { x: 0, y: 0 },}
        canvas2.width = canvasConfig2.width;
        canvas2.height = canvasConfig2.height;
		
        var config2 = {
            pickerSize: 50,
            x: canvas2.width / 2 - 100 / 2,
            y: canvas2.height / 2 - 100 / 2}

        var resCanvas2 = [$("#res4")[0].getContext("2d"), $("#res5")[0].getContext("2d"), $("#res6")[0].getContext("2d")];
//结果canvas尺寸配置
       var resSize2 = [100, 50, 32]
       resSize2.forEach(function (size, i) {
       $("#res" + (i + 3))[0].width = 800;
       $("#res" + (i + 3))[0].height = 400;});


//绑定选择图片事件
$("#fileinput2").change(function () {
    var file = this.files[0],
        URL = (window.webkitURL || window.URL),
        url = URL.createObjectURL(file),
        img = new Image();
        img.src = url;
        img.onload = function () {
        canvasConfig2.img = img;
        canvasConfig2.size = getFixedSize(img, canvas2);
        draw2(context2, img, canvasConfig2.size);
    }
});

$(document).on(eventName.up, function (e) {
    $("#canvasContainer2").unbind(eventName.move);
})

function draw2(context, img, size) {
    var pickerSize = config.pickerSize,
        zoom = canvasConfig.zoom,
        offset = canvasConfig.offset;
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.drawImage(img, 0, 0, img.width, img.height, offset.x, offset.y, size.width * zoom, size.height * zoom);
}

var canvas3 = document.getElementById("container3"),
    context3 = canvas3.getContext("2d"),

    eventName3 = { down: "mousedown", move: "mousemove", up: "mouseup", click: "click" };

    var canvasConfig3 = {
		
        width: 800,
        height: 400,
        zoom: 1,
        img: null,
        size: null,
        offset: { x: 0, y: 0 },}
        canvas3.width = canvasConfig3.width;
        canvas3.height = canvasConfig3.height;

        var resCanvas3 = [$("#res7")[0].getContext("2d"), $("#res8")[0].getContext("2d"), $("#res9")[0].getContext("2d")];
//结果canvas尺寸配置
       var resSize3 = [100, 50, 32]
       resSize3.forEach(function (size, i) {
       $("#res" + (i + 6))[0].width = 800;
       $("#res" + (i + 6))[0].height = 400;});


//绑定选择图片事件
$("#fileinput3").change(function () {
    var file = this.files[0],
        URL = (window.webkitURL || window.URL),
        url = URL.createObjectURL(file),
        img = new Image();
        img.src = url;
        img.onload = function () {
        canvasConfig3.img = img;
        canvasConfig3.size = getFixedSize(img, canvas3);
        draw2(context3, img, canvasConfig3.size);
    }
});

$(document).on(eventName.up, function (e) {
    $("#canvasContainer3").unbind(eventName.move);
})

 
}


function step1(){
	if($(".info input").val()!=""){
		$.post("kl/teaIdentityFirst.action",{
			imgurl:$("#uploadres").val(),
			teaName:$("#tname").val(),
			year:$("#year").val(),
			sex:$("input[name='sex']:checked").val(),
			teaEducation:$("#tEducation").val(),
			teaSchool:$("#tschool").val(),
			teaMajor:$("#tmajor").val(),
			teaArea:$("#tarea").val(),
			teaDescription:$("#tDescription").val(),
			teaExperience:$("#tExperience").val(),
			teaIdCard:$("#tIdcard").val()},
			function(result){
				 if($.trim(result.markMsg)=="fillok"){
				     $("#step1").hide();
			         $("#step2").show();
			         $('html,body').animate({scrollTop:0},300);
			        }else{
			        	alert(result.markMsg);
			        }
			});
		}
	else{
		alert("请填写完所有信息！");}
	}
