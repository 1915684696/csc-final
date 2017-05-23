package pres.haimi.csc.task.api;

import org.springframework.beans.factory.annotation.Autowired;
import pres.haimi.csc.task.dao.DemoDao;
import pres.haimi.csc.task.model.Demo;

/**
 * Created by HaimiZhou on 2017/5/22.
 */
public class Test {
    @Autowired
    private DemoDao demoDao;
    public void init(){
        System.out.println("Spring 初始化！");
        demoDao.add(new Demo(1,"hello"));
        System.out.println("Mybatis success!");
    }
}
