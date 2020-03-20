package com.tianhy.javabase.javaserver;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * {@link}
 *
 * @Desc: 可使用SSL协议。需要设置一个服务器证书。启动时设置参数
 * @Author: thy
 * @CreateTime: 2020/3/3 4:07
 **/
public class JSSEWebServer extends WebServer {
    public static final int HTTPS = 8443;

    public static void main(String[] args) throws IOException {
/*        if (System.getProperty("javax.net.ssl.keyStore") == null) {
            System.err.println("none ssl");
            System.exit(1);
        }*/
        JSSEWebServer server = new JSSEWebServer();
        server.runServer(HTTPS);
    }

    //使用JSSE得到一个HHTPS服务套接字
    @Override
    protected ServerSocket getServerSocket(int port) throws IOException {
        ServerSocketFactory ssf = SSLServerSocketFactory.getDefault();
        return ssf.createServerSocket(port);
    }
}
