package pres.haimi.csc.task.dao.task;

import pres.haimi.csc.task.dao.BaseDao;
import pres.haimi.csc.task.model.task.CollectTask;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
public interface CollectTaskDao extends BaseDao<CollectTask,Integer>{
    List<CollectTask> selectCollectedBySelf(String UserId);
}
