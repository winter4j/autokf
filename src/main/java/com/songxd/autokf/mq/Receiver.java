package com.songxd.autokf.mq;

import com.songxd.autokf.annotation.Command;
import com.songxd.autokf.api.IGiftService;
import com.songxd.autokf.comm.PlayerDto;
import com.songxd.autokf.comm.Request;
import com.songxd.autokf.comm.Utils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 消费端
 */
@Component
public class Receiver {

    @Autowired
    private IGiftService giftService;
    @Value("${server.key}")
    private String serverKey;

    @RabbitListener(queues = "${server.key}")
    public Object process(@Payload Request request) throws Exception {
        System.out.println(serverKey + " recv: " + request.toString());
        //因为现在是有一个接口 先简单写死
        Method[] methods = giftService.getClass().getMethods();

        for(Method method : methods){
            Command command = method.getAnnotation(Command.class);
            if(command.value().equalsIgnoreCase(request.getCommand())){
                Object[] args = Utils.readArgs(request.getArgs());
                return method.invoke(giftService, args);
            }
        }
        return null;
    }

}
