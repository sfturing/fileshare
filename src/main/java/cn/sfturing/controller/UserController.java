package cn.sfturing.controller;

import cn.sfturing.jdk.GeetVerify;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by Shi Xiaohao on 2017/8/14 下午12:51.
 * E-mail:sfturing@gamil.com
 * version:1.0
 */
@Controller
public class UserController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexLogin() {
        return "login/login";
    }

    @ResponseBody
    @RequestMapping(value = "/StartCaptcha")
    /**
     * @ClassName:UserController
     * @Description:geetest验证的首次验证请求，能够成功的加载验证码。
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/8/26 下午11:08
     */
    public String StartCaptcha(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        String resStr = "{}";
        resStr = GeetVerify.StartCaptcha(request,response);
        return resStr;

    }
    @ResponseBody
    @RequestMapping(value = "/login")
    /**
     * @ClassName:UserController
     * @Description:geetest的二次服务验证
     * @Author:Shi Xiaohao
     * @E-mail:sfturing@gmail.com
     * @Date :2017/8/26 下午11:09
     */
    public String login(HttpServletRequest request,
                        HttpServletResponse response){
        String resStr = "{}";
        resStr = GeetVerify.VerifyLogin(request,response);
        return resStr;
    }

}



