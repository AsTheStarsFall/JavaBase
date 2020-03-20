package com.tianhy.javabase.Binary;


/**
 * @Author: thy
 * @Date: 2020/2/20 0:50
 * @Desc:
 */
public class BinaryTest {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(24));
        System.out.println(Integer.valueOf("111000", 2).toString());
        System.out.println(2 * 2 * 2 * 2 * 2 + 2 * 2 * 2 * 2 + 2 * 2 * 2);

        System.out.println(56<<1);
        System.out.println(56>>1);
    }

}
