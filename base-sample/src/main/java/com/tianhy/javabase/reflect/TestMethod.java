package com.tianhy.javabase.reflect;

import com.tianhy.javabase.reflect.interfaces.TestInterface;
import com.tianhy.javabase.reflect.interfaces.TestInterface1;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/20
 **/
public class TestMethod {
    private TestInterface testInterface;


    private TestInterface1 testInterface1;

    public TestMethod() {
        System.out.println("构造函数");
    }

    public static void method(){
        System.out.println("method");
    }
    public static void method(String str){
        System.out.println(str);
    }
}
