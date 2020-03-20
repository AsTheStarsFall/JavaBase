package com.tianhy.javabase.javaserver;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc: 处理多客户端
 * @Author: thy
 * @CreateTime: 2020/3/3 0:31
 **/
public class EchoServerThreaded {
    public static final int ECHOPORT = 7;

    public static void main(String[] args) {

        new EchoServerThreaded().runServer();
    }

    public void runServer() {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(ECHOPORT);
            System.out.println("Server ready for connections.");

            //等待一个连接
            while (true) {
                //accept方法是不同步的，所以如果线程并发访问的话，可能会出现意想不到的事情
                //如果没有客户端连接，accept会有一个随机线程，用于等待连接
                socket = serverSocket.accept();
                //创建一个通信线程，并且启动
                new Handler(socket).start();
            }
        } catch (IOException e) {

        }
    }

    //客户端通信子线程
    class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Socket starting");
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream os = new PrintStream(socket.getOutputStream());
                String line;
                while ((line = is.readLine()) != null) {
                    os.print(line + "\r\n");
                    os.flush();
                }
                socket.close();
            } catch (IOException e) {
                return;
            }
            System.out.println("Socket ended :" + socket);

        }
    }
}
