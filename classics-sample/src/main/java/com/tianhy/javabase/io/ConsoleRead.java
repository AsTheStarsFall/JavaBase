package com.tianhy.javabase.io;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/2 4:21
 **/
public class ConsoleRead {

    public static void main(String[] args) {
        /**
         * 运行命令：
         * F:\StudyWorkSpaces\JavaBase\classics-sample\src\main\java>java com.tianhy.javabase.io.ConsoleRead
         */
        String name = System.console().readLine("what ?");
        System.out.println("Hello， "+ name.toUpperCase());
    }
}
