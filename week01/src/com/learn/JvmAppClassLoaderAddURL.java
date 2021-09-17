package com.learn;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Class: JvmAppClassLoaderAddURL
 * @Description:
 * @Author: Jerry Qu
 * @Create: 2021-09-14 15:52:21
 */
public class JvmAppClassLoaderAddURL {
    public static void main(String[] args) {
        String appPath = "file:/d:/app/";
        URLClassLoader urlClassLoader = (URLClassLoader) JvmAppClassLoaderAddURL.class.getClassLoader();
        try {
            Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            URL url = new URL(appPath);
            addURL.invoke(urlClassLoader, url);
            Class.forName("com.learn.Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
