package com.tianhy.javabase.javaserver;

import java.net.*;
import java.util.Enumeration;

/**
 * {@link}
 *
 * @Desc: 计算机的网络接口
 * @Author: thy
 * @CreateTime: 2020/3/3 5:24
 **/
public class NetWorkInterfaceDemo {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            //名称
            System.out.println(networkInterface.getDisplayName());
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            //地址
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.println(inetAddress);
            }
        }

        //获得一个给定的本地地址接口
        InetAddress address = InetAddress.getByName("host");
        try {
            NetworkInterface inetAddress = NetworkInterface.getByInetAddress(address);
            System.out.println(inetAddress);
        } catch (SocketException e) {
            System.err.println(e);
        }
    }
}
