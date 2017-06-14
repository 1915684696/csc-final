package pres.haimi.csc.task.rpc.service.task.dto;

import java.util.Date;

/**
 * Created by Zhou on 2017/6/10.
 */
public class TaskTemplateDto {
    private String name;
    private String avatars;//若是空 ，前台判断并给出默认头像
    private String id;//编号
    private Date publishDate;//发布时间
    private Date endTime;//结束时间
    private String taskType;//任务类型
    private String description;//任务描述
    private Double pay;//酬谢金额
    private Integer state;//任务状态  0:未接收 1：进行时 2：已完成 3：未完成  -1:无效
    private Integer collectTimes;//收藏次数
    private String pic;//任务图片

    public enum  TaskType{

        study("学习"),
        tourist("旅游"),
        life("生活"),
        delisious("美食"),
        other("其他");

        private final String value;

        TaskType(String name) {
            this.value =name;
        }
        public String getValue() {
            return value;
        }
    }
    public TaskTemplateDto(String id,Date publishDate, Date endTime, String taskType, String description, Double pay, Integer state,Integer collectTimes, String pic) {
        this.id=id;
        this.publishDate = publishDate;
        this.endTime = endTime;
        this.taskType = taskType;
        this.description = description;
        this.pay = pay;
        this.state = state;
        this.collectTimes = collectTimes;
        this.pic = pic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCollectTimes() {
        return collectTimes;
    }

    public void setCollectTimes(Integer collectTimes) {
        this.collectTimes = collectTimes;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
