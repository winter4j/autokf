package com.songxd.autokf;

import com.songxd.autokf.api.IGiftService;
import com.songxd.autokf.comm.PlayerDto;
import com.songxd.autokf.comm.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private IGiftService giftService;
    @Autowired
    private ServiceFactory serviceFactory;

    public static Map<String, PlayerDto> map = new HashMap<>();
    static{
        PlayerDto playerDto = new PlayerDto();
        playerDto.setPlayerName("Peter");
        playerDto.setServerKey("S1");

        map.put(playerDto.getPlayerName(), playerDto);

        playerDto = new PlayerDto();
        playerDto.setPlayerName("Tom");
        playerDto.setServerKey("S2");

        map.put(playerDto.getPlayerName(), playerDto);
    }

    @RequestMapping("gift")
    public String gift(@RequestParam("name") String name,
                       @RequestParam("giftName") String giftName, @RequestParam("num") int num){
        PlayerDto playerDto = map.get(name);
        if(playerDto == null){
            return "name error Peter or Tom";
        }
        IGiftService service = serviceFactory.getService(IGiftService.class, giftService);
        return service.presentGift(playerDto, giftName, num) > 0 ? "success" : "fail";
    }
}
