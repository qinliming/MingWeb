package com.qinliming.eweb.web;


import com.google.inject.Module;
import com.qinliming.eweb.config.Config;
import com.qinliming.eweb.config.ConfigUtils;
import com.qinliming.eweb.config.RouterReader;
import com.qinliming.eweb.example.Controller;
import com.qinliming.eweb.web.module.RouteModule;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;


/**
 * This is the core dispatcher servlet of eweb
 * It will get all the request from web
 * Created by qinliming on 2016/11/24.
 */
public class DispatcherServlet implements Servlet{
    private Container container;
    @Override
    public void init(ServletConfig servletconfig) throws ServletException {
        try {
            Config config = ConfigUtils.getConfig(servletconfig.getInitParameter("configClass"));
            Set<Module> modules = config.getModules();
            modules.add(new RouteModule(RouterReader.getRealPath(servletconfig)));
            container = new Container(modules);
            RouterReader reader = container.getBean(RouterReader.class);
            reader.init();
            String[] paths = reader.getRouteList();
            RouteMapper mapper = container.getBean(RouteMapper.class);
            mapper.init(paths,container);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    private String getURI(HttpServletRequest request){
        return  request.getRequestURI();
    }
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String uri = this.getURI((HttpServletRequest) req);
        System.out.println(uri);
        System.out.println(container.getBean(Controller.class));
        res.getWriter().write("heheda~~~~~~~~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
