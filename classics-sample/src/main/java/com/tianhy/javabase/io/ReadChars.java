package com.tianhy.javabase.io;

import java.io.*;

/**
 * {@link}
 *
 * @Desc: 读取chars
 * @Author: thy
 * @CreateTime: 2020/3/2 5:21
 **/
public class ReadChars {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "checknum.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        int c;
        while ((c = bufferedReader.read()) != -1) {
            System.out.println((char) c);
        }

        bufferedReader.close();
        /**
         * T
         * h
         * i
         * s
         *
         * i
         * s
         *
         * t
         * h
         * e
         *
         * c
         * o
         * n
         * t
         * e
         * x
         * t
         */
    }
}
