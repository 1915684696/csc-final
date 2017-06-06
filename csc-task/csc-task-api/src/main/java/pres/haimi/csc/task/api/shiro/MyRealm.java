package pres.haimi.csc.task.api.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.AuthResult;
import pres.haimi.csc.task.rpc.service.AuthService;
import pres.haimi.csc.task.rpc.service.user.PlainUserService;

/**
 * Created by Zhou on 2017/6/5.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private PlainUserService plainUserService;

    //用于权限的认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //用于登陆的认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //获取用户账号和密码
        String key = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        PlainUser user = plainUserService.getPlainUser(key) ;
        if (user != null){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(key,password, getName()) ;
            return authenticationInfo ;
        }else{
            return  null;
        }
    }
}
