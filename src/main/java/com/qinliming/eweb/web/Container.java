package com.qinliming.eweb.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by qinliming on 2016/12/5.
 */
public class Container {
    private static Injector injector;
    public static Injector getInjector() {
        return injector;
    }

    public Container(Set<Module> modules) {
        injector = Guice.createInjector(modules);
    }

    public <T> T getBean(Class<T> clazz) {
        return injector.getInstance(clazz);
    }
}
