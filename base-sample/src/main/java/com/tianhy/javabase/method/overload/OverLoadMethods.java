package com.tianhy.javabase.method.overload;

/**
 * @Author: thy
 * @Date: 2020/2/20 23:23
 * @Desc: 重载
 */
public class OverLoadMethods {
    //无参
    public OverLoadMethods() {
        System.out.println("无参构造");
    }

    //基本数据类型
    public OverLoadMethods(int param) {
        System.out.println("基本数据类型");
    }

    //包装数据类型
    public OverLoadMethods(Integer param) {
        System.out.println("包装数据类型");
    }

    //可变参数
    public OverLoadMethods(Integer... param) {
        System.out.println("可变参数");
    }

    //Object对象
    public OverLoadMethods(Object param) {
        System.out.println("Object");

    }
}
