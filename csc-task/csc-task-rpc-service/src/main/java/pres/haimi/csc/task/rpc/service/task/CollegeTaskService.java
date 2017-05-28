package pres.haimi.csc.task.rpc.service.task;

import pres.haimi.csc.task.model.task.CollegeTask;

import java.util.List;
import java.util.Map;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public interface CollegeTaskService {

    Map<String,List<CollegeTask>> getAllTasks();
    List<CollegeTask> publishedBySelf(String publishUserId);
    List<CollegeTask> acceptedBySelf(String acceptUserId);
    List<CollegeTask> findTasksByState(Integer state);
    String publishTask(CollegeTask collegeTask);
    String changetTaskState(Integer taskId,Integer state);

}
