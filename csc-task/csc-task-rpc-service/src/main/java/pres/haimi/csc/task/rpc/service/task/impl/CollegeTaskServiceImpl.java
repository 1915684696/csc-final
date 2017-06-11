package pres.haimi.csc.task.rpc.service.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.task.CollegeTaskDao;
import pres.haimi.csc.task.dao.user.PlainUserDao;
import pres.haimi.csc.task.model.task.CollegeTask;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;
import pres.haimi.csc.task.rpc.service.task.dto.TaskTemplateDto;

import java.util.*;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
@Service
public class CollegeTaskServiceImpl implements CollegeTaskService{

    @Autowired
    private CollegeTaskDao collegeTaskDao;
    @Autowired
    private PlainUserDao userDao;

    //按发布者分类
    @Override
    public  List<TaskTemplateDto> getAllTaskTemplate() {
        List<CollegeTask> taskList = collegeTaskDao.selectUnAccpetTask();
        if (Objects.equals(taskList, null) || taskList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        List<TaskTemplateDto> taskTemplateDtoList=new ArrayList<>();
        taskList.forEach(task -> {
            TaskTemplateDto taskTemplateDto=new TaskTemplateDto(task.getId(),task.getPublishDate(),task.getEndTime(),
                    task.getTaskType(),task.getDescription(),task.getPay(),task.getState(),task.getCollectTimes(),task.getPic());
            String key = task.getPublishUserId();
            PlainUser user = userDao.selectByUserId(key);
            if (user != null && user.getName() != null) {
                taskTemplateDto.setName(user.getName());
                taskTemplateDto.setAvatars(user.getAvatars());
            }
            taskTemplateDtoList.add(taskTemplateDto);
        });
        return taskTemplateDtoList;
    }

    //私人发布的
    @Override
    public List<CollegeTask> publishedBySelf(String publishUserId) {
        if(Objects.equals(publishUserId,null)){
            return Collections.emptyList();
        }
        return collegeTaskDao.selectByPublishUserId(publishUserId);
    }

    //私人接收的
    @Override
    public List<CollegeTask> acceptedBySelf(String acceptUserId) {
        if(Objects.equals(acceptUserId,null)||acceptUserId.trim().equals("")){
            return Collections.emptyList();
        }
        return collegeTaskDao.selectByAcceptUserId(acceptUserId);
    }

    //根据状态得到任务列表
    @Override
    public List<CollegeTask> findTasksByState(Integer state) {
        if(Objects.equals(state,null)){
            return Collections.EMPTY_LIST;
        }
        if(state==-1){
            return Collections.emptyList();
        }
        return collegeTaskDao.selectByState(state);
    }

    //发布任务
    @Override
    public String publishTask(CollegeTask collegeTask) {
        if(Objects.equals(collegeTask,null)||collegeTask.getPublishDate()==null
                ||collegeTask.getEndTime()==null||collegeTask.getId()==null){
            return CommonResult.IMCOMPLETE_MESSAGE;
        }
        if(collegeTask.getPublishDate().compareTo(collegeTask.getEndTime())>0){
            return CommonResult.INVALIDATE_TIME;
        }
        collegeTask.setState(0);
        int num=collegeTaskDao.add(collegeTask);
        if(num>0){
            return CommonResult.SUCCESS;
        }else {
            return CommonResult.INSERT_ERROR;
        }
    }

    //改变任务状态
    @Override
    public  String changeTaskState(Integer taskId,Integer state) {
        if (taskId!=null){
            CollegeTask collegeTask=collegeTaskDao.select(taskId);
            if (collegeTask==null){
                return CommonResult.QUERY_ERROR;
            }
            if(state!=-1 && state!=1){
                collegeTask.setState(state);
            }
            int num=collegeTaskDao.update(collegeTask);
            if(num>0){
                return CommonResult.SUCCESS;
            }else {
                return CommonResult.ERROR;
            }
        }
        return null;
    }


}
