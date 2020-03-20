package com.tianhy.javabase.callback;

/**
 * @Author: thy
 * @Date: 2020/2/6 18:21
 * @Desc: 回调函数测试
 */
public class CallbackTest {

    public static void main(String[] args) {
        Caller caller = new Caller();

        caller.setCallback(() -> System.out.println("回调"));

        caller.doCall();
    }

}
