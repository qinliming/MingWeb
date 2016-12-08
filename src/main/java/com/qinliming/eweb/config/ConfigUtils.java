package com.qinliming.eweb.config;

/**
 * Created by qinliming on 2016/12/5.
 */
final public class ConfigUtils {
    private ConfigUtils(){}
    private static Class  getConfigClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
    private static AbsConfig getConfigInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class configClass = getConfigClass(className);
        return (AbsConfig) configClass.newInstance();
    }
    public static Config getConfig(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Config ewebConfig = new Config();
        AbsConfig config = getConfigInstance(className);
        config.initModule();
        ewebConfig.setModules(AbsConfig.getModuleList());
        return ewebConfig;
    }
}
