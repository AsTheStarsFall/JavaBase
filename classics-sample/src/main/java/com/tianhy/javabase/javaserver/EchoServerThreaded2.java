package com.tianhy.javabase.javaserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc: 处理多客户端2
 * @Author: thy
 * @CreateTime: 2020/3/3 2:51
 **/
public class EchoServerThreaded2 {
    public static final int ECHOPORT = 7;
    public static final int NUM_THREADS = 4;


    public static void main(String[] args) {

    }

    public EchoServerThreaded2(int port, int threads) {

        //创建一定数量的线程来启动
        for (int i = 0; i < threads; i++) {

        }
    }

    class handler extends Thread {

        ServerSocket serverSocket;
        int threadNums;

        handler(ServerSocket serverSocket, int i) {
            this.serverSocket = serverSocket;
            this.threadNums = i;
        }

        @Override
        public void run() {
            //等待连接，调用accept时，在服务器套接字上同步
            while (true) {

                try {
                    System.out.println("Waiting...");
                    Socket socket;

                    //等待下一次连接
                    synchronized (serverSocket) {
                        socket = serverSocket.accept();
                    }
                    System.out.println(getName() + "starting, ip = " + socket.getInetAddress());

                    BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintStream os = new PrintStream(socket.getOutputStream());

                    String line;
                    while ((line = is.readLine()) != null) {
                        os.print(line + "\r\n");
                        os.flush();
                    }
                    System.out.println(getName() + "ended.");
                    socket.close();
                } catch (IOException e) {

                    return;
                }
            }
        }
    }
}
