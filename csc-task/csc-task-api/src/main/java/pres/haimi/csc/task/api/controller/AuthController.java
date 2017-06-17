package pres.haimi.csc.task.api.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.api.log.annotation.SysLog;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.AuthResult;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

import javax.servlet.http.HttpSession;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
@RestController
@RequestMapping
public class AuthController extends BaseController{

    @Autowired
    private PlainUserService plainUserService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public APIResult login(
            @RequestParam("name") String name,
            @RequestParam("password") String password,
                    HttpSession session) {
        PlainUser user=plainUserService.getPlainUser(name);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            session.setAttribute("user",user);
            session.setAttribute("userId",user.getId());
            return asSuccess(new AuthResult(true, CommonResult.SUCCESS_LOGIN,user));
        }catch (Exception e){
            return asUnLogin(e.getMessage());
        }

    }
}
