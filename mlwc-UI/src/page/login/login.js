layui.config({
	base : BASE_PATH + "/js/"
}).use(['form','layer'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		$ = layui.jquery;
	//video背景
	$(window).resize(function(){
		if($(".video-player").width() > $(window).width()){
			$(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}else{
			$(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
		}
	}).resize();
	
	//登录按钮事件
	form.on("submit(login)",function(data){
		$.ajax({
			url:BASE_PATH + 'sso/user',
			type:'post',
			data:{
				username:$("#username").val(),
				password:$("#password").val()
			}
		})
		window.location.href = BASE_PATH + "/sso/user";
		return false;
	})
})
