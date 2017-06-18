package pres.haimi.csc.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

/**
 * Created by Zhou on 2017/6/18.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private PlainUserService plainUserService;

    @RequestMapping("/taskgram")
    public APIResult getTaskGram(@RequestParam("userId") String userId){
        return asSuccess(plainUserService.getTaskSituationGram(userId));
    }
}
