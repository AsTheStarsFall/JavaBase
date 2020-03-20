package com.tianhy.javabase;

/**
 * @Author: thy
 * @Date: 2020/2/8 18:59
 * @Desc:
 */
public class LogicSymble {

    public static void main(String[] args) {
        boolean cuo = false;
        boolean dui = true;

/*        System.out.println(cuo || dui); //true

        System.out.println(dui || cuo);//true*/
        System.out.println(cuo || cuo); //false
        System.out.println(dui || dui); //true

/*        System.out.println(dui && dui); // true

        System.out.println(cuo && cuo); // false

        System.out.println(dui && cuo);//false

        System.out.println(cuo && dui);//false*/

    }
}
