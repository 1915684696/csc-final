package pres.haimi.csc.task.dao.task;

import pres.haimi.csc.task.dao.BaseDao;
import pres.haimi.csc.task.model.task.CollegeTask;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/23.
 */
public interface CollegeTaskDao extends BaseDao<CollegeTask,Integer>{
    List<CollegeTask> selectByPublishUserId(String publishUserId);
    List<CollegeTask> selectByAcceptUserId(String acceptUserId);
    List<CollegeTask> selectByState(Integer state);
}
