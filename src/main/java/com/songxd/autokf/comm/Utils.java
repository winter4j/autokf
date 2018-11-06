package com.songxd.autokf.comm;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Utils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Object[]和参数对象的转换
     * @param map
     * @return
     * @throws Exception
     */
    public static Object[] readArgs(Map<Class<?>, String> map) throws Exception {
        if(map == null || map.isEmpty()){
            return null;
        }
        Object[] object = new Object[map.size()];
        int index = 0;
        for(Map.Entry<Class<?>, String> entry : map.entrySet()){
            object[index++] = objectMapper.readValue(entry.getValue(), entry.getKey());
        }
        return object;
    }

    /**
     * Object[]和参数对象的转换
     * @param objects
     * @return
     * @throws Exception
     */
    public static Map<Class<?>, String> WriteArgs(Object[] objects) throws Exception {
        Map<Class<?>, String> map = new LinkedHashMap<>();
        if(objects != null && objects.length > 0){
            for(Object object : objects){
                map.put(object.getClass(), objectMapper.writeValueAsString(object));
            }
        }
        return map;
    }
}
