package pres.haimi.csc.task.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;

/**
 * Created by HaimiZhou on 2017/5/22.
 */
public class Test {
   /* @Autowired
    private DemoDao demoDao;*/
    @Autowired
    private CollegeTaskService collegeTaskService;
    public void init(){
        System.out.println("Spring 初始化！");
       /* collegeTaskService.selectAll();*/
      /*  System.out.println(collegeTaskDao.select(1));*/
        /*demoDao.add(new Demo(2,"hello"));*/
        System.out.println("Mybatis success!");
    }
    private static Logger logger= Logger.getLogger(Test.class);
    public static void main(String[] args){
        logger.debug("This is a debug message.");
        logger.info("This is a info message.");
        logger.error("This is a error message.");
    }
}
