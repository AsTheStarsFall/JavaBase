package com.tianhy.javabase.javaserver;


import org.apache.log4j.Logger;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/3 4:36
 **/
public class Log4jDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jDemo.class);

//        PropertyConfigurator.configure("log4j.properties");
        Object o = new Object();
        logger.info("created a object :" + o);
    }

}
