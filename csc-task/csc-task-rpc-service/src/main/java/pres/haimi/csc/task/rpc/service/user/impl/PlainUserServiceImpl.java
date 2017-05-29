package pres.haimi.csc.task.rpc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.user.PlainUserDao;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

import java.util.List;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public class PlainUserServiceImpl implements PlainUserService {
    @Autowired
    private PlainUserDao userDao;
    //注册
    @Override
    public String register(PlainUser user) {
        if (user!=null||user.getName()!=null){
            List<PlainUser> userList=userDao.selectByName(user.getName());
            if (userList!=null||userList.size()!=0){
                return CommonResult.EXIST_USER;
            }else {
                int num=userDao.add(user);
                if (num > 0) {
                    return CommonResult.SUCCESS;
                }else {
                    return CommonResult.INSERT_ERROR;
                }
            }
        }else {
            return CommonResult.IMCOMPLETE_MESSAGE;
        }
    }
}
