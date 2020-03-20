package com.tianhy.javabase.serialize.serializer;


import com.google.protobuf.InvalidProtocolBufferException;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class ProtobufSerializer {


    public static void main(String[] args) {
        UserProto.User user = UserProto.User.newBuilder()
                .setName("tianhy").setAge(18).build();

        byte[] bytes = user.toByteArray();
        System.out.println(bytes.length);
        for (byte aByte : bytes) {
            System.out.print(aByte + " ");
        }

        UserProto.User user1 = null;
        try {
            user1 = user.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(user1);

    }
}
