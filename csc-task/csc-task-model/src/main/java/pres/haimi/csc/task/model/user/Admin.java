package pres.haimi.csc.task.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pres.haimi.csc.task.model.User;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable,User{
    private String id;
    private String name;
    private String password;
    private String avatars; //头像
    private String sex;
    private String identity;
    private String phone;
    private Date birthday;
    private String mail;  //邮箱
    private Integer limit;

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
