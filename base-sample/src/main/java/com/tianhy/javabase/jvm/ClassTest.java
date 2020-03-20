package com.tianhy.javabase.jvm;

import java.lang.reflect.Field;

/**
 * @Author: thy
 * @Date: 2020/2/28 2:54
 * @Desc:
 */
public class ClassTest {

    private static final int[] array = new int[3];
    private static final int length = array.length;


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        //.class获取大写Class类对象
        Class<One> one = One.class;
        Class<Another> another = Another.class;

        //newInstance获取类对象
        One oneInstance = one.newInstance();
        oneInstance.call();
        Another anotherInstance = another.newInstance();

        //获取私有成员属性对象Field
        Field inner = oneInstance.getClass().getDeclaredField("inner");
        //设置私有对象可以访问和修改
        inner.setAccessible(true);

        inner.set(oneInstance, "world changed");
        System.out.println(oneInstance.getInner());
    }

    class One {

        private String inner = "inner filed";

        public One() {
        }

        public String getInner() {
            return inner;
        }

        public void call() {
            System.out.println("call");
        }
    }

    class Another {

    }


}
