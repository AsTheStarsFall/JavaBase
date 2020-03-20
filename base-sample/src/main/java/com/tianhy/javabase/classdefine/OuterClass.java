package com.tianhy.javabase.classdefine;

/**
 * @Author: thy
 * @Date: 2020/2/20 2:26
 * @Desc: 内部类
 */
public class OuterClass {

    private String name;
    private Integer id;

    public OuterClass(String name) {
        this.name = name;
    }

    public OuterClass(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    //默认构造方法
/*    public OuterClass() {
    }*/

    private class InnerClass {
        //成员内部类

    }

    static class StaticInnerClass {
        //静态内部类
    }

    public static void main(String[] args) {
        //匿名内部类
        (new Thread() {

        }).start();

        //方法内部类
        class MethodClass {

        }
    }
}
