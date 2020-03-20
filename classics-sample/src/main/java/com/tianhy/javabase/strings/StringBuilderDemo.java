package com.tianhy.javabase.strings;

/**
 * {@link}
 *
 * @Desc: 字符串拼接
 * @Author: thy
 * @CreateTime: 2020/3/2 1:08
 **/
public class StringBuilderDemo {
    public static void main(String[] args) {
        String s1 = "Hello" + ",  " + "World";
        System.out.println(s1);

        //构建StringBuilder对象，添加字符串
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hello");
        sb2.append(", ");
        sb2.append(" ");
        sb2.append("World");

        //将StringBuilder的值转为String类型
        String s2 = sb2.toString();
        System.out.println(s2);


        System.out.println(
                new StringBuilder()
                        .append("Hello")
                        .append(", ")
                        .append(" ")
                        .append("World")
        );

    }
}
