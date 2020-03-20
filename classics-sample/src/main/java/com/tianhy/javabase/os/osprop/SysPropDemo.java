package com.tianhy.javabase.os.osprop;

/**
 * {@link}
 *
 * @Desc:  需要编写基于操作系统的代码
 *
 * 如果要在Java中生成文件名，就需要知道选择 / 还是 \
 * 第一种办法：当允许文件在UNIX和Microsoft系统之间移动时，使用\ /的一种：
 * 当编译的字符串用于Windows上时，要用双\\
 * 第二种办法：判断所运行的操作系统
 * <p>
 * UNIX 的路径： PATH=/bin:/usr/bin
 * DOS 的路径：PATH=C:\windows;\D:\mybin
 * </p>
 * @Author: thy
 * @CreateTime: 2020/2/29 4:39
 **/
public class SysPropDemo {
    public static void main(String[] args) {
        //所有系统属性，在不同的操作系统上运行会得到更多的信息
        //可以据此判断所运行的操作系统
        if (args.length == 0) {
            System.getProperties().list(System.out);
        } else {
            for (String arg : args) {
                System.out.println(arg + "=" + System.getProperty(arg));
            }
        }
    }
}
