package pres.haimi.csc.task.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pres.haimi.csc.task.common.Auth;
import pres.haimi.csc.task.model.apiwrapper.APIResult;
import pres.haimi.csc.task.rpc.service.log.SysLogService;

/**
 * Created by Zhou on 2017/6/17.
 */
@RestController
@RequestMapping("/syslog")
public class SysLogController extends BaseController{
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/list")
    public APIResult getSysLogList(){
       return asSuccess(sysLogService.findAll());
    }
}
