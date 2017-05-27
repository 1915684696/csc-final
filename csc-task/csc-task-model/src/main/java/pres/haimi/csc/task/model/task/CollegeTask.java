
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
public class CollegeTask implements Serializable{
    private Integer id;//编号
    private Date publishDate;//发布时间
    private Date endTime;//结束时间
    private String title;//标题
    private String description;//任务描述
    private Double pay;//酬谢金额
    private Integer state;//任务状态  0:未接收 1：进行时 2：已完成 3：未完成
    private String publishUserId;//发布者
    private	String acceptUserId;//接受者
    private Integer collectTimes;//收藏次数
    private String pic;//任务图片
}
