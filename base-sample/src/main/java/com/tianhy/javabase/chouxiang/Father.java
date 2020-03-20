package com.tianhy.javabase.chouxiang;

/**
 * @Desc: 抽象类
 * @Author: thy
 * @CreateTime: 2019/3/22
 **/
public abstract class Father {

    private String name;

    public Father(String name) {
        this.name = name;
    }

    /**
     * 1、抽象类不一定有抽象方法
     * 2、有抽象方法，类必须为抽象
     * 3、继承抽象类的子类，必须实现覆盖实现父类的抽象方法
     * 4、有构造函数时，子类会通过super()调用父类的构造函数
     */

    public abstract void method();

    protected void method1(){
        System.out.println("method1");
    }
    private void method2(){
        System.out.println("method2");

    }

    public static void method4(){
        System.out.println("method4");
    }


}
