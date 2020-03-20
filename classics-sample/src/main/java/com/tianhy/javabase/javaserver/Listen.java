package com.tianhy.javabase.javaserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/2 23:05
 **/
public class Listen {

    public static final short port = 9999;

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(9999);
            //accept返回的socket对象，它将双向连接到客户端的Socket对象（或者其它等价物，如果其他语言编写）
            while ((clientSocket = serverSocket.accept()) != null) {

                process(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket clientSocket) throws IOException {
        System.out.println("Accept from client :" + clientSocket.getInetAddress());
        clientSocket.close();
    }
}
