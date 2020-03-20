package com.tianhy.javabase.keyword;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/4/1
 **/
public class StaticDemo {
    /**
     * public private 是访问权限修饰符
     * static修饰的变量被所有对象共享，在内存中只有一个副本
     */

     static String name;

    /**静态方法内不能调用非静态方法，在外部直接可以通过类名来调用静态方法*/
    public static void method(){
        t1();
    }

    public static void t1(){

    }

    public static void main(String[] args) {
        StaticDemo.name = "";
    }
    public void t(){

    }
}
