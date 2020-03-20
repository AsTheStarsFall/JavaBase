package com.tianhy.javabase.reflect;

import com.tianhy.javabase.reflect.interfaces.impl.TestInterfaceImpl;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/31
 **/
public class AnnoTest {

    public static void main(String[] args) {
            Class<?> claz = TestInterfaceImpl.class;
            for (Class<?> clazz :claz.getInterfaces()){
                System.out.println(clazz.getName());
            }
    }
}
