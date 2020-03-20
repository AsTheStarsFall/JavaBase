package com.tianhy.javabase.javaserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc: 向客户端发送字符串
 * @Author: thy
 * @CreateTime: 2020/3/2 23:19
 **/
public class EchoServer {
    protected ServerSocket serverSocket;
    public static final int ECHOPORT = 7;
    //控制调试标志
    protected boolean debug = true;

    public static void main(String[] args) {

        new EchoServer(ECHOPORT).handler();

    }

    public EchoServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("I/O error");
            System.exit(1);
        }
    }

    protected void handler() {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        while (true) {

            try {
                System.out.println("Waiting for client");
                socket = serverSocket.accept();
                System.out.println("Accepted from " + socket.getInetAddress().getHostName());

                //输入流
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "8859_1"));
                //输出流
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "8859_1"), true);

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Read " + line);
                    out.println(line + "\r\n");
                    out.flush();
                    System.out.println("Wrote " + line);
                }
                System.out.println("All Done.");
            } catch (IOException e) {
                System.err.println(e);

            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    System.err.println("I/O error");

                }
            }

        }
    }
}
