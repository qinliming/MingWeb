package com.qinliming.eweb.example;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.qinliming.eweb.config.AbsConfig;

/**
 * Created by qinliming on 2016/12/5.
 */
public class Config extends AbsConfig{
    @Override
    public void initModule() {
        modules.add(new Module() {
            @Override
            public void configure(Binder binder) {

            }
        });
    }
}
