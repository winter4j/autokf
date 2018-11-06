package com.songxd.autokf;

import com.songxd.autokf.api.IGiftService;
import com.songxd.autokf.comm.PlayerDto;
import com.songxd.autokf.comm.ServiceFactory;
import com.songxd.autokf.service.GiftService;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {

    @Autowired
    private ServiceFactory serviceFactory;

    @Autowired
    private GiftService giftService;

    public void test(){
        useService("Peter", "S1");
        useService("Tom", "S2");
    }

    private void useService(String name, String key){
        PlayerDto playerDto = new PlayerDto();
        playerDto.setPlayerName(name);
        playerDto.setServerKey(key);
        IGiftService service = serviceFactory.getService(IGiftService.class, giftService);
        Object result = service.presentGift(playerDto, "钻石", 200);
        System.out.println("result = " + result.toString());
    }
}
