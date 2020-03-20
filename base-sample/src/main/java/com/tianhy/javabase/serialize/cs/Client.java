package com.tianhy.javabase.serialize.cs;

import com.tianhy.javabase.serialize.pojo.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class Client {
    private static final int DEFAULT_PORT = 8888;
    private static final String SERVER_IP = "127.0.0.1";

    public static void send(Object obj) {
        send(DEFAULT_PORT, obj);
    }

    private static void send(int defaultPort, Object obj) {
        Socket socket = null;
        ObjectOutputStream oos = null;
        User user = null;

        try {
            socket = new Socket(SERVER_IP, defaultPort);
            oos = new ObjectOutputStream(socket.getOutputStream());
            user = new User();
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("tianhy");
        user.setAge(18);
        Client.send(user);
    }

}
