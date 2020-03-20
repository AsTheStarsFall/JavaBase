package com.tianhy.javabase.io;

import java.io.*;

/**
 * {@link}
 *
 * @Desc: InputStreamReader 将stream类转换为Readers类
 * @Author: thy
 * @CreateTime: 2020/3/2 4:04
 **/
public class InputStreamReaderDemo {


    //读取文件内内容
    public static void readFileContext() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "checknum.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();

        String s = bufferedReader.readLine();
        while (s != null) {
            sb.append(s);
            sb.append("\n");
            s = bufferedReader.readLine();
        }
        System.out.println(sb);

        bufferedReader.close();
        is.close();
    }

    public static void inputStreamReader() {
        try {
            //将输入流转为Readers类，通过readLine()将字符输出
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                System.out.println(inputString);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //读取整数
    public static void readInt() {
        String line = null;
        int val = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //读取内容
            line = bufferedReader.readLine();
            //转int
            val = Integer.parseInt(line);
            System.out.println("Read the number：" + val);

        } catch (IOException e) {
            System.err.println(e);
        } catch (NumberFormatException n) {
            System.err.println("Not a number");
        }

    }

    public static void main(String[] args) throws IOException {

//        readInt();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        input = bufferedReader.readLine();

        System.out.println(input);

        bufferedReader.close();
    }

}
