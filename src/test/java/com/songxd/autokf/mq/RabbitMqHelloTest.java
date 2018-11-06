package com.songxd.autokf.mq;

import com.songxd.autokf.Client;
import com.songxd.autokf.annotation.Command;
import com.songxd.autokf.api.IGiftService;
import com.songxd.autokf.comm.PlayerDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private Client client;
    @Autowired
    private IGiftService giftService;

    @Test
    public void hello() throws Exception {
        client.test();
    }
}
