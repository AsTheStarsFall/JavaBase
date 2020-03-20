package com.tianhy.javabase.os.prop;


import java.io.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/4 2:10
 **/
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        PropertiesDemo p = new PropertiesDemo();

        String resource = p.getClass().getResource("/httpd.properties").getPath();
        System.out.println(resource);
        /**
         * /F:/StudyWorkSpaces/JavaBase/classics-sample/target/classes/httpd.properties
         */


    }
}
