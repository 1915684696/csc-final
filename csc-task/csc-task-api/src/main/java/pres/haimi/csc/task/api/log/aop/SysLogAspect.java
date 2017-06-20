package pres.haimi.csc.task.api.log.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pres.haimi.csc.task.api.log.annotation.SysLog;
import pres.haimi.csc.task.api.shiro.ShiroUtils;
import pres.haimi.csc.task.common.utils.HttpContextUtils;
import pres.haimi.csc.task.common.utils.IPUtils;
import pres.haimi.csc.task.model.User;
import pres.haimi.csc.task.model.common.SystemLog;
import pres.haimi.csc.task.model.user.PlainUser;
import pres.haimi.csc.task.rpc.service.log.SysLogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 系统日志，切面处理类
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogService sysLogService;
	
	@Pointcut("@annotation(pres.haimi.csc.task.api.log.annotation.SysLog)")
	public void logPointCut() { 
		
	}
	
	@Before("logPointCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		SystemLog sysLog = new SystemLog();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述 
			sysLog.setOperation(syslog.value());
		}
		
		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");
		
		//请求的参数
		Object[] args = joinPoint.getArgs();
		String params = JSON.toJSONString(args[0]);
		sysLog.setParams(params);
		
		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		//用户名
		HttpSession session = request.getSession();
		PlainUser user = (PlainUser) session.getAttribute("user");

		if(user==null){//未登陆不能保存当前收藏任务这个日志
			return;
		}else{
			/*String username = ShiroUtils.getUserEntity().getName();*/
			sysLog.setUserName(user.getName());

			sysLog.setOperateTime(new Date());
			//保存系统日志
			sysLogService.save(sysLog);
		}

	}
	
}
