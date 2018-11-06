package com.songxd.autokf.comm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 发送到请求
 */
public class Request {
    //接口
    private String command;
    //参数
    private Map<Class<?>, String> args = new LinkedHashMap<>();

    private String exchange;

    private String routingKey;

    @Override
    public String toString() {
        return "Request{" +
                "command='" + command + '\'' +
                ", args=" + args +
                ", exchange='" + exchange + '\'' +
                ", routingKey='" + routingKey + '\'' +
                '}';
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Map<Class<?>, String> getArgs() {
        return args;
    }

    public void setArgs(Map<Class<?>, String> args) {
        this.args = args;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
