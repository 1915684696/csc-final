package pres.haimi.csc.task.rpc.service.user;

import pres.haimi.csc.task.model.user.User;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public interface UserService {
    String login(String userName,String password);
    String register(User user);
}
