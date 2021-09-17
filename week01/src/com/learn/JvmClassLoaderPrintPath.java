package com.learn;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Class: JvmClassLoaderPrintPath
 * @Description:
 * @Author: Jerry Qu
 * @Create: 2021-09-14 14:39:29
 */
public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL urL : urLs) {
            System.out.println(" ===> " + urL.toExternalForm());
        }

        //扩展类加载器
        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        //应用类加载器
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader classLoader) {
        System.out.println(classLoader.toString());
    }
}
