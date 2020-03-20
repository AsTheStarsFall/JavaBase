package com.tianhy.javabase.javaserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link}
 *
 * @Desc: 返回二进制数据
 * @Author: thy
 * @CreateTime: 2020/3/3 0:08
 **/
public class DayTimeServer {
    ServerSocket serverSocket;
    public static final int ECHOPORT = 7;

    public DayTimeServer(int echoport) throws IOException {
        serverSocket = new ServerSocket(echoport);
    }

    public static void main(String[] args) throws IOException {
        new DayTimeServer(ECHOPORT).runService();
    }


    protected void runService() {
        Socket socket = null;
        DataOutputStream os = null;
        while (true) {
            try {
                System.out.println("Waiting for connection ");
                socket = serverSocket.accept();
                System.out.println("Accepted from " + socket.getInetAddress().getHostName());

                os = new DataOutputStream(socket.getOutputStream());

                long time = System.currentTimeMillis();

                time /= RDateClient.MESC;
                time += RDateClient.BASE_DIFF;

                os.writeInt((int) time);
                os.close();

            } catch (IOException e) {

                System.err.println(e);
            }
        }
    }

}
