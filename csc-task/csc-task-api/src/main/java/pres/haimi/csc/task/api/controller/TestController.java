package pres.haimi.csc.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.model.task.CollegeTask;
import pres.haimi.csc.task.rpc.service.TestService;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public List<CollegeTask> getAllTasks(){
        return testService.getAllTasks();
    }

}
