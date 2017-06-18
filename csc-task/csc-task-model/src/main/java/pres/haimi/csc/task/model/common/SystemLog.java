package pres.haimi.csc.task.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhou on 2017/6/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemLog implements Serializable{
    private Integer id;
    private String userName;//操作人
    private String operation;//操作内容
    private String ip;//请求ip
    private Date operateTime;//操作时间
    //请求方法
    private String method;
    //请求参数
    private String params;

}
