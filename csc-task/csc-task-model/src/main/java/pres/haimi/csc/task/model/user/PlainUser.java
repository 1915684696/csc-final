package pres.haimi.csc.task.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pres.haimi.csc.task.model.User;

import java.io.Serializable;

/**
 * Created by HaimiZhou on 2017/5/20.
 */
@Data//为所有字段添加toString equals hashcode getter  为非final字段添加setter和RequireArgsConstructs
//@RequiredArgsConstructor使用类中所有带有@NonNull注解的或者带有final修饰的成员变量生成对应的构造方法，它可以使用@Data(staticConstructor=”methodName”)来生成一个静态方法，返回一个调用相应的构造方法产生的对象
@AllArgsConstructor
@NoArgsConstructor
public class PlainUser implements Serializable,User{
    private String id;			//编号
    private String name;	//用户名
    private String password;	//密码
    private String gender;		//性别
    private String telephone;	//手机号
    private Integer publishTimes; //发布次数
    private Integer acceptTimes; //接收次数
    private Integer finishTimes;//完成次数
    private Integer integrate; //积分
    private String avatars;//用户头像
    private String mail;//用户邮箱

    public String[] getAvatars1() {
        if (avatars==null) {
            return new String[0];
        }
        return avatars.split(",");
    }

    public void addAvatars(String avatar) {
        if (avatar==null) return;
        if (this.avatars==null) {
            this.avatars = avatar;
            return;
        }
        this.avatars += "," +avatar;
    }

}
