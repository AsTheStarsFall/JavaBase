package com.tianhy.javabase.multithread.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * {@link}
 *
 * @Desc: a simple webserver
 * @Author: thy
 * @CreateTime: 2020/3/4 1:40
 **/
public class Httpd {
    public static final int HTTP = 80;
    protected ServerSocket serverSocket;
    //用于加载配置信息
    private Properties http;
    //用于加载mimetype信息
    private Properties mimeType;
    //root dir
    private String rootDir;

    public Httpd() {
        this.http = new Properties();
        this.mimeType = new Properties();
        try {
            http.load(this.getClass().getClassLoader().getResourceAsStream("httpd.properties"));
            mimeType.load(this.getClass().getClassLoader().getResourceAsStream("mime.properties"));
        } catch (IOException e) {
            System.err.println("Properties load fail");
        }
        this.rootDir = http.getProperty("rootDir", "/");
    }

    public static void main(String[] args) throws IOException {
        Httpd httpd = new Httpd();
        httpd.startServer(HTTP);
        httpd.runServer();
    }

    void runServer() throws IOException {
        while (true) {
            try {
                //接收客户端连接
                final Socket socket = serverSocket.accept();
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        new Handler(Httpd.this).process(socket);
                    }
                };
                t.start();
            } catch (IOException e) {
                System.err.println("Socket error");
                return;
            }
        }
    }

    public void startServer(int portNum) throws IOException {
        String portNumStr = null;
        if (portNum == HTTP) {
            portNumStr = http.getProperty("portNum");
            if (portNumStr != null) {
                portNum = Integer.parseInt(portNumStr);
            }
        }
        serverSocket = new ServerSocket(portNum);
        System.out.println("Server listening on port :" + portNum);

    }

    public String getMimeType(String type) {
        return mimeType.getProperty(type);
    }

    public String getMimeType(String type, String dflt) {
        return mimeType.getProperty(type, dflt);
    }

    public String getServerProperty(String name) {
        return http.getProperty(name);
    }

    public String getRootDir() {
        return rootDir;
    }


}
