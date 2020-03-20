package com.tianhy.javabase.javaserver;

/**
 * {@link}
 *
 * @Desc: 二进制时间
 * @Author: thy
 * @CreateTime: 2020/3/2 23:58
 **/
public class RDateClient {
    public static final short TIME_PORT = 37;
    //1970与1900年间隔秒数
    public static final long BASE_DAYS = (1970 - 1900) * 365 + (1970 - 1900 - 1) / 4;

    //自1970以来的秒数
    public static final long BASE_DIFF = (BASE_DAYS * 24 * 60 * 60);
    //秒转毫秒
    public static final int MESC = 1000;

    public static void main(String[] args) {

    }
}
