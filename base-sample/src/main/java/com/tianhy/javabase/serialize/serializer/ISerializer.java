package com.tianhy.javabase.serialize.serializer;


/**
 * {@link}
 *
 * @Desc: 序列化接口
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public interface ISerializer {

    //序列化
    <T> byte[] serialize(T obj);

    //反序列化
    <T> T deSerialize(byte[] data, Class<T> clazz);
}
