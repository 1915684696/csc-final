package pres.haimi.csc.task.rpc.service.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.task.CollectTaskDao;
import pres.haimi.csc.task.model.task.CollectTask;
import pres.haimi.csc.task.rpc.service.task.CollectTaskService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public class CollectTaskServiceImpl implements CollectTaskService{
    @Autowired
    private CollectTaskDao collectTaskDao;

    //我收藏的任务
    @Override
    public List<CollectTask> getCollectedBySelf(String userId) {
        if (Objects.equals(userId,null)){
            return null;
        }
        return collectTaskDao.selectCollectedBySelf(userId);
    }

    //收藏任务
    @Override
    public String collectTask(String userId,String taskId) {
        if (Objects.equals(taskId,null)||Objects.equals(userId,null)){
            return CommonResult.ERROR;
        }
        CollectTask collectTask=new CollectTask(1,taskId,userId,new Date());
        int result=collectTaskDao.add(collectTask);
        if (result>0){
            return CommonResult.SUCCESS;
        }else {
            return CommonResult.INSERT_ERROR;
        }
    }

    //取消收藏
    @Override
    public String cancelCollect(String userId, String taskId) {
        if (Objects.equals(taskId,null)||Objects.equals(userId,null)){
            return CommonResult.ERROR;
        }
        CollectTask collectTask=collectTaskDao.selectCollectTask(userId, taskId);
        if (collectTask!=null&&collectTask.getId()!=null){
            collectTaskDao.delete(collectTask.getId());
            return CommonResult.SUCCESS;
        }else{
            return CommonResult.ERROR;
        }
    }
}
