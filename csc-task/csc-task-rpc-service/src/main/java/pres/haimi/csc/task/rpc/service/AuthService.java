package pres.haimi.csc.task.rpc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
@Service
public class AuthService {

    private int plainUserKeyNum;

    private int adminKeyNum;

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
