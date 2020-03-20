package com.tianhy.javabase.method;

/**
 * @Author: thy
 * @Date: 2020/2/20 17:16
 * @Desc: 参数传递
 */
public class ParamPassing {
    public ParamPassing() {
    }

    private static int intSatic = 111;

    private static String stringStatic = "old String";

    private static StringBuilder stringBuilder = new StringBuilder("old StringBuilder");

    public static void main(String[] args) throws InterruptedException {
        //实参调用
        method(intSatic);
        method(stringStatic);
        method(stringBuilder, stringBuilder);

        System.out.println(intSatic);
        method();
        System.out.println(intSatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilder);
        while (true) {
        }

    }

    //A method
    public static void method(int intSatic) {
        intSatic = 777;
    }

    //B method
    public static void method() {
        intSatic = 888;
    }

    //c method
    public static void method(String stringStatic) {
        //String is immutable
        stringStatic = "new String";
    }

    //d method
    public static void method(StringBuilder stringBuilder1, StringBuilder stringBuilder2) {
        //使用参数引用修改对象
        stringBuilder1.append(".method.first-");
        stringBuilder2.append("method.second-");
        //引用重新赋值
        stringBuilder1 = new StringBuilder("new StringBuilder");
        stringBuilder1.append("new method's append");
    }
}
