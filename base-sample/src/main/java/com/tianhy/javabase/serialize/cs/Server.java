package com.tianhy.javabase.serialize.cs;

import com.tianhy.javabase.serialize.pojo.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class Server {
    private static final int PORT = 8888;
    protected static ServerSocket serverSocket;

    public static void start() {
        start(PORT);
    }

    private static void start(int port) {
        if (serverSocket != null) return;
        Socket socket = null;
        ObjectInputStream ois = null;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            ois = new ObjectInputStream(socket.getInputStream());
            //反序列化
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Server.start();
    }

}
