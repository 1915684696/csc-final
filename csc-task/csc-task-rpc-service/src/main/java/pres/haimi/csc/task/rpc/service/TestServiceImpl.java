package pres.haimi.csc.task.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.dao.task.CollegeTaskDao;
import pres.haimi.csc.task.model.task.CollegeTask;

import java.util.Collections;
import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private CollegeTaskDao collegeTaskDao;
    @Override
    public List<CollegeTask> getAllTasks() {
        List<CollegeTask> taskList=collegeTaskDao.selectAll();
        return taskList==null? Collections.emptyList():taskList;
    }
}
