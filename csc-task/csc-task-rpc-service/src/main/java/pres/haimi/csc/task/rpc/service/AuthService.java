package pres.haimi.csc.task.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.common.utils.StringUtil;
import pres.haimi.csc.task.dao.user.AdminDao;
import pres.haimi.csc.task.model.user.Admin;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
@Service
public class AuthService {

    private int plainUserKeyNum;
    private int adminKeyNum;

    @Autowired
    private PlainUserService plainUserService;

    @Autowired
    private AdminDao adminDao;

    //验证普通用户或管理员的登陆
    public AuthResult auth(String key,String password){
        AuthResult result=new AuthResult();
        if(Objects.equals(key,null) || Objects.equals(password,null)){
            result.setMessage("用户名或密码不能为空");
            return result;
        }
        //正则匹配
        if(!StringUtil.checkPassword(password)){
            result.setMessage("用户名或密码不正确");
            return result;
        }
        if(Objects.equals(key.length(),plainUserKeyNum)){
            return checkPlainUser(key,password,result);
        }
        if(Objects.equals(key.length(),adminKeyNum)){
            return checkAdmin(key,password,result);
        }
        return result;
    }

    private AuthResult checkPlainUser(String key,String password,AuthResult result){
        PlainUser plainUser=plainUserService.getPlainUser(key);
        if (plainUser==null){
            result.setMessage("用户名不存在");
            return result;
        }
        if (Objects.equals(plainUser.getPassword(),password)){
            result.setLogin(true);
            result.setMessage("登陆成功");
            result.setUser(plainUser);
            return result;
        }
        return result;
    }

    private AuthResult checkAdmin(String key,String password,AuthResult result){
        Admin admin=adminDao.select(key);
        if (admin==null){
            result.setMessage("用户名不存在");
            return result;
        }
        if (Objects.equals(admin.getPassword(),password)){
            result.setLogin(true);
            result.setMessage("登陆成功");
            result.setUser(admin);
        }
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
