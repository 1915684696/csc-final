package pres.haimi.csc.task.rpc.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.user.UserDao;
import pres.haimi.csc.task.model.user.User;
import pres.haimi.csc.task.rpc.service.user.UserService;

import java.util.List;
import java.util.Objects;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    //登录
    @Override
    public String login(String userName, String password) {
        if(Objects.equals(userName,null)||Objects.equals(password,null)){
            return null;
        }
        List<User> userList=userDao.selectByName(userName);
        if(userList.get(0)==null||userList.size()==0){
            return CommonResult.IMEXIST_USER;
        }
        for (User user:userList) {
            if(user.getPassword().equals(password)){
                return CommonResult.SUCCESS;
            }
        }
        return CommonResult.ERROR_PASSWORD;
    }

    //注册
    @Override
    public String register(User user) {
        if (user!=null||user.getUserName()!=null){
            List<User> userList=userDao.selectByName(user.getUserName());
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
