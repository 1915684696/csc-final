package pres.haimi.csc.task.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pres.haimi.csc.task.rpc.service.task.CollegeTaskService;
import redis.clients.jedis.Jedis;

/**
 * Created by HaimiZhou on 2017/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:configs/spring-mybatis.xml","classpath*:configs/spring-servlet.xml"})
public class JTest {

    @Autowired
    private CollegeTaskService collegeTaskService;
    @Test
    public void testJedisSingle() throws Exception {
       /* collegeTaskService.selectAll();*/
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("shenlinnan", "hahahahahaha");
        System.out.println(jedis.get("shenlinnan"));
        jedis.close();
    }

}
