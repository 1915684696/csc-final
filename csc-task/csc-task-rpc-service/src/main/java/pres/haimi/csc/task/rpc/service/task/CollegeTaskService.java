package pres.haimi.csc.task.rpc.service.task;

import pres.haimi.csc.task.model.task.CollegeTask;
import pres.haimi.csc.task.rpc.service.task.dto.TaskTemplateDto;

import java.util.List;
import java.util.Map;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public interface CollegeTaskService {

    List<TaskTemplateDto> getAllTaskTemplate();
    List<CollegeTask> publishedBySelf(String publishUserId);
    List<CollegeTask> acceptedBySelf(String acceptUserId);
    List<CollegeTask> findTasksByState(Integer state);
    String publishTask(CollegeTask collegeTask);
    String changeTaskState(Integer taskId,Integer state);

}
