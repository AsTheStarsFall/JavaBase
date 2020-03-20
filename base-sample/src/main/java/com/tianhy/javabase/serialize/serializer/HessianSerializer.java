package com.tianhy.javabase.serialize.serializer;

import com.caucho.hessian.io.*;

import java.io.*;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class HessianSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(bos);

        try {
            ho.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        HessianInput hi = new HessianInput(bis);

        try {
            return (T) hi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
