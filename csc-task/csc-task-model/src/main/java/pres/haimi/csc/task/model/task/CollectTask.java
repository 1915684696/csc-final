package pres.haimi.csc.task.model.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectTask implements Serializable{
    private Integer id;
    private String taskId;
    private String userId;
    private Date collectDate;

    public CollectTask(String taskId, String userId, Date collectDate) {
        this.taskId = taskId;
        this.userId = userId;
        this.collectDate = collectDate;
    }
}
