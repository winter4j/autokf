package com.songxd.autokf.api;

import com.songxd.autokf.annotation.Command;
import com.songxd.autokf.comm.PlayerDto;

public interface IGiftService {

    /**
     * 给targetServer的receiverName赠送num个giftName
     * @param player
     * @param giftName
     * @param num
     */
    int presentGift(PlayerDto player, String giftName, int num);

}
