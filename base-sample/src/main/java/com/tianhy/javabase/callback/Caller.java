package com.tianhy.javabase.callback;

/**
 * @Author: thy
 * @Date: 2020/2/6 18:19
 * @Desc: 回调函数调用者
 */
public class Caller {

    private MyCallback callback;

    public void doCall() {
        callback.func();
    }

    public void setCallback(MyCallback callback) {
        this.callback = callback;
    }
}
