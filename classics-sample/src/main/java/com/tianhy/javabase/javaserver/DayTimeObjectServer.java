package com.tianhy.javabase.javaserver;

import sun.awt.image.ShortInterleavedRaster;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * {@link}
 *
 * @Desc: 返回对象
 * @Author: thy
 * @CreateTime: 2020/3/3 0:20
 **/
public class DayTimeObjectServer {
    public static final int ECHOPORT = 7;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {

            serverSocket = new ServerSocket(ECHOPORT);
            while ((socket = serverSocket.accept()) != null) {
                System.out.println("Accept from " + socket.getInetAddress().getHostName());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                //构造对象并且返回
                out.writeObject(new Date());

                out.close();
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
