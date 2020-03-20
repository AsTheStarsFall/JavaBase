package com.tianhy.javabase.classdefine;

/**
 * @Author: thy
 * @Date: 2020/2/20 15:24
 * @Desc:
 */
public class OuterClassChild extends OuterClass {

    //子类的构造方法隐含调用super()，如果父类没有提供默认的构造方法，会报错
    public OuterClassChild(String name) {
        super(name);
    }

}
