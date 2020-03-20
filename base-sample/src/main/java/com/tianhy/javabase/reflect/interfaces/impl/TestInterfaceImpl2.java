package com.tianhy.javabase.reflect.interfaces.impl;


import com.tianhy.javabase.reflect.anno.TestAnnotation;
import com.tianhy.javabase.reflect.interfaces.TestInterface;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/31
 **/
@TestAnnotation
public class TestInterfaceImpl2 implements TestInterface {
    @Override
    public void doSomething() {
        System.out.println("do Something2");
    }
}
