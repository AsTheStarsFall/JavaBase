package com.tianhy.javabase.classload;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/4/2
 **/
public class JavacTest {
    private int a = 0;

    public JavacTest() {

    }

    public int inc(){
        return a+1;
    }

    static {
        System.out.println("static");
    }
}
