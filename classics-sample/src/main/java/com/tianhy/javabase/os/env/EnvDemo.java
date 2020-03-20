package com.tianhy.javabase.os.env;

import java.util.Map;
import java.util.Set;

/**
 * {@link}
 *
 * @Desc: 在Java程序中获取环境变量的值
 * @Author: thy
 * @CreateTime: 2020/2/29 3:40
 **/
public class EnvDemo {

    public static void main(String[] args) {


    }

    //获取环境变量的值
    public void getEnv() {
        //获取环境变量
        Map<String, String> getenv = System.getenv();
        Set<Map.Entry<String, String>> entries = getenv.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
    }

    public void getSyspro(){

    }

}
