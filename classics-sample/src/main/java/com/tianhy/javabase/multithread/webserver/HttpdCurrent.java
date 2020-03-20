package com.tianhy.javabase.multithread.webserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/4 5:45
 **/
public class HttpdCurrent extends Httpd {
    private final Executor executor;

    public HttpdCurrent(Executor executor) {
        //super 执行父类的构造方法
        super();
        this.executor = Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) {

    }

    //重写父类的方法
    @Override
    void runServer() throws IOException {
        while (true) {
            final Socket socket = serverSocket.accept();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    new Handler(HttpdCurrent.this).process(socket);
                }
            });

        }
    }
}
