package com.tianhy.javabase.strings;


import java.io.*;

/**
 * {@link}
 *
 * @Desc: 校验和
 * @Author: thy
 * @CreateTime: 2020/3/2 2:00
 **/
public class CheckSum {


    public static void main(String[] args) throws IOException {


    }


    //校验和。如果将校验和与文件内容分开传输，接收方可以对文件校验并确认收到的文件完整无误
    public static int checkSum() throws IOException {
        InputStream is = new FileInputStream(System.getProperty("user.dir") + File.separator + "checknum.txt");
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new InputStreamReader(is));
        int sum = 0;
        try {
            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                for (int i = 0; i < inputString.length(); i++) {
                    sum += inputString.charAt(i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        is.close();
        bufferedReader.close();
        System.out.println(sum);
        return sum;

    }


}
