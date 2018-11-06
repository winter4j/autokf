package com.songxd.autokf.service;

import com.songxd.autokf.annotation.Command;
import com.songxd.autokf.api.IGiftService;
import com.songxd.autokf.comm.PlayerDto;
import org.springframework.stereotype.Component;

@Component
public class GiftService implements IGiftService {

    @Override
    @Command(value = "presentGift", exchange = "gift")
    public int presentGift(PlayerDto player, String giftName, int num) {
        System.out.println("log:"+player.getServerKey()+"的"+player.getPlayerName()+"获得"+num+"份"+giftName);
        return 1; //成功
    }
}
