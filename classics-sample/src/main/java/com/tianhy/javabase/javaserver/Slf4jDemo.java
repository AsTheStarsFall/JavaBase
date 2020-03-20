package com.tianhy.javabase.javaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link}
 *
 * @Desc: slf4j
 * @Author: thy
 * @CreateTime: 2020/3/3 4:37
 **/
public class Slf4jDemo {

    static final Logger LOGGER = LoggerFactory.getLogger(Slf4jDemo.class);

    public static void main(String[] args) {
        Object o = new Object();
        LOGGER.info("created a object :" + o);
    }
}
