
package pres.haimi.csc.task.model.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import pres.haimi.csc.task.model.user.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
public class CollegeTask {
    private Integer id;//编号
    private Date publisurDate;//发布时间
    private String endTime;//结束时间
    private String description;//任务描述
    private Double pay;//酬谢金额
    private String state;//任务状态
    private User publish_user;//发布者
    private	User accept_user;//接受者
    private Integer collectTimes;//收藏次数
    private String pic;//任务图片

    private Set<CollectTask> task_users=new HashSet<>();

}
