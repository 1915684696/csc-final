package pres.haimi.csc.task.rpc.service;

import org.springframework.beans.factory.annotation.Value;
import pres.haimi.csc.task.common.utils.StringUtil;


import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/29.
 */

public class AuthValidate {

    private static int plainUserKeyNum =10;
    private static int adminKeyNum =8;


    //校验用户名和密码格式
    public static AuthResult auth(String key,String password){
        AuthResult result=new AuthResult();
        if(Objects.equals(key,null) || Objects.equals(password,null)){
            result.setMessage("用户名或密码不能为空");
            return result;
        }
        //正则匹配
        if(!StringUtil.checkPassword(password)){
            result.setMessage("密码格式不正确");
            return result;
        }
        if(Objects.equals(key.length(),plainUserKeyNum)){
            result.setLogin(true);
            return result;
        }else if(!Objects.equals(key.length(),plainUserKeyNum)){
            result.setMessage("用户名必须为10位数");
            return result;
        }

        if (!Objects.equals(key.length(),adminKeyNum)) {
            result.setMessage("管理员账号必须为8位数");
            return result;
        }else if (Objects.equals(key.length(),adminKeyNum)) {
            result.setLogin(true);
            return result;
        }
        result.setLogin(true);
        return result;
    }

    @Value("#{prop.c_plainUser_key_num}")
    public void setPlainUserKeyNum(int plainUserKeyNum) {
        System.out.println(plainUserKeyNum+"加载配置文件参数");
        this.plainUserKeyNum = plainUserKeyNum;
    }
    @Value("#{prop.c_admin_key_num}")
    public void setAdminKeyNum(int adminKeyNum) {
        this.adminKeyNum = adminKeyNum;
    }
}