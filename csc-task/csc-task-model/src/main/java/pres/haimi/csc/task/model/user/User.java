package pres.haimi.csc.task.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import pres.haimi.csc.task.model.goods.CollectGoods;
import pres.haimi.csc.task.model.task.CollectTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;			//编号
    private String userName;	//用户名
    private String password;	//密码
    private String gender;		//性别
    private String telephone;	//手机号
    private Integer publishTimes; //发布次数
    private Integer acceptTimes; //接收次数
    private Integer finishTimes;//完成次数
    private Integer integrate; //积分
    private String avator;//用户头像
    private String mail;//用户邮箱
    private List<String> images=new ArrayList<>();//用户所有图片

    private Set<CollectTask> task_users=new HashSet<>();
    private Set<CollectGoods> goods_users=new HashSet<>();
}
