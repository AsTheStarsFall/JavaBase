package com.tianhy.javabase.serialize.serializer;

import com.alibaba.fastjson.JSON;

/**
 * {@link}
 *
 * @Desc: fastjson序列化
 * @Author: thy
 * @CreateTime: 2019/6/18
 **/
public class FastJsonSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(new String(data), clazz);
    }
}
