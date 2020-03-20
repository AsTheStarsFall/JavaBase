package com.tianhy.javabase.classload;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/9
 **/
public class ClassLoadTest {

    public static void main(String[] args) {

        try {
            ClassLoadDemo test=new ClassLoadDemo();
            ClassLoadDemo.display();
            test.display_1();
            /*ClassLoadDemo test1=new ClassLoadDemo();
            ClassLoadDemo test2=new ClassLoadDemo();*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
