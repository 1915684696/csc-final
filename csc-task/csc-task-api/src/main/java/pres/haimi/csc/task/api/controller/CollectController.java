package pres.haimi.csc.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.common.Auth;
import pres.haimi.csc.task.dao.task.CollegeTaskDao;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.model.task.CollegeTask;
import pres.haimi.csc.task.rpc.service.task.CollectTaskService;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;
import pres.haimi.csc.task.rpc.service.task.impl.CollectTaskBo;

import javax.jws.Oneway;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhou on 2017/6/11.
 */
@RestController
@RequestMapping("/task")
public class CollectController extends BaseController{

    @Autowired
    private CollectTaskService collectTaskService;

    @Autowired
    private CollegeTaskService collegeTaskService;
    @Autowired
    private CollegeTaskDao collegeTaskDao;

    @Autowired
    private CollectTaskBo collectTaskBo;
    @RequestMapping("/collect")
    public APIResult collectTask(
            @RequestParam("taskId") String taskId,
            HttpSession session){
        int auth = getAuth();
        if (Auth.IS_LOGIN(auth)) {

            String userId=(String)session.getAttribute("userId");
            CollegeTask collegeTask=collegeTaskService.selectTaskById(taskId);
            //数据库存在该条记录是取消收藏，数据库没有是收藏
            boolean flag=collectTaskService.isCollect(userId,taskId);
            CollegeTask newCollegeTask=collectTaskBo.collectTask(flag,userId,taskId);
            if (!flag){
                return asSuccess(newCollegeTask,"成功收藏");
            }else {
                return asSuccess(newCollegeTask,"已取消收藏");
            }
        }
        return handleNoAuth(auth);
    }
}
