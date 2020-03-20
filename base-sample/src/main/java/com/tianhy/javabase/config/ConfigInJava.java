package com.tianhy.javabase.config;

import java.io.File;

/**
 * @Author: thy
 * @Date: 2020/2/14 0:32
 * @Desc:
 */
public class ConfigInJava {
    public static void main(String[] args) {
/*        print(System.getProperty("user.home"));
        print(System.getProperty("user.dir"));
        print(System.getenv());*/
        /*print(System.getProperty("user.name"));
        print(System.getProperty("user.age", "27"));
        print(Integer.getInteger("user.age"));
        print(Boolean.getBoolean("user.male"));
*/

        path();
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    public static void path() {
        String currPath = System.getProperty("user.dir");
        String path = File.separator + "uploadFile" + File.separator + "123";
        System.out.println(currPath + path);

    }
}
