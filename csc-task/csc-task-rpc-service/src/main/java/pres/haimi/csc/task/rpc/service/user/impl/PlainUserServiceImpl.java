package pres.haimi.csc.task.rpc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.user.PlainUserDao;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

import java.util.List;
import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
@Service
public class PlainUserServiceImpl implements PlainUserService {
    @Autowired
    private PlainUserDao plainUserDao;
    //注册
    @Override
    public String register(PlainUser user) {
        if (user!=null||user.getName()!=null){
            List<PlainUser> userList=plainUserDao.selectByName(user.getName());
            if (userList!=null||userList.size()!=0){
                return CommonResult.EXIST_USER;
            }else {
                int num=plainUserDao.add(user);
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

    @Override
    public PlainUser getPlainUser(String plainUserId) {
        if(Objects.equals(plainUserId,null)){
            return null;
        }
        return plainUserDao.select(plainUserId);
    }
}
