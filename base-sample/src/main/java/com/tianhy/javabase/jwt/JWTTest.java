package com.tianhy.javabase.jwt;


/**
 * @Author: thy
 * @Date: 2020/2/26 4:54
 * @Desc:
 */
public class JWTTest {

    public static void main(String[] args) {
        String str ="abc,def,hij";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(new String(split[i]));
        }
    }


}
