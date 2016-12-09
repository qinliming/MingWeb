package com.qinliming.eweb.web;

import com.google.inject.Injector;

import javax.inject.Singleton;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qinliming on 2016/12/7.
 */
@Singleton
final public class RouteMapper {
    private static final Map routeMap = new ConcurrentHashMap<>();
    private static Container container;
    private static final String SPACE = " ";
    private static final String POINT = ".";

    private String[] getMap(String route) {
        String[] result = new String[3];
        route = route.trim();
        Integer point = route.lastIndexOf(POINT);
        String tmp = route.substring(0, point);
        String[] tmpResult = tmp.split(SPACE);
        result[0] = tmpResult[0];
        result[1] = tmpResult[1];
        result[2] = tmpResult[2]+route.substring(point);
        return result;
    }

    public void init(String[] list,Container container) {
        RouteMapper.container = container;
        for (String s : list) {
            String[] route = this.getMap(s);
            Action action = container.getBean(Action.class);
            action.setRequestMethod(route[0]);
            Method method;
            routeMap.put(route[1],action);
        }
    }
}
