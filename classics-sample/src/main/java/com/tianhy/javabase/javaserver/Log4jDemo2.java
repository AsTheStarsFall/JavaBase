package com.tianhy.javabase.javaserver;

import org.apache.log4j.Logger;

/**
 * {@link}
 *
 * @Desc: 捕获异常并记录
 * @Author: thy
 * @CreateTime: 2020/3/3 5:15
 **/
public class Log4jDemo2 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Log4jDemo.class);
        try {
            Object o = new Object();
            logger.debug("created a object :" + o);
            if (o != null) {
                throw new IllegalArgumentException("Just test");
            }
        } catch (Exception e) {
            logger.error("Caught Exception :" + e, e);
        }
    }

}
