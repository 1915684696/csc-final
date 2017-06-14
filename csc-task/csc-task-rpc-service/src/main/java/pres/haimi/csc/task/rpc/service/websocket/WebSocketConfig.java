package pres.haimi.csc.task.rpc.service.websocket;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * Created by Zhou on 2017/6/13.
 */
@Configurable
@Component
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

    private ETaskWebSocketHandler handler=new ETaskWebSocketHandler();

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler,"/ws").addInterceptors(new HandShake()).setAllowedOrigins("*");
        registry.addHandler(handler,"/ws/sockjs").addInterceptors(new HandShake()).setAllowedOrigins("*").withSockJS();
    }
}
