package pres.haimi.csc.task.rpc.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pres.haimi.csc.task.common.CommonResult;
import pres.haimi.csc.task.dao.log.SysLogDao;
import pres.haimi.csc.task.model.common.SystemLog;

import java.util.Objects;

/**
 * Created by Zhou on 2017/6/16.
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public String save(SystemLog systemLog) {
        if (Objects.equals(systemLog,null)) {
            return CommonResult.IMCOMPLETE_MESSAGE;
        }
        int result=sysLogDao.add(systemLog);
        if (result>0) {
            return CommonResult.SUCCESS;
        }else {
            return CommonResult.INSERT_ERROR;
        }
    }
}
