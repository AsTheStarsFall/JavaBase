package com.tianhy.javabase.strings;

/**
 * {@link}
 *
 * @Desc: 字符串左右对齐或者居中
 * @Author: thy
 * @CreateTime: 2020/3/4 5:57
 **/
public class StringAlignDemo {
    public static void main(String[] args) {
        StringAlign formatter = new StringAlign(70,StringAlign.Justify.CENTER);
        System.out.println(formatter.format("- i -"));
        System.out.println(formatter.format(Integer.toString(4)));
    }
}
