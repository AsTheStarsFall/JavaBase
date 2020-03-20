package com.tianhy.javabase.keyword;

/**
 * @Desc: this
 * @Author: thy
 * @CreateTime: 2019/3/23
 **/
public class ThisKeyWord {

    private String name;
    public ThisKeyWord(String name) {
        //引用成员变量
        this.name = name;
    }
    public ThisKeyWord() {
        //调用类的构造方法
        this(" Hello World!");
    }

    /**
     * 静态方法是存放在内存中的数据段里，this和super调用的是堆空间里的应用对象,
     * 不能调用数据段区域里的数据，因此静态方法中不能用this和super关键字
     */



}
