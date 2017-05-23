package pres.haimi.csc.task.model.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import pres.haimi.csc.task.model.user.User;

import java.util.Date;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
public class CollectTask {
    private Integer id;
    private CollegeTask collect_task;
    private User collect_task_user;
    private Date collectDate;
}
