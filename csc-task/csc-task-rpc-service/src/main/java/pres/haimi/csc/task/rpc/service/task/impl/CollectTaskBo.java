package pres.haimi.csc.task.rpc.service.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.dao.task.CollegeTaskDao;
import pres.haimi.csc.task.model.task.CollegeTask;
import pres.haimi.csc.task.rpc.service.task.CollectTaskService;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;

/**
 * Created by Zhou on 2017/6/13.
 */
@Service
public class CollectTaskBo {

    @Autowired
    private CollectTaskService collectTaskService;
    @Autowired
    private CollegeTaskService collegeTaskService;

    @Autowired
    private CollegeTaskDao collegeTaskDao;

    //收藏业务方法
    public CollegeTask collectTask(boolean flag,String userId,String taskId){
        CollegeTask collegeTask=collegeTaskService.selectTaskById(taskId);
        if (flag){
            collegeTask.setCollectTimes(collegeTask.getCollectTimes()-1);
            collegeTaskDao.update(collegeTask);
            collectTaskService.cancelCollect(userId,taskId);
            return collegeTask;
        }else {
            collegeTask.setCollectTimes(collegeTask.getCollectTimes()+1);
            collegeTaskDao.update(collegeTask);
            collectTaskService.collectTask(userId,taskId);
            return collegeTask;
        }
    }
}
