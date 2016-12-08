package com.qinliming.eweb.example;

import java.io.*;

/**
 * Created by qinliming on 2016/12/7.
 */
public class Main {
    public static void main(String[] args) {
        System.currentTimeMillis();
        File file = new File("/Users/qinliming/sources/eweb/src/main/webapp/WEB-INF/route.conf");
        try {
            InputStream stream = new FileInputStream(file);
            System.out.println(stream.available());
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            String tm = new String(bytes);
            String n = tm.replaceAll("\\n", "@");
            System.out.println(n);
            String o = n.replaceAll("\\s+", " ");
            System.out.println(o);
            String[] list = o.split("@");

            for (String f : list) {
                System.out.println(f);
                int from = 0;
                int end = f.indexOf(" ", 0);
                String method = f.substring(from, end);
                System.out.println(method);
                from = end + 1;
                end = f.indexOf(" ", from);
                String url = f.substring(from, end);
                System.out.println(url);
                from = end+1;
                String meth = f.substring(from);
                System.out.println(meth);
                String classPath = meth.substring(0,meth.lastIndexOf("."));
                System.out.println(classPath);
            }
            System.out.println("[------------------------]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
