package pres.haimi.csc.task.common;

/**
 * Created by Zhou on 2017/6/6.
 */
public class Auth {
    public final static String Auth="auth";
    public final static Integer PlAINUSER=1;
    public final static Integer ADMIN=0;
    public final static Integer BLACK=-1;
    public final static Integer NO_AUTH=-2;
    //...

    public static boolean IS_LOGIN(int auth){
        if(auth == PlAINUSER || auth == ADMIN ) {
            return true;
        }
        return false;
    }
}


