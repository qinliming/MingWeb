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

    public static Parameter[] getParameters(String method) throws ClassNotFoundException {
        Integer begin = method.indexOf("(");
        Integer end = method.indexOf(")");
        String params = method.substring(begin + 1, end);
        String[] paramsList = params.split(",");
        Parameter[] parameters = new Parameter[paramsList.length];
        Integer i = 0;
        for (String para : paramsList) {
            Parameter parameter = new Parameter();
            String[] paraPiece = para.split(" ");
            String className = "java.lang." + paraPiece[0];
            Class clazz = Class.forName(className);
            parameter.setClazz(clazz);
            parameter.setParamName(paraPiece[1]);
            parameters[i++] = parameter;
        }
        return parameters;
    }
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
    private String[] getClassPath(String m){
        String[] classPiece = new String[2];
        Integer point = m.lastIndexOf(POINT);
        System.out.println(m.substring(0,point));
        System.out.println(m.substring(point+1));
        return classPiece;
    }
    public void init(String[] list,Container container) {
        RouteMapper.container = container;
        for (String s : list) {
            String[] route = this.getMap(s);
            for (String r:route){
                System.out.println(r);
            }
            this.getClassPath(route[2]);
            Action action = container.getBean(Action.class);
            String method = route[0];
            action.setRequestMethod(method);

//            System.out.println(action);
//
//            action.setRequestMethod(method);
           // Method method;
           // routeMap.put(route[1],action);
        }
    }
}
