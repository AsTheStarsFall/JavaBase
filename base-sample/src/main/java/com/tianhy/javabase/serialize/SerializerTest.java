package com.tianhy.javabase.serialize;

import com.tianhy.javabase.serialize.pojo.User;
import com.tianhy.javabase.serialize.serializer.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class SerializerTest {

    public static void main(String[] args) {
//        ISerializer serializer = new XStreamSerializer();
//        ISerializer serializer = new JavaSerializer();
        ISerializer serializer = new FastJsonSerializer();
//        ISerializer serializer = new HessianSerializer();
//        ISerializer serializer = new JavaSerializerWithFile();


        User user = new User();
        user.setName("tianhy");
        user.setAge(18);

        byte[] bytes = serializer.serialize(user);
        System.out.println("bytes length: " + bytes.length);
        System.out.println(new String(bytes));
        /**
         * xstream: 299
         * Java: 113
         * FastJson :26
         * Hessian: 71
         * protobuf : 10
         */

        User user1 = serializer.deSerialize(bytes, User.class);
        System.out.println(user1);

    }
}
