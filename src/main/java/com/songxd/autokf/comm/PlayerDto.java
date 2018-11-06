package com.songxd.autokf.comm;

/**
 * 一个模拟的玩家对象
 */
public class PlayerDto {

    private String playerName;
    private String serverKey;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getServerKey() {
        return serverKey;
    }

    public void setServerKey(String serverKey) {
        this.serverKey = serverKey;
    }
}
