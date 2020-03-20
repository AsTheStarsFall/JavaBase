package com.tianhy.javabase.webclient;

import java.io.*;
import java.net.*;

/**
 * {@link}
 *
 * @Desc: 轻量级客户端
 * @Author: thy
 * @CreateTime: 2020/3/2 9:09
 **/
public class RestClient {
    public static void main(String[] args) throws IOException {
        URLConnection conn = new URL("http://freegeoip.net/json/www.baidu.com").openConnection();
        try (BufferedReader b = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;

            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
