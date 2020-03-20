package com.tianhy.javabase.os.osprop;


import java.io.File;

/**
 * {@link}
 *
 * @Desc: 空装置的机制，用来废弃输出
 * @Author: thy
 * @CreateTime: 2020/2/29 3:57
 **/
public class SysDep {

    //Linux OS下的空装置路径
    final static String UNIX_NULL_DEV = "/dev/null";
    final static String WINDOWS_NULLL_DEV = "NUL:";
    final static String FAKE_NULL_DEV = "jnk";

    public static void main(String[] args) {
        System.out.println(getDevNull());

    }

    public static String getDevNull() {
        if (new File(UNIX_NULL_DEV).exists()) {
            return UNIX_NULL_DEV;
        }
        //获取烯烃属性 os.name 的值
        String sys = System.getProperty("os.name");
        if (sys == null) {
            return FAKE_NULL_DEV;
        }
        if (sys.startsWith("Windows")) {
            return WINDOWS_NULLL_DEV;
        }

        return FAKE_NULL_DEV;
    }
}
