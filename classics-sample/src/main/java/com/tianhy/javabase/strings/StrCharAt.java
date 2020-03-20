package com.tianhy.javabase.strings;

/**
 * {@link}
 *
 * @Desc: 处理字符串中的单个字符串
 * @Author: thy
 * @CreateTime: 2020/3/2 1:53
 **/
public class StrCharAt {

    public static void strCharAt() {
        String str = "May tries to be june";
        for (int i = 0; i < str.length(); i++) {
            System.out.println("Char " + i + "is " + str.charAt(i));
        }

        //或者
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
    }
}
