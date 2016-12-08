package com.qinliming.eweb.config;

import com.google.inject.Module;

import java.util.*;


/**
 * Created by qinliming on 2016/12/5.
 */
abstract public class AbsConfig {
    protected static final Set<Module> modules = new HashSet<>();
    public static Set<Module> getModuleList(){
        return modules;
    }
    abstract public void initModule();
}
