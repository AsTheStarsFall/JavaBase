package com.tianhy.javabase.javaserver;

import java.io.IOException;
import java.net.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/2 23:14
 **/
public class ListenInside {
    public static final short PORT = 9999;
    //网络接口名称
    public static final String INSIDE_PORT = "acmewidgets-inside";
    //允许排队的客户端的数量
    public static final int BACKLOG = 10;

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        try {

            serverSocket = new ServerSocket(PORT, BACKLOG);
            //主机名
            InetAddress byName = InetAddress.getByName(INSIDE_PORT);
            while ((socket = serverSocket.accept()) != null) {
                process(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(Socket socket) throws IOException {
        System.out.println("Connected from " + INSIDE_PORT + ":" + socket.getInetAddress());

        socket.close();
    }
}
