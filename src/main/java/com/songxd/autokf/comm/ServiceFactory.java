package com.songxd.autokf.comm;

import com.songxd.autokf.ServerConfig;
import com.songxd.autokf.mq.Sender;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.Oneway;
import java.lang.reflect.Proxy;

/**
 * 获得对应方法的Service
 */
@Component
public class ServiceFactory {

    @Autowired
    private Sender sender;
    @Autowired
    private ServerConfig serverConfig;

    public <T> T getService(Class<T> type, Object obj) {
        TransferHandler handler = new TransferHandler(obj, sender, serverConfig);
        return handler.createProxy(type);
    }

}
