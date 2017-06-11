package pres.haimi.csc.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;

/**
 * Created by Zhou on 2017/6/7.
 */
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController{

    @Autowired
    private CollegeTaskService collegeTaskService;

    @RequestMapping("/all")
    public APIResult getAllTask(){
        return asSuccess(collegeTaskService.getAllTaskTemplate());
    }
}
