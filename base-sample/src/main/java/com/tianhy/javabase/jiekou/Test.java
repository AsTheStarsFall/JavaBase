package com.tianhy.javabase.jiekou;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/4/12
 **/
public class Test {

    public static void main(String[] args) {
        boolean success = false;
        Template template = new Template();
        success = template.doSome(new Demo<Boolean>() {
            @Override
            public Boolean doSomething(Func func) {
                return func.func1() >1 ;
            }
        });
    }
}
