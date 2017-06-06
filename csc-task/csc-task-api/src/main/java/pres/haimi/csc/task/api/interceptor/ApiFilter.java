package pres.haimi.csc.task.api.interceptor;

import pres.haimi.csc.task.common.Auth;
import pres.haimi.csc.task.model.user.Admin;
import pres.haimi.csc.task.model.user.PlainUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zhou on 2017/6/6.
 * 权限拦截器接口
 */
public class ApiFilter implements Filter{

    public static ThreadLocal<HttpServletRequest> requestThreadLocal=new ThreadLocal<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpSession session=request.getSession();
        request.setAttribute("auth",getAuth(session));
        this.requestThreadLocal.set(request);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    /**
     *管理员默认权限是1，如果是-1则是黑名单
     */
    public int getAuth(HttpSession session) {
        Object obj=session.getAttribute("user");
        if(obj != null) {
            if (obj instanceof PlainUser) {
                return Auth.PlAINUSER;
            }else if (obj instanceof Admin){
                Admin admin=(Admin) obj;
                if (admin.getLimit()== -1){
                    return Auth.BLACK;
                }
                return Auth.ADMIN;
            }
        }
        return Auth.NO_AUTH;
    }
}
