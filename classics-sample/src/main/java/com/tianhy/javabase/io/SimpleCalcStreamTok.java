package com.tianhy.javabase.io;

import java.io.*;
import java.util.Stack;

/**
 * {@link}
 *
 * @Desc: 简单计算器
 * @Author: thy
 * @CreateTime: 2020/3/2 5:59
 **/
public class SimpleCalcStreamTok {
    /**
     * StreamTokenizer提供了更多扫描文件的功能。
     * 能读取字符，并组装成单词或标记
     */
    protected StreamTokenizer tf;
    protected PrintWriter out = new PrintWriter(System.out, true);

    protected String variable;

    protected Stack s;

    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + File.separator + "users.txt";

    }

    public SimpleCalcStreamTok(String fileName) {

    }

    public SimpleCalcStreamTok(Reader r) {
        tf = new StreamTokenizer(r);
        //控制字符集
        tf.slashSlashComments(true);
        tf.ordinaryChar('-');
    }
}
