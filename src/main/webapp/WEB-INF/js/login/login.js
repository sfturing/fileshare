/**
 * Created by xiaohaoshi on 2017/8/24.
 */
//非ajax提交
var handler1 = function (captchaObj) {
    $("#submit1").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            $("#notice1").show();
            setTimeout(function () {
                $("#notice1").hide();
            }, 2000);
            e.preventDefault();
        }
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });
    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
};
$.ajax({
    url: "StartCaptcha?t=" + (new Date()).getTime(), // 加随机数防止缓存
    type: "get",
    dataType: "json",
    success: function (data) {
        // 调用 initGeetest 初始化参数
        // 参数1：配置参数
        // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
        initGeetest({
            gt: data.gt,
            challenge: data.challenge,
            new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
            offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            product: "float", // 产品形式，包括：float，popup
            width: "100%"
            // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
        }, handler1);
    }
});


/*//ajax提交


var handler2 = function (captchaObj) {
    $("#submit2").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            $("#notice2").show();
            setTimeout(function () {
                $("#notice2").hide();
            }, 2000);
        } else {
            $.ajax({
                url: 'gt/ajax-validate2',
                type: 'POST',
                dataType: 'json',
                data: {
                    username: $('#username2').val(),
                    password: $('#password2').val(),
                    geetest_challenge: result.geetest_challenge,
                    geetest_validate: result.geetest_validate,
                    geetest_seccode: result.geetest_seccode
                },
                success: function (data) {
                    if (data.status === 'success') {
                        alert('登录成功');
                    } else if (data.status === 'fail') {
                        alert('登录失败');
                    }
                }
            })
        }
        e.preventDefault();
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha2");
    captchaObj.onReady(function () {
        $("#wait2").hide();
    });
    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
};
$.ajax({
    url: "gt/register2?t=" + (new Date()).getTime(), // 加随机数防止缓存
    type: "get",
    dataType: "json",
    success: function (data) {
        // 调用 initGeetest 初始化参数
        // 参数1：配置参数
        // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
        initGeetest({
            gt: data.gt,
            challenge: data.challenge,
            new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
            offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            product: "popup", // 产品形式，包括：float，popup
            width: "100%"
            // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
        }, handler2);
    }
});*/
