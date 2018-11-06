package com.songxd.autokf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerConfig {

    @Value("${server.key}")
    private String serverKey;


    public String getServerKey() {
        return serverKey;
    }
}
