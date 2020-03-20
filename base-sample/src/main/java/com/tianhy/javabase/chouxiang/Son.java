package com.tianhy.javabase.chouxiang;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/22
 **/
public class Son extends Father {

    public Son() {
        super("");
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.method1();
        Father.method4();
    }

    @Override
    public void method() {
        System.out.println("method");
    }


    @Override
    protected void method1() {
        System.out.println("6132315");
    }




}
