package com.songxd.autokf.comm;

import com.songxd.autokf.ServerConfig;
import com.songxd.autokf.annotation.Command;
import com.songxd.autokf.mq.Sender;
import com.songxd.autokf.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * java动态代理
 */
public class TransferHandler implements InvocationHandler {

    private Object obj;

    private Sender sender;
    private ServerConfig serverConfig;

    public TransferHandler(Object obj, Sender sender, ServerConfig serverConfig) {
        this.obj = obj;
        this.sender = sender;
        this.serverConfig = serverConfig;
    }

    public <T> T createProxy(Class<T> type){
        return type.cast(Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        PlayerDto playerDto = getPlayerDto(args);
        if(!serverConfig.getServerKey().equalsIgnoreCase(playerDto.getServerKey())) {
            //不是同一个服的就rpc

            //这里不能从传参的method中获得注解 奇怪
            Method m = obj.getClass().getMethod(method.getName(), method.getParameterTypes());
            Command command = m.getAnnotation(Command.class);
            Request request = new Request();
            request.setCommand(command.value());
            request.setArgs(Utils.WriteArgs(args));
            request.setExchange(command.exchange());
            request.setRoutingKey(playerDto.getServerKey());
            return this.sender.sendAndRecv(request);
        }
        //同进程调用
        return method.invoke(obj, args);
    }

    private PlayerDto getPlayerDto(Object[] args){
        for(Object temp : args){
            if(temp instanceof PlayerDto){
                return (PlayerDto) temp;
            }
        }
        return null;
    }
}
