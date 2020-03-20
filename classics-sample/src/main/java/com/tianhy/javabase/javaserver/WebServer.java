package com.tianhy.javabase.javaserver;

import java.io.*;
import java.net.*;

/**
 * {@link}
 *
 * @Desc: 为HTTP协议提供服务
 * @Author: thy
 * @CreateTime: 2020/3/3 3:03
 **/
public class WebServer {
    public static final int HTTP = 80;
    public static final String CRLF = "\r\n";
    ServerSocket serverSocket;
    private static final String URL_STR = "https://github.com/AsTheStarsFall";

    public static void main(String[] args) throws IOException {

        WebServer server = new WebServer();
        server.runServer(HTTP);
    }

    //得到ServerSocket，延迟到构造以后,这样能和ServerSocketFactory混合使用（例如SSL）
    protected ServerSocket getServerSocket(int port) throws IOException {
        return new ServerSocket(port);
    }

    public void runServer(int port) throws IOException {
        serverSocket = getServerSocket(port);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Handler(socket);
            } catch (IOException e) {
                System.err.println(e);
                return;

            }
        }
    }

    private void Handler(Socket socket) {
        //从浏览器
        BufferedReader is;
        //到浏览器
        PrintWriter os;
        String request;

        try {
            String from = socket.getInetAddress().toString();
            System.out.println("Accepted connection from " + from);
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            request = is.readLine();
            System.out.println("Request :" + request);

            os = new PrintWriter(socket.getOutputStream(), true);
            os.print("HTTP/1.0 200 Here is ur data" + CRLF);
            os.print("Content-type:text/html;" + CRLF);
            os.print("Server-name: Psithurism Java WebServer" + CRLF);
            String reply1 = "<html><head>" +
                    "<title>Wrong response</title></head>\n" +
                    "<h1>Welcome,";
            String reply2 = "please view another ststem</h1>\n" +
                    "<p>View : <a href=\"" + URL_STR + "\">" +
                    "</a>.</p>" +
                    "</html>\n";
            os.print("Content-length: " + reply1.length() + from.length() + reply2.length() + CRLF);
            os.print(CRLF);
            os.print(reply1 + from + reply2 + CRLF);
            os.flush();
            socket.close();

        } catch (IOException e) {
            System.err.println(e);
            return;
        }
    }
}
