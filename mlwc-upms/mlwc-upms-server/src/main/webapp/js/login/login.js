layui.config({
    base: BASE_PATH + "/js/"
}).use(['layer'], function () {
    $ = layui.jquery;
    //video背景
    $(window).resize(function () {
        if ($(".video-player").width() > $(window).width()) {
            $(".video-player").css({
                "height": $(window).height(),
                "width": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        } else {
            $(".video-player").css({
                "width": $(window).width(),
                "height": "auto",
                "left": -($(".video-player").width() - $(window).width()) / 2
            });
        }
    }).resize();
})

//登录按钮事件
function login() {
    $.ajax({
        url: BASE_PATH + '/sso/login',
        type: 'post',
        data: {
            username: $("#username").val(),
            password: $("#password").val()
        },
        success: function (data) {
            console.log(data);
            if (data != '') {
                location.href = BASE_PATH + "/resources/mlwc-ui/page/main.html";
            } else {
                layer.alert("error");
            }
        },
        error: function (error) {
            console.log(error);
        }
    })
}
