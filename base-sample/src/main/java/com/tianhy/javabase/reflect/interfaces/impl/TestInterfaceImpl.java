package com.tianhy.javabase.reflect.interfaces.impl;


import com.tianhy.javabase.reflect.anno.TestAnnotation;
import com.tianhy.javabase.reflect.interfaces.TestInterface;
import com.tianhy.javabase.reflect.interfaces.TestInterface1;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/31
 **/
@TestAnnotation
public class TestInterfaceImpl implements TestInterface, TestInterface1 {
    @Override
    public void doSomething() {
        System.out.println("do Something");
    }
}
