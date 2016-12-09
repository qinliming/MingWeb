package com.qinliming.eweb.web;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qinliming on 2016/12/8.
 */
public class Action {
    private static final Map<String, Object> controllerMap = new ConcurrentHashMap<>();
    private Method method;
    private String requestMethod;
    private String classPath;
    private Parameter[] parameters;

    public static Map<String, Object> getControllerMap() {
        return controllerMap;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public static Object getController(String className) {
        return controllerMap.get(className);
    }

    public static void setController(String className, Object object) {
        controllerMap.put(className, object);
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
