package cn.sfturing.controller;

import cn.sfturing.utils.GeetestConfig;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.sfturing.jdk.GeetestLib;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @RequestMapping(value = "/verifyLogin")
    public JSONObject Login(HttpServletRequest request,
                            HttpServletResponse response) {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(), GeetestConfig.isnewfailback());
        String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
        //从session中获取gt-server状态
        int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

        //从session中获取userid
        String userid = (String) request.getSession().getAttribute("userid");
        int gtResult = 0;

        if (gt_server_status_code == 1) {
            //gt-server正常，向gt-server进行二次验证

            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, userid);
            System.out.println(gtResult);
        } else {
            // gt-server非正常情况下，进行failback模式验证

            System.out.println("failback:use your own server captcha validate");
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
            System.out.println(gtResult);
        }
        if (gtResult == 1) {
            JSONObject data = new JSONObject();
            try {
                data.put("status", "success");
                data.put("version", gtSdk.getVersionInfo());
                return data;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println("验证成功*****************");
            return data;

        } else {
            JSONObject data = new JSONObject();
            try {
                data.put("status", "fail");
                data.put("version", gtSdk.getVersionInfo());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println("验证失败*****************");
            return data;
        }

    }
}
