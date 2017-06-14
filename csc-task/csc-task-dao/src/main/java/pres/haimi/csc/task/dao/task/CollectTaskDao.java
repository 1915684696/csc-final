package pres.haimi.csc.task.dao.task;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import pres.haimi.csc.task.dao.BaseDao;
import pres.haimi.csc.task.model.task.CollectTask;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
public interface CollectTaskDao extends BaseDao<CollectTask,Integer>{
    List<CollectTask> selectCollectedBySelf(String userId);
    CollectTask selectCollectTask(@Param("userId") String userId, @Param("taskId") String taskId);
}
