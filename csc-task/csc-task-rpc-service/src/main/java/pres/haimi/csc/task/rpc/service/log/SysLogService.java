package pres.haimi.csc.task.rpc.service.log;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pres.haimi.csc.task.model.common.SystemLog;

/**
 * Created by Zhou on 2017/6/16.
 */
public interface SysLogService {
    String save(SystemLog systemLog);
}
