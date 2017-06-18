package pres.haimi.csc.task.rpc.service.user;

import pres.haimi.csc.task.model.user.PlainUser;

import java.util.Map;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
public interface PlainUserService {
    String register(PlainUser user);
    PlainUser getPlainUser(String plainUserId);
    Map<String,Integer> getTaskSituationGram(String userId);
}
