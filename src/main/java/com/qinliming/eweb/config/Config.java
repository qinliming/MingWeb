package com.qinliming.eweb.config;

import com.google.inject.Module;

import java.util.Set;

/**
 * Created by qinliming on 2016/12/5.
 */
public class Config {
    private Set<Module> modules;


    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
