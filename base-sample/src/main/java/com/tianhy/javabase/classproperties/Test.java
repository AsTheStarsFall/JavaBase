package com.tianhy.javabase.classproperties;

import java.lang.reflect.Field;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/4/13
 **/
public class Test {

    public static void main(String[] args) {
        Field[] declaredFields = TestClass.class.getDeclaredFields();

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
}
