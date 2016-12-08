package com.qinliming.eweb.config;


import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletConfig;
import java.io.*;

/**
 * Created by qinliming on 2016/12/8.
 */
@Singleton
public class RouterReader {
    private String routerString;

    @Inject
    @Named(value = "routePath")
    private String path;


    public void init() {
        try {
            InputStream stream = new FileInputStream(new File(path));
            byte[] buf = new byte[stream.available()];
            stream.read(buf);
            routerString = new String(buf);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getRouteList() {
        this.replaceEnter();
        this.removeTabe();
        this.removeSpace();
        return routerString.split("@");
    }

    private void removeTabe() {
        this.routerString = routerString.replaceAll("\\t", " ");
    }

    private void replaceEnter() {
        this.routerString = routerString.replaceAll("\\n", "@");
    }

    private void removeSpace() {
        this.routerString = routerString.replaceAll("\\s+", " ");
    }
    public static String getRealPath(ServletConfig config){
        return config.getServletContext().getRealPath("/WEB-INF/route.conf");
    }
}
