package pres.haimi.csc.task.common.utils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HaimiZhou on 2017/5/29.
 */
public class StringUtil {
    private static final String PASSWORD_PATTERN="^[a-zA-Z]\\w{5,17}$";

    public static boolean checkPassword(String password){
        if(Objects.equals(password,null)){
            return false;
        }
        Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher=pattern.matcher(password);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String ip) {
        if (Objects.equals(ip,null)) {
            return true;
        }
        return false;
    }
}
