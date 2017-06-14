package pres.haimi.csc.task.api.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhou on 2017/6/13.
 */
@RestController
public class Demo {
    @RequestMapping("/msg")
    public void test(){
        System.out.println("ws????");
    }
}
