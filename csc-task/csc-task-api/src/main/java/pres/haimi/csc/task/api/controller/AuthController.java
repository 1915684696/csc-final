package pres.haimi.csc.task.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
@RestController
@RequestMapping
public class AuthController extends BaseController{
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password) {
        System.out.println(userName+password+"---------->");
    }
}
