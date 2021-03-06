package com.feng.knowlege.deleteifelsebetter;

import com.google.common.collect.Maps;
import org.springframework.util.StringUtils;

import java.util.Map;

public class Factory {
    private static final Map<String, Handler> strategyMap = Maps.newHashMap();

    public static Handler getInvokeStrategy(String name) {
        return strategyMap.get(name);
    }

    public static void register(String name, Handler handler) {
        if (StringUtils.isEmpty(name) || null == handler) {
            return;
        }
        strategyMap.put(name, handler);
    }

}
