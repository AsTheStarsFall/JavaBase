package com.tianhy.javabase.config;


import org.apache.commons.configuration.SystemConfiguration;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: thy
 * @Date: 2020/2/14 1:03
 * @Desc:
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        SystemConfiguration systemConfiguration = new SystemConfiguration();
        systemConfiguration.setProperty("name","thy");

        System.out.println(systemConfiguration.getInt("user.age"));
//        pro2xml();
    }

    private static void pro2xml() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "thy");
        properties.setProperty("age", "27");
        properties.storeToXML(System.out, "注释", "UTF-8");
    }
}
