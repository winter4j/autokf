package com.songxd.autokf.mq;

import com.songxd.autokf.comm.Request;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 生产端
 */
@Component
public class Sender {

    @Autowired
    private RabbitConfig config;
    @Value("${server.key}")
    private String serverKey;

    public Object sendAndRecv(Request request){
        System.out.println(serverKey + " send: " + request.toString());
        return config.rabbitTemplate().convertSendAndReceive(
                request.getExchange(), request.getRoutingKey(), request);
    }
}
