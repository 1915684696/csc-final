package pres.haimi.csc.task.rpc.service.task;

import pres.haimi.csc.task.model.task.CollectTask;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public interface CollectTaskService {
    List<CollectTask> getCollectedBySelf(String UserId);
}
