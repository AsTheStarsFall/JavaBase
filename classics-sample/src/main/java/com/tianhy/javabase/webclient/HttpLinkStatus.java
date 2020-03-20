package com.tianhy.javabase.webclient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * {@link}
 *
 * @Desc: Http链接检查
 * @Author: thy
 * @CreateTime: 2020/3/2 6:36
 **/
public class HttpLinkStatus {

    public static void main(String[] args) {
        String urlString = "https://www.baidu.com";
        URL url;
        HttpURLConnection conn = null;
        HttpURLConnection.setFollowRedirects(false);
        try {
            url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            switch (conn.getResponseCode()) {
                case 200:
                    System.out.println("200");
                    break;
                case 403:
                    System.out.println("403");
                    break;
                case 404:
                    System.out.println("404");
                    break;
            }
            InputStream inputStream = conn.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String context;

            while ((context = bufferedReader.readLine()) != null) {
                System.out.println(context);
            }
            bufferedReader.close();

        } catch (Exception e) {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }


}
