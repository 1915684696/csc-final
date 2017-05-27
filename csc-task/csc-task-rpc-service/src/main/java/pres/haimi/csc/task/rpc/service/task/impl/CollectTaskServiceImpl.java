package pres.haimi.csc.task.rpc.service.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.dao.task.CollectTaskDao;
import pres.haimi.csc.task.model.task.CollectTask;
import pres.haimi.csc.task.rpc.service.task.CollectTaskService;

import java.util.List;
import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public class CollectTaskServiceImpl implements CollectTaskService{
    @Autowired
    private CollectTaskDao collectTaskDao;
    @Override
    public List<CollectTask> getCollectedBySelf(String UserId) {
        if (Objects.equals(UserId,null)){
            return null;
        }
        return collectTaskDao.selectCollectedBySelf(UserId);
    }
}
