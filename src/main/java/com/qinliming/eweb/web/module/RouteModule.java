package com.qinliming.eweb.web.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.qinliming.eweb.config.RouterReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by qinliming on 2016/12/8.
 */
public class RouteModule extends AbstractModule {
    private String path;

    public RouteModule(String path) {
        super();
        this.path = path;
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("routePath")).toInstance(path);
    }
}
