package com.tianhy.javabase.jiekou;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/4/12
 **/
public class Template {


    public<T> T doSome(Demo demo){
        return (T) doAnyThing();
    }

    public static String doAnyThing(){
       return "11";
    }
}
