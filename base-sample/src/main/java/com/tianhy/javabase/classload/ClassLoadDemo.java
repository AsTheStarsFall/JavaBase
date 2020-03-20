package com.tianhy.javabase.classload;

/**
 * @Desc: 类加载顺序
 * @Author: thy
 * @CreateTime: 2019/3/9
 **/
public class ClassLoadDemo {

    public static int X = 100;

    public final static int Y = 200;

    {
        //在创建对象时被调用，优先于类构造函数
        System.out.println("构造代码块");
    }

    //每次实例化都会执行构造函数
    public ClassLoadDemo() {
        System.out.println("每次实例化--构造函数执行");
    }

    //只会执行一次
    static {
        System.out.println("只会执行一次--static语句块执行");

    }

    //在外部直接根据类调用
    public static void display() {
        System.out.println("在外部直接调用--静态方法被执行");
    }

    //在外部需要实例化后才能调用
    public void display_1() {
        System.out.println("在外部，需要实例化之后调用--实例方法被执行");
    }
}
