package com.tianhy.javabase.serialize.serializer;

import java.io.*;

/**
 * {@link}
 *
 * @Desc: Java原生序列化（文件）
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class JavaSerializerWithFile implements ISerializer {

    @Override
    public <T> byte[] serialize(T obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("user")));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user")));
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
