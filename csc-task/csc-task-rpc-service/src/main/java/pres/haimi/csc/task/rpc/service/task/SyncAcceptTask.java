package pres.haimi.csc.task.rpc.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.task.CollegeTaskDao;
import pres.haimi.csc.task.model.task.CollegeTask;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by HaimiZhou on 2017/6/1.
 */
@Service
public class SyncAcceptTask {

    int num=0;

    @Autowired
    private CollegeTaskDao collegeTaskDao;

    ExecutorService exec= Executors.newFixedThreadPool(100);


    //同步方法：
    /*对于同步方法，锁是当前实例对象。
    对于静态同步方法，锁是当前对象的Class对象。
    对于同步方法块，锁是Synchonized括号里配置的对象。*/
    public void acceptTask(Integer taskId,Integer state) {
        exec.execute(()->{
            syncAccept(taskId,state);
        });
        exec.shutdown();
    }

    private String syncAccept(Integer taskId,Integer state){
        if(Objects.equals(taskId,null)){
            return CommonResult.ERROR;
        }
        CollegeTask collegeTask=collegeTaskDao.select(taskId);
        if (collegeTask==null){
            return CommonResult.QUERY_ERROR;
        }
        synchronized (this){
            if(state==1){
                collegeTask.setState(state);
            }
            num=collegeTaskDao.update(collegeTask);
        }
        if(num>0){
            return CommonResult.SUCCESS;
        }else {
            return CommonResult.ERROR;
        }
    }

}
